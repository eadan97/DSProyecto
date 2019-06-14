package Controller;

import Model.Actividad;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class GestorActividad {
    private  DAOActividad DAOAct;
    
    public GestorActividad(){
        this.DAOAct = new DAOActividad();
    } 
    
    public boolean CrearActividad(Actividad actividad){
        return DAOAct.Registrar(actividad);
    }
    
    public ArrayList<Actividad> ConsultarActividadesUsuario(Integer userId) throws SQLException{
        return DAOAct.BuscarActividades(userId);
    }

    ArrayList<Actividad> ConsultarTodasLasActividades() {
        return DAOAct.BuscarActividades();
    }
}
