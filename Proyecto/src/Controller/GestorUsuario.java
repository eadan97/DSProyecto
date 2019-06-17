/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;

/**
 *
 * @author eadan
 */
class GestorUsuario {

    DAOUsuario daoUsr;
    
    public GestorUsuario() {
        daoUsr=new DAOUsuario();
    }

    
    public boolean CrearUsuario(Usuario unUsuario) {
        return daoUsr.Registrar(unUsuario);
    }
    
    public Usuario ObtenerUsusario(int id){
        return daoUsr.leerUsuario(id);
    }
    
    public int validarUsuario(Usuario unUsuario){
        return daoUsr.verificarUsuario(unUsuario);
    }
    
    public void ActualizarUsuario(Usuario unUsuario){
        daoUsr.actualizarUsuario(unUsuario);
    }
    
}
