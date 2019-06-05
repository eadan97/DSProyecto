/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Controller.Controlador;
import Controller.DAOActividad;
import Controller.GestorImportacion;
import Model.Actividad;
import Model.ConexionBD;
import Model.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Joaquin
 */
public class Proyecto {
    
    public static Controlador Ctrl = Controlador.getInstance();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException, ParseException {
        // TODO code application logic here
        //Controlador Ctrl = Controlador.getInstance();
        //ImportarProyecto();
        AgregarAvance();
       //AgregarEvidencia();
       
        
    }
    public void menuInteligente() throws IOException, ParseException{
        Ctrl.imprimirMensaje();
        System.out.println("Seleccione la operación que desea realizar");
        System.out.println("Importar un Nuevo Proyecto");
        System.out.println("Iniciar Sessión en Proyecto existente");
    }
    
    public static void ImportarProyecto() throws IOException, ParseException{
        System.out.println("Digite la ruta donde se encuentra el archivo JSON");
        String path = "";
        Scanner entradaScanner = new Scanner(System.in);
        path = entradaScanner.nextLine();
        //path = "../archivo.json";
        Ctrl.ImportarArchivo(path);        
    }
    
    public static void AgregarAvance(){
        Scanner entradaScanner;
        int act = 0;
        int horas = 0;
        int tipAvance = 0;
        String descrip = "";
        Date Fecha = new Date();
        java.sql.Date FechaMod = sqlDate(Fecha);
        
        System.out.println("Digite Numero de Actividad");
        entradaScanner = new Scanner(System.in);
        act = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite Numero de Horas dedicadas");
        entradaScanner = new Scanner(System.in);
        horas = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite tipo de Avance");
        entradaScanner = new Scanner(System.in);
        tipAvance = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite descripcion del avance Avance");
        entradaScanner = new Scanner(System.in);
        descrip = entradaScanner.nextLine();
        
        Ctrl.getDTOAvance().getUnAvance().setIdActividad(act);
        Ctrl.getDTOAvance().getUnAvance().setFechaAvance(FechaMod);
        Ctrl.getDTOAvance().getUnAvance().setHorasDedicadas(horas);
        Ctrl.getDTOAvance().getUnAvance().setTipoAvance(tipAvance);
        Ctrl.getDTOAvance().getUnAvance().setDescripcion(descrip);
        
        Ctrl.CrearAvance();
    }
    public static void AgregarEvidencia() throws IOException{
        Scanner entradaScanner;
        String pathImagen = "";
        int evd = 0;
        System.out.println("Digite path de la imagen");
        entradaScanner = new Scanner(System.in);
        pathImagen = entradaScanner.nextLine();
        //Image imagenExterna = new ImageIcon(pathImagen).getImage();
        BufferedImage bImage = ImageIO.read(new File(pathImagen));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        
        //
        System.out.println("Digite Numero de Avance");
        entradaScanner = new Scanner(System.in);
        evd = Integer.parseInt(entradaScanner.nextLine());
        //
        Ctrl.getDTOEvidencia().getUnaEvidencia().setIdAvance(evd);
        Ctrl.getDTOEvidencia().getUnaEvidencia().setImagen(data);
        
        Ctrl.CrearEvidencia();
    }
    
    
    public static void modificarPerfilUsuario(int idUsuario) throws SQLException{
        ConexionBD conexion =  ConexionBD.getInstance();
        Connection conn = conexion.getConexion();
        Usuario user = new Usuario();
        Usuario userL = Ctrl.LeerUsuario(idUsuario);
        int idUsuarioBD;
        String nombre;
        String correo;

        idUsuarioBD = userL.getIdUsuario();
        nombre = userL.getNombre();
        correo = userL.getCorreo();
//        
        user.setNombre("Pedro");
        user.setCorreo("pedro@gmail.com");
        //
        System.out.println(idUsuarioBD);
        System.out.println(nombre);
        System.out.println(correo);
//        
        user.setCorreo("joaquinmena.84@gmail.com");
        Ctrl.getDTOUsuario().setUnUsuario(user);
        Ctrl.CrearUsuario();
        System.out.println("Se agrego correctamente");  
        
        conexion.desconectar();
    }
    
    private static java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
    public void agregarActividad(){
        DAOActividad dao = new DAOActividad();
        Ctrl.imprimirMensaje();
        //ConexionBD conexion =  ConexionBD.getInstance();
        //Connection conn = conexion.getConexion();
//        Actividad act = new Actividad();
//        //act.setIdUsuario(1);
//        Date dt = new Date ("Fri Apr 05 00:00:00 CST 2019");
//        act.setFechaCreacion(dt);
//        act.setIdProyecto(1);
//        dao.Registrar(act);  
    }
  
}
