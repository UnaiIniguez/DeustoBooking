package DeustoBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Gestor {
	
	private ArrayList<Duenio> propietarios = new ArrayList();

	private HashMap<String, ArrayList<Inmueble>> huespedes = new HashMap<>(); // En este mapa se almacenaran todos los
																				// huespedes y los inmuebles que tiene
																				// reservados.

	ArrayList<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web
	
	public void datosTest() {
		
		ArrayList<Inmueble> inmueblesTest = new ArrayList();
		Duenio d = new Duenio(12345678, "Pepe", "pepe@gmail.com", "656232359", "1234", inmueblesTest);
		propietarios.add(d);
		
	}

	

	public Gestor() {
		
	}

	public ArrayList<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(ArrayList<Duenio> propietarios) {
		this.propietarios = propietarios;
	}

	public HashMap<String, ArrayList<Inmueble>> getHuespedes() {
		return huespedes;
	}

	public void setHuespedes(HashMap<String, ArrayList<Inmueble>> huespedes) {
		this.huespedes = huespedes;
	}

	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(ArrayList<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
	
	public static void anadirInmueblePersona( Duenio duenio, Inmueble inmueble ) {
		
		duenio.getInmuebles().add(inmueble);
		
	}
	
	public static void borrarInmueble( Duenio duenio, Inmueble inmueble) {
		
		duenio.getInmuebles().remove(inmueble);
		
	}

}


