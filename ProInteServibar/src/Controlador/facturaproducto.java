package Controlador;



public class facturaproducto {
	private Factura factu;
	private Producto produ;
	private Integer cantidad;
	private Integer total;
	
	public facturaproducto (Factura f, Producto p, Integer canti) {
		this.factu = f;
		this.produ = p;
		this.cantidad = canti;
		this.total = canti * p.getPreciounitario();	
	}

	public Factura getFactu() {
		return factu;
	}

	public void setFactu(Factura factu) {
		this.factu = factu;
	}

	public Producto getProdu() {
		return produ;
	}

	public void setProdu(Producto produ) {
		this.produ = produ;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	

}
