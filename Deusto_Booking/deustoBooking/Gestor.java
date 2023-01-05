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



import utilidades.Cifrar;

public class Gestor {

	private static Set<Duenio> propietarios = new HashSet<>();

	private static Set<Huesped> huespedes = new HashSet<>(); // Guardará a todos los huespedes de la base de datos

	private static Set<Inmueble> inmuebles = new TreeSet<>(); // Las viviendas que hay en la pagina web

	private Map<String, ArrayList<Reserva>> reservas = new HashMap<>(); // En este mapa se almacenaran todas las
																			// reservas. La clave será el DNI del huesped
																			// que ha hecho esas reservas.
	private static Connection conectar;

	private static boolean isChangedP;// MArcador de cambio de Propietario
	private static boolean isChangedI;// Marcador de cambio de Inmueble

	public void datosTest() {

		ArrayList<Inmueble> inmueblesTest = new ArrayList<>();
		Duenio d = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", "Jefe");
		propietarios.add(d);

	}

	public Gestor() {
		conectar();
		isChangedP = false;
		isChangedI = false;
		inicializarBD();

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
		anyadirInmuebleBD(inmueble);
		
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
		eliminarInmuebleBD(inmueble);

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
		editarNumBanInmuebleBD(inmueble, Ban);
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
		
		editarNumHabInmuebleBD(inmueble, Hab);
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
			reservarBD(reserva);
			
		} else {
			reservas.put(h.getDni(), new ArrayList<Reserva>());
			reservas.get(h.getDni()).add(reserva);
			reservarBD(reserva);
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
			anularReservaBD(reserva);
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
			editarFechaReservaBD( reserva, FechaEntrada, FechaSalida);
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



	// ========================Metodo para conenctarme a la Base de
	// Datos======================================================================================================================================================

	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");

			conectar = DriverManager.getConnection("jdbc:sqlite:Deusto_Booking.db");
			System.out.println("Conexion establecida");
			inicializarBD();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conectar;

	}

	public void inicializarBD() {

		String sql_TablaInmueble = " CREATE TABLE IF NOT EXISTS Inmueble (" + "Precio DECIMAL," + "Max_Hu INTEGER,"
				+ "Ocupado INTEGER," + "Num_Hab INTEGER," + "Num_Bany INTEGER," + "Ubi TEXT," + "Tipo TEXT,"
				+ "m2	DECIMAL," + "DNI_D INTEGER," + "PRIMARY KEY (Ubi) "
				+ "FOREIGN KEY (DNI_D) REFERENCES Duenyo (DNI_D) );";

		String sql_TablaHuesped = " CREATE TABLE IF NOT EXISTS Huesped (" + "DNI_H INTEGER," + "NOM_H TEXT,"
				+ "EDAD_H INTEGER," + "MAIL_H TEXT," + "TLF_H TEXT," + "Cargo TEXT," + "NOM_EMP TEXT,"
				+ "Contrasenya_H	TEXT," + "PRIMARY KEY (DNI_H) );";

		String sql_TablaDuenyo = " CREATE TABLE IF NOT EXISTS Duenyo (" + "DNI_D TEXT," + "NOM_D TEXT,"
				+ "EDAD_D INTEGER," + "MAIL_D TEXT," + "TLF_D INTEGER," + "Contrasenya	TEXT," + "Cargo TEXT,"
				+ "PRIMARY KEY (DNI_D) );";

		try {
			Statement st = conectar.createStatement();
			st.execute(sql_TablaInmueble);
			st.execute(sql_TablaHuesped);
			st.execute(sql_TablaDuenyo);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public static void actualizarBD() {

		// Este metodo detecta que tablas han sido modificadas y a continuacion borra la
		// informacion
		// antigua y guarda la nueva

		if (isChangedP) {
			String sql_TablaDuenyo = "DELETE from Duenyo;";

			try {
				Statement st = conectar.createStatement();
				st.execute(sql_TablaDuenyo);
				//guardarDatosBD(TipoBusqueda.DUENYO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (isChangedI) {
			String sql_TablaDuenyo = "DELETE from Inmueble;";

			try {
				Statement st = conectar.createStatement();
				st.execute(sql_TablaDuenyo);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		if (isChangedH) {
//			String sql_TablaDuenyo = "DELETE from Inmueble;";
//
//			try {
//				Statement st = conectar.createStatement();
//				st.execute(sql_TablaDuenyo);
//				guardarDatosBD(TipoBusqueda.INMUEBLE);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}


		
	}

	// ================Test de la Base de Datos==========================

	public void bdTest() {

		datosTest();

		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?);";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setInt(1, 9999);
			pst.setInt(2, 3);
			pst.setInt(3, 1);
			pst.setString(4, "Bilbao");
			pst.setInt(5, 4);
			pst.setString(6, "Casa");
			pst.setFloat(7, 70);
			pst.setFloat(8, (float) 55.99);
			pst.setInt(9, 0);
			pst.setString(10, "58000000S");
			
			pst.executeUpdate();
			System.out.println("Insercion correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void anyadirDuenyoBD(Duenio duenio) { // A�ade un due�o a la Base de Datos

		String datos_sql = "INSERT INTO Duenyo VALUES ( ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setString(1, duenio.getDni());
			pst.setString(2, duenio.getNombre());
			pst.setInt(3, duenio.getEdad());
			pst.setString(4, duenio.getMail());
			pst.setString(5, duenio.getTlfNum());
			pst.setString(6, Cifrar.cifrar(duenio.getContrasenya()));
			pst.setString(7, duenio.getCargo());
			pst.executeUpdate();
			System.out.println("Inserci�n correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void anyadirInmuebleBD(Inmueble inmueble) { // A�ade un inmueble a la Base de Datos

		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setInt(1, inmueble.getId_Inmueble());
			pst.setInt(2, inmueble.getNumHab());
			pst.setInt(3, inmueble.getNumBany());
			pst.setString(4, inmueble.getUbicacion());
			pst.setInt(5, inmueble.getMaxHuespedes());
			pst.setString(6, inmueble.getTipo().toString());
			pst.setFloat(7, inmueble.getMetrosCuadrados());
			pst.setFloat(8, inmueble.getPrecioNoche());
			pst.setInt(9, inmueble.getOcupado());
			pst.setString(10, inmueble.getDni_Duenio());
			//pst.setBlob(11, );
			pst.executeUpdate();
			System.out.println("Insercion correcta");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void eliminarInmuebleBD(Inmueble inmueble) {
		String s = "DELETE FROM Inmueble WHERE id_Inmueble =" + inmueble.getId_Inmueble() + "ON DELETE CASCADE;";
		
		try {
			PreparedStatement eliminarSQL = conectar.prepareStatement(s);
			eliminarSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void editarNumBanInmuebleBD(Inmueble inmueble, int ban) {
		String s = "UPDATE Inmueble SET numBany = " + ban + "WHERE id_Inmueble = " + inmueble.getId_Inmueble()+ ";";
		
		try {
			PreparedStatement editarSQL = conectar.prepareStatement(s);
			editarSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarNumHabInmuebleBD(Inmueble inmueble, int Hab) {
		String s = "UPDATE Inmueble SET numHabi = " + Hab + "WHERE id_Inmueble = " + inmueble.getId_Inmueble()+ ";";
		
		try {
			PreparedStatement editarSQL = conectar.prepareStatement(s);
			editarSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

	public void anyadirHuespedBD(Huesped huesped) { // A�ade un huesped a la Base de Datos

		String datos_sql = "INSERT INTO Huesped VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setString(1, huesped.getDni());
			pst.setString(2, huesped.getNombre());
			pst.setInt(3, huesped.getEdad());
			pst.setString(4, huesped.getMail());
			pst.setString(5, huesped.getTlfNum());
			pst.setString(6, huesped.getCargo());
			pst.setString(7, huesped.getNomEmpresa());
			pst.setString(8, Cifrar.cifrar(huesped.getContrasenya()));
			pst.executeUpdate();
			System.out.println("Inserci�n correcta");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

	public void reservarBD( Reserva reserva) {
		String datos_sql = "INSERT INTO Reserva VALUES(? , ? , ? , ? , ? );";
		
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setInt(0, reserva.getId_Reserva());
			pst.setInt(1, reserva.getId_Inmueble());
			
			long dato1 = reserva.getFecha_Entrada().getTime();
	        java.sql.Date fechaEntrada = new java.sql.Date(dato1);
			pst.setDate(2,fechaEntrada);
			
			long dato2 = reserva.getFecha_Salida().getTime();
	        java.sql.Date fechaSalida = new java.sql.Date(dato2);
			pst.setDate(3,fechaSalida);
			
			pst.setString(4, reserva.getDni_Huesped());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public void anularReservaBD(Reserva reserva) {
		
		String datos_sql = "DELETE FROM Reserva WHERE Id_Reserva = " + reserva.getId_Reserva() + ";";
		
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void editarFechaReservaBD( Reserva reserva, Date FechaEntrada, Date FechaSalida) {
		
		long dato1 = FechaEntrada.getTime();
        java.sql.Date entrada = new java.sql.Date(dato1);
        long dato2 = FechaSalida.getTime();
        java.sql.Date salida = new java.sql.Date(dato2);
        
		String datos_sql = "UPDATE Reserva SET fecha_Entrada = '" + entrada + "', fecha_Salida = '" + salida + "' WHERE Id_Reserva = " + reserva.getId_Reserva()+ ";";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
	

}
