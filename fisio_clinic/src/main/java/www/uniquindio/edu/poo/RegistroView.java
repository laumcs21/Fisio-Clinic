package www.uniquindio.edu.poo;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistroView {

    private FisioClinic fisioClinic;

    public RegistroView(Stage stage) {
        fisioClinic = FisioClinic.getInstancia();

        // Configuración de los TextField con su propio PromptText
        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre");

        TextField apellidoField = new TextField();
        apellidoField.setPromptText("Apellido");

        TextField identificacionField = new TextField();
        identificacionField.setPromptText("Identificación");

        TextField numeroField = new TextField();
        numeroField.setPromptText("Número");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField contraseñaField = new PasswordField();
        contraseñaField.setPromptText("Contraseña");

        // Botón para registrar usuario
        Button registrarButton = new Button("Registrar");
        registrarButton.setOnAction(e -> {
            // Crear un nuevo Usuario con los datos ingresados
            Usuario nuevoUsuario = new Usuario(
                    nombreField.getText(),
                    apellidoField.getText(),
                    identificacionField.getText(),
                    numeroField.getText(),
                    emailField.getText(),
                    LocalDate.now(),
                    contraseñaField.getText());

            // Llamada al CRUD para guardar el nuevo usuario
            fisioClinic.getUsuarioCRUD().crear(nuevoUsuario);
            fisioClinic.guardarUsuariosRegistrados(); // Guardar automáticamente al registrar
        });

        // Agregar los componentes a un VBox y establecer márgenes
        VBox root = new VBox(10, nombreField, apellidoField, identificacionField, numeroField, emailField,
                contraseñaField, registrarButton);
        root.setPadding(new Insets(20)); // Márgenes alrededor de los componentes

        // Crear y configurar la escena
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Registrar Usuario");
    }
}
