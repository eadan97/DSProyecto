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
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

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
        ImportarProyecto();
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
        System.out.println("Seleccione la actividad");
        String act = "";
        Scanner entradaScanner = new Scanner(System.in);
    }
    
    public static void modificarPerfilUsuario(int idUsuario) throws SQLException{
        ConexionBD conexion =  ConexionBD.getInstance();
        Connection conn = conexion.getConexion();
        Usuario user = new Usuario();
        Usuario userL = conexion.leerUsuario(idUsuario);
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
        conexion.insertarUsuario(user);
        System.out.println("Se agrego correctamente");  
        
        conexion.desconectar();
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
