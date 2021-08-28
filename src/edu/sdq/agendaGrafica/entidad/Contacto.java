package edu.sdq.agendaGrafica.entidad;

public class Contacto {
	private int IdPersonas;
	private String nombre;
	private String apellido;
	
	
	public int getIdPersonas() {
		return IdPersonas;
	}
	public void setIdPersonas(int idPersonas) {
		IdPersonas = idPersonas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Contacto(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	//Un segundo constructor para poder llevar el ID al jtable
	public Contacto(int IdPersonas, String nombre, String apellido) {
		this.IdPersonas = IdPersonas;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	

}
