package Model;

import Controlador.Vendedor;

import java.sql.*;
import java.util.ArrayList;

public class DAOVendedor implements DAO<Vendedor> {

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:G:/sistemaEntradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";


    @Override
    public void guardar(Vendedor elemento) throws DAOException {
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
            preparedStatement.setBoolean(5,true);

            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Vendedor elemento) throws DAOException {

    }

    @Override
    public void eliminar(long id) throws DAOException {

    }

    @Override
    public Vendedor buscar(long id) throws DAOException {
        return null;
    }

    public Vendedor buscar2(String mail) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Vendedor vendedor=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM USUARIO  WHERE MAILUSUARIO=?");
            preparedStatement.setString(1,mail);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                vendedor = new Vendedor();
                vendedor.setNombreUsuario(resultSet.getString("NOMBREUSUARIO"));
                vendedor.setContraseña(resultSet.getString("CONTRASEÑA"));
                vendedor.setMailUsuario(mail);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return vendedor;
    }

    public boolean buscarEsVendedor(String mail) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean esVendedor = false;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT ES_VENDEDOR FROM USUARIO WHERE MAILUSUARIO=?");
            preparedStatement.setString(1, mail);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                esVendedor = resultSet.getBoolean("ES_VENDEDOR");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e.getMessage());
        }

        return esVendedor;
    }

    public ArrayList<Vendedor> buscarTodosVendedor() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Vendedor> datos = new ArrayList<>();
        Vendedor vendedor;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM USUARIO WHERE ES_VENDEDOR = TRUE;");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                vendedor = new Vendedor();
                vendedor.setMailUsuario(resultSet.getString("MAILUSUARIO"));
                vendedor.setNombreUsuario(resultSet.getString("NOMBREUSUARIO"));
                vendedor.setContraseña(resultSet.getString("CONTRASEÑA"));
                vendedor.setEsAdmin(resultSet.getBoolean("ES_ADMIN"));
                vendedor.setEsVendedor(resultSet.getBoolean("ES_VENDEDOR"));
                datos.add(vendedor);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }



    @Override
    public ArrayList buscarTodos() throws DAOException {
        return null;
    }
}
