package Controlador;


import java.util.ArrayList;

public class Comprador extends Usuario{
    private ArrayList<Entrada> entradas = new ArrayList<>();
    private boolean esAdmin;
    private boolean esVendedor;
    private ArrayList<Estadio> estadios;
    private ArrayList<Espectaculo> espectaculos;


    public Comprador(String nombreUsuario, String mailUsuario, String contraseña) {
        super(nombreUsuario, mailUsuario, contraseña);
    }

    public Comprador(String nombreUsuario, String mailUsuario, String contraseña,  ArrayList<Entrada> entradas, boolean esAdmin, boolean esVendedor) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.entradas = entradas;
        this.esAdmin = esAdmin;
        this.esVendedor = esVendedor;
    }

    public Comprador(String nombreUsuario, String mailUsuario, String contraseña, boolean esAdmin, boolean esVendedor, ArrayList<Estadio> estadios, ArrayList<Espectaculo> espectaculos) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.esAdmin = esAdmin;
        this.esVendedor = esVendedor;
        this.estadios = estadios;
        this.espectaculos = espectaculos;
    }

    public Comprador(){
        super();
    }



    public void comprarEntrada(){

    }


    public void verEntradas(){

    }

    public Espectaculo verEspectaculo(){
        return verEspectaculo();
    }


    public void setEntradas(ArrayList<Entrada> entradas) {
        this.entradas = entradas;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public boolean isesVendedor() {
        return esVendedor;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public void setesVendedor(boolean esVendedor) {
        this.esVendedor = esVendedor;
    }

    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }

    public void setEspectaculos(ArrayList<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public String toString2() {
        return "Comprador{" + super.toString() +
                ", entradas=" + entradas +
                ", esAdmin=" + esAdmin +
                ", esVendedor=" + esVendedor +
                '}';
    }

    @Override
    public String getContraseña() {
        return super.getContraseña();
    }



    @Override
    public String toString() {
        return super.toString();
    }



}
