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

	private List<Duenio> propietarios = new ArrayList<>();

	private List<Huesped> huespedes = new ArrayList<>(); // GuardarÃ¡ a todos los huespedes de la base de datos

	private Map<String, ArrayList<Inmueble>> Reservas = new HashMap<>(); // En este mapa se almacenaran todos los
																			// huespedes y los inmuebles que tiene
																			// reservados.(Clave DNI)

	List<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web

	public void datosTest() {

		ArrayList<Inmueble> inmueblesTest = new ArrayList<>();
		Duenio d = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", inmueblesTest);
		propietarios.add(d);

	}

	public Gestor() {
		conectar();
		inicializarBD();
		
	}

	public List<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Duenio> propietarios) {
		this.propietarios = propietarios;
	}

	public Map<String, ArrayList<Inmueble>> getHuespedes() {
		return Reservas;
	}

	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}

//**************************METODOS COMUNES**********************************************

	/**
	 * 
	 * Iniciar sesiÃ³n  
	 * 
	 * @param Persona = La persona que desea iniciar sesiÃ³n.
	 *
	 */
	public boolean iniSesion(String dni, String contraseña) {
		
		for(Duenio d : propietarios) {
			if(d.getContrasenya() == contraseña && d.getDni() == dni) {
				return true;
				
			}
		}
		
		for( Huesped p : huespedes) {
			if(p.getContrasenya() == contraseña && p.getDni() == dni) {
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
	public void anadirInmueble(Duenio duenio, Inmueble inmueble) {

		duenio.getInmuebles().add(inmueble);
		inmuebles.add(inmueble);

	}

	/**
	 * 
	 * Borra un inmueble de la web
	 * 
	 * @param Duenio   = El duenio que quiere eliminar el inmueble
	 * @param Inmueble = inmueble que quiere eliminar
	 *
	 */
	public void borrarInmueble(Duenio duenio, Inmueble inmueble) {

		duenio.getInmuebles().remove(inmueble);
		inmuebles.remove(inmueble);

	}

	/**
	 * 
	 * Editar el inmueble (Cambios en el espacio, mas habitaciones...)
	 * 
	 * @param Duenio   = El duenio que quiere editar el inmueble
	 * @param Inmueble viejo = El viejo inmueble que se quiere editar
	 * @param Inmueble nuevo = El inmueble con los cambios
	 *
	 */
	public void editarInmueble(Duenio duenio, Inmueble inmuebleviejo, Inmueble nuevoInmueble) {

		duenio.getInmuebles().remove(inmuebleviejo);
		inmuebles.remove(inmuebleviejo);

		duenio.getInmuebles().add(nuevoInmueble);
		inmuebles.add(nuevoInmueble);

	}

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
		if (Reservas.containsKey(h.getDni())) {
			if (Reservas.get(h.getDni()).contains(i)) {
				Reservas.get(h.getDni()).remove(i);
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
		if (Reservas.containsKey(h.getDni())) {
			if (!Reservas.get(h.getDni()).contains(i)) {
				Reservas.get(h.getDni()).add(i);
			}
		} else {
			Reservas.put(h.getDni(), new ArrayList<Inmueble>());
			Reservas.get(h.getDni()).add(i);
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

	// ========================Metodo para conenctarme a la Base de Datos======================================================================================================================================================

	private Connection conectar;

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
		
		String sql_TablaInmueble = " CREATE TABLE IF NOT EXISTS Inmueble ("
				+ "Precio INTEGER,"
				+ "Max_Hu INTEGER,"
				+ "Ocupado INTEGER,"
				+ "Num_Hab INTEGER,"
				+ "Num_Bany INTEGER,"
				+ "Ubi TEXT,"
				+ "Tipo TEXT,"
				+ "m2	INTEGER,"
				+ "DNI_D INTEGER,"
				+ "PRIMARY KEY (Ubi) );";
		
		String sql_TablaHuesped = " CREATE TABLE IF NOT EXISTS Huesped ("
				+ "DNI_H INTEGER,"
				+ "NOM_H TEXT,"
				+ "EDAD_H INTEGER,"
				+ "MAIL_H TEXT,"
				+ "TLF_H INTEGER,"
				+ "Cargo TEXT,"
				+ "NOM_EMP TEXT,"
				+ "Contrasenya_H	TEXT,"
				+ "PRIMARY KEY (DNI_H) );";
		
		String sql_TablaDuenyo = " CREATE TABLE IF NOT EXISTS Duenyo ("
				+ "DNI_D INTEGER,"
				+ "NOM_D TEXT,"
				+ "EDAD_D INTEGER,"
				+ "MAIL_D TEXT,"
				+ "TLF_D INTEGER,"
				+ "Cargo TEXT,"
				+ "Contrasenya	TEXT,"
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
	
	//================Test de la Base de Datos==========================

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
			System.out.println("Inserción correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
public void anyadirInmueble(Inmueble inmueble) {
		
		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
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
			System.out.println("Inserción correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

public void anyadirDuenyo(Duenio duenio) {
	
	String datos_sql = "INSERT INTO Duenyo VALUES ( ? , ? , ? , ? , ? , ? , ? );";
	try {
		PreparedStatement pst = conectar.prepareStatement(datos_sql);
		pst.setInt(1, 11223344);
		pst.setString(2, "Pepe");
		pst.setInt(3, 30);
		pst.setString(4, "pepe@gmail.com");
		pst.setInt(5, 123586479);
		pst.setString(6, "Jefe");
		pst.setString(7, "123456");
		System.out.println("Inserción correcta");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void anyadirHuesped(Huesped huesped) {
	
	String datos_sql = "INSERT INTO Huesped VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";
	try {
		PreparedStatement pst = conectar.prepareStatement(datos_sql);
		pst.setInt(1, 12345679);
		pst.setString(2, "Juan");
		pst.setInt(3, 28);
		pst.setString(4, "juan@gmail.com");
		pst.setInt(5, 456825476);
		pst.setString(6, "Hospedado");
		pst.setString(7, "Iberdrola");
		pst.setString(8, "456789123");
		System.out.println("Inserción correcta");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	// Obtener de Inmueble los datos necesarios para introducir en la Base de Datos, 

}
