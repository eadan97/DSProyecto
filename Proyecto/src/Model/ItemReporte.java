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
 * @author eadan
 */
public class ItemReporte {
      
    Integer IdAvance;
    Integer IdActividad;
    Date FechaAvance;
    Integer HorasDedicadas;
    String TipoAvance;
    String Nombre;
    String Correo;
    String Descripcion;
    Integer IdEvidencia;
    byte[] Imagen;

    public ItemReporte(Integer IdAvance, Integer IdActividad, Date FechaAvance, Integer HorasDedicadas, String TipoAvance, String Nombre, String Correo, String Descripcion, Integer IdEvidencia, byte[] Imagen) {
        this.IdAvance = IdAvance;
        this.IdActividad = IdActividad;
        this.FechaAvance = FechaAvance;
        this.HorasDedicadas = HorasDedicadas;
        this.TipoAvance = TipoAvance;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Descripcion = Descripcion;
        this.IdEvidencia = IdEvidencia;
        this.Imagen = Imagen;
    }

    public Integer getIdAvance() {
        return IdAvance;
    }

    public void setIdAvance(Integer IdAvance) {
        this.IdAvance = IdAvance;
    }

    public Integer getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(Integer IdActividad) {
        this.IdActividad = IdActividad;
    }

    public Date getFechaAvance() {
        return FechaAvance;
    }

    public void setFechaAvance(Date FechaAvance) {
        this.FechaAvance = FechaAvance;
    }

    public Integer getHorasDedicadas() {
        return HorasDedicadas;
    }

    public void setHorasDedicadas(Integer HorasDedicadas) {
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

    public Integer getIdEvidencia() {
        return IdEvidencia;
    }

    public void setIdEvidencia(Integer IdEvidencia) {
        this.IdEvidencia = IdEvidencia;
    }

    public byte[] getImagen() {
        return Imagen;
    }

    public void setImagen(byte[] Imagen) {
        this.Imagen = Imagen;
    }
    
    
    
}
