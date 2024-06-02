package Controlador;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
public class Basedatos implements Persona {
	private String conectionstr = "jdbc:oracle:thin:@desktop-vk7lhjm:1521:xe";
	private String username = "servibar";
	private String password = "servibar";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.conectionstr, this.username, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}public ResultSet getChartData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT Producto, Cantidad FROM facturaproducto";
        return stmt.executeQuery(query);
	}
	
	
	public LinkedList<Persona> getDatos(){
		LinkedList<Persona> data1 = new LinkedList<Persona>();
		Connection conn = this.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "select * from Vendedor";
			ResultSet result = st.executeQuery(query);
			while(result.next()) {
				 System.out.println("Leyendo datos de Vendedor...");
				boolean add = data1.add(new Vendedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
				System.out.println("Vendedor agregado: " + data1.getLast());
			}
			result.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data1;
	}
	public Vendedor login(String username , String password) {
		Vendedor user=null;
		Connection conn = this.getConnection();
		try {
			String query = "select * from Vendedor where username= ? and password= ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				user=new Vendedor(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	  // Método para agregar un vendedor a la base de datos
    public  void registrarVendedor(Integer Id, String Cedula, String Nombre, String correoElectronico, String Telefono ) {
    	String query = "INSERT INTO Vendedor (Id, Cedula, Nombre, correoElectronico, Telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
        	statement.setString(1, Nombre);
            statement.setString(2, Cedula);
            statement.setString(3, correoElectronico);
            statement.setString(4, Telefono);
            statement.setInt(5, Id);
            
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarVendedor(String Cedula) {
        String query = "DELETE FROM Vendedor WHERE Cedula = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(2, Cedula);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vendedor eliminado correctamente");
            } else {
                System.out.println("No se encontró ningún vendedor con el ID especificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar vendedor");
        }
    }
    
    // Método para modificar un vendedor en la base de datos
    public void modificarVendedor(Integer Id,String Cedula, String Nombre, String correoElectronico, String Telefono) {
        String query = "UPDATE Vendedor SET Nombre = ?, Cedula = ?, correoElectronico = ?, Telefono = ? WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Nombre);
            statement.setString(2, Cedula);
            statement.setString(3, correoElectronico);
            statement.setString(4, Telefono);
            statement.setInt(5, Id);
            
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vendedor modificado correctamente");
            } else {
                System.out.println("No se encontró ningún vendedor con el ID especificado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al modificar vendedor");
        }
    }
	public static void clear() {
		// TODO Auto-generated method stub
			}
	public static void add(Vendedor a) {
		// TODO Auto-generated method stub
	}
	
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	public LinkedList<Persona> getDatos1(){
	    LinkedList<Persona> data2 = new LinkedList<Persona>();
	    Connection conn = this.getConnection();
	    Statement st;
	    try {
	        st = conn.createStatement();
	        System.out.println("Statement creado exitosamente.");
	        
	        String query = "select * from Cliente";
	        System.out.println("Query: " + query);
	        
	        ResultSet result = st.executeQuery(query);
	        System.out.println("Result set obtenido.");
	        
	        while(result.next()) {
	            System.out.println("Leyendo datos de Cliente...");
	            Integer id = result.getInt(1);
	            String cedula = result.getString(2);
	            String nombre = result.getString(3);
	            String correoElectronico = result.getString(4);
	            String telefono = result.getString(5);
	            String direccion = result.getString(6);
	            
	            Cliente nuevoCliente = new Cliente(id, cedula, nombre, correoElectronico, telefono, direccion);
	            data2.add(nuevoCliente);
	            
	            System.out.println("Cliente agregado: " + nuevoCliente);
	        }
	        
	        System.out.println("Total de clientes leídos: " + data2.size());
	        
			result.close();
			st.close();
			conn.close();
	        System.out.println("Recursos cerrados.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error al leer datos de la base de datos: " + e.getMessage());
	    }
	    
	    return data2;
	}
	
	public void registrarCliente(Integer Id, String Cedula, String Nombre, String correoElectronico, String Telefono, String Direccion ) {
    String query = "INSERT INTO Cliente (Id, Cedula, Nombre, correoElectronico, Telefono, Direccion) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setInt(1, Id);
        statement.setString(2, Cedula);
        statement.setString(3, Nombre);
        statement.setString(4, correoElectronico);
        statement.setString(5, Telefono);
        statement.setString(6, Direccion);
        
        
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	public void eliminarCliente(String Cedula) {
	    String query = "DELETE FROM Cliente WHERE Cedula =?";

	    try (Connection conn = getConnection();
	         PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setString(1, Cedula); 
	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Cliente eliminado correctamente");
	        } else {
	            System.out.println("No se encontró ningún cliente con la cédula especificada");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.err.println("Error al eliminar cliente");
	    }
	}




public void modificarCliente(Integer Id, String Cedula, String Nombre, String correoElectronico, String Telefono, String Direccion) {
    String query = "UPDATE Cliente SET Cedula =?, Nombre =?, correoElectronico =?, Telefono =?, Direccion =? WHERE Id =?"; // Corrección aquí

    try (Connection conn = getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, Cedula);
        statement.setString(2, Nombre);
        statement.setString(3, correoElectronico);
        statement.setString(4, Telefono);
        statement.setString(5, Direccion);
        statement.setInt(6, Id); 
        
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Cliente modificado correctamente");
        } else {
            System.out.println("No se encontró ningún cliente con el ID especificado");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error al modificar cliente");
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




public LinkedList<Producto> getDatos2(){
    LinkedList<Producto> data3 = new LinkedList<Producto>();
    Connection conn = this.getConnection();
    Statement st;
    try {
        st = conn.createStatement();
        System.out.println("Statement creado exitosamente.");
        
        String query = "select * from Producto";
        System.out.println("Query: " + query);
        
        ResultSet result = st.executeQuery(query);
        System.out.println("Result set obtenido.");
        
        while(result.next()) {
            System.out.println("Leyendo datos de Cliente...");
            Integer IdProducto = result.getInt(1);
            String  Nombre = result.getString(2);
            String Descripcion = result.getString(3);
            Integer Cantidad = result.getInt(4);
            Integer Preciounitario = result.getInt(5);
            Integer Impuesto = result.getInt(6);
            
            
            Producto nuevoProducto = new Producto(IdProducto, Nombre,Descripcion,Cantidad, Preciounitario, Impuesto);
            data3.add(nuevoProducto);
            
            System.out.println("Producto agregado: " + nuevoProducto);
        }
        
        System.out.println("Total de Productos leídos: " + data3.size());
        
		result.close();
		st.close();
		conn.close();
        System.out.println("Recursos cerrados.");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al leer datos de la base de datos: " + e.getMessage());
    }
    
    return data3;
}




//Método para agregar un producto a la base de datos
public  void registrarProducto(Integer IdProducto, String Nombre, String Descripcion,Integer Cantidad, Integer precio, Integer impuesto) {
 String query = "INSERT INTO Producto (IdProducto, Nombre, Descripcion,Cantidad ,Preciounitario, Impuesto) VALUES (?,?, ?, ?, ?, ?)";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setInt(1, IdProducto);
     statement.setString(2, Nombre);
     statement.setString(3, Descripcion);
     statement.setInt(4, Cantidad);
     statement.setInt(5,   precio);
     statement.setInt(6,  impuesto);

     statement.executeUpdate();
 } catch (SQLException e) {
     e.printStackTrace();
 }
}

public void eliminarProducto(int Id) {
 String query = "DELETE FROM Producto WHERE Id = ?";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setInt(1, Id);
     int rowsAffected = statement.executeUpdate();

     if (rowsAffected > 0) {
         System.out.println("Producto eliminado correctamente");
     } else {
         System.out.println("No se encontró ningún producto con el ID especificado");
     }
 } catch (SQLException e) {
     e.printStackTrace();
     System.err.println("Error al eliminar producto");
 }
}

//Método para modificar un producto en la base de datos
public  void modificarProducto(Integer Id, String Nombre, String Descripcion,Integer Cantidad, Integer precio, Integer impuesto) {
 String query = "UPDATE Producto SET Nombre = ?, Descripcion = ?,Cantidad = ?, Preciounitario = ?, Impuesto = ? WHERE IdProducto = ?";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setString(1, Nombre);
     statement.setString(2, Descripcion);
     statement.setInt(3, Cantidad);
     statement.setInt(4, precio);
     statement.setInt(5,  impuesto);
     statement.setInt(6, Id);

     int rowsAffected = statement.executeUpdate();
     if (rowsAffected > 0) {
         System.out.println("Producto modificado correctamente");
     } else {
         System.out.println("No se encontró ningún producto con el ID especificado");
     }
 } catch (SQLException e) {
     e.printStackTrace();
     System.err.println("Error al modificar producto");
 }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public void closeConection(Connection conn) {
	try {
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void closeResultSet(ResultSet rs) {
	try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void closeStatement(PreparedStatement st) {
	try {
		st.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}





public Producto getProductInfo(	String Id) {
	Producto data = null;
	Connection conn = this.getConnection();
	try {
		String query = "select * from Producto where Id=?";
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, Id);
		ResultSet res = st.executeQuery();
		res.next();
		data = new Producto(res.getInt(1), res.getString(2), res.getString(3),res.getInt(4),res.getInt(5),res.getInt(6));
		this.closeResultSet(res);
		this.closeStatement(st);
		this.closeConection(conn);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
}
		
public int getMaxId() {
	int val = 0;
	Connection conn = this.getConnection();
	try {
		
		String query = "select MAX(Id) from Factura";
		PreparedStatement st = conn.prepareStatement(query);
		ResultSet res = st.executeQuery();
		res.next();
		val=res.getInt(1)+1;
		
		this.closeResultSet(res);
		this.closeStatement(st);
		this.closeConection(conn);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return val;
}


public Cliente getClientInfo(String id){
	Cliente data = null;
	Connection conn = this.getConnection();
	try {
		
		String query = "select * from Cliente where Id=? ";
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, id);
		ResultSet res = st.executeQuery();
		res.next();
		data = new Cliente(res.getInt(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5), res.getString(6));
		
		this.closeResultSet(res);
		this.closeStatement(st);
		this.closeConection(conn);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return data;
	}

public boolean saveFactura(Factura factura) {
    boolean data = false;
    Connection conn = this.getConnection();
    try {
        String query = "INSERT INTO Factura(Id, Fecha) VALUES (?, ?)";
        String query2 = "INSERT INTO facturaproducto(IdFactura, IdProducto, Cantidad) VALUES (?, ?, ?)";

        PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement st2 = conn.prepareStatement(query2);

        st.setInt(1, factura.getCliente().getId());
        st.setDate(2, factura.getFecha() != null ? new Date(factura.getFecha().getTime()) : null);

        int modified = st.executeUpdate();

        if (modified == 1) {
            ResultSet pks = st.getGeneratedKeys();
            int pk = -1;

            if (pks.next()) {
                pk = Integer.parseInt(pks.getString(1)); // Convertir el valor de la clave generada a Integer
            }

            for (facturaproducto f : factura.getProductos()) {
                st2.setInt(1, pk);
                st2.setInt(2, f.getProdu().getId());
                st2.setInt(3, f.getCantidad());
                st2.addBatch();
            }

            int[] batchResult = st2.executeBatch();

            for (int result : batchResult) {
                if (result <= 0) {
                    throw new SQLException("Error al insertar facturaproducto");
                }
            }

            this.closeResultSet(pks);
        }
		conn.commit();
		this.closeStatement(st);
		data = true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		try {
			conn.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}finally {
		
		this.closeConection(conn);
	}
	return data;
}


public Factura getFacturaInfo(String id){
	Factura data = null;
	Connection conn = this.getConnection();
	try {
		
		String query = "select f.Id, b.Fecha, fp.Cantidad, p.IdProducto, p.Nombre, p.Preciounitario from Factura "
				+ "f left outer join facturaproducto fp on fp=f.Id left outer join Producto p"
				+ " on p.Id=fp.Id Where f.Id=?";
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(1, id);
		ResultSet res = st.executeQuery();
		data = new Factura(Integer.parseInt(id), null, null, query, null);
		Date fecha=null;
		int cliente = 0;
		if(!res.next()) {
			return data;
		}
		do {
			Producto p = new Producto(res.getInt(5), res.getString(6),res.getString(7), res.getInt(8),res.getInt(9),res.getInt(10));
			facturaproducto fp = new facturaproducto(data, p, res.getInt(4));
			data.addfacturaproducto(fp);
			if  (fecha == null) {
				fecha = res.getDate(3);
				cliente = res.getInt(2);
				System.out.print(cliente);
			}
			}while(res.next());
			data.setFecha(fecha);
			this.closeResultSet(res);
			this.closeStatement(st);
			PreparedStatement st2 = conn.prepareStatement("select Id, Nombre, Telefono, correoElectronico from Cliente where Id=?");
			st2.setInt(1, cliente);
			ResultSet res1= st2.executeQuery();
			res1.next();
			Cliente c1 = new Cliente(cliente,res1.getString(1), res1.getString(2), res1.getString(3), res1.getString(4),res1.getString(5));
			data.setCliente(c1);
			this.closeConection(conn);	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return data;
}

public void addAll(List<facturaproducto> productos) {
	// TODO Auto-generated method stub
	
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









	
		
	

























