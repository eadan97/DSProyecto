/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aleta
 */
public class Reporte {

    private Date FechaSolicitudReporte;

    protected ArrayList<ItemReporte> itemReportes;


    public Reporte() {
        itemReportes = new ArrayList<>();
        
    }


    
    public Date getFechaSolicitudReporte() {
        return FechaSolicitudReporte;
    }

    public void setFechaSolicitudReporte(Date FechaSolicitudReporte) {
        this.FechaSolicitudReporte = FechaSolicitudReporte;
    }

    public ArrayList<ItemReporte> getItemReportes() {
        return itemReportes;
    }

    public void setItemReportes(ArrayList<ItemReporte> itemReportes) {
        this.itemReportes = itemReportes;
    }

    public void addItemReporte(ItemReporte item){
        this.itemReportes.add(item);
    }

}
