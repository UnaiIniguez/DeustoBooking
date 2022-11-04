package DeustoBooking;

public class Huesped extends Persona {

	// Puesto de trabajo actual
	private String cargo;
	// Empresa en la que trabaja
	private String nomEmpresa;

	private static final long serialVersionUID = 1L;
	// Solvencia economica demostrable = demostramos la solvencia con pagos por
	// adelantado.

	public Huesped(int dni, String nombre, String mail, int tlfNum, int contrasenya, String cargo, String nomEmpresa) {
		super(dni, nombre, mail, tlfNum, contrasenya);
		this.setCargo(cargo);
		this.setNomEmpresa(nomEmpresa);
		if (cargo == null) {
			this.setCargo("Desempleado");
			this.setNomEmpresa(null);
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

}
