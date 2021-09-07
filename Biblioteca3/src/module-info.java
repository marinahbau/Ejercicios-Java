module Biblioteca3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	
	opens edu.control to javafx.graphics, javafx.fxml;
	opens edu.vista to javafx.graphics, javafx.fxml;
}
