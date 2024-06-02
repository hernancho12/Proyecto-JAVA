package Graficar;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.Pane;



public class graficaLineas {
	void graficar(Pane container) {
		NumberAxis yaxis = new NumberAxis();
		CategoryAxis xaxis = new CategoryAxis();
		
		LineChart<String, Number> grafico = new LineChart<>(xaxis, yaxis);
		
		XYChart.Series<String, Number> serie = new Series<String, Number>();
		
		serie.getData().add(new XYChart.Data<>("MOUSE",34));
		serie.getData().add(new XYChart.Data<>("TECLADO",32));
		serie.getData().add(new XYChart.Data<>("PANTALLAS",45));
		serie.getData().add(new XYChart.Data<>("CPU",38));
		serie.getData().add(new XYChart.Data<>("RAM",17));
		
		grafico.getData().add(serie);
		
		container.getChildren().add(grafico);
	}
}

