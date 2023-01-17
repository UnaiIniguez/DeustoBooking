package Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class HuespedTest {
	
	private Huesped huesped;

	@Before
	public void setUp() {
		
	
		huesped = new Huesped("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", "Empresario","Eroski");
	}
	
	@Test 
	public void getCargoTest() {

		assertEquals( "Empresario", huesped.getCargo());
	}
	
	@Test 
	public void setcargoTest() {
		huesped.setCargo(huesped.getCargo());
		assertEquals( "Empresario",huesped.getCargo());
	}
	
	@Test 
	public void getNomEmpresaTest() {
		assertEquals( "Eroski", huesped.getNomEmpresa());
	}
	
	@Test 
	public void setNomEmpresaTest() {
		huesped.setNomEmpresa("Deusto");
		assertEquals ("Deusto", huesped.getNomEmpresa());
	}
	
	@Test
	public void getDniTest() {
		assertEquals("11111111J", huesped.getDni());
	}
	
	@Test
	public void setDniTest() {
		huesped.setDni("58050911W");
		assertEquals("58050911W", huesped.getDni());
	}
	
	@Test
	public void getNombreTest() {
		
		assertEquals("Andres", huesped.getNombre());
	}
	
	@Test
	public void setNombreTest() {
		huesped.setNombre("Javier");
		assertEquals("Javier", huesped.getNombre());
	}
	
	@Test
	public void getMailTest() {
		assertEquals("andres@opendeusto.es", huesped.getMail());
	}
	
	@Test
	public void setMailTest() {
		
		huesped.setMail("javier@gmail.com");
		assertEquals("javier@gmail.com", huesped.getMail());
	}
	
	@Test
	public void getTlfNumTest() {
		
		assertEquals("607343434", huesped.getTlfNum());
	}
	
	@Test
	public void setTlfNumTest() {
		huesped.setTlfNum("636480492");
		assertEquals("636480492", huesped.getTlfNum());
	
	}
	
	@Test
	public void getEdadTest() {
		
		assertEquals(32, huesped.getEdad());
		
	}
	
	@Test
	public void setEdadTest() {
		
		huesped.setEdad(33);
		assertEquals(33, huesped.getEdad());
		
	}
	
	@Test
	public void getContrasenyaTest() {
		assertEquals("Deusto24", huesped.getContrasenya());
	}
	
	@Test
	public void setContrasenyaTest() {
		
		huesped.setContrasenya("11111");
		assertEquals("11111", huesped.getContrasenya());
	}
	
	@Test
	public void equalsTest() {
		Huesped p = new Huesped("48930253Q", "Javier", 22, "javier@gmail.com", "252637282", "11111", "Informatico", "Microsoft");
		assertEquals(false, huesped.equals(p));
	
	}
	
	
	
}
