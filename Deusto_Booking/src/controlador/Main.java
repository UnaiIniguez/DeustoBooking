package controlador;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import deustoBooking.Gestor;
import gui.VentanaLogin;
import gui.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		
		Gestor gestor = new Gestor();
		VentanaPrincipal ventana = new VentanaPrincipal(gestor);
		ventana.setVisible(true);
		Gestor conexion = new Gestor();
		Connection cn = conexion.conectar();
		
//========================Leer la Base de Datos===============================
		
		leerBaseDeDatos(cn);
		
	}

	// ========================Metodo para leer la Base de Datos======================================================================================================================================================

	private static void leerBaseDeDatos(Connection cn) {

		try {
			Statement st = cn.createStatement();

			// Para ver los datos de la BD se usa executeQuery; para borrar y actualizar
			// datos se usa executeUpdate

			ResultSet rs = st.executeQuery("SELECT * FROM Duenyo");

			// Para iterar todos los datos
			while (rs.next()) {

				// Columnas Inmueble
//				int precio = rs.getInt(1);
//				int max_hu = rs.getInt(2);
//				int ocupado = rs.getInt(3);
//				int num_hab = rs.getInt(4);
//				int num_bany = rs.getInt(5);
//				String ubi = rs.getString(6);
//				String tipo = rs.getString(7);
//				int m2 = rs.getInt(8);
//				int dni_d = rs.getInt(9);
				// Lo muestro por pantalla
				//System.out.println(precio + " " + max_hu + " " + ocupado + " " + num_hab + " " + num_bany + " " + ubi + " " + tipo + " " + m2 + " " + dni_d);
				
				//Columnas Huesped
//				int dni_h = rs.getInt(1);
//				String nom_h = rs.getString(2);
//				int edad_h = rs.getInt(3);
//				String mail_h = rs.getString(4);
//				int tlf_h = rs.getInt(5);
//				String cargo = rs.getString(6);
//				String nom_emp = rs.getString(7);
//				String contrasenya_h = rs.getString(9);
				
				//Lo muestro por pantalla
				//System.out.println(dni_h + " " + nom_h + " " + edad_h + " " + mail_h + " " + tlf_h + " " + cargo + " " + nom_emp + " " + contrasenya_h);
				
				//Columnas Duenyo
				int dni_d = rs.getInt(1);
				String nom_d = rs.getString(2);
				int edad_d = rs.getInt(3);
				String mail_d = rs.getString(4);
				int tlf_d = rs.getInt(5);
				String cargo = rs.getString(6);
				String contrasenya = rs.getString(9);
				
				//Lo muestro por pantalla
				System.out.println(dni_d + " " + nom_d + " " + edad_d + " " + mail_d + " " + tlf_d + " " + cargo + " " + contrasenya);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
