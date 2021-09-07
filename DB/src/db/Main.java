package db;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Ejemplo sencillo para la conexión con una BD con Java
 * @author Marina
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexDB conexion = new ConexDB();
		Connection con = conexion.conectarMySQL();
		if(con != null) {
			System.out.println("Conexion establecida");
		}
		conexion.printLibros(con);
		
	}

}
