package Vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;
import Controlador.Basedatos;
import Controlador.Vendedor;
import Controlador.Session;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;

public class Login1Controller {
    @FXML
    private Label lbUsuario;
    @FXML
    private Label lbContraseña;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContraseña;
    @FXML
    private CheckBox checkRegistrar;
    @FXML
    private Button btnEnter;
    
    private Basedatos dataprovider = new Basedatos();

    // Event Listener on Button[#btnEnter].onAction
    @FXML
    public void btnIniciaSesion(ActionEvent event) throws SQLException {
        // Validación de campos
        if (txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos Vacíos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, completa todos los campos.");
            alert.showAndWait();
            return;
        }

        // Verificación de credenciales
        Vendedor vendedor = dataprovider.login(txtUsuario.getText(), txtContraseña.getText());

        if (vendedor!= null) {
            // Credenciales correctas, procede con la autenticación del usuario
            Session session = new Session(); // Asumiendo que tienes una clase Session para manejar sesiones de usuario
            Stage stage = (Stage) btnEnter.getScene().getWindow(); // Obtener la ventana actual
            stage.close(); // Cierra la ventana de inicio de sesión

            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Vista/VentanaPrincipal.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Credenciales incorrectas, muestra un mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de Autenticación");
            alert.setHeaderText(null);
            alert.setContentText("Nombre de usuario o contraseña incorrectos.");
            alert.showAndWait();
        }
    }
}
