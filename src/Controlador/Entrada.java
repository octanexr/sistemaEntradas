package Controlador;

import Model.DAOEspectaculo;
import Model.DAOException;


import java.util.ArrayList;

public class Entrada {

    private long codEntrada;
    private long codEspectaculo;
    private long codEstadio;
    private String fechaEntrada;
    private int precioEntrada;
    private String mailUsuario;
    private String ubicacion;



    public Entrada(long codEntrada, long codEspectaculo, long codEstadio, String fechaEntrada, int precioEntrada, String mailUsuario, String ubicacion) {
        this.codEntrada = codEntrada;
        this.codEspectaculo = codEspectaculo;
        this.codEstadio = codEstadio;
        this.fechaEntrada = fechaEntrada;
        this.precioEntrada = precioEntrada;
        this.mailUsuario = mailUsuario;
        this.ubicacion = ubicacion;
    }

    public Entrada() {
    }

    public String getNombreEspectaculo() throws DAOException {
        DAOEspectaculo daoEspectaculo = new DAOEspectaculo();

        Espectaculo espectaculo = daoEspectaculo.buscar(codEspectaculo);

        return espectaculo.getNombreEspectaculo();

    }


    public long getCodEntrada() {
        return codEntrada;
    }

    public long getCodEspectaculo() {
        return codEspectaculo;
    }

    public long getCodEstadio() {
        return codEstadio;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public int getPrecioEntrada() {
        return precioEntrada;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setCodEntrada(long codEntrada) {
        this.codEntrada = codEntrada;
    }

    public void setCodEspectaculo(long codEspectaculo) {
        this.codEspectaculo = codEspectaculo;
    }

    public void setCodEstadio(long codEstadio) {
        this.codEstadio = codEstadio;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setPrecioEntrada(int precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        try {
            return getNombreEspectaculo() + " " + fechaEntrada + " " + ubicacion ;
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
