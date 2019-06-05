/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DAOAvance;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleta
 */
public class BuilderActividad extends ReporteBuilder{

        DAOAvance DAOAvance= new DAOAvance();
    @Override
    public void GenerarReporte() {
        
        System.out.println("generando reoirte de actividad");
        String Actividad;
        Scanner entrada = new Scanner (System.in);
//        
        System.out.println("Cual es el numero de la Actividad");
       Actividad= entrada.nextLine();
        
            try {
                DAOAvance.BuscarAvancesActividad(Integer.valueOf(Actividad));
            } catch (SQLException ex) {
                Logger.getLogger(BuilderActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
