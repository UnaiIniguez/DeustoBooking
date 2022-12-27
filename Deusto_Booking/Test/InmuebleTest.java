import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class InmuebleTest {

	private Inmueble i;

	
	@Before
	public void setUp() {
		ArrayList<Inmueble> inmueble= new ArrayList<Inmueble>(); 
		i = new Inmueble(new Duenio("58050922A","Javier",0, "Javier@gmail.com","62660030327","perro23",inmueble), "Blas de Otero 58", TipoVivienda.PISO, 100f, 1, 3, 3,45f);
		
	}
	
	
	@Test 
	public void testGetOcupado() {
		assertEquals(false, i.getOcupado());
	}
	
	@Test
	public void testSetOcupado() {
		i.setOcupado(i.getOcupado());
		assertEquals(false, i.getOcupado());
	}
	@Test
	public void testGetHuesped() {
		assertEquals(null,i.getHuesped());
	}
	@Test
	public void testSetHuesped() {
		i.setHuesped(i.getHuesped());
		assertEquals(null, i.getHuesped());	
	}
	@Test
	public void testGetNumHab() {
		assertEquals(3, i.getNumHab());
	}
	@Test
	public void testSetNumHab() {
		i.setNumHab(i.getNumHab());
		assertEquals(3, i.getNumHab());
	}
	@Test
	public void testGetNumBany() {
		assertEquals(1, i.getNumBany());
	}
	@Test
	public void testSetNumBany() {
		i.setNumBany( i.getNumBany());
		assertEquals(1, i.getNumBany());
	}
	@Test
	public void testGetMaxHuespedes() {
		assertEquals(3, i.getMaxHuespedes());
	}
	@Test
	public void testSetMaxHuespedes() {
		i.setMaxHuespedes(i.getMaxHuespedes());
		assertEquals(3,i.getMaxHuespedes());
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
		i.setPrecioNoche(i.getPrecioNoche());
		assertEquals(45f,i.getPrecioNoche(),0.1f);
	}
	
}
