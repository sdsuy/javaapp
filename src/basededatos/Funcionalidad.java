package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Funcionalidad {
	
	private Connection conexion = DatabaseManager.getConexion();
	
	// Insertar funcionalidad
	public void insertarFuncionalidad(int id, String nombre, String descripcion) {
		String insert = "INSERT INTO funcionalidad (id_funcionalidad, nombre, descripcion) VALUES (?,?,?)";
		
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(insert);
			
			prprdstmt.setInt(1, id);
			prprdstmt.setString(2, nombre);
			prprdstmt.setString(3, descripcion);
			
			int filasIngresadas = prprdstmt.executeUpdate();
			System.out.println("Se agregó: " + filasIngresadas + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
