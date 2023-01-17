package Test;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.Reserva;
import deustoBooking.TipoVivienda;

public class GestionTest {

	private Gestor gestor;
	private Duenio duenio;
	private Inmueble i;
	private Huesped huesped;

	@Before
	public void setUp() {
		ArrayList<Inmueble> inmueble = new ArrayList<Inmueble>();
		
		duenio = new Duenio("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", "dueño");		
		i = new Inmueble(123456, "11111111J", "Blas de Otero 58", TipoVivienda.PISO, 100f, 1, 3, 3, 45f, 0, null);		
		huesped = new Huesped("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", "Empresario", "Eroski");

		gestor = new Gestor();
		gestor.datosTest();

		//HashMap<String, ArrayList<Inmueble>> inmueblePru = new HashMap<>();
		//inmueblePru.put("String", new ArrayList<Inmueble>());
	}

	@Test
	public void testGetPropietarios() {
		Gestor g = new Gestor();
		Set<Duenio> propietarios = new HashSet<>();
		Duenio d1 = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", "Jefe");
		Duenio d2 = new Duenio("87654321C", "Juan", 35, "juan@gmail.com", "659872135", "5678", "Empleado");
		propietarios.add(d1);
		propietarios.add(d2);
		g.setPropietarios(propietarios);

		assertEquals(propietarios, g.getPropietarios());

		//assertNotSame(propietarios, g.getPropietarios());
	}

	@Test
	public void testSetPropietarios() {
		Gestor g = new Gestor();
		Set<Duenio> propietarios = new HashSet<>();
		Duenio d1 = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", "Jefe");
		Duenio d2 = new Duenio("87654321C", "Juan", 35, "juan@gmail.com", "659872135", "5678", "Empleado");
		propietarios.add(d1);
		propietarios.add(d2);
		g.setPropietarios(propietarios);

		assertEquals(propietarios, g.getPropietarios());
	}

	@Test
	public void testGetInmuebles() {
		Gestor g = new Gestor();
		Set<Inmueble> inmuebles = new TreeSet<>();
		Inmueble i1 = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0,
				null);
		Inmueble i2 = new Inmueble(2, "87654321B", "Spain/Catalunia/Barcelona", TipoVivienda.PISO, 75, 2, 3, 6, 70, 0,
				null);
		Inmueble i3 = new Inmueble(3, "98765432C", "Spain/Galicia/Santiago de Compostela", TipoVivienda.CHALET, 90, 3,
				4, 8, 100, 0, null);
		inmuebles.add(i1);
		inmuebles.add(i2);
		inmuebles.add(i3);
		g.setInmuebles(inmuebles);

		assertEquals(inmuebles, g.getInmuebles());

		//assertNotSame(inmuebles, g.getInmuebles());
	}

	@Test
	public void testSetInmuebles() {
		Gestor g = new Gestor();
		Set<Inmueble> inmuebles = new TreeSet<>();
		Inmueble i1 = new Inmueble(1, "12345678A", "Spain/Pais Vasco/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50, 0,
				null);
		Inmueble i2 = new Inmueble(2, "87654321B", "Spain/Catalunia/Barcelona", TipoVivienda.PISO, 75, 2, 3, 6, 70, 0,
				null);
		Inmueble i3 = new Inmueble(3, "98765432C", "Spain/Galicia/Santiago de Compostela", TipoVivienda.CHALET, 90, 3,
				4, 8, 100, 0, null);
		inmuebles.add(i1);
		inmuebles.add(i2);
		inmuebles.add(i3);

		g.setInmuebles(inmuebles);
		assertEquals(inmuebles, g.getInmuebles());

		inmuebles.remove(i1);
		g.setInmuebles(inmuebles);
		assertEquals(inmuebles, g.getInmuebles());

	}

	@Before
    public void setup() {
        gestor = new Gestor();
        huesped = new Huesped("12345678B", "Juan", 25, "juan@gmail.com", "666777888", "1234", "Manager", "Google");
    }
	
	
	
    @Test
    public void testAddHuesped() {
        // Adding the huesped to the huespedes map
        //((Object) gestor).addHuesped(huesped);
    	//gestor.registroHuesped("12345678B", "Juan", 25, "juan@gmail.com", "666777888", "1234", "Manager", "Google");
    	gestor.reservar(huesped, new Reserva(1, 1, new Date(2020, 10, 1), new Date(2020, 10, 5), "12345678A"));
        // Get the Map containing the huesped's reservas
        Map<String, ArrayList<Reserva>> reservas = gestor.getHuespedes();
        // Assert that the map contain the huesped's DNI as key 
        assertTrue(reservas.containsKey(huesped.getDni()));
    }
    
    
    
    

	@Test
	public void testIsChangedP() {
		Gestor g = new Gestor();

		assertFalse(g.isChangedP());
		g.setChangedP(true);
		assertTrue(g.isChangedP());
		g.setChangedP(false);
		assertFalse(g.isChangedP());

		g.setChangedP(true);
		assertTrue(g.isChangedP());
		g.setChangedP(false);
		assertFalse(g.isChangedP());

	}

	@Test
	public void testSetChangedP() {
		Gestor g = new Gestor();

		g.setChangedP(true);
		assertTrue(g.isChangedP());
		g.setChangedP(false);
		assertFalse(g.isChangedP());

		g.setChangedP(true);
		assertTrue(g.isChangedP());
		g.setChangedP(false);
		assertFalse(g.isChangedP());

	}

	@Test

	public void testIsChangedI() {
		Gestor g = new Gestor();

		assertFalse(g.isChangedI());
		g.setChangedI(true);
		assertTrue(g.isChangedI());
		g.setChangedI(false);
		assertFalse(g.isChangedI());

		g.setChangedI(true);
		assertTrue(g.isChangedI());
		g.setChangedI(false);
		assertFalse(g.isChangedI());

	}

	@Test
	public void testSetChangedI() {
		Gestor g = new Gestor();

		g.setChangedI(true);
		assertTrue(g.isChangedI());
		g.setChangedI(false);
		assertFalse(g.isChangedI());

		g.setChangedI(true);
		assertTrue(g.isChangedI());
		g.setChangedI(false);
		assertFalse(g.isChangedI());

	}

	@Test

	public void testGetReservas() {
		Gestor gestor = new Gestor();
		Reserva r1 = new Reserva(1, 1, new Date(2020, 10, 1), new Date(2020, 10, 5), "12345678A");
		Reserva r2 = new Reserva(2, 2, new Date(2020, 11, 1), new Date(2020, 11, 5), "12345678A");
		Map<String, ArrayList<Reserva>> reservas = new HashMap<>();
		ArrayList<Reserva> listaReservas = new ArrayList<>();
		listaReservas.add(r1);
		listaReservas.add(r2);
		reservas.put("12345678A", listaReservas);

		gestor.setReservas(reservas);
		// Creamos un gestor y añadimos las reservas que queremos probar
		listaReservas.add(r1);
		listaReservas.add(r2);
		reservas.put("12345678A", listaReservas);
		gestor.setReservas(reservas);

	}

	@Test
	public void testGetConectar() {
		Gestor g = new Gestor();
		Connection conectar = g.getConectar();
		assertNotNull(conectar);
	}

	@Test
	public void testIniSesion() {
		Gestor g = new Gestor();
		Duenio d1 = new Duenio("12345678B", "Pepe", 77, "pepe@gmail.com", "656232359", "1234", "Jefe");
		Duenio d2 = new Duenio("87654321C", "Juan", 35, "juan@gmail.com", "659872135", "5678", "Empleado");
		g.getPropietarios().add(d1);
		g.getPropietarios().add(d2);

		boolean result = g.iniSesion("12345678B", "1234");
		assertTrue(result);

		result = g.iniSesion("12345678B", "5678");
		assertFalse(result);

		result = g.iniSesion("98765432D", "5678");
		assertFalse(result);

		result = g.iniSesion(null, "5678");
		assertFalse(result);

		result = g.iniSesion("12345678B", null);
		assertFalse(result);
	}
	

	@Test
	public void testAnadirInmueble() {
		// Crear un nuevo gestor y añadir algunos inmuebles
		Gestor g = new Gestor();
		Inmueble i1 = new Inmueble(1, "12345678A", "Spain/Basque Country/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50,
				0, null);
		Inmueble i2 = new Inmueble(2, "87654321B", "Spain/Catalonia/Barcelona", TipoVivienda.PISO, 75, 2, 3, 6, 70, 0,
				null);
		g.anadirInmueble(i1);
		g.anadirInmueble(i2);

		// Comprobar que los inmuebles se han añadido correctamente
		assertEquals(3, g.getInmuebles().size());
		assertTrue(g.getInmuebles().contains(i1));
		assertTrue(g.getInmuebles().contains(i2));

		// Añadir un inmueble nuevo
		Inmueble i3 = new Inmueble(3, "87654321D", "Spain/Catalonia/Barcelona", TipoVivienda.PISO, 100, 3, 2, 6, 90, 0, null);
		g.anadirInmueble(i3);

		// Comprobar que el inmueble se ha añadido correctamente
		assertEquals(3, g.getInmuebles().size());

		g.eliminarInmueble(i1);
		g.eliminarInmueble(i2);
		g.eliminarInmueble(i3);
	}
	

	
    public void setUp1() {
        gestor = new Gestor();
        
        Inmueble inmueble1 = new Inmueble(2, "87654321B", "Spain/Catalonia/Barcelona", TipoVivienda.PISO, 75, 2, 3, 6, 70, 0,
				null);
        Inmueble inmueble2 = new Inmueble(1, "12345678A", "Spain/Basque Country/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2, 4, 50,
				0, null);
        Inmueble inmueble3 = new Inmueble(3, "87654321D", "Spain/Catalonia/Barcelona", TipoVivienda.CHALET, 100, 3, 2, 6, 90, 0, null);
        gestor.getInmuebles().add(inmueble1);
        gestor.getInmuebles().add(inmueble2);
        gestor.getInmuebles().add(inmueble3);
    }

    @Test
    public void testEliminarInmueble() {
        //gestor.eliminarInmueble(3);
        Set<Inmueble> inmuebles = gestor.getInmuebles();
        //assertFalse(inmuebles.contains(inmueble2 ));
        //assertTrue(inmuebles.contains(inmueble1));
        //assertTrue(inmuebles.contains(inmueble3));
    }
	
   
	
	@Test
	public void testEditarNumBanInmueble() {
		Gestor g = new Gestor();
		Inmueble inmueble = new Inmueble(1, "12345678A", "Spain/Basque Country/Bilbao", TipoVivienda.ADOSADO, 60, 1, 2,
				3, 50, 0, null);
		g.anadirInmueble(inmueble);
		assertEquals(1, inmueble.getNumBany());

		g.editarNumBanInmueble(inmueble, 4);
		assertEquals(4, inmueble.getNumBany());
	}

	@Test
	public void anularReservaTest() {
		// gestor.anularReserva(huesped, i);

	}

	@Test
	public void reservarTest() {
		//gestor.reservar(huesped, i);
	}

	@Test
	public void registroHuespedTest() {
		Huesped h = new Huesped("1405809J", "Fernando", 19, "fernando@opendeusto.es", "608111111", "Deusto24",
				"Estudiante", null);
		gestor.registroHuesped(null, null, 0, null, null, null, null, null);
	}

}
