/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DAOAvance;
import java.text.ParseException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;  
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;


/**
 *
 * @author aleta
 */
public class BuilderFecha extends ReporteBuilder {
    public Reporte Reporte;
    DAOAvance DAOAvance= new DAOAvance();


    @Override
    public void GenerarReporte() {
        String FechaInicio;
        String FechaFin;
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Generando Reporte con Respecto a fechas");
        System.out.println("Cual es la Fecha de inicio (yyyy-MM-dd)");
        FechaInicio= entrada.nextLine();
        System.out.println("Cual es la Fecha final (yyyy-MM-dd)");
        FechaFin= entrada.nextLine();
       /* java.util.Date Inicio = null;  
        try {
            Inicio = new SimpleDateFormat("yyyy-MM-dd").parse(FechaInicio);
        } catch (ParseException ex) {
            Logger.getLogger(BuilderFecha.class.getName()).log(Level.SEVERE, null, ex);
        }*//*
        java.util.Date Fin = null;  
        try {
            Fin = new SimpleDateFormat("yyyy-MM-dd").parse(FechaFin);
        } catch (ParseException ex) {
            Logger.getLogger(BuilderFecha.class.getName()).log(Level.SEVERE, null, ex);
        }   */
        //System.out.println(Inicio);
       
        try {
            DAOAvance.BuscarAvanceFechas(FechaInicio,FechaFin);
          
        } catch (SQLException ex) {
            Logger.getLogger(BuilderFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    

    
}
