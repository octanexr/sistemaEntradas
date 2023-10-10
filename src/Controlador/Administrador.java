package Controlador;

import java.util.ArrayList;

public class Administrador extends Usuario {
    private ArrayList<Estadio> estadios;
    private ArrayList<Espectaculo> espectaculos;


    public Administrador(String nombreUsuario, String mailUsuario, String contraseña, ArrayList<Estadio> estadios, ArrayList<Espectaculo> espectaculos) {
        super(nombreUsuario, mailUsuario, contraseña);
        this.estadios = estadios;
        this.espectaculos = espectaculos;
    }

    public Administrador(String nombreUsuario, String mailUsuario, String contraseña) {
        super(nombreUsuario, mailUsuario, contraseña);
    }

    public Administrador() {
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    public ArrayList<Espectaculo> getEspectaculos() {
        return espectaculos;
    }

    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }

    public void setEspectaculos(ArrayList<Espectaculo> espectaculos) {
        this.espectaculos = espectaculos;
    }

    public Administrador crearAdminitrador(Usuario usuario){
        String nombreUsuario = usuario.getNombreUsuario();
        String mailUsuario = usuario.getMailUsuario();
        String contraseña = usuario.getContraseña();

        Administrador administrador = new Administrador(nombreUsuario,mailUsuario,contraseña);
        return administrador;
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() +
                "estadios=" + estadios +
                ", espectaculos=" + espectaculos +
                '}';
    }
}
