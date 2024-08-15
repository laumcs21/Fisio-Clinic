package www.uniquindio.edu.poo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class CitaCRUD implements CRUD<Cita> {
    private Collection<Usuario> usuarios = new ArrayList<>();

    public Optional<Usuario> buscarUsuarioPorIdentificacion(String identificacion) {
        Predicate<Usuario> condicion = usuario -> usuario.getIdentificacion().equals(identificacion);
        return usuarios.stream().filter(condicion).findAny();
    }

    @Override
    public void actualizar(Cita cita) {
        boolean existeUsuario = buscarUsuarioPorIdentificacion(usuario.getIdentificacion()).isPresent();
        if (!existeUsuario) {
            throw new IllegalArgumentException("El usuario no está registrado.");
        }
        usuarios.remove(usuario);
        usuarios.add(usuario);

    }

    @Override
    public void crear(Cita cita) {
        boolean existeUsuario = buscarUsuarioPorIdentificacion(usuario.getIdentificacion()).isPresent();
        if (existeUsuario) {
            throw new IllegalArgumentException("El usuario ya está registrado.");
        }
        usuarios.add(usuario);

    }

    @Override
    public void eliminar(String identificacion) {
        Optional<Usuario> usuario = buscarUsuarioPorIdentificacion(identificacion);
        if (!usuario.isPresent()) {
            throw new IllegalArgumentException("El usuario no está registrado.");
        }
        usuarios.remove(usuario.get());

    }

    @Override
    public Usuario leer(String identificacion) {
        Optional<Usuario> usuario = buscarUsuarioPorIdentificacion(identificacion);
        if (!usuario.isPresent()) {
            throw new IllegalArgumentException("El usuario no está registrado.");
        }
        return usuario.get();
    }
}
