package modelo;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private int dni;
	private String nombre;
	private String mail;
	private int edad;
	private int tlfNum; 
	private int contrasenya;
	
	public Persona(int dni, String nombre, String mail, int tlfNum, int contrasenya) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.mail = mail;
		this.tlfNum = tlfNum;
		this.contrasenya = contrasenya;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
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

	public int getTlfNum() {
		return tlfNum;
	}

	public void setTlfNum(int tlfNum) {
		this.tlfNum = tlfNum;
	}
	
	
	
	

}
