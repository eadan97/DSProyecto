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
public class BuilderMiembro extends ReporteBuilder {


      DAOAvance DaoAvance = new DAOAvance();
    @Override
        public void GenerarReporte() {
        
        String Miembro;
       
        Scanner entrada = new Scanner (System.in);
        
        System.out.println("Generando Reporte con Respecto a usuario Especifico");
        System.out.println("Cual es el Nombre del Usuario");
        Miembro= entrada.nextLine();
          try {
              DaoAvance.BuscarAvancesMiembro(Integer.valueOf(Miembro));
              //  DaoAvance.leerAvance(1);
              
              
              
              //llamar a base y hacer query
          } catch (SQLException ex) {
              Logger.getLogger(BuilderMiembro.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
        
        
        
}
