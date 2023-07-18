package service;

import Controlador.Comprador;
import Controlador.Vendedor;
import Model.DAOComprador;
import Model.DAOException;
import Model.DAOVendedor;

import java.util.ArrayList;

public class CompradorService {

    private DAOComprador daoComprador;


    public CompradorService() {
        daoComprador = new DAOComprador();
    }

    public void guardarComprador(Comprador comprador) throws ServiceException {
        try {
            daoComprador.guardar(comprador);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void eliminarComprador(long id) throws ServiceException {
        try {
            daoComprador.eliminar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void modificarComprador(Comprador comprador) throws ServiceException {
        try {
            daoComprador.modificar(comprador);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public void EliminarComprador(long id) throws ServiceException{
        try {
            daoComprador.eliminar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Comprador buscar2Comprador(String mail) throws ServiceException{
        Comprador comprador;
        try {
            comprador = daoComprador.buscar2(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return comprador;
    }

    public boolean buscarEsAdmin(String mail) throws ServiceException{
        Boolean esAdmin=false;
        try {
            esAdmin = daoComprador.buscarEsAdmin(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return esAdmin;
    }





}



