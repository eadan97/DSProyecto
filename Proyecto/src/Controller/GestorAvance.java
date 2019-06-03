package Controller;

import Model.Avance;
import java.util.Date;

/**
 *
 * @author Joaquin
 */
public class GestorAvance {
    //private Controlador Ctrl = Controlador.getInstance();
    private  DAOAvance DAOAvan;
    
    public GestorAvance(){
        this.DAOAvan = new DAOAvance();
    }
    
    public boolean CrearAvance(Avance avance){
      return DAOAvan.Registrar(avance);
    }
}
