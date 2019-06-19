/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author eadan
 */
public class OpcionesReporte {
    public boolean responsable, idActividad, fecha, horasDedicadas, descripcion, correo;

    public OpcionesReporte(boolean responsable, boolean idActividad, boolean fecha, boolean horasDedicadas, boolean descripcion, boolean correo) {
        this.responsable = responsable;
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.horasDedicadas = horasDedicadas;
        this.descripcion = descripcion;
        this.correo = correo;
    }

    
    
    public boolean isResponsable() {
        return responsable;
    }

    public void setResponsable(boolean responsable) {
        this.responsable = responsable;
    }

    public boolean isIdActividad() {
        return idActividad;
    }

    public void setIdActividad(boolean idActividad) {
        this.idActividad = idActividad;
    }

    public boolean isFecha() {
        return fecha;
    }

    public void setFecha(boolean fecha) {
        this.fecha = fecha;
    }

    public boolean isHorasDedicadas() {
        return horasDedicadas;
    }

    public void setHorasDedicadas(boolean horasDedicadas) {
        this.horasDedicadas = horasDedicadas;
    }

    public boolean isDescripcion() {
        return descripcion;
    }

    public void setDescripcion(boolean descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCorreo() {
        return correo;
    }

    public void setCorreo(boolean correo) {
        this.correo = correo;
    }
    
    
    
}
