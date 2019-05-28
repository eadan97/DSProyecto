 package Controller;

/**
 *
 * @author Joaquin
 */
public class GestorImportacion {
    private String NombreArchivo;
    private Controlador Ctrl = Controlador.getInstance();
    
    public void LeerArchivo(String NombreArchivo){
        this.NombreArchivo = NombreArchivo;
    }
    
    public void LineaArchivo(String TareaPadre){
        /*Aqui van todos los atributos*/
        Ctrl.getDTOActividad().getUnaActividad().setTareaPadre(TareaPadre);
        
    }    
}
