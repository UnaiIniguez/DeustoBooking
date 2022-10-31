package DeustoBooking;

public class Huesped extends Persona {


	// Puesto de trabajo actual
	private String cargo;
	//Empresa en la que trabaja
	private String nomEmpresa;
	
	private static final long serialVersionUID = 1L;
	// Solvencia economica demostrable = demostramos la solvencia con pagos por adelantado.

	public Huesped(int dni, String nombre, String mail, int tlfNum, int contrasenya, String cargo, String nomEmpresa) {
		super(dni, nombre, mail, tlfNum, contrasenya);
		this.cargo = cargo;
		this.nomEmpresa = nomEmpresa;
		if (cargo == null) {
			this.cargo = "Desempleado";
			this.nomEmpresa = null;
		}
	}
	

	

	
	

}
