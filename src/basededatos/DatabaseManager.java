package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	private static Connection Conexion;
	private static String CADENA_CONEXION = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private static String USUARIO = "JAVA";
	private static String CLAVE = "JAVA";
	
	static {
		try {
			Conexion = DriverManager.getConnection(CADENA_CONEXION, USUARIO, CLAVE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		return Conexion;
	}

}
