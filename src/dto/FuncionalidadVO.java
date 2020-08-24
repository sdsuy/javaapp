package dto;

import java.util.LinkedList;

public class FuncionalidadVO {
	
	private int id;
	private String nombre;
	private String descripcion;
	private LinkedList<RolVO> roles;
	
	public FuncionalidadVO() {
		super();
	}

	public FuncionalidadVO(int id, String nombre, String descripcion, LinkedList<RolVO> roles) {
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

	public LinkedList<RolVO> getRoles() {
		return roles;
	}

	public void setRoles(LinkedList<RolVO> roles) {
		this.roles = roles;
	}

}
