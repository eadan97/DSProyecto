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
public class BuilderMiembro extends ReporteBuilder {


    @Override
        public void GenerarReporte() {
        
        String Miembro;
       
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Generando Reporte con Respecto a usuario Especifico");
        System.out.println("Cual es el Nombre del Usuario");
        Miembro= entrada.nextLine();
        
        //llamar a base y hacer query
        
    }
}
