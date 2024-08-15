package www.uniquindio.edu.poo;

public interface CRUD<T> {
    void crear(T objeto);

    T leer(String id);

    void actualizar(T objeto);

    void eliminar(String id);
}
