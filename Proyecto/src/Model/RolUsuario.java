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
public class RolUsuario {
    private Integer idRolUsuario;
    private Integer idUsuario;
    private Integer idRol;

    public RolUsuario() {
    }

    public RolUsuario(Integer idRolUsuario, Integer idUsuario, Integer idRol) {
        this.idRolUsuario = idRolUsuario;
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    public Integer getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(Integer idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
}
