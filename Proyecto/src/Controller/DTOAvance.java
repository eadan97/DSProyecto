package Controller;

import Model.Avance;
import java.util.ArrayList;

/**
 *
 * @author Joaquin
 */
public class DTOAvance {
     private Avance unAvance;
     private ArrayList<Avance> avances;
     
     public DTOAvance(){
         unAvance = new Avance();
         avances = new ArrayList<>();
     }
     
     public Avance getUnAvance(){
         return unAvance;
     }
     
     public void setUnAvance(Avance avance){
         this.unAvance = avance;
     }
     
    
}
