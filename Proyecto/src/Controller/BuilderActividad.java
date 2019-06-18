/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.DAOAvance;
import Model.Avance;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleta
 */
public class BuilderActividad extends ReporteBuilder {

    @Override
    public void GenerarReporte() {

        try {
            //rrayList<Avance> avances = ctrl..BuscarAvancesActividad(DTOReporte.getIdActividad());
            ctrl.getDTOReporte().setUnReporte(daoReporte.BuscarReportePorActividad(ctrl.getDTOReporte().getIdActividad()));

        } catch (SQLException ex) {
            Logger.getLogger(BuilderActividad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
