package dto;

import java.util.LinkedList;

public class Rol {
	
	private int id;
	private String nombre;
	private String descripcion;
	private LinkedList<Funcionalidad> funcionalidades;
	
	public Rol() {
		super();
	}

	public Rol(int id, String nombre, String descripcion, LinkedList<Funcionalidad> funcionalidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funcionalidades = funcionalidades;
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

	public LinkedList<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(LinkedList<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
