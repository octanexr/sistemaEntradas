package Controlador;

import gui.HomePage;
import gui.LoginPage;
import service.CompradorService;
import service.ServiceException;
import service.VendedorService;
import service.VentaService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Vendedor extends Usuario {
    private int cantEntradasVendidas;
    private Entrada entrada;
    private boolean esAdmin;
    private boolean esVendedor;
    private ArrayList<Espectaculo> espectaculos = new ArrayList<>();


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

    public ArrayList<Venta> verVentas(Vendedor vendedor) throws ServiceException {
        try {
            ArrayList<Venta> arrayList = new ArrayList<>();
            VentaService ventaService = new VentaService();
            arrayList = ventaService.buscarTodosUsuarioVenta(vendedor.getMailUsuario());
            return arrayList;
        }catch (ServiceException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Espectaculo verEspectaculo() {
        return null;
    }

    @Override
    public boolean buscarUsuario(String emailUsuario, String nombreUsuario, String contraseña, JFrame frame){
        VendedorService vendedorService = new VendedorService();
        try {
            Usuario usuario = vendedorService.buscar2Vendedor(emailUsuario);
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
        Vendedor vendedor = new Vendedor(emailUsuario,nombreUsuario,contraseña);
        VendedorService vendedorService = new VendedorService();

        try{
            vendedorService.guardarVendedor(vendedor);
            JOptionPane.showMessageDialog(null, "Se registro el usuario con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            new LoginPage();
            return true;

        } catch (ServiceException ex) {
            throw new RuntimeException(ex);
        }

    }


    public Entrada verCantidadEntradas(){
       return entrada;
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

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
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
                ", entrada=" + entrada +
                ", esAdmin=" + esAdmin +
                ", esVendedor=" + esVendedor +
                ", espectaculos=" + espectaculos +
                '}';
    }
}
