/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author aleta
 */
public class BuilderFecha extends ReporteBuilder {
    public Reporte Reporte;
    @Override
    public void Consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GenerarReporte() {
        System.out.println("Generando Reporte con Respecto a fechas");
        // ir a reporte y generar avance
        
        Reporte.ReporteBD();
                
    }
    
}
