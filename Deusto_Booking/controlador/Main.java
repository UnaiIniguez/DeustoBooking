package controlador;

import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.TipoBusqueda;
import deustoBooking.TipoVivienda;
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
		leerBaseDeDatos(cn, TipoBusqueda.INMUEBLE);

	}

	// ========================Metodo para leer la Base de
	// Datos======================================================================================================================================================

	private static void leerBaseDeDatos(Connection cn, TipoBusqueda tb) {

		System.out.println("Ejecuci�n m�todo leerBaseDatos");

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
					Gestor.getPropietarios().add(new Duenio(dni_d, nom_d, edad_d, mail_d, tlf_d, cargo, contrasenya));
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
				//PRUEBA
				sqlQuery = "SELECT * FROM Inmueble";
				rs = st.executeQuery(sqlQuery);
				while (rs.next()) {
					// Columnas Inmueble
					int id_Inmueble = rs.getInt(1);
					int num_hab = rs.getInt(2);
					int num_bany = rs.getInt(3);
					String ubi = rs.getString(4);
					int max_hu = rs.getInt(5);
					String tipo = rs.getString(6);
					float m2 = rs.getFloat(7);
					float precio = rs.getFloat(8);
					int ocupado = rs.getInt(9);
					String dni_d = rs.getString(10);
					Blob foto_1 = rs.getBlob(11);
					Blob foto_2 = rs.getBlob(12);
					Blob foto_3 = rs.getBlob(13);
					Blob foto_4 = rs.getBlob(14);
					
					// Lo muestro por pantalla(Todo menos las fotos)
					System.out.println(id_Inmueble + " " + num_hab + " " + num_bany + " " + ubi + " " +  max_hu + " " + tipo + " " + m2 + " " + precio + " " +  ocupado + " " +
							     dni_d);
					// public Inmueble(Duenio duenio, String ubicacion, TipoVivienda tipo, float
					// metrosCuadrados, int numBany, int numHab,
					// int maxHuespedes, float precioNoche, int ocupado)
					
					TipoVivienda tipo_vivienda = tipoVivienda(tipo);
					Blob[] imagenes; 
					imagenes = new Blob[4];
					//imagenes = new Blob[foto_1,foto_2,foto_3,foto_4];
					
					Gestor.getInmuebles().add(new Inmueble(id_Inmueble, dni_d, ubi,tipo_vivienda,m2,num_bany,num_hab,max_hu,precio,ocupado, imagenes));
				}

				break;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	

	private static TipoVivienda tipoVivienda(String tipo) {
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

}
