package control;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Libro;
import view.OverviewController;

/**
 * Actividad 9.1. Biblioteca I 
 * Desarrolla una aplicaci�n Java en la que se acceda a una base de datos MySQL con los productos de una tienda online de venta de libros. 
 * La base de datos s�lo tiene una tabla, la tabla Libros. Los campos de la tabla los defin�s vosotros, 
 * al menos 4 campos (referencia, editorial, titulo,autor,isbn, precio,anio, etc.). 
 * Se dispondr� de una IU dise�ada con Swing o JavaFX en la que aparecer�n todos los libros en formato tabular 
 * (parte izquierda de la interfaz) y cuando se seleccione un libro, aparecer�n todos sus detalles en la parte derecha de la interfaz. 
 * La informaci�n de detalle es de s�lo lectura.
 * @author Marina
 *
 */

public class MainApp extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private ObservableList<Libro> libros = FXCollections.observableArrayList();
	
	public MainApp() {
		//Recuperar los libros de la BD
		libros.add(new Libro(1,"Hola","aaa","bbb"));
	}
	
	public ObservableList<Libro> getLibros(){
		return libros;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Libreria");
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/PersonOverview.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			Scene scene = new Scene(rootLayout, 600, 400);
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
			
			OverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
