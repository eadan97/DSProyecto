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
        String query = "SELECT IdActividad,FechaAvance,HorasDedicadas,T.Nombre as TipoAvance,U.Nombre,Descripción, IdEvidencia,\n"
                + "	a.IdAvance,Imagen,U.Correo FROM Avance A  full outer join Evidencia E\n"
                + "	on A.IdAvance = E.IdEvidencia\n"
                + "	join Usuario U on U.IdUsuario = A.IdUsuario\n"
                + "	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n"
                + "	Where A.idUsuario = " + IdUsuario + ";";
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
        java.sql.Date d1 = java.sql.Date.valueOf(Inicio);
        java.sql.Date d2 = java.sql.Date.valueOf(Final);
        String query = "	SELECT A.IdAvance,IdActividad,FechaAvance,HorasDedicadas,U.Nombre, T.Nombre AS TipoAvance,\n"
                + "	Descripción,IdEvidencia,Imagen,U.Correo		\n"
                + "	FROM Avance A full outer join\n"
                + "	Evidencia E on A.IdAvance =E.IdAvance\n"
                + "	join Usuario U on A.IdUsuario = U.IdUsuario\n"
                + "	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n"
                + "	Where (FechaAvance BETWEEN '" + Inicio + "' AND '" + Final + "');"; //" +Inicio+ " AND " + Final +")";
                //"	Where (FechaAvance BETWEEN '2019-05-06' AND '2019-06-30'); "; //" +Inicio+ " AND " + Final +")";
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
        String query = "	SELECT A.IdAvance,IdActividad,FechaAvance,HorasDedicadas,U.Nombre, T.Nombre AS TipoAvance,\n"
                + "	Descripción,IdEvidencia,Imagen,U.Correo FROM Avance A  full outer join Evidencia E\n"
                + "	on A.IdAvance = E.IdEvidencia\n"
                + "	join Usuario U on A.IdUsuario = U.IdUsuario\n"
                + "	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n"
                + "	Where A.IdActividad =" + idActividad + ";";
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
