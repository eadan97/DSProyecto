/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import Model.ConexionBD;
import Model.Usuario;

/**
 *
 * @author Joaquin
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Simulador Agregar Actividades*/
        System.out.println("BIENVENIDO AL SISTEMA DE INTEGRACION");
        
        
    }
    public void menuInteligente(){
        System.out.println("Seleccione la operación que desea realizar");
        System.out.println("Importar un Nuevo Proyecto");
        System.out.println("Iniciar Sessión en Proyecto existente");
    }
    
    public static void modificarPerfilUsuario(int idUsuario){
        ConexionBD conn =  ConexionBD.getInstance();
        
        Usuario user = conn.leerUsuario(idUsuario);
        int idUsuarioBD;
        String nombre;
        String correo;
        //
        idUsuarioBD = user.getIdUsuario();
        nombre = user.getNombre();
        correo = user.getCorreo();
        //
        System.out.println(idUsuarioBD);
        System.out.println(nombre);
        System.out.println(correo);
        //
        user.setCorreo("joaquinmena.84@gmail.com");
        //
        conn.actualizarUsuario(user);
        System.out.println("Se actualizo correctamente");
        
    }
    
}
