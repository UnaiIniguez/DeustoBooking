import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.Persona;

public class PersonaTest {
	
	private Persona persona;
	
	
	

	@Test 
	public void getDniTest() {
		assertEquals("11111111W",persona.getDni());
	}

	@Test 
	public void setDni(String dni) {
		persona.setDni("11111111W");
		assertEquals("11111111W", persona.getDni());
	}
	@Test
	public void getNombreTest() {
		assertEquals("Fernando",persona.getNombre());
	}

	@Test
	public void setNombreTest() {
		persona.setNombre("Fernando");
		assertEquals("Fernando",persona.getNombre());
	}
	@Test
	public void getMailTest() {
		assertEquals("Fernando@opendeusto.es",persona.getMail());
	}

	@Test
	public void setMail(String mail) {
		persona.setMail("Fernando@opendeusto.es");
		assertEquals("Fernando@opendeusto.es",persona.getMail());
	}

	@Test
	public void getTlfNumTest() {
		assertEquals("607354543",persona.getTlfNum());
	}

	@Test
	public void setTlfNum() {
		persona.setTlfNum("607354543");
		assertEquals("607354543",persona.getTlfNum());
	}

	@Test
	public void getEdadTest() {
		assertEquals(22,persona.getEdad());
	}

	public void setEdad(int edad) {
		persona.setEdad(23);
		assertEquals(23,persona.getEdad());
	}

	@Test
	public void getContrasenya() {
		assertEquals("Deusto24",persona.getContrasenya());
	}

	@Test
	public void setContrasenyaTest() {
		persona.setContrasenya("Deusto23");
		assertEquals("Deusto23",persona.getContrasenya());
	}

}
