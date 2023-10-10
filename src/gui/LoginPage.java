package gui;

import Controlador.Comprador;
import Controlador.Vendedor;
import service.CompradorService;
import service.VendedorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {


    JFrame frame = new JFrame();
    JButton botonSeleccionComprador = new JButton("Comprador");
    JButton botonSeleccionVendedor = new JButton("Vendedor");
    JButton botonLogin = new JButton("Login");
    JButton botonReset = new JButton("Reset");
    JButton botonVolver1 = new JButton("Volver");
    JButton botonVolver2 = new JButton("Volver");
    JTextField emailUsuarioField = new JTextField();
    JTextField nombreUsuarioField = new JTextField();
    JPasswordField constrasenaUsuarioField = new JPasswordField();
    JLabel emailUsuarioLabel = new JLabel("Email:");
    JLabel nombreUsuarioLabel = new JLabel("Usuario:");
    JLabel contrasenaUsuarioLabel = new JLabel("Contraseña:");
    JLabel iniciarSesionLabel = new JLabel("Iniciar sesion");
    JLabel compradorLabel = new JLabel("Comprador");
    JLabel vendedorLabel = new JLabel("Vendedor");

    JButton botonLogin2 = new JButton("Login");
    JButton botonReset2 = new JButton("Reset");
    JTextField emailUsuarioField2 = new JTextField();
    JTextField nombreUsuarioField2 = new JTextField();
    JPasswordField constrasenaUsuarioField2 = new JPasswordField();
    JLabel emailUsuarioLabel2 = new JLabel("email:");
    JLabel nombreUsuarioLabel2 = new JLabel("Usuario:");
    JLabel contrasenaUsuarioLabel2 = new JLabel("Contraseña:");
    JLabel instruccionRegistroLabel = new JLabel("No tenes cuenta? Create una:");
    JButton botonRegistrarse = new JButton("Registrarse");
    JPanel panelRealizarSeleccion = new JPanel();
    JPanel fondoPanelRealizarSeleccion = new JPanel();
    JPanel panelIniciarSesionVendedor = new JPanel();
    JPanel fondoPanelIniciarSesionVendedor = new JPanel();
    JPanel panelIniciarSesionComprador = new JPanel();
    JPanel fondoPanelIniciarSesionComprador = new JPanel();

    CompradorService compradorService = new CompradorService();
    VendedorService vendedorService = new VendedorService();

    public LoginPage() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1240, 720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        panelRealizarSeleccion.setBounds(0,0,1240,720);
        panelRealizarSeleccion.setBackground(new Color(32,51,84));
        panelRealizarSeleccion.setVisible(true);
        panelRealizarSeleccion.setLayout(null);

        fondoPanelRealizarSeleccion.setBounds(350,50,500,500);
        fondoPanelRealizarSeleccion.setBackground(new Color(6, 90, 131));
        fondoPanelRealizarSeleccion.setLayout(null);
        fondoPanelRealizarSeleccion.setBorder(BorderFactory.createLineBorder(Color.black));
        
        panelIniciarSesionComprador.setBounds(0,0,1240,720);
        panelIniciarSesionComprador.setBackground(new Color(32,51,84));
        panelIniciarSesionComprador.setVisible(false);
        panelIniciarSesionComprador.setLayout(null);

        fondoPanelIniciarSesionComprador.setBounds(350,50,500,500);
        fondoPanelIniciarSesionComprador.setBackground(new Color(6, 90, 131));
        fondoPanelIniciarSesionComprador.setLayout(null);
        fondoPanelIniciarSesionComprador.setBorder(BorderFactory.createLineBorder(Color.black));

        panelIniciarSesionVendedor.setBounds(0,0,1240,720);
        panelIniciarSesionVendedor.setBackground(new Color(32,51,84));
        panelIniciarSesionVendedor.setVisible(false);
        panelIniciarSesionVendedor.setLayout(null);

        fondoPanelIniciarSesionVendedor.setBounds(350,50,500,500);
        fondoPanelIniciarSesionVendedor.setBackground(new Color(6, 90, 131));
        fondoPanelIniciarSesionVendedor.setLayout(null);
        fondoPanelIniciarSesionVendedor.setBorder(BorderFactory.createLineBorder(Color.black));

        emailUsuarioLabel.setBounds(100, 80, 75, 25);
        emailUsuarioLabel.setFont(new Font(null,Font.PLAIN,20));
        emailUsuarioLabel.setForeground(Color.white);
        nombreUsuarioLabel.setBounds(100, 160, 75, 25);
        nombreUsuarioLabel.setFont(new Font(null,Font.PLAIN,20));
        nombreUsuarioLabel.setForeground(Color.white);
        contrasenaUsuarioLabel.setBounds(100, 240, 200, 25);
        contrasenaUsuarioLabel.setFont(new Font(null,Font.PLAIN,20));
        contrasenaUsuarioLabel.setForeground(Color.white);

        emailUsuarioField.setBounds(220, 80, 200, 30);
        emailUsuarioField.setFont(new Font(null,Font.PLAIN,15));
        nombreUsuarioField.setBounds(220, 160, 200, 30);
        nombreUsuarioField.setFont(new Font(null,Font.PLAIN,15));
        constrasenaUsuarioField.setBounds(220, 240, 200, 30);
        constrasenaUsuarioField.setFont(new Font(null,Font.PLAIN,15));

        botonSeleccionComprador.setBounds(50,60,400,50);
        botonSeleccionComprador.addActionListener(this);
        botonSeleccionComprador.setFocusable(false);
        botonSeleccionComprador.setFont(new Font(null,Font.PLAIN,20));
        
        botonSeleccionVendedor.setBounds(50,150,400,50);
        botonSeleccionVendedor.addActionListener(this);
        botonSeleccionVendedor.setFocusable(false);
        botonSeleccionVendedor.setFont(new Font(null,Font.PLAIN,20));
        
        botonLogin.setBounds(300, 300, 120, 40);
        botonLogin.addActionListener(this);
        botonLogin.setFocusable(false);

        botonReset.setBounds(100, 300, 120, 40);
        botonReset.addActionListener(this);
        botonReset.setFocusable(false);

        botonVolver1.setBounds(30,430,100,30);
        botonVolver1.addActionListener(this);
        botonVolver1.setFocusable(false);

        botonVolver2.setBounds(30,430,100,30);
        botonVolver2.addActionListener(this);
        botonVolver2.setFocusable(false);

        emailUsuarioLabel2.setBounds(100, 80, 75, 25);
        emailUsuarioLabel2.setFont(new Font(null,Font.PLAIN,20));
        emailUsuarioLabel2.setForeground(Color.white);
        nombreUsuarioLabel2.setBounds(100, 160, 75, 25);
        nombreUsuarioLabel2.setFont(new Font(null,Font.PLAIN,20));
        nombreUsuarioLabel2.setForeground(Color.white);
        contrasenaUsuarioLabel2.setBounds(100, 240, 200, 25);
        contrasenaUsuarioLabel2.setFont(new Font(null,Font.PLAIN,20));
        contrasenaUsuarioLabel2.setForeground(Color.white);

        emailUsuarioField2.setBounds(220, 80, 200, 30);
        emailUsuarioField2.setFont(new Font(null,Font.PLAIN,15));
        nombreUsuarioField2.setBounds(220, 160, 200, 30);
        nombreUsuarioField2.setFont(new Font(null,Font.PLAIN,15));
        constrasenaUsuarioField2.setBounds(220, 240, 200, 30);
        constrasenaUsuarioField2.setFont(new Font(null,Font.PLAIN,15));

        botonLogin2.setBounds(300, 300, 120, 40);
        botonLogin2.addActionListener(this);
        botonLogin2.setFocusable(false);

        botonReset2.setBounds(100, 300, 120, 40);
        botonReset2.addActionListener(this);
        botonReset2.setFocusable(false);

        iniciarSesionLabel.setBounds(170,20,200,25);
        iniciarSesionLabel.setFont(new Font(null,Font.BOLD,25));
        iniciarSesionLabel.setForeground(Color.white);

        compradorLabel.setBounds(185,20,200,25);
        compradorLabel.setFont(new Font(null,Font.BOLD,25));
        compradorLabel.setForeground(Color.white);

        vendedorLabel.setBounds(190,20,200,25);
        vendedorLabel.setFont(new Font(null,Font.BOLD,25));
        vendedorLabel.setForeground(Color.white);
        
        instruccionRegistroLabel.setBounds(50,250,200,25);
        instruccionRegistroLabel.setForeground(Color.white);

        botonRegistrarse.setBounds(220,240,200,50);
        botonRegistrarse.setFocusable(false);
        botonRegistrarse.addActionListener(this);
        
        fondoPanelRealizarSeleccion.add(iniciarSesionLabel);
        fondoPanelRealizarSeleccion.add(botonSeleccionComprador);
        fondoPanelRealizarSeleccion.add(botonSeleccionVendedor);
        fondoPanelRealizarSeleccion.add(instruccionRegistroLabel);
        fondoPanelRealizarSeleccion.add(botonRegistrarse);
        
        panelRealizarSeleccion.add(fondoPanelRealizarSeleccion);

        fondoPanelIniciarSesionComprador.add(compradorLabel);
        fondoPanelIniciarSesionComprador.add(emailUsuarioLabel);
        fondoPanelIniciarSesionComprador.add(nombreUsuarioLabel);
        fondoPanelIniciarSesionComprador.add(contrasenaUsuarioLabel);
        fondoPanelIniciarSesionComprador.add(emailUsuarioField);
        fondoPanelIniciarSesionComprador.add(nombreUsuarioField);
        fondoPanelIniciarSesionComprador.add(constrasenaUsuarioField);
        fondoPanelIniciarSesionComprador.add(botonLogin);
        fondoPanelIniciarSesionComprador.add(botonReset);
        fondoPanelIniciarSesionComprador.add(botonVolver2);

        panelIniciarSesionComprador.add(fondoPanelIniciarSesionComprador);
        
        fondoPanelIniciarSesionVendedor.add(vendedorLabel);
        fondoPanelIniciarSesionVendedor.add(emailUsuarioLabel2);
        fondoPanelIniciarSesionVendedor.add(nombreUsuarioLabel2);
        fondoPanelIniciarSesionVendedor.add(contrasenaUsuarioLabel2);
        fondoPanelIniciarSesionVendedor.add(emailUsuarioField2);
        fondoPanelIniciarSesionVendedor.add(nombreUsuarioField2);
        fondoPanelIniciarSesionVendedor.add(constrasenaUsuarioField2);
        fondoPanelIniciarSesionVendedor.add(botonLogin2);
        fondoPanelIniciarSesionVendedor.add(botonReset2);
        fondoPanelIniciarSesionVendedor.add(botonVolver1);

        panelIniciarSesionVendedor.add(fondoPanelIniciarSesionVendedor);
        
        frame.add(panelRealizarSeleccion);
        frame.add(panelIniciarSesionComprador);
        frame.add(panelIniciarSesionVendedor);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botonSeleccionComprador){
            panelRealizarSeleccion.setVisible(false);
            panelIniciarSesionComprador.setVisible(true);

        }

        if(e.getSource()==botonSeleccionVendedor){
            panelRealizarSeleccion.setVisible(false);
            panelIniciarSesionVendedor.setVisible(true);
        }

        if(e.getSource()==botonVolver1){
            panelIniciarSesionVendedor.setVisible(false);
            panelRealizarSeleccion.setVisible(true);
        }

        if(e.getSource()==botonVolver2){
            panelIniciarSesionComprador.setVisible(false);
            panelRealizarSeleccion.setVisible(true);
        }

        if (e.getSource() == botonReset) {
            emailUsuarioField.setText("");
            nombreUsuarioField.setText("");
            constrasenaUsuarioField.setText("");
        }

        if (e.getSource() == botonReset2) {
            emailUsuarioField2.setText("");
            nombreUsuarioField2.setText("");
            constrasenaUsuarioField2.setText("");
        }


        if (e.getSource() == botonLogin) {
            String emailUsuario = emailUsuarioField.getText();
            String nombreUsuaro = nombreUsuarioField.getText();
            String contraseña = constrasenaUsuarioField.getText();

            Comprador comprador = new Comprador(emailUsuario,nombreUsuaro,contraseña);
            if(compradorService.buscarUsuario(emailUsuario,nombreUsuaro,contraseña,frame)){
                panelIniciarSesionComprador.setVisible(false);
            }

        }

        if (e.getSource() == botonLogin2) {
            String emailUsuario = emailUsuarioField2.getText();
            String nombreUsuaro = nombreUsuarioField2.getText();
            String contraseña = constrasenaUsuarioField2.getText();

            Vendedor vendedor = new Vendedor(emailUsuario,nombreUsuaro,contraseña);
            if(vendedorService.buscarUsuario(emailUsuario,nombreUsuaro,contraseña,frame)){
                panelIniciarSesionVendedor.setVisible(false);
            }


        }

        if(e.getSource()==botonRegistrarse){
            frame.dispose();
            RegistrarUsuarioPage registrarUsuarioPage = new RegistrarUsuarioPage();

        }
    }
}
