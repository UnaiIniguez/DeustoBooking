package deustoBooking;

import java.lang.reflect.Array;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Inmueble {

	
	private int id_Inmueble;
	private int numHab;
	private int numBany;
	private String ubicacion; // Poner: (Pais/Comunidad/Ciudad)
	private int MaxHuespedes;
	private TipoVivienda tipo;
	private float metrosCuadrados;
	private float precioNoche;
	private int ocupado;
	private String dni_Duenio;
	private List<Blob> imagenes;
	
public Inmueble() {
		
	}

	public Inmueble( int id_Inmueble,String dni_Duenio, String ubicacion, TipoVivienda tipo, float metrosCuadrados, int numBany, int numHab,
			int maxHuespedes, float precioNoche, int ocupado, List<Blob> imagenes) {
		super();
		this.imagenes = new ArrayList<>();
		this.id_Inmueble = id_Inmueble;
		this.dni_Duenio = dni_Duenio;
		this.numHab = numHab;
		this.numBany = numBany;
		this.ubicacion = ubicacion;
		this.MaxHuespedes = maxHuespedes;
		this.tipo = tipo;
		this.metrosCuadrados = metrosCuadrados;
		this.precioNoche = precioNoche;
		this.ocupado = ocupado;

	}

//*************************************GETTERS Y SETTERS*****************************************************
	
	
	public String getDni_Duenio() {
		return dni_Duenio;
	}
	public int getId_Inmueble() {
		return id_Inmueble;
	}

	public List<Blob> getImagenes() {
		return imagenes;
	}

	public int getOcupado() {
		return ocupado;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setMetrosCuadrados(float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setOcupado(int ocupado) {
		this.ocupado = ocupado;
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


	public String getDuenio() {
		return dni_Duenio;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public TipoVivienda getTipo() {
		return tipo;
	}

	public void setTipo(TipoVivienda tipo) {
		this.tipo = tipo;
	}

	public float getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
	}
	
	public void setDuenio(String duenio) {
		this.dni_Duenio = duenio;
	}

	@Override
	public String toString() {
		return "Inmueble [duenio=" + dni_Duenio + ", ocupado=" + ocupado + ", numHab=" + numHab
				+ ", numBany=" + numBany + ", ubicacion=" + ubicacion + ", MaxHuespedes=" + MaxHuespedes + ", tipo="
				+ tipo + ", metrosCuadrados=" + metrosCuadrados + ", precioNoche=" + precioNoche + "]";
	}

	
	
	
	

	

}
