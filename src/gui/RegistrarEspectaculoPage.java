package gui;

import Controlador.Comprador;
import Controlador.Espectaculo;
import Controlador.Estadio;
import Controlador.Vendedor;
import Model.DAOException;
import service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class RegistrarEspectaculoPage implements ActionListener {

    Comprador comprador1;
    JFrame frameREspectaculo;
    JPanel panelREspectaculo = new JPanel();
    JPanel fondoPanelREspectaculo = new JPanel();
    JLabel nombreEspectaculoLabel = new JLabel("Nombre:");
    JLabel fechaEspectaculoLabel = new JLabel("Fecha:");
    JLabel cantEntradasLabel = new JLabel("Cant entradas:");
    JLabel codEstadioLabel = new JLabel("Estadio:");
    JLabel precioEspectauloLabel = new JLabel("Precio espectaculo:");
    JLabel vendedorLabel = new JLabel("Vendedor: ");
    JTextField nombreEspectaculoField = new JTextField();
    JTextField fechaEspectaculoField = new JTextField();
    JTextField cantEntradasField = new JTextField();
    JTextField precioEspectaculoField = new JTextField();
    JComboBox<Estadio> estadioComboBox = new JComboBox<>();
    JComboBox<Vendedor> vendedorComboBox = new JComboBox<>();

    JButton botonRegistrar = new JButton("Registrar");
    JButton botonReset = new JButton("Reset");
    JButton botonVolver = new JButton("Volver");
    JLabel mensajeLabel = new JLabel();

    EstadioService estadioService = new EstadioService();
    EspectaculoService espectaculoService = new EspectaculoService();
    VendedorService vendedorService = new VendedorService();





    public RegistrarEspectaculoPage(Comprador comprador, JFrame frame) throws DAOException {
        frameREspectaculo = frame;
        vendedorComboBox = vendedorService.cargarVendedores();
        comprador1 = comprador;
        System.out.println(comprador1);

        panelREspectaculo.setBounds(0,0,1420,720);
        panelREspectaculo.setLayout(null);
        panelREspectaculo.setVisible(true);
        panelREspectaculo.setBackground(new Color(32,51,84));
        
        fondoPanelREspectaculo.setBounds(300,50,550,500);
        fondoPanelREspectaculo.setBackground(new Color(6, 90, 131));
        fondoPanelREspectaculo.setLayout(null);
        fondoPanelREspectaculo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        nombreEspectaculoLabel.setBounds(50,50,75,25);
        nombreEspectaculoLabel.setForeground(Color.white);
        fechaEspectaculoLabel.setBounds(50,90,75,25);
        fechaEspectaculoLabel.setForeground(Color.white);
        cantEntradasLabel.setBounds(50,130,100,25);
        cantEntradasLabel.setForeground(Color.white);
        codEstadioLabel.setBounds(50,170,125,25);
        codEstadioLabel.setForeground(Color.white);
        precioEspectauloLabel.setBounds(50,210,125,25);
        precioEspectauloLabel.setForeground(Color.white);
        vendedorLabel.setBounds(50,250,100,25);
        vendedorLabel.setForeground(Color.white);

        mensajeLabel.setBounds(100,320,250,35);
        mensajeLabel.setFont(new Font(null, Font.ITALIC, 25));

        botonRegistrar.setBounds(200,300,100,25);
        botonRegistrar.setFocusable(false);
        botonRegistrar.addActionListener(this);

        botonReset.setBounds(100,300,100,25);
        botonReset.setFocusable(false);
        botonReset.addActionListener(this);

        botonVolver.setBounds(10,10,100,25);
        botonVolver.setFocusable(false);
        botonVolver.addActionListener(this);

        nombreEspectaculoField.setBounds(140,50,200,25);
        fechaEspectaculoField.setBounds(140,90,200,25);
        cantEntradasField.setBounds(140,130,200,25);
        estadioComboBox.setBounds(140, 170, 200, 25);
        precioEspectaculoField.setBounds(170,210,200,25);
        vendedorComboBox.setBounds(140,250,200,25);

        fondoPanelREspectaculo.add(nombreEspectaculoLabel);
        fondoPanelREspectaculo.add(fechaEspectaculoLabel);
        fondoPanelREspectaculo.add(cantEntradasLabel);
        fondoPanelREspectaculo.add(codEstadioLabel);
        fondoPanelREspectaculo.add(mensajeLabel);
        fondoPanelREspectaculo.add(precioEspectauloLabel);
        fondoPanelREspectaculo.add(nombreEspectaculoField);
        fondoPanelREspectaculo.add(fechaEspectaculoField);
        fondoPanelREspectaculo.add(cantEntradasField);
        fondoPanelREspectaculo.add(estadioComboBox);
        fondoPanelREspectaculo.add(precioEspectaculoField);
        fondoPanelREspectaculo.add(botonRegistrar);
        fondoPanelREspectaculo.add((vendedorComboBox));
        fondoPanelREspectaculo.add(vendedorLabel);
        fondoPanelREspectaculo.add(botonReset);
        fondoPanelREspectaculo.add(botonVolver);

        panelREspectaculo.add(fondoPanelREspectaculo);

        frame.add(panelREspectaculo);

        ArrayList<Estadio> estadios = estadioService.cargarEstadios();
        for(Estadio estadio : estadios)
            estadioComboBox.addItem(estadio);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonReset){
            nombreEspectaculoField.setText("");
            fechaEspectaculoField.setText("");
            cantEntradasField.setText("");
            precioEspectaculoField.setText("");
        }

        if(e.getSource()==botonVolver){
            try {
                panelREspectaculo.setVisible(false);
                panelREspectaculo = null;
                new HomePage(comprador1,frameREspectaculo);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            } catch (DAOException ex) {
                throw new RuntimeException(ex);
            }

        }

        if (e.getSource() == botonRegistrar) {
            String nombreEspectaculo = nombreEspectaculoField.getText();
            String fechaEspectaculo = fechaEspectaculoField.getText();
            int cantEntradas = Integer.parseInt(cantEntradasField.getText());
            Estadio estadioSeleccionado = (Estadio) estadioComboBox.getSelectedItem();
            long codEstadio = estadioSeleccionado.getCodEstadio();
            int precioEspectaulo = Integer.parseInt(precioEspectaculoField.getText());
            int capacidadMaxina = estadioSeleccionado.getCapacidadMaxima();
            Vendedor vendedor = (Vendedor) vendedorComboBox.getSelectedItem();
            String mailVendedor = vendedor.getMailUsuario();

            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat.parse(fechaEspectaculo);
                fechaEspectaculo = outputFormat.format(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }


            Random random = new Random();
            int codigoMax = 6;
            long codEspectaculo = random.nextLong((long) Math.pow(10, codigoMax));

            Estadio estadio = new Estadio();

            try {
               estadio = estadioService.buscar(codEstadio);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


            Espectaculo espectaculo1 = null;
            espectaculo1 = new Espectaculo(codEspectaculo,nombreEspectaculo,cantEntradas,fechaEspectaculo,codEstadio,estadio,precioEspectaulo,mailVendedor);
            espectaculoService.guardarEspectaculo(espectaculo1,capacidadMaxina);

        }


    }
}
