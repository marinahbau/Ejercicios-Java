package edu.vista;

import edu.control.Main;
import edu.modelo.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VistaBibliotecaControlador {
	@FXML
	private TableView<Libro> tablaLibros;
	
	@FXML
	private TableColumn<Libro, String> titulos;
	
	@FXML
	private Label labelId;
	
	@FXML
	private Label labelTitulo;
	
	@FXML
	private Label labelAutor;
	
	@FXML
	private Label labelAnno;
	
	private Main main;

	
	public VistaBibliotecaControlador() {
		
	}
	
	@FXML
	private void initialize() {
		titulos.setCellValueFactory(z -> z.getValue().getTitulo());
		
		showDetails(null);
		
		tablaLibros.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> showDetails(newValue));
	}
	
	public void setMainApp(Main main) {
		this.main = main;
		tablaLibros.setItems(main.getLibros());
	}
	
	private void showDetails(Libro libro) {
		if(libro != null) {
			labelId.setText(Integer.toString(libro.getId().get()));
			labelTitulo.setText(libro.getTitulo().get());
			labelAnno.setText(Integer.toString(libro.getAnno().get()));
			labelAutor.setText(libro.getAutor().get());
		} else {
			labelId.setText("");
			labelTitulo.setText("");
			labelAutor.setText("");
			labelAnno.setText("");
		}
	}
	
}
