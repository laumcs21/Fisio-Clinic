package www.uniquindio.edu.poo;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InicioSesionView {

    private FisioClinic fisioClinic;

    public InicioSesionView(Stage stage) {
        fisioClinic = FisioClinic.getInstancia();

        // Configuración de los TextField con su propio PromptText
        TextField identificacionField = new TextField();
        identificacionField.setPromptText("Identificación");

        TextField contraseñaField = new PasswordField();
        contraseñaField.setPromptText("Contraseña");

        Button IniciarButton = new Button("Iniciar Sesión");
        IniciarButton.setOnAction(e -> {
                    nombreField.getText(),
                    apellidoField.getText(),            
}
    }
}
