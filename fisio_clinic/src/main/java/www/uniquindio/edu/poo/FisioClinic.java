package www.uniquindio.edu.poo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class FisioClinic {

    private static final String ARCHIVO_USUARIOS = "usuarios.ser";
    private Map<String, Usuario> usuariosRegistrados;
    private static FisioClinic instancia;
    private Collection<Usuario> usuarios;
    private Collection<Doctor> doctor;
    private Collection<Cita> citas;
    private UsuarioCRUD usuarioCRUD;

    public FisioClinic() {

        this.usuarios = new ArrayList<>();
        this.doctor = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.usuarioCRUD = new UsuarioCRUD();

    }

    // Método estático para obtener la única instancia de FisioClinic
    public static FisioClinic getInstancia() {
        if (instancia == null) {
            instancia = new FisioClinic();
        }
        return instancia;
    }

    public Collection<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Collection<Doctor> getDoctor() {
        return this.doctor;
    }

    public Collection<Cita> getCitas() {
        return this.citas;
    }

    public UsuarioCRUD getUsuarioCRUD() {
        return usuarioCRUD;
    }

    private Map<String, Usuario> cargarUsuariosRegistrados() {
        Map<String, Usuario> usuariosCargados = new HashMap<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
            usuariosCargados = (Map<String, Usuario>) in.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("El archivo de usuarios registrados no existe.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar usuarios registrados: " + e.getMessage());
        }
        return usuariosCargados;
    }

    public boolean registrarUsuario(String nombre, String apellido, String identificacion, String numeroCelular,
            String email,
            LocalDate fechaNacimiento, String contrasena) {
        if (!usuariosRegistrados.containsKey(identificacion)) {
            Usuario usuario = new Usuario(nombre, apellido, identificacion, numeroCelular, email, fechaNacimiento,
                    contrasena);
            usuariosRegistrados.put(identificacion, usuario);
            guardarUsuariosRegistrados();
            return true;
        }
        return false;
    }

    public void guardarUsuariosRegistrados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            out.writeObject(usuariosRegistrados);
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios registrados: " + e.getMessage());
        }
    }

    // Método para cargar datos desde un archivo
    public static void cargarDatos(String archivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            instancia = (FisioClinic) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el archivo de usuarios. Usando la instancia existente.");
            // No se crea una nueva instancia, se utiliza la existente
        }
    }

    // Método para guardar datos en un archivo
    public void guardarDatos(String archivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(instancia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}