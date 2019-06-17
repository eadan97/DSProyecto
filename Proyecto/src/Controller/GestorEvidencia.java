package Controller;

import Model.Evidencia;
import java.sql.SQLException;
import java.util.ArrayList;

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

    ArrayList<Evidencia> ObtenerEvidenciasAvance(Integer idAvance)throws SQLException {
        return DAOEvid.BuscarEvidenciaAvance(idAvance);
    }
    
    
    
}
