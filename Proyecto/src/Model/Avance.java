/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author curso
 */
public class Avance {
    private Integer idAvance;
    private Integer idActividad;
    private Date fechaAvance;
    private Integer horasDedicadas;
    private Integer tipoAvance;
    private Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "Avance{" + "idAvance=" + idAvance + ", fechaAvance=" + fechaAvance + ", horasDedicadas=" + horasDedicadas + ", descripcion=" + descripcion + '}';
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    private String descripcion;

    public Avance() {
    }

    public Integer getIdAvance() {
        return idAvance;
    }

    public void setIdAvance(Integer idAvance) {
        this.idAvance = idAvance;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Date getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(Date fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public Integer getHorasDedicadas() {
        return horasDedicadas;
    }

    public void setHorasDedicadas(Integer horasDedicadas) {
        this.horasDedicadas = horasDedicadas;
    }

    public Integer getTipoAvance() {
        return tipoAvance;
    }

    public void setTipoAvance(Integer tipoAvance) {
        this.tipoAvance = tipoAvance;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Avance(Integer idAvance, Integer idActividad, Date fechaAvance, Integer horasDedicadas, Integer tipoAvance, Integer idUsuario, String descripcion) {
        this.idAvance = idAvance;
        this.idActividad = idActividad;
        this.fechaAvance = fechaAvance;
        this.horasDedicadas = horasDedicadas;
        this.tipoAvance = tipoAvance;
        this.descripcion = descripcion;
        this.idUsuario=idUsuario;
    }

}
