package Controlador;

import service.EstadioService;
import service.ServiceException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Estadio {
    private long codEstadio;
    private String nombreEstadio;
    private int capacidadMaxima;
    private int cantPlatea;
    private int cantCampo;
    private int cantVip;
    private int precioPlatea;
    private int precioCampo;
    private int precioVip;
    private byte[] bytesImagen;

    public Estadio(long codEstadio, String nombreEstadio, int capacidadMaxima, int cantPlatea, int cantCampo, int cantVip,int precioPlatea,int precioCampo,int precioVip,byte[] bytes) {
        this.codEstadio = codEstadio;
        this.nombreEstadio = nombreEstadio;
        this.capacidadMaxima = capacidadMaxima;
        this.cantPlatea = cantPlatea;
        this.cantCampo = cantCampo;
        this.cantVip = cantVip;
        this.precioPlatea = precioPlatea;
        this.precioCampo = precioCampo;
        this.precioVip = precioVip;
        this.bytesImagen = bytes;
    }

    public Estadio(){

    }



    public void asignarLugar(){

    }

    public void registrarEstadio(int cantCampo, int cantPlatea, int cantVip, int capacidadMaxima, Estadio estadio){
        EstadioService estadioService = new EstadioService();

        if(cantCampo+cantPlatea+cantVip <= capacidadMaxima) {

            try {
                estadioService.guardarEstadio(estadio);
                JOptionPane.showMessageDialog(null, "Se registro el estadio con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "La suma de los asientos es mayor a la cantidad maxima", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public byte[] buscarImagenEstadio(Estadio estadio) throws ServiceException {
        EstadioService estadioService = new EstadioService();
        return estadioService.buscarImagenEstadio(estadio.getCodEstadio());

    }

    public ArrayList<Estadio> cargarEstadios(EstadioService estadioService) throws ServiceException{
        ArrayList<Estadio> estadios = new ArrayList<>();

        estadios = estadioService.buscarTodosEstadio();

        for(Estadio estadio:estadios){
            estadio.setBytesImagen(buscarImagenEstadio(estadio));
            System.out.println(estadio.toString2());
        }



        return estadios;
    }

    public JComboBox<Estadio> cargarEstadios2(EstadioService estadioService, JComboBox<Estadio> estadiosComboBox) throws ServiceException{
        try{
            ArrayList<Estadio> estadios = estadioService.buscarTodosEstadio();
            for(Estadio a:estadios){
                estadiosComboBox.addItem(a);
            }
        }catch (ServiceException e){
            throw new RuntimeException(e);
        }

        return estadiosComboBox;
    }

    public long getCodEstadio() {
        return codEstadio;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantPlatea() {
        return cantPlatea;
    }

    public int getCantCampo() {
        return cantCampo;
    }

    public int getCantVip() {
        return cantVip;
    }

    public int getPrecioPlatea() {
        return precioPlatea;
    }

    public int getPrecioCampo() {
        return precioCampo;
    }

    public int getPrecioVip() {
        return precioVip;
    }

    public byte[] getBytesImagen() {
        return bytesImagen;
    }

    public String toString(){
        return nombreEstadio;
    }

    public void setCodEstadio(long codEstadio) {
        this.codEstadio = codEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCantPlatea(int cantPlatea) {
        this.cantPlatea = cantPlatea;
    }

    public void setCantCampo(int cantCampo) {
        this.cantCampo = cantCampo;
    }

    public void setCantVip(int cantVip) {
        this.cantVip = cantVip;
    }

    public void setPrecioPlatea(int precioPlatea) {
        this.precioPlatea = precioPlatea;
    }

    public void setPrecioCampo(int precioCampo) {
        this.precioCampo = precioCampo;
    }

    public void setPrecioVip(int precioVip) {
        this.precioVip = precioVip;
    }

    public void setBytesImagen(byte[] bytesImagen) {
        this.bytesImagen = bytesImagen;
    }


    public String toString2() {
        return "Estadio{" +
                "codEstadio=" + codEstadio +
                ", nombreEstadio='" + nombreEstadio + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", cantPlatea=" + cantPlatea +
                ", cantCampo=" + cantCampo +
                ", cantVip=" + cantVip +
                ", precioPlatea=" + precioPlatea +
                ", precioCampo=" + precioCampo +
                ", precioVip=" + precioVip +
                ", bytesImagen=" + //Arrays.toString(bytesImagen) +
                '}';
    }


}
