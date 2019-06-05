package Controller;

import Model.Actividad;
import java.sql.SQLException;

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
    
    public void ConsultarActividad(Integer TaskId) throws SQLException{
        DAOAct.BuscarActividades(TaskId);
    }
}
