/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reporte;
import java.sql.SQLException;

/**
 *
 * @author eadan
 */
public class GestorReporte {
    DAOReporte daoReporte=new DAOReporte();
    DirectorReporte DReporte = new DirectorReporte();
    ReporteBuilder RBuilder;
    
    public void GenerarReporteMiembro() throws SQLException{       
        RBuilder = new BuilderMiembro();
        DReporte.setBuilder(RBuilder);
        DReporte.prepararReporte();

    }
    
    public void GenerarReporteActividad() {
        RBuilder = new BuilderActividad();
        DReporte.setBuilder(RBuilder);
        DReporte.prepararReporte();
    }
    
    public void GenerarReporteFecha() {
        RBuilder = new BuilderFecha();
        DReporte.setBuilder(RBuilder);
        DReporte.prepararReporte();
    }
    
    
    public void ObtenerReportePorUsuario(Integer idUsuario){
           return; 
    }
    
    public void GenerarDocumento(IGenerador generador, Reporte reporte){
        generador.GenerarReporte(reporte);
    }

    
}
