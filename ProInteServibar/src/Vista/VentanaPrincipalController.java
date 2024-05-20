 package Vista;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import Controlador.Basedatos;
import Controlador.Cliente;
import Controlador.Persona;
import Controlador.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class VentanaPrincipalController<BigDecimal> implements Initializable {

    @FXML
    private Button BuscarVendedorbtn;
    
    @FXML
    private Label Cedula;

    @FXML
    private TableColumn<Persona, String> CedulaNueVenTable;

    @FXML
    private TextField CedulaNuevoVendeor;

    @FXML
    private Label CerrarSesionlabel;

    @FXML
    private Label Clientelabel;

    @FXML
    private TableColumn<Persona, String> CorreoNueVenTable;

    @FXML
    private TextField CorreoNuevoVendedor;

    @FXML
    private Button EliminarVendedorbtn;

    @FXML
    private Label GeneFactulabel;

    @FXML
    private Label GeneReporlabel;

    @FXML
    private TableColumn<Persona, String> IdNueVenTable;

    @FXML
    private TextField IdNuevoVendeor;

    @FXML
    private TableColumn<Persona, String>NombreNueVenTable;

    @FXML
    private TextField NombreNuevoVendedor;

    @FXML
    private Label Productolabel;

    @FXML
    private Label RealizarVenLabel;

    @FXML
    private Label RegisVenlabel;

    @FXML
    private Button RegistrarVendedorBtn;

    @FXML
    private TableColumn<Persona, String> TelefonoNueVenTable;

    @FXML
    private TextField TelefonoNuevoVendedor;

    @FXML
    private Button modificarVendedorbtn;

    @FXML
    private TabPane panelAdmin;

   
    @FXML
    private TableView<Persona> tableVendedor;
    

    @FXML
    private TableView<Persona> tableCliente;
    
    
    @FXML
    private TableColumn<Persona, String> CedulaNueClienteTable;

    @FXML
    private TextField CedulaNueClienteTxt;
    @FXML
    private TableColumn<Persona, String> CorreoNueClienteTable;

    @FXML
    private TextField CorreoNueClienteTxt;
    @FXML
    private TableColumn<Persona, String> DireccionNueClienteTable;

    @FXML
    private TextField DireccionNueClienteTxt;

    @FXML
    private TableColumn<Persona, String> IdNueClienteTable;

    @FXML
    private TextField IdNueClienteTxt;

    @FXML
    private TableColumn<Persona, String> NombreNueClienteTable;

    @FXML
    private TextField NombreNueClienteTxt;
    @FXML
    private TableColumn<Persona, String> TelefonoNueClienteTable;

    @FXML
    private TextField TelefonoNueClienteTxt;

   @FXML
    private Button buscarClientebtn;

    @FXML
    private Button eliminarClientebtn;

    @FXML
    private Button modificarClientebtn;
    @FXML
    private Button registrarClientebtn;
        
    @FXML
        private Button RegistrarProductoBtn;
    @FXML
        private Button ModificarProductoBtn;  
    @FXML
        private Button EliminarProductoBtn;
    	@FXML
        private Button BuscarProductoBtn;
      	

      	@FXML
        private TextField CantidadProductoTxt;
      	@FXML
        private TableColumn<Persona, String> IdProductoTable;

        @FXML
        private TextField IdProductoTxt;

        @FXML
        private TextField NombreProductoTxt;
        @FXML
        private TextField DescripcionProductoTxt;

        @FXML
        private TextField ImpuestoProductoTxt;

        @FXML
        private TextField PreciounitarioProductoTxt;

        @FXML
        private TableColumn<Persona, String> NombreProductoTable;
        
        @FXML
        private TableView<Persona> tableProducto;
       
        @FXML
        private TableColumn<Persona, String> DescripcionProductoTable;

        @FXML
        private TableColumn<Persona, BigDecimal> PreciounitarioProductoTable;

        @FXML
        private TableColumn<Persona, BigDecimal> ImpuestoProductoTable;
        @FXML
        private TableColumn<Persona, String> CantidadProductoTable;

   
    
    
 
    @FXML
    private Pane panelVenta;
    // Define una lista observable para almacenar los resultados de la búsqueda
    ObservableList<Persona> vendedoresEncontrados = FXCollections.observableArrayList();
    
       
    Basedatos data;
    
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        // Asignar las columnas de la tabla a los atributos correspondientes del objeto Vendedor
    	this.data = new Controlador.Basedatos();
        this.IdNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Id"));
        this.CedulaNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Cedula"));
        this.NombreNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        this.CorreoNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("correoElectronico"));
        this.TelefonoNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
        tableVendedor.setItems(this.vendedoresEncontrados);
        this.IdNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CedulaNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.NombreNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CorreoNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.TelefonoNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.data = new Controlador.Basedatos();
        this.IdNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Id"));
        this.CedulaNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Cedula"));
        this.NombreNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        this.CorreoNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("correoElectronico"));
        this.TelefonoNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
        this.DireccionNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Direccion")); 
        tableCliente.setItems(this.clientesEncontrados);
        this.IdNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CedulaNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.NombreNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CorreoNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.TelefonoNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.DireccionNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        
        cargarDatos();
        
        
        
        this.data = new Controlador.Basedatos();
        this.IdProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Id"));
        this.NombreProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        this.DescripcionProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Descripcion"));
        this.CantidadProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Cantidad"));
        this.PreciounitarioProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, BigDecimal>("Preciounitario"));
        this.ImpuestoProductoTable.setCellValueFactory(new PropertyValueFactory<Persona, BigDecimal>("Impuesto"));
        tableProducto.setItems(this.productosEncontrados);
        this.IdProductoTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.NombreProductoTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.DescripcionProductoTable.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
    }
    
    @FXML
    void OnIdNueVenTable(TableColumn.CellEditEvent<Vendedor, String> event) {
    	Vendedor vendedorSeleccionado = event.getRowValue();
        vendedorSeleccionado.setId(event.getNewValue());
    }   
    @FXML
    void OnCedulaNueVenTable(TableColumn.CellEditEvent<Vendedor, String> event) {
    	Vendedor vendedorSeleccionado = event.getRowValue();
        vendedorSeleccionado.setCedula(event.getNewValue());
    }
        
    @FXML
    void OnNombreNueVenTable(TableColumn.CellEditEvent<Vendedor, String> event) {
    	Vendedor vendedorSeleccionado = event.getRowValue();
        vendedorSeleccionado.setNombre(event.getNewValue());

    }
    @FXML
    void OnCorreoNueVenTable(TableColumn.CellEditEvent<Vendedor, String> event) {
    	Vendedor vendedorSeleccionado = event.getRowValue();
        vendedorSeleccionado.setCorreoElectronico(event.getNewValue());
    }
    @FXML
    void OnTelefonoNueVenTable(TableColumn.CellEditEvent<Vendedor, String> event) {
    	Vendedor vendedorSeleccionado = event.getRowValue();
        vendedorSeleccionado.setTelefono(event.getNewValue());
        Basedatos basedatos = new Basedatos();
        basedatos.modificarVendedor(vendedorSeleccionado.getId(),vendedorSeleccionado.getCedula(), vendedorSeleccionado.getNombre(), vendedorSeleccionado.getCorreoElectronico(), vendedorSeleccionado.getTelefono());
    }	
    	
    
    
    
    @FXML
    void selectTablaVen(MouseEvent event) {
    
    }

    

    @FXML
    public void OnBuscarVendedorbtn(MouseEvent event) {
    	vendedoresEncontrados.clear();
    	LinkedList<Persona> data1 = data.getDatos();
    	for(Persona a : data1) {
		vendedoresEncontrados.add(a);
    	}
        String Id = IdNuevoVendeor.getText().trim();
        String Cedula =CedulaNuevoVendeor.getText().trim();
        String Nombre = NombreNuevoVendedor.getText().trim();
        String correoElectronico = CorreoNuevoVendedor.getText().trim();
        String Telefono = TelefonoNuevoVendedor.getText().trim();

        Predicate<Vendedor> filtro = vendedor ->
                vendedor.getId().toLowerCase().contains(Id.toLowerCase()) &&
                vendedor.getCedula().toLowerCase().contains(Cedula.toLowerCase()) &&
                vendedor.getNombre().toLowerCase().contains(Nombre.toLowerCase()) &&
                vendedor.getCorreoElectronico().toLowerCase().contains(correoElectronico.toLowerCase()) &&
                vendedor.getTelefono().toLowerCase().contains(Telefono.toLowerCase());
                
         ObservableList<Persona> vendedoresFiltrados = FXCollections.observableArrayList();
         for (Persona vendedores : vendedoresEncontrados) {
         if (filtro.test ((Vendedor) vendedores)) {
        	 vendedoresFiltrados.add(vendedores);
         }
         }
         tableVendedor.setItems(vendedoresFiltrados);
    }

   	
    @FXML
    
    public void OnEliminarVendedorbtn(MouseEvent event) {
    
    	    String Cedula = IdNuevoVendeor.getText(); // Suponiendo que textFieldID es el campo de texto donde el usuario ingresa el ID del vendedor a eliminar
    	    
    	    if (!Cedula.isEmpty()) {
    	        Basedatos basedatos = new Basedatos();
    	        basedatos.eliminarVendedor(Cedula);
    	    } else {
    	        System.out.println("Por favor ingrese un ID válido.");
    	    }
    	}    

    @FXML
    public void OnRegistrarVendedorBtn(MouseEvent event) {
    	  String id = IdNuevoVendeor.getText();
    	  String cedula = CedulaNuevoVendeor.getText();
          String nombre = NombreNuevoVendedor.getText();
          String correoelectronico = CorreoNuevoVendedor.getText();
          String telefono = TelefonoNuevoVendedor.getText();
          
          Basedatos basedatos = new Basedatos();
		basedatos.registrarVendedor(id, cedula, nombre, correoelectronico, telefono);
      }
    @FXML
    public void OnmodificarVendedorbtn(MouseEvent event) {
    	
            String id = IdNuevoVendeor.getText();
            String cedula = CedulaNuevoVendeor.getText();
            String nombre = NombreNuevoVendedor.getText();
            String correo = CorreoNuevoVendedor.getText();
            String telefono = TelefonoNuevoVendedor.getText();

            Basedatos basedatos = new Basedatos();
            basedatos.modificarVendedor(id, cedula,  nombre, correo, telefono);
        }

    



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    ObservableList<Persona> clientesEncontrados = FXCollections.observableArrayList();
    
    
    
    public void cargarDatos() {
        clientesEncontrados.clear();
        LinkedList<Persona> data1 = data.getDatos1();
        for (Persona a : data1) {
            clientesEncontrados.add(a);
        }
    }

	@FXML
    void OnCedulaNueClienteTable(TableColumn.CellEditEvent<Persona, String> event) {
		Persona clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setCedula(event.getNewValue());
    }
    @FXML
    void OnCorreoNueClienteTable(TableColumn.CellEditEvent<Persona, String> event) {
    	Persona clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setCorreoElectronico(event.getNewValue());
    }
    @FXML
    void OnDireccionNueClienteTable(TableColumn.CellEditEvent<Persona, String> event) {
    	Persona clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setDireccion(event.getNewValue());
    }
    @FXML
    void OnIdNueClienteTable(TableColumn.CellEditEvent<Persona, String> event) {
    	Persona clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setId(event.getNewValue());
    }
    @FXML
    void OnNombreNueClienteTable(TableColumn.CellEditEvent<Cliente, String> event) {
    	Cliente clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setNombre(event.getNewValue());
    }
    @FXML
    void OnTelefonoNueClienteTable(TableColumn.CellEditEvent<Cliente, String> event) {
    	Cliente clienteSeleccionado = event.getRowValue();
        clienteSeleccionado.setTelefono(event.getNewValue());
        Basedatos basedatos = new Basedatos();
        basedatos.modificarCliente(clienteSeleccionado.getId(),clienteSeleccionado.getCedula(), clienteSeleccionado.getNombre(), clienteSeleccionado.getCorreoElectronico(), clienteSeleccionado.getTelefono(),clienteSeleccionado.getDireccion());

    }
    @FXML
    void selectTablaClien(MouseEvent event) {

    }    
    
    @FXML
void OnBuscarClientebtn(MouseEvent event) {
    	
    	
    	    clientesEncontrados.clear(); // Asegúrate de que esta lista existe y es de tipo LinkedList<Cliente>
    	    LinkedList<Persona> data2 = data.getDatos1(); // Asume que data.getDatos() devuelve una lista de Clientes
    	    for(Persona a : data2) {
    	        clientesEncontrados.add(a); // Añade todos los clientes encontrados a la lista
    	    }
    	    
    	    String Id = IdNueClienteTxt.getText().trim(); // Asume que estos campos existen en tu interfaz
    	    String Cedula = CedulaNueClienteTxt.getText().trim();
    	    String Nombre = NombreNueClienteTxt.getText().trim();
    	    String correoElectronico = CorreoNueClienteTxt.getText().trim();
    	    String Telefono = TelefonoNueClienteTxt.getText().trim();
    	    String Direccion = DireccionNueClienteTxt.getText().trim();

    	    Predicate<Persona> filtro = cliente ->
    	            cliente.getId().toLowerCase().contains(Id.toLowerCase()) &&
    	            cliente.getCedula().toLowerCase().contains(Cedula.toLowerCase()) &&
    	            cliente.getNombre().toLowerCase().contains(Nombre.toLowerCase()) &&
    	            cliente.getCorreoElectronico().toLowerCase().contains(correoElectronico.toLowerCase()) &&
    	            cliente.getTelefono().toLowerCase().contains(Telefono.toLowerCase()) &&
    	            cliente.getDireccion().toLowerCase().contains(Direccion.toLowerCase());

    	    ObservableList<Persona> clientesFiltrados = FXCollections.observableArrayList();
    	    for (Persona cliente : clientesEncontrados) {
    	        if (filtro.test((Cliente) cliente)) {
    	            clientesFiltrados.add(cliente);
    	        }
    	    }
    	    tableCliente.setItems(clientesFiltrados); // Asume que tableCliente es una TableView de tipo Cliente
    	}
@FXML
void OnEliminarClientebtn(MouseEvent event) {
	

    String Cedula = IdNueClienteTxt.getText(); 
    
    if (!Cedula.isEmpty()) {
        Basedatos basedatos = new Basedatos();
        basedatos.eliminarCliente(Cedula);
    } else {
        System.out.println("Por favor ingrese un ID válido.");
    }
}

@FXML
void OnModificarClientebtn(MouseEvent event) {
	
	String id = IdNueClienteTxt.getText();
    String cedula = CedulaNueClienteTxt.getText();
    String nombre = NombreNueClienteTxt.getText();
    String correo = CorreoNueClienteTxt.getText();
    String telefono = TelefonoNueClienteTxt.getText();
    String direccion = DireccionNueClienteTxt.getText();
   

    Basedatos basedatos = new Basedatos();
    basedatos.modificarCliente(id, cedula,  nombre, correo, telefono, direccion);
}
@FXML
void OnRegistrarClientebtn(MouseEvent event) {
	
	  String id = IdNueClienteTxt.getText();
	  String cedula = CedulaNueClienteTxt.getText();
      String nombre = NombreNueClienteTxt.getText();
      String correoelectronico = CorreoNueClienteTxt.getText();
      String telefono = TelefonoNueClienteTxt.getText();
      String direccion = DireccionNueClienteTxt.getText();
      
      Basedatos basedatos = new Basedatos();
	basedatos.registrarCliente(id, cedula, nombre, correoelectronico, telefono, direccion);
  }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@FXML
void selectTablaProducto(MouseEvent event) {

}

ObservableList<Persona> productosEncontrados = FXCollections.observableArrayList();


@FXML
void OnIdProductoTable(TableColumn.CellEditEvent<Persona, String> event) {
	Persona productoSeleccionado = event.getRowValue();
    productoSeleccionado.setId(event.getNewValue());
    
}
@FXML
void OnNombreProductoTable(TableColumn.CellEditEvent<Persona, String> event) {
	Persona productoSeleccionado = event.getRowValue();
    productoSeleccionado.setNombre(event.getNewValue());
}
@FXML
void OnDescripcionProductoTable(TableColumn.CellEditEvent<Persona, String> event) {
	Persona productoSeleccionado = event.getRowValue();
    productoSeleccionado.setDescripcion(event.getNewValue());
}

@FXML
void OnPreciounitarioProductoTable() {

}
@FXML
void OnImpuestoProductoTable() {

}
@FXML
void OnCantidadProductoTable(TableColumn.CellEditEvent<Persona, String> event) {
	Persona productoSeleccionado = event.getRowValue();
    productoSeleccionado.setCantidad(event.getNewValue());    
    Basedatos basedatos = new Basedatos();
    basedatos.modificarProducto(productoSeleccionado.getId(),productoSeleccionado.getNombre(), productoSeleccionado.getDescripcion(), productoSeleccionado.getCantidad(),productoSeleccionado.getPreciounitario(), productoSeleccionado.getImpuesto());

    }

@FXML
void OnBuscarProductoBtn(MouseEvent event) {
	 

    
	productosEncontrados.clear(); // Asegúrate de que esta lista existe y es de tipo LinkedList<Cliente>
    LinkedList<Persona> data3 = data.getDatos2(); // Asume que data.getDatos() devuelve una lista de Clientes
    for(Persona a : data3) {
    	((List<Persona>) productosEncontrados).add(a); // Añade todos los clientes encontrados a la lista
    }
    
    String IdProducto = IdProductoTxt.getText().trim(); // Asume que estos campos existen en tu interfaz
    String Nombre = NombreProductoTxt.getText().trim();
    String Cantidad = CantidadProductoTxt.getText().trim();
    String descripcion = DescripcionProductoTxt.getText().trim();
    BigDecimal Preciounitario = (BigDecimal) PreciounitarioProductoTxt.getText().trim();
    BigDecimal Impuesto = (BigDecimal) ImpuestoProductoTxt.getText().trim();

    Predicate<Persona> filtro = producto ->
            producto.getId().toLowerCase().contains(IdProducto.toLowerCase()) &&
            producto.getNombre().toLowerCase().contains(Nombre.toLowerCase()) &&
            producto.getDescripcion().toLowerCase().contains(descripcion.toLowerCase()) &&
            producto.getCantidad().toLowerCase().contains(Cantidad.toLowerCase()) &&
            producto.getPreciounitario().abs().equals(((java.math.BigDecimal) Preciounitario).abs()) &&
            producto.getImpuesto().abs().equals(((((java.math.BigDecimal) Impuesto).abs())));

    ObservableList<Persona> productosFiltrados = FXCollections.observableArrayList();
    for (Persona Producto: clientesEncontrados) {
        if (filtro.test((Persona) Producto)) {
        	productosFiltrados.add(Producto);
        }
    }
    tableProducto.setItems(productosFiltrados); // Asume que tableCliente es una TableView de tipo Cliente
}

@FXML
void OnEliminarProductoBtn(MouseEvent event) {
	
    String Id = IdProductoTxt.getText(); 
    
    if (!Id.isEmpty()) {
        Basedatos basedatos = new Basedatos();
        basedatos.eliminarProducto(Id);
    } else {
        System.out.println("Por favor ingrese un ID válido.");
    }
}
@FXML
void OnModificarProductoBtn(MouseEvent event) {
	
	String Id = IdProductoTxt.getText();
    String nombre = NombreProductoTxt.getText();
    String descripcion = DescripcionProductoTxt.getText();
    String Cantidad = CantidadProductoTxt.getText();
    BigDecimal precio = (BigDecimal) PreciounitarioProductoTxt.getText();
    BigDecimal impuesto = (BigDecimal) ImpuestoProductoTxt.getText();
    
    Basedatos basedatos = new Basedatos();
	basedatos.registrarProducto(Id, nombre, descripcion,Cantidad, precio, impuesto);

}
@FXML
void OnRegistrarProductoBtn(MouseEvent event) {
	
	String Id = IdProductoTxt.getText();
    String nombre = NombreProductoTxt.getText();
    String descripcion = DescripcionProductoTxt.getText();
    String Cantidad = CantidadProductoTxt.getText();
    BigDecimal precio = (BigDecimal) PreciounitarioProductoTxt.getText();
    BigDecimal impuesto = (BigDecimal) ImpuestoProductoTxt.getText();
    
    Basedatos basedatos = new Basedatos();
	basedatos.registrarProducto(Id, nombre, descripcion,Cantidad ,precio, impuesto);



}



}



