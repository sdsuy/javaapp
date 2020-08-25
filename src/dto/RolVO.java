Apackage dto;

import java.util.LinkedList;

public class RolVO {
	
	private int id;
	private String nombre;
	private String descripcion;
	private LinkedList<FuncionalidadVO> funcionalidades;
	
	public RolVO() {
		super();
	}

	public RolVO(int id, String nombre, String descripcion, LinkedList<FuncionalidadVO> funcionalidades) {
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

	public LinkedList<FuncionalidadVO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(LinkedList<FuncionalidadVO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
