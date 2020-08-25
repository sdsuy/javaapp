package dto;

import java.util.LinkedList;

import basededatos.DAOFuncionalidad;

public class FuncionalidadBO {
	
	private LinkedList<FuncionalidadVO> funcionalidades;
	private FuncionalidadVO funcionalidad;
	
	/**
	 * 
	 * Constructor que crea un linkedlist de funcionalidades vacio
	 */
	public FuncionalidadBO() {
		this.funcionalidades = new LinkedList<>();
	}

	/**
	 * 
	 * Agrego una funcionalidad
	 * @param funcionalidad
	 * @return
	 */
	public boolean agregarFuncionalidad(FuncionalidadVO funcionalidad) {
		return DAOFuncionalidad.insertarFuncionalidad(funcionalidad);
	}
	
	/**
	 * 
	 * Cargo las funcionalidades
	 */
	public void obtenerFuncionalidades() {
		funcionalidades = DAOFuncionalidad.seleccionarFuncionalidades();
	}
	
	/**
	 * 
	 * Actualizo una funcionalidad
	 * @param funcionalidad
	 * @return
	 */
	public boolean actualizarFuncionalidad(FuncionalidadVO funcionalidad) {
		return DAOFuncionalidad.actualizarFuncionalidad(funcionalidad);
	}
	
	/**
	 * 
	 * Elimino una funcionalidad
	 * @param id
	 * @return
	 */
	public boolean eliminarFuncionalidad(int id) {
		return DAOFuncionalidad.eliminarFuncionalidad(id);
	}
	
	/**
	 * 
	 * Busco una funcionalidad
	 * @param nombre
	 * @return
	 */
	public void buscarFuncionalidad(String nombre) {
		funcionalidad = DAOFuncionalidad.buscarFuncionalidad(nombre);
	}

	/**
	 * 
	 * Getter de funcionalidad
	 * @return
	 */
	public FuncionalidadVO getFuncionalidad() {
		return funcionalidad;
	}

	/**
	 * 
	 * Getter del linkedlist funcionalidades
	 * @return
	 */
	public LinkedList<FuncionalidadVO> getFuncionalidades() {
		return funcionalidades;
	}

}
