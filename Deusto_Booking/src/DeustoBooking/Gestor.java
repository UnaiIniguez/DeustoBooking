package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public class Gestor {
	
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
	
	
}
