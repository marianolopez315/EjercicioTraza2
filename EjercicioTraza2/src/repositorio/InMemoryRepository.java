package repositorio;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import java.util.*;

// T es la entidad (entidades.Categoria, entidades.Articulo, etc.)
public class InMemoryRepository<T> {
    private Map<Long, T> storage = new HashMap<>();

    // Crear o guardar entidad
    public void save(Long id, T entity) {
        storage.put(id, entity);
    }

    // Buscar por id
    public T findById(Long id) {
        return storage.get(id);
    }

    // Obtener todas las entidades
    public Collection<T> findAll() {
        return storage.values();
    }

    // Actualizar entidad (igual a save, porque si existe reemplaza)
    public void update(Long id, T entity) {
        if (storage.containsKey(id)) {
            storage.put(id, entity);
        } else {
            throw new NoSuchElementException("No existe entidad con id " + id);
        }
    }

    // Eliminar por id
    public void delete(Long id) {
        storage.remove(id);
    }

    // Saber si existe
    public boolean exists(Long id) {
        return storage.containsKey(id);
    }
}

