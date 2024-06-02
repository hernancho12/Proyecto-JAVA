package Controlador;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Factura {
	private int Id;
	private String 	Cedula;
	private Cliente cliente;
	private String Numerofactura;
	private List<facturaproducto> producto;
	private Date Fecha;	
	private Integer total;
	
	
	public Factura (Integer Id,String Cedula, Cliente cliente,String Numerofactura, Date Fecha) {
		this.Id = Id;
		this.Cedula = Cedula;
		this.cliente = cliente;
		this.Numerofactura = Numerofactura;
		this.producto = producto;
		producto = new LinkedList<facturaproducto>();
		this.Fecha = Fecha;		
		this.total = 0;
		
				
	}



	public List<facturaproducto> getProductos() {
		return producto;
	}

	public void setProductos(List<facturaproducto> producto) {
		this.producto = producto;
	}

	public int getId() {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumerofactura() {
		return Numerofactura;
	}

	public void setNumerofactura(String numerofactura) {
		Numerofactura = numerofactura;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		this.Fecha = fecha;
	}

	public Integer getTotal() {
		return total;
	}

	
	public void addfacturaproducto(facturaproducto producto) {
		this.total += producto.getCantidad()*producto.getProdu().getPreciounitario().byteValue();
		this.producto.add(producto);
	}


}
