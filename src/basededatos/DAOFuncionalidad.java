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
	
	private static final String INSERT = "INSERT INTO funcionalidad (id_funcionalidad, nombre, descripcion) VALUES (seq_id_funcionalidad.nextval,?,?)";
	private static final String SELECT = "SELECT * FROM funcionalidad";
	private static final String UPDATE = "UPDATE funcionalidad SET nombre=?, descripcion=? WHERE id_funcionalidad=?";
	private static final String DELETE = "DELETE FROM funcionalidad WHERE id_funcionalidad=?";
	private static final String FIND = "SELECT * FROM funcionalidad WHERE nombre=?";
	
	// Insertar registro
	public static boolean insertarFuncionalidad(FuncionalidadVO funcionalidad) {
		int filasIngresadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(INSERT);
			
//			prprdstmt.setInt(1, funcionalidad.getId());
			prprdstmt.setString(1, funcionalidad.getNombre());
			prprdstmt.setString(2, funcionalidad.getDescripcion());
			
			filasIngresadas = prprdstmt.executeUpdate();
//			System.out.println("Se agregó: " + filasIngresadas + " registro nuevo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasIngresadas > 0;
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
	public static boolean actualizarFuncionalidad(FuncionalidadVO funcionalidad) {
		int filasActualizadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(UPDATE);
			
			prprdstmt.setString(1, funcionalidad.getNombre());
			prprdstmt.setString(2, funcionalidad.getDescripcion());
			prprdstmt.setInt(3, funcionalidad.getId());
			
			filasActualizadas = prprdstmt.executeUpdate();
//			System.out.println("Se actualizó: " + filasActualizadas + " registro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasActualizadas > 0;
	}
	
	// Eliminar un registro
	public static boolean eliminarFuncionalidad(int id) {
		int filasEliminadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(DELETE);
			
			prprdstmt.setInt(1, id);
			
			filasEliminadas = prprdstmt.executeUpdate();
//			System.out.println("Se eliminó: " + filasEliminadas + " registro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasEliminadas > 0;
	}
	
	// Buscar un registro
	public static FuncionalidadVO buscarFuncionalidad(String nombre) {
		FuncionalidadVO funcionalidad = new FuncionalidadVO();
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(SELECT);
			
			if(rset.next()) {
				funcionalidad.setId(rset.getInt("id_funcionalidad"));
				funcionalidad.setNombre(rset.getString("nombre"));
				funcionalidad.setDescripcion(rset.getString("descripcion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionalidad;
	}

}
