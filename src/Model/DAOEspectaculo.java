package Model;

import Controlador.Espectaculo;
import Controlador.Estadio;

import java.sql.*;
import java.util.ArrayList;

public class DAOEspectaculo implements DAO<Espectaculo> {

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:G:/sistemaEntradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";
    @Override
    public void guardar(Espectaculo elemento) throws DAOException {
        Estadio estadio;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Espectaculo Values(?,?,?,?,?,?,?)");
            preparedStatement.setLong(1,elemento.getCodEspectaculo());
            preparedStatement.setString(2, elemento.getNombreEspectaculo());
            preparedStatement.setInt(3, elemento.getCantEntradas());
            preparedStatement.setLong(4, elemento.getCodEstadio());
            preparedStatement.setString(6, elemento.getFechaEvento());
            preparedStatement.setInt(5, elemento.getPrecioEspectaculo());
            preparedStatement.setString(7,elemento.getMailVendedor());

            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }

        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Espectaculo elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE espectaculo SET cantentradas = cantentradas - 1 WHERE codespectaculo=?");

            preparedStatement.setLong(1, elemento.getCodEspectaculo());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }


    }

    public void modificar2(Espectaculo elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE espectaculo SET cantentradas = cantentradas + 1 WHERE codespectaculo=?");

            preparedStatement.setLong(1, elemento.getCodEspectaculo());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se modificaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }


    }

    @Override
    public void eliminar(long id) throws DAOException {

    }

    @Override
    public Espectaculo buscar(long id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Espectaculo espectaculo=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ESPECTACULO  WHERE CODESPECTACULO=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                espectaculo = new Espectaculo();
                espectaculo.setNombreEspectaculo(resultSet.getString("NOMBREESPECTACULO"));
                espectaculo.setCantEntradas(resultSet.getInt("CANTENTRADAS"));
                espectaculo.setCodEstadio(resultSet.getLong("CODESTADIO"));
                espectaculo.setFechaEvento(resultSet.getString("FECHAESPECTACULO"));
                espectaculo.setPrecioEspectaculo(resultSet.getInt("PRECIOESPECTAULO"));
                espectaculo.setMailVendedor(resultSet.getString("MAILVENDEDOR"));
                espectaculo.setCodEspectaculo(id);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return espectaculo;
    }



    @Override
    public ArrayList<Espectaculo> buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Espectaculo> datos=new ArrayList<>();
        Espectaculo espectaculo;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ESPECTACULO");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                espectaculo = new Espectaculo();
                espectaculo.setNombreEspectaculo(resultSet.getString("NOMBREESPECTACULO"));
                espectaculo.setCantEntradas(resultSet.getInt("CANTENTRADAS"));
                espectaculo.setFechaEvento(resultSet.getString("FECHAESPECTACULO"));
                espectaculo.setPrecioEspectaculo(resultSet.getInt("PRECIOESPECTAULO"));
                espectaculo.setCodEstadio(resultSet.getInt("CODESTADIO"));
                espectaculo.setCodEspectaculo(resultSet.getLong("CODESPECTACULO"));
                espectaculo.setMailVendedor(resultSet.getString("MAILVENDEDOR"));
                datos.add(espectaculo);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }

    public ArrayList<Espectaculo> buscarTodosPorVemdedor(String nombre) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Espectaculo> datos=new ArrayList<>();
        Espectaculo espectaculo;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ESPECTACULO WHERE MAILVENDEDOR=?");
            preparedStatement.setString(1,nombre);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                espectaculo = new Espectaculo();
                espectaculo.setNombreEspectaculo(resultSet.getString("NOMBREESPECTACULO"));
                espectaculo.setCantEntradas(resultSet.getInt("CANTENTRADAS"));
                espectaculo.setFechaEvento(resultSet.getString("FECHAESPECTACULO"));
                espectaculo.setPrecioEspectaculo(resultSet.getInt("PRECIOESPECTAULO"));
                espectaculo.setCodEstadio(resultSet.getInt("CODESTADIO"));
                espectaculo.setCodEspectaculo(resultSet.getLong("CODESPECTACULO"));
                espectaculo.setMailVendedor(resultSet.getString("MAILVENDEDOR"));
                datos.add(espectaculo);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }
}
