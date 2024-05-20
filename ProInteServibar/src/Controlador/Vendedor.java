package Controlador;

import java.math.BigDecimal;

public class Vendedor implements Persona {
	private String Id;
	private String Cedula;
	private String Nombre;
	private String correoElectronico;
	private String Telefono;
	private String username;
	private String password;
	
	
	public Vendedor(String Id, String Cedula,  String Nombre, String correoElectronico, String Telefono, String username, String password) {
		this.Id = Id;
		this.Cedula= Cedula;
		this.Nombre = Nombre;
		this.correoElectronico = correoElectronico;
		this.Telefono = Telefono;
		this.username = username;
		this.password = password;
		
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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