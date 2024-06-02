package Controlador;

import Controlador.Persona;
import Controlador.Factura;

public abstract class DatosFactory {
	
	public boolean saveFactura(Factura f) {
		if(f.getCliente()!=null && f.getProductos()!=null && f.getTotal()>0) {
			return obtenerDataProvider().saveFactura(f);
		}else {
			return false;
		}
	}
	
	public abstract Persona obtenerDataProvider();
}
