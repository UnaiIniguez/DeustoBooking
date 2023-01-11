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
	
	
}
