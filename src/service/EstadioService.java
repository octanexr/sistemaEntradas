package service;

import Controlador.Estadio;
import Model.DAOEstadio;
import Model.DAOException;

import java.io.InputStream;
import java.util.ArrayList;

public class EstadioService {

    private DAOEstadio daoEstadio;

    public EstadioService(){
        daoEstadio = new DAOEstadio();
    }

    public void guardarEstadio(Estadio estadio) throws ServiceException{
        try {
            daoEstadio.guardar(estadio);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Estadio buscar(long id) throws ServiceException{
        Estadio estadio;
        try {
            estadio = daoEstadio.buscar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return estadio;

    }

    public ArrayList<Estadio> buscarTodosEstadio() throws ServiceException{
        try {
            return daoEstadio.buscarTodos();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }


    }

    public byte[] buscarImagenEstadio(long id) throws ServiceException {
        try {
            return daoEstadio.buscarImagenEstadio(id);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }


    }

    public void subirImagenEstadio(long id, byte[] imagenesByte) throws ServiceException{
        try {
            daoEstadio.subirImagenEstadio(id,imagenesByte);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }
    }


}
