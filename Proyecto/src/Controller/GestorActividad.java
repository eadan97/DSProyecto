package Controller;

import Model.Actividad;

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
    
    public void ConsultarActividad(int TaskId){
        
    }
}
