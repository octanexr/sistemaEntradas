package Model;

import Controlador.Comprador;
import Controlador.Comprador;
import Controlador.Entrada;
import Controlador.Espectaculo;

import java.util.ArrayList;
import java.sql.*;

public class DAOComprador implements DAO<Comprador> {

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/octir/OneDrive/Escritorio/Sistema de enradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";


    @Override
    public void guardar(Comprador elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into Usuario Values(?,?,?,?,?)");
            preparedStatement.setString(1, elemento.getNombreUsuario());
            preparedStatement.setString(2, elemento.getMailUsuario());
            preparedStatement.setString(3, elemento.getContraseña());
            preparedStatement.setBoolean(4,false);
            preparedStatement.setBoolean(5,false);

            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Comprador elemento) throws DAOException {

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("UPDATE Usuario SET nombre=?, constraseña=?, mail=? WHERE id=?");

            preparedStatement.setString(1, elemento.getNombreUsuario());
            preparedStatement.setString(2, elemento.getContraseña());
            preparedStatement.setString(3, elemento.getMailUsuario());
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
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("DELETE FROM USUARIO  WHERE IDUSUARIO=?");

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
    public Comprador buscar(long id) throws DAOException {
        return new Comprador();
    }

    public Comprador buscar2(String mail) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Comprador comprador=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM USUARIO  WHERE MAILUSUARIO=?");
            preparedStatement.setString(1,mail);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                comprador = new Comprador();
                comprador.setNombreUsuario(resultSet.getString("NOMBREUSUARIO"));
                comprador.setContraseña(resultSet.getString("CONTRASEÑA"));
                comprador.setMailUsuario(mail);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return comprador;
    }

    public boolean buscarEsAdmin(String mail) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean esAdmin = false;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT ES_ADMIN FROM USUARIO WHERE MAILUSUARIO=?");
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                esAdmin = resultSet.getBoolean("ES_ADMIN");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e.getMessage());
        }

        return esAdmin;
    }


    @Override
    public ArrayList buscarTodos() throws DAOException{

        return new ArrayList<>();
    }



}
