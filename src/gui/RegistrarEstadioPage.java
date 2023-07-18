package gui;

import Controlador.Comprador;
import Controlador.Estadio;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class RegistrarEstadioPage implements ActionListener {

    private Comprador comprador1;
    JFrame frameRE;
    JPanel registrarEstadioPanel = new JPanel();
    JPanel fondoRegistrarEstadioPanel = new JPanel();
    JLabel nombreEstadioLabel = new JLabel("Nombre:");
    JLabel capacidadMaximaLabel = new JLabel("Cap. Max.:");
    JLabel cantPlateaLabel = new JLabel("Cant platea:");
    JLabel cantCampoLabel = new JLabel("Cant campo:");
    JLabel cantVipLabel = new JLabel("Cant VIP:");
    JLabel precioPlateaLabel = new JLabel("Precio platea");
    JLabel precioCampoLabel = new JLabel("Precio campo");
    JLabel precioVipLabel = new JLabel("Precio VIP");
    JLabel mensajeLabel = new JLabel();
    JLabel imagenEstadioLabel = new JLabel("Imagen del estadio:");
    JTextField nombreEstadioField = new JTextField();
    JTextField capacidadMaximaField = new JTextField();
    JTextField cantPlateaField = new JTextField();
    JTextField cantCampoField = new JTextField();
    JTextField cantVipField = new JTextField();
    JTextField precioPlateaField = new JTextField();
    JTextField precioCampoField = new JTextField();
    JTextField precioVipField = new JTextField();
    JButton botonRegistrar = new JButton("Registrar");
    JButton botonReset = new JButton("Reset");
    JButton botonVolver = new JButton("Volver");
    JButton botonSubirImagen = new JButton("Subir imagen...");
    JFileChooser fileChooser = new JFileChooser();
    File file;
    byte[] imagenBytes;


    public RegistrarEstadioPage(Comprador comprador, JFrame frame){
        frameRE = frame;
        
        registrarEstadioPanel.setBounds(0,0,1240, 720);
        registrarEstadioPanel.setLayout(null);
        registrarEstadioPanel.setVisible(true);
        registrarEstadioPanel.setBackground(new Color(32,51,84));
        
        fondoRegistrarEstadioPanel.setBounds(300,50,550,500);
        fondoRegistrarEstadioPanel.setBackground(new Color(6, 90, 131));
        fondoRegistrarEstadioPanel.setLayout(null);
        fondoRegistrarEstadioPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        comprador1 = comprador;
        System.out.println(comprador1);

        nombreEstadioLabel.setBounds(50,50,75,25);
        nombreEstadioLabel.setForeground(Color.white);
        capacidadMaximaLabel.setBounds(50,90,75,25);
        capacidadMaximaLabel.setForeground(Color.white);
        cantPlateaLabel.setBounds(50,130,100,25);
        cantPlateaLabel.setForeground(Color.white);
        cantCampoLabel.setBounds(50,170,125,25);
        cantCampoLabel.setForeground(Color.white);
        cantVipLabel.setBounds(50,210,150,25);
        cantVipLabel.setForeground(Color.white);
        precioPlateaLabel.setBounds(50,250,150,25);
        precioPlateaLabel.setForeground(Color.white);
        precioCampoLabel.setBounds(50,290,150,25);
        precioCampoLabel.setForeground(Color.white);
        precioVipLabel.setBounds(50,330,150,25);
        precioVipLabel.setForeground(Color.white);
        imagenEstadioLabel.setBounds(50,370,150,25);
        imagenEstadioLabel.setForeground(Color.white);

        mensajeLabel.setBounds(100,350,250,35);
        mensajeLabel.setFont(new Font(null, Font.ITALIC, 25));

        botonRegistrar.setBounds(230,430,100,25);
        botonRegistrar.setFocusable(false);
        botonRegistrar.addActionListener(this);

        botonReset.setBounds(120,430,100,25);
        botonReset.setFocusable(false);
        botonReset.addActionListener(this);

        botonVolver.setBounds(10,10,100,25);
        botonVolver.setFocusable(false);
        botonVolver.addActionListener(this);

        botonSubirImagen.setBounds(180,370,120,25);
        botonSubirImagen.setFocusable(false);
        botonSubirImagen.addActionListener(this);

        nombreEstadioField.setBounds(140,50,200,25);
        capacidadMaximaField.setBounds(140,90,200,25);
        cantPlateaField.setBounds(140,130,200,25);
        cantCampoField.setBounds(140,170,200,25);
        cantVipField.setBounds(140,210,200,25);
        precioPlateaField.setBounds(140,250,150,25);
        precioCampoField.setBounds(140,290,150,25);
        precioVipField.setBounds(140,330,150,25);


        fondoRegistrarEstadioPanel.add(nombreEstadioLabel);
        fondoRegistrarEstadioPanel.add(capacidadMaximaLabel);
        fondoRegistrarEstadioPanel.add(cantPlateaLabel);
        fondoRegistrarEstadioPanel.add(cantCampoLabel);
        fondoRegistrarEstadioPanel.add(mensajeLabel);
        fondoRegistrarEstadioPanel.add(cantVipLabel);
        fondoRegistrarEstadioPanel.add(precioPlateaLabel);
        fondoRegistrarEstadioPanel.add(precioCampoLabel);
        fondoRegistrarEstadioPanel.add(precioVipLabel);
        fondoRegistrarEstadioPanel.add(nombreEstadioField);
        fondoRegistrarEstadioPanel.add(capacidadMaximaField);
        fondoRegistrarEstadioPanel.add(cantPlateaField);
        fondoRegistrarEstadioPanel.add(cantCampoField);
        fondoRegistrarEstadioPanel.add(cantVipField);
        fondoRegistrarEstadioPanel.add(precioPlateaField);
        fondoRegistrarEstadioPanel.add(precioCampoField);
        fondoRegistrarEstadioPanel.add(precioVipField);
        fondoRegistrarEstadioPanel.add(botonRegistrar);
        fondoRegistrarEstadioPanel.add(botonReset);
        fondoRegistrarEstadioPanel.add(botonVolver);
        fondoRegistrarEstadioPanel.add(imagenEstadioLabel);
        fondoRegistrarEstadioPanel.add(botonSubirImagen);

        registrarEstadioPanel.add(fondoRegistrarEstadioPanel);

        frame.add(registrarEstadioPanel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonReset){            nombreEstadioField.setText("");
            capacidadMaximaField.setText("");
            cantPlateaField.setText("");
            cantCampoField.setText("");
            cantVipField.setText("");
            precioPlateaField.setText("");
            precioCampoField.setText("");
            precioVipField.setText("");
            
        }

        if(e.getSource()==botonVolver){
            try {
                registrarEstadioPanel.setVisible(false);
                registrarEstadioPanel = null;
                new HomePage(comprador1,frameRE);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


        }

        if(e.getSource()==botonSubirImagen){

            int response = fileChooser.showOpenDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try {
                    imagenBytes = Files.readAllBytes(file.toPath());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }



            }



        }


        if(e.getSource()==botonRegistrar){
            String nombreEstadio = nombreEstadioField.getText();
            int capacidadMaxima = Integer.parseInt(capacidadMaximaField.getText());
            int cantPlatea = Integer.parseInt(cantPlateaField.getText());
            int cantCampo = Integer.parseInt(cantCampoField.getText());
            int cantVip = Integer.parseInt(cantVipField.getText());
            int precioPlatea = Integer.parseInt(precioPlateaField.getText());
            int precioCampo = Integer.parseInt(precioCampoField.getText());
            int precioVIP = Integer.parseInt(precioVipField.getText());
            byte[] imagenSubidaBytes = imagenBytes;

            Random random = new Random();
            int codigoMax = 5;
            long codEstadio = random.nextLong((long) Math.pow(10, codigoMax));

            Estadio estadio = new Estadio(codEstadio, nombreEstadio, capacidadMaxima, cantPlatea, cantCampo, cantVip, precioPlatea, precioCampo, precioVIP,imagenSubidaBytes);
            estadio.registrarEstadio(cantCampo,cantPlatea,cantVip,capacidadMaxima,estadio);


        }

    }
}
