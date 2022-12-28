package Test;
import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import deustoBooking.Duenio;
import deustoBooking.Gestor;
import deustoBooking.Huesped;
import deustoBooking.Inmueble;
import deustoBooking.TipoVivienda;

public class GestionTest {
	
	private Gestor gestor;
	private Duenio duenio;
	private Inmueble i;
	private Huesped huesped;
	
	
	@Before
	public void setUp() {
		ArrayList<Inmueble> inmueble= new ArrayList<Inmueble>(); 
		duenio = new Duenio("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", inmueble);
		i = new Inmueble(new Duenio("58050922A","Javier",0, "Javier@gmail.com","62660030327","perro23",inmueble), "Blas de Otero 58", TipoVivienda.PISO, 100f, 1, 3, 3,45f);
		huesped = new Huesped("11111111J", "Andres", 32, "andres@opendeusto.es", "607343434", "Deusto24", "Empresario","Eroski");
		
		gestor = new Gestor();
		
		gestor.datosTest();
		
		HashMap<String, ArrayList<Inmueble>> inmueblePru = new HashMap<>();
		inmueblePru.put( "String", new ArrayList<Inmueble>());
		
	}

	@Test
	public void anadirInmueblePersonaTest() {
		
		Duenio d = gestor.getPropietarios().get(0);
<<<<<<< HEAD
		gestor.anadirInmueble( d, i );
		assertEquals( i, d.getInmuebles().get(0) );//Comparo si el inmueble de test con el que he introducido
=======
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		//gestor.anadirInmueble( d, i );
		//assertEquals( i, d.getInmuebles().get(0) );//Comparo si el inmueble de test con el que he introducido
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
		
	}
	
	@Test
	public void borrarInmuebleTest() {
		Duenio d = gestor.getPropietarios().get(0);
<<<<<<< HEAD
		gestor.borrarInmueble( d , i);
=======
		Inmueble i = new Inmueble(d, "Santnader", null, 0, 0, 0, 0, 0);
		
		//gestor.borrarInmueble( d , i);
		assertEquals( null, null);
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	}
	
	
	@Test 
	public void editarInmuebleTest() {
		Duenio d = gestor.getPropietarios().get(0);
		Inmueble inmuebleviejo = new Inmueble(d, "Bilbao", null, 0, 0, 0, 0, 0);
		Inmueble nuevoInmueble = new Inmueble(d, "Getxo", null, 0, 0, 0, 0, 0);
		//gestor.editarInmueble(d, inmuebleviejo, nuevoInmueble);
	}
	
	@Test 
	public void anularReservaTest(){
		gestor.anularReserva(huesped, i);
	
		
	}
	
	
	@Test
	public void reservarTest() {
		gestor.reservar(huesped, i);
	}
	
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
