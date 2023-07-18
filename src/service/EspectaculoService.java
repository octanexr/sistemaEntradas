package service;

import Controlador.Espectaculo;
import Model.DAOEspectaculo;
import Model.DAOException;

import java.util.ArrayList;

public class EspectaculoService {

    private DAOEspectaculo daoEspectaculo;

    public EspectaculoService(){
        daoEspectaculo = new DAOEspectaculo();
    }

    public void guardarEspectaculo(Espectaculo espectaculo) throws ServiceException{
        try {
            daoEspectaculo.guardar(espectaculo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Espectaculo buscarEspectaculo(long id) throws ServiceException{
        Espectaculo espectaculo;
        try {
            espectaculo = daoEspectaculo.buscar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return espectaculo;
    }

    public ArrayList<Espectaculo> buscarTodosEspectaculo() throws ServiceException{
        try {
            return daoEspectaculo.buscarTodos();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public void modificarEspectaculo(Espectaculo espectaculo) throws ServiceException{
        try {
            daoEspectaculo.modificar(espectaculo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public void modificarEspectaculo2(Espectaculo espectaculo) throws ServiceException{
        try {
            daoEspectaculo.modificar2(espectaculo);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public ArrayList<Espectaculo> buscarTodosEspectaculosPorVendedor(String nombre) throws ServiceException{
        try {
            return daoEspectaculo.buscarTodosPorVemdedor(nombre);
        } catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }


}
