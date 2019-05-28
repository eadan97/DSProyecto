package Controller;

/**
 *
 * @author Joaquin
 */
public class Controlador {
    private static Controlador singleton;
    private GestorImportacion gImportacion;
    private GestorActividad gActividad;
    private DTOProyecto DTOProyecto;
    private DTOActividad DTOActividad;
    
    private Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
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
    
    public DTOActividad getDTOActividad(){
        return DTOActividad;
    }
    
    public void CrearActividad(){
        gActividad.CrearActividad(DTOActividad.getUnaActividad());
    }
    
    
}
