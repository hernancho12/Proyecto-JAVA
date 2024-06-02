package Controlador;


import java.sql.Date;

import javafx.scene.Node;



public interface Persona {


	public Integer getId();

	public void setId(int id);

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

	
	public Cliente getCliente() ;

	public void setCliente(Cliente cliente) ;

	public String getNumerofactura() ;

	public void setNumerofactura(String numerofactura) ;
	public Date getFecha() ;

	public void setFecha(Date fecha) ;
	public Integer getTotal();

	public void setTotal(Integer total);
	
	public Factura getFactu() ;

	public void setFactu(Factura factu) ;
	

	public void setId(Integer newValue);
	
public boolean saveFactura(Factura factura);
	
	public Factura getFacturaInfo(String id);
public Producto getProductInfo(String id);
	
	public int getMaxId();
	
	public Cliente getClientInfo(String id);

	

	public Producto getProdu() ;

	public void setProdu(Producto produ) ;
	public Integer getCantidad() ;

	public void setCantidad(Integer cantidad) ;

	public void setDescripcion(String setDescripcion);

	public Integer getPreciounitario();

	public Integer getImpuesto();

	public String getDescripcion();
	
	
	
	}
	
	

	
	




