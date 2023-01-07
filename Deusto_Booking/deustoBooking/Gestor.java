package deustoBooking;

import java.sql.Connection;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import controlBD.GestorBD;
import utilidades.Cifrar;

public class Gestor {

	private static Set<Duenio> propietarios = new HashSet<>();

	private static Set<Huesped> huespedes = new HashSet<>(); // Guardará a todos los huespedes de la base de datos

	private static Set<Inmueble> inmuebles = new TreeSet<>(); // Las viviendas que hay en la pagina web

	private Map<String, ArrayList<Reserva>> reservas = new HashMap<>(); // En este mapa se almacenaran todas las
																			// reservas. La clave será el DNI del huesped
																			// que ha hecho esas reservas.
	private static Connection conectar;

	private GestorBD gestorBD;
	private static boolean isChangedP;// MArcador de cambio de Propietario
	private static boolean isChangedI;// Marcador de cambio de Inmueble

	public void datosTest() {

		ArrayList<Inmueble> inmueblesTest = new ArrayList<>();
		Duenio d = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", "Jefe");
		propietarios.add(d);

	}

	public Gestor() {
		gestorBD.conectar();
		isChangedP = false;
		isChangedI = false;
		gestorBD.inicializarBD();

	}

	public static Set<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(Set<Duenio> duenios) {
		propietarios = duenios;
	}

	public static Set<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public static void setInmuebles(Set<Inmueble> inmuebles) {
		Gestor.inmuebles = inmuebles;
	}

	public Map<String, ArrayList<Reserva>> getHuespedes() {
		return reservas;
	}

	public static boolean isChangedP() {
		return isChangedP;
	}

	public static void setChangedP(boolean value) {
		isChangedP = value;
	}

	public static boolean isChangedI() {
		return isChangedI;
	}

	public static void setChangedI(boolean isChangedI) {
		Gestor.isChangedI = isChangedI;
	}

//**************************METODOS COMUNES**********************************************

	public Map<String, ArrayList<Reserva>> getReservas() {
		return reservas;
	}

	public Connection getConectar() {
		return conectar;
	}

	/**
	 * 
	 * Iniciar sesión
	 * 
	 * @param Persona = La persona que desea iniciar sesión.
	 *
	 */
	public boolean iniSesion(String dni, String contrasena) {

		for (Duenio d : propietarios) {
			if (d.getContrasenya() == contrasena && d.getDni() == dni) {
				return true;

			}
		}

		for (Huesped p : huespedes) {
			if (p.getContrasenya() == contrasena && p.getDni() == dni) {
				return true;
			}

		}
		return false;

	}

//********************METODOS DEL DUENIO********************************

	/**
	 * 
	 * Anyade un inmueble a la web
	 * 
	 * 
	 * @param Inmueble = inmueble que quiere anyadir
	 *
	 */
	public void anadirInmueble( Inmueble inmueble) {

		inmuebles.add(inmueble);
		gestorBD.anyadirInmuebleBD(inmueble);
		
	}

	/**
	 * 
	 * Borra un inmueble de la web
	 * 
	 *
	 * @param Inmueble = inmueble que quiere eliminar
	 *
	 */
	public void eliminarInmueble( Inmueble inmueble) {

		inmuebles.remove(inmueble);
		gestorBD.eliminarInmuebleBD(inmueble);

	}

	/**
	 * 
	 * Editar el numero de baños que tiene el inmueble 
	 * 
	 * @param 
	 * @param Inmueble = El inmueble que se desea modificar
	 * @param Baños = Nuevo numero de baños que tendrá el inmueble
	 *
	 */
	public void editarNumBanInmueble(Inmueble inmueble, int Ban) {
		
		ArrayList<Inmueble> inm = new ArrayList<>(inmuebles);
		for(Inmueble i : inm) {
			if(i.getId_Inmueble() == inmueble.getId_Inmueble()) {
				i.setNumBany(Ban);
			}
		}
		gestorBD.editarNumBanInmuebleBD(inmueble, Ban);
	}
	
	/**
	 * 
	 * Editar el numero de habitaciones que tiene el inmueble 
	 * 
	 * @param 
	 * @param Inmueble = El inmueble que se desea modificar
	 * @param Habitación = Nuevo numero de habitaciones que va a tener el inmueble
	 *
	 */
	public void editarNumHabInmueble(Inmueble inmueble, int Hab) {
		
		ArrayList<Inmueble> inm = new ArrayList<>(inmuebles);
		for(Inmueble i : inm) {
			if(i.getId_Inmueble() == inmueble.getId_Inmueble()) {
				i.setNumHab(Hab);
			}
		}
		
		gestorBD.editarNumHabInmuebleBD(inmueble, Hab);
	}
	
	
	

	// ********************METODOS DEL HUESPED********************************
	
	/**
	 * 
	 * Hace el registro de un huesped
	 * 
	 * @param DNI = el dni del huesped(Será el usuario a la hora de iniciar sesion)
	 * @param Nombre = Nombre del huesped
	 * @param Edad = edad del huesped
	 * @param Gmail = el gmail del huesped
	 * @param Telefono = El numero de telefono del huesped
	 * @param El puesto de trabajo = El puesto de trabajo o cargo que tiene el huesped
	 * @param La compañia = La compañia en la que trabaja el cliente
	 * @param Contraseña = La contrasenya que quiere tener el huesped. 
	 *
	 */
	public void registroHuesped(String dni, String nombre, int edad, String mail, String tlf, String cargo,
			String nomEmpresa, String contrasenya) {

		Huesped h = new Huesped(dni, nombre, edad, mail, tlf, contrasenya, cargo, nomEmpresa);

		if (!huespedes.contains(h)) {
			huespedes.add(h);
		}
	}
	/**
	 * 
	 * Reservar
	 * 
	 * @param h = Huesped que ejecuta la reserva
	 * @param reserva = la reserva que desea realizar
	 *
	 */
	public void reservar(Huesped h, Reserva reserva) {
		if (reservas.containsKey(h.getDni())) {
			reservas.get(h.getDni()).add(reserva);
			gestorBD.reservarBD(reserva);
			
		} else {
			reservas.put(h.getDni(), new ArrayList<Reserva>());
			reservas.get(h.getDni()).add(reserva);
			gestorBD.reservarBD(reserva);
		}
		
	}
	
	
	/**
	 * 
	 * Anular una reserva
	 * 
	 * @param h = Huesped que desea anular una reserva
	 * @param reserva = la reserva que desea anular
	 *
	 */
	public void anularReserva(Huesped h , Reserva reserva)throws ReservaInexistenteException {
		if (reservas.containsKey(h.getDni())) {
			reservas.get(h.getDni()).remove(reserva);
			gestorBD.anularReservaBD(reserva);
		} else {
			throw new ReservaInexistenteException("No existe esa reserva");
		}
	}
	
	/**
	 * 
	 * Cambiar una reserva de fechas
	 * 
	 * @param h = Huesped que desea cambiar la reserva
	 * @param reserva = la reserva que desea modificar
	 * @param Fecha_Entrada = Nueva fecha entrada que se quiere añadir
	 * @param Fecha_Salida = Nueva fecha de salida que se quiere añadir
	 *
	 */
	public void editarFechaReserva(Huesped h , Reserva reserva, Date FechaEntrada, Date FechaSalida )throws ReservaInexistenteException {
		if (reservas.containsKey(h.getDni())) {
			ArrayList<Reserva> res = reservas.get(h.getDni());
			for(Reserva r : res) {
				if(r.equals(reserva)) {
					r.setFecha_Entrada(FechaEntrada);
					r.setFecha_Salida(FechaSalida);		
					
				}
			}
			reservas.remove(h.getDni());
			reservas.put(h.getDni(), res);
			gestorBD.editarFechaReservaBD( reserva, FechaEntrada, FechaSalida);
		} else {
			throw new ReservaInexistenteException("No existe esa reserva");
		}
	}
	
	
	public boolean iniciarSesionDB(String dni, String contrasenya) {

		Connection conn = null;
		{
			try {

				contrasenya = Cifrar.cifrar(contrasenya);
				
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:db/Deusto_Booking.db");
				System.out.println("Abre la DB");

				Statement stmt = conn.createStatement();

				List<String> usuarios = new ArrayList<>();
				ResultSet rs1 = stmt.executeQuery(" SELECT DNI_H FROM Huesped");
				while (rs1.next()) {
					usuarios.add(rs1.getString("DNI_H"));
				}

				List<String> contrasenyas = new ArrayList<>();
				ResultSet rs2 = stmt.executeQuery(" SELECT Contrasenya_H FROM Huesped");
				while (rs2.next()) {
					contrasenyas.add(rs2.getString("Contrasenya_H"));
				}

				if (usuarios.contains(dni) && contrasenyas.contains(contrasenya)
						&& usuarios.indexOf(dni) == contrasenyas.indexOf(contrasenya)) {
					return true;
				}

				stmt.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("Error de conexion a la BD");
			}

		}
		return false;

	}



	

}
