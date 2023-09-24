package Model;
import Controlador.Estadio;
import java.sql.*;
import java.util.ArrayList;

public class DAOEstadio implements DAO<Estadio>{

    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:C:/Users/Compumax/Documents/GitHub/sistemaEntradas/base/baseEntradas";
    private String DB_USER="sa";
    private String DB_PASSWORD="";

    @Override
    public void guardar(Estadio elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("INSERT into ESTADIO Values(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setLong(1,elemento.getCodEstadio());
            preparedStatement.setString(2, elemento.getNombreEstadio());
            preparedStatement.setInt(3,elemento.getCapacidadMaxima());
            preparedStatement.setInt(4,elemento.getCantCampo());
            preparedStatement.setInt(5,elemento.getCantPlatea());
            preparedStatement.setInt(6,elemento.getCantVip());
            preparedStatement.setInt(7,elemento.getPrecioPlatea());
            preparedStatement.setInt(8,elemento.getPrecioCampo());
            preparedStatement.setInt(9,elemento.getPrecioVip());
            preparedStatement.setBytes(10,elemento.getBytesImagen());
            int res=preparedStatement.executeUpdate();
            System.out.println("Se agregaron " + res);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
    }

    @Override
    public void modificar(Estadio elemento) throws DAOException {

    }

    @Override
    public void eliminar(long id) throws DAOException {

    }

    @Override
    public Estadio buscar(long id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Estadio estadio=null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ESTADIO  WHERE CODESTADIO=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                estadio = new Estadio();
                estadio.setNombreEstadio(resultSet.getString("NOMBREESTADIO"));
                estadio.setCapacidadMaxima(resultSet.getInt("CAPACIDADMAXIMA"));
                estadio.setCantPlatea(resultSet.getInt("CANTPLATEA"));
                estadio.setCantCampo(resultSet.getInt("CANTCAMPO"));
                estadio.setCantVip(resultSet.getInt("CANTVIP"));
                estadio.setPrecioPlatea(resultSet.getInt("PRECIOPLATEA"));
                estadio.setPrecioCampo(resultSet.getInt("PRECIOCAMPO"));
                estadio.setPrecioVip(resultSet.getInt("PRECIOVIP"));
                estadio.setBytesImagen(resultSet.getBytes("IMAGENESTADIO"));
                estadio.setCodEstadio(id);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return estadio;
    }

    public byte[] buscarImagenEstadio(long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        byte[] imagenesBytes = new byte[0];
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("SELECT IMAGENESTADIO FROM ESTADIO WHERE CODESTADIO = ?");
            preparedStatement.setLong(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                imagenesBytes = rs.getBytes("IMAGENESTADIO");
            }

        } catch (ClassNotFoundException|SQLException e){
            throw new DAOException(e.getMessage());
        }

        return imagenesBytes;
    }

    public void subirImagenEstadio(long id,byte[] imagenBytes) throws DAOException{
        Connection connection =null;
        PreparedStatement preparedStatement=null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement = connection.prepareStatement("UPDATE ESTADIO SET IMAGENESTADIO = ? WHERE CODESTADIO = ?");
            preparedStatement.setBytes(1,imagenBytes);
            preparedStatement.setLong(2,id);
            preparedStatement.executeUpdate();
        }catch (ClassNotFoundException|SQLException e){
            throw new DAOException(e.getMessage());
        }

    }


    @Override
    public ArrayList<Estadio> buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Estadio> datos=new ArrayList<>();
        Estadio estadio;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            preparedStatement=connection.prepareStatement("SELECT * FROM ESTADIO");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {

                estadio = new Estadio();
                estadio.setCodEstadio(resultSet.getLong("CODESTADIO"));
                estadio.setNombreEstadio(resultSet.getString("NOMBREESTADIO"));
                estadio.setCapacidadMaxima(resultSet.getInt("CAPACIDADMAXIMA"));
                estadio.setCantPlatea(resultSet.getInt("CANTPLATEA"));
                estadio.setCantCampo(resultSet.getInt("CANTCAMPO"));
                estadio.setCantVip(resultSet.getInt("CANTVIP"));
                estadio.setPrecioPlatea(resultSet.getInt("PRECIOPLATEA"));
                estadio.setPrecioCampo(resultSet.getInt("PRECIOCAMPO"));
                estadio.setPrecioVip(resultSet.getInt("PRECIOVIP"));
                estadio.setBytesImagen(resultSet.getBytes("IMAGENESTADIO"));
                datos.add(estadio);
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw  new DAOException(e.getMessage());
        }
        return datos;
    }


}
