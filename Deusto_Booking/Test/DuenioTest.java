package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import deustoBooking.Duenio;
import deustoBooking.Inmueble;

public class DuenioTest {
	
	private Duenio duenio;
	
	private Duenio duenio2;
	
	
	@Before
	public void setUp() {
	duenio = new Duenio("123456", "John", 30, "john@example.com", "555-555-5555", "password", "manager");
	duenio2 = new Duenio("00000", "Unai", 12, "john@example.com", "000-000-000", "password", "manager");
	
	}
	
	
	@Test
	public void testToString() {
	    assertEquals("John 123456", duenio.toString());
	}
	
	
	@Test
	public void testGetCargo() {
	    assertEquals("manager", duenio.getCargo());
	}
	
	
	@Test
	public void testSetCargo() {
	    duenio.setCargo("supervisor");
	    assertEquals("supervisor", duenio.getCargo());
	}
	
	
	@Test
	public void testGetDni() {
	    assertEquals("123456", duenio.getDni());
	}
	
	
	@Test
	public void testSetDni() {
		duenio.setDni("00000");
	    assertEquals("00000", duenio.getDni());
	}
	
	
	@Test
	public void testGetNombre() {
	    assertEquals("John", duenio.getNombre());
	}
	
	
	@Test
	public void testSetNombre() {
		duenio.setNombre("Unai");
	    assertEquals("Unai", duenio.getNombre());
	}
	
	
	@Test
	public void testGetMail() {
	    assertEquals("john@example.com", duenio.getMail());
	}
	
	
	@Test
	public void testSetMail() {
		duenio.setMail("unai@example.com");
	    assertEquals("unai@example.com", duenio.getMail());
	}
	
	
	@Test
	public void testGetTlfNum() {
	    assertEquals("555-555-5555", duenio.getTlfNum());
	}
	
	
	@Test
	public void testSetTlfNum() {
		duenio.setTlfNum("111-111-111");
	    assertEquals("111-111-111", duenio.getTlfNum());
	}
	
	
	@Test
	public void testGetEdad() {
	    assertEquals(30, duenio.getEdad());
	}
	
	
	@Test
	public void testSetEdad() {
		duenio.setEdad(20);
	    assertEquals(20, duenio.getEdad());
	}
	
	
	@Test
	public void testGetContrasenya() {
	    assertEquals("password", duenio.getContrasenya());
	}
	
	
	@Test
	public void testSetContrasenya() {
		duenio.setContrasenya("hola");
	    assertEquals("hola", duenio.getContrasenya());
	}
	
	
	@Test
	public void testEquals() {
		assertFalse(duenio.equals(duenio2));
	}
	
	
	
}
