package deustoBooking;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;
	private String cargo;

	public Duenio(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya, String cargo,
			List<Inmueble> inmueble) {
		super(dni, nombre, edad, mail, tlfNum, contrasenya);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

}