package gui;

import Controlador.Comprador;
import Controlador.Vendedor;
import service.CompradorService;
import service.VendedorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarUsuarioPage implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panelEleccion = new JPanel();
    JPanel fondoPanelEleccion = new JPanel();
    JPanel panelUsuarioNormal = new JPanel();
    JPanel fondoPanelUsuarioNormal = new JPanel();
    JPanel panelUsuarioVendedor = new JPanel();
    JPanel fondoPanelUsuarioVendedor = new JPanel();
    JButton botonComprador = new JButton("Registrarse como comprador");
    JButton botoncVendedor = new JButton("Registrarse como vendedor");
    JButton botonVolverALogin = new JButton("Volver");
    JButton botonVolverAEleccion = new JButton("Volver");
    JButton botonVolverAEleccion2 = new JButton("Volver");
    JLabel labelTextoInicial = new JLabel("Elija que tipo de usuario desea crear");
    JLabel nombreUsuarioLabel = new JLabel("Username:");
    JLabel mailUsuarioLabel = new JLabel("mail:");
    JLabel contraseñaUsuarioLabel = new JLabel("contraseña:");
    JLabel nombreUsuarioLabel2 = new JLabel("Username:");
    JLabel mailUsuarioLabel2 = new JLabel("mail:");
    JLabel contraseñaUsuarioLabel2 = new JLabel("contraseña:");
    JLabel mensajeLabel = new JLabel();
    JTextField nombreUsuarioField = new JTextField();
    JTextField mailUsuarioField = new JTextField();
    JPasswordField contraseñaUsuarioField = new JPasswordField();
    JTextField nombreUsuarioField2 = new JTextField();
    JTextField mailUsuarioField2 = new JTextField();
    JPasswordField contraseñaUsuarioField2 = new JPasswordField();
    JButton botonRegistrar = new JButton("Registrar");
    JButton botonRegistrarVendedor = new JButton("Registrar");
    JButton botonReset = new JButton("Reset");
    JButton botonReset2 = new JButton("Reset");

    CompradorService compradorService = new CompradorService();
    VendedorService vendedorService = new VendedorService();

    public RegistrarUsuarioPage( )
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1240, 720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        panelEleccion.setBounds(0,0,1240, 720);
        panelEleccion.setBackground(new Color(32,51,84));
        panelEleccion.setVisible(true);
        panelEleccion.setLayout(null);
        
        fondoPanelEleccion.setBounds(350,50,500,500);
        fondoPanelEleccion.setBackground(new Color(6, 90, 131));
        fondoPanelEleccion.setLayout(null);
        fondoPanelEleccion.setBorder(BorderFactory.createLineBorder(Color.black));

        labelTextoInicial.setBounds(75,20,350,40);
        labelTextoInicial.setFont(new Font(null,Font.BOLD,20));
        labelTextoInicial.setForeground(Color.white);

        botonComprador.setBounds(35,220,205,35);
        botonComprador.setFocusable(false);
        botonComprador.addActionListener(this);

        botoncVendedor.setBounds(250,220,205,35);
        botoncVendedor.setFocusable(false);
        botoncVendedor.addActionListener(this);

        botonVolverAEleccion.setBounds(10,15,100,25);
        botonVolverAEleccion.setFocusable(false);
        botonVolverAEleccion.addActionListener(this);

        botonVolverAEleccion2.setBounds(10,15,100,25);
        botonVolverAEleccion2.setFocusable(false);
        botonVolverAEleccion2.addActionListener(this);

        botonVolverALogin.setBounds(140,320,205,35);
        botonVolverALogin.setFocusable(false);
        botonVolverALogin.addActionListener(this);

        fondoPanelEleccion.add(labelTextoInicial);
        fondoPanelEleccion.add(botonComprador);
        fondoPanelEleccion.add(botoncVendedor);
        fondoPanelEleccion.add(botonVolverALogin);
        fondoPanelEleccion.setVisible(true);

        panelEleccion.add(fondoPanelEleccion);

        panelUsuarioNormal.setBounds(0,0,1240, 720);
        panelUsuarioNormal.setBackground(new Color(32,51,84));
        panelUsuarioNormal.setVisible(false);
        panelUsuarioNormal.setLayout(null);
        
        fondoPanelUsuarioNormal.setBounds(350,50,500,500);
        fondoPanelUsuarioNormal.setBackground(new Color(6, 90, 131));
        fondoPanelUsuarioNormal.setLayout(null);
        fondoPanelUsuarioNormal.setBorder(BorderFactory.createLineBorder(Color.black));

        panelUsuarioVendedor.setBounds(0,0,1240, 720);
        panelUsuarioVendedor.setBackground(new Color(32,51,84));
        panelUsuarioVendedor.setVisible(false);
        panelUsuarioVendedor.setLayout(null);

        fondoPanelUsuarioVendedor.setBounds(350,50,500,500);
        fondoPanelUsuarioVendedor.setBackground(new Color(6, 90, 131));
        fondoPanelUsuarioVendedor.setLayout(null);
        fondoPanelUsuarioVendedor.setBorder(BorderFactory.createLineBorder(Color.black));

        mailUsuarioLabel.setBounds(15,60,75,25);
        mailUsuarioLabel.setForeground(Color.white);
        nombreUsuarioLabel.setBounds(15,90,75,25);
        nombreUsuarioLabel.setForeground(Color.white);
        contraseñaUsuarioLabel.setBounds(15,120,75,25);
        contraseñaUsuarioLabel.setForeground(Color.white);

        nombreUsuarioLabel2.setBounds(15,60,75,25);
        nombreUsuarioLabel2.setForeground(Color.white);
        mailUsuarioLabel2.setBounds(15,90,75,25);
        mailUsuarioLabel2.setForeground(Color.white);
        contraseñaUsuarioLabel2.setBounds(15,120,75,25);
        contraseñaUsuarioLabel2.setForeground(Color.white);

        mailUsuarioField.setBounds(90,60,205,25);
        nombreUsuarioField.setBounds(90,90,205,25);
        contraseñaUsuarioField.setBounds(90,120,205,25);

        nombreUsuarioField2.setBounds(90,60,205,25);
        mailUsuarioField2.setBounds(90,90,205,25);
        contraseñaUsuarioField2.setBounds(90,120,205,25);

        botonRegistrar.setBounds(50,225,100,25);
        botonRegistrar.setFocusable(false);
        botonRegistrar.addActionListener(this);

        botonRegistrarVendedor.setBounds(50,225,100,25);
        botonRegistrarVendedor.setFocusable(false);
        botonRegistrarVendedor.addActionListener(this);

        botonReset.setBounds(150,225,100,25);
        botonReset.setFocusable(false);
        botonReset.addActionListener(this);

        botonReset2.setBounds(150,225,100,25);
        botonReset2.setFocusable(false);
        botonReset2.addActionListener(this);

        mensajeLabel.setBounds(50, 285, 400, 35);
        mensajeLabel.setFont(new Font(null, Font.ITALIC, 25));

        fondoPanelUsuarioNormal.add(nombreUsuarioLabel);
        fondoPanelUsuarioNormal.add(mailUsuarioLabel);
        fondoPanelUsuarioNormal.add(contraseñaUsuarioLabel);
        fondoPanelUsuarioNormal.add(nombreUsuarioField);
        fondoPanelUsuarioNormal.add(mailUsuarioField);
        fondoPanelUsuarioNormal.add(contraseñaUsuarioField);
        fondoPanelUsuarioNormal.add(botonRegistrar);
        fondoPanelUsuarioNormal.add(botonReset);
        fondoPanelUsuarioNormal.add(botonVolverAEleccion2);
        fondoPanelUsuarioNormal.add(mensajeLabel);
        
        panelUsuarioNormal.add(fondoPanelUsuarioNormal);

        fondoPanelUsuarioVendedor.add(nombreUsuarioLabel2);
        fondoPanelUsuarioVendedor.add(mailUsuarioLabel2);
        fondoPanelUsuarioVendedor.add(contraseñaUsuarioLabel2);
        fondoPanelUsuarioVendedor.add(nombreUsuarioField2);
        fondoPanelUsuarioVendedor.add(mailUsuarioField2);
        fondoPanelUsuarioVendedor.add(contraseñaUsuarioField2);
        fondoPanelUsuarioVendedor.add(botonRegistrarVendedor);
        fondoPanelUsuarioVendedor.add(botonReset2);
        fondoPanelUsuarioVendedor.add(botonVolverAEleccion);
        fondoPanelUsuarioVendedor.add(mensajeLabel);
        
        panelUsuarioVendedor.add(fondoPanelUsuarioVendedor);

        frame.add(panelUsuarioVendedor);
        frame.add(panelUsuarioNormal);
        frame.add(panelEleccion);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonComprador){
            panelEleccion.setVisible(false);
            panelUsuarioNormal.setVisible(true);


        }

        if(e.getSource()==botoncVendedor){
            panelEleccion.setVisible(false);
            panelUsuarioVendedor.setVisible(true);
        }

        if(e.getSource()==botonVolverALogin){
            frame.dispose();
            new LoginPage();
        }

        if(e.getSource()==botonReset){
            nombreUsuarioField.setText("");
            mailUsuarioField.setText("");
            contraseñaUsuarioField.setText("");
        }

        if(e.getSource()==botonReset2){
            nombreUsuarioField2.setText("");
            mailUsuarioField2.setText("");
            contraseñaUsuarioField2.setText("");

        }

        if(e.getSource()==botonVolverAEleccion){
            panelUsuarioVendedor.setVisible(false);
            panelEleccion.setVisible(true);

        }

        if(e.getSource()==botonVolverAEleccion2){
            panelUsuarioNormal.setVisible(false);
            panelEleccion.setVisible(true);
        }

        if(e.getSource()==botonRegistrar){
            String nombreUsuario = nombreUsuarioField.getText();
            String mailUsuario = mailUsuarioField.getText();
            String contraseñaUsuario = contraseñaUsuarioField.getText();

            Comprador comprador = new Comprador(mailUsuario,nombreUsuario,contraseñaUsuario);
            if( compradorService.registrarUsuario(mailUsuario,nombreUsuario,contraseñaUsuario)){
                frame.dispose();
            }

        }

        if(e.getSource()==botonRegistrarVendedor){
            String nombreUsuario = nombreUsuarioField2.getText();
            String mailUsuario = mailUsuarioField2.getText();
            String contraseñaUsuario = contraseñaUsuarioField2.getText();

            Vendedor vendedor = new Vendedor(mailUsuario,nombreUsuario,contraseñaUsuario);
            if(vendedorService.registrarUsuario(nombreUsuario,mailUsuario,contraseñaUsuario)){
                frame.dispose();
            }


        }
    }
}
