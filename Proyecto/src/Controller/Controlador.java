package Controller;


import Model.BuilderActividad;
import Model.BuilderFecha;
import Model.BuilderMiembro;
import Model.DirectorReporte;
import Model.Reporte;
import Model.Usuario;


/**
 *
 * @author Joaquin
 */
public class Controlador {
    private static Controlador instancia;
    private GestorImportacion gImportacion;
    private GestorActividad gActividad;
    private GestorAvance gAvance;
    private GestorEvidencia gEvidencia;
    private GestorUsuario gUsuario;
    private DTOProyecto DTOProyecto;
    private DTOActividad DTOActividad;
    private DTOAvance DTOAvance;
    private DirectorReporte DReporte;
    private BuilderFecha BFecha;
    private BuilderActividad BActvidad;
    private BuilderMiembro BMiembro;
    private DTOEvidencia DTOEvidencia;
    private DTOUsuario DTOUsuario;

    
    public Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        gAvance = new GestorAvance();
        gEvidencia = new GestorEvidencia();
        gUsuario = new GestorUsuario();
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
        DTOAvance = new DTOAvance();
        DReporte  = new DirectorReporte();
        DTOEvidencia = new DTOEvidencia();
        DTOUsuario = new DTOUsuario();
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

    public DTOEvidencia getDTOEvidencia() {
        return DTOEvidencia;
    }

    public void setDTOEvidencia(DTOEvidencia DTOEvidencia) {
        this.DTOEvidencia = DTOEvidencia;
    }
    
    public void CrearActividad(){
        gActividad.CrearActividad(DTOActividad.getUnaActividad());
    }
    
    public void CrearAvance(){
        gAvance.CrearAvance(DTOAvance.getUnAvance());
    }
    

    public void CrearReporte(String S){

       switch(S){
           case "Miembro":
               BMiembro = new BuilderMiembro();
               DReporte.setBuilder(BMiembro);
               break;
           case "Actividad":
               BActvidad = new BuilderActividad();
               DReporte.setBuilder(BActvidad);
               break;
           case "Fechas":
               BFecha = new BuilderFecha();
               DReporte.setBuilder(BFecha);
               break;
               
           default:
               System.out.println("Reporte no soportado");
       }
        
       DReporte.prepararReporte();
    }
    
    public void CrearEvidencia(){
        gEvidencia.CrearEvidencia(DTOEvidencia.getUnaEvidencia());

    }
    
    public void AdjuntarEvidencia(Object obj,int IdAvance){              

    }
    
    public void VerEvidencia(Integer actividad){
        gAvance.VerAvance(actividad);
    }
    

    public DTOUsuario getDTOUsuario() {
        return this.DTOUsuario;
    }
    public void setDTOUsuario(DTOUsuario newdto){
        this.DTOUsuario = newdto;                
    }

    public void CrearUsuario() {
        gUsuario.CrearUsuario(DTOUsuario.getUnUsuario());
    }

    public Usuario LeerUsuario(int idUsuario) {
        return gUsuario.ObtenerUsusario(idUsuario);
    }
}
