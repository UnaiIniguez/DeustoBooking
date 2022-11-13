package DeustoBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Gestor {

	private HashMap<String, ArrayList<Inmueble>> propietarios = new HashMap<>(); // En este mapa se almacenaran los
																					// propietarios con sus viviendas

	private HashMap<String, ArrayList<Inmueble>> huespedes = new HashMap<>(); // En este mapa se almacenaran todos los
																				// huespedes y los inmuebles que tiene
																				// reservados.

	ArrayList<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web

	

	public Gestor() {
		
	}

	public HashMap<String, ArrayList<Inmueble>> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(HashMap<String, ArrayList<Inmueble>> propietarios) {
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
	
	public static void anadirInmueblePersona( String nombre, HashMap<String, ArrayList<Inmueble>> inmuebles, ArrayList<Inmueble> arrayList ) {
		if ( inmuebles.containsKey(nombre) ) {
			inmuebles.get(nombre).addAll(arrayList);	
			System.out.println( "Se a�adio el inmueble" );
		}else {
			System.out.println( "No se encontro al propietario" );
		}
		
	}
	
	public static void borrarInmueble( String nombre, HashMap<String, ArrayList<Inmueble>> inmuebles ) {
		Scanner sc = new Scanner(System.in);
		if (inmuebles.containsKey(nombre)) {
			inmuebles.remove( nombre, sc);
			System.out.println( "Se a eliminado el inmueble" );
		}else {
			System.out.println( "No hay ningun inmueble asignado a esa persona" );
		}
		
	}

}


