package controlBD;

import java.sql.Blob;

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
import deustoBooking.TipoVivienda;
import utilidades.Cifrar;

public class GestorBD {

	private Connection conn;
	private Gestor gestor;
	
	
	
	public GestorBD() {
		
	}



	// ========================Metodo para conenctarme a la Base de
	// Datos======================================================================================================================================================

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");

			conn = DriverManager.getConnection("jdbc:sqlite:Deusto_Booking.db");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

	public void inicializarBD() {

		String sql_TablaInmueble = " CREATE TABLE IF NOT EXISTS Inmueble (" + "id_Inmueble INTEGER," + "Num_Hab INTEGER," + "Num_Bany INTEGER," +
				"ubicacion TEXT," +  "maxHuespedes INTEGER," + "tipo TEXT,"
				+ "m2	DECIMAL," + "precioNoche DECIMAL," + "ocupado INTEGER,"   
				  + "DNI_D TEXT," + "foto1 BLOB," + "foto2 BLOB," + "foto3 BLOB," + "foto4 BLOB," 
				+ "PRIMARY KEY (id_Inmueble AUTOINCREMENT)"
				+ "FOREIGN KEY (DNI_D) REFERENCES Duenyo (DNI_D) );";

		String sql_TablaHuesped = " CREATE TABLE IF NOT EXISTS Huesped (" + "DNI_H INTEGER," + "NOM_H TEXT,"
				+ "EDAD_H INTEGER," + "MAIL_H TEXT," + "TLF_H TEXT," +  "Contrasenya_H	TEXT," +"Cargo TEXT," + "NOM_EMP TEXT,"
				 + "PRIMARY KEY (DNI_H) );";

		String sql_TablaDuenyo = " CREATE TABLE IF NOT EXISTS Duenyo (" + "DNI_D TEXT," + "NOM_D TEXT,"
				+ "EDAD_D INTEGER," + "MAIL_D TEXT," + "TLF_D INTEGER," + "Contrasenya_D	TEXT," + "Cargo TEXT,"
				+ "PRIMARY KEY (DNI_D) );";

		String sql_TablaReserva = "CREATE TABLE IF NOT EXISTS Reserva(" + "Id_Reserva INTEGER," + "id_Inmueble," + "fecha_Entrada DATE,"
				+ "fecha_Salida DATE," + "DNI_H TEXT, " + "PRIMARY KEY (Id_Reserva AUTOINCREMENT)," + "FOREIGN KEY (DNI_H) FROM Huesped(DNI_H) ON DELETE CASCADE,"
				+ "FOREIGN KEY (Id_Inmueble) FROM Inmueble(Id_Inmueble) ON DELETE CASCADE ); ";
		try {
			conectar();
			
			DatabaseMetaData meta = conn.getMetaData();
			
			ResultSet rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			
			int tablas = 0;
			
			while (rs.next()) {
				tablas++;
			}
			
			
			if (tablas == 0) {
			Statement st = conn.createStatement();
			st.execute(sql_TablaInmueble);
			st.execute(sql_TablaHuesped);
			st.execute(sql_TablaDuenyo);
			st.execute(sql_TablaReserva);
			
			st.close();
			}
			
			conn.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void leerBaseDeDatos() {

		System.out.println("Ejecucion metodo leerBaseDatos");

		

		try {
			

			// Para ver los datos de la BD se usa executeQuery; para borrar y actualizar
			
			// datos se usa executeUpdate
			conectar();
			Statement duenios = conn.createStatement();
			ResultSet tablaDuenios = duenios.executeQuery("SELECT * FROM Duenyo ;");
			
			while (tablaDuenios.next()) {
					// Columnas Duenyo
				String dni_d = tablaDuenios.getString(1);
				String nom_d = tablaDuenios.getString(2);
				int edad_d = tablaDuenios.getInt(3);
				String mail_d = tablaDuenios.getString(4);
				String tlf_d = tablaDuenios.getString(5);
				String cargo = tablaDuenios.getString(6);
				String contrasenya = tablaDuenios.getString(7); 

				// Lo muestro por pantalla
				System.out.println(dni_d + " " + nom_d + " " + edad_d + " " + mail_d + " " + tlf_d + " " + cargo
						+ " " + contrasenya);
				gestor.anyadirDuenio(new Duenio(dni_d, nom_d, edad_d, mail_d, tlf_d, cargo, contrasenya));
			}
			duenios.close();

			
			Statement huesped = conn.createStatement();
			ResultSet tablaHuesped = huesped.executeQuery("SELECT * FROM Huesped ;");
			
				while (tablaHuesped.next()) {
					// Columnas Huesped
					String dni_h = tablaHuesped.getString(1);
					String nom_h = tablaHuesped.getString(2);
					int edad_h = tablaHuesped.getInt(3);
					String mail_h = tablaHuesped.getString(4);
					String tlf_h = tablaHuesped.getString(5);
					String cargo = tablaHuesped.getString(6);
					String nom_emp = tablaHuesped.getString(7);
					String contrasenya_h = tablaHuesped.getString(8); // Aqui habia un 9 ( ns si hay que cambiarlo)

					// Lo muestro por pantalla
					System.out.println(dni_h + " " + nom_h + " " + edad_h + " " + mail_h + " " + tlf_h + " " + cargo
							+ " " + nom_emp + " " + contrasenya_h);
				}
				
				huesped.close();

				Statement inmueble = conn.createStatement();
				ResultSet tablaInmuebles = inmueble.executeQuery("SELECT * FROM Inmueble ;");
				
				while (tablaInmuebles.next()) {
					// Columnas Inmueble
					int id_Inmueble = tablaInmuebles.getInt(1);
					int num_hab = tablaInmuebles.getInt(2);
					int num_bany = tablaInmuebles.getInt(3);
					String ubi = tablaInmuebles.getString(4);
					int max_hu = tablaInmuebles.getInt(5);
					String tipo = tablaInmuebles.getString(6);
					float m2 = tablaInmuebles.getFloat(7);
					float precio = tablaInmuebles.getFloat(8);
					int ocupado = tablaInmuebles.getInt(9);
					String dni_d = tablaInmuebles.getString(10);
					Blob foto_1 = tablaInmuebles.getBlob(11);
					Blob foto_2 = tablaInmuebles.getBlob(12);
					Blob foto_3 = tablaInmuebles.getBlob(13);
					Blob foto_4 = tablaInmuebles.getBlob(14);
					
					// Lo muestro por pantalla(Todo menos las fotos)
					System.out.println(id_Inmueble + " " + num_hab + " " + num_bany + " " + ubi + " " +  max_hu + " " + tipo + " " + m2 + " " + precio + " " +  ocupado + " " +
							     dni_d);
					
					TipoVivienda tipo_vivienda = tipoVivienda(tipo);
					
					ArrayList<Blob> imagenes = new ArrayList<Blob>();
					imagenes.add(foto_1);
					imagenes.add(foto_2);
					imagenes.add(foto_3);
					imagenes.add(foto_4);
					
					gestor.anadirInmueble(new Inmueble(id_Inmueble, dni_d, ubi,tipo_vivienda,m2,num_bany,num_hab,max_hu,precio,ocupado, imagenes));
				}

				conn.close();
				inmueble.close();
			

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}

	//Para averiguar que tipo de vivienda es
	private TipoVivienda tipoVivienda(String tipo) {
		switch (tipo) {
		case "CHALET":
			return TipoVivienda.CHALET;

		case "PISO":
			return TipoVivienda.PISO;

		case "ADOSADO":
			return TipoVivienda.ADOSADO;

		case "ESTUDIO":
			return TipoVivienda.ESTUDIO;

		}
		return null;
	}
	

	// ================Test de la Base de Datos==========================
	
	
	public boolean iniciarSesionDB(String dni, String contrasenya) {

		conectar();
		
			try {

				contrasenya = Cifrar.cifrar(contrasenya);
				

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
					conn.close();
					stmt.close();
					return true;
				}
				
				conn.close();
				stmt.close();
				
				
			} catch (Exception e) {
				System.out.println("Error de conexion a la BD");
			}

		
		return false;

	}

	public void anyadirDuenyoBD(Duenio duenio) { // Añade un dueno a la Base de Datos

		conectar();
		
		String datos_sql = "INSERT INTO Duenyo VALUES ( ? , ? , ? , ? , ? , ? , ? );";
		
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
			pst.setString(1, duenio.getDni());
			pst.setString(2, duenio.getNombre());
			pst.setInt(3, duenio.getEdad());
			pst.setString(4, duenio.getMail());
			pst.setString(5, duenio.getTlfNum());
			pst.setString(6, Cifrar.cifrar(duenio.getContrasenya()));
			pst.setString(7, duenio.getCargo());
			pst.executeUpdate();
			System.out.println("Insercion correcta");
			
			pst.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	
	public void anyadirInmuebleBD(Inmueble inmueble) { // A�ade un inmueble a la Base de Datos

		conectar();
		
		String datos_sql = "INSERT INTO Inmueble VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? );";
		
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
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
			pst.setBlob(11, inmueble.getImagenes().get(0));
			pst.setBlob(12, inmueble.getImagenes().get(1));
			pst.setBlob(13, inmueble.getImagenes().get(2));
			pst.setBlob(14, inmueble.getImagenes().get(3));
			
			pst.executeUpdate();
			
			System.out.println("Insercion correcta");
		
			pst.close();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void eliminarInmuebleBD(Inmueble inmueble) {
		
		conectar();
		
		String s = "DELETE FROM Inmueble WHERE id_Inmueble =" + inmueble.getId_Inmueble() + "ON DELETE CASCADE;";
		
		try {
			Statement eliminarSQL = conn.createStatement();
			eliminarSQL.executeUpdate(s);
			
			eliminarSQL.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void editarNumBanInmuebleBD(Inmueble inmueble, int ban) {
		
		conectar();
		
		String s = "UPDATE Inmueble SET numBany = " + ban + "WHERE id_Inmueble = " + inmueble.getId_Inmueble()+ ";";
		
		try {
			PreparedStatement editarSQL = conn.prepareStatement(s);
			editarSQL.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void editarNumHabInmuebleBD(Inmueble inmueble, int Hab) {
		
		conectar();
		
		String s = "UPDATE Inmueble SET numHabi = " + Hab + "WHERE id_Inmueble = " + inmueble.getId_Inmueble()+ ";";
		
		try {
			PreparedStatement editarSQL = conn.prepareStatement(s);
			editarSQL.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	public void anyadirHuespedBD(Huesped huesped) { // A�ade un huesped a la Base de Datos

		conectar();
		
		String datos_sql = "INSERT INTO Huesped VALUES ( ? , ? , ? , ? , ? , ? , ? , ? );";
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
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
			pst.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void reservarBD( Reserva reserva) {
		
		conectar();
		
		String datos_sql = "INSERT INTO Reserva VALUES(? , ? , ? , ? , ? );";
		
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
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
			
			pst.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
	
	
	public void anularReservaBD(Reserva reserva) {
		
		conectar();
		
		String datos_sql = "DELETE FROM Reserva WHERE Id_Reserva = " + reserva.getId_Reserva() + ";";
		
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
			pst.executeUpdate();
			
			pst.close();
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void editarFechaReservaBD( Reserva reserva, Date FechaEntrada, Date FechaSalida) {
		
		conectar();
		
		long dato1 = FechaEntrada.getTime();
        java.sql.Date entrada = new java.sql.Date(dato1);
        long dato2 = FechaSalida.getTime();
        java.sql.Date salida = new java.sql.Date(dato2);
        
		String datos_sql = "UPDATE Reserva SET fecha_Entrada = '" + entrada + "', fecha_Salida = '" + salida + "' WHERE Id_Reserva = " + reserva.getId_Reserva()+ ";";
		try {
			PreparedStatement pst = conn.prepareStatement(datos_sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	
}
