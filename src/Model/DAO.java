package Model;

import java.util.ArrayList;

public interface DAO<T>{
    public void guardar(T elemento) throws DAOException;
    public void modificar(T elemento) throws DAOException;
    public void eliminar(long id) throws DAOException;
    public T buscar(long id) throws DAOException;
    public ArrayList buscarTodos() throws DAOException;

}