package deustoBooking;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;
	private List<Inmueble> inmueble = new ArrayList<>();

	public Duenio(int dni, String nombre, String mail, String tlfNum, String contrasenya, ArrayList<Inmueble> inmueble) {
		super(dni, nombre, mail, tlfNum, contrasenya);
		this.inmueble = inmueble;
	}

	public List<Inmueble> getInmuebles() {
		return inmueble;
	}

	public void setInmueble(ArrayList<Inmueble> inmueble) {
		this.inmueble = inmueble;
	}
	
	
	

}