/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Scanner;

/**
 *
 * @author aleta
 */
public class BuilderActividad extends ReporteBuilder{

    @Override
    public void GenerarReporte() {
        
        String Actividad;
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Generando Reporte con Respecto a Actividad Especifica");
        System.out.println("Cual es el Nombre de la Actividad");
        Actividad= entrada.nextLine();
        
        //llamar a base y hacer query
        
    }
    
}
