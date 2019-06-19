/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.ItemReporte;

/**
 *
 * @author aleta
 */
public class UtilidadesReportes {
    
    public static String ItemReporteToString (ItemReporte R){
               
        return R.getNombre()+ " " + R.getCorreo() + " " + R.getDescripcion() + " " + R.getTipoAvance() ;
    }
            
    
}
