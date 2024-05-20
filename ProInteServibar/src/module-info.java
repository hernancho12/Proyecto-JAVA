module ProyectoIntegrador {
	
	
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens Controlador to javafx.graphics, javafx.fxml, javafx.base;
	opens Vista to javafx.graphics, javafx.fxml, javafx.base;
}