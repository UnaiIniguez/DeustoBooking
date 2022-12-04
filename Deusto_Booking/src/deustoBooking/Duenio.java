package deustoBooking;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;
	private List<Inmueble> inmueble = new ArrayList<>();

	public Duenio(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya,
			List<Inmueble> inmueble) {
		super(dni, nombre, edad, mail, tlfNum, contrasenya);
		this.inmueble = inmueble;
	}

	public List<Inmueble> getInmuebles() {
		return inmueble;
	}

	public void setInmueble(ArrayList<Inmueble> inmueble) {
		this.inmueble = inmueble;
	}
	
	
	

}