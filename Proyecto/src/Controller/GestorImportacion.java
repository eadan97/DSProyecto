 package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Joaquin
 */
public class GestorImportacion {
    private String filename;
    private Controlador Ctrl = Controlador.getInstance();
    
    private String jsonAsStr;
    //private ArrayList<Actividad> actividades;
    
    public void LeerArchivo(String filename)throws IOException{
        this.filename = filename;

        jsonAsStr=new String(Files.readAllBytes(Paths.get(filename)));
        
        JSONArray tasks = (JSONArray) (new JSONObject(jsonAsStr)).get("data");
        // Iterator tasksIterator = tasks.iterator();
        for(int i = 0; i<tasks.length(); ++i){
 
                //int idActividadad               = i;
                int idTarea                     = Integer.parseInt((String) tasks.getJSONObject(i).get("gid"));
                Date fechaCreacion              = ParseDayFromJson((String)tasks.getJSONObject(i).get("created_at"));
                Date fechaCompletado            = ParseDayFromJson((String)tasks.getJSONObject(i).get("completed_at"));
                Date fechaUltimaModificacion    = ParseDayFromJson((String)tasks.getJSONObject(i).get("due_on"));
                String nombreTarea              = (String) tasks.getJSONObject(i).get("name");
                int idUsuario                   = Integer.parseInt((String) ((JSONObject) tasks.getJSONObject(i).get("assignee")).get("gid"));
                String emailAsignado            = null;
                Date fechaInicio                = ParseDayFromJson((String)tasks.getJSONObject(i).get("start_on"));
                Date fechaFin                   = ParseDayFromJson((String)tasks.getJSONObject(i).get("modified_at"));
                String etiqueta                 = "";
                JSONArray tags                  = (JSONArray) tasks.getJSONObject(i).get("tags");
                for (int j=0; i<tags.length(); ++i){
                    etiqueta+=tags.get(j);
                    if(j< tags.length()-1)
                        etiqueta+=", ";
                }
                
                String nota                     = (String) tasks.getJSONObject(i).get("notes");
                int idProyecto                  = Integer.parseInt((String) ((JSONObject) ((JSONArray)tasks.getJSONObject(i).get("projects")).get(0)).get("gid"));
                int tareaPadre                  = Integer.parseInt((String) ((JSONObject) tasks.getJSONObject(i).get("parent")).get("gid")); // Creo que las secciones no tienen padre. tengo que revisar
                
                
                LineaArchivo(idTarea, fechaCreacion, fechaCompletado, fechaUltimaModificacion, nombreTarea, idUsuario, emailAsignado, fechaInicio, fechaFin, etiqueta, nota, idProyecto, tareaPadre);
                /*
                System.out.println("TaskID: "+tasks.getJSONObject(i).get("gid"));
                System.out.println("Nombre: "+tasks.getJSONObject(i).get("name"));
                System.out.println("Fecha creado: "+tasks.getJSONObject(i).get("created_at"));
                System.out.println("Completado?: "+tasks.getJSONObject(i).get("completed"));
                System.out.println("Fecha completado: "+tasks.getJSONObject(i).get("completed_at"));
                System.out.println("Ultima modificacion: "+tasks.getJSONObject(i).get("modified_at"));
                System.err.println("Asignado a:");
                System.out.println("\t ID: "+((JSONObject) tasks.getJSONObject(i).get("assignee")).get("gid"));
                System.out.println("\t Nombre: "+((JSONObject) tasks.getJSONObject(i).get("assignee")).get("name"));
                System.out.println("\t Email: ERROR");//+tasks.getJSONObject(i).get("name"));
                System.out.println("Fecha inicio: "+tasks.getJSONObject(i).get("name"));
                System.out.println("Fecha fin: "+tasks.getJSONObject(i).get("name"));
                System.out.println("Etiquetas: "+tasks.getJSONObject(i).get("name"));
                System.out.println("Notas: "+tasks.getJSONObject(i).get("name"));
                System.out.println("Proyectos: ???");//+tasks.getJSONObject(i).get("name"));
                System.out.println("Tarea padre: "+tasks.getJSONObject(i).get("name"));
                System.err.println("--------------------------------------------");
                System.out.println("Fecha completado: "+((tasks.getJSONObject(i).get("completed_at")) == JSONObject.NULL));*/
            

        }


    }
    
    private Date ParseDayFromJson(String str){
        try {
            return str==JSONObject.NULL?null: new SimpleDateFormat("yyyy-MM-dd").parse((str.split("T")[0]));
        } catch (ParseException ex) {
           // TODO: Error parseando algun dia;
           return null;
        }
    }
    
    public void LineaArchivo(int idTarea, Date fechaCreacion,
            Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea,
            int idUsuario,String emailAsignado,Date fechaInicio,Date fechaFin,
            String etiqueta, String nota,int idProyecto, int tareaPadre){
        
        //Ctrl.getDTOActividad().getUnaActividad().setIdActividad(idActividadad);
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
