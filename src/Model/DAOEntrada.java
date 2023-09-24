package Model;

import Controlador.Comprador;
import Controlador.Entrada;
import Controlador.Espectaculo;

import java.sql.*;
import java.util.ArrayList;

public class DAOEntrada implements DAO<Entrada> {

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/Compumax/Documents/GitHub/sistemaEntradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";

    @Override
    public void guardar(Entrada elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into ENTRADA Values(?,?,?,?,?,?,?)");
            preparedStatement.setLong(1, elemento.getCodEntrada());
            preparedStatement.setLong(2, elemento.getCodEspectaculo());
            preparedStatement.setLong(3, elemento.getCodEstadio());
            preparedStatement.setString(4, elemento.getFechaEntrada());
            preparedStatement.setInt(5,elemento.getPrecioEntrada());
            preparedStatement.setString(6,elemento.getMailUsuario());
            preparedStatement.setString(7,elemento.getUbicacion());

            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Entrada elemento) throws DAOException {

    }


    @Override
    public void eliminar(long id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM ENTRADA  WHERE CODENTRADA=?");

            preparedStatement.setLong(1,id);
            int res=preparedStatement.executeUpdate();
            System.out.println("Se elimino" + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public Entrada buscar(long id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Entrada entrada=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ENTRADA  WHERE CODENTRADA=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                entrada = new Entrada();
                entrada.setUbicacion(resultSet.getString("UBICACION"));
                entrada.setCodEspectaculo(resultSet.getLong("CODESPECTACULO"));
                entrada.setCodEstadio(resultSet.getLong("CODESTADIO"));
                entrada.setFechaEntrada(resultSet.getString("FECHAENTRADA"));
                entrada.setPrecioEntrada(resultSet.getInt("PRECIOENTRADA"));
                entrada.setMailUsuario(resultSet.getString("MAILUSUARIO"));
                entrada.setCodEntrada(id);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return entrada;
    }

    @Override
    public ArrayList buscarTodos() throws DAOException {
        return null;
    }

    public ArrayList<Entrada> buscarTodosUsuario(String mail) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Entrada> datos=new ArrayList<>();
        Entrada entrada;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ENTRADA  WHERE MAILUSUARIO=?");
            preparedStatement.setString(1,mail);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                entrada = new Entrada();
                entrada.setCodEntrada(resultSet.getLong("CODENTRADA"));
                entrada.setCodEspectaculo(resultSet.getLong("CODESPECTACULO"));
                entrada.setCodEstadio(resultSet.getLong("CODESTADIO"));
                entrada.setFechaEntrada(resultSet.getString("FECHAENTRADA"));
                entrada.setPrecioEntrada(resultSet.getInt("PRECIOENTRADA"));
                entrada.setMailUsuario(resultSet.getString("MAILUSUARIO"));
                entrada.setUbicacion(resultSet.getString("UBICACION"));
                datos.add(entrada);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }
}
