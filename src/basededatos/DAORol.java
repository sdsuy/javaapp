package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAORol {
	
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
	
	// Seleccionar todos los registros
		public LinkedList<dto.Rol> seleccionarFuncionalidades() {
			LinkedList<dto.Rol> roles = new LinkedList<>(); 
			String consulta = "SELECT * FROM funcionalidad";
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(consulta);
				
				while(rset.next()) {
					dto.Rol rol = new dto.Rol();
					rol.setId(rset.getInt("id_funcionalidad"));
					rol.setNombre(rset.getString("nombre"));
					rol.setDescripcion(rset.getString("descripcion"));
					roles.add(rol);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return roles;
		}
	
	

}
