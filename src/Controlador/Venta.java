package Controlador;

import Model.DAOEntrada;
import Model.DAOEspectaculo;
import Model.DAOException;
import service.EntradaService;
import service.EspectaculoService;
import service.ServiceException;
import service.VentaService;

import javax.swing.*;
import java.time.LocalDate;

public class Venta {
    private long codventa;
    private String mailVendedor;
    private Vendedor vendedor;
    private String mailComprador;
    private Comprador comprador;
    private long codEntrada;
    private Entrada entrada;
    private String fechaVenta;
    private int valorVenta;
    private String tipoTarjeta;
    private String nombreEnTarjeta;
    private int numeroTarjeta;
    private String fechaVencimiento;
    private int cvv;
    private String localidad;
    private String direccionFacturacion;
    private String codigoPostal;


    public Venta(long codventa, String mailVendedor, String mailComprador, long codEntrada, String fechaVenta, int valorVenta, String tipoTarjeta, String nombreEnTarjeta, int numeroTarjeta, String fechaVencimiento, int cvv, String localidad, String direccionFacturacion, String codigoPostal) {
        this.codventa = codventa;
        this.mailVendedor = mailVendedor;
        this.mailComprador = mailComprador;
        this.codEntrada = codEntrada;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.tipoTarjeta = tipoTarjeta;
        this.nombreEnTarjeta = nombreEnTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.localidad = localidad;
        this.direccionFacturacion = direccionFacturacion;
        this.codigoPostal = codigoPostal;
    }

    public Venta(long codventa, String mailVendedor, Vendedor vendedor, String mailComprador, Comprador comprador, long codEntrada, Entrada entrada, String fechaVenta, int valorVenta, String tipoTarjeta, String nombreEnTarjeta, int numeroTarjeta, String fechaVencimiento, int cvv, String localidad, String direccionFacturacion, String codigoPostal) {
        this.codventa = codventa;
        this.mailVendedor = mailVendedor;
        this.vendedor = vendedor;
        this.mailComprador = mailComprador;
        this.comprador = comprador;
        this.codEntrada = codEntrada;
        this.entrada = entrada;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
        this.tipoTarjeta = tipoTarjeta;
        this.nombreEnTarjeta = nombreEnTarjeta;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.localidad = localidad;
        this.direccionFacturacion = direccionFacturacion;
        this.codigoPostal = codigoPostal;
    }

    public Venta(long codventa, String mailVendedor, String mailComprador, long codEntrada, String fechaVenta, int valorVenta) {
        this.codventa = codventa;
        this.mailVendedor = mailVendedor;
        this.mailComprador = mailComprador;
        this.codEntrada = codEntrada;
        this.fechaVenta = fechaVenta;
        this.valorVenta = valorVenta;
    }

    public Venta() {
    }

    public String getNombreEspectaculo() throws DAOException {
        DAOEspectaculo daoEspectaculo = new DAOEspectaculo();
        DAOEntrada daoEntrada = new DAOEntrada();

        Entrada entrada = daoEntrada.buscar(codEntrada);
        Espectaculo espectaculo = daoEspectaculo.buscar(entrada.getCodEspectaculo());

        return espectaculo.getNombreEspectaculo();

    }

    public void guardarVenta(Venta venta) throws ServiceException {
        VentaService ventaService = new VentaService();
        ventaService.GuardarVenta(venta);
        JOptionPane.showMessageDialog(null, "Compra realizada con exito", "Información", JOptionPane.INFORMATION_MESSAGE);

    }

    public void cancelarVenta(Venta venta, Espectaculo espectaculo) throws ServiceException {
        EntradaService entradaService = new EntradaService();
        EspectaculoService espectaculoService = new EspectaculoService();

        entradaService.eliminarEntrada(venta.getCodEntrada());
        espectaculoService.modificarEspectaculo2(espectaculo);
        espectaculo.setCantEntradas(espectaculo.getCantEntradas()+1);


    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public long getCodventa() {
        return codventa;
    }

    public String getMailVendedor() {
        return mailVendedor;
    }

    public String getMailComprador() {
        return mailComprador;
    }

    public long getCodEntrada() {
        return codEntrada;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setCodventa(long codventa) {
        this.codventa = codventa;
    }

    public void setMailVendedor(String mailVendedor) {
        this.mailVendedor = mailVendedor;
    }

    public void setMailComprador(String mailComprador) {
        this.mailComprador = mailComprador;
    }

    public void setCodEntrada(long codEntrada) {
        this.codEntrada = codEntrada;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getNombreEnTarjeta() {
        return nombreEnTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public void setNombreEnTarjeta(String nombreEnTarjeta) {
        this.nombreEnTarjeta = nombreEnTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setDireccionFacturacion(String direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    public String toString2() {
        return "Venta{" +
                "codventa=" + codventa +
                ", mailVendedor='" + mailVendedor + '\'' +
                ", vendedor=" + vendedor +
                ", mailComprador='" + mailComprador + '\'' +
                ", comprador=" + comprador +
                ", codEntrada=" + codEntrada +
                ", entrada=" + entrada +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", valorVenta=" + valorVenta +
                ", tipoTarjeta='" + tipoTarjeta + '\'' +
                ", nombreEnTarjeta='" + nombreEnTarjeta + '\'' +
                ", numeroTarjeta=" + numeroTarjeta +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cvv=" + cvv +
                ", localidad='" + localidad + '\'' +
                ", direccionFacturacion='" + direccionFacturacion + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                '}';
    }

    @Override
    public String toString() {
        try {
            return getNombreEspectaculo() + " | vendido en: " + fechaVenta;
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
