package DeustoBooking;

public class Huesped extends Persona {

	private static final long serialVersionUID = 1L;
	// Solvencia economica demostrable
	private Boolean solvencia;

	public Huesped(int dni, String nombre, String mail, int tlfNum, int contrasenya, Boolean solvencia) {
		super(dni, nombre, mail, tlfNum, contrasenya);
		this.solvencia = solvencia;
	}

}
