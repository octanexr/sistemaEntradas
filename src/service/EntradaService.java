package service;

import Controlador.Comprador;
import Controlador.Entrada;
import Model.DAOEntrada;
import Model.DAOException;

import java.util.ArrayList;

public class EntradaService {

    private DAOEntrada daoEntrada;

    public EntradaService(){
        daoEntrada = new DAOEntrada();
    }

    public void guardarEntrada(Entrada entrada) throws ServiceException {
        try {
            daoEntrada.guardar(entrada);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }


    }

    public void eliminarEntrada(long id) throws ServiceException{
        try {
            daoEntrada.eliminar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Entrada buscarEntrada(long id) throws ServiceException{
        Entrada entrada;
        try {
            entrada = daoEntrada.buscar(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return entrada;
    }

    public ArrayList<Entrada> buscarTodosUsuarioEntrada(String mail) throws ServiceException{
        try {
            return daoEntrada.buscarTodosUsuario(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public ArrayList<Entrada> cargarEntradas(Comprador comprador1) throws DAOException {
        ArrayList<Entrada> entradas = new ArrayList<>();

        entradas = daoEntrada.buscarTodosUsuario(comprador1.getMailUsuario());
        comprador1.setEntradas(entradas);

        return entradas;
    }



}
