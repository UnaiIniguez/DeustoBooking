package Test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class InmuebleTest {

	Inmueble inmueble;
	@Before
	public void setUp() {
		 inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		
		
	}
	
	
	
 @Test
   public  void testGetDni_Duenio() {
       
        assertEquals("12345678A", inmueble.getDni_Duenio());
    }
 
	    @Test
   public  void testSetDni_Duenio() {
        
        inmueble.setDni_Duenio("87654321B");
        assertEquals("87654321B", inmueble.getDni_Duenio());
    }
	    
 	    
	@Test
    public void testGetId_Inmueble() {
       
        assertEquals(1, inmueble.getId_Inmueble());
    }
 
 
 @Test
    public void testSetId_Inmueble() {
        
        inmueble.setId_Inmueble(2);
        assertEquals(2, inmueble.getId_Inmueble());
    }
	    


	   @Test
    public void testGetImagenes() {
		   
        List<Blob> imagenes = new ArrayList<>();
        assertEquals(imagenes, inmueble.getImagenes());
    } 
	   
	   
	 
	@Test 
	public void testGetOcupado() {
       
        inmueble.setOcupado(1);
		assertEquals(1, inmueble.getOcupado());
	}
	
	

	@Test
	public void testGetHuesped() {
        
		assertEquals(4,inmueble.getMaxHuespedes());
	}
	@Test
	public void testSetHuesped() {
        
        inmueble.setMaxHuespedes(4);
		assertEquals(4, inmueble.getMaxHuespedes());	
	}
	
	
	@Test
	public void testGetNumHab() {
        
		assertEquals(2, inmueble.getNumHab());
	}
	@Test
	public void testSetNumHab() {
       
		inmueble.setNumHab(3);
		assertEquals(3, inmueble.getNumHab());
	}
	
	
	@Test
	public void testGetNumBany() {
        
		assertEquals(1, inmueble.getNumBany());
	}
	@Test
	public void testSetNumBany() {
        
		inmueble.setNumBany(1);
		assertEquals(1, inmueble.getNumBany());
	}
	
	
	@Test
	public void testGetMaxHuespedes() {
        
		assertEquals(4, inmueble.getMaxHuespedes());
	}
	@Test
	public void testSetMaxHuespedes() {
        
		inmueble.setMaxHuespedes(5);
		assertEquals(5,inmueble.getMaxHuespedes());
	}
	

	@Test
	public void testGetMetrosCuadrados() {
       
		assertEquals(60f,(float) inmueble.getMetrosCuadrados(),0.01f);
	}

	@Test
	public void testGetUbicacion() {
        
		assertEquals("Spain/Pais Vasco/Bilbao",inmueble.getUbicacion());
	}
	@Test
	public void testGetTipo() {
        
		assertEquals(TipoVivienda.ADOSADO,inmueble.getTipo());
	}
	@Test
	public void testGetPrecioNoche() {
        
		assertEquals(50f,inmueble.getPrecioNoche(),0.1f);
	}
	@Test
	public void testSetPrecioNoche() {
        
		inmueble.setPrecioNoche(inmueble.getPrecioNoche());
		assertEquals(50f,inmueble.getPrecioNoche(),0.1f);
	}
	
}
