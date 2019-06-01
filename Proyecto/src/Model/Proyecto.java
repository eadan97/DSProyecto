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
public class Proyecto {
    private Integer codigoProyecto;
    private String nombreProyecto;

    public Proyecto() {
    }

    public Proyecto(Integer codigoProyecto, String nombreProyecto) {
        this.codigoProyecto = codigoProyecto;
        this.nombreProyecto = nombreProyecto;
    }

    public Integer getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(Integer codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    
}
