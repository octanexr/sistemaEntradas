package Controlador;

import service.EspectaculoService;
import service.ServiceException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Espectaculo {
    private long codEspectaculo;
    private String nombreEspectaculo;
    private long codEstadio;
    private Entrada entrada;
    private int cantEntradas;
    private String fechaEvento;
    private String mailVendedor;

    private int precioEspectaculo;

    public Espectaculo(long codEspectaculo, String nombreEvento, Long codEstadio, Entrada entrada, int cantEntradas, String fechaEvento) {
        this.codEspectaculo = codEspectaculo;
        this.nombreEspectaculo = nombreEvento;
        this.codEstadio = codEstadio;
        this.entrada = entrada;
        this.cantEntradas = cantEntradas;
        this.fechaEvento = fechaEvento;
    }

    public Espectaculo(long codEspectaculo,String nombreEspectaculo, int cantEntradas, String fechaEvento, long codEstadio,int precioEspectaculo, String mailVendedor){
        this.codEspectaculo = codEspectaculo;
        this.nombreEspectaculo = nombreEspectaculo;
        this.cantEntradas = cantEntradas;
        this.fechaEvento = fechaEvento;
        this.codEstadio = codEstadio;
        this.precioEspectaculo=precioEspectaculo;
        this.mailVendedor = mailVendedor;

    }

    public Espectaculo() {
    }

    public void asignarEstadio(Estadio estadio){

    }

    public void definirCantEntradas(Entrada entrada){

    }

    public long getCodEspectaculo() {
        return codEspectaculo;
    }

    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }


    public Entrada getEntrada() {
        return entrada;
    }

    public void guardarEspectaculo(Espectaculo espectaculo, int capacidadMaxima){
        EspectaculoService espectaculoService = new EspectaculoService();

        if(cantEntradas<=capacidadMaxima) {

            try {
                espectaculoService.guardarEspectaculo(espectaculo);
                JOptionPane.showMessageDialog(null, "Se registro el espectaculo con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

        }
        else
            JOptionPane.showMessageDialog(null, "La cantidad de entradas es mayor a la capacidad maxima", "Error", JOptionPane.ERROR_MESSAGE);

    }

    public ArrayList<Espectaculo> cargarEspectaculos() throws ServiceException {
        EspectaculoService espectaculoService = new EspectaculoService();
        ArrayList <Espectaculo> espectaculos = espectaculoService.buscarTodosEspectaculo();
        return espectaculos;
    }

    public void restarEntradas(Espectaculo espectaculo) throws ServiceException {
        EspectaculoService espectaculoService = new EspectaculoService();

        espectaculoService.modificarEspectaculo(espectaculo);
        espectaculo.setCantEntradas(espectaculo.getCantEntradas() - 1) ;

    }

    public void sumarEntradas(Espectaculo espectaculo) throws ServiceException{
        EspectaculoService espectaculoService = new EspectaculoService();
        espectaculoService.modificarEspectaculo2(espectaculo);
        espectaculo.setCantEntradas(espectaculo.getCantEntradas()+1);

    }


    public int getCantEntradas() {
        return cantEntradas;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public int getPrecioEspectaculo() {
        return precioEspectaculo;
    }

    public void setCodEspectaculo(long codEspectaculo) {
        this.codEspectaculo = codEspectaculo;
    }

    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }

    public void setCodEstadio(Estadio estadio){
        this.codEstadio = estadio.getCodEstadio();
    }

    public long getCodEstadio(){
        return codEstadio;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public void setCantEntradas(int cantEntradas) {
        this.cantEntradas = cantEntradas;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setPrecioEspectaculo(int precioEspectaculo) {
        this.precioEspectaculo = precioEspectaculo;
    }

    public void setCodEstadio(long codEstadio) {
        this.codEstadio = codEstadio;
    }

    public String toString(){return nombreEspectaculo + " | " + fechaEvento;}

    public String getMailVendedor() {
        return mailVendedor;
    }

    public void setMailVendedor(String mailVendedor) {
        this.mailVendedor = mailVendedor;
    }


}
