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

    /**
     * Funcion que se encarga de leer un archivo tipo json con el proyecto de Asana
     * @param filename ruta del archivo
     * @throws IOException
     * @throws ParseException 
     */
    public void LeerArchivo(String filename) throws IOException, ParseException {
        this.filename = filename;
        jsonAsStr = new String(Files.readAllBytes(Paths.get(filename)));
        JSONArray tasks = (new JSONObject(jsonAsStr)).getJSONArray("data");
        for (int i = 0; i < tasks.length(); ++i) {
            JSONObject taskJsonObject = tasks.getJSONObject(i);
            parseJsonObject(taskJsonObject);
                  
        }
    }

    /**
     * Funcion para parsear un JSONObject
     * @param objetoTask JSONObject a parsear
     */
    void parseJsonObject(JSONObject objetoTask){
        parseJsonObject(objetoTask, null);
    }
    
    /**
     * Funcion para parsear un JSONObject
     * @param objetoTask JSONObject a parsear
     * @param codigoAsigneePadre En caso de no encontrar un asignee, se le asigna este
     */
    void parseJsonObject(JSONObject objetoTask, String codigoAsigneePadre){
        String idTarea = objetoTask.getString("gid");
        String nombreTarea = objetoTask.getString("name");
        String nota =  objetoTask.getString("notes");
        String tareaPadre = tryGetStringFromChildrenJson(objetoTask, "parent", "gid");
        String emailAsignado = null;
        String CodigoUsuario = tryGetStringFromChildrenJson(objetoTask, "assignee", "gid");
        String nombreUsuario = tryGetStringFromChildrenJson(objetoTask, "assignee", "name");
        if (CodigoUsuario==null)
            CodigoUsuario=codigoAsigneePadre;
        else
            SolicitarRegistroUsuario(CodigoUsuario, nombreUsuario);
        
        Date fechaCreacion = ParseDayFromJson(tryGetStringFromJson(objetoTask, "created_at"));
        Date fechaCompletado = ParseDayFromJson(tryGetStringFromJson(objetoTask, "completed_at"));        
        Date fechaUltimaModificacion= ParseDayFromJson(tryGetStringFromJson(objetoTask, "modified_at"));        
        Date fechaInicio=ParseDayFromJson(tryGetStringFromJson(objetoTask, "due_on"));
        Date fechaFin=ParseDayFromJson(tryGetStringFromJson(objetoTask, "due_at"));

        /**
         * Lectura de las etiquetas
         */
        String etiqueta = "";
        JSONArray tags = objetoTask.getJSONArray("tags");
        for (int j = 0; j < tags.length(); ++j) {
            etiqueta += tags.getJSONObject(j).getString("name");
            if (j < tags.length() - 1) {
                etiqueta += ", ";
            }
        }
        
        /**
         * El id del proyecto es especial y no puede ser traido con trygetstringfromchild
         */
        String idProyecto;
        try{
          
            idProyecto = objetoTask.getJSONArray("projects").getJSONObject(0).getString("gid");
        }catch(Exception e){
            idProyecto=null;
        }
        
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
    
    /**
     * Trata de devolver un string en especifico de un JSONObject
     * @param jsonObject
     * @param string Clave del string a buscar
     * @return 
     */
    public String tryGetStringFromJson(JSONObject jsonObject, String string){
        try{
            return jsonObject.getString(string);
        }catch(Exception ex){
            return null;
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
            return str == JSONObject.NULL||str==null ? null : new SimpleDateFormat("yyyy-MM-dd").parse((str.split("T")[0]));
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


    private String tryGetStringFromChildrenJson(JSONObject objetoTask, String parent, String gid) {
        try{
            return objetoTask.getJSONObject(parent).getString(gid);
        }catch(Exception e){
            return null;
        }
                
    }
}
