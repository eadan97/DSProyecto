package Controller;

import Model.Avance;

/**
 *
 * @author Joaquin
 */
public class DTOAvance {
     private Avance unAvance;
     
     public DTOAvance(){
         unAvance = new Avance();
     }
     
     public Avance getUnAvance(){
         return unAvance;
     }
     
     public void setUnAvance(Avance avance){
         this.unAvance = avance;
     }
     
    
}
