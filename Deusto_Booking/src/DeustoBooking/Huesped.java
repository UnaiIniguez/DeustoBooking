package DeustoBooking;

public class Huesped extends Persona {

	// Puesto de trabajo actual
	private String cargo;
	//Empresa en la que trabaja
	private String nomEmpresa;
	
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
