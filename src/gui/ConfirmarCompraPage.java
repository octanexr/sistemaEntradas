package gui;

import Controlador.*;
import service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class ConfirmarCompraPage implements ActionListener {

    Entrada entrada1;
    Espectaculo espectaculo1;
    Comprador comprador1;
    JFrame frameCC;
    JButton botonConfirmar = new JButton("confirmar");
    JButton botonCancelar = new JButton("Cancelar");
    JButton botonCancelar2 = new JButton("Cancelar");
    JButton botonComprar = new JButton("Comprar");
    JLabel ingresarFechaLabel = new JLabel("Fecha de hoy: ");
    JLabel metodoDePagoLabel = new JLabel("MÉTODO DE PAGO");
    JLabel informacionDeFacturacionLabel = new JLabel("INFORMACIÓN DE FACTURACIÓN");
    JLabel precioTotalLabel = new JLabel();
    JLabel seleccionaMetodoDePagoLabel = new JLabel("Selccione un método de pago: ");
    JLabel nombreEnTarjetaLabel = new JLabel("Nombre en tarjeta: ");
    JLabel numeroDeTarjetaLabel = new JLabel("Numero de tarjeta: ");
    JLabel fechaVencimientoLabel = new JLabel("Fecha de vencimiento: ");
    JLabel localidadLabel = new JLabel("Localidad: ");
    JLabel direccionDeFacturacionLabel = new JLabel("Dirección de factuación: ");
    JLabel codigoPostalLabel = new JLabel("Codigo postal o zip: ");
    JLabel metodoDePagoSeleccionadolabel = new JLabel();
    JLabel cuentaDelUsuarioLabel = new JLabel();
    JLabel fechaDeLaCompraLabel = new JLabel();
    JTextField nombreEnTarjetaField = new JTextField();
    JTextField numeroDeTarjetaField = new JTextField();
    JTextField cvvField = new JTextField();
    JTextField localidadTextField = new JTextField();
    JTextField direccionDeFacturacionField = new JTextField();
    JTextField codigoPostalField = new JTextField();
    JComboBox<String> mesVencimientoComboBox = new JComboBox<>();
    JComboBox<String> añoVencimientoComboBox = new JComboBox<>();
    JComboBox<String> metodoDePagoComboBox = new JComboBox<>();
    JLabel cvvLabel = new JLabel("CVV: ");
    JTextField ingresarFechaField = new JTextField();
    JPanel panelCC = new JPanel();
    JPanel panelFondoCC = new JPanel();
    JPanel panelConfirmacionCC = new JPanel();
    JPanel panelFondoConfimarcionCC = new JPanel();

    private String mailVendedor;
    private String mailComprador;
    private long codEntrada;
    private String fechaVenta;
    private int valorVenta;
    private long codVenta;
    private int numeroTarjeta;
    private int cvv;
    private String metodoPagoSeleccionado;
    private String fechaVencimiento;
    private String nombreEnTarjeta;
    private String localidad;
    private String direccionFacturacion;
    private String codigoPostal;
    private int precioTotal1;
    private Venta venta;


    public ConfirmarCompraPage(Entrada entrada, Espectaculo espectaculo,Comprador comprador,JFrame frame,int precioTotal){
        precioTotal1 = precioTotal;

        metodoDePagoComboBox.addItem(" ");
        metodoDePagoComboBox.addItem("Visa");
        metodoDePagoComboBox.addItem("Mastercard");

        mesVencimientoComboBox.addItem(" ");
        mesVencimientoComboBox.addItem("01");
        mesVencimientoComboBox.addItem("02");
        mesVencimientoComboBox.addItem("03");
        mesVencimientoComboBox.addItem("04");
        mesVencimientoComboBox.addItem("05");
        mesVencimientoComboBox.addItem("06");
        mesVencimientoComboBox.addItem("07");
        mesVencimientoComboBox.addItem("08");
        mesVencimientoComboBox.addItem("09");
        mesVencimientoComboBox.addItem("10");
        mesVencimientoComboBox.addItem("11");
        mesVencimientoComboBox.addItem("12");

        añoVencimientoComboBox.addItem(" ");
        for(int i=2023;i<2050;i++){
            String año = String.valueOf(i);
            añoVencimientoComboBox.addItem(año);
        }

        frameCC = frame;
        comprador1=comprador;
        espectaculo1=espectaculo;
        entrada1=entrada;

        panelCC.setBounds(0,0,1240,720);
        panelCC.setVisible(true);
        panelCC.setLayout(null);
        panelCC.setBackground(new Color(32,51,84));

        panelFondoCC.setBounds(300,50,550,500);
        panelFondoCC.setBackground(new Color(6, 90, 131));
        panelFondoCC.setLayout(null);
        panelFondoCC.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelConfirmacionCC.setBounds(0,0,1240,720);
        panelConfirmacionCC.setVisible(false);
        panelConfirmacionCC.setLayout(null);
        panelConfirmacionCC.setBackground(new Color(32,51,84));

        panelFondoConfimarcionCC.setBounds(350,50,550,500);
        panelFondoConfimarcionCC.setBackground(new Color(6, 90, 131));
        panelFondoConfimarcionCC.setLayout(null);
        panelFondoConfimarcionCC.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        metodoDePagoLabel.setBounds(10,10,400,25);
        metodoDePagoLabel.setFont(new Font(null,Font.PLAIN,20));
        metodoDePagoLabel.setForeground(Color.white);

        informacionDeFacturacionLabel.setBounds(10,180,500,25);
        informacionDeFacturacionLabel.setFont(new Font(null,Font.PLAIN,20));
        informacionDeFacturacionLabel.setForeground(Color.white);

        seleccionaMetodoDePagoLabel.setBounds(10,50,200,25);
        seleccionaMetodoDePagoLabel.setForeground(Color.white);
        numeroDeTarjetaLabel.setBounds(10,90,200,25);
        numeroDeTarjetaLabel.setForeground(Color.white);
        cvvLabel.setBounds(340,90,100,25);
        cvvLabel.setForeground(Color.white);
        fechaVencimientoLabel.setBounds(10,130,200,25);
        fechaVencimientoLabel.setForeground(Color.white);
        nombreEnTarjetaLabel.setBounds(10,220,200,25);
        nombreEnTarjetaLabel.setForeground(Color.white);
        ingresarFechaLabel.setBounds(10,260,100,25);
        ingresarFechaLabel.setForeground(Color.white);
        localidadLabel.setBounds(250,220,100,25);
        localidadLabel.setForeground(Color.white);
        direccionDeFacturacionLabel.setBounds(220,260,200,25);
        direccionDeFacturacionLabel.setForeground(Color.white);
        codigoPostalLabel.setBounds(10,300,200,25);
        codigoPostalLabel.setForeground(Color.white);


        metodoDePagoComboBox.setBounds(200,50,100,25);
        numeroDeTarjetaField.setBounds(120,90,200,25);
        cvvField.setBounds(370,90,50,25);
        mesVencimientoComboBox.setBounds(150,130,80,25);
        añoVencimientoComboBox.setBounds(250,130,100,25);
        nombreEnTarjetaField.setBounds(120,220,100,25);
        ingresarFechaField.setBounds(100,260,100,25);
        localidadTextField.setBounds(320,220,100,25);
        direccionDeFacturacionField.setBounds(360,260,175,25);
        codigoPostalField.setBounds(120,300,100,25);

        botonConfirmar.setBounds(120,400,100,25);
        botonConfirmar.setFocusable(false);
        botonConfirmar.addActionListener(this);

        botonCancelar.setBounds(10,400,100,25);
        botonCancelar.setFocusable(false);
        botonCancelar.addActionListener(this);

        botonCancelar2.setBounds(10,400,100,25);
        botonCancelar2.setFocusable(false);
        botonCancelar2.addActionListener(this);

        panelFondoCC.add(metodoDePagoLabel);
        panelFondoCC.add(seleccionaMetodoDePagoLabel);
        panelFondoCC.add(metodoDePagoComboBox);
        panelFondoCC.add(numeroDeTarjetaLabel);
        panelFondoCC.add(numeroDeTarjetaField);
        panelFondoCC.add(cvvLabel);
        panelFondoCC.add(cvvField);
        panelFondoCC.add(fechaVencimientoLabel);
        panelFondoCC.add(mesVencimientoComboBox);
        panelFondoCC.add(añoVencimientoComboBox);
        panelFondoCC.add(informacionDeFacturacionLabel);
        panelFondoCC.add(nombreEnTarjetaLabel);
        panelFondoCC.add(nombreEnTarjetaField);
        panelFondoCC.add(ingresarFechaLabel);
        panelFondoCC.add(ingresarFechaField);
        panelFondoCC.add(nombreEnTarjetaLabel);
        panelFondoCC.add(nombreEnTarjetaField);
        panelFondoCC.add(localidadLabel);
        panelFondoCC.add(localidadTextField);
        panelFondoCC.add(direccionDeFacturacionLabel);
        panelFondoCC.add(direccionDeFacturacionField);
        panelFondoCC.add(codigoPostalLabel);
        panelFondoCC.add(codigoPostalField);
        panelFondoCC.add(botonCancelar);
        panelFondoCC.add(botonConfirmar);

        panelCC.add(panelFondoCC);

        precioTotalLabel.setBounds(10,10,300,25);
        precioTotalLabel.setForeground(Color.white);
        metodoDePagoSeleccionadolabel.setBounds(10,40,300,25);
        metodoDePagoSeleccionadolabel.setForeground(Color.white);
        cuentaDelUsuarioLabel.setBounds(10,70,300,25);
        cuentaDelUsuarioLabel.setForeground(Color.white);
        fechaDeLaCompraLabel.setBounds(10,100,300,25);
        fechaDeLaCompraLabel.setForeground(Color.white);

        botonComprar.setBounds(10,130,100,25);
        botonComprar.setFocusable(false);
        botonComprar.addActionListener(this);

        panelFondoConfimarcionCC.add(precioTotalLabel);
        panelFondoConfimarcionCC.add(metodoDePagoSeleccionadolabel);
        panelFondoConfimarcionCC.add(cuentaDelUsuarioLabel);
        panelFondoConfimarcionCC.add(fechaDeLaCompraLabel);
        panelFondoConfimarcionCC.add(botonComprar);
        panelFondoConfimarcionCC.add(botonCancelar2);

        panelConfirmacionCC.add(panelFondoConfimarcionCC);

        frame.add(panelCC);
        frame.add(panelConfirmacionCC);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonConfirmar){
            mailVendedor = espectaculo1.getMailVendedor();
            mailComprador = entrada1.getMailUsuario();
            codEntrada = entrada1.getCodEntrada();
            fechaVenta = ingresarFechaField.getText();
            valorVenta = entrada1.getPrecioEntrada();
            metodoPagoSeleccionado = (String) metodoDePagoComboBox.getSelectedItem();
            numeroTarjeta = Integer.parseInt(numeroDeTarjetaField.getText());
            cvv = Integer.parseInt(cvvField.getText());
            fechaVencimiento = (String) mesVencimientoComboBox.getSelectedItem() + "/" + (String) añoVencimientoComboBox.getSelectedItem() + "/" + "01";
            System.out.println((String) mesVencimientoComboBox.getSelectedItem() + "-" + (String) añoVencimientoComboBox.getSelectedItem()+"-" + "01") ;
            nombreEnTarjeta = nombreEnTarjetaField.getText();
            localidad = localidadTextField.getText();
            direccionFacturacion = direccionDeFacturacionField.getText();
            codigoPostal = codigoPostalField.getText();

            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat.parse(fechaVenta);
                fechaVenta = outputFormat.format(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date date = inputFormat2.parse(fechaVencimiento);
                fechaVencimiento = outputFormat2.format(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }


            Random random = new Random();
            int codMax = 5;
            long codVenta = random.nextLong((long) Math.pow(10, codMax));

            venta = new Venta(codVenta,mailVendedor,mailComprador,codEntrada,fechaVenta,valorVenta,metodoPagoSeleccionado,nombreEnTarjeta,numeroTarjeta,fechaVencimiento,cvv,localidad,direccionFacturacion,codigoPostal);

            precioTotalLabel.setText("Precio total a pagar: $" + precioTotal1);
            metodoDePagoSeleccionadolabel.setText("Metodo de pago seleccionado: " + metodoPagoSeleccionado);
            cuentaDelUsuarioLabel.setText("Cuenta utilizada: " + comprador1.getNombreUsuario());
            fechaDeLaCompraLabel.setText("Fecha: " + fechaVenta);

            panelCC.setVisible(false);
            panelConfirmacionCC.setVisible(true);

        }

        if(e.getSource()==botonComprar){
            try {
                venta.guardarVenta(venta);
                panelConfirmacionCC.setVisible(false);
                new HomePage(comprador1,frameCC);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource()==botonCancelar){
            panelCC.setVisible(false);
            try {
                entrada1.eliminarEntrada(entrada1);
                espectaculo1.sumarEntradas(espectaculo1);
                new HomePage(comprador1,frameCC);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource()==botonCancelar2){

            try {
                venta.cancelarVenta(venta,espectaculo1);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }
            try {
                panelConfirmacionCC.setVisible(false);
                new HomePage(comprador1,frameCC);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


        }


    }

}
