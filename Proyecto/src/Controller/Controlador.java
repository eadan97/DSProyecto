package Controller;

/**
 *
 * @author Joaquin
 */
public class Controlador {
    private static Controlador instancia;
    private GestorImportacion gImportacion;
    private GestorActividad gActividad;
    private GestorAvance gAvance;
    private DTOProyecto DTOProyecto;
    private DTOActividad DTOActividad;
    private DTOAvance DTOAvance;
    
    public Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        gAvance = new GestorAvance();
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
        DTOAvance = new DTOAvance();
    }
  
    public static Controlador getInstance(){
        if(instancia==null){
            instancia = new Controlador();
        }
        return instancia;
    }    
    
    public void imprimirMensaje(){
        System.out.println("Mensaje prueba");
    }
    public void ImportarArchivo(String path){
        try{
            gImportacion.LeerArchivo(path);
        }
        catch(Exception e){
            // TODO: Reportar el error
        }  
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
    
    public void AdjuntarEvidencia(Object obj,int IdAvance){
        
        
    }

}
