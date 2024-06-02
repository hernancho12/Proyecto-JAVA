package Graficar;

import javafx.scene.layout.Pane;

public class graficaInforme implements Factorychart {

	@Override
	public void crearLineas(Pane container) {
		new graficaLineas().graficar(container);
	}

	@Override
	public void crearBarras(Pane container) {
		// TODO Auto-generated method stub

	}

}