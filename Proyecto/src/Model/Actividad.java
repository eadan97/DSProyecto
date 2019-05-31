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
public class Actividad {
    private Integer idActividad;
    private Integer idTarea;
    private Date fechaCreacion;
    private Date fechaCompletado;
    private Date fechaUltimaModificacion;
    private String nombreTarea;
    private Integer idUsuario;
    private String emailAsignado;
    private Date fechaInicio;
    private Date fechaFin;
    private String etiqueta;
    private String nota;
    private Integer idProyecto;
    private Integer tareaPadre;

    public Actividad() {
    }

    public Actividad(Integer idActividad, Integer idTarea, Date fechaCreacion, Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea, Integer idUsuario, String emailAsignado, Date fechaInicio, Date fechaFin, String etiqueta, String nota, Integer idProyecto, Integer tareaPadre) {
        this.idActividad = idActividad;
        this.idTarea = idTarea;
        this.fechaCreacion = fechaCreacion;
        this.fechaCompletado = fechaCompletado;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.nombreTarea = nombreTarea;
        this.idUsuario = idUsuario;
        this.emailAsignado = emailAsignado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.etiqueta = etiqueta;
        this.nota = nota;
        this.idProyecto = idProyecto;
        this.tareaPadre = tareaPadre;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmailAsignado() {
        return emailAsignado;
    }

    public void setEmailAsignado(String emailAsignado) {
        this.emailAsignado = emailAsignado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Integer getTareaPadre() {
        return tareaPadre;
    }

    public void setTareaPadre(Integer tareaPadre) {
        this.tareaPadre = tareaPadre;
    }

}
