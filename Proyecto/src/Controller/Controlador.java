package Controller;


import Model.Actividad;
import Model.Avance;
import Model.Evidencia;
import Model.Reporte;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author Joaquin
 */
public class Controlador {
    protected static Controlador instancia;
    protected GestorImportacion gImportacion;
    protected GestorActividad gActividad;
    protected GestorAvance gAvance;
    protected GestorEvidencia gEvidencia;
    protected GestorUsuario gUsuario;
    protected GestorReporte gReporte;
    protected DTOProyecto DTOProyecto;
    protected DTOActividad DTOActividad;
    protected DTOAvance DTOAvance;

    protected DTOEvidencia DTOEvidencia;
    protected DTOUsuario DTOUsuario;
    protected DTOReporte DTOReporte;

    
    public Controlador(){
        gImportacion = new GestorImportacion();
        gActividad = new GestorActividad(); 
        gAvance = new GestorAvance();
        gEvidencia = new GestorEvidencia();
        gUsuario = new GestorUsuario();
        gReporte = new GestorReporte();
        DTOProyecto = new DTOProyecto();
        DTOActividad = new DTOActividad();
        DTOAvance = new DTOAvance();
        DTOEvidencia = new DTOEvidencia();
        DTOUsuario = new DTOUsuario();
        DTOReporte = new DTOReporte();
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
    

    /*public boolean ExportarReporte(String S){
       
       IGenerador generador = null;
       switch(S){
           case "PDF":
               generador=new GeneradorPDF();
               break;
           default:           
               System.out.println("Reporte no soportado");
               return false;
       }
        
       gReporte.GenerarDocumento(generador, DTOReporte.getUnReporte());
       return true;
    }*/
    
    
    public boolean ExportarReporte(){
       
       IGenerador generador = new GeneradorPDF();
               
       gReporte.GenerarDocumento(generador, DTOReporte.getUnReporte());
       return true;
    }
    
    public void CrearReporte(String S) throws SQLException{

       switch(S){
           case "Usuario":
               gReporte.GenerarReporteMiembro();
               break;
           case "Actividad":
               gReporte.GenerarReporteActividad();
               break;
           case "Fechas":
                gReporte.GenerarReporteFecha();
               break;
               
           default:
               System.out.println("Reporte no soportado");
       }
        
    }
    
    public void CrearEvidencia(){
        gEvidencia.CrearEvidencia(DTOEvidencia.getUnaEvidencia());

    }
    
    public void AdjuntarEvidencia(Object obj,int IdAvance){              

    }
    
    public void VerEvidencia(Integer actividad){
        gAvance.VerAvance(actividad);
        //Todo: arreglar esto
    }
    

    public DTOUsuario getDTOUsuario() {
        return this.DTOUsuario;
    }
    public void setDTOUsuario(DTOUsuario newdto){
        this.DTOUsuario = newdto;                
    }

    public boolean CrearUsuario() {
        return gUsuario.CrearUsuario(DTOUsuario.getUnUsuario());
    }
    
    public void ActualizarUsuario(Usuario u){
        gUsuario.ActualizarUsuario(u);
    }

    public Usuario LeerUsuario(int idUsuario) {
        return gUsuario.ObtenerUsusario(idUsuario);
    }
    
    public int validarUsuario(){
        return gUsuario.validarUsuario(DTOUsuario.getUnUsuario());
    }
    
    public ArrayList<Actividad> ConsultarActividades(int idUsuario) throws SQLException{
        return gActividad.ConsultarActividadesUsuario(idUsuario);
    } 

    public ArrayList<Actividad> ConsultarActividades() {
        return gActividad.ConsultarTodasLasActividades();
    }
    public ArrayList<Avance> ConsultarAvancesActividad(int idActividad) throws SQLException{
        return gAvance.ObtenerAvancesActividad(idActividad);
    }

    public ArrayList<Evidencia> ConsultarEvidenciasAvance(Integer idAvance) throws SQLException{
        return gEvidencia.ObtenerEvidenciasAvance(idAvance);
    }
    
    public DTOReporte getDTOReporte() {
        return DTOReporte;
    }
}
