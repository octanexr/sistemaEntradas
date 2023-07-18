package gui;

import Controlador.Comprador;
import Controlador.Entrada;
import Controlador.Espectaculo;
import Controlador.Estadio;
import service.EntradaService;
import service.EspectaculoService;
import service.EstadioService;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EntradasDelUsuarioPage implements ActionListener {

    EntradaService entradaService = new EntradaService();
    EspectaculoService espectaculoService = new EspectaculoService();
    EstadioService estadioService = new EstadioService();
    Comprador comprador1;
    JFrame frameEU;
    JComboBox<Entrada> entradasComboBox = new JComboBox<>();
    JLabel misEntradasLabel = new JLabel("Mis entradas: ");
    JLabel nombreEspectaculoLabel = new JLabel("Nombre del espectaculo: ");
    JLabel nombreEstadioLabel = new JLabel("Nombre del estadio: ");
    JLabel fechaEntradaLabel = new JLabel("Fecha de compra: ");
    JLabel precioEntradaLabel = new JLabel("Precio de la entrada: ");
    JLabel ubicacionLabel = new JLabel("Ubicacion: ");
    JButton botonConfirmar = new JButton("Confirmar");
    JButton botonVolver = new JButton("Vovler");
    JPanel panelEntradasDelUsuario = new JPanel();
    JPanel panelFondoEntradasDelUsuario = new JPanel();


    private void cargarEntradas(Comprador comprador2){
        try {
            ArrayList<Entrada> entradas = entradaService.buscarTodosUsuarioEntrada(comprador2.getMailUsuario());
            for(Entrada entrada:entradas){
                entradasComboBox.addItem(entrada);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    public EntradasDelUsuarioPage(Comprador comprador, JFrame frame){

        comprador1 = comprador;

        cargarEntradas(comprador1);
        frameEU = frame;

        panelEntradasDelUsuario.setBounds(0,0,1240, 720);
        panelEntradasDelUsuario.setLayout(null);
        panelEntradasDelUsuario.setVisible(true);
        panelEntradasDelUsuario.setBackground(new Color(32,51,84));

        panelFondoEntradasDelUsuario.setBounds(300,50,550,500);
        panelFondoEntradasDelUsuario.setBackground(new Color(6, 90, 131));
        panelFondoEntradasDelUsuario.setLayout(null);
        panelFondoEntradasDelUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        entradasComboBox.setBounds(90,10,300,25);
        entradasComboBox.addActionListener(this);

        botonConfirmar.setBounds(400,10,100,25);
        botonConfirmar.setFocusable(false);
        botonConfirmar.addActionListener(this);

        misEntradasLabel.setBounds(10,10,150,25);
        misEntradasLabel.setForeground(Color.white);

        nombreEspectaculoLabel.setBounds(10,50,500,25);
        nombreEspectaculoLabel.setForeground(Color.white);
        nombreEspectaculoLabel.setFont(new Font(null,Font.PLAIN,18));

        nombreEstadioLabel.setBounds(10,90,500,25);
        nombreEstadioLabel.setForeground(Color.white);
        nombreEstadioLabel.setFont(new Font(null,Font.PLAIN,18));

        fechaEntradaLabel.setBounds(10,130,500,25);
        fechaEntradaLabel.setForeground(Color.white);
        fechaEntradaLabel.setFont(new Font(null,Font.PLAIN,18));

        precioEntradaLabel.setBounds(10,170,500,25);
        precioEntradaLabel.setForeground(Color.white);
        precioEntradaLabel.setFont(new Font(null,Font.PLAIN,18));

        ubicacionLabel.setBounds(10,210,500,25);
        ubicacionLabel.setForeground(Color.white);
        ubicacionLabel.setFont(new Font(null,Font.PLAIN,18));

        botonVolver.setBounds(10,300,75,25);
        botonVolver.setFocusable(false);
        botonVolver.addActionListener(this);

        panelFondoEntradasDelUsuario.add(misEntradasLabel);
        panelFondoEntradasDelUsuario.add(entradasComboBox);
        panelFondoEntradasDelUsuario.add(botonConfirmar);
        panelFondoEntradasDelUsuario.add(nombreEspectaculoLabel);
        panelFondoEntradasDelUsuario.add(nombreEstadioLabel);
        panelFondoEntradasDelUsuario.add(fechaEntradaLabel);
        panelFondoEntradasDelUsuario.add(precioEntradaLabel);
        panelFondoEntradasDelUsuario.add(ubicacionLabel);
        panelFondoEntradasDelUsuario.add(botonVolver);

        panelEntradasDelUsuario.add(panelFondoEntradasDelUsuario);

        frame.add(panelEntradasDelUsuario);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==botonVolver){
            try {
                panelEntradasDelUsuario.setVisible(false);
                panelEntradasDelUsuario = null;
                new HomePage(comprador1,frameEU);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource()==botonConfirmar){
            Entrada entrada1 = (Entrada) entradasComboBox.getSelectedItem();
            Espectaculo espectaculo;
            Estadio estadio;


            try {
                espectaculo = espectaculoService.buscarEspectaculo(entrada1.getCodEspectaculo());
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


            try {
                estadio = estadioService.buscar(entrada1.getCodEstadio());
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


            nombreEspectaculoLabel.setText("Nombre del espectaculo " +  espectaculo.getNombreEspectaculo());
            nombreEstadioLabel.setText("Nombre del estadio: " + estadio.getNombreEstadio());
            fechaEntradaLabel.setText("Fecha de compra: " + entrada1.getFechaEntrada());
            precioEntradaLabel.setText("Precio de la entrada " + entrada1.getPrecioEntrada());
            ubicacionLabel.setText("Ubicacion: " + entrada1.getUbicacion());


        }

    }
}
