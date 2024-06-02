package Controlador;

import java.sql.Date;


public class Venta {
	private Integer IdVenta;
	private Date Fecha;
	private Integer Cantidad;
	private Integer Iva;
	private Integer Total;
	private Integer Id_vendedor;
	private Integer Id_cliente;
	private Integer Id_producto;
	
	public Venta(Integer IdVenta, Date Fecha, Integer Cantidad, Integer Subtotal, Integer Iva, Integer Total, Integer Id_vendedor,
			Integer Id_cliente, Integer Id_producto) {
	
		this.IdVenta = IdVenta;
		this.Fecha = Fecha;
		this.Cantidad = Cantidad;
		this.Iva = Iva;
		this.Total = Total;
		this.Id_vendedor = Id_vendedor;
		this.Id_cliente = Id_cliente;
		this.Id_producto = Id_producto;
	}

	public Integer getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(Integer idVenta) {
		IdVenta = idVenta;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public Integer getIva() {
		return Iva;
	}

	public void setIva(Integer iva) {
		Iva = iva;
	}

	public Integer getTotal() {
		return Total;
	}

	public void setTotal(Integer total) {
		Total = total;
	}

	public Integer getId_vendedor() {
		return Id_vendedor;
	}

	public void setId_vendedor(Integer id_vendedor) {
		Id_vendedor = id_vendedor;
	}

	public Integer getId_cliente() {
		return Id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		Id_cliente = id_cliente;
	}

	public Integer getId_producto() {
		return Id_producto;
	}

	public void setId_producto(Integer id_producto) {
		Id_producto = id_producto;
	}

	
}
