package www.uniquindio.edu.poo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private FisioClinic fisioClinic;

    @Override
    public void start(Stage primaryStage) {
        fisioClinic = FisioClinic.getInstancia(); // Singleton

        Button registrarButton = new Button("Registrar Usuario");
        Button loginButton = new Button("Iniciar Sesión");

        registrarButton.setOnAction(e -> mostrarPantallaRegistro(primaryStage));
        loginButton.setOnAction(e -> mostrarPantallaLogin(primaryStage));

        VBox root = new VBox(10, registrarButton, loginButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FisioClinic - Inicio");
        primaryStage.show();
    }

    private void mostrarPantallaRegistro(Stage stage) {
        new RegistroView(stage);
    }

    private void mostrarPantallaLogin(Stage stage) {
    }

    public static void main(String[] args) {
        launch(args);
    }
}