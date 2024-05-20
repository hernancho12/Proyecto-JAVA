package Controlador;
import java.math.BigDecimal;
import java.sql.Date;


public class Venta {
	private String IdVenta;
	private Date Fecha;
	private Integer Cantidad;
	private BigDecimal Subtotal;
	private BigDecimal Iva;
	private BigDecimal Total;
	private Integer Id_vendedor;
	private Integer Id_cliente;
	private Integer Id_producto;
	
	public Venta(String IdVenta, Date Fecha, Integer Cantidad, BigDecimal Subtotal, BigDecimal Iva, BigDecimal Total, Integer Id_vendedor,
			Integer Id_cliente, Integer Id_producto) {
	
		this.IdVenta = IdVenta;
		this.Fecha = Fecha;
		this.Cantidad = Cantidad;
		this.Subtotal = Subtotal;
		this.Iva = Iva;
		this.Total = Total;
		this.Id_vendedor = Id_vendedor;
		this.Id_cliente = Id_cliente;
		this.Id_producto = Id_producto;
	}

	public String getIdVenta() {
		return IdVenta;
	}

	public void setIdVenta(String idVenta) {
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

	public BigDecimal getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		Subtotal = subtotal;
	}

	public BigDecimal getIva() {
		return Iva;
	}

	public void setIva(BigDecimal iva) {
		Iva = iva;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
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
