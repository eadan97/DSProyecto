/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Model.ConexionBD;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Joaquin
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        /*Simulador Agregar Actividades*/
        System.out.println("BIENVENIDO AL SISTEMA DE INTEGRACION");
        int userID = 1;
        modificarPerfilUsuario(userID);
        
    }
    public void menuInteligente(){
        System.out.println("Seleccione la operación que desea realizar");
        System.out.println("Importar un Nuevo Proyecto");
        System.out.println("Iniciar Sessión en Proyecto existente");
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
        user.setNombre("Maria");
        user.setCorreo("maria@gmail.com");
        //
        System.out.println(idUsuarioBD);
        System.out.println(nombre);
        System.out.println(correo);
//        
        //user.setCorreo("joaquinmena.84@gmail.com");
        conexion.insertarUsuario(user);
        System.out.println("Se agrego correctamente");  
        
        conexion.desconectar();
    }
    
}
