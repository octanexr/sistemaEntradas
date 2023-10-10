package service;

import Controlador.Estadio;
import Model.DAOEstadio;
import Model.DAOException;

import javax.swing.*;
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


    public void registrarEstadio(int cantCampo, int cantPlatea, int cantVip, int capacidadMaxima, Estadio estadio){

        if(cantCampo+cantPlatea+cantVip <= capacidadMaxima) {

            try {
                daoEstadio.guardar(estadio);
                JOptionPane.showMessageDialog(null, "Se registro el estadio con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "La suma de los asientos es mayor a la cantidad maxima", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<Estadio> cargarEstadios() throws DAOException {
        ArrayList<Estadio> estadios = new ArrayList<>();

        estadios = daoEstadio.buscarTodos();

        for(Estadio estadio:estadios){
            estadio.setBytesImagen(daoEstadio.buscarImagenEstadio(estadio.getCodEstadio()));
            System.out.println(estadio.toString2());
        }



        return estadios;
    }

    public JComboBox<Estadio> cargarEstadios2(JComboBox<Estadio> estadiosComboBox) throws ServiceException{
        try{
            ArrayList<Estadio> estadios = daoEstadio.buscarTodos();
            for(Estadio a:estadios){
                estadiosComboBox.addItem(a);
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return estadiosComboBox;
    }





}
