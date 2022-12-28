package deustoBooking;

import java.io.Serializable;

public abstract class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dni;			
	private String nombre;
	private int edad;
	private String mail;
	private String tlfNum;		//He cambiado el telefono de int a String porque sino no daba el rango
	private String contrasenya;		//He cambiado la contraseña a String porque cada uno puede poner la contraseña com desea
	
	public Persona() {
		
	}

	public Persona(String dni, String nombre, int edad, String mail, String tlfNum, String contrasenya) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.mail = mail;
		this.tlfNum = tlfNum;
		this.contrasenya = contrasenya;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTlfNum() {
		return tlfNum;
	}

	public void setTlfNum(String tlfNum) {
		this.tlfNum = tlfNum;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

}
