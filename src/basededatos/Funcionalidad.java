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
	public void insertarFuncionalidad(int id, String nombre, String descripcion) {
		String insertar = "INSERT INTO funcionalidad (id_funcionalidad, nombre, descripcion) VALUES (?,?,?)";
		
		try {
			PreparedStatement prprdstmt = conexion.prepareStatement(insertar);
			
			prprdstmt.setInt(1, id);
			prprdstmt.setString(2, nombre);
			prprdstmt.setString(3, descripcion);
			
			int filasIngresadas = prprdstmt.executeUpdate();
			System.out.println("Se agregó: " + filasIngresadas + "registros nuevos");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

}
