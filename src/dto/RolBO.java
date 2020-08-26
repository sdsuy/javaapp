package dto;

import java.util.LinkedList;

import basededatos.DAOFuncionalidad;
import basededatos.DAORol;
import basededatos.DAORolFuncion;

public class RolBO {
	
private LinkedList<RolVO> roles;
private RolVO rol;
	
	//Constructor que crea un linkedlist de roles vacio
	
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
		boolean agregado = DAORol.insertarRol(rol); // agrego el rol
		if(agregado) {
			int rolId = DAORol.buscarRol(rol.getNombre()).getId(); // obtengo el ID del rol creado
			rol.setId(rolId);
			for(FuncionalidadVO funaux: rol.getFuncionalidades()) {
				RolFuncionVO rolFuncion = new RolFuncionVO();
				rolFuncion.setIdFuncion(funaux.getId());
				rolFuncion.setIdRol(rol.getId());
				if(!DAORolFuncion.insertarRolFuncion(rolFuncion)) {
					return false; // retorna false sólo si alguna RolFuncion no logra insertarse
				}
			}
		}
		return agregado;
	}
	
	 //Cargo los roles
	 
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
		boolean actualizado = DAORol.actualizarRol(rol); // actualizo el rol
		if(actualizado) {
			if(!DAORolFuncion.eliminarRolFuncion(rol.getId())) {
				return false; // elimino todas las relaciones con funcionalidades segun el id_rol en una sola consulta y en caso de error retorno false
			}
			for(FuncionalidadVO funaux: rol.getFuncionalidades()) {
				RolFuncionVO rolFuncion = new RolFuncionVO();
				rolFuncion.setIdFuncion(funaux.getId());
				rolFuncion.setIdRol(rol.getId());
				if(!DAORolFuncion.insertarRolFuncion(rolFuncion)) {
					return false; // retorna false sólo si alguna RolFuncion no logra insertarse
				}
			}
		}
		return actualizado;
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
	/**
	 * Getter de Rol
	 * @return
	 */
	public RolVO getRol() {
		return rol;	
	}
	/**
	 *Busco un rol segun nombre
	 * @param nombre
	 */
	public void buscarRol(String nombre) {
		rol = DAORol.buscarRol(nombre);
		LinkedList<RolFuncionVO> rolFunciones = DAORolFuncion.seleccionarRolFuncionByRol(rol.getId());
		LinkedList<FuncionalidadVO> funcionalidades = new LinkedList<FuncionalidadVO>();
		for(RolFuncionVO rolFuncionalidad: rolFunciones) {
			FuncionalidadVO funcionalidad = DAOFuncionalidad.buscarFuncionalidadById(rolFuncionalidad.getIdFuncion());
			funcionalidades.add(funcionalidad);
		}
		rol.setFuncionalidades(funcionalidades);
	}

}
