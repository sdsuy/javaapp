package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.FuncionalidadVO;
import dto.RolVO;

public class DAORol {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT = "INSERT INTO ROL (id_rol, nombre, descripcion) VALUES (seq_id_rol.nextval,?,?)";
	private static final String SELECT = "SELECT * FROM ROL";
	private static final String UPDATE = "UPDATE ROL SET nombre=?, descripcion=? WHERE ID_ROL=?";
	private static final String DELETE = "DELETE FROM ROL WHERE ID_ROL=?";
	private static final String FIND = "SELECT * FROM ROL WHERE NOMBRE=?";
	private static final String FIND_BY_ID_PERSONA = "SELECT\r\n" + 
			"    rol.id_rol,\r\n" + 
			"    rol.nombre,\r\n" + 
			"    rol.descripcion,\r\n" + 
			"    persona.id_persona\r\n" + 
			"FROM\r\n" + 
			"    rol\r\n" + 
			"    INNER JOIN persona ON rol.id_rol = persona.id_rol\r\n" + 
			"WHERE\r\n" + 
			"    persona.id_persona = ?";
	
	//insertar rol
	
	public static boolean insertarRol(RolVO rol) {
		int filasInsert = 0;
		try {
			
			PreparedStatement sentencia = conexion.prepareStatement(INSERT);
			
			
			sentencia.setString(1, rol.getNombre());
			sentencia.setString(2, rol.getDescripcion());
			
			filasInsert = sentencia.executeUpdate();
//			System.out.println("Se agregaron: " + filasInsert + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasInsert > 0;
	}
	
	// Seleccionar todos los registros
		public static LinkedList<RolVO> seleccionarRoles() {
			
			LinkedList<RolVO> roles = new LinkedList<>(); 
			
			try {
				Statement sentencia = conexion.createStatement();
				ResultSet resultado = sentencia.executeQuery(SELECT);
				
				while(resultado.next()) {
					RolVO rol = new RolVO();
					rol.setId(resultado.getInt("id_rol"));
					rol.setNombre(resultado.getString("nombre"));
					rol.setDescripcion(resultado.getString("descripcion"));
					roles.add(rol);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return roles;
		}
		
		//Actualizar un regstro
		public static boolean actualizarRol(RolVO rol) {
			int filasUpdate = 0;
			try {
				PreparedStatement sentencia = conexion.prepareStatement(UPDATE);
				
				sentencia.setString(1, rol.getNombre());
				sentencia.setString(2, rol.getDescripcion());
				sentencia.setInt(3, rol.getId());
				
				filasUpdate = sentencia.executeUpdate();
				
//				System.out.println("Se actualizaron: " + filasUpdate + " registros");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			return filasUpdate > 0;
		}
		
		// Eliminar un registro
		public static boolean eliminarRol(int id) {
			
			int filasEliminadas = 0;
			
			try {
				PreparedStatement sentencia = conexion.prepareStatement(DELETE);
				
				sentencia.setInt(1, id);
				
				filasEliminadas = sentencia.executeUpdate();
				
				//System.out.println("Se eliminaron: " + filasEliminadas + " registros");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return filasEliminadas > 0;
		}
		
		//Buscar un registro
		
		public static RolVO buscarRol(String nombre) {
			RolVO rol = new RolVO();
			try {
				PreparedStatement sentencia = conexion.prepareStatement(FIND);
				
				sentencia.setString(1, nombre);
				
				ResultSet resultado = sentencia.executeQuery();
				
				
				if(resultado.next()) {
					rol.setId(resultado.getInt("id_rol"));
					rol.setNombre(resultado.getString("nombre"));
					rol.setDescripcion(resultado.getString("descripcion"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rol;
		}
		
		//Buscar un registro por id de persona
		
				public static RolVO buscarRol(int idPersona) {
					RolVO rol = new RolVO();
					try {
						PreparedStatement sentencia = conexion.prepareStatement(FIND_BY_ID_PERSONA);
						
						sentencia.setInt(1, idPersona);
						
						ResultSet resultado = sentencia.executeQuery();
						
						
						if(resultado.next()) {
							rol.setId(resultado.getInt("id_rol"));
							rol.setNombre(resultado.getString("nombre"));
							rol.setDescripcion(resultado.getString("descripcion"));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return rol;
				}
	
	

}