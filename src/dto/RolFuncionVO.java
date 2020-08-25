package dto;

public class RolFuncionVO {
	
	private int idRolFuncion;
	private int idRol;
	private int idFuncion;
	
	
	public RolFuncionVO() {
		super();
	}
	
	public RolFuncionVO(int idRolFuncion, int idRol, int idFuncion) {
		this.idRolFuncion = idRolFuncion;
		this.idRol = idRol;
		this.idFuncion = idFuncion;
	}


	public int getIdRolFuncion() {
		return idRolFuncion;
	}


	public void setIdRolFuncion(int idRolFuncion) {
		this.idRolFuncion = idRolFuncion;
	}


	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public int getIdFuncion() {
		return idFuncion;
	}


	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}
	
	

}
