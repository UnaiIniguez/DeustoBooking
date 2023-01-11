package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import deustoBooking.Duenio;
import deustoBooking.Inmueble;

public class DuenioTest {
	
	private Duenio duenio;

	
	@Before
	public void setUp() {
	duenio = new Duenio("123456", "John", 30, "john@example.com", "555-555-5555", "password", "manager");
	
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
	

	
	
	
}
