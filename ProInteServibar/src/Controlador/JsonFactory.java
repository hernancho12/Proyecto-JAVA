package Controlador;

public class JsonFactory extends DatosFactory {

	@Override
	public Persona obtenerDataProvider() {
		// TODO Auto-generated method stub
		return new DatosJson();
	}

}
