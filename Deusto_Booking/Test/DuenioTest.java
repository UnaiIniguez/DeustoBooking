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
	List<Inmueble> inmueble= new ArrayList<Inmueble>(); 
	duenio = new Duenio("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", inmueble);
	}
	
	@Test
	public void  getInmueblesTest() {
<<<<<<< HEAD
		duenio.getInmuebles();
=======
		ArrayList<Inmueble> inmueble = new ArrayList<Inmueble>(); 
		//duenio.getInmuebles();
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	}
	
	@Test 
	public void setInmuebleTest() {
<<<<<<< HEAD
		List<Inmueble> inmueble= new ArrayList<Inmueble>(); 
		duenio.setInmueble(duenio.getInmuebles());
		assertEquals(inmueble, duenio.getInmuebles());
=======
		ArrayList<Inmueble> inmueble = new ArrayList<Inmueble>(); 
		
		//duenio.setInmueble(inmueble);
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	}
	
	@Test 
	public void getDniTest() {
		assertEquals("11111111J",duenio.getDni());
	}

	@Test 
	public void setDni() {
		duenio.setDni( duenio.getDni());
		assertEquals("11111111J", duenio.getDni());
	}
	@Test
	public void getNombreTest() {
		assertEquals("Andres",duenio.getNombre());
	}

	@Test
	public void setNombreTest() {
		duenio.setNombre(duenio.getNombre());
		assertEquals("Andres",duenio.getNombre());
	}
	@Test
	public void getMailTest() {
		assertEquals("andres@opendeusto.es",duenio.getMail());
	}

	@Test
	public void setMail() {
		duenio.setMail(duenio.getMail());
		assertEquals("andres@opendeusto.es",duenio.getMail());
	}

	@Test
	public void getTlfNumTest() {
		assertEquals("607343434",duenio.getTlfNum());
	}

	@Test
	public void setTlfNum() {
		duenio.setTlfNum(duenio.getTlfNum());
		assertEquals("607343434",duenio.getTlfNum());
	}

	@Test
	public void getEdadTest() {
		assertEquals( 32,duenio.getEdad());
	}
	
	@Test
	public void setEdad() {
		duenio.setEdad(duenio.getEdad());
		assertEquals(32,duenio.getEdad());
	}

	@Test
	public void getContrasenya() {
		assertEquals("Deusto24",duenio.getContrasenya());
	}

	@Test
	public void setContrasenyaTest() {
		duenio.setContrasenya(duenio.getContrasenya());
		assertEquals("Deusto24",duenio.getContrasenya());
	}

	
	
	
	
}
