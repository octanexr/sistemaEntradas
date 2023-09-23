package gui;

import Controlador.*;
import Model.DAOEstadio;
import service.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HomePage implements ActionListener {
    private boolean es_admin;
    private boolean es_vendedor;
    private Comprador comprador1;
    private Vendedor vendedor1;
    private int precioTotal;

    JFrame frameHP;
    JPanel panelAdmin = new JPanel();
    JPanel panelComprador = new JPanel();
    JPanel panelSeleccionComprador = new JPanel();
    JPanel panelVendedor = new JPanel();
    JPanel panelEntradasVendidas = new JPanel();
    JPanel panelHeaderComprador = new JPanel();
    JPanel panelEventosComprador = new JPanel();
    JPanel panelEntradasComprador = new JPanel();
    JPanel panelEspectaculosDestacados = new JPanel();
    JPanel panelFondoSeleccionComprador = new JPanel();
    JPanel panelEstadiosAdmin = new JPanel();
    JPanel panelEventosAdmin = new JPanel();
    JPanel panelGenerarInformeAdmin = new JPanel();
    JPanel panelHeaderAdmin = new JPanel();
    JPanel panelHeaderVendedor = new JPanel();
    JPanel panelEventosVendedor = new JPanel();
    JButton botonRegistrarEstadio = new JButton("Registrar nuevo estadio");
    JButton botonRegistrarEspectaculo = new JButton("Registrar nuevo evento");
    JButton botonGenerarInforme = new JButton("Generar informe");
    JButton botonVerEspectaculos = new JButton("VER TODOS / COMPRAR ENTRADA");
    JButton botonVerEspectaculos2 = new JButton("VER TODOS / COMPRAR ENTRADA");
    JButton botonConfirmarSeleccion = new JButton("Continuar");
    JButton botonVerEntradas = new JButton("VER TODAS MIS ENTRADAS");
    JButton botonVerEntradasVendidas = new JButton("Ver entradas vendidas");
    JButton botonVolver1 = new JButton("Volver");
    JButton botonVolver2 = new JButton("Volver");
    JButton botonCerrarSesion = new JButton("Cerrar sesion");
    JButton botonCerrarSesion2 = new JButton("Cerrar sesion");
    JButton botonCerrarSesion3 = new JButton("Cerrar sesion");
    JComboBox<Espectaculo> espectaculoComboBox = new JComboBox<>();
    JComboBox<String> seleccionAsientoComboBox = new JComboBox<>();
    JComboBox<Venta> entradasVendidasComboBox = new JComboBox<>();
    JLabel seleccionarUnEspactaculoLabel = new JLabel("Seleccione un espectaculo: ");
    JLabel nombreEspectaculoLabel = new JLabel("Nombre del espectaculo: ");
    JLabel estadioEspectaculoLabel = new JLabel("Estadio: ");
    JLabel cantEntradasEspectaculoLabel = new JLabel("Cantidad de entradas disponibles: ");
    JLabel fechaEspectaculoLabel = new JLabel("Fecha: ");
    JLabel precioEspectaculoLabel = new JLabel("Precio del espectaculo: ");
    JLabel seleccionarUbicacionLabel = new JLabel("Seleccionar ubicacion: ");
    JLabel precioUbicacionLabel = new JLabel();
    JLabel cantidadDeVentasLabel = new JLabel();
    JLabel bienvenidaAdminLabel = new JLabel();
    JLabel bienvenidaUsuarioLabel = new JLabel();
    JLabel bienvenidaVendedorLabel = new JLabel();
    JLabel tituloEspectaculosLabel = new JLabel("    Espectaculos     ");
    JLabel entradasUsuarioLabel = new JLabel("        Mis entradas      ");
    JLabel espectaculosDestacadosLabel = new JLabel("Espectaculos destacados");
    JLabel tituloEstadioSLabel = new JLabel("  Estadios   ");
    JLabel tituloEventosAdminLabel = new JLabel("   Espectaculos  ");
    JLabel tituloGenerarInformeLabel = new JLabel("Generar informe de ventas");
    JLabel tituloEventosVendedorLabel = new JLabel("                                              Mis eventos                                                     ");
    JLabel estadioEspectaculoImagenLabel = new JLabel();
    private Estadio estadio;
    private Espectaculo espectaculo;
    private ArrayList<Espectaculo> espectaculos = new ArrayList<>();
    private ArrayList<Entrada> entradas = new ArrayList<>();
    private ArrayList<Estadio> estadios = new ArrayList<>();
    JComboBox<Estadio> estadiosComboBox = new JComboBox<>();
    JPanel panelImagenesEstadio = new JPanel();
    JButton botonVerImagenesEstadio = new JButton("Ver imagenes estadio");
    JButton botonSeleccionarEstadio = new JButton("Seleccionar");
    JButton botonSubirImagenEstadio = new JButton("Subir imagen");
    JLabel imagenEstadioLabel = new JLabel();
    File file;

    CompradorService compradorService = new CompradorService();
    VentaService ventaService = new VentaService();
    EspectaculoService espectaculoService = new EspectaculoService();
    EstadioService estadioService = new EstadioService();
    VendedorService vendedorService = new VendedorService();
    EntradaService entradaService = new EntradaService();
    JButton botonVolver3 = new JButton("Volver");

    private void cargarVentas(Vendedor vendedor){
        try {
            ArrayList<Venta> ventas = vendedor.verVentas(vendedor);
            for(Venta venta:ventas){
                entradasVendidasComboBox.addItem(venta);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }


    private void cargarEspectaculos(){
        try {
            ArrayList<Espectaculo> espectaculos = espectaculoService.buscarTodosEspectaculo();
            for(Espectaculo espectaculo:espectaculos){
                espectaculoComboBox.addItem(espectaculo);
            }
        } catch (ServiceException e) {
            throw new RuntimeException(e);
        }

    }

    private void cargarEstadios2() throws ServiceException{
        try{
            ArrayList<Estadio> estadios = estadioService.buscarTodosEstadio();
            for(Estadio a:estadios){
                estadiosComboBox.addItem(a);
            }
        }catch (ServiceException e){
            throw new RuntimeException(e);
        }
    }

    private void cargarEspectaculos2() throws ServiceException {
        espectaculos = espectaculoService.buscarTodosEspectaculo();
    }

    private void cargarEspectaculoVendedor(Vendedor vendedor) throws ServiceException {
        espectaculos = espectaculoService.buscarTodosEspectaculosPorVendedor(vendedor.getMailUsuario());
        vendedor.setEspectaculos(espectaculos);
    }

    private void cargarEntradas() throws ServiceException {
        entradas = entradaService.buscarTodosUsuarioEntrada(comprador1.getMailUsuario());
        comprador1.setEntradas(entradas);
    }

    private void cargarEstadios() throws ServiceException{
        estadios = estadioService.buscarTodosEstadio();
    }

    public HomePage(Usuario usuario,JFrame frame) throws ServiceException {
        frameHP = frame;
        es_admin = compradorService.buscarEsAdmin(usuario.getMailUsuario());
        es_vendedor = vendedorService.buscarEsVendedor(usuario.getMailUsuario());


        if(!es_vendedor){
            comprador1 = (Comprador) usuario;
        }

        if(es_vendedor){
            vendedor1 = (Vendedor) usuario;
            cargarVentas(vendedor1);

        }

        panelAdmin.setBounds(0,0,1240, 720);
        panelAdmin.setBackground(Color.RED);
        panelAdmin.setVisible(false);
        panelAdmin.setLayout(null);

        panelHeaderAdmin.setBounds(0,0,1240,40);
        panelHeaderAdmin.setBackground(new Color(21,34,56));
        panelHeaderAdmin.setLayout(null);

        botonCerrarSesion2.setBounds(1000,5,180,30);
        botonCerrarSesion2.setFocusable(false);
        botonCerrarSesion2.addActionListener(this);

        bienvenidaAdminLabel.setBounds(5,5,1240,30);
        bienvenidaAdminLabel.setText("Bienvenido/a " + usuario.getNombreUsuario() + "!");
        bienvenidaAdminLabel.setFont(new Font(null,Font.ITALIC, 25));
        bienvenidaAdminLabel.setForeground(Color.white);

        panelHeaderAdmin.add(botonCerrarSesion2);
        panelHeaderAdmin.add(bienvenidaAdminLabel);

        panelEstadiosAdmin.setBounds(0,40,400,670);
        panelEstadiosAdmin.setBackground(new Color(32,51,84)); //ACA
        panelEstadiosAdmin.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEstadiosAdmin.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        tituloEstadioSLabel.setBounds(130,5,200,25);
        tituloEstadioSLabel.setFont(new Font(null,Font.PLAIN,20));
        tituloEstadioSLabel.setForeground(Color.white);

        botonRegistrarEstadio.setBounds(115,160,180,30);
        botonRegistrarEstadio.setFocusable(false);
        botonRegistrarEstadio.addActionListener(this);
        botonRegistrarEstadio.setFont(new Font(null,Font.BOLD,15));


        panelEstadiosAdmin.add(tituloEstadioSLabel);
        panelEstadiosAdmin.add(botonRegistrarEstadio);

        panelEventosAdmin.setBounds(400,40,400,670);
        panelEventosAdmin.setBackground(new Color(32,51,84));
        panelEventosAdmin.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEventosAdmin.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        tituloEventosAdminLabel.setBounds(130,5,200,25);
        tituloEventosAdminLabel.setFont(new Font(null,Font.PLAIN,20));
        tituloEventosAdminLabel.setForeground(Color.white);

        botonRegistrarEspectaculo.setBounds(115,160,180,30);
        botonRegistrarEspectaculo.setFocusable(false);
        botonRegistrarEspectaculo.addActionListener(this);
        botonRegistrarEspectaculo.setFont(new Font(null,Font.BOLD,15));

        panelEventosAdmin.add(tituloEventosAdminLabel);
        panelEventosAdmin.add(botonRegistrarEspectaculo);

        botonGenerarInforme.setBounds(115,160,180,30);
        botonGenerarInforme.setFocusable(false);
        botonGenerarInforme.addActionListener(this);
        botonGenerarInforme.setFont(new Font(null,Font.BOLD,15));

        tituloGenerarInformeLabel.setBounds(130,5,200,25);
        tituloGenerarInformeLabel.setFont(new Font(null,Font.PLAIN,20));
        tituloGenerarInformeLabel.setForeground(Color.white);

        panelGenerarInformeAdmin.add(tituloGenerarInformeLabel);
        panelGenerarInformeAdmin.add(botonGenerarInforme);

        panelImagenesEstadio.setBounds(0,0,1240,720);
        panelImagenesEstadio.setVisible(false);
        panelImagenesEstadio.setLayout(null);

        botonVerImagenesEstadio.setBounds(115,200,180,30);
        botonVerImagenesEstadio.setFocusable(false);
        botonVerImagenesEstadio.addActionListener(this);

        botonSubirImagenEstadio.setBounds(500,0,180,30);
        botonSubirImagenEstadio.setFocusable(false);
        botonSubirImagenEstadio.addActionListener(this);

        botonVolver3.setBounds(700,0,180,30);
        botonVolver3.setFocusable(false);
        botonVolver3.addActionListener(this);

        estadiosComboBox.setBounds(0,0,200,25);
        botonSeleccionarEstadio.setBounds(250,0,180,30);
        botonSeleccionarEstadio.addActionListener(this);
        imagenEstadioLabel.setBounds(0,300,692,490);

        panelImagenesEstadio.add(botonVolver3);
        panelImagenesEstadio.add(botonSubirImagenEstadio);
        panelImagenesEstadio.add(estadiosComboBox);
        panelImagenesEstadio.add(imagenEstadioLabel);
        panelImagenesEstadio.add(botonSeleccionarEstadio);

        panelGenerarInformeAdmin.add(botonVerImagenesEstadio);

        frame.add(panelImagenesEstadio);

        panelAdmin.add(panelGenerarInformeAdmin);
        panelAdmin.add(panelHeaderAdmin);
        panelAdmin.add(panelEstadiosAdmin);
        panelAdmin.add(panelEventosAdmin);

        panelGenerarInformeAdmin.setBounds(800,40,430,670);
        panelGenerarInformeAdmin.setBackground(new Color(32,51,84));
        panelGenerarInformeAdmin.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelGenerarInformeAdmin.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        panelComprador.setBounds(0,0,1240, 720);
        panelComprador.setBackground(Color.green);
        panelComprador.setVisible(false);
        panelComprador.setLayout(null);

        bienvenidaUsuarioLabel.setBounds(5,5,1240,30);
        bienvenidaUsuarioLabel.setText("Bienvenido/a " + usuario.getNombreUsuario() + "!");
        bienvenidaUsuarioLabel.setFont(new Font(null,Font.ITALIC, 25));
        bienvenidaUsuarioLabel.setForeground(Color.white);

        botonVerEspectaculos.setFocusable(false);
        botonVerEspectaculos.setBounds(100,600,180,30);
        botonVerEspectaculos.addActionListener(this);
        botonVerEspectaculos.setFont(new Font(null,Font.BOLD,15));

        botonVerEspectaculos2.setFocusable(false);
        botonVerEspectaculos2.setBounds(100,600,180,30);
        botonVerEspectaculos2.addActionListener(this);
        botonVerEspectaculos2.setFont(new Font(null,Font.BOLD,15));

        botonVerEntradas.setBounds(115,160,180,30);
        botonVerEntradas.setFocusable(false);
        botonVerEntradas.addActionListener(this);
        botonVerEntradas.setFont(new Font(null,Font.BOLD,15));

        botonCerrarSesion.setBounds(1000,5,180,30);
        botonCerrarSesion.setFocusable(false);
        botonCerrarSesion.addActionListener(this);

        panelHeaderComprador.setBounds(0,0,1240,40);
        panelHeaderComprador.setBackground(new Color(21,34,56));
        panelHeaderComprador.setLayout(null);

        panelHeaderComprador.add(bienvenidaUsuarioLabel);
        panelHeaderComprador.add(botonCerrarSesion);

        panelEventosComprador.setBounds(0,40,400,670);
        panelEventosComprador.setBackground(new Color(32,51,84)); //ACA
        panelEventosComprador.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEventosComprador.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        tituloEspectaculosLabel.setBounds(130,5,200,25);
        tituloEspectaculosLabel.setFont(new Font(null,Font.PLAIN,20));
        tituloEspectaculosLabel.setForeground(Color.white);

        panelEventosComprador.add(tituloEspectaculosLabel);
        panelEventosComprador.add(botonVerEspectaculos);

        panelEntradasComprador.setBounds(400,40,400,670);
        panelEntradasComprador.setBackground(new Color(32,51,84));
        panelEntradasComprador.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEntradasComprador.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        entradasUsuarioLabel.setBounds(130,5,200,25);
        entradasUsuarioLabel.setFont(new Font(null,Font.PLAIN,20));
        entradasUsuarioLabel.setForeground(Color.white);

        panelEntradasComprador.add(entradasUsuarioLabel);
        panelEntradasComprador.add(botonVerEntradas);

        panelEspectaculosDestacados.setBounds(800,40,430,670);
        panelEspectaculosDestacados.setBackground(new Color(32,51,84));
        panelEspectaculosDestacados.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEspectaculosDestacados.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        espectaculosDestacadosLabel.setBounds(100,5,250,25);
        espectaculosDestacadosLabel.setFont(new Font(null,Font.PLAIN,20));
        espectaculosDestacadosLabel.setForeground(Color.white);

        panelEspectaculosDestacados.add(espectaculosDestacadosLabel);
        panelEspectaculosDestacados.add(botonVerEspectaculos2);
        
        panelComprador.add(panelEspectaculosDestacados);
        panelComprador.add(panelEntradasComprador);
        panelComprador.add(panelEventosComprador);
        panelComprador.add(panelHeaderComprador);

        panelFondoSeleccionComprador.setBounds(350,50,500,500);
        panelFondoSeleccionComprador.setBackground(new Color(6, 90, 131));
        panelFondoSeleccionComprador.setLayout(null);
        panelFondoSeleccionComprador.setBorder(BorderFactory.createLineBorder(Color.black));

        panelSeleccionComprador.setBounds(0,0,1240,720);
        panelSeleccionComprador.setBackground(new Color(32,51,84));
        panelSeleccionComprador.setVisible(false);
        panelSeleccionComprador.setLayout(null);

        espectaculoComboBox.setBounds(200,10,250,25);
        espectaculoComboBox.addActionListener(this);

        botonConfirmarSeleccion.setBounds(220,240,120,25);
        botonConfirmarSeleccion.setFocusable(false);
        botonConfirmarSeleccion.setVisible(false);
        botonConfirmarSeleccion.addActionListener(this);

        seleccionarUnEspactaculoLabel.setBounds(15,10,200,25);
        seleccionarUnEspactaculoLabel.setForeground(Color.white);
        nombreEspectaculoLabel.setBounds(15,45,300,25);
        nombreEspectaculoLabel.setForeground(Color.white);
        cantEntradasEspectaculoLabel.setBounds(15,65,300,25);
        cantEntradasEspectaculoLabel.setForeground(Color.white);
        fechaEspectaculoLabel.setBounds(15,85,300,25);
        fechaEspectaculoLabel.setForeground(Color.white);
        estadioEspectaculoLabel.setBounds(15,105,300,25);
        estadioEspectaculoLabel.setForeground(Color.white);
        precioEspectaculoLabel.setBounds(15,125,300,25);
        precioEspectaculoLabel.setForeground(Color.white);
        seleccionarUbicacionLabel.setBounds(15,155,150,25);
        seleccionarUbicacionLabel.setForeground(Color.white);
        precioUbicacionLabel.setBounds(15,185,300,25);
        precioUbicacionLabel.setForeground(Color.white);


        seleccionAsientoComboBox.addItem("Seleccionar");
        seleccionAsientoComboBox.addItem("Platea");
        seleccionAsientoComboBox.addItem("Campo");
        seleccionAsientoComboBox.addItem("VIP");
        seleccionAsientoComboBox.setVisible(false);
        seleccionAsientoComboBox.setBounds(150,155,200,25);
        seleccionAsientoComboBox.addActionListener(this);

        botonVolver1.setBounds(15,435,75,25);
        botonVolver1.setFocusable(false);
        botonVolver1.addActionListener(this);

        estadioEspectaculoImagenLabel.setBounds(15,215,200,200);

        panelFondoSeleccionComprador.add(estadioEspectaculoImagenLabel);
        panelFondoSeleccionComprador.add(espectaculoComboBox);
        panelFondoSeleccionComprador.add(botonConfirmarSeleccion);
        panelFondoSeleccionComprador.add(nombreEspectaculoLabel);
        panelFondoSeleccionComprador.add(cantEntradasEspectaculoLabel);
        panelFondoSeleccionComprador.add(fechaEspectaculoLabel);
        panelFondoSeleccionComprador.add(estadioEspectaculoLabel);
        panelFondoSeleccionComprador.add(precioEspectaculoLabel);
        panelFondoSeleccionComprador.add(seleccionarUbicacionLabel);
        panelFondoSeleccionComprador.add(seleccionAsientoComboBox);
        panelFondoSeleccionComprador.add(precioUbicacionLabel);
        panelFondoSeleccionComprador.add(botonVolver1);
        panelFondoSeleccionComprador.add(seleccionarUnEspactaculoLabel);

        panelSeleccionComprador.add(panelFondoSeleccionComprador);


        panelVendedor.setBounds(0,0,1240,720);
        panelVendedor.setLayout(null);
        panelVendedor.setBackground(new Color(32,51,84));
        panelVendedor.setVisible(false);

        panelHeaderVendedor.setBounds(0,0,1240,40);
        panelHeaderVendedor.setBackground(new Color(21,34,56));
        panelHeaderVendedor.setLayout(null);

        bienvenidaVendedorLabel.setBounds(5,5,1240,30);
        bienvenidaVendedorLabel.setText("Bienvenido " + usuario.getNombreUsuario() + "!");
        bienvenidaVendedorLabel.setFont(new Font(null,Font.ITALIC, 25));
        bienvenidaVendedorLabel.setForeground(Color.white);

        botonCerrarSesion3.setBounds(1000,5,180,30);
        botonCerrarSesion3.setFocusable(false);
        botonCerrarSesion3.addActionListener(this);

        panelHeaderVendedor.add(bienvenidaAdminLabel);
        panelHeaderVendedor.add(botonCerrarSesion3);

        botonVerEntradasVendidas.setBounds(800,120,180,30);
        botonVerEntradasVendidas.setFocusable(false);
        botonVerEntradasVendidas.addActionListener(this);

        panelEventosVendedor.setBounds(0,40,620,670);
        panelEventosVendedor.setBackground(new Color(32,51,84)); //ACA
        panelEventosVendedor.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelEventosVendedor.setBorder(BorderFactory.createLineBorder(new Color(85,85,85)));

        tituloEventosVendedorLabel.setBounds(130,5,200,25);
        tituloEventosVendedorLabel.setFont(new Font(null,Font.PLAIN,20));
        tituloEventosVendedorLabel.setForeground(Color.white);

        panelEventosVendedor.add(tituloEventosVendedorLabel);

        panelVendedor.add(panelEventosVendedor);
        panelVendedor.add(panelHeaderVendedor);
        panelVendedor.add(botonVerEntradasVendidas);

        panelEntradasVendidas.setBounds(0,0,1240,720);
        panelEntradasVendidas.setLayout(null);
        panelEntradasVendidas.setBackground(new Color(32,51,84));
        panelEntradasVendidas.setVisible(false);

        entradasVendidasComboBox.setBounds(10,10,300,25);
        cantidadDeVentasLabel.setBounds(0,50,200,25);
        cantidadDeVentasLabel.setForeground(Color.white);

        botonVolver2.setBounds(120,100,75,50);
        botonVolver2.setFocusable(false);
        botonVolver2.addActionListener(this);

        panelEntradasVendidas.add(entradasVendidasComboBox);
        panelEntradasVendidas.add(cantidadDeVentasLabel);
        panelEntradasVendidas.add(botonVolver2);


        if(es_admin && !es_vendedor){
            cargarEstadios();
            cargarEspectaculos2();
            frame.add(panelAdmin);
            panelAdmin.setVisible(true);

            for(Estadio a:estadios){
                JPanel panelEstadio = new JPanel();
                panelEstadio.setLayout(null);
                panelEstadio.setPreferredSize(new Dimension(350,65));
                panelEstadio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelEstadio.setBackground(new Color(6, 90, 131));

                JLabel nombreLabel = new JLabel("Nombre del estadio: " + a.getNombreEstadio());
                JLabel capacidadMaximaLabel = new JLabel("Capacidad Maxima: " + a.getCapacidadMaxima());

                nombreLabel.setBounds(5,5,340,20);
                nombreLabel.setForeground(Color.white);
                capacidadMaximaLabel.setBounds(5,35,200,20);
                capacidadMaximaLabel.setForeground(Color.white);

                panelEstadio.add(nombreLabel);
                panelEstadio.add(capacidadMaximaLabel);

                panelEstadiosAdmin.add(panelEstadio);


            }

            for(Espectaculo a: espectaculos){
                JPanel panelEventoA = new JPanel();
                panelEventoA.setLayout(null);
                panelEventoA.setVisible(true);
                panelEventoA.setPreferredSize(new Dimension(350,100));
                panelEventoA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelEventoA.setBackground(new Color(6, 90, 131));

                JLabel nombreLabel = new JLabel("Nombre del espectáculo: " + a.getNombreEspectaculo());
                JLabel fechaLabel = new JLabel("Fecha: " + a.getFechaEvento());
                JLabel precioLabel = new JLabel("Precio: $" + a.getPrecioEspectaculo());
                JLabel entradasLabel = new JLabel("Entradas disponibles: " + a.getCantEntradas());

                nombreLabel.setBounds(5,5,340,20);
                nombreLabel.setForeground(Color.white);
                fechaLabel.setBounds(5,25,200,20);
                fechaLabel.setForeground(Color.white);
                precioLabel.setBounds(5,45,200,20);
                precioLabel.setForeground(Color.white);
                entradasLabel.setBounds(5,65,200,20);
                entradasLabel.setForeground(Color.white);

                panelEventoA.add(nombreLabel);
                panelEventoA.add(fechaLabel);
                panelEventoA.add(precioLabel);
                panelEventoA.add(entradasLabel);

                panelEventosAdmin.add(panelEventoA);
            }
        }

        else if(!es_vendedor && !es_admin){
            cargarEspectaculos2();
            cargarEntradas();
            System.out.println(comprador1.toString2());
            frame.add(panelComprador);
            frame.add(panelSeleccionComprador);
            panelComprador.setVisible(true);

            for(Espectaculo a: espectaculos){
                JPanel panelEvento = new JPanel();
                panelEvento.setLayout(null);
                panelEvento.setPreferredSize(new Dimension(350,100));
                panelEvento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelEvento.setBackground(new Color(6, 90, 131));

                JLabel nombreLabel = new JLabel("Nombre del espectáculo: " + a.getNombreEspectaculo());
                JLabel fechaLabel = new JLabel("Fecha: " + a.getFechaEvento());
                JLabel precioLabel = new JLabel("Precio: $" + a.getPrecioEspectaculo());
                JLabel entradasLabel = new JLabel("Entradas disponibles: " + a.getCantEntradas());

                nombreLabel.setBounds(5,5,340,20);
                nombreLabel.setForeground(Color.white);
                fechaLabel.setBounds(5,25,200,20);
                fechaLabel.setForeground(Color.white);
                precioLabel.setBounds(5,45,200,20);
                precioLabel.setForeground(Color.white);
                entradasLabel.setBounds(5,65,200,20);
                entradasLabel.setForeground(Color.white);

                panelEvento.add(nombreLabel);
                panelEvento.add(fechaLabel);
                panelEvento.add(precioLabel);
                panelEvento.add(entradasLabel);

                panelEventosComprador.add(panelEvento);
            }

            for(Entrada a:entradas){
                JPanel panelEntrada = new JPanel();
                panelEntrada.setLayout(null);
                panelEntrada.setPreferredSize(new Dimension(350,100));
                panelEntrada.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelEntrada.setBackground(new Color(6, 90, 131));

                Espectaculo b = espectaculoService.buscarEspectaculo(a.getCodEspectaculo());

                JLabel nombreEntradaLabel = new JLabel("Nombre del espectaculo: " + b.getNombreEspectaculo());
                JLabel fechaEntradaLabel = new JLabel("Fecha: " + b.getFechaEvento());
                JLabel ubicacionLabel = new JLabel("Ubicacion: " + a.getUbicacion());
                JLabel fechaCompraLabel = new JLabel("Comprada en el: " + a.getFechaEntrada());

                nombreEntradaLabel.setBounds(5,5,340,20);
                nombreEntradaLabel.setForeground(Color.white);
                fechaEntradaLabel.setBounds(5,25,200,20);
                fechaEntradaLabel.setForeground(Color.white);
                ubicacionLabel.setBounds(5,45,200,20);
                ubicacionLabel.setForeground(Color.white);
                fechaCompraLabel.setBounds(5,65,200,20);
                fechaCompraLabel.setForeground(Color.white);

                panelEntrada.add(nombreEntradaLabel);
                panelEntrada.add(fechaEntradaLabel);
                panelEntrada.add(ubicacionLabel);
                panelEntrada.add(fechaCompraLabel);
                
                panelEntradasComprador.add(panelEntrada);

            }

            for(Espectaculo a:espectaculos){
                Collections.shuffle(espectaculos);
                JPanel panelEventoDestacado = new JPanel();
                panelEventoDestacado.setLayout(null);
                panelEventoDestacado.setPreferredSize(new Dimension(350,100));
                panelEventoDestacado.setBorder(BorderFactory.createLineBorder(Color.black));
                panelEventoDestacado.setBackground(new Color(6, 90, 131));

                JLabel nombreLabel = new JLabel("Nombre del espectáculo: " + a.getNombreEspectaculo());
                JLabel fechaLabel = new JLabel("Fecha: " + a.getFechaEvento());
                JLabel precioLabel = new JLabel("Precio: $" + a.getPrecioEspectaculo());
                JLabel entradasLabel = new JLabel("Entradas disponibles: " + a.getCantEntradas());

                nombreLabel.setBounds(5,5,340,20);
                nombreLabel.setForeground(Color.white);
                fechaLabel.setBounds(5,25,200,20);
                fechaLabel.setForeground(Color.white);
                precioLabel.setBounds(5,45,200,20);
                precioLabel.setForeground(Color.white);
                entradasLabel.setBounds(5,65,200,20);
                entradasLabel.setForeground(Color.white);

                panelEventoDestacado.add(nombreLabel);
                panelEventoDestacado.add(fechaLabel);
                panelEventoDestacado.add(precioLabel);
                panelEventoDestacado.add(entradasLabel);

                panelEspectaculosDestacados.add(panelEventoDestacado);
                
            }


        }

        else if(!es_admin && es_vendedor){
            cargarEspectaculoVendedor(vendedor1);
            System.out.println(vendedor1.toString2());
            frame.add(panelVendedor);
            frame.add(panelEntradasVendidas);
            panelVendedor.setVisible(true);

            for(Espectaculo a:espectaculos){
                JPanel panelEvento = new JPanel();
                panelEvento.setLayout(null);
                panelEvento.setPreferredSize(new Dimension(300,100));
                panelEvento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelEvento.setBackground(new Color(6, 90, 131));

                JLabel nombreLabel = new JLabel("Nombre del espectáculo: " + a.getNombreEspectaculo());
                JLabel fechaLabel = new JLabel("Fecha: " + a.getFechaEvento());
                JLabel precioLabel = new JLabel("Precio: $" + a.getPrecioEspectaculo());
                JLabel entradasLabel = new JLabel("Entradas disponibles: " + a.getCantEntradas());

                nombreLabel.setBounds(5,5,340,20);
                nombreLabel.setForeground(Color.white);
                fechaLabel.setBounds(5,25,200,20);
                fechaLabel.setForeground(Color.white);
                precioLabel.setBounds(5,45,200,20);
                precioLabel.setForeground(Color.white);
                entradasLabel.setBounds(5,65,200,20);
                entradasLabel.setForeground(Color.white);

                panelEvento.add(nombreLabel);
                panelEvento.add(fechaLabel);
                panelEvento.add(precioLabel);
                panelEvento.add(entradasLabel);

                panelEventosVendedor.add(panelEvento);



            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonRegistrarEstadio){
            panelAdmin.setVisible(false);
            panelAdmin = null;
            RegistrarEstadioPage registrarEstadioPage = new RegistrarEstadioPage(comprador1,frameHP);
        }

        if(e.getSource()==botonVerImagenesEstadio){
            panelAdmin.setVisible(false);
            panelImagenesEstadio.setVisible(true);
            try {
                cargarEstadios2();
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

        }

        if(e.getSource()==botonSeleccionarEstadio){
            Estadio b = (Estadio) estadiosComboBox.getSelectedItem();
            ByteArrayInputStream inputStream;
            Image imagen;
            DAOEstadio daoEstadio = new DAOEstadio();
            try {
                inputStream = new ByteArrayInputStream(b.buscarImagenEstadio(b)) ;
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

            try {
                imagen = ImageIO.read(inputStream);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Image imagenRedimensionada = imagen.getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imagenRedimensionada);
            imagenEstadioLabel.setIcon(imageIcon);


        }

        if(e.getSource()==botonSubirImagenEstadio){
            JFileChooser fileChooser = new JFileChooser();
            byte[] imagenBytes;

            int response = fileChooser.showOpenDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
            try {
                imagenBytes = Files.readAllBytes(file.toPath());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            Estadio b = (Estadio) estadiosComboBox.getSelectedItem();
            try {
                estadioService.subirImagenEstadio(b.getCodEstadio(),imagenBytes);
                JOptionPane.showMessageDialog(null, "Imagen subida con exito!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }


        }

        if(e.getSource()==botonRegistrarEspectaculo){
            panelAdmin.setVisible(false);
            panelAdmin = null;
            RegistrarEspectaculoPage registrarEspectaculoPage = new RegistrarEspectaculoPage(comprador1,frameHP);
        }

        if(e.getSource()==botonGenerarInforme){
            panelAdmin.setVisible(false);
            panelAdmin = null;
            new RealizarInformePage(frameHP,comprador1);

        }

        if(e.getSource()==botonCerrarSesion){
            frameHP.dispose();
            new LoginPage();

        }
        if(e.getSource()==botonCerrarSesion2){
            frameHP.dispose();
            new LoginPage();

        }
        if(e.getSource()==botonCerrarSesion3){
            frameHP.dispose();
            new LoginPage();

        }

        if(e.getSource()==botonVerEspectaculos){
            panelComprador.setVisible(false);
            cargarEspectaculos();
            panelSeleccionComprador.setVisible(true);

        }
        if(e.getSource()==botonVerEspectaculos2){
            panelComprador.setVisible(false);
            cargarEspectaculos();
            panelSeleccionComprador.setVisible(true);

        }

        if(e.getSource()==botonVerEntradas){
            panelComprador.setVisible(false);
            new EntradasDelUsuarioPage(comprador1,frameHP);

        }

        if(e.getSource()==botonVerEntradasVendidas){
            panelVendedor.setVisible(false);
            panelEntradasVendidas.setVisible(true);

            cantidadDeVentasLabel.setText("Cantidad de entradas vendidas: " + String.valueOf(entradasVendidasComboBox.getItemCount()));
        }

        if(e.getSource()==botonVolver1){
            panelSeleccionComprador.setVisible(false);
            panelComprador.setVisible(true);

        }

        if(e.getSource()==botonVolver2){
            panelEntradasVendidas.setVisible(false);
            panelVendedor.setVisible(true);

        }

        if(e.getSource()==botonVolver3){
            panelImagenesEstadio.setVisible(false);
            panelAdmin.setVisible(true);

        }

        if(e.getSource()==espectaculoComboBox){
            espectaculo = (Espectaculo) espectaculoComboBox.getSelectedItem();
            System.out.printf(espectaculo.toString2());
            try {
                estadio = estadioService.buscar(espectaculo.getCodEstadio());
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

            ByteArrayInputStream inputStream;
            Image imagen;
            try {
                inputStream = new ByteArrayInputStream(estadio.buscarImagenEstadio(estadio)) ;
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

            try {
                imagen = ImageIO.read(inputStream);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Image imagenRedimensionada = imagen.getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imagenRedimensionada);
            estadioEspectaculoImagenLabel.setIcon(imageIcon);


            nombreEspectaculoLabel.setText("Nombre del espectaculo: " + espectaculo.getNombreEspectaculo());
            cantEntradasEspectaculoLabel.setText("Cantidad de entradas disponibles: " + String.valueOf(espectaculo.getCantEntradas()));
            fechaEspectaculoLabel.setText("Fecha: " + espectaculo.getFechaEvento());
            estadioEspectaculoLabel.setText("Estadio: " + estadio.getNombreEstadio());
            precioEspectaculoLabel.setText("Pracio del espectaculo: $" + String.valueOf(espectaculo.getPrecioEspectaculo()));

            seleccionAsientoComboBox.setVisible(true);

        }

        if(e.getSource()==seleccionAsientoComboBox){
            if(seleccionAsientoComboBox.getSelectedItem()=="Seleccionar"){
                precioUbicacionLabel.setText("");
                botonConfirmarSeleccion.setVisible(false);
            }

            if(seleccionAsientoComboBox.getSelectedItem()=="Platea"){
                precioUbicacionLabel.setText("Precio de la ubicacion: $" + String.valueOf(estadio.getPrecioPlatea()) );
                botonConfirmarSeleccion.setVisible(true);
                precioTotal = estadio.getPrecioPlatea() + espectaculo.getPrecioEspectaculo();

            }

            if(seleccionAsientoComboBox.getSelectedItem()=="Campo"){
                precioUbicacionLabel.setText("Precio de la ubicacion: $" + String.valueOf(estadio.getPrecioCampo()) );
                botonConfirmarSeleccion.setVisible(true);
                precioTotal = estadio.getPrecioCampo() + espectaculo.getPrecioEspectaculo();

            }
            if(seleccionAsientoComboBox.getSelectedItem()=="VIP"){
                precioUbicacionLabel.setText("Precio de la ubicacion: $" + String.valueOf(estadio.getPrecioVip()) );
                botonConfirmarSeleccion.setVisible(true);
                precioTotal = estadio.getPrecioVip() + espectaculo.getPrecioEspectaculo();
            }


        }

        if(e.getSource()==botonConfirmarSeleccion){
            long codEspectaculo = espectaculo.getCodEspectaculo();
            long codEstadio = espectaculo.getCodEstadio();
            String fechaEntrada = espectaculo.getFechaEvento();
            int precioEntrada = precioTotal;
            String mailUsuario = comprador1.getMailUsuario();
            String ubicacion = (String) seleccionAsientoComboBox.getSelectedItem();

            Random random = new Random();
            int codMax = 5;
            long codEntrada = random.nextLong((long) Math.pow(10, codMax));

            try {
                espectaculo.restarEntradas(espectaculo);
            } catch (ServiceException ex) {
                throw new RuntimeException(ex);
            }

            if(espectaculo.getCantEntradas()>-1) {

                Entrada entrada = new Entrada(codEntrada, codEspectaculo, codEstadio, fechaEntrada, precioEntrada, mailUsuario, ubicacion);

                try {
                    entrada.guardarEntrada(entrada);
                } catch (ServiceException ex) {
                    throw new RuntimeException(ex);
                }
                panelSeleccionComprador.setVisible(false);
                new ConfirmarCompraPage(entrada,espectaculo,comprador1,frameHP,precioTotal);
            }
            else {
                try {
                    espectaculo.sumarEntradas(espectaculo);
                    JOptionPane.showMessageDialog(null,"Entradas agotadas.","ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
                } catch (ServiceException ex) {
                    throw new RuntimeException(ex);
                }

            }


        }


    }
}
