package gui;

import Controlador.Comprador;
import Controlador.Espectaculo;
import Controlador.Usuario;
import Controlador.Venta;
import service.EspectaculoService;
import service.ServiceException;
import service.VentaService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RealizarInformePage implements ActionListener {

    private JPanel panel = new JPanel();
    JPanel fondoPanel = new JPanel();
    private JComboBox espectaculosComboBox = new JComboBox();
    JTextField fechaField1 = new JTextField();
    JTextField fechaField2 = new JTextField();
    JLabel seleccionarEventoLabel = new JLabel("Seleccionar evento");
    JLabel fechaLabel1 = new JLabel("Fecha 1:");
    JLabel fechalabel2 = new JLabel("Fecha 2:");
    JLabel nombreEventoLabel = new JLabel("Nombre del evento:");
    JLabel fechasSelaccionadasLabel = new JLabel("Fechas seleccionadas:");
    JLabel cantidadDeEntradasVendidasLabel = new JLabel("Cantidad de entradas vendidas:");
    JLabel cantidadRecaudadaLabel = new JLabel("Cantidad recaudada:");
    JButton botonConfirmar = new JButton("Confirmar");
    JButton botonVolver = new JButton("Volver");
    
    EspectaculoService espectaculoService = new EspectaculoService();
    VentaService ventaService = new VentaService();
    JFrame frame1;
    Comprador comprador;


    private void cargarEspectaculos(){
        try {
            ArrayList<Espectaculo> espectaculos = espectaculoService.buscarTodosEspectaculo();
            for(Espectaculo espectaculo:espectaculos){
                espectaculosComboBox.addItem(espectaculo);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    public RealizarInformePage(JFrame frame, Usuario usuario){
        comprador=(Comprador) usuario;
        frame1=frame;
        cargarEspectaculos();

        panel.setBounds(0,0,1240,720);
        panel.setVisible(true);
        panel.setLayout(null);
        panel.setBackground(new Color(32,51,84));

        fondoPanel.setBounds(300,50,550,500);
        fondoPanel.setBackground(new Color(6, 90, 131));
        fondoPanel.setLayout(null);
        fondoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        espectaculosComboBox.setBounds(150,25,200,25);

        seleccionarEventoLabel.setBounds(25,25,120,25);
        seleccionarEventoLabel.setForeground(Color.white);
        fechaLabel1.setBounds(25,75,100,25);
        fechaLabel1.setForeground(Color.white);
        fechalabel2.setBounds(25,105,100,25);
        fechalabel2.setForeground(Color.white);

        fechaField1.setBounds(100,75,100,25);
        fechaField2.setBounds(100,105,100,25);

        nombreEventoLabel.setBounds(25,175,300,25);
        nombreEventoLabel.setForeground(Color.white);
        fechasSelaccionadasLabel.setBounds(25,215,300,25);
        fechasSelaccionadasLabel.setForeground(Color.white);
        cantidadDeEntradasVendidasLabel.setBounds(25,255,300,25);
        cantidadDeEntradasVendidasLabel.setForeground(Color.white);
        cantidadRecaudadaLabel.setBounds(25,295,330,25);
        cantidadRecaudadaLabel.setForeground(Color.white);

        botonConfirmar.setBounds(25,145,100,25);
        botonConfirmar.setFocusable(false);
        botonConfirmar.addActionListener(this);

        botonVolver.setBounds(25,400,100,25);
        botonVolver.setFocusable(false);
        botonVolver.addActionListener(this);


        fondoPanel.add(seleccionarEventoLabel);
        fondoPanel.add(espectaculosComboBox);
        fondoPanel.add(fechaField1);
        fondoPanel.add(fechaLabel1);
        fondoPanel.add(fechaField2);
        fondoPanel.add(fechalabel2);
        fondoPanel.add(nombreEventoLabel);
        fondoPanel.add(fechasSelaccionadasLabel);
        fondoPanel.add(cantidadDeEntradasVendidasLabel);
        fondoPanel.add(cantidadRecaudadaLabel);
        fondoPanel.add(botonConfirmar);
        fondoPanel.add(botonVolver);

        panel.add(fondoPanel);

        frame.add(panel);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonConfirmar){
            System.out.println("boton");
            Espectaculo espectaculo = (Espectaculo) espectaculosComboBox.getSelectedItem();
            long codEspectaculo = espectaculo.getCodEspectaculo();
            ArrayList<Venta> ventas;
            String fecha1 = fechaField1.getText();
            String fecha2 = fechaField2.getText();
            int cantidadVentas=0;
            int cantidadRecaudada=0;

            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat.parse(fecha1);
                fecha1 = outputFormat.format(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat2.parse(fecha2);
                fecha2 = outputFormat2.format(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            try {
                ventas = ventaService.buscarTodosVentaPorFecha(fecha1,fecha2,codEspectaculo);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

            for(Venta venta:ventas){
                cantidadVentas++;
                cantidadRecaudada+=venta.getValorVenta();
            }

            nombreEventoLabel.setText("Nombre del evento " + espectaculo.getNombreEspectaculo());
            fechasSelaccionadasLabel.setText("Fechas seleccionadas " + fecha1 + " y " + fecha2);
            cantidadDeEntradasVendidasLabel.setText("Cantidad de entradas vendidas: " + cantidadVentas);
            cantidadRecaudadaLabel.setText("Cantidad recaudada " + cantidadRecaudada);


        }

        if(e.getSource()==botonVolver){
            try {
                panel.setVisible(false);
                panel = null;
                new HomePage(comprador,frame1);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }

        
    }
}
