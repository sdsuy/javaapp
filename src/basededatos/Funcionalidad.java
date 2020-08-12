package basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Funcionalidad {
	
	private Connection conexion = DatabaseManager.getConexion();
	
	// Insertar funcionalidad
	public int insertarFuncionalidad(int id, String nombre, String descripcion) {
		String insertar = "INSERT INTO funcionalidad (id_funcionalidad, nombre, descripcion) VALUES (?,?,?)";
		int filasIngresadas = 0;
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(insertar);
			
			prprdstmt.setInt(1, id);
			prprdstmt.setString(2, nombre);
			prprdstmt.setString(3, descripcion);
			
			filasIngresadas = prprdstmt.executeUpdate();
			System.out.println("Se agregó: " + filasIngresadas + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filasIngresadas;
	}
	
	// Seleccionar todos los registros
	public LinkedList<dto.Funcionalidad> seleccionarFuncionalidades() {
		LinkedList<dto.Funcionalidad> funcionalidades = new LinkedList<>(); 
		String consulta = "SELECT * FROM funcionalidad";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(consulta);
			
			while(rset.next()) {
				dto.Funcionalidad funcionalidad = new dto.Funcionalidad();
				funcionalidad.id = rset.getInt("id_funcionalidad");
				funcionalidad.nombre = rset.getString("nombre");
				funcionalidad.descripcion = rset.getString("descripcion");
				funcionalidades.add(funcionalidad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionalidades;
	}
	
	// Actualizar un registro
	public void actualizarFuncionalidad(int id, String nombre, String descripcion) {
		String actualizar = "UPDATE funcionalidad SET (nombre=?, descripcion=?) WHERE id_funcionalidad=?";
		
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(actualizar);
			
			prprdstmt.setString(1, nombre);
			prprdstmt.setString(2, descripcion);
			prprdstmt.setInt(3, id);
			
			int filasActualizadas = prprdstmt.executeUpdate();
			System.out.println("Se actualizó: " + filasActualizadas + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
