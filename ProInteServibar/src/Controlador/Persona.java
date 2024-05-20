package Controlador;

import java.math.BigDecimal;

public interface Persona {


	public String getId();

	public void setId(String id);

	public String getCedula();

	public void setCedula(String cedula);
	
	public String getNombre(); 

	public void setNombre(String nombre);

	public String getCorreoElectronico();

	public void setCorreoElectronico(String correoElectronico); 

	public String getTelefono();

	public void setTelefono(String telefono);

	public String getUsername();

	public void setUsername(String username) ;

	public String getPassword(); 

	public void setPassword(String password);
	
	public String getDireccion() ;

	public void setDireccion(String direccion) ;	

	public String getDescripcion();
	
	public void setDescripcion(String descripcion) ;

	public String getCantidad();

	public void setCantidad(String cantidad);

	public BigDecimal getPreciounitario();

	public void setPreciounitario(BigDecimal preciounitario);

	public BigDecimal getImpuesto();

	public void setImpuesto(BigDecimal impuesto);



}
