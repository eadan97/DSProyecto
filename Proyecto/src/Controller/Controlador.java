package Controller;

/**
 *
 * @author Joaquin
 */
public class Controlador {
    private static Controlador singleton;
    private GestorImportacion gImportacion;
    private GestorActividad gActividad;
    private GestorAvance gAvance;
    private DTOProyecto DTOProyecto;
    private DTOActividad DTOActividad;
    private DTOAvance DTOAvance;
    
    private Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        gAvance = new GestorAvance();
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
        DTOAvance = new DTOAvance();
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
    
    public DTOAvance getDTOAvance(){
        return DTOAvance;
    }
    
    public void CrearActividad(){
        gActividad.CrearActividad(DTOActividad.getUnaActividad());
    }
    
    public void CrearAvance(){
        gAvance.CrearAvance(DTOAvance.getUnAvance());
    }

}
