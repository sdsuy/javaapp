package dto;

import java.util.LinkedList;

import basededatos.DAOFuncionalidad;

public class FuncionalidadBO {
	
	private LinkedList<FuncionalidadVO> funcionalidades;
	
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
	
	public FuncionalidadVO buscarFuncionalidad(String nombre) {
		return DAOFuncionalidad.buscarFuncionalidad(nombre);
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
