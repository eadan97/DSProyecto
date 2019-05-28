package Controller;

/**
 *
 * @author Joaquin
 */
public class Controlador {
    private static Controlador singleton;
    private GestorImportación gImportacion;
    private DTOProyecto DTOProyecto;
    
    private Controlador(){
        gImportacion = new GestorImportación();
        DTOProyecto = new DTOProyecto();
    }
    
    private synchronized static void setInstance(){
        if(singleton==null)
            singleton=new Controlador();
    }
    
    public static Controlador getInstance(){
        if(singleton==null) 
            setInstance();
        return singleton;
    }
    
    public void ImportarArchivo(String path){
        gImportacion.LeerArchivo(path);
    }
    
    public DTOProyecto getDTOProyecto() {
        return DTOProyecto;
    }
    
    
}
