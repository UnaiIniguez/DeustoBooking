package deustoBooking;

public class Huesped extends Persona {

	// Puesto de trabajo actual
	private String cargo;
	// Empresa en la que trabaja
	private String nomEmpresa;

	private static final long serialVersionUID = 1L;
	// Solvencia economica demostrable = demostramos la solvencia con pagos por
	// adelantado.

	
	public Huesped(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya, String cargo,
			String nomEmpresa) {
		super(dni, nombre, edad, mail, tlfNum, contrasenya);
		this.cargo = cargo;
		this.nomEmpresa = nomEmpresa;
		if (cargo == null) {
			this.setCargo("Desempleado");
			this.setNomEmpresa(null);
		}
	}


	public  String getCargo() {
		return cargo;
	}


	public  void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}


	@Override
	public String toString() {
		return "Huesped " + this.getDni() + " " +  this.getNombre() ;
	}
	
	

}
