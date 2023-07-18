package Controlador;

import javax.swing.*;

public abstract class Usuario {
    private String nombreUsuario;
    private String mailUsuario;
    private String contraseña;

    public Usuario( String nombreUsuario, String mailUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.mailUsuario = mailUsuario;
        this.contraseña = contraseña;
    }

    public Usuario() {

    }

    public abstract Espectaculo  verEspectaculo();

    public abstract boolean buscarUsuario(String emailUsuario, String nombreUsuario, String contraseña, JFrame frame);

    public abstract boolean registrarUsuario(String emailUsuario, String nombreUsuario, String contraseña);

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }
}
