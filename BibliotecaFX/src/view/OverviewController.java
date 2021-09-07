package view;

import control.MainApp;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Libro;

public class OverviewController {

	@FXML
	private TableView<Libro> librosTable;
	@FXML
	private TableColumn<Libro,String> columnaTitulo;
	
	@FXML
	private Label referencia;
	@FXML
	private Label titulo;
	@FXML
	private Label autor;
	@FXML
	private Label editorial;
	
	private MainApp mainApp;
	
	public OverviewController() {
		
	}
	
	@FXML
	private void initialize() {
		columnaTitulo.setCellValueFactory(cell -> new ReadOnlyStringWrapper(cell.getValue().getTitulo()));
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		
		librosTable.setItems(mainApp.getLibros());
	}
}
