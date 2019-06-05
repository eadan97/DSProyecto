package Controller;

import Model.Evidencia;

/**
 *
 * @author Joaquin
 */
public class GestorEvidencia {
    
    private  DAOEvidencia DAOEvid;
    
    public GestorEvidencia(){
        this.DAOEvid = new DAOEvidencia();
    }
    
    public boolean CrearEvidencia(Evidencia evidencia){
      return DAOEvid.Registrar(evidencia);
    }
    
    
    
}
