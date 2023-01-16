package deustoBooking;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

	private static final long serialVersionUID = 1L;

	

	private String cargo;
	
	public Duenio() {
		
	}

	public Duenio(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya, String cargo) {
		super(dni, nombre, edad, mail, tlfNum, contrasenya);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

		
	public void setCargo(String cargo) {
		this.cargo = cargo;

	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		Duenio other_d = (Duenio) other;
		return this.getDni().equals(other_d.getDni());
	}
	
	@Override
	public String toString() {
		
		return super.getNombre()+" "+super.getDni();
	}
	

}