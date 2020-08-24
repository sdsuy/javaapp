package basededatos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import dto.FuncionalidadVO;

public class DAOFuncionalidadTest {

	@Test
	public void testInsertarFuncionalidad() {
		int filasIngresadas = DAOFuncionalidad.insertarFuncionalidad(1, "Nueva", "");
		DAOFuncionalidad.eliminarFuncionalidad(1);
		assertEquals(1, filasIngresadas);
	}

	@Test
	public void testSeleccionarFuncionalidades() {
		DAOFuncionalidad.insertarFuncionalidad(1, "Primera", "");
		DAOFuncionalidad.insertarFuncionalidad(2, "Segunda", "");
		DAOFuncionalidad.insertarFuncionalidad(3, "Tercera", "");
		LinkedList<FuncionalidadVO> funcionalidades = DAOFuncionalidad.seleccionarFuncionalidades();
		DAOFuncionalidad.eliminarFuncionalidad(1);
		DAOFuncionalidad.eliminarFuncionalidad(2);
		DAOFuncionalidad.eliminarFuncionalidad(3);
		assertEquals(3, funcionalidades.size());
	}

	@Test
	public void testActualizarFuncionalidad() {
		DAOFuncionalidad.insertarFuncionalidad(1, "Vieja", "");
		DAOFuncionalidad.actualizarFuncionalidad(1, "Nueva", "");
		LinkedList<FuncionalidadVO> funcionalidades = DAOFuncionalidad.seleccionarFuncionalidades();
		DAOFuncionalidad.eliminarFuncionalidad(1);
		assertTrue(funcionalidades.get(0).getNombre().equals("Nueva"));
	}
	
	@Test
	public void testEliminarFuncionalidad() {
		DAOFuncionalidad.insertarFuncionalidad(1, "Borrarme", "");
		int filasEliminadas = DAOFuncionalidad.eliminarFuncionalidad(1);
		assertEquals(1, filasEliminadas);
	}

}
