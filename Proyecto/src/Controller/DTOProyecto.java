package Controller;

import Model.Proyecto;

/**
 *
 * @author Joaquin
 */
public class DTOProyecto {
    
    private Proyecto unProyecto;
    
    public DTOProyecto(){
        unProyecto = new Proyecto();
    }
    
    public Proyecto getUnProyecto() {
        return unProyecto;
    }

    public void setUnProyecto(Proyecto unProyecto) {
        this.unProyecto = unProyecto;
    }
    
}
