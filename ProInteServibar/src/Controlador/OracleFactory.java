package Controlador;

public class OracleFactory extends DatosFactory {

	@Override
	public Persona obtenerDataProvider() {
		// TODO Auto-generated method stub
		return new Basedatos();
	}
	
	

}
