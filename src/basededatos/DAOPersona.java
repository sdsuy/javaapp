package basededatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import dto.PersonaVO;

import java.sql.Connection;

public class DAOPersona {
	private Connection conexion = DatabaseManager.getConexion();
	private static final String INSERT_PERSONA = "INSERT INTO PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,APELLIDO2,NOMBRE1,NOMBRE2,FECHA_NAC,CLAVE,MAIL,ID_ROL VALUES (?,?,?,?,?,?,?,?,?,?) ";
	private static final String DELETE_PERSONA = "DELETE FROM PERSONA WHERE ID_PERSONA = ?";
	private static final String UPDATE_PERSONA = "UPDATE PERSONA SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?,CLAVE=?,MAIL=? WHERE ID_PERSONA=?";
	//insertar persona
	public void nuevaPersona(int id_persona,String documento, String apellido1, String apellido2, String nombre1, String nombre2, Date fecha_nac, String clave, String mail, int id_rol) {
		try {
			PreparedStatement prepStatment = conexion.prepareStatement(INSERT_PERSONA);
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
		public LinkedList<PersonaVO> seleccionarPersona() {
			LinkedList<PersonaVO> personas = new LinkedList<>(); 
			String consulta = "SELECT * FROM PERSONA";
			try {
				Statement stmt = conexion.createStatement();
				ResultSet rset = stmt.executeQuery(consulta);
				
				while(rset.next()) {
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
					persona.setId_rol(rset.getInt("ID_ROL"));
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
				pst.setInt(9, per.getId_rol());
				pst.setInt(10, per.getId());
				
				int retorno = pst.executeUpdate();
				return retorno>0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
			
		}
		


}
