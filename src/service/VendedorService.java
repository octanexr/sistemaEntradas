package service;

import Controlador.Comprador;
import Controlador.Vendedor;
import Model.DAOException;
import Model.DAOVendedor;

import java.util.ArrayList;

public class VendedorService {

    private DAOVendedor daoVendedor;

    public VendedorService(){
        daoVendedor = new DAOVendedor();
    }

    public void guardarVendedor(Vendedor vendedor) throws ServiceException{
        try {
            daoVendedor.guardar(vendedor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Vendedor buscar2Vendedor(String mail) throws ServiceException{
        Vendedor vendedor;
        try {
            vendedor = daoVendedor.buscar2(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return vendedor;
    }

    public boolean buscarEsVendedor(String mail) throws ServiceException {
        Boolean esVendedor= null;
        try {
            esVendedor = daoVendedor.buscarEsVendedor(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return esVendedor;
    }

    public ArrayList<Vendedor> buscarTodosVendedor() throws ServiceException{
        try {
            return daoVendedor.buscarTodosVendedor();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }


    }


}
