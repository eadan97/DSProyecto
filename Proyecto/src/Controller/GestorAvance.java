package Controller;

import Model.Avance;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void VerAvance(Integer actividad){
        System.out.println("antes de caer");
        //DAOAvan.BuscarAvancesEvidencias(actividad);
    }
    
    public ArrayList<Avance> ObtenerAvancesActividad(int idActividad) throws SQLException{
        return DAOAvan.BuscarAvancesActividad(idActividad);
        
    }

}
