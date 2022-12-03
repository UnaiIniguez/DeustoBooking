import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class InmuebleTest {

	private Inmueble i;
	
	@Before
	public void setUp() {
		i = new Inmueble(new Duenio("58050922A","Javier","Javier@gmail.com","62660030327","perro23",new ArrayList<Inmueble>()), "Blas de Otero 58", TipoVivienda.PISO, 100f, 1, 3, 3,45f);
	}
	
	
	@Test 
	public void testGetOcupado() {
		assertEquals(false, i.getOcupado());
	}
	
	@Test
	public void testSetOcupado() {
		i.setOcupado(true);
		assertEquals(true, i.getOcupado());
	}
	@Test
	public void testGetHuesped() {
		i.setHuesped("58033622J");
		assertEquals("58033622J",i.getHuesped());
	}
	@Test
	public void testSetHuesped() {
		i.setHuesped("58033622A");
		assertEquals("58033622A", i.getHuesped());	
	}
	@Test
	public void testGetNumHab() {
		assertEquals(3, i.getNumHab());
	}
	@Test
	public void testSetNumHab() {
		i.setNumHab(4);
		assertEquals(4, i.getNumHab());
	}
	@Test
	public void testGetNumBany() {
		assertEquals(1, i.getNumBany());
	}
	@Test
	public void testSetNumBany() {
		i.setNumBany(4);
		assertEquals(4, i.getNumBany());
	}
	@Test
	public void testGetMaxHuespedes() {
		assertEquals(3, i.getMaxHuespedes());
	}
	@Test
	public void testSetMaxHuespedes() {
		i.setMaxHuespedes(4);
		assertEquals(4,i.getMaxHuespedes());
	}
	@Test
	public void testGetMetrosCuadrados() {
		assertEquals(100f,(float) i.getMetrosCuadrados(),0.01f);
	}
	

	@Test
	public void testGetUbicacion() {
		assertEquals("Blas de Otero 58",i.getUbicacion());
	}
	@Test
	public void testGetTipo() {
		assertEquals(TipoVivienda.PISO,i.getTipo());
	}
	@Test
	public void testGetPrecioNoche() {
		assertEquals(45f,i.getPrecioNoche(),0.1f);
	}
	@Test
	public void testSetPrecioNoche() {
		i.setPrecioNoche(40f);
		assertEquals(40f,i.getPrecioNoche(),0.1f);
	}
	
}
