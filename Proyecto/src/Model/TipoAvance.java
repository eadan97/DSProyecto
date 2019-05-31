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
public class TipoAvance {
    private Integer idTipoAvance;
    private String nombre;

    public TipoAvance() {
    }

    public TipoAvance(Integer idTipoAvance, String nombre) {
        this.idTipoAvance = idTipoAvance;
        this.nombre = nombre;
    }

    public Integer getIdTipoAvance() {
        return idTipoAvance;
    }

    public void setIdTipoAvance(Integer idTipoAvance) {
        this.idTipoAvance = idTipoAvance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
