package basededatos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import dto.FuncionalidadVO;

public class DAOFuncionalidadTest {

	@Test
	public void testInsertarFuncionalidad() {
		FuncionalidadVO funcionalidad = new FuncionalidadVO();
		funcionalidad.setId(1);
		funcionalidad.setNombre("Nueva");
		funcionalidad.setDescripcion("");
		boolean filasIngresadas = DAOFuncionalidad.insertarFuncionalidad(funcionalidad);
		DAOFuncionalidad.eliminarFuncionalidad(1);
		assertTrue(filasIngresadas);
	}

	@Test
	public void testSeleccionarFuncionalidades() {
		FuncionalidadVO funcionalidad1 = new FuncionalidadVO();
		funcionalidad1.setId(1);
		funcionalidad1.setNombre("Primera");
		funcionalidad1.setDescripcion("");
		FuncionalidadVO funcionalidad2 = new FuncionalidadVO();
		funcionalidad2.setId(2);
		funcionalidad2.setNombre("Segunda");
		funcionalidad2.setDescripcion("");
		FuncionalidadVO funcionalidad3 = new FuncionalidadVO();
		funcionalidad3.setId(3);
		funcionalidad3.setNombre("Tercera");
		funcionalidad3.setDescripcion("");
		DAOFuncionalidad.insertarFuncionalidad(funcionalidad1);
		DAOFuncionalidad.insertarFuncionalidad(funcionalidad2);
		DAOFuncionalidad.insertarFuncionalidad(funcionalidad3);
		LinkedList<FuncionalidadVO> funcionalidades = DAOFuncionalidad.seleccionarFuncionalidades();
		DAOFuncionalidad.eliminarFuncionalidad(1);
		DAOFuncionalidad.eliminarFuncionalidad(2);
		DAOFuncionalidad.eliminarFuncionalidad(3);
		assertEquals(3, funcionalidades.size());
	}

	@Test
	public void testActualizarFuncionalidad() {
		FuncionalidadVO funcionalidad = new FuncionalidadVO();
		funcionalidad.setId(1);
		funcionalidad.setNombre("Vieja");
		funcionalidad.setDescripcion("");
		DAOFuncionalidad.insertarFuncionalidad(funcionalidad);
		funcionalidad.setNombre("Nueva");
		DAOFuncionalidad.actualizarFuncionalidad(funcionalidad);
		LinkedList<FuncionalidadVO> funcionalidades = DAOFuncionalidad.seleccionarFuncionalidades();
		DAOFuncionalidad.eliminarFuncionalidad(1);
		assertTrue(funcionalidades.get(0).getNombre().equals("Nueva"));
	}
	
	@Test
	public void testEliminarFuncionalidad() {
		FuncionalidadVO funcionalidad = new FuncionalidadVO();
		funcionalidad.setId(1);
		funcionalidad.setNombre("Borrarme");
		funcionalidad.setDescripcion("");
		DAOFuncionalidad.insertarFuncionalidad(funcionalidad);
		boolean filasEliminadas = DAOFuncionalidad.eliminarFuncionalidad(1);
		assertTrue(filasEliminadas);
	}

}
