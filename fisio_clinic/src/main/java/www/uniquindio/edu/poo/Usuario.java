package www.uniquindio.edu.poo;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String contraseña;

    public Usuario(String nombre, String apellido, String identificacion, String numeroCelular, String email,
            LocalDate fechaNacimiento, String Contraseña) {
        super(nombre, apellido, identificacion, numeroCelular, email, fechaNacimiento);

        this.contraseña = contraseña;

        assert contraseña != null;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
