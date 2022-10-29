package modelo;

public class Inmueble {
	
	
	Propietario propietario;
	Boolean ocupado = false;
	String Huesped = null;
	
	private  int numHab;
	private int numBany;
	private String ubicacion;				//Poner: (Pais/Comunidad/Ciudad)
	private int MaxHuespedes;
	TipoVivienda tipo;
	private float metrosCuadrados;
	private float precioNoche;
	
	
	
	public Inmueble(Propietario propietario, String ubicacion,TipoVivienda tipo,
			 float metrosCuadrados, int numBany, int numHab, int maxHuespedes, float precioNoche) {
		super();
		this.propietario = propietario;
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



	public Propietario getPropietario() {
		return propietario;
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
	
	
	
	
	
	
	

}
