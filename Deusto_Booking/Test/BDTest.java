import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Inmueble;

public class BDTest {
	
	private Gestor gestor;
	
	@Before
	public void setUp() {
		
		gestor = new Gestor();
		
		gestor.bdTest();
		
		
	}
	
	@Test
	public void anadirInmueblePersonaTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		//gestor.anadirInmueble( d, i );
		//assertEquals( i, d.getInmuebles().get(0) );//Comparo si el inmueble de test con el que he introducido esta dentro detro de la BD
	}
	
	@Test
	public void anadirDuenioTest() {
		
		
		
	}

	@Test
	public void anadirHuespedTest() {
		
	}
	

}
