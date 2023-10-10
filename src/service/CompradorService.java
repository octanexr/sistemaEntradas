package service;

import Controlador.Comprador;
import Controlador.Usuario;
import Controlador.Vendedor;
import Model.DAOComprador;
import Model.DAOException;
import Model.DAOVendedor;
import gui.HomePage;
import gui.LoginPage;

import javax.swing.*;
import java.util.ArrayList;

public class CompradorService {

    private DAOComprador daoComprador;


    public CompradorService() {
        daoComprador = new DAOComprador();
    }


    public Comprador buscar2Comprador(String mail) throws ServiceException{
        Comprador comprador;
        try {
            comprador = daoComprador.buscar2(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return comprador;
    }

    public boolean buscarEsAdmin(String mail) throws ServiceException{
        Boolean esAdmin=false;
        try {
            esAdmin = daoComprador.buscarEsAdmin(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return esAdmin;
    }


    public boolean buscarUsuario(String emailUsuario, String nombreUsuario, String contraseña, JFrame frame){
        try {
            Usuario usuario = daoComprador.buscar2(emailUsuario);
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
        } catch (DAOException | ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean registrarUsuario(String emailUsuario, String nombreUsuario, String contraseña) {
        Comprador comprador = new Comprador(emailUsuario,nombreUsuario,contraseña);

        try{
            daoComprador.guardar(comprador);
            JOptionPane.showMessageDialog(null, "Se registro el usuario con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);;
            LoginPage loginPage = new LoginPage();
            return true;

        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }





}



