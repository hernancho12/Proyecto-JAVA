package Controlador;

import java.sql.Date;

public class Producto  {
	private Integer Id;
	private String Nombre;
	private String Descripcion;
	private Integer Cantidad;
	private Integer Preciounitario;
	private Integer Impuesto;
	
	public Producto (Integer Id, String Nombre,String Descripcion, Integer Cantidad, Integer Preciounitario, Integer Impuesto) {
		this.Id = Id;
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Cantidad = Cantidad;
		this.Preciounitario = Preciounitario;
		this.Impuesto = Impuesto ;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Integer getCantidad() {
		return Cantidad;
	}

	public void setCantidad(Integer cantidad) {
		Cantidad = cantidad;
	}

	public Integer getPreciounitario() {
		return Preciounitario;
	}

	public void setPreciounitario(Integer preciounitario) {
		Preciounitario = preciounitario;
	}

	public Integer getImpuesto() {
		return (this.Preciounitario * this.Impuesto/100)+ this.Preciounitario;
	}

	public void setImpuesto(Integer impuesto) {
		Impuesto = impuesto;
	}

	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
		
	


	


	
	
	

}