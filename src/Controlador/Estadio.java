package Controlador;

import service.EstadioService;
import service.ServiceException;

import javax.swing.*;
import java.sql.Connection;
import java.util.Random;

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
    private byte[] bytes;

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
        this.bytes = bytes;
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

    public int getPrecioPlatea() {
        return precioPlatea;
    }

    public int getPrecioCampo() {
        return precioCampo;
    }

    public int getPrecioVip() {
        return precioVip;
    }

    public int getCantVip() {
        return cantVip;
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

    public String toString(){
        return nombreEstadio;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
