package basededatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.Persona;

import java.sql.Connection;

public class DAOPersona {
	private Connection conexion = DatabaseManager.getConexion();
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA = ?";
	//insertar persona
	public void nuevaPersona(int id_persona,String documento, String apellido1, String apellido2, String nombre1, String nombre2, Date fecha_nac, String clave, String mail, int id_rol) {
		String insert = "INSERT INTO PERSONA (ID_PERSONA, DOCUMENTO, APELLLIDO1, APELLIDO2, NOMBRE1, NBOMBRE2, FECHA_NAC, CLAVE, MAIL, ID_ROL) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepStatment = conexion.prepareStatement(insert);
			prepStatment.setInt(1, id_persona);
			prepStatment.setString(2, documento);
			prepStatment.setString(3, apellido1);
			prepStatment.setString(4, apellido2);
			prepStatment.setString(5, nombre1);
			prepStatment.setString(6, nombre2);
			prepStatment.setDate(7, fecha_nac);
			prepStatment.setString(8, clave);
			prepStatment.setString(9, mail);
			prepStatment.setInt(10, id_rol);
			
			int filasAgregadas = prepStatment.executeUpdate();
			System.out.println("Se agrego filas "+ filasAgregadas + "registros nuevos");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	// Seleccionar todos los registros
		public LinkedList<Persona> seleccionarPersona() {
			LinkedList<Persona> personas = new LinkedList<>(); 
			String consulta = "SELECT * FROM PERSONA";
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(consulta);
				
				while(rset.next()) {
					Persona persona = new Persona();
					persona.id = rset.getInt("ID_PERSONA");
					persona.documento = rset.getString("DOCUMENTO");
					persona.apellido1 = rset.getString("APELLIDO1");
					persona.apellido2 = rset.getString("APELLIDO2");
					persona.nombre1 = rset.getString("NOMBRE1");
					persona.nombre2 = rset.getString("NOMBRE2");
					persona.fecha_nac = rset.getDate("FECHA_NAC");
					persona.clave = rset.getString("CLAVE");
					persona.mail = rset.getString("MAIL");
					persona.id_rol = rset.getInt("ID_ROL");
					personas.add(persona);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return personas;
		}
		public static boolean eliminarPersona(String id) {
			try {
				PreparedStatement pst =  DatabaseManager.getConexion().prepareStatement(DELETE_PERSONA);
				pst.setString(1, id);
				int retorno = pst.executeUpdate();
				
				return retorno > 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
			
		}


}
