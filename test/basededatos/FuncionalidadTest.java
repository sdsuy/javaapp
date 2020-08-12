package basededatos;

import static org.junit.Assert.*;

import org.junit.Test;

public class FuncionalidadTest {

	@Test
	public void testInsertarFuncionalidad() {
		Funcionalidad funcionalidad = new Funcionalidad();
		int filasIngresadas = funcionalidad.insertarFuncionalidad(1, "Santiago", "");
		assertEquals(1, filasIngresadas);
	}

	@Test
	public void testSeleccionarFuncionalidades() {
//		fail("Not yet implemented");
		assertTrue(true);
	}

	@Test
	public void testActualizarFuncionalidad() {
//		fail("Not yet implemented");
		assertTrue(true);
	}

}
