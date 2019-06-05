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
        
        JSONArray tasks = (new JSONObject(jsonAsStr)).getJSONArray("data");
        // Iterator tasksIterator = tasks.iterator();
        for(int i = 0; i<tasks.length(); ++i){
 
                String idTarea = tasks.getJSONObject(i).getString("gid");
                String nombreTarea = tasks.getJSONObject(i).getString("name");

                String nota = tasks.getJSONObject(i).getString("notes");
                String idProyecto = tasks.getJSONObject(i).getJSONArray("projects").getJSONObject(0).getString("gid");
                String tareaPadre = tasks.getJSONObject(i).getJSONObject("parent").getString("gid");
                
                Date fechaCreacion = ParseDayFromJson(tasks.getJSONObject(i).getString("created_at")); 
                Date fechaCompletado = ParseDayFromJson(tasks.getJSONObject(i).getString("completed_at"));
                Date fechaUltimaModificacion = ParseDayFromJson(tasks.getJSONObject(i).getString("modified_at"));
                Date fechaInicio = ParseDayFromJson(tasks.getJSONObject(i).getString("due_on"));
                Date fechaFin = ParseDayFromJson(tasks.getJSONObject(i).getString("due_at"));  
                
                String etiqueta = "";
                JSONArray tags = tasks.getJSONObject(i).getJSONArray("tags");
                for (int j=0; i<tags.length(); ++i){
                    etiqueta+=tags.getString(j);
                    if(j< tags.length()-1)
                    etiqueta+=", ";
                }

                //Integer idUsuario = Integer.parseInt((String) ((JSONObject) tasks.getJSONObject(i).get("assignee")).get("gid"));
                int idUsuario = tasks.getJSONObject(i).getJSONObject("assignee").getInt("id");
                String nombreUsuario = tasks.getJSONObject(i).getJSONObject("assignee").getString("name");
                // String emailAsignado = null;
                SolicitarRegistroUsuario(idUsuario, nombreUsuario);
                  
                  
                  
                /*
                * Deberia registrar acá los followers a una tarea?
                */
                  
                
                
                
                
                // Entonces id usuario es integer o string? 
                
                LineaArchivo(idTarea, fechaCreacion, fechaCompletado, 
                        fechaUltimaModificacion, nombreTarea, String.valueOf(idUsuario),
                        fechaInicio, fechaFin, etiqueta,
                        nota, idProyecto, tareaPadre);
 

        }


    }
    
    // Este metodo no puede retornar una excepcion, todo esta dentro del try.
    private Date ParseDayFromJson(String str){
        try {
            return str==JSONObject.NULL?null: new SimpleDateFormat("yyyy-MM-dd").parse((str.split("T")[0]));
        } catch (ParseException ex) {
            System.out.println("No encotro fecha");
            Date dt = new Date ("Fri Apr 05 00:00:00 CST 2019"); //En base a que esta fecha, y porque aveces esta fecha y aveces null?
            return dt;
            //return null;
        }
    }
    
    
    public void SolicitarRegistroUsuario(int id, String nombre){
        Controlador ctrl = Controlador.getInstance();
        DTOUsuario dtoUsuario=ctrl.getDTOUsuario();
        dtoUsuario.getUnUsuario().setIdUsuario(id);
        dtoUsuario.getUnUsuario().setNombre(nombre);
        ctrl.CrearUsuario();
        // El correo no se puede obtener del json
              
    }
    
    public void LineaArchivo(String idTarea, Date fechaCreacion,
            Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea,
            String idUsuario,Date fechaInicio,Date fechaFin,
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
        // Que no hay emails en el json! Ctrl.getDTOActividad().getUnaActividad().setEmailAsignado(emailAsignado);
        Ctrl.getDTOActividad().getUnaActividad().setFechaInicio(fechaInicio);
        Ctrl.getDTOActividad().getUnaActividad().setFechaFin(fechaFin);
        Ctrl.getDTOActividad().getUnaActividad().setEtiqueta(etiqueta);
        Ctrl.getDTOActividad().getUnaActividad().setNota(nota);
        Ctrl.getDTOActividad().getUnaActividad().setIdProyecto(idProyecto);        
        Ctrl.getDTOActividad().getUnaActividad().setTareaPadre(tareaPadre);
        
        Ctrl.CrearActividad();        
    }    
}
