package DeustoBooking;

public class Inmueble {
<<<<<<< HEAD

	Duenio duenio;
	Boolean ocupado = false;

=======
	
	

	Duenio duenio;
	Boolean ocupado = false;				

	

>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	String Huesped = null;

	private int numHab;
	private int numBany;
	private String ubicacion; // Poner: (Pais/Comunidad/Ciudad)
	private int MaxHuespedes;
	TipoVivienda tipo;
	private float metrosCuadrados;
	private float precioNoche;
<<<<<<< HEAD

	public Inmueble(Duenio duenio, String ubicacion, TipoVivienda tipo, float metrosCuadrados, int numBany, int numHab,
			int maxHuespedes, float precioNoche) {
=======
	
	
	
	public Inmueble(Duenio duenio, String ubicacion,TipoVivienda tipo,
			 float metrosCuadrados, int numBany, int numHab, int maxHuespedes, float precioNoche) {
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
		super();
		this.duenio = duenio;
		this.numHab = numHab;
		this.numBany = numBany;
		this.ubicacion = ubicacion;
		this.MaxHuespedes = maxHuespedes;
		this.tipo = tipo;
		this.metrosCuadrados = metrosCuadrados;
		this.precioNoche = precioNoche;

	}

//*************************************GETTERS Y SETTERS*****************************************************

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getHuesped() {
		return Huesped;
	}

	public void setHuesped(String huesped) {
		Huesped = huesped;
	}

	public int getNumHab() {
		return numHab;
	}

	public void setNumHab(int numHab) {
		this.numHab = numHab;
	}

	public int getNumBany() {
		return numBany;
	}

	public void setNumBany(int numBany) {
		this.numBany = numBany;
	}

	public int getMaxHuespedes() {
		return MaxHuespedes;
	}

	public void setMaxHuespedes(int maxHuespedes) {
		MaxHuespedes = maxHuespedes;
	}

	public float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

<<<<<<< HEAD
=======


>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git
	public Duenio getDuenio() {
		return duenio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public TipoVivienda getTipo() {
		return tipo;
	}

	public float getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Inmueble [duenio=" + duenio + ", ocupado=" + ocupado + ", Huesped=" + Huesped + ", numHab=" + numHab
				+ ", numBany=" + numBany + ", ubicacion=" + ubicacion + ", MaxHuespedes=" + MaxHuespedes + ", tipo="
				+ tipo + ", metrosCuadrados=" + metrosCuadrados + ", precioNoche=" + precioNoche + "]";
	}
=======
		return "Inmueble [duenio=" + duenio + ", ocupado=" + ocupado + ", Huesped=" + Huesped + ", numHab="
				+ numHab + ", numBany=" + numBany + ", ubicacion=" + ubicacion + ", MaxHuespedes=" + MaxHuespedes
				+ ", tipo=" + tipo + ", metrosCuadrados=" + metrosCuadrados + ", precioNoche=" + precioNoche + "]";
	}
	
	
	
	
	
	
	
>>>>>>> branch 'master' of https://github.com/UnaiIniguez/DeustoBooking.git

}