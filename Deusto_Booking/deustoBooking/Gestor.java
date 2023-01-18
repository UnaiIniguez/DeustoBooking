package deustoBooking;

import java.io.IOException;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import controlBD.GestorBD;
import utilidades.Cifrar;

public class Gestor {

	private static final Logger LOGGER = Logger.getLogger(Gestor.class.getName());

	private Set<Duenio> propietarios = new HashSet<>();

	private Set<Huesped> huespedes = new HashSet<>(); // Guardará a todos los huespedes de la base de datos

	private Set<Inmueble> inmuebles = new TreeSet<>(); // Las viviendas que hay en la pagina web

	private Map<String, ArrayList<Reserva>> reservas = new HashMap<>(); // En este mapa se almacenaran todas las
																		// reservas. La clave será el DNI del huesped
																		// que ha hecho esas reservas.

	private static Connection conectar;

	private GestorBD gestorBD = new GestorBD(this);

	public Gestor() {

		gestorBD.inicializarBD();
		gestorBD.leerBaseDeDatos();

		FileHandler fileHandler;
		try {
			fileHandler = new FileHandler("log.txt", false);
			LOGGER.addHandler(fileHandler);
		} catch (SecurityException | IOException e) {

			e.printStackTrace();
		}

	}

	public Set<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(Set<Duenio> duenios) {
		propietarios = duenios;
	}

	public Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(Set<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public Set<Huesped> getHuespedes() {
		return huespedes;
	}

	public Map<String, ArrayList<Reserva>> getReservas() {
		return reservas;
	}

//********************METODOS DEL DUENIO********************************

	/**
	 * 
	 * Este metodo busca si un duenio esta en la memoria o no
	 * 
	 * 
	 * @param DNI         = El dni que se desea buscar
	 * @param Contrasenya = La clave del duenio
	 *
	 */
	public boolean buscarDuenio(String dni, String contrasenya) {
		ArrayList<Duenio> duenios = new ArrayList<>(getPropietarios());
		for (Duenio d : duenios) {
//			String c = Cifrar.cifrar(contrasenya);
			if (d.getDni().equalsIgnoreCase(dni) && d.getContrasenya().equals(contrasenya)) {
				return true;
			}

		}
		return false;

	}

	/**
	 * 
	 * Anyade un duenio
	 * 
	 * 
	 * @param Duenio = El nuevo duenio que se quiere anyadir.
	 *
	 */
	public boolean anyadirDuenio(Duenio duenio) {

		ArrayList<Duenio> p = new ArrayList<>(propietarios);

		if (p.contains(duenio)) {
			return false;
		} else {
			propietarios.add(duenio);

			Thread d = new Thread(new Runnable() {

				@Override
				public void run() {
					gestorBD.anyadirDuenyoBD(duenio);

				}
			});
			d.start();

			return true;
		}

	}

	public Set<Inmueble> filtrar(TipoVivienda tipo, String ubicacion, Date diaLlegada, Date diaSalida, int huespedes) {

		ArrayList<Inmueble> inmuebles = new ArrayList<>(getInmuebles());
		Collection<ArrayList<Reserva>> listaReservas = getReservas().values();
		Set<Inmueble> seleccionadas = new TreeSet<>();

		for (Inmueble i : inmuebles) {
			if (ubicacion.equalsIgnoreCase(i.getUbicacion()) && i.getOcupado() == 0) {
				if (listaReservas.isEmpty()) {

					seleccionadas.add(i);

				} else {
					for (ArrayList<Reserva> lr : listaReservas) {
						for (Reserva re : lr) {

							String diaL = new SimpleDateFormat("dd-MM-yyyy").format(diaLlegada);
							String redial = new SimpleDateFormat("dd-MM-yyyy").format(re.getFecha_Entrada());
							System.out.println(diaL + "El q metemos");
							System.out.println(redial);
							String diaS = new SimpleDateFormat("dd-MM-yyyy").format(diaSalida);
							String rediaS = new SimpleDateFormat("dd-MM-yyyy").format(re.getFecha_Salida());
							System.out.println(diaS + "el que metemos");
							System.out.println(rediaS);
							if ((!diaL.equals(redial)) && (!diaS.equals(rediaS))) {

								if (i.getMaxHuespedes() >= huespedes && i.getTipo().equals(tipo)) {
									seleccionadas.add(i);
								}
							} else {
								System.out.println("Esa reserva ya esta ");
								seleccionadas.clear();
							}
						}
					}
				}

			}
		}

		return seleccionadas;
	}

	/**
	 * 
	 * Anyade un inmueble a la web
	 * 
	 * 
	 * @param Inmueble = inmueble que quiere anyadir
	 *
	 */
	public void anadirInmueble(Inmueble inmueble) {

		inmuebles.add(inmueble);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				gestorBD.anyadirInmuebleBD(inmueble);

			}
		});
		t.start();

	}

	/**
	 * 
	 * Borra un inmueble de la web
	 * 
	 *
	 * @param Inmueble = inmueble que quiere eliminar
	 *
	 */
	public void eliminarInmueble(Inmueble inmueble) throws InmuebleInexistenteException {
		ArrayList<Inmueble> lista = new ArrayList<>(inmuebles);
		
		System.out.println(lista);

		for (Inmueble i : lista) {
			
			if (i.equals(inmueble)) {
				
				inmuebles.remove(inmueble);
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						gestorBD.eliminarInmuebleBD(inmueble);

					}
				});
				t.start();
				
			} else {
				
				throw new InmuebleInexistenteException("No existe un inmueble con ese ID");
				
			}
		}

	}

	/**
	 * 
	 * Editar el numero de baños que tiene el inmueble
	 * 
	 * @param
	 * @param Inmueble = El inmueble que se desea modificar
	 * @param Baños   = Nuevo numero de baños que tendrá el inmueble
	 *
	 */
	public void editarNumBanInmueble(Inmueble inmueble, int Ban) throws InmuebleInexistenteException {

		ArrayList<Inmueble> inm = new ArrayList<>(inmuebles);
		if (inm.contains(inmueble)) {

			inmueble.setNumBany(Ban);

		} else {
			throw new InmuebleInexistenteException("No existe un inmueble con ese ID");
		}

	}

	/**
	 * 
	 * Editar el numero de habitaciones que tiene el inmueble
	 * 
	 * @param
	 * @param Inmueble    = El inmueble que se desea modificar
	 * @param Habitación = Nuevo numero de habitaciones que va a tener el inmueble
	 *
	 */
	public void editarNumHabInmueble(Inmueble inmueble, int Hab) throws InmuebleInexistenteException {

		ArrayList<Inmueble> inm = new ArrayList<>(inmuebles);

		if (inm.contains(inmueble)) {
			inmueble.setNumHab(Hab);

			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {

					gestorBD.editarNumHabInmuebleBD(inmueble, Hab);
				}
			});
			t.start();
		} else {
			throw new InmuebleInexistenteException("No existe un inmueble con ese ID");
		}

	}

	public void editarOcupacionInmueble(Inmueble inmueble) {

		gestorBD.editarEstadoInmueble(inmueble);

	}

	// ********************METODOS DEL HUESPED********************************

	/**
	 * 
	 * Hace el registro de un huesped
	 * 
	 * @param DNI         = el dni del huesped(Será el usuario a la hora de iniciar
	 *                    sesion)
	 * @param Nombre      = Nombre del huesped
	 * @param Edad        = edad del huesped
	 * @param Gmail       = el gmail del huesped
	 * @param Telefono    = El numero de telefono del huesped
	 * @param El          puesto de trabajo = El puesto de trabajo o cargo que tiene
	 *                    el huesped
	 * @param La          compañia = La compañia en la que trabaja el cliente
	 * @param Contraseña = La contrasenya que quiere tener el huesped.
	 *
	 */
	public void registroHuesped(String dni, String nombre, int edad, String mail, String tlf, String cargo,
			String nomEmpresa, String contrasenya) {

		Huesped h = new Huesped(dni, nombre, edad, mail, tlf, contrasenya, cargo, nomEmpresa);
		ArrayList<Huesped> hs = new ArrayList<>(huespedes);
		if (!hs.contains(h)) {
			huespedes.add(h);
		}
		Thread p = new Thread(new Runnable() {

			@Override
			public void run() {
				gestorBD.anyadirHuespedBD(h);

			}
		});
		p.start();
	}

	/**
	 * 
	 * Reservar
	 * 
	 * @param h       = Huesped que ejecuta la reserva
	 * @param reserva = la reserva que desea realizar
	 *
	 */
	public void reservar(String dni, Reserva reserva) {
		if (reservas.containsKey(dni)) {
			reservas.get(dni).add(reserva);

		} else {
			reservas.put(dni, new ArrayList<Reserva>());
			reservas.get(dni).add(reserva);

		}
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				gestorBD.reservarBD(reserva);

			}
		});
		t.start();
	}

	/**
	 * 
	 * Anular una reserva
	 * 
	 * @param h       = dni del Huesped que desea anular una reserva
	 * @param reserva = la reserva que desea anular
	 *
	 */
	public void anularReserva(String h_dni, Reserva reserva) throws ReservaInexistenteException {
		if (reservas.containsKey(h_dni)) {
			reservas.get(h_dni).remove(reserva);
			Thread r = new Thread(new Runnable() {

				@Override
				public void run() {
					gestorBD.anularReservaBD(reserva);

				}
			});
			r.start();

		} else {

			throw new ReservaInexistenteException("No existe esa reserva");

		}
	}

	/**
	 * 
	 * Cambiar una reserva de fechas
	 * 
	 * @param h             = dni del Huesped que desea cambiar la reserva
	 * @param reserva       = la reserva que desea modificar
	 * @param Fecha_Entrada = Nueva fecha entrada que se quiere añadir
	 * @param Fecha_Salida  = Nueva fecha de salida que se quiere añadir
	 *
	 */
	public void editarFechaReserva(String h, Reserva reserva, Date FechaEntrada, Date FechaSalida)
			throws ReservaInexistenteException {
		if (reservas.containsKey(h)) {
			ArrayList<Reserva> res = reservas.get(h);
			for (Reserva r : res) {
				if (r.equals(reserva)) {
					r.setFecha_Entrada(FechaEntrada);
					r.setFecha_Salida(FechaSalida);

				}
			}
			reservas.remove(h);
			reservas.put(h, res);
			Thread f = new Thread(new Runnable() {

				@Override
				public void run() {
					gestorBD.editarFechaReservaBD(reserva, FechaEntrada, FechaSalida);

				}
			});

			f.start();

		} else {
			throw new ReservaInexistenteException("No existe esa reserva");
		}
	}

	/**
	 * 
	 * Este metodo busca si un Huesped esta en la memoria o no
	 * 
	 * 
	 * @param DNI         = El dni que se desea buscar
	 * @param Contrasenya = La clave del huesped
	 *
	 */
	public boolean buscarHuesped(String dni, String contrasenya) {
		ArrayList<Huesped> huespedes = new ArrayList<>(getHuespedes());
		for (Huesped h : huespedes) {
			// String c = Cifrar.cifrar(contrasenya);

			System.out.println(h);

			if (h.getDni().equalsIgnoreCase(dni) && h.getContrasenya().equals(contrasenya)) {
				return true;
			}

		}
		return false;

	}

	public void datosTest() {

	}

}
