 package Vista;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Controlador.Basedatos;
import Controlador.Cliente;
import Controlador.Factura;
import Controlador.Persona;
import Controlador.Producto;
import Controlador.Vendedor;
import Controlador.facturaproducto;
import Graficar.Factorychart;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class VentanaPrincipalController implements Initializable {

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
    private TableColumn<Persona, Integer> IdNueVenTable;

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
    private TableColumn<Persona, Integer> IdNueClienteTable;

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
        private TableColumn<Producto, Integer> IdProductoTable;

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
        private TableColumn<Producto, String> NombreProductoTable;
        
        @FXML
        private TableView<Producto> tableProducto;
       
        @FXML
        private TableColumn<Producto, String> DescripcionProductoTable;

        @FXML
        private TableColumn<Producto, Integer> PreciounitarioProductoTable;

        @FXML
        private TableColumn<Producto, Integer> ImpuestoProductoTable;
        @FXML
        private TableColumn<Producto, Integer> CantidadProductoTable;
        
        @FXML
        private Label totalLBL;
        @FXML
        private Label idFacturalabel;
        @FXML
        private TextField idclienterealizartxt;

        @FXML
        private TextField nombrerealizartxt;

        @FXML
        private TextField correorealizartxt;

        @FXML
        private TextField telefonorealizartxt;
        
        @FXML
        private TextField idproductorealizartxt;

        @FXML
        private TextField cantidadrealizartxt;        

        @FXML
        private TextField consultarfacturarealizartxt;
        
        @FXML
        private Button agregarrealizarBtn;
        @FXML
        private Button pagarrealizarBtn;
        @FXML
        private Button consultarrealizarBtn;
        
        @FXML
        private TableView<Persona> tableFacturaProducto;
        @FXML
        private TableColumn<Persona,Integer> idproductorealizarcolum ;
        @FXML
        private TableColumn<Persona, String> productorealizarcolum;
        @FXML
        private TableColumn<Persona, Integer> preciorealizarcolum;
        @FXML
        private TableColumn<Persona, Integer> cantidadrealizarcolum;
        @FXML
        private TableColumn<Persona, Integer> totalrealizarcolum;
        @FXML
        private AnchorPane chartGrafic;
        @FXML
        private BarChart<Persona, String> barcharrrr;
        @FXML

        private LineChart<String, Integer> graficaLineas;
        
        ObservableList<Persona> data2;
        
        Persona dataprovider;
        Factorychart graficador;
        Factura facturaActual;
        Cliente actualCliente; 
        Controlador.DatosFactory datareal;
        
        /*
         * 
         * ventana pricnipal para que corra el cod de la grafica 
         */
        
        public VentanaPrincipalController(Factorychart graficador) {
    		this.graficador = graficador;
    		JSONParser parser = new JSONParser();
    		try {
    			JSONObject res =(JSONObject) parser.parse(new FileReader("./settings.json"));
    			String type = res.get("source").toString();
    			if(type.equals("oracle")) {
    				datareal = new Controlador.OracleFactory();
    				dataprovider = new Basedatos();
    			}else if(type.equals("json")) {
    				datareal = new Controlador.JsonFactory();
    				dataprovider = new Controlador.DatosJson();
    			}
    		} catch (IOException | ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
             
     
 
    @FXML
    private Pane panelVenta;
    // Define una lista observable para almacenar los resultados de la búsqueda
    ObservableList<Persona> vendedoresEncontrados = FXCollections.observableArrayList();
    
       
    Basedatos data;
    
   
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
*       INICIALIZADOR DE LA TABLA VENDEDOR
* */
    	this.data = new Controlador.Basedatos();
        this.IdNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("Id"));
        this.CedulaNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Cedula"));
        this.NombreNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        this.CorreoNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("correoElectronico"));
        this.TelefonoNueVenTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
        tableVendedor.setItems(this.vendedoresEncontrados);
        this.IdNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn((new StringConverter<Integer>() {
    		@Override
    		public String toString(Integer val){
    			return val.toString();
    		}
    		@Override
    		public Integer fromString(String val) {
    			return Integer.parseInt(val);
    		}
            })));
        this.CedulaNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.NombreNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CorreoNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.TelefonoNueVenTable.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
*       INICIALIZADOR DE LA TABLA CLIENTE
* */
        this.data = new Controlador.Basedatos();
        this.IdNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("Id"));
        this.CedulaNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Cedula"));
        this.NombreNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
        this.CorreoNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("correoElectronico"));
        this.TelefonoNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));
        this.DireccionNueClienteTable.setCellValueFactory(new PropertyValueFactory<Persona, String>("Direccion")); 
        tableCliente.setItems(this.clientesEncontrados);
        this.IdNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
		@Override
		public String toString(Integer val){
			return val.toString();
		}
		@Override
		public Integer fromString(String val) {
			return Integer.parseInt(val);
		}
        }));
        this.CedulaNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.NombreNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CorreoNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.TelefonoNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.DireccionNueClienteTable.setCellFactory(TextFieldTableCell.forTableColumn());
        
        cargarDatos();
        
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
*       INICIALIZADOR DE LA TABLA PRODUCTO
* */
        this.data = new Controlador.Basedatos();        
        this.IdProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("Id"));
        this.NombreProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, String>("Nombre"));
        this.DescripcionProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, String>("Descripcion"));
        this.CantidadProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("Cantidad"));
        this.PreciounitarioProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("Preciounitario"));
        this.ImpuestoProductoTable.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("Impuesto"));
        tableProducto.setItems(this.productosEncontrados);
        this.IdProductoTable.setCellFactory(TextFieldTableCell.forTableColumn(((new StringConverter<Integer>() {
    		@Override
    		public String toString(Integer val){
    			return val.toString();
    		}
    		@Override
    		public Integer fromString(String val) {
    			return Integer.parseInt(val);
    		}
            }))));
        this.NombreProductoTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.DescripcionProductoTable.setCellFactory(TextFieldTableCell.forTableColumn());
        this.CantidadProductoTable.setCellFactory(TextFieldTableCell.forTableColumn(((new StringConverter<Integer>() {
    		@Override
    		public String toString(Integer val){
    			if (val==null) {
    				return "0";
    			}
    			return val.toString();
    		}
    		@Override
    		public Integer fromString(String val) {
    			return Integer.parseInt(val);
    		}
            }))));
        this.PreciounitarioProductoTable.setCellFactory(TextFieldTableCell.forTableColumn(((new StringConverter<Integer>() {
    		@Override
    		public String toString(Integer val){
    			if (val==null) {
    				return "0";
    			}
    			return val.toString();
    		}
    		@Override
    		public Integer fromString(String val) {
    			return Integer.parseInt(val);
    		}
            }))));
        this.ImpuestoProductoTable.setCellFactory(TextFieldTableCell.forTableColumn(((new StringConverter<Integer>() {
    		@Override
    		public String toString(Integer val){
    			if (val==null) {
    				return "0";
    			}
    			return val.toString();
    		}
    		@Override
    		public Integer fromString(String val) {
    			return Integer.parseInt(val);
    		}
            }))));
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
*    INICIALIZADOR DE LA TABLA E INTERFAZ FACTURAPRODUCTO
* */
     this.data = new Controlador.Basedatos();
     idproductorealizarcolum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProdu().getId()).asObject());
     productorealizarcolum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProdu().getNombre())); 
     preciorealizarcolum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProdu().getPreciounitario()).asObject()); 
     cantidadrealizarcolum.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getProdu().getCantidad()).asObject()); 
     totalrealizarcolum.setCellValueFactory(cellData -> new SimpleIntegerProperty(( cellData.getValue().getProdu()).getTotal()).asObject()); 
     data2 = FXCollections.observableArrayList();
     tableFacturaProducto.setItems(data2);
     dataprovider = new Basedatos();
     
     Integer id = dataprovider.getMaxId();
     facturaActual = new Factura(id, null, null, null, null);
     this.idFacturalabel.setText(id.toString());
     
     this.idclienterealizartxt.focusedProperty().addListener((observable, oldval, newval) -> {
         if (this.idclienterealizartxt.getText().length()> 0 &&!newval) { 
        	 /*String clienteTexto = this.idclienterealizartxt.getText();
             if (!clienteTexto.isEmpty()) {*/
                 actualCliente = dataprovider.getClientInfo(this.idclienterealizartxt.getText());
                 this.nombrerealizartxt.setText(actualCliente.getNombre());
                 this.correorealizartxt.setText(actualCliente.getCorreoElectronico());
                 this.telefonorealizartxt.setText(actualCliente.getTelefono());
             }
         
     });


     this.graficador.crearLineas(chartGrafic);

     
     /*
      * Esta parte dle cod, es para editar las celdas en las tablas       */
        
    }
    
    
	@FXML
    void OnIdNueVenTable(TableColumn.CellEditEvent<Vendedor, Integer> event) {
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

    /*
     * BOTONES DE BUSCAR, ELIMINAR,REGISTRAR Y  MODIFICAR  VENDEDOR
     */

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
        vendedor.getId().toString().toLowerCase().contains(Id.toLowerCase()) &&
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
    	int id = Integer.parseInt(IdNuevoVendeor.getText());
    	  String cedula = CedulaNuevoVendeor.getText();
          String nombre = NombreNuevoVendedor.getText();
          String correoelectronico = CorreoNuevoVendedor.getText();
          String telefono = TelefonoNuevoVendedor.getText();
          
          Basedatos basedatos = new Basedatos();
		basedatos.registrarVendedor(id, cedula, nombre, correoelectronico, telefono);
      }
    @FXML
    public void OnmodificarVendedorbtn(MouseEvent event) {
    	
            int id = Integer.parseInt(IdNuevoVendeor.getText());
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
    
    /*
     * ESTO ES PARA EDITAR LA CELDAS DE CLIENTE EN SU TABLA 
     */


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
    void OnIdNueClienteTable(TableColumn.CellEditEvent<Persona, Integer> event) {
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

    	
    	
    	/*
         * BOTONES DE BUSCAR, ELIMINAR,REGISTRAR Y  MODIFICAR  CLIENTE
         */

    }    
    
    @FXML
void OnBuscarClientebtn(MouseEvent event) {
    	
    	
    	    clientesEncontrados.clear(); // Asegúrate de que esta lista existe y es de tipo LinkedList<Cliente>
    	    LinkedList<Persona> data1 = data.getDatos1(); // Asume que data.getDatos() devuelve una lista de Clientes
    	    for(Persona a : data1) {
    	        clientesEncontrados.add(a); // Añade todos los clientes encontrados a la lista
    	    }
    	    
    	    String Id = IdNueClienteTxt.getText().trim(); 
    	    String Cedula = CedulaNueClienteTxt.getText().trim();
    	    String Nombre = NombreNueClienteTxt.getText().trim();
    	    String correoElectronico = CorreoNueClienteTxt.getText().trim();
    	    String Telefono = TelefonoNueClienteTxt.getText().trim();
    	    String Direccion = DireccionNueClienteTxt.getText().trim();

    	    Predicate<Persona> filtro = cliente -> {
    	        Integer idCliente = cliente.getId() != null ? Integer.parseInt(cliente.getId().toString()) : null;
    	        String cedulaCliente = cliente.getCedula() != null ? cliente.getCedula().toLowerCase() : "";
    	        String nombreCliente = cliente.getNombre() != null ? cliente.getNombre().toLowerCase() : "";
    	        String correoCliente = cliente.getCorreoElectronico() != null ? cliente.getCorreoElectronico().toLowerCase() : "";
    	        String telefonoCliente = cliente.getTelefono() != null ? cliente.getTelefono().toLowerCase() : "";
    	        String direccionCliente = cliente.getDireccion() != null ? cliente.getDireccion().toLowerCase() : "";

    	        return idCliente != null && idCliente.equals(idCliente) &&
    	               cedulaCliente.contains(Cedula.toLowerCase()) &&
    	               nombreCliente.contains(Nombre.toLowerCase()) &&
    	               correoCliente.contains(correoElectronico.toLowerCase()) &&
    	               telefonoCliente.contains(Telefono.toLowerCase()) &&
    	               direccionCliente.contains(Direccion.toLowerCase());
    	    };


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
	
	int id = Integer.parseInt(IdNueClienteTxt.getText());
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
	
	  int id = Integer.parseInt(IdNueClienteTxt.getText());
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

ObservableList<Producto> productosEncontrados = FXCollections.observableArrayList();


/*
 * EDITAR EN LA TABLA PRODUCTO LOS CAMPOS SELECCCIOANDOS Y /*
     * BOTONES DE BUSCAR, ELIMINAR,REGISTRAR Y  MODIFICAR  PRODUCTO
 */


@FXML
void OnIdProductoTable(TableColumn.CellEditEvent<Producto, Integer> event) {
	Producto productoSeleccionado = event.getRowValue();
    productoSeleccionado.setId(event.getNewValue());
    
}
@FXML
void OnNombreProductoTable(TableColumn.CellEditEvent<Producto, String> event) {
	Producto productoSeleccionado = event.getRowValue();
    productoSeleccionado.setNombre(event.getNewValue());
}
@FXML
void OnDescripcionProductoTable(TableColumn.CellEditEvent<Producto, String> event) {
	Producto productoSeleccionado = event.getRowValue();
    productoSeleccionado.setDescripcion(event.getNewValue());
}

@FXML
void OnPreciounitarioProductoTable() {

}
@FXML
void OnImpuestoProductoTable() {

}
@FXML
void OnCantidadProductoTable(TableColumn.CellEditEvent<Persona, Integer> event) {
	Persona productoSeleccionado = event.getRowValue();
    productoSeleccionado.setCantidad(event.getNewValue());
    Basedatos basedatos = new Basedatos();
    basedatos.modificarProducto(productoSeleccionado.getId(),productoSeleccionado.getNombre(), productoSeleccionado.getDescripcion(), productoSeleccionado.getCantidad(),productoSeleccionado.getPreciounitario(), productoSeleccionado.getImpuesto());

    }

@FXML
void OnBuscarProductoBtn(MouseEvent event) {
	 

    
	productosEncontrados.clear(); // Asegúrate de que esta lista existe y es de tipo LinkedList<Cliente>
	LinkedList<Producto> data3 = data.getDatos2(); // Asume que data.getDatos() devuelve una lista de Clientes
	for(Producto a : data3) {
	    ((List<Producto>) productosEncontrados).add(a); // Añade todos los clientes encontrados a la lista
	}

	Integer IdProducto = Integer.parseInt(IdProductoTxt.getText()); // Asume que estos campos existen en tu interfaz
	String Nombre = NombreProductoTxt.getText().trim();
	Integer Cantidad = Integer.parseInt(CantidadProductoTxt.getText());
	String descripcion = DescripcionProductoTxt.getText().trim();
	Integer Preciounitario = Integer.parseInt(PreciounitarioProductoTxt.getText());
	Integer Impuesto = Integer.parseInt(ImpuestoProductoTxt.getText());

	Predicate<Producto> filtro = producto -> {
		// Asumiendo que producto es un objeto de tu clase Producto
		Integer idproducto = producto.getId()!= null? Integer.parseInt(producto.getId().toString()): null;
		String nombreProducto = producto.getNombre()!= null? producto.getNombre().toLowerCase() : "";
		String descripcionProducto = producto.getDescripcion()!= null? producto.getDescripcion().toLowerCase() : "";
		Integer cantidadProducto = producto.getCantidad()!= null? Integer.parseInt(producto.getCantidad().toString()) : null;
		Integer preciounitarioProducto = producto.getPreciounitario()!= null? Integer.parseInt(producto.getPreciounitario().toString()) : null;
		Integer impuestoProducto = producto.getImpuesto()!= null? Integer.parseInt(producto.getImpuesto().toString()) : null;

		return idproducto!= null && idproducto.equals(idproducto) &&
		       nombreProducto.contains(Nombre.toLowerCase()) &&
		       descripcionProducto.contains(descripcion.toLowerCase()) &&
		       cantidadProducto != null && cantidadProducto.equals(cantidadProducto) &&
		       preciounitarioProducto != null && Preciounitario.equals(preciounitarioProducto) &&
		       impuestoProducto != null && Impuesto.equals(impuestoProducto);


	};

	ObservableList<Producto> productosFiltrados = FXCollections.observableArrayList();
	for (Producto producto : productosEncontrados) { // Corrección en el nombre del parámetro
	    if (filtro.test(producto)) { // Corrección en la condición del filtro
	        double impuesto = producto.getPreciounitario() * 0.19; // Cálculo del impuesto como double
	        producto.setImpuesto((int) impuesto); // Conversión a int antes de establecer el impuesto
	        productosFiltrados.add(producto); // Agregar el producto a la lista filtrada
	    }
	}


	  tableProducto.setItems(productosFiltrados);
    // Asume que tableCliente es una TableView de tipo Cliente
}



@FXML
void OnEliminarProductoBtn(MouseEvent event) {
    String idStr = IdProductoTxt.getText(); // Obtener el texto del campo de ID como cadena
    
    // Verificar si el campo de ID está vacío
    if (idStr.isEmpty()) {
        System.out.println("Por favor ingrese un ID válido.");
        return; // Salir del método si el campo de ID está vacío
    }
    
    try {
        int id = Integer.parseInt(idStr); // Intentar convertir la cadena a un entero
        Basedatos basedatos = new Basedatos();
        basedatos.eliminarProducto(id); // Eliminar el producto con el ID especificado
    } catch (NumberFormatException e) {
        System.out.println("ID inválido. Por favor ingrese un número entero.");
    }
}

@FXML
void OnModificarProductoBtn(MouseEvent event) {
	
	int Id = Integer.parseInt(IdProductoTxt.getText());
    String nombre = NombreProductoTxt.getText();
    String descripcion = DescripcionProductoTxt.getText();
    int Cantidad = Integer.parseInt (CantidadProductoTxt.getText());
    int precio = Integer.parseInt (PreciounitarioProductoTxt.getText());
    int impuesto = Integer.parseInt (ImpuestoProductoTxt.getText());
    
    Basedatos basedatos = new Basedatos();
	basedatos.registrarProducto(Id, nombre, descripcion,Cantidad, precio, impuesto);

}
@FXML
void OnRegistrarProductoBtn(MouseEvent event) {
	
	Integer Id = Integer.parseInt(IdProductoTxt.getText());
    String nombre = NombreProductoTxt.getText();
    String descripcion = DescripcionProductoTxt.getText();
    Integer Cantidad = Integer.parseInt(CantidadProductoTxt.getText());
    Integer precio =  Integer.parseInt(PreciounitarioProductoTxt.getText());
    Integer impuesto = Integer.parseInt( ImpuestoProductoTxt.getText());
    
    Basedatos basedatos = new Basedatos();
	basedatos.registrarProducto(Id, nombre, descripcion,Cantidad ,precio, impuesto);



}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
ObservableList<Persona> facturaproductosEncontrados = FXCollections.observableArrayList();


/*
 * AQUI YA MANEJAMOS UNA INTERFAZ PARA CONTROLAR LOS DATOS ASIGNADOS A LA ABLA FACTURAPRODUCTO */




public void cargarDatos1() {
    facturaproductosEncontrados.clear();
    LinkedList<Producto> data2 = data.getDatos2();
    for (Producto a : data2) {
        productosEncontrados.add(a);
    }
}

@FXML
void selectTablaFacturaProducto(MouseEvent event) {

}

@FXML
void OnpagarrealizarBtn(MouseEvent event) {
    // Verifica si facturaActual es null antes de intentar usarlo
    if (this.facturaActual == null) {
        // Manejar el caso donde facturaActual es null, por ejemplo, inicializándolo
        this.facturaActual = new Factura(null, null, actualCliente, null, null);
    }
    
    this.facturaActual.setCliente(actualCliente);
    this.facturaActual.setFecha(null);
    
    Cliente cliente = this.facturaActual.getCliente();
    if (cliente != null) {
        // Verifica si el cliente no es null antes de acceder a su id
        int Id = cliente.getId();
        System.out.println("ID del cliente: " + Id);
        
        if (this.datareal.saveFactura(facturaActual)) {
            Alert alt = new Alert(AlertType.CONFIRMATION);
            alt.setContentText("Guardado");
            alt.setHeaderText("Se generó la factura");
            alt.show();
        } else {
            Alert alt = new Alert(AlertType.ERROR);
            alt.setContentText("Error ");
            alt.setHeaderText("Se generó un error");
            alt.show();
        }
    } else {
        // Maneja el caso donde el cliente de la factura es null
        Alert alt = new Alert(AlertType.ERROR);
        alt.setContentText("Error ");
        alt.setHeaderText("La factura no tiene un cliente asignado");
        alt.show();
    }
    
    this.data2.clear();
}


@FXML
void OnagregarrealizarBtn(MouseEvent event) {
    Producto nuevo = dataprovider.getProductInfo(this.idproductorealizartxt.getText());
        facturaproducto nuevoB = new facturaproducto(facturaActual, nuevo, Integer.parseInt(this.cantidadrealizartxt.getText()));
        facturaActual.addfacturaproducto(nuevoB);
        data2.clear();
        data.addAll(facturaActual.getProductos());
        this.totalLBL.setText(facturaActual.getTotal().toString());
        this.idproductorealizartxt.clear();
        this.cantidadrealizartxt.clear();
}



@FXML
void OnconsultarrealizarBtn(MouseEvent event) {
	this.data2.clear();
	facturaActual = dataprovider.getFacturaInfo(this.consultarfacturarealizartxt.getText());
	if (facturaActual != null && facturaActual.getCliente() != null) {
	    // Código a ejecutar si facturaActual y facturaActual.getCliente() no son null
	

		this.data.addAll(facturaActual.getProductos());
		actualCliente = facturaActual.getCliente();
		this.idclienterealizartxt.setText(actualCliente.getCliente().toString());
		this.nombrerealizartxt.setText(actualCliente.getNombre());
		this.correorealizartxt.setText(actualCliente.getCorreoElectronico());
		this.telefonorealizartxt.setText(actualCliente.getTelefono());
	}else {
		Alert alt = new Alert(AlertType.ERROR);
		alt.setContentText("Error ");
		alt.setHeaderText("La factura no existe");
		alt.show();
	}

}




























}



