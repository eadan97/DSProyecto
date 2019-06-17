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
  
    private int IdActividad;
    private String Nombre;
    private String Correo;
    
    
    
    private ArrayList <Avance> Avances;
    private ArrayList <Evidencia> Evidencia;
    

    public Date getFechaSolicitudReporte() {
        return FechaSolicitudReporte;
    }

    public void setFechaSolicitudReporte(Date FechaSolicitudReporte) {
        this.FechaSolicitudReporte = FechaSolicitudReporte;
    }



    public int getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
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



    

}
