package www.uniquindio.edu.poo;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    public TipoTerapia tipoTerapia;

    public Doctor(String nombre, String apellido, String identificacion, String numeroCelular, String email,
            LocalDate fechaNacimiento, TipoTerapia tipoTerapia) {
        super(nombre, apellido, identificacion, numeroCelular, email, fechaNacimiento);

        this.tipoTerapia = tipoTerapia;

        assert tipoTerapia != null;
    }

    public TipoTerapia getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(TipoTerapia tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

}
