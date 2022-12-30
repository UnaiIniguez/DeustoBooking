package deustoBooking;

import java.util.Date;
import java.util.Objects;

public class Reserva {

	private int id_Reserva;
	private int  id_Inmueble;
	private Date fecha_Entrada;
	private Date fecha_Salida;
	private String dni_Huesped;
	
	
	public Reserva(int id_Reserva, int id_Inmueble, Date fecha_Entrada, Date fecha_Salida, String dni_Huesped) {
		super();
		this.id_Reserva = id_Reserva;
		this.id_Inmueble = id_Inmueble;
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
		this.dni_Huesped = dni_Huesped;
	}


	public int getId_Inmueble() {
		return id_Inmueble;
	}


	public void setId_Inmueble(int id_Inmueble) {
		this.id_Inmueble = id_Inmueble;
	}


	public Date getFecha_Entrada() {
		return fecha_Entrada;
	}


	public void setFecha_Entrada(Date fecha_Entrada) {
		this.fecha_Entrada = fecha_Entrada;
	}


	public Date getFecha_Salida() {
		return fecha_Salida;
	}


	public void setFecha_Salida(Date fecha_Salida) {
		this.fecha_Salida = fecha_Salida;
	}


	public String getDni_Huesped() {
		return dni_Huesped;
	}


	public void setDni_Huesped(String dni_Huesped) {
		this.dni_Huesped = dni_Huesped;
	}


	@Override
	public String toString() {
		return "Reserva [id de la reserva =" + id_Reserva + ", la fecha de entrada será=" + fecha_Entrada + " y la fecha de salida será =" + fecha_Salida
				 + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return id_Reserva == other.id_Reserva;
	}  
	
	
	
}
