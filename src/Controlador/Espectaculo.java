package Controlador;



import javax.swing.*;
import java.util.ArrayList;

public class Espectaculo {
    private long codEspectaculo;
    private String nombreEspectaculo;
    private long codEstadio;
    private Estadio estadio;
    private int cantEntradas;
    private String fechaEvento;
    private String mailVendedor;
    private int precioEspectaculo;




    public Espectaculo(long codEspectaculo,String nombreEspectaculo, int cantEntradas,
                       String fechaEvento, long codEstadio, Estadio estadio, int precioEspectaculo, String mailVendedor)  {
        this.codEspectaculo = codEspectaculo;
        this.nombreEspectaculo = nombreEspectaculo;
        this.cantEntradas = cantEntradas;
        this.fechaEvento = fechaEvento;
        this.codEstadio = codEstadio;
        this.estadio = estadio;
        this.precioEspectaculo=precioEspectaculo;
        this.mailVendedor = mailVendedor;

    }





    public Espectaculo() {
    }


    public long getCodEspectaculo() {
        return codEspectaculo;
    }

    public String getNombreEspectaculo() {
        return nombreEspectaculo;
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

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public String toString2() {
        return "Espectaculo{" +
                "codEspectaculo=" + codEspectaculo +
                ", nombreEspectaculo='" + nombreEspectaculo + '\'' +
                ", codEstadio=" + codEstadio +
                ", estadio=" + estadio+
                ", cantEntradas=" + cantEntradas +
                ", fechaEvento='" + fechaEvento + '\'' +
                ", mailVendedor='" + mailVendedor + '\'' +
                ", precioEspectaculo=" + precioEspectaculo +
                '}';
    }


    public String getMailVendedor() {
        return mailVendedor;
    }

    public void setMailVendedor(String mailVendedor) {
        this.mailVendedor = mailVendedor;
    }


}
