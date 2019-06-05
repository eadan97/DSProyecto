 package Controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Joaquin
 */
public class GestorImportacion {
    private String filename;

    //private Controlador Ctrl = Controlador.getInstance();

    

    
    private String jsonAsStr;
    SimpleDateFormat myformat = new SimpleDateFormat ("yyyy-MM--dd");
//private ArrayList<Actividad> actividades;
    
    public void LeerArchivo(String filename)throws IOException, ParseException{
        this.filename = filename;

        jsonAsStr=new String(Files.readAllBytes(Paths.get(filename)));
        
        JSONArray tasks = (JSONArray) (new JSONObject(jsonAsStr)).get("data");
        // Iterator tasksIterator = tasks.iterator();
        for(int i = 0; i<tasks.length(); ++i){
 
                  String idTarea = (String) tasks.getJSONObject(i).get("gid");
                  Date fechaCreacion = ParseDayFromJson((String)tasks.getJSONObject(i).get("created_at")); 
                  Date fechaCompletado;
                  try{
                      fechaCompletado = ParseDayFromJson((String)tasks.getJSONObject(i).get("completed_at"));
                  }catch(Exception e){
                      fechaCompletado = null;
                  }
                  Date fechaUltimaModificacion;
                  try{
                      fechaUltimaModificacion = ParseDayFromJson((String)tasks.getJSONObject(i).get("modified_at"));
                  }catch(Exception e){
                      fechaUltimaModificacion = null;
                  }
                  String nombreTarea = (String) tasks.getJSONObject(i).get("name");
                  //Integer idUsuario                   = Integer.parseInt((String) ((JSONObject) tasks.getJSONObject(i).get("assignee")).get("gid"));
                  String idUsuario                   = (String) ((JSONObject) tasks.getJSONObject(i).get("assignee")).get("gid");
                  String emailAsignado            = null;
                  Date fechaInicio;
                  try{
                      fechaInicio=ParseDayFromJson((String)tasks.getJSONObject(i).get("due_on"));
                  }catch(Exception e){
                      fechaInicio = null;
                  }
                  Date fechaFin;
                  try{
                      fechaFin = ParseDayFromJson((String)tasks.getJSONObject(i).get("due_at"));
                  }catch(Exception e){
                      fechaFin = null;
                  }
                  String etiqueta = "";
                  JSONArray tags                  = (JSONArray) tasks.getJSONObject(i).get("tags");
                  for (int j=0; i<tags.length(); ++i){
                    etiqueta+=tags.get(j);
                    if(j< tags.length()-1)
                        etiqueta+=", ";
                  }
                
                  String nota = (String) tasks.getJSONObject(i).get("notes");
                  String idProyecto = (String) ((JSONObject) ((JSONArray)tasks.getJSONObject(i).get("projects")).get(0)).get("gid");
                  String tareaPadre ;
                  try{
                      tareaPadre = (String) ((JSONObject) tasks.getJSONObject(i).get("parent")).get("gid");
                  }catch(Exception e){
                      tareaPadre = null;
                  }
                
                LineaArchivo(idTarea, fechaCreacion, fechaCompletado, 
                        fechaUltimaModificacion, nombreTarea, idUsuario,
                        emailAsignado, fechaInicio, fechaFin, etiqueta,
                        nota, idProyecto, tareaPadre);
 

        }


    }
    
    private Date ParseDayFromJson(String str){
        try {
            return str==JSONObject.NULL?null: new SimpleDateFormat("yyyy-MM-dd").parse((str.split("T")[0]));
        } catch (ParseException ex) {
            System.out.println("No encotro fecha");
            Date dt = new Date ("Fri Apr 05 00:00:00 CST 2019");
           return dt;
        }
    }
    
    public void LineaArchivo(String idTarea, Date fechaCreacion,
            Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea,
            String idUsuario,String emailAsignado,Date fechaInicio,Date fechaFin,
            String etiqueta, String nota,String idProyecto, String tareaPadre){

        Controlador Ctrl = Controlador.getInstance();
//        System.out.println(idTarea);
//        System.out.println(fechaCreacion);
//        System.out.println(fechaCompletado);
//        System.out.println(fechaUltimaModificacion);
//        System.out.println(nombreTarea);
//        System.out.println(idUsuario);
//        System.out.println(emailAsignado);
//        System.out.println(fechaInicio);
//        System.out.println(fechaFin);
//        System.out.println(etiqueta);
//        System.out.println(nota);
//        System.out.println(idProyecto);
//        System.out.println(tareaPadre);
//        System.out.println("-----------------------------");

//        
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
