package dto;

import java.util.LinkedList;

import basededatos.DAORol;

public class RolBO {
	
private LinkedList<RolVO> roles;
	
	/**
	 * 
	 * Constructor que crea un linkedlist de roles vacio
	 */
	public RolBO() {
		this.roles = new LinkedList<>();
	}

	/**
	 * 
	 * Agrego un rol
	 * @param rol
	 * @return
	 */
	public boolean agregarRol(RolVO rol) {
		return DAORol.insertarRol(rol);
	}
	
	/**
	 * 
	 * Cargo los roles
	 */
	public void obtenerRoles() {
		roles = DAORol.seleccionarRoles();
	}
	
	/**
	 * 
	 * Actualizo un rol
	 * @param rol
	 * @return
	 */
	public boolean actualizarRol(RolVO rol) {
		return DAORol.actualizarRol(rol);
	}
	
	/**
	 * 
	 * Elimino un rol
	 * @param idRol
	 * @return
	 */
	public boolean eliminarRol(int idRol) {
		return DAORol.eliminarRol(idRol);
	}

	/**
	 * 
	 * Getter del linkedlist roles
	 * @return
	 */
	public LinkedList<RolVO> getRoles() {
		return roles;
	}

}
