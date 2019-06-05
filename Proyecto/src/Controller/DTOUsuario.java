package Controller;

import Model.Usuario;

/**
 *
 * @author Joaquin
 */
public class DTOUsuario {
     private Usuario unUsuario;
     
     public DTOUsuario(){
         unUsuario = new Usuario();
     }
     
     public Usuario getUnUsuario(){
         return unUsuario;
     }
     
     public void setUnUsuario(Usuario avance){
         this.unUsuario = avance;
     }
     
    
}
