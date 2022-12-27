package deustoBooking;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private List<Inmueble> inmueble = new ArrayList<Inmueble>();
=======
	private String cargo;
	
	public Duenio() {
		
	}
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git

	public Duenio(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya, String cargo) {
		super(dni, nombre, edad, mail, tlfNum, contrasenya);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

<<<<<<< HEAD
	public void setInmueble(List<Inmueble> inmueble) {
		this.inmueble = inmueble;
=======
	public void setCargo(String cargo) {
		this.cargo = cargo;
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	}
	
	@Override
	public String toString() {
		
		return super.getNombre()+" "+super.getDni();
	}
	

}