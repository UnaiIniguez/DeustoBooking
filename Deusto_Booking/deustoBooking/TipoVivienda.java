package deustoBooking;

public enum TipoVivienda {
	CHALET("CHALET"),PISO("PISO"),ADOSADO("ADOSADO"),ESTUDIO("ESTUDIO");
	
	private String tipo;
	
	TipoVivienda(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
}
