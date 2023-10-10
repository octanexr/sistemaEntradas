package service;

import Controlador.Espectaculo;
import Controlador.Vendedor;
import Model.DAOEspectaculo;
import Model.DAOException;

import javax.swing.*;
import java.util.ArrayList;

public class EspectaculoService {

    private DAOEspectaculo daoEspectaculo;

    public EspectaculoService(){
        daoEspectaculo = new DAOEspectaculo();
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

    public void restarEntradas(Espectaculo espectaculo) throws DAOException {

        daoEspectaculo.modificar(espectaculo);
        espectaculo.setCantEntradas(espectaculo.getCantEntradas() - 1) ;

    }

    public void sumarEntradas(Espectaculo espectaculo) throws DAOException {
        daoEspectaculo.modificar2(espectaculo);
        espectaculo.setCantEntradas(espectaculo.getCantEntradas()+1);

    }

    public JComboBox<Espectaculo> cargarEspectaculos(JComboBox<Espectaculo> espectaculoComboBox){
        try {
            ArrayList<Espectaculo> espectaculos = daoEspectaculo.buscarTodos();
            EstadioService estadioService = new EstadioService();
            for(Espectaculo espectaculo:espectaculos){

                espectaculo.setEstadio(estadioService.buscar(espectaculo.getCodEstadio()));

                espectaculoComboBox.addItem(espectaculo);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return espectaculoComboBox;

    }

    public ArrayList<Espectaculo> cargarEspectaculos2() throws ServiceException, DAOException {
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        espectaculos = daoEspectaculo.buscarTodos();
        EstadioService estadioService = new EstadioService();
        for(Espectaculo espectaculo: espectaculos){
            espectaculo.setEstadio(estadioService.buscar(espectaculo.getCodEstadio()));
            System.out.println(espectaculo.toString2());
        }

        return espectaculos;
    }

    public void guardarEspectaculo(Espectaculo espectaculo, int capacidadMaxima){

        if(espectaculo.getCantEntradas()<=capacidadMaxima) {

            try {
                daoEspectaculo.guardar(espectaculo);
                JOptionPane.showMessageDialog(null, "Se registro el espectaculo con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }

        }
        else
            JOptionPane.showMessageDialog(null, "La cantidad de entradas es mayor a la capacidad maxima", "Error", JOptionPane.ERROR_MESSAGE);

    }


    public ArrayList<Espectaculo> cargarEspectaculoVendedor(Vendedor vendedor) throws ServiceException, DAOException {
        EstadioService estadioService = new EstadioService();
        ArrayList<Espectaculo> espectaculos = new ArrayList<>();
        espectaculos = daoEspectaculo.buscarTodosPorVemdedor(vendedor.getMailUsuario());

        for(Espectaculo espectaculo: espectaculos){
            espectaculo.setEstadio(estadioService.buscar(espectaculo.getCodEstadio()));
            System.out.println(espectaculo.toString2());
        }

        vendedor.setEspectaculos(espectaculos);

        return espectaculos;
    }



}
