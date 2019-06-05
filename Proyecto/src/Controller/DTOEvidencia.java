package Controller;

import Model.Evidencia;

/**
 *
 * @author Joaquin
 */
public class DTOEvidencia {
    private Evidencia unaEvidencia;
    
    public DTOEvidencia(){
        unaEvidencia = new Evidencia();
    } 

    public Evidencia getUnaEvidencia() {
        return unaEvidencia;
    }

    public void setUnaEvidencia(Evidencia unaEvidencia) {
        this.unaEvidencia = unaEvidencia;
    }
    
    
}
