/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ItemReporte;
import Model.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author aleta
 */
public class GeneradorPDF implements IGenerador{
    
    public GeneradorPDF(){}


    public boolean generarPDF (String IdAvance, String IdActividad, String FechaAvance,String HorasDedicadas,
    String TipoAvance,String Nombre, String Descripcion, String IdEvidencia,String Correo){
        try{
            FileOutputStream fi = new FileOutputStream("Avance "+IdAvance + " " + Nombre+ ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fi);
            doc.open();
            doc.add(new Paragraph("REPORTE DE AVANCE"));
            
            doc.add(new Paragraph(IdAvance));
            String infs = "";
            String parrafo;
             
            
                parrafo = "\n**************************************************";
                parrafo+= "\nResponsable: " + Nombre;
                parrafo+= "\nActividad: " + IdActividad;
                parrafo+= "\nFecha: " + FechaAvance;
                parrafo+= "\nHorasDedicadas: " + HorasDedicadas;
                parrafo+= "\nDescripcion: " + Descripcion;
                parrafo+= "\nCorreo: " +Correo;
                //parrafo = "\n**************************************************";
                infs += parrafo;
            
            
            doc.add(new Paragraph(infs));
            
            doc.close();
            
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }

    @Override
    public boolean GenerarReporte(Reporte Reporte) {
        try{
            
            FileOutputStream fi = new FileOutputStream("Reporte X.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fi);
            doc.open();
            doc.add(new Paragraph("REPORTE DE AVANCES"));
            
            //doc.add(new Paragraph());
            String infs = "";
            /*var a = new Base(itemReporte.getIdActividad());
            if (responsable is in opciones)
            a = new ResponsableWrapper(a);
            if (responsable is in opciones)
            a = new ResponsableWrapper(a);
            if (responsable is in opciones)
            a = new ResponsableWrapper(a);*/
            
            String parrafo;
            for (ItemReporte itemReporte : Reporte.getItemReportes()) {
                parrafo = "\n\n**************************************************";
                parrafo+= "\nResponsable: " + itemReporte.getNombre();
                parrafo+= "\nActividad: " + itemReporte.getIdActividad();
                parrafo+= "\nFecha: " + itemReporte.getFechaAvance();
                parrafo+= "\nHorasDedicadas: " + itemReporte.getHorasDedicadas();
                parrafo+= "\nDescripcion: " + itemReporte.getDescripcion();
                parrafo+= "\nCorreo: " + itemReporte.getCorreo();
                
                infs += parrafo;
            }
            infs += "\n**************************************************";

            doc.add(new Paragraph(infs));
            doc.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    

    
}
