package Controlador;

import gui.HomePage;
import gui.LoginPage;
import service.*;

import javax.swing.*;
import java.util.ArrayList;

public class Vendedor extends Usuario {
    private int cantEntradasVendidas;

    private boolean esAdmin;
    private boolean esVendedor;
    private ArrayList<Espectaculo> espectaculos = new ArrayList<>();
    private ArrayList<Venta> ventas = new ArrayList<>();

    public Vendedor(String nombreUsuario, String mailUsuario, String contraseña, int cantEntradasVendidas, boolean esAdmin, boolean esVendedor, ArrayList<Espectaculo> espectaculos, ArrayList<Venta> ventas) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.cantEntradasVendidas = cantEntradasVendidas;
        this.esAdmin = esAdmin;
        this.esVendedor = esVendedor;
        this.espectaculos = espectaculos;
        this.ventas = ventas;
    }

    public Vendedor(String nombreUsuario, String mailUsuario, String contraseña, boolean esAdmin, boolean esVendedor ) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.esAdmin = esAdmin;
        this.esVendedor = esVendedor;

    }
    public Vendedor(String nombreUsuario, String mailUsuario, String contraseña){
        super(nombreUsuario,mailUsuario,contraseña);
    }
    public Vendedor(){
        super();
    }

    public Vendedor(String nombreUsuario, String mailUsuario, String contraseña, int cantEntradasVendidas) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.cantEntradasVendidas = cantEntradasVendidas;
    }




    @Override
    public String getContraseña() {
        return super.getContraseña();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setCantEntradasVendidas(int cantEntradasVendidas) {
        this.cantEntradasVendidas = cantEntradasVendidas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public void setEsVendedor(boolean esVendedor) {
        this.esVendedor = esVendedor;
    }

    public void setEspectaculos(ArrayList<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }


    public String toString2() {
        return "Vendedor{" +
                "cantEntradasVendidas=" + cantEntradasVendidas +
                ", esAdmin=" + esAdmin +
                ", esVendedor=" + esVendedor +
                ", espectaculos=" + espectaculos +
                ", ventas=" + ventas +
                '}';
    }
}
