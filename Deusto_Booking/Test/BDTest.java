package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;

public class BDTest {
	
	private Gestor gestor;
	
	private Set<Duenio> setDuenios;
	private Set<Inmueble> setInmuebles;
	private Set<Huesped> setHuesped;
	
	@Before
	public void setUp() {
		
		gestor = new Gestor();
		
		setDuenios = gestor.getPropietarios();
		setInmuebles = gestor.getInmuebles();
		setHuesped = gestor.getHuespedes();
		
		
	}
	
	@Test
	public void anadirInmueblePersonaTest() {
		
		List<Inmueble> listaInmuebles = new ArrayList<>(setInmuebles);
		
		Inmueble i = listaInmuebles.get(0);
		
		gestor.anadirInmueble( i );
		assertEquals( i, listaInmuebles.get(0) );//Comparo si el inmueble de test con el que he introducido esta dentro detro de la BD
	}
	
	@Test
	public void anadirDuenioTest() {
		List<Duenio> listaDuenios = new ArrayList<>(setDuenios);
		
		Duenio d = new Duenio( "65498721A", "Pepe", 30, "pepe@gmail.com", "4796165", "11111", "informatico" );
		
		gestor.anyadirDuenio(d);
		assertEquals(d, listaDuenios.get( 1 ));
	}

	@Test
	public void anadirHuespedTest() {
		List<Huesped> listaHuespedes = new ArrayList<>(setHuesped);
		
		Huesped h = new Huesped( "85214736A", "Beltran", 20, "beltran@gmail.com", "654128259", "11111", "Empleado", "Google" );
		
		gestor.registroHuesped("85214736A", "Beltran", 20, "beltran@gmail.com", "654128259", "11111", "Empleado", "Google");
		assertEquals( h, listaHuespedes.get( 4 ));
		
	}
	

}
