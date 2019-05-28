package Controller;

import Model.Actividad;

/**
 *
 * @author Joaquin
 */
public class DTOActividad {
    private Actividad unaActividad;
    
    
    public DTOActividad(){
        unaActividad = new Actividad();
    }
    
   public Actividad getUnaActivida() {
        return unaActividad;
    }

    public void setUnaActividad(Actividad unaActividad) {
        this.unaActividad = unaActividad;
    }
     
}
