package basededatos;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class FuncionalidadTest {

	@Test
	public void testInsertarFuncionalidad() {
		Funcionalidad funcionalidad = new Funcionalidad();
		int filasIngresadas = funcionalidad.insertarFuncionalidad(1, "Nueva", "");
		funcionalidad.eliminarFuncionalidad(1);
		assertEquals(1, filasIngresadas);
	}

	@Test
	public void testSeleccionarFuncionalidades() {
		Funcionalidad funcionalidad = new Funcionalidad();
		funcionalidad.insertarFuncionalidad(1, "Primera", "");
		funcionalidad.insertarFuncionalidad(2, "Segunda", "");
		funcionalidad.insertarFuncionalidad(3, "Tercera", "");
		LinkedList<dto.Funcionalidad> funcionalidades = funcionalidad.seleccionarFuncionalidades();
		funcionalidad.eliminarFuncionalidad(1);
		funcionalidad.eliminarFuncionalidad(2);
		funcionalidad.eliminarFuncionalidad(3);
		assertEquals(3, funcionalidades.size());
	}

	@Test
	public void testActualizarFuncionalidad() {
		Funcionalidad funcionalidad = new Funcionalidad();
		funcionalidad.insertarFuncionalidad(1, "Vieja", "");
		funcionalidad.actualizarFuncionalidad(1, "Nueva", "");
		LinkedList<dto.Funcionalidad> funcionalidades = funcionalidad.seleccionarFuncionalidades();
		funcionalidad.eliminarFuncionalidad(1);
		assertTrue(funcionalidades.get(0).nombre.equals("Nueva"));
	}
	
	@Test
	public void testEliminarFuncionalidad() {
		Funcionalidad funcionalidad = new Funcionalidad();
		funcionalidad.insertarFuncionalidad(1, "Borrarme", "");
		int filasEliminadas = funcionalidad.eliminarFuncionalidad(1);
		assertEquals(1, filasEliminadas);
	}

}
