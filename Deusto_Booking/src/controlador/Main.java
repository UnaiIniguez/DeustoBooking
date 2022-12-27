package controlador;

import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.TipoBusqueda;
import gui.VentanaLogin;
import gui.VentanaPrincipal;

public class Main {
	
	private static Gestor gestor;
	private static VentanaPrincipal ventana;
	private static Connection cn;
	
	

	public static void main(String[] args) {

		gestor = new Gestor();
		ventana = new VentanaPrincipal(gestor);
		ventana.setVisible(true);
		cn = gestor.conectar();
		
		
//========================Leer la Base de Datos===============================

		leerBaseDeDatos(cn, TipoBusqueda.DUENYO);

	}

	// ========================Metodo para leer la Base de
	// Datos======================================================================================================================================================

	private static void leerBaseDeDatos(Connection cn, TipoBusqueda tb) {
		
		System.out.println("Ejecución método leerBaseDatos");

		String sqlQuery = "";
		ResultSet rs = null;

		try {
			Statement st = cn.createStatement();

			// Para ver los datos de la BD se usa executeQuery; para borrar y actualizar
			// datos se usa executeUpdate

			switch (tb) {
			case DUENYO:
				sqlQuery = "SELECT * FROM Duenyo";
				rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					// Columnas Duenyo
					String dni_d = rs.getString(1);
					String nom_d = rs.getString(2);
					int edad_d = rs.getInt(3);
					String mail_d = rs.getString(4);
					String tlf_d = rs.getString(5);
					String cargo = rs.getString(6);
					String contrasenya = rs.getString(7); // Aqui habia un 9, ( ns si hay que cambiarlo)

					// Lo muestro por pantalla
					System.out.println(dni_d + " " + nom_d + " " + edad_d + " " + mail_d + " " + tlf_d + " " + cargo
							+ " " + contrasenya);
				}

				break;
			case HUESPED:
				sqlQuery = "SELECT * FROM Huesped";
				rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					// Columnas Huesped
					String dni_h = rs.getString(1);
					String nom_h = rs.getString(2);
					int edad_h = rs.getInt(3);
					String mail_h = rs.getString(4);
					String tlf_h = rs.getString(5);
					String cargo = rs.getString(6);
					String nom_emp = rs.getString(7);
					String contrasenya_h = rs.getString(8); // Aqui habia un 9 ( ns si hay que cambiarlo)

					// Lo muestro por pantalla
					System.out.println(dni_h + " " + nom_h + " " + edad_h + " " + mail_h + " " + tlf_h + " " + cargo
							+ " " + nom_emp + " " + contrasenya_h);
				}

				break;
			case INMUEBLE:
				sqlQuery = "SELECT * FROM Inmueble";
				rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					// Columnas Inmueble
					float precio = rs.getFloat(1);
					int max_hu = rs.getInt(2);
					boolean ocupado = rs.getBoolean(3);
					int num_hab = rs.getInt(4);
					int num_bany = rs.getInt(5);
					String ubi = rs.getString(6);
					String tipo = rs.getString(7);
					float m2 = rs.getFloat(8);
					String dni_d = rs.getString(9);

					// Lo muestro por pantalla
					System.out.println(precio + " " + max_hu + " " + ocupado + " " + num_hab + " " + num_bany + " "
							+ ubi + " " + tipo + " " + m2 + " " + dni_d);
				}

				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
