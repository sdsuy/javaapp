package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.FuncionalidadVO;

public class DAOFuncionalidad {
	
	private static Connection conexion = DatabaseManager.getConexion();
	
	private static final String INSERT = "INSERT INTO funcionalidad (id_funcionalidad, nombre, descripcion) VALUES (?,?,?)";
	private static final String SELECT = "SELECT * FROM funcionalidad";
	private static final String UPDATE = "UPDATE funcionalidad SET nombre=?, descripcion=? WHERE id_funcionalidad=?";
	private static final String DELETE = "DELETE FROM funcionalidad WHERE id_funcionalidad=?";
	
	// Insertar registro
	public static int insertarFuncionalidad(int id, String nombre, String descripcion) {
		int filasIngresadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(INSERT);
			
			prprdstmt.setInt(1, id);
			prprdstmt.setString(2, nombre);
			prprdstmt.setString(3, descripcion);
			
			filasIngresadas = prprdstmt.executeUpdate();
			System.out.println("Se agreg�: " + filasIngresadas + " registro nuevo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasIngresadas;
	}
	
	// Seleccionar todos los registros
	public static LinkedList<FuncionalidadVO> seleccionarFuncionalidades() {
		LinkedList<FuncionalidadVO> funcionalidades = new LinkedList<>();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(SELECT);
			
			while(rset.next()) {
				FuncionalidadVO funcionalidad = new FuncionalidadVO();
				funcionalidad.setId(rset.getInt("id_funcionalidad"));
				funcionalidad.setNombre(rset.getString("nombre"));
				funcionalidad.setDescripcion(rset.getString("descripcion"));
				funcionalidades.add(funcionalidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionalidades;
	}
	
	// Actualizar un registro
	public static void actualizarFuncionalidad(int id, String nombre, String descripcion) {
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(UPDATE);
			
			prprdstmt.setString(1, nombre);
			prprdstmt.setString(2, descripcion);
			prprdstmt.setInt(3, id);
			
			int filasActualizadas = prprdstmt.executeUpdate();
			System.out.println("Se actualiz�: " + filasActualizadas + " registro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Eliminar un registro
	public static int eliminarFuncionalidad(int id) {
		int filasEliminadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(DELETE);
			
			prprdstmt.setInt(1, id);
			
			filasEliminadas = prprdstmt.executeUpdate();
			System.out.println("Se elimin�: " + filasEliminadas + " registro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasEliminadas;
	}

}
