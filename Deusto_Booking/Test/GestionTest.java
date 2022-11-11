import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import DeustoBooking.Gestor;
import DeustoBooking.Inmueble;

public class GestionTest {
	
	
	@Before
	public void setUp() {
		
		HashMap<String, ArrayList<Inmueble>> inmueblePru = new HashMap<>();
		inmueblePru.put( "String", new ArrayList<Inmueble>());
		
	}

	@Test
	public void anadirInmueblePersonaTest() {
		
		Gestor.anadirInmueblePersona( "Manuel", null, null);
		assertEquals( "Manuel", null );
		
	}
	
	@Test
	public void borrarInmuebleTest() {
		
		Gestor.borrarInmueble( "Manuel" , null);
		assertFalse(false);
	}

}
