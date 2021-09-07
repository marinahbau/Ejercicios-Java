package vista;

import control.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Operaciones;

public class VistaControlador {
	private Main mainApp;
	@FXML
	private TextField operando1;
	@FXML
	private TextField operando2;
	@FXML
	private TextField resultado;
	@FXML
	private Button operar;
	@FXML
	private RadioButton sumar;
	@FXML
	private RadioButton restar;
	@FXML
	private RadioButton producto;
	@FXML
	private RadioButton dividir;
	
	public VistaControlador() {}
	
	@FXML
	public void initialize() {
		//Inicializar grupo
		ToggleGroup tg = new ToggleGroup();
		this.sumar.setToggleGroup(tg);
		this.restar.setToggleGroup(tg);
		this.producto.setToggleGroup(tg);
		this.dividir.setToggleGroup(tg);
		
		//Añadir evento al boton
		/*if(this.operar.isPressed()) {
			calcular();
		}*/
	}
	
	public void calcular() {
		int op1 = Integer.parseInt(this.operando1.getText());
		int op2 = Integer.parseInt(this.operando2.getText());
		
		Operaciones operacion = new Operaciones(op1,op2);
		
		if(this.sumar.isSelected()) {
			this.resultado.setText(Integer.toString(operacion.suma()));
		}
		if(this.restar.isSelected()) {
			this.resultado.setText(Integer.toString(operacion.resta()));
		}
		if(this.producto.isSelected()) {
			this.resultado.setText(Integer.toString(operacion.producto()));
		}
		if(this.dividir.isSelected()) {
			this.resultado.setText(Integer.toString(operacion.division()));
		}
	}
	
	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp;
	}
}
