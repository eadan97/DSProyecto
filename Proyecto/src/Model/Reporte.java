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
<<<<<<< HEAD
  
    private int IdActividad;
    private String Nombre;
    private String Correo;
    
    
    
    private ArrayList <Avance> Avances;
    private ArrayList <Evidencia> Evidencia;
    
=======
    private int IdActividad;
    private String Nombre;
    private String Correo;
    private ArrayList <Avance> avances;
    private ArrayList <Evidencia> evidencias;
>>>>>>> 83172b2725e666019ff1f987f0db203fc9d00527

    public Date getFechaSolicitudReporte() {
        return FechaSolicitudReporte;
    }

    public void setFechaSolicitudReporte(Date FechaSolicitudReporte) {
        this.FechaSolicitudReporte = FechaSolicitudReporte;
    }

<<<<<<< HEAD


=======
>>>>>>> 83172b2725e666019ff1f987f0db203fc9d00527
    public int getIdActividad() {
        return IdActividad;
    }

    public void setIdActividad(int IdActividad) {
        this.IdActividad = IdActividad;
    }

<<<<<<< HEAD

=======
>>>>>>> 83172b2725e666019ff1f987f0db203fc9d00527
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

<<<<<<< HEAD


=======
    public void addEvidencia (Evidencia E){
        this.evidencias.add(E);
    }
>>>>>>> 83172b2725e666019ff1f987f0db203fc9d00527
    
    public void addAvance (Avance avance){
        this.avances.add(avance);
    }

}
