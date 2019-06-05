/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author aleta
 */
public class DirectorReporte {
           
   public ReporteBuilder builder;

    public ReporteBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(ReporteBuilder builder) {
        this.builder = builder;
    }

   public Reporte getReporte(){
       return builder.getReporte();
   }
     
   public void prepararReporte(){
       System.out.println("preparar reporte");
        builder.GenerarReporte();
    
}


    

}
