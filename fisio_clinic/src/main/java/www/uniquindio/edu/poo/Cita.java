package www.uniquindio.edu.poo;

import java.time.LocalDate;
import java.io.Serializable;

public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;

    private Usuario usuario;
    private TipoTerapia tipoTerapia;
    private LocalDate fechaCita;
    private HorasDisponibles horaCita;
    private Doctor doctor;

    public Cita(Usuario usuario, TipoTerapia tipoTerapia, LocalDate fechaCita, HorasDisponibles horaCita,
            Doctor doctor) {
        this.usuario = usuario;
        this.tipoTerapia = tipoTerapia;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.doctor = doctor;

        assert usuario != null;
        assert doctor != null;
        assert fechaCita != null;
        assert horaCita != null;
        assert tipoTerapia != null;
    }

    public TipoTerapia getTipoTerapia() {
        return tipoTerapia;
    }

    public void setTipoTerapia(TipoTerapia tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public HorasDisponibles getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(HorasDisponibles horaCita) {
        this.horaCita = horaCita;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
