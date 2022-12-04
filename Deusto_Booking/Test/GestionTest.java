import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;

public class GestionTest {
	
	private Gestor gestor;
	
	
	
	@Before
	public void setUp() {
		
		gestor = new Gestor();
		
		gestor.datosTest();
		
		HashMap<String, ArrayList<Inmueble>> inmueblePru = new HashMap<>();
		inmueblePru.put( "String", new ArrayList<Inmueble>());
		
	}

	@Test
	public void anadirInmueblePersonaTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		gestor.anadirInmueble( d, i );
		assertEquals( i, d.getInmuebles().get(0) );//Comparo si el inmueble de test con el que he introducido
		
	}
	
	@Test
	public void borrarInmuebleTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		gestor.borrarInmueble( d , i);
		assertEquals( null, null);
	}
	
	
	@Test 
	public void editarInmuebleTest() {
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble inmuebleviejo = new Inmueble(d, "Bilbao", null, 0, 0, 0, 0, 0);
		Inmueble nuevoInmueble = new Inmueble(d, "Getxo", null, 0, 0, 0, 0, 0);
		gestor.editarInmueble(d, inmuebleviejo, nuevoInmueble);
	}
	
	/*
	@Test 
	public void anularReservaTest(){
		Huesped h = new Huesped("1405809J", "Fernando", 19, "fernando@opendeusto.es", "608111111", "Deusto24", "Estudiante", null);
		Inmueble i= new Inmueble(h, "Getxo", null, 0, 0, 0, 0, 0);
		gestor.anularReserva(h, in);
	
		
	}
	
	
	@Test
	public void reservarTest() {
		Huesped h = new Huesped("1405809J", "Fernando", 19, "fernando@opendeusto.es", "608111111", "Deusto24", "Estudiante", null);
		Inmueble i = new Inmueble(h, "Getxo", null, 0, 0, 0, 0, 0);
		gestor.reservar(h, i);
	}
	*/	
	@Test 
	public void iniciarSesionDBTest() {
		String dni = "1405809J";
		String contrasenya = "Deusto22";
		gestor.iniciarSesionDB(dni, contrasenya);
	
	}
	
	
	
	
	@Test 
	public void registroHuespedTest() {
		Huesped h = new Huesped("1405809J", "Fernando", 19, "fernando@opendeusto.es", "608111111", "Deusto24", "Estudiante", null);
		gestor.registroHuesped(null, null, 0, null, null, null, null, null);
	}

	
}
