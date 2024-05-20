package Controlador;

public class Reporte {
	private String Id;
	private String tipoReporte;
	private Integer Id_venta;
	
	
	public Reporte (String Id, String tipoReporte, Integer Id_venta) {
		this.Id = Id;
		this.tipoReporte = tipoReporte;
		this.Id_venta = Id_venta;
}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getTipoReporte() {
		return tipoReporte;
	}


	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}


	public Integer getId_venta() {
		return Id_venta;
	}


	public void setId_venta(Integer id_venta) {
		Id_venta = id_venta;
	}
}