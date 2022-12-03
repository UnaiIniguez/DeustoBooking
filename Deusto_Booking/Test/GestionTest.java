import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;

public class GestionTest {
	
	private Gestor gestor;
	
	@Before
	public void setUp() {
		
		gestor = new Gestor();
		
		gestor.datosTest();
		
		HashMap<String, ArrayList<Inmueble>> inmueblePru = new HashMap<>();
		inmueblePru.put( "String", new ArrayList<Inmueble>());
		
	}

	@Test
	public void anadirInmueblePersonaTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		gestor.anadirInmueblePersona( d, i );
		assertEquals( i, d.getInmuebles().get(0) );//Comparo si el inmueble de test con el que he introducido
		
	}
	
	@Test
	public void borrarInmuebleTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		gestor.borrarInmueble( d , i);
		assertEquals( null, null);
	}

}
