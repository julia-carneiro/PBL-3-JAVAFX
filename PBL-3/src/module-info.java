module PBL3 {
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.base;
	
	opens app.controller to javafx.graphics, javafx.fxml;
	exports app;
}