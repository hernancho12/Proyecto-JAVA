package Controlador;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;



public class Basedatos {
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
	}
	
	public LinkedList<Persona> getDatos(){
		LinkedList<Persona> data = new LinkedList<Persona>();
		Connection conn = this.getConnection();
		Statement st;
		try {
			st = conn.createStatement();
			String query = "select * from Vendedor";
			ResultSet result = st.executeQuery(query);
			while(result.next()) {
				 System.out.println("Leyendo datos de Vendedor...");
				data.add(new Vendedor(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7)));
				System.out.println("Vendedor agregado: " + data.getLast());
			}
			result.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
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
				user=new Vendedor(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	  // Método para agregar un vendedor a la base de datos
    public  void registrarVendedor(String Id, String Cedula, String Nombre, String correoElectronico, String Telefono ) {
    	String query = "INSERT INTO Vendedor (Id, Cedula, Nombre, correoElectronico, Telefono) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
        	statement.setString(1, Nombre);
            statement.setString(2, Cedula);
            statement.setString(3, correoElectronico);
            statement.setString(4, Telefono);
            statement.setString(5, Id);
            
            
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
    public void modificarVendedor(String Id,String Cedula, String Nombre, String correoElectronico, String Telefono) {
        String query = "UPDATE Vendedor SET Nombre = ?, Cedula = ?, correoElectronico = ?, Telefono = ? WHERE Id = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, Nombre);
            statement.setString(2, Cedula);
            statement.setString(3, correoElectronico);
            statement.setString(4, Telefono);
            statement.setString(5, Id);
            
            
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
	            String id = result.getString(1);
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


	
	
	
	
	
	
	
	public void registrarCliente(String Id, String Cedula, String Nombre, String correoElectronico, String Telefono, String Direccion ) {
    String query = "INSERT INTO Cliente (Id, Cedula, Nombre, correoElectronico, Telefono, Direccion) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, Id);
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




public void modificarCliente(String Id, String Cedula, String Nombre, String correoElectronico, String Telefono, String Direccion) {
    String query = "UPDATE Cliente SET Cedula =?, Nombre =?, correoElectronico =?, Telefono =?, Direccion =? WHERE Id =?"; // Corrección aquí

    try (Connection conn = getConnection();
         PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setString(1, Cedula);
        statement.setString(2, Nombre);
        statement.setString(3, correoElectronico);
        statement.setString(4, Telefono);
        statement.setString(5, Direccion);
        statement.setString(6, Id); 
        
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




public LinkedList<Persona> getDatos2(){
    LinkedList<Persona> data3 = new LinkedList<Persona>();
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
            String IdProducto = result.getString(1);
            String  Nombre = result.getString(2);
            String Descripcion = result.getString(3);
            String Cantidad = result.getString(4);
            BigDecimal Preciounitario = result.getBigDecimal(5);
            BigDecimal Impuesto = result.getBigDecimal(6);
            
            
            Persona nuevoProducto = new Producto(IdProducto, Nombre,Descripcion,Cantidad, Preciounitario, Impuesto);
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
public <BigDecimal> void registrarProducto(String IdProducto, String Nombre, String Descripcion,String Cantidad, BigDecimal precio, BigDecimal impuesto) {
 String query = "INSERT INTO Producto (IdProducto, Nombre, Descripcion,Cantidad ,Preciounitario, Impuesto) VALUES (?,?, ?, ?, ?, ?)";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setString(1, IdProducto);
     statement.setString(2, Nombre);
     statement.setString(3, Descripcion);
     statement.setString(4, Cantidad);
     statement.setBigDecimal(5, (java.math.BigDecimal) precio);
     statement.setBigDecimal(6, (java.math.BigDecimal) impuesto);

     statement.executeUpdate();
 } catch (SQLException e) {
     e.printStackTrace();
 }
}

public void eliminarProducto(String IdProducto) {
 String query = "DELETE FROM Producto WHERE IdProducto = ?";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setString(1, IdProducto);
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
public <BigDecimal> void modificarProducto(String IdProducto, String Nombre, String Descripcion,String Cantidad, BigDecimal Preciounitario, BigDecimal Impuesto) {
 String query = "UPDATE Producto SET Nombre = ?, Descripcion = ?,Cantidad = ?, Preciounitario = ?, Impuesto = ? WHERE IdProducto = ?";

 try (Connection conn = getConnection();
      PreparedStatement statement = conn.prepareStatement(query)) {
     statement.setString(1, Nombre);
     statement.setString(2, Descripcion);
     statement.setString(3, Cantidad);
     statement.setBigDecimal(4, (java.math.BigDecimal) Preciounitario);
     statement.setBigDecimal(5, (java.math.BigDecimal) Impuesto);
     statement.setString(6, IdProducto);

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


}





















