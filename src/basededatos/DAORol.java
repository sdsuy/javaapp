package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAORol {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT = "INSERT INTO ROL (ID_ROL, nombre, descripcion) VALUES (?,?,?)";
	private static final String SELECT = "SELECT * FROM ROL";
	private static final String UPDATE = "UPDATE ROL SET nombre=?, descripcion=? WHERE ID_ROL=?";
	private static final String DELETE = "DELETE FROM ROL WHERE ID_ROL=?";
	
	//insertar rol
	
	public void insertarRol(int id, String nombre, String descripcion) {
		
		try {
			
			PreparedStatement sentencia = conexion.prepareStatement(INSERT);
			
			sentencia.setInt(1, id);
			sentencia.setString(2, nombre);
			sentencia.setString(3, descripcion);
			
			int filasInsert = sentencia.executeUpdate();
			System.out.println("Se agregaron: " + filasInsert + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Seleccionar todos los registros
		public LinkedList<dto.Rol> seleccionarRol() {
			
			LinkedList<dto.Rol> roles = new LinkedList<>(); 
			
			try {
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(SELECT);
				
				while(resultado.next()) {
					dto.Rol rol = new dto.Rol();
					rol.id = resultado.getInt("id_funcionalidad");
					rol.nombre = resultado.getString("nombre");
					rol.descripcion = resultado.getString("descripcion");
					roles.add(rol);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return roles;
		}
		
		//Actualizar un regstro
		public static void actualizarRol(int id, String nombre, String descripcion) {
			
			try {
				PreparedStatement sentencia = conexion.prepareStatement(UPDATE);
				
				sentencia.setString(1, nombre);
				sentencia.setString(2, descripcion);
				sentencia.setInt(3, id);
				
				int filasUpdate = sentencia.executeUpdate();
				
				System.out.println("Se actualizaron: " + filasUpdate + " registros");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
		}
		
		// Eliminar un registro
		public static int eliminarRol(int id) {
			
			int filasEliminadas = 0;
			
			try {
				PreparedStatement sentencia = conexion.prepareStatement(DELETE);
				
				sentencia.setInt(1, id);
				
				filasEliminadas = sentencia.executeUpdate();
				
				System.out.println("Se eliminaron: " + filasEliminadas + " registros");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return filasEliminadas;
		}
	
	

}