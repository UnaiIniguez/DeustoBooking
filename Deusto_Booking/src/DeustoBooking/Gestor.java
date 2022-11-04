package DeustoBooking;

import java.util.ArrayList;
import java.util.HashMap;

public class Gestor {
<<<<<<< HEAD

	private HashMap<String, ArrayList<Inmueble>> propietarios = new HashMap<>(); // En este mapa se almacenaran los
																					// propietarios con sus viviendas

	private HashMap<String, ArrayList<Inmueble>> huespedes = new HashMap<>(); // En este mapa se almacenaran todos los
																				// huespedes y los inmuebles que tiene
																				// reservados.

	ArrayList<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web

	public Gestor(HashMap<String, ArrayList<Inmueble>> propietarios, HashMap<String, ArrayList<Inmueble>> huespedes,
			ArrayList<Inmueble> inmuebles) {
		super();
		this.propietarios = propietarios;
		this.huespedes = huespedes;
		this.inmuebles = inmuebles;
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

=======
	
	private HashMap<String, ArrayList<Inmueble>> propietarios = new HashMap<>();	//En este mapa se almacenaran los propietarios con sus viviendas
	
	private HashMap<String, ArrayList<Inmueble>> huespedes = new HashMap<>();			//En este mapa se almacenaran todos los huespedes y los inmuebles que tiene reservados.
	
	ArrayList<Inmueble> inmuebles = new ArrayList<>();			//Las viviendas que hay en la pagina web


	
	
	
	
	
	
	
	
	
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
	
	
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
}
