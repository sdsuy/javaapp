package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.RolFuncionVO;

public class DAORolFuncion {
	
private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT = "INSERT INTO ROL_FUNCION (ID_ROL_FUNCION, ID_ROL, ID_FUNCION) VALUES (seq_id_rol_funcion.nextval,?,?)";
	private static final String SELECT = "SELECT * FROM ROL_FUNCION";
	private static final String UPDATE = "UPDATE ROL_FUNCION SET ID_ROL=?, ID_FUNCION=? WHERE ID_ROL_FUNCION=?";
	private static final String DELETE = "DELETE FROM ROL_FUNCION WHERE ID_ROL=?";
	private static final String FIND = "SELECT * FROM rol_funcion WHERE ID_ROL=?";
	
	//insertar rol
	
		public static boolean insertarRolFuncion(RolFuncionVO rolFuncion) {
			int filasInsert = 0;
			try {
				
				PreparedStatement sentencia = conexion.prepareStatement(INSERT);
				
				
				sentencia.setInt(1, rolFuncion.getIdRol());
				sentencia.setInt(2, rolFuncion.getIdFuncion());
				
				filasInsert = sentencia.executeUpdate();
			//System.out.println("Se agregaron: " + filasInsert + "registros nuevos");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return filasInsert > 0;
		}
		
		// Seleccionar todos los registros
			public static LinkedList<RolFuncionVO> seleccionarRolFuncion() {
				
				LinkedList<RolFuncionVO> rolFunciones = new LinkedList<>(); 
				
				try {
					Statement sentencia = conexion.createStatement();
					ResultSet resultado = sentencia.executeQuery(SELECT);
					
					while(resultado.next()) {
						RolFuncionVO rolFuncion = new RolFuncionVO();
						rolFuncion.setIdRolFuncion(resultado.getInt("ID_ROL_FUNCION"));
						rolFuncion.setIdRol(resultado.getInt("ID_ROL"));
						rolFuncion.setIdFuncion(resultado.getInt("ID_FUNCION"));
						rolFunciones.add(rolFuncion);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rolFunciones;
			}
			
			//Actualizar un regstro
			public static boolean actualizarRolFuncion(RolFuncionVO rolFuncion) {
				int filasUpdate = 0;
				try {
					PreparedStatement sentencia = conexion.prepareStatement(UPDATE);
					
					sentencia.setInt(1, rolFuncion.getIdRolFuncion());
					sentencia.setInt(2, rolFuncion.getIdRol());
					sentencia.setInt(3, rolFuncion.getIdFuncion());
					
					filasUpdate = sentencia.executeUpdate();
					
//					System.out.println("Se actualizaron: " + filasUpdate + " registros");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
				return filasUpdate > 0;
			}
			
			// Eliminar registros
			public static boolean eliminarRolFuncion(int idRol) {
				
				int filasEliminadas = 0;
				
				try {
					PreparedStatement sentencia = conexion.prepareStatement(DELETE);
					
					sentencia.setInt(1, idRol);
					
					filasEliminadas = sentencia.executeUpdate();
					
					//System.out.println("Se eliminaron: " + filasEliminadas + " registros");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return filasEliminadas > 0;
			}
			
			// Seleccionar todos los registros segun el rol
			public static LinkedList<RolFuncionVO> seleccionarRolFuncionByRol(int idRol) {
				
				LinkedList<RolFuncionVO> rolFunciones = new LinkedList<>(); 
				
				try {
					PreparedStatement sentencia = conexion.prepareStatement(FIND);
					
					sentencia.setInt(1, idRol);
					
					ResultSet resultado = sentencia.executeQuery();
					
					while(resultado.next()) {
						RolFuncionVO rolFuncion = new RolFuncionVO();
						rolFuncion.setIdRolFuncion(resultado.getInt("ID_ROL_FUNCION"));
						rolFuncion.setIdRol(resultado.getInt("ID_ROL"));
						rolFuncion.setIdFuncion(resultado.getInt("ID_FUNCION"));
						rolFunciones.add(rolFuncion);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return rolFunciones;
			}
	

}
