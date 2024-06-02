package Controlador;


import java.sql.Date;

public class Vendedor implements Persona {
	private Integer Id;
	private String Cedula;
	private String Nombre;
	private String correoElectronico;
	private String Telefono;
	private String username;
	private String password;
	
	
	public Vendedor(Integer Id, String Cedula,  String Nombre, String correoElectronico, String Telefono, String username, String password) {
		this.Id = Id;
		this.Cedula= Cedula;
		this.Nombre = Nombre;
		this.correoElectronico = correoElectronico;
		this.Telefono = Telefono;
		this.username = username;
		this.password = password;
		
	}

	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
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
	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Cliente getCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNumerofactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumerofactura(String numerofactura) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFecha(Date fecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTotal(Integer total) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Factura getFactu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFactu(Factura factu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto getProdu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProdu(Producto produ) {
		// TODO Auto-generated method stub
		
	}


	

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void setCantidad(Integer cantidad) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Integer getPreciounitario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getImpuesto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveFactura(Factura factura) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Factura getFacturaInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto getProductInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente getClientInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}