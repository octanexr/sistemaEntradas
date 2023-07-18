package Controlador;

import gui.HomePage;
import gui.LoginPage;
import service.CompradorService;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;

public class Comprador extends Usuario{
    private Espectaculo EspectaculoAsignado;
    private Entrada tipoEntrada;
    private boolean esAdmin;
    private boolean esVendedor;


    public Comprador(String nombreUsuario, String mailUsuario, String contraseña) {
        super(nombreUsuario, mailUsuario, contraseña);
    }

    public Comprador(String nombreUsuario, String mailUsuario, String contraseña, boolean esAdmin, boolean esVendedor) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.esAdmin = esAdmin;
        this.esVendedor = esVendedor;
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

    @Override
    public boolean buscarUsuario(String emailUsuario, String nombreUsuario, String contraseña, JFrame frame){
        CompradorService compradorService = new CompradorService();
        try {
            Usuario usuario = compradorService.buscar2Comprador(emailUsuario);
            if (usuario != null) {
                if(usuario.getContraseña().equals(contraseña)){
                    if(usuario.getNombreUsuario().equals(nombreUsuario)){
                        HomePage homePage = new HomePage(usuario,frame);
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Nombre de usuario o contraeña incorrectos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                        return false;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Nombre de usuario o contraeña incorrectos","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null,"Usuario inexistente","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (ServiceException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean registrarUsuario(String emailUsuario, String nombreUsuario, String contraseña) {
        Comprador comprador = new Comprador(emailUsuario,nombreUsuario,contraseña);
        CompradorService compradorService = new CompradorService();

        try{
            compradorService.guardarComprador(comprador);
            JOptionPane.showMessageDialog(null, "Se registro el usuario con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            LoginPage loginPage = new LoginPage();
            return true;

        } catch (ServiceException ex) {
            throw new RuntimeException(ex);
        }
    }


    public void setEspectaculoAsignado(Espectaculo espectaculoAsignado) {
        EspectaculoAsignado = espectaculoAsignado;
    }

    public void setTipoEntrada(Entrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Espectaculo getEspectaculoAsignado() {
        return EspectaculoAsignado;
    }

    public Entrada getTipoEntrada() {
        return tipoEntrada;
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

    @Override
    public String getContraseña() {
        return super.getContraseña();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
