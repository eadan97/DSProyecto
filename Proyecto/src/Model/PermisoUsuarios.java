/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author curso
 */
public class PermisoUsuarios {
    private Integer idPermisoUsuario;
    private Integer idUsuario;
    private Integer idPermiso;

    public PermisoUsuarios() {
    }

    public PermisoUsuarios(Integer idPermisoUsuario, Integer idUsuario, Integer idPermiso) {
        this.idPermisoUsuario = idPermisoUsuario;
        this.idUsuario = idUsuario;
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermisoUsuario() {
        return idPermisoUsuario;
    }

    public void setIdPermisoUsuario(Integer idPermisoUsuario) {
        this.idPermisoUsuario = idPermisoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }
    
}
