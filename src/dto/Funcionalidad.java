package dto;

import java.util.LinkedList;

public class Funcionalidad {
	
	private int id;
	private String nombre;
	private String descripcion;
	private LinkedList<Rol> roles;
	
	public Funcionalidad() {
		super();
	}

	public Funcionalidad(int id, String nombre, String descripcion, LinkedList<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LinkedList<Rol> getRoles() {
		return roles;
	}

	public void setRoles(LinkedList<Rol> roles) {
		this.roles = roles;
	}

}
