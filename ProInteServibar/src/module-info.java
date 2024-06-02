module ProyectoIntegrador {
	
	
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	requires json.simple;
	requires com.oracle.database.jdbc;
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens Controlador to javafx.graphics, javafx.fxml, javafx.base;
	opens Vista to javafx.graphics, javafx.fxml, javafx.base;
	opens Graficar to javafx.graphics, javafx.fxml, javafx.base;
}