/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.GestorAvance;
import Model.Reporte;

/**
 *
 * @author aleta
 */
public abstract class ReporteBuilder {
    
   DAOReporte daoReporte = new DAOReporte();
   Controlador ctrl = Controlador.getInstance();
   
   abstract void GenerarReporte();
   
}
