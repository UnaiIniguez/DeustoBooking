package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import deustoBooking.Gestor;
import gui.VentanaLogin;
import gui.VentanaPrincipal;

public class Main {
	
	public static void main(String[] args) {
		
		
		Gestor gestor = new Gestor();
		VentanaLogin ventana = new VentanaLogin(gestor);
		ventana.setVisible(true);
		
		
	}
	

}
