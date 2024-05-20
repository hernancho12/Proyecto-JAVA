package Controlador;

import java.sql.Date;

public class Factura {
	private String Id;
	private String 	Cedula;
	private Cliente cliente;
	private String Numerofactura;
	private Date Fecha;	
	private Integer total;
	
	public Factura (String Id,String Cedula, String Numerofactura, Date Fecha, Cliente cliente,Integer total) {
		this.Id = Id;
		this.Cedula = Cedula;
		this.Numerofactura = Numerofactura;
		this.Fecha = Fecha;
		this.cliente = cliente;
		this.total = total;
		
				
	}


}
