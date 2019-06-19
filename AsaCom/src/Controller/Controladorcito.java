/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.OpcionesReporte;


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
  
    public boolean ExportarReporte(String S, OpcionesReporte or) {
        
        IGenerador generador = null;
        switch(S){
            case "TXT":
               generador=new GeneradorTXT(or);
               break;
            case "HTML":
               generador=new GeneradorHTML(or);
               break;
            case "PDF":
                generador=new GeneradorPDF2(or);
                break;
           default:  
               //super.ExportarReporte();
               System.out.println("Reporte no soportado");
               return false;
       }
        
       gReporte.GenerarDocumento(generador, DTOReporte.getUnReporte());
       return true;
    }
    
}
