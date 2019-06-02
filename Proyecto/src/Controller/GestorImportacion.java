 package Controller;

import java.util.Date;

/**
 *
 * @author Joaquin
 */
public class GestorImportacion {
    private String NombreArchivo;
    private Controlador Ctrl = Controlador.getInstance();
    
    public void LeerArchivo(String NombreArchivo){
        this.NombreArchivo = NombreArchivo;
        /*Procesar el archivo*/
        /*Enviar a LineaArchivo cada una de las líneas leídas*/
    }
    
    public void LineaArchivo(int idTarea, Date fechaCreacion,
            Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea,
            int idUsuario,String emailAsignado,Date fechaInicio,Date fechaFin,
            String etiqueta, String nota,int idProyecto, int tareaPadre){
        
        Ctrl.getDTOActividad().getUnaActividad().setIdTarea(idTarea);
        Ctrl.getDTOActividad().getUnaActividad().setFechaCreacion(fechaCreacion);
        Ctrl.getDTOActividad().getUnaActividad().setFechaCompletado(fechaCompletado);
        Ctrl.getDTOActividad().getUnaActividad().setFechaUltimaModificacion(fechaUltimaModificacion);
        Ctrl.getDTOActividad().getUnaActividad().setNombreTarea(nombreTarea);
        Ctrl.getDTOActividad().getUnaActividad().setIdUsuario(idUsuario);
        Ctrl.getDTOActividad().getUnaActividad().setEmailAsignado(emailAsignado);
        Ctrl.getDTOActividad().getUnaActividad().setFechaInicio(fechaInicio);
        Ctrl.getDTOActividad().getUnaActividad().setFechaFin(fechaFin);
        Ctrl.getDTOActividad().getUnaActividad().setEtiqueta(etiqueta);
        Ctrl.getDTOActividad().getUnaActividad().setNota(nota);
        Ctrl.getDTOActividad().getUnaActividad().setIdProyecto(idProyecto);        
        Ctrl.getDTOActividad().getUnaActividad().setTareaPadre(tareaPadre);
        
        Ctrl.CrearActividad();
        
    }    
}
