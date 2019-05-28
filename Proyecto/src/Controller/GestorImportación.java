package Controller;

/**
 *
 * @author Joaquin
 */
public class GestorImportación {
    private String NombreArchivo;
    private Controlador Ctrl = Controlador.getInstance();
    
    public void LeerArchivo(String NombreArchivo){
        this.NombreArchivo = NombreArchivo;
    }
    
    public void LineaArchivo(){
    }    
}
