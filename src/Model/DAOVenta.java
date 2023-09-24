package Model;

import Controlador.Entrada;
import Controlador.Estadio;
import Controlador.Vendedor;
import Controlador.Venta;

import java.sql.*;
import java.util.ArrayList;

public class DAOVenta implements DAO<Venta> {

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/Compumax/Documents/GitHub/sistemaEntradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";

    @Override
    public void guardar(Venta elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into VENTA Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,elemento.getMailVendedor());
            preparedStatement.setString(2, elemento.getMailComprador());
            preparedStatement.setLong(3, elemento.getCodEntrada());
            preparedStatement.setInt(4,elemento.getValorVenta());
            preparedStatement.setLong(5,elemento.getCodventa());
            preparedStatement.setString(6,elemento.getFechaVenta());
            preparedStatement.setString(7,elemento.getTipoTarjeta());
            preparedStatement.setString(8,elemento.getNombreEnTarjeta());
            preparedStatement.setInt(9,elemento.getNumeroTarjeta());
            preparedStatement.setString(14,elemento.getFechaVencimiento());
            preparedStatement.setInt(10,elemento.getCvv());
            preparedStatement.setString(11,elemento.getLocalidad());
            preparedStatement.setString(12,elemento.getDireccionFacturacion());
            preparedStatement.setString(13,elemento.getCodigoPostal());

            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Venta elemento) throws DAOException {

    }

    @Override
    public void eliminar(long id) throws DAOException {

    }

    @Override
    public Venta buscar(long id) throws DAOException {
        return null;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {
        return null;
    }

    public ArrayList<Venta> buscarTodosUsuario(String mail) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Venta> datos=new ArrayList<>();
        Venta venta;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM VENTA WHERE MAILVENDEDOR=?");
            preparedStatement.setString(1,mail);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                venta = new Venta();
                venta.setMailVendedor(resultSet.getString("MAILVENDEDOR"));
                venta.setMailComprador(resultSet.getString("MAILCOMPRADOR"));
                venta.setCodEntrada(resultSet.getLong("CODENTRADA"));
                venta.setValorVenta(resultSet.getInt("VALORVENTA"));
                venta.setCodventa(resultSet.getLong("CODVENTA"));
                venta.setFechaVenta(resultSet.getString("FECHAVENTA"));
                venta.setTipoTarjeta(resultSet.getString("METODOPAGO"));
                venta.setNombreEnTarjeta(resultSet.getString("NOMBREENTARJETA"));
                venta.setNumeroTarjeta(resultSet.getInt("NUMEROTARJETA"));
                venta.setFechaVenta(resultSet.getString("FECHAVENCIMIENTO"));
                venta.setCvv(resultSet.getInt("CVV"));
                venta.setLocalidad(resultSet.getString("LOCALIDAD"));
                venta.setDireccionFacturacion("DIRECCIONFACTURAMIENTO");
                venta.setCodigoPostal(resultSet.getString("CODIGOPOSTAL"));
                datos.add(venta);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }

    public ArrayList<Venta> buscarTodosPorFecha(String fecha1, String fecha2, Long codEspectaculo) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Venta> datos=new ArrayList<>();
        Venta venta;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT V.* FROM VENTA V JOIN ENTRADA E ON V.CODENTRADA = E.CODENTRADA WHERE V.FECHAVENTA >=? AND V.FECHAVENTA <=? AND E.CODESPECTACULO =?");
            preparedStatement.setString(1,fecha1);
            preparedStatement.setString(2,fecha2);
            preparedStatement.setLong(3,codEspectaculo);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                venta = new Venta();
                venta.setMailVendedor(resultSet.getString("MAILVENDEDOR"));
                venta.setMailComprador(resultSet.getString("MAILCOMPRADOR"));
                venta.setCodEntrada(resultSet.getLong("CODENTRADA"));
                venta.setValorVenta(resultSet.getInt("VALORVENTA"));
                venta.setCodventa(resultSet.getLong("CODVENTA"));
                venta.setFechaVenta(resultSet.getString("FECHAVENTA"));
                datos.add(venta);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }
}
