
	package edu.control;

	import java.sql.Connection;
import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class DB {

	    // Librería de MySQL
	    public String driver = "com.mysql.jdbc.Driver";

	    // Nombre de la base de datos
	    public String database = "prueba";

	    // Host
	    public String hostname = "localhost";

	    // Puerto
	    public String port = "3306";

	    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
	    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	    // Nombre de usuario
	    public String username = "root";

	    // Clave de usuario
	    public String password = null;

	    public java.sql.Connection conectarMySQL() {
	        java.sql.Connection conn = null;

	        try {
	            Class.forName(driver);
	            conn = DriverManager.getConnection(url, username, password);
	            } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return conn;
	    }
	    
	    public ResultSet getLibros(Connection conexion) {
	    	
	    	try {
	    		Statement instruccion = conexion.createStatement();
				ResultSet tabla = instruccion.executeQuery("SELECT * FROM LIBROS");
				return tabla;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return null;
	    	
	    }

	}
