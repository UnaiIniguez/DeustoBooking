package DeustoBooking;

import java.util.ArrayList;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;
	private ArrayList<Inmueble> inmueble = new ArrayList<>();

	public Duenio(int dni, String nombre, String mail, int tlfNum, int contrasenya, ArrayList<Inmueble> inmueble) {
		super(dni, nombre, mail, tlfNum, contrasenya);
		this.inmueble = inmueble;
	}

	public ArrayList<Inmueble> getInmueble() {
		return inmueble;
	}

	public void setInmueble(ArrayList<Inmueble> inmueble) {
		this.inmueble = inmueble;
	}
	
	
	

}