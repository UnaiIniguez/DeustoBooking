package controlBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.Reserva;
import utilidades.Cifrar;

public class GestorBD {

	private static Connection conectar;
	private Gestor gestor;
	
	
	
	public GestorBD() {
		
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
			conectar();
			
			DatabaseMetaData meta = conectar.getMetaData();
			
			ResultSet rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			
			int tablas = 0;
			
			while (rs.next()) {
				tablas++;
			}
			
			
			if (tablas == 0) {
			Statement st = conectar.createStatement();
			st.execute(sql_TablaInmueble);
			st.execute(sql_TablaHuesped);
			st.execute(sql_TablaDuenyo);
			}
			
			conectar.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	

	// ================Test de la Base de Datos==========================

	public void bdTest() {

		gestor.datosTest();

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
			
			e.printStackTrace();
		}

	}

	public void anyadirDuenyoBD(Duenio duenio) { // A�ade un due�o a la Base de Datos

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
			
			e.printStackTrace();
		}

	}
	
	
	public void anyadirInmuebleBD(Inmueble inmueble) { // A�ade un inmueble a la Base de Datos

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
			Statement eliminarSQL = conectar.createStatement();
			eliminarSQL.executeUpdate(s);
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
			System.out.println("Insercion correcta");
			
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
