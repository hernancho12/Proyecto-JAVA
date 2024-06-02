package Controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DatosJson implements Persona {

	@Override
	public Producto getProductInfo(String id) {
		// TODO Auto-generated method stub
		Producto pro = null;
		JSONParser parser = new JSONParser();
		try {
			JSONArray o = (JSONArray) parser.parse(new FileReader("./Productos.json"));
			for(Object o1 : o) {
				JSONObject temp = (JSONObject) o1;
				if(temp.get("id").toString().equals(id)) {
					pro = new Producto(Integer.parseInt(temp.get("id").toString()), temp.get("Name").toString(), id, Integer.parseInt(temp.get("Price").toString()), null, null);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCedula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCedula(String cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCorreoElectronico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorreoElectronico(String correoElectronico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTelefono(String telefono) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		
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
	public void setId(Integer newValue) {
		// TODO Auto-generated method stub
		
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
	public int getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente getClientInfo(String id) {
		// TODO Auto-generated method stub
		return null;
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
	public Integer getCantidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCantidad(Integer cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescripcion(String setDescripcion) {
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
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}
}