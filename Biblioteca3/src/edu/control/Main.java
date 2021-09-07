package edu.control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.control.DB;
import edu.modelo.Libro;
import edu.vista.VistaBibliotecaControlador;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private ObservableList<Libro> libros = FXCollections.observableArrayList();

	public Main() {
		//Conectamos de la base de datos y recuperamos los libros
		DB conexion = new DB();
		Connection con =  conexion.conectarMySQL();
		ResultSet tablaDB = conexion.getLibros(con);
		
		//Guardamos la tabla en objetos tipo libro y los añadimos a la lista
		try {
			while(tablaDB.next()) {
				libros.add(new Libro(tablaDB.getInt(1),tablaDB.getString(2),tablaDB.getString(3),tablaDB.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObservableList<Libro> getLibros() {
		return libros;
	}


	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Biblioteca");

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/edu/vista/VistaBiblioteca.fxml"));
		try {
			AnchorPane vista = loader.load();
			Scene scene = new Scene(vista);
			primaryStage.setScene(scene);
			primaryStage.show();

			VistaBibliotecaControlador controlador = loader.getController();
			controlador.setMainApp(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
