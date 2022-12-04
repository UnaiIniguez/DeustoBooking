import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Inmueble;

public class DuenioTest {
	
	private Duenio duenio;
	
	
	@Test
	public void  getInmueblesTest() {
		ArrayList<Inmueble> inmueble = new ArrayList<Inmueble>(); 
		duenio.getInmuebles();
	}
	
	@Test 
	public void setInmuebleTest() {
		ArrayList<Inmueble> inmueble = new ArrayList<Inmueble>(); 
		
		duenio.setInmueble(inmueble);
	}
	
	
	

	
	
	
	
}
