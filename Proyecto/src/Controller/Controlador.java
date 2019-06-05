package Controller;

import Model.BuilderActividad;
import Model.BuilderFecha;
import Model.BuilderMiembro;
import Model.DirectorReporte;
import Model.Reporte;


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
    private DirectorReporte DReporte;
    private BuilderFecha BFecha;
    private BuilderActividad BActvidad;
    private BuilderMiembro BMiembro;
    

    
    public Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        gAvance = new GestorAvance();
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
        DTOAvance = new DTOAvance();
        DReporte  = new DirectorReporte();
        
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
    

    public void CrearReporte(String S){
        System.out.println(S);
        
     //   DReporte.setBuilder(DReporte);
        //DReporte.prepararReporte();
       switch(S){
           case "Miembro":
               System.out.println(S+"addasd");
               DReporte.setBuilder(BMiembro);
               //DReporte.prepararReporte();
               break;
           case "Actividad":
               System.out.println("case actividad");
               DReporte.setBuilder(BActvidad);
               
               break;
           case "Fechas":
               DReporte.setBuilder(BFecha);
               
           default:
               System.out.println("Reporte no soportado");
       }
        
        DReporte.prepararReporte();
    }
    
    public void AdjuntarEvidencia(Object obj,int IdAvance){              

    }
    
    public void VerEvidencia(Integer actividad){
        gAvance.VerAvance(actividad);
    }
    

}
