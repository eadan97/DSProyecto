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
import Controller.Controlador;

/**
 *
 * @author Joaquin
 */
public class GestorImportacion {

    private String filename;
    private String jsonAsStr;
    //SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM--dd");

    public void LeerArchivo(String filename) throws IOException, ParseException {
        this.filename = filename;
        jsonAsStr = new String(Files.readAllBytes(Paths.get(filename)));
        JSONArray tasks = (new JSONObject(jsonAsStr)).getJSONArray("data");
        for (int i = 0; i < tasks.length(); ++i) {
            JSONObject taskJsonObject = tasks.getJSONObject(i);
            parseJsonObject(taskJsonObject);
                  
        }
    }

    void parseJsonObject(JSONObject objetoTask){
        parseJsonObject(objetoTask, null);
    }
    
    void parseJsonObject(JSONObject objetoTask, String codigoAsigneePadre){
        String idTarea = (String) objetoTask.get("gid");
        Date fechaCreacion = ParseDayFromJson((String) objetoTask.get("created_at"));
        Date fechaCompletado;
        try {
            fechaCompletado = ParseDayFromJson((String) objetoTask.get("completed_at"));
        } catch (Exception e) {
            fechaCompletado = null;
        }
        Date fechaUltimaModificacion;
        try {
            fechaUltimaModificacion = ParseDayFromJson((String) objetoTask.get("modified_at"));
        } catch (Exception e) {
            fechaUltimaModificacion = null;
        }
        String nombreTarea = (String) objetoTask.get("name");
        
        Date fechaInicio;
        try {
            fechaInicio = ParseDayFromJson((String) objetoTask.get("due_on"));
        } catch (Exception e) {
            fechaInicio = null;
        }
        Date fechaFin;
        try {
            fechaFin = ParseDayFromJson((String) objetoTask.get("due_at"));
        } catch (Exception e) {
            fechaFin = null;
        }
        String etiqueta = "";
        JSONArray tags = (JSONArray) objetoTask.get("tags");
        for (int j = 0; j < tags.length(); ++j) {
            etiqueta += tags.getJSONObject(j).getString("name");
            if (j < tags.length() - 1) {
                etiqueta += ", ";
            }
        }
        String nota = (String) objetoTask.get("notes");
        String idProyecto;
        try{
          
            idProyecto = (String) ((JSONObject) ((JSONArray) objetoTask.get("projects")).get(0)).get("gid");
        }catch(Exception e){
            idProyecto=null;
        }
        
        String tareaPadre;
        try {
            tareaPadre = (String) ((JSONObject) objetoTask.get("parent")).get("gid");
        } catch (Exception e) {
            tareaPadre = null;
        }
        String emailAsignado;
        String CodigoUsuario;
        String nombreUsuario;

        try{
            CodigoUsuario = (String) ((JSONObject) objetoTask.get("assignee")).get("gid");
            nombreUsuario = objetoTask.getJSONObject("assignee").getString("name");
            SolicitarRegistroUsuario(CodigoUsuario, nombreUsuario);
        }catch(Exception e){
            CodigoUsuario=codigoAsigneePadre;
        }
        emailAsignado = null;
        
        
        
        


        LineaArchivo(idTarea, fechaCreacion, fechaCompletado,
                fechaUltimaModificacion, nombreTarea, CodigoUsuario,
                emailAsignado, fechaInicio, fechaFin, etiqueta,
                nota, idProyecto, tareaPadre);
        
        /**
         * Obtencion de las subtareas
         */
        try{
            JSONArray subtasks = objetoTask.getJSONArray("subtasks");
            for(int j =0; j<subtasks.length();++j){
                JSONObject subtask = subtasks.getJSONObject(j);
                parseJsonObject(subtask, CodigoUsuario);
            }
        }catch(Exception e){
        }
            
    }
    
    
    
    public void LineaArchivo(String idTarea, Date fechaCreacion,
            Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea,
            String idUsuario, String emailAsignado, Date fechaInicio, Date fechaFin,
            String etiqueta, String nota, String idProyecto, String tareaPadre) {

        Controlador Ctrl = Controlador.getInstance();

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

    // Este metodo no puede retornar una excepcion, todo esta dentro del try.
    private Date ParseDayFromJson(String str) {
        try {
            return str == JSONObject.NULL ? null : new SimpleDateFormat("yyyy-MM-dd").parse((str.split("T")[0]));
        } catch (ParseException ex) {
            System.out.println("No encotro fecha");
            Date dt = new Date("Fri Apr 05 00:00:00 CST 2019"); //En base a que esta fecha, y porque aveces esta fecha y aveces null?
            return dt;
            //return null;
        }
    }

    public void SolicitarRegistroUsuario(String codigoUsuario, String nombre) {
        Controlador Ctrl = Controlador.getInstance();
        Ctrl.getDTOUsuario().getUnUsuario().setCodigoUsuario(codigoUsuario);
        Ctrl.getDTOUsuario().getUnUsuario().setNombre(nombre);
        Ctrl.getDTOUsuario().getUnUsuario().setRolUsuario(2);
        Ctrl.getDTOUsuario().getUnUsuario().setCorreo(nombre+"@asacom.com");
        Ctrl.getDTOUsuario().getUnUsuario().setPassword("admin");
        Ctrl.CrearUsuario();
    }
}
