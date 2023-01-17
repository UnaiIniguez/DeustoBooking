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
    public void testGetImagenes() {
        List<Blob> imagenes = new ArrayList<>();
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, imagenes);
        List<Blob> esperado = imagenes;
        List<Blob> result = inmueble.getImagenes();
        assertEquals(esperado, result);
    } 
	   
	   
	 
	@Test 
	public void testGetOcupado() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        inmueble.setOcupado(1);
		assertEquals(1, inmueble.getOcupado());
	}
	
	

	@Test
	public void testGetHuesped() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(4,inmueble.getMaxHuespedes());
	}
	@Test
	public void testSetHuesped() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
        inmueble.setMaxHuespedes(4);
		assertEquals(4, inmueble.getMaxHuespedes());	
	}
	
	
	@Test
	public void testGetNumHab() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(2, inmueble.getNumHab());
	}
	@Test
	public void testSetNumHab() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		inmueble.setNumHab(3);
		assertEquals(3, inmueble.getNumHab());
	}
	
	
	@Test
	public void testGetNumBany() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(1, inmueble.getNumBany());
	}
	@Test
	public void testSetNumBany() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		inmueble.setNumBany(1);
		assertEquals(1, inmueble.getNumBany());
	}
	
	
	@Test
	public void testGetMaxHuespedes() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(4, inmueble.getMaxHuespedes());
	}
	@Test
	public void testSetMaxHuespedes() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		inmueble.setMaxHuespedes(5);
		assertEquals(5,inmueble.getMaxHuespedes());
	}
	

	@Test
	public void testGetMetrosCuadrados() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(60f,(float) inmueble.getMetrosCuadrados(),0.01f);
	}

	@Test
	public void testGetUbicacion() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals("Spain/Pais Vasco/Bilbao",inmueble.getUbicacion());
	}
	@Test
	public void testGetTipo() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(TipoVivienda.ADOSADO,inmueble.getTipo());
	}
	@Test
	public void testGetPrecioNoche() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		assertEquals(50f,inmueble.getPrecioNoche(),0.1f);
	}
	@Test
	public void testSetPrecioNoche() {
        Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0, null);
		inmueble.setPrecioNoche(inmueble.getPrecioNoche());
		assertEquals(50f,inmueble.getPrecioNoche(),0.1f);
	}
	
}
