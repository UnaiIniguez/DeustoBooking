import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;

public class HuespedTest {

	private Huesped huesped;
	
	@Test 
	public void getCargoTest() {
		assertEquals( "Empresario", huesped.getCargo());
	}
	
	@Test 
	public void setcargoTest() {
		huesped.setCargo("Empresario");
		assertEquals( "Empresario",huesped.getCargo());
	}
	
	@Test 
	public void getNomEmpresaTest() {
		assertEquals( "Deusto", huesped.getCargo());
	}
	
	@Test 
	public void setNomEmpresaTest() {
		huesped.setNomEmpresa("Deusto");
		assertEquals ("Deusto", huesped.getNomEmpresa());
	}
	
	
}
