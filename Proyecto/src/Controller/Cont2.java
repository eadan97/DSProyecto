/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evidencia;

/**
 *
 * @author eadan
 */
public class Cont2 extends Controlador{

    public Cont2() {
    }
  
    public boolean ExportarReporte(String S) {
        
        IGenerador generador = null;
        switch(S){
            case "El formato que quiera":
               generador=new GeneradorPDF();
               break;
            case "PDF":
                super.ExportarReporte();
                return true;
           default:  
               super.ExportarReporte();
               System.out.println("Reporte no soportado");
               return false;
       }
        
       gReporte.GenerarDocumento(generador, DTOReporte.getUnReporte());
       return true;
    }
    
}
