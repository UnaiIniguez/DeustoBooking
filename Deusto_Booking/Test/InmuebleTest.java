import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DeustoBooking.Duenio;
import DeustoBooking.Inmueble;
import DeustoBooking.TipoVivienda;

public class InmuebleTest {

	private Inmueble i;
	
	@Before
	public void setUp() {
		i = new Inmueble(new Duenio(58050922,"Javier","Javier@gmail.com","62660030327","perro23",new ArrayList()), "Blas de Otero 58", TipoVivienda.PISO, 100f, 2, 3, 3,45f);
	}
	
	
	@Test 
	public void testGetOcupado() {
		assertEquals(false, i.getOcupado());
	}
	
	public void testSetOcupado() {
		i.setOcupado(true);
		assertEquals(true, i.getOcupado());
	}
	
	public void testGetHuesped() {
		i.setHuesped("58033622J");
		assertEquals("58033622J",i.getHuesped());
	}
	
	public void testSetHuesped() {
		i.setHuesped("58033622A");
		assertEquals("58033622A", i.getHuesped());	
	}
	
	public void testGetNumHab() {
		assertEquals(3, i.getNumHab());
	}
	
	public void testSetNumHab() {
		i.setNumHab(4);
		assertEquals(4, i.getNumHab());
	}
	
	public void testGetNumBany() {
		assertEquals(1, i.getNumBany());
	}
	
	public void testSetNumBany() {
		i.setNumBany(4);
		assertEquals(4, i.getNumBany());
	}
	
	public void testGetMaxHuespedes() {
		assertEquals(3, i.getMaxHuespedes());
	}
	
	public void testSetMaxHuespedes() {
		i.setMaxHuespedes(4);
		assertEquals(4,i.getMaxHuespedes());
	}
	
	public void testGetMetrosCuadrados() {
		assertEquals(100f,(float) i.getMetrosCuadrados(),0.01f);
	}
	
//	public void testGetDuenio() {
//		assertEquals()						
//	}
	
	public void testGetUbicacion() {
		assertEquals("Blas de Otero 58",i.getUbicacion());
	}
	
	public void testGetTipo() {
		assertEquals(TipoVivienda.PISO,i.getTipo());
	}

	public void testGetPrecioNoche() {
		assertEquals(45f,i.getPrecioNoche(),0.1f);
	}
	
	public void testSetPrecioNoche() {
		i.setPrecioNoche(40f);
		assertEquals(40f,i.getPrecioNoche(),0.1f);
	}
	
}
