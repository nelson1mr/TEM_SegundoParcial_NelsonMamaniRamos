
package com.emergentes.dao;
import com.emergentes.modelo.Libro;
import java.util.List;

public interface LibroDAO {
    public void insert(Libro aviso) throws Exception;
    public void update(Libro aviso) throws Exception;
    public void delete(int id ) throws Exception;
    public List<Libro> getAll() throws Exception;
    public Libro getById(int id) throws Exception;
}
