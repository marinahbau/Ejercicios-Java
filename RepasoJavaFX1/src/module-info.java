module RepasoJavaFX1 {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens control to javafx.graphics, javafx.fxml;
	opens vista to javafx.graphics, javafx.fxml;
}
