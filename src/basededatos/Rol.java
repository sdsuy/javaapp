package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rol {
	
	private Connection conexion = DatabaseManager.getConexion();
	
	//insertar rol
	
	public void insertarRol(int id, String nombre, String descripcion) {
		String insert = "INSERT INTO ROL (ID_ROL, NOMBRE, DESCRIPCION) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement prepare = conexion.prepareStatement(insert);
			
			prepare.setInt(1, id);
			prepare.setString(2, nombre);
			prepare.setString(3, descripcion);
			
			int filas = prepare.executeUpdate();
			System.out.println("Se agregó: " + filas + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
