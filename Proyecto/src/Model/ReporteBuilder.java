/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.GestorAvance;

/**
 *
 * @author aleta
 */
public abstract class ReporteBuilder {
    
   protected Reporte Reporte;
   GestorAvance gAvance;
   
   public Reporte getReporte(){
    return Reporte;
}
   
   public void crearReporte (){
       Reporte= new Reporte();
   }
    

   abstract void GenerarReporte();
   
}
