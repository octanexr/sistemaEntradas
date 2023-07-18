package service;

import Controlador.Venta;
import Model.DAOException;
import Model.DAOVenta;

import java.util.ArrayList;

public class VentaService {

    private DAOVenta daoVenta;

    public VentaService(){
        daoVenta = new DAOVenta();
    }

    public void GuardarVenta(Venta venta) throws ServiceException{
        try {
            daoVenta.guardar(venta);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Venta> buscarTodosUsuarioVenta(String mail) throws ServiceException{
        try {
            return daoVenta.buscarTodosUsuario(mail);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public ArrayList<Venta> buscarTodosVentaPorFecha(String fecha1,String fecha2,Long codEspectaculo) throws ServiceException{
        try{
            return daoVenta.buscarTodosPorFecha(fecha1, fecha2,codEspectaculo);
        }catch (DAOException e){
            throw new ServiceException(e.getMessage());
        }

    }

}
