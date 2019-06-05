/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.Scanner;


/**
 *
 * @author aleta
 */
public class BuilderFecha extends ReporteBuilder {
    public Reporte Reporte;


    @Override
    public void GenerarReporte() {
        String FechaInicio;
        String FechaFin;
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Generando Reporte con Respecto a fechas");
        System.out.println("Cual es la Fecha de inicio (dd/MM/yyyy)");
        FechaInicio= entrada.nextLine();
        System.out.println("Cual es la Fecha final (dd/MM/yyyy)");
        FechaFin= entrada.nextLine();
        
        
        // llamar base datos
        
        
        
        
                  
        
        
        // ir a reporte y generar avance
        
        //Reporte.ReporteBD();
                
    }
    
}
