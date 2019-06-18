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
public class Controladorcito extends Controlador{

    static Controladorcito instancia2;
    
    public static Controladorcito getInstance(){
        if(instancia2==null){
            instancia2 = new Controladorcito();
            instancia = instancia2;
        }
        return instancia2;
    }        
    private Controladorcito() { 
        super();
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
