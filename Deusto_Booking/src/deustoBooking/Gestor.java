package deustoBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Gestor {
	
	private List<Duenio> propietarios = new ArrayList();

	private Map<String, ArrayList<Inmueble>> huespedes = new HashMap<>(); // En este mapa se almacenaran todos los
																				// huespedes y los inmuebles que tiene
																				// reservados.(Clave DNI)

	List<Inmueble> inmuebles = new ArrayList<>(); // Las viviendas que hay en la pagina web
	
	public void datosTest() {
		
		ArrayList<Inmueble> inmueblesTest = new ArrayList();
		Duenio d = new Duenio(12345678, "Pepe", "pepe@gmail.com", "656232359", "1234", inmueblesTest);
		propietarios.add(d);
		
	}

	

	public Gestor() {
		
	}

	public List<Duenio> getPropietarios() {
		return propietarios;
	}

	public void setPropietarios(List<Duenio> propietarios) {
		this.propietarios = propietarios;
	}

	public Map<String, ArrayList<Inmueble>> getHuespedes() {
		return huespedes;
	}


	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}


//**************************METODOS COMUNES**********************************************
	


	/**
	 * 
	 * Iniciar sesión  
	 * 
	 * @param Persona = La persona que desea iniciar sesión.
	 *
	 */
	public boolean iniSesion(Persona p) {
		if ( p instanceof Duenio) {
			if(propietarios.contains(p)) {
				return true;
			}
		}else {
			if(huespedes.keySet().contains(p.getDni())) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
//********************METODOS DEL ANFITRIÓN********************************
	
	
	
	/**
	 * 
	 * Anyade un inmueble a la web 
	 * 
	 * @param Duenio = El duenio que quiere anyadir el inmueble
	 *  @param Inmueble = inmueble que quiere anyadir
	 *
	 */
	public void anadirInmueble( Duenio duenio, Inmueble inmueble ) {
		
		duenio.getInmuebles().add(inmueble);
		inmuebles.add(inmueble);
		
	}
	
	/**
	 * 
	 * Borra un inmueble de la web 
	 * 
	 * @param Duenio = El duenio que quiere eliminar el inmueble
	 *  @param Inmueble = inmueble que quiere eliminar
	 *
	 */
	public void borrarInmueble( Duenio duenio, Inmueble inmueble) {
		
		duenio.getInmuebles().remove(inmueble);
		inmuebles.remove(inmueble);
		
	}
	
	
	/**
	 * 
	 * Editar el inmueble (Cambios en el espacio, mas habitaciones...)
	 * 
	 * @param Duenio = El duenio que quiere editar el inmueble
	 * @param Inmueble viejo = El viejo inmueble que se quiere editar
	 * @param Inmueble nuevo = El inmueble con los cambios   
	 *
	 */
	public void editarInmueble(Duenio duenio, Inmueble inmuebleviejo, Inmueble nuevoInmueble) {
		
		duenio.getInmuebles().remove(inmuebleviejo);
		inmuebles.remove(inmuebleviejo);
		
		duenio.getInmuebles().add(nuevoInmueble);
		inmuebles.add(nuevoInmueble);
		
	}
	
	
	//********************METODOS DEL HUESPED********************************
	
	public void anularReserva(Huesped h, Inmueble i) {
		if ( huespedes.containsKey(h.getDni()) ) {
			if(huespedes.get(h.getDni()).contains(i)) {
				huespedes.get(h.getDni()).remove(i);
			}
		}
	}
	

}


