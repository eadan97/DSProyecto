/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reporte;
import java.util.Date;

/**
 *
 * @author eadan
 */
public class DTOReporte {
    private int idUsuario;
    private String fechaInicio;
    //private Date fechaInicio;
    private String fechaFin;
    //private Date fechaFin;
    private int idActividad;
    private int tipoFomato;
    
    private Reporte unReporte;
    
    public int getTipoFomato() {
        return tipoFomato;
    }

    /**
     * 
     * @param tipoFomato 1 para pdf
     */
    public void setTipoFomato(int tipoFomato) {
        this.tipoFomato = tipoFomato;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public Reporte getUnReporte() {
        return unReporte;
    }

    public void setUnReporte(Reporte unReporte) {
        this.unReporte = unReporte;
    }
    
    
    
}
