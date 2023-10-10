package Controlador;


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
                ", bytesImagen=" + Arrays.toString(bytesImagen) +
                '}';
    }


}
