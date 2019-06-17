/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aleta
 */
public class Reporte {

    private Date FechaSolicitudReporte;
    private int IdAvance;
    private int IdActividad;
    private String FechaAvance;
    private int HorasDedicadas;
    private String TipoAvance;
    private String Nombre;
    private String Correo;
    private String Descripcion;
    private ArrayList <Integer> IdEvidencia;
    private byte[] imagen;

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    public Date getFechaSolicitudReporte() {
        return FechaSolicitudReporte;
    }

    public void setFechaSolicitudReporte(Date FechaSolicitudReporte) {
        this.FechaSolicitudReporte = FechaSolicitudReporte;
    }

    public int getIdAvance() {
        return IdAvance;
    }

    public void setIdAvance(int IdAvance) {
        this.IdAvance = IdAvance;
    }

    public int getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

    public String getFechaAvance() {
        return FechaAvance;
    }

    public void setFechaAvance(String FechaAvance) {
        this.FechaAvance = FechaAvance;
    }

    public int getHorasDedicadas() {
        return HorasDedicadas;
    }

    public void setHorasDedicadas(int HorasDedicadas) {
        this.HorasDedicadas = HorasDedicadas;
    }

    public String getTipoAvance() {
        return TipoAvance;
    }

    public void setTipoAvance(String TipoAvance) {
        this.TipoAvance = TipoAvance;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public ArrayList<Integer> getIdEvidencia() {
        
        return IdEvidencia;
    }

    public void setIdEvidencia(ArrayList<Integer> IdEvidencia) {
        this.IdEvidencia = IdEvidencia;
    }
    public void addEvidencia (int E){
        this.IdEvidencia.add(E);
        
    }
    
    
   

    

}
