package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Reserva;

public class ReservaTest {

	Reserva r;
	Reserva r2;
	
	@Before
	public void setUp() {
		 r = new Reserva(0, 0, null, null, "00000000A");
		 r2 = new Reserva(1, 0, null, null, "00000000A");
		
		
	}
	
	@Test
	public void testGetId_Reserva() {
	    assertEquals(0, r.getId_Reserva());
	}
	
	@Test
	public void testGetId_Inmueble() {
	    assertEquals(0, r.getId_Inmueble());
	}
	
	@Test
	public void testGetFecha_Entrada() {
	    assertEquals(null, r.getFecha_Entrada());
	}
	
	@Test
	public void testSetFecha_Entrada() {
		r.setFecha_Entrada(null);
	    assertEquals(null, r.getFecha_Entrada());
	}
	
	@Test
	public void testGetFecha_Salida() {
	    assertEquals(null, r.getFecha_Salida());
	}
	
	
	@Test
	public void testSetFecha_Salida() {
		r.setFecha_Salida(null);
	    assertEquals(null, r.getFecha_Salida());
	}
	
	
	@Test
	public void testGetDni_Huesped() {
	    assertEquals("00000000A", r.getDni_Huesped());
	}
	
	@Test
	public void testSetDni_Huesped() {
		r.setDni_Huesped("11111111Z");
	    assertEquals("11111111Z", r.getDni_Huesped());
	}
	
	@Test
	public void testToString() {
	    assertEquals("Reserva [id de la reserva =" + r.getId_Reserva() + ", la fecha de entrada será=" + r.getFecha_Entrada() + " y la fecha de salida será =" + r.getFecha_Salida()
				 + "]", r.toString());
	}
	
	@Test
	public void testEquals() {
	    assertFalse(r.equals(r2));
	}
	
}
