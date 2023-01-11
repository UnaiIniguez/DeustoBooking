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

	private Inmueble i;

	
	@Before
	public void setUp() {
	}
	
	
	
 @Test
   public  void testGetDni_Duenio() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        String esperado = "12345678A";
        String result = inmueble.getDni_Duenio();
        assertEquals(esperado, result);
    }
 
	    @Test
   public  void testSetDni_Duenio() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        inmueble.setDni_Duenio("87654321B");
        String esperado = "87654321B";
        String result = inmueble.getDni_Duenio();
        assertEquals(esperado, result);
    }
	    
 	    
	@Test
    public void testGetId_Inmueble() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        int esperado = 1;
        int result = inmueble.getId_Inmueble();
        assertEquals(esperado, result);
    }
 
 
 @Test
    public void testSetId_Inmueble() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        inmueble.setId_Inmueble(2);
        int esperado = 2;
        int result = inmueble.getId_Inmueble();
        assertEquals(esperado, result);
    }
	    


	   @Test
    void testGetImagenes() {
        List<Blob> imagenes = new ArrayList<>();
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, imagenes);
        List<Blob> esperado = imagenes;
        List<Blob> result = inmueble.getImagenes();
        assertEquals(esperado, result);
    } 
	   
	   
	 
	@Test 
	public void testGetOcupado() {
		assertEquals(false, i.getOcupado());
	}
	
	

	@Test
	public void testGetHuesped() {
		assertEquals(4,i.getMaxHuespedes());
	}
	@Test
	public void testSetHuesped() {
		i.setMaxHuespedes(i.getMaxHuespedes());
		assertEquals(4, i.getMaxHuespedes());	
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
