package basededatos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persona {
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

}
