package Controlador;

import java.math.BigDecimal;

public class Cliente implements Persona {
	private String Id;
	private String Cedula;
	private String Nombre;
	private String correoElectronico;
	private String Telefono;
	private String Direccion;
	
	public Cliente (String Id, String Cedula, String Nombre, String correoElectronico, String Telefono, String Direccion) {
		this.Id = Id;
		this.Cedula = Cedula;
		this.Nombre = Nombre;
		this.correoElectronico = correoElectronico;
		this.Telefono = Telefono;
		this.Direccion = Direccion;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
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
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getPreciounitario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPreciounitario(BigDecimal preciounitario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BigDecimal getImpuesto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setImpuesto(BigDecimal impuesto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCantidad(String cantidad) {
		// TODO Auto-generated method stub
		
	}

	

}
