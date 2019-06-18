/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Avance;
import Model.ConexionBD;
import Model.ItemReporte;
import Model.Reporte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;

/**
 *
 * @author eadan
 */
public class DAOReporte {

    private Connection conn;

    public Reporte BuscarReportesPorUsuario(Integer IdUsuario) throws SQLException {
        this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        String query = "exec ConsultaReportes @IdUsuario="+IdUsuario+",@FechaInicio=NULL,@FechaFinal=NULL,@IdActividad=NULL;";
        ResultSet rs = stmt.executeQuery(query);
        Reporte reporte = new Reporte();
        reporte.setFechaSolicitudReporte(Date.from(Instant.now()));

        while (rs.next()) {
            reporte.addItemReporte(new ItemReporte(rs.getInt("IdAvance"),
                                    rs.getInt("IdActividad"),
                                    rs.getDate("FechaAvance"),
                                    rs.getInt("HorasDedicadas"),
                                    rs.getString("TipoAvance"),
                                    rs.getString("Nombre"),
                                    rs.getString("Correo"),
                                    rs.getString("Descripción"),
                                    rs.getInt("IdEvidencia"),
                                    rs.getBytes("Imagen")));
            
        }
        return reporte;
    }
    
 
    public Reporte BuscarReportesPorFechas(String Inicio, String Final) throws SQLException {
        this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        System.out.println("inicio" + Inicio);
        //java.sql.Date d1 = java.sql.Date.valueOf(Inicio);
        //java.sql.Date d2 = java.sql.Date.valueOf(Final);
        String query = "exec ConsultaReportes @IdUsuario=NULL,@FechaInicio='"+Inicio+"',@FechaFinal='"+Final+"',@IdActividad=NULL;";
        ResultSet rs = stmt.executeQuery(query);
        Reporte reporte = new Reporte();
        reporte.setFechaSolicitudReporte(Date.from(Instant.now()));

        while (rs.next()) {
            reporte.addItemReporte(new ItemReporte(rs.getInt("IdAvance"),
                                    rs.getInt("IdActividad"),
                                    rs.getDate("FechaAvance"),
                                    rs.getInt("HorasDedicadas"),
                                    rs.getString("TipoAvance"),
                                    rs.getString("Nombre"),
                                    rs.getString("Correo"),
                                    rs.getString("Descripción"),
                                    rs.getInt("IdEvidencia"),
                                    rs.getBytes("Imagen")));
            
        }
        return reporte;
    }

    public Reporte BuscarReportePorActividad(Integer idActividad) throws SQLException {
        this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        String query = "exec ConsultaReportes @IdUsuario=NULL,@FechaInicio=NULL,@FechaFinal=NULL,@IdActividad="+idActividad+";";
        ResultSet rs = stmt.executeQuery(query);
        Reporte reporte = new Reporte();
        reporte.setFechaSolicitudReporte(Date.from(Instant.now()));

        while (rs.next()) {
            reporte.addItemReporte(new ItemReporte(rs.getInt("IdAvance"),
                                    rs.getInt("IdActividad"),
                                    rs.getDate("FechaAvance"),
                                    rs.getInt("HorasDedicadas"),
                                    rs.getString("TipoAvance"),
                                    rs.getString("Nombre"),
                                    rs.getString("Correo"),
                                    rs.getString("Descripción"),
                                    rs.getInt("IdEvidencia"),
                                    rs.getBytes("Imagen")));
            
        }
        return reporte;
    }

}
