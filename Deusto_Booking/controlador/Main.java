package controlador;

import deustoBooking.Gestor;
import gui.VentanaPrincipal;

public class Main {



	public static void main(String[] args) {

		Gestor gestor = new Gestor();
		new VentanaPrincipal(gestor);
		
		

	}


}
