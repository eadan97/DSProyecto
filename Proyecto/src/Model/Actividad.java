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
    private int idTarea;
    private Date fechaCreacion;
    private Date fechaCompletado;
    private Date fechaUltimaModificacion;
    private String nombreTarea;
    private int idUsuario;
    private String emailAsignado;
    private Date fechaInicio;
    private Date fechaFin;
    private String etiqueta;
    private String nota;
    private int idProyecto;
    private int tareaPadre;

    public Actividad() {
    }

    public Actividad(int idTarea, Date fechaCreacion, Date fechaCompletado, Date fechaUltimaModificacion, String nombreTarea, int idUsuario, String emailAsignado, Date fechaInicio, Date fechaFin, String etiqueta, String nota, int idProyecto, int tareaPadre) {
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

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getTareaPadre() {
        return tareaPadre;
    }

    public void setTareaPadre(Integer tareaPadre) {
        this.tareaPadre = tareaPadre;
    }

}
