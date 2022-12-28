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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Gestor {

	private static List<Duenio> propietarios = new ArrayList<>();

	private static List<Huesped> huespedes = new ArrayList<>(); // GuardarÃ¡ a todos los huespedes de la base de datos

	private static List<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web

	private Map<String, ArrayList<Inmueble>> reservas = new HashMap<>(); // En este mapa se almacenaran todos los
																			// huespedes y los inmuebles que tien //															// reservados.(Clave DNI)
	private static Connection conectar;
	
	private static boolean isChangedP;//MArcador de cambio de Propietario
	private static boolean isChangedI;//Marcador de cambio de Inmueble

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

	public static List<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Duenio> duenios) {
		propietarios = duenios;
	}
	
	public static List<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public static void setInmuebles(List<Inmueble> inmuebles) {
		Gestor.inmuebles = inmuebles;
	}
	
	public Map<String, ArrayList<Inmueble>> getHuespedes() {
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


	public Map<String, ArrayList<Inmueble>> getReservas() {
		return reservas;
	}

	public Connection getConectar() {
		return conectar;
	}

	/**
	 * 
	 * Iniciar sesiÃ³n
	 * 
	 * @param Persona = La persona que desea iniciar sesiÃ³n.
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

//********************METODOS DEL ANFITRIÃ“N********************************

	/**
	 * 
	 * Anyade un inmueble a la web
	 * 
	 * @param Duenio   = El duenio que quiere anyadir el inmueble
	 * @param Inmueble = inmueble que quiere anyadir
	 *
	 */
//	public void anadirInmueble(Duenio duenio, Inmueble inmueble) {
//
//		duenio.getInmuebles().add(inmueble);
//		inmuebles.add(inmueble);
//
//	}

	/**
	 * 
	 * Borra un inmueble de la web
	 * 
	 * @param Duenio   = El duenio que quiere eliminar el inmueble
	 * @param Inmueble = inmueble que quiere eliminar
	 *
	 */
//	public void borrarInmueble(Duenio duenio, Inmueble inmueble) {
//
//		duenio.getInmuebles().remove(inmueble);
//		inmuebles.remove(inmueble);
//
//	}

	/**
	 * 
	 * Editar el inmueble (Cambios en el espacio, mas habitaciones...)
	 * 
	 * @param Duenio   = El duenio que quiere editar el inmueble
	 * @param Inmueble viejo = El viejo inmueble que se quiere editar
	 * @param Inmueble nuevo = El inmueble con los cambios
	 *
	 */
//	public void editarInmueble(Duenio duenio, Inmueble inmuebleviejo, Inmueble nuevoInmueble) {
//
//		duenio.getInmuebles().remove(inmuebleviejo);
//		inmuebles.remove(inmuebleviejo);
//
//		duenio.getInmuebles().add(nuevoInmueble);
//		inmuebles.add(nuevoInmueble);
//
//	}

	// ********************METODOS DEL HUESPED********************************

	/**
	 * 
	 * Anular reserva
	 * 
	 * @param h = Huesped que anula la reserva
	 * @param i = Inmueble reservado pendiente de anular
	 *
	 */
	public void anularReserva(Huesped h, Inmueble i) {
		if (reservas.containsKey(h.getDni())) {
			if (reservas.get(h.getDni()).contains(i)) {
				reservas.get(h.getDni()).remove(i);
			}
		}
	}

	/**
	 * 
	 * Reservar
	 * 
	 * @param h = Huesped que ejecuta la reserva
	 * @param i = Inmueble pendiente de reservar
	 *
	 */
	public void reservar(Huesped h, Inmueble i) {
		if (reservas.containsKey(h.getDni())) {
			if (!reservas.get(h.getDni()).contains(i)) {
				reservas.get(h.getDni()).add(i);
			}
		} else {
			reservas.put(h.getDni(), new ArrayList<Inmueble>());
			reservas.get(h.getDni()).add(i);
		}
	}

	public boolean iniciarSesionDB(String dni, String contrasenya) {

		Connection conn = null;
		{
			try {

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
					usuarios.add(rs2.getString("Contrasenya_H"));
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

	public void registroHuesped(String dni, String nombre, int edad, String mail, String tlf, String cargo,
			String nomEmpresa, String contrasenya) {

		Huesped h = new Huesped(dni, nombre, edad, mail, tlf, contrasenya, cargo, nomEmpresa);

		if (!huespedes.contains(h)) {
			huespedes.add(h);
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void actualizarBD() {


		String sql_TablaDuenyo = "DELETE from Duenyo;";

		try {
			Statement st = conectar.createStatement();
			st.execute(sql_TablaDuenyo);
			guardarDatosBD();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ================Test de la Base de Datos==========================

	public void bdTest() {

		datosTest();

		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setInt(1, 100);
			pst.setInt(2, 20);
			pst.setInt(3, 1);
			pst.setInt(4, 4);
			pst.setInt(5, 2);
			pst.setString(6, "Bilbao");
			pst.setString(7, "Casa");
			pst.setInt(8, 12);
			pst.setInt(9, 11223344);
			pst.executeUpdate();
			System.out.println("Inserciï¿½n correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void anyadirInmuebleBD(Inmueble inmueble) { // Añade un inmueble a la Base de Datos

		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setFloat(1, inmueble.getPrecioNoche());
			pst.setInt(2, inmueble.getMaxHuespedes());
			pst.setInt(3, inmueble.getOcupado());
			pst.setInt(4, inmueble.getNumHab());
			pst.setInt(5, inmueble.getNumBany());
			pst.setString(6, inmueble.getUbicacion());
			pst.setString(7, "Casa");// no se porque no me deja hacer inmueble.getTipo(
			pst.setFloat(8, inmueble.getMetrosCuadrados());
			pst.setString(9, inmueble.getDuenio().getDni());
			System.out.println("Inserciï¿½n correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void anyadirDuenyoBD(Duenio duenio) { // Añade un dueño a la Base de Datos

		String datos_sql = "INSERT INTO Duenyo VALUES ( ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conectar.prepareStatement(datos_sql);
			pst.setString(1, duenio.getDni());
			pst.setString(2, duenio.getNombre());
			pst.setInt(3, duenio.getEdad());
			pst.setString(4, duenio.getMail());
			pst.setString(5, duenio.getTlfNum());
			pst.setString(6, duenio.getContrasenya());
			pst.setString(7, duenio.getCargo());
			pst.executeUpdate();
			System.out.println("Inserciï¿½n correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void anyadirHuespedBD(Huesped huesped) { // Añade un huesped a la Base de Datos

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
			pst.setString(8, huesped.getContrasenya());
			System.out.println("Inserciï¿½n correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Obtener de Inmueble los datos necesarios para introducir en la Base de Datos,

//=============================Metodo para guardar en la Base de Datos==============================================================================

	public static void guardarDatosBD() {

		if (!propietarios.isEmpty()) { // Si el array de propietarios contiene propietarios entonces ejecutará los métodos de anyadirDuenyo
			for (int i = 0; i < propietarios.size(); i++) {
				anyadirDuenyoBD(propietarios.get(i));
			}
		}

//		if (!huespedes.isEmpty()) {
//			for (int i = 0; i < huespedes.size(); i++) {
//				anyadirHuespedBD(huespedes.get(i));
//			}
//		}
//
		if (!inmuebles.isEmpty()) {
			for (int i = 0; i < inmuebles.size(); i++) {
				anyadirInmuebleBD(inmuebles.get(i));
			}
		}

	}

}
