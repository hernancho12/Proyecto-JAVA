package Controlador;
import java.math.BigDecimal;

public class Producto implements Persona {
	private String Id;
	private String Nombre;
	private String Descripcion;
	private String Cantidad;
	private BigDecimal Preciounitario;
	private BigDecimal Impuesto;
	
	public Producto (String Id, String Nombre, String Descripcion,String Cantidad, BigDecimal Preciounitario, BigDecimal Impuesto) {
		this.Id = Id;
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Cantidad = Cantidad;
		this.Preciounitario = Preciounitario;
		this.Impuesto = Impuesto;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public BigDecimal getPreciounitario() {
		return Preciounitario;
	}

	public void setPreciounitario(BigDecimal preciounitario) {
		Preciounitario = preciounitario;
	}

	public BigDecimal getImpuesto() {
		return Impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		Impuesto = impuesto;
	}

	@Override
	public String getCedula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCedula(String cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCorreoElectronico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorreoElectronico(String correoElectronico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTelefono(String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDireccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDireccion(String direccion) {
		// TODO Auto-generated method stub
		
	}

}