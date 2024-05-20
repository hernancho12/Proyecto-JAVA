package Controlador;
import java.math.BigDecimal;


public class detalleFactura {
	private String IdDetallefac;
	private BigDecimal Cantidad;
	private BigDecimal Subtotal;
	private Integer Id_venta;
	private Integer Id_producto;
	
	
	
	public detalleFactura (String IdDetallefac, BigDecimal Cantidad, BigDecimal Subtotal, Integer Id_venta, Integer Id_producto_, Integer Id_producto) {
		this.IdDetallefac = IdDetallefac;
		this.Cantidad = Cantidad;
		this.Id_venta = Id_venta;
		this.Id_producto =	Id_producto;	
		this.Subtotal = Subtotal;
		
	}



	public String getIdDetallefac() {
		return IdDetallefac;
	}



	public void setIdDetallefac(String idDetallefac) {
		IdDetallefac = idDetallefac;
	}



	public BigDecimal getCantidad() {
		return Cantidad;
	}



	public void setCantidad(BigDecimal cantidad) {
		Cantidad = cantidad;
	}



	public BigDecimal getSubtotal() {
		return Subtotal;
	}



	public void setSubtotal(BigDecimal subtotal) {
		Subtotal = subtotal;
	}



	public Integer getId_venta() {
		return Id_venta;
	}



	public void setId_venta(Integer id_venta) {
		Id_venta = id_venta;
	}



	public Integer getId_producto() {
		return Id_producto;
	}



	public void setId_producto(Integer id_producto) {
		Id_producto = id_producto;
	}

	

}
