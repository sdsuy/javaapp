package basededatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.PersonaVO;
import dto.RolVO;
import presentacion.Rol;

import java.sql.Connection;

public class DAOPersona {
	private static Connection conexion = DatabaseManager.getConexion();
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC,CLAVE,MAIL,ID_ROL VALUES (?,?,?,?,?,?,?,?,?,?) ";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA = ?";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?,CLAVE=?,MAIL=?,ID_ROL=? WHERE ID_PERSONA=?";
	private static final String ALL_PERSONA = "SELECT * FROM PERSONA WHERE ID_PERSONA";
	//insertar persona
	public static boolean nuevaPersona(PersonaVO persona) {
		try {
			PreparedStatement prepStatment = conexion.prepareStatement(INSERT_PERSONA);
			prepStatment.setInt(1, persona.getId());
			prepStatment.setString(2, persona.getDocumento());
			prepStatment.setString(3, persona.getApellido1());
			prepStatment.setString(4, persona.getApellido1());
			prepStatment.setString(5, persona.getNombre1());
			prepStatment.setString(6, persona.getNombre2());
			prepStatment.setDate(7, persona.getFecha_nac());
			prepStatment.setString(8, persona.getClave());
			prepStatment.setString(9, persona.getMail());
			prepStatment.setInt(10, persona.getRol().getId());
			
			int filasAgregadas = prepStatment.executeUpdate();
			System.out.println("Se agrego filas "+ filasAgregadas + "registros nuevos");
			return filasAgregadas>0;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	// Seleccionar todos los registros
		public static LinkedList<PersonaVO> seleccionarPersona() {
			LinkedList<PersonaVO> personas = new LinkedList<>(); 
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(ALL_PERSONA);
				
				while(rset.next()) {
					RolVO rol = new RolVO();
					PersonaVO persona = new PersonaVO();
					persona.setId(rset.getInt("ID_PERSONA"));
					persona.setDocumento(rset.getString("DOCUMENTO"));
					persona.setApellido1(rset.getString("APELLIDO1"));
					persona.setApellido2(rset.getString("APELLIDO2"));
					persona.setNombre1(rset.getString("NOMBRE1"));
					persona.setNombre2(rset.getString("NOMBRE2"));
					persona.setFecha_nac(rset.getDate("FECHA_NAC"));
					persona.setClave(rset.getString("CLAVE"));
					persona.setMail(rset.getString("MAIL"));
					rol.setId(rset.getInt("ID_Rol"));
					persona.setRol(rol);
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
		public static boolean modificarPersona(PersonaVO per) {
			
			try {
				PreparedStatement pst = DatabaseManager.getConexion().prepareStatement(UPDATE_PERSONA);
				pst.setString(1, per.getDocumento());
				pst.setString(2, per.getApellido1());
				pst.setString(3, per.getApellido2());
				pst.setString(4, per.getNombre1());
				pst.setString(5, per.getNombre2());
				pst.setDate(6, per.getFecha_nac());
				pst.setString(7, per.getClave());
				pst.setString(8, per.getMail());
				pst.setInt(9, per.getId());
				int retorno = pst.executeUpdate();
				return retorno>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
			
		}
		


}
