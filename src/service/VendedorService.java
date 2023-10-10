package service;

import Controlador.Comprador;
import Controlador.Usuario;
import Controlador.Vendedor;
import Controlador.Venta;
import Model.DAOException;
import Model.DAOVendedor;
import gui.HomePage;
import gui.LoginPage;

import javax.swing.*;
import java.util.ArrayList;

public class VendedorService {

    private DAOVendedor daoVendedor;

    public VendedorService(){
        daoVendedor = new DAOVendedor();
    }

    public void guardarVendedor(Vendedor vendedor) throws ServiceException{
        try {
            daoVendedor.guardar(vendedor);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    public Vendedor buscar2Vendedor(String mail) throws ServiceException{
        Vendedor vendedor;
        try {
            vendedor = daoVendedor.buscar2(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return vendedor;
    }

    public boolean buscarEsVendedor(String mail) throws ServiceException {
        Boolean esVendedor= null;
        try {
            esVendedor = daoVendedor.buscarEsVendedor(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return esVendedor;
    }

    public ArrayList<Vendedor> buscarTodosVendedor() throws ServiceException{
        try {
            return daoVendedor.buscarTodosVendedor();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }


    }

    public boolean buscarUsuario(String emailUsuario, String nombreUsuario, String contraseña, JFrame frame){

        try {
            Usuario usuario = daoVendedor.buscar2(emailUsuario);
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
        } catch (ServiceException | DAOException ex) {
            throw new RuntimeException(ex);
        }
    }


    public boolean registrarUsuario(String emailUsuario, String nombreUsuario, String contraseña) {
        Vendedor vendedor = new Vendedor(emailUsuario,nombreUsuario,contraseña);



        try{
            daoVendedor.guardar(vendedor);
            JOptionPane.showMessageDialog(null, "Se registro el usuario con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            new LoginPage();
            return true;

        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

    }

    public JComboBox<Venta> cargarVentas(Vendedor vendedor, JComboBox<Venta> entradasVendidasComboBox){
        try {
            VentaService ventaService = new VentaService();
            CompradorService compradorService = new CompradorService();
            EntradaService entradaService = new EntradaService();

            ArrayList<Venta> ventas = ventaService.verVentas(vendedor);
            vendedor.setVentas(ventas);

            for(Venta venta:ventas){
                venta.setVendedor(vendedor);
                venta.setComprador( compradorService.buscar2Comprador(venta.getMailComprador()));
                venta.setEntrada(entradaService.buscarEntrada(venta.getCodEntrada()));
                System.out.println(venta.toString2());
                entradasVendidasComboBox.addItem(venta);

            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

        return entradasVendidasComboBox;

    }

    public JComboBox<Vendedor> cargarVendedores(){
        JComboBox<Vendedor> vendedorComboBox = new JComboBox<>();
        try {
            ArrayList<Vendedor> vendedores = daoVendedor.buscarTodosVendedor();
            for(Vendedor vendedor:vendedores){
                vendedorComboBox.addItem(vendedor);
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }

        return vendedorComboBox;

    }



}
