/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author aleta
 */
public class  GeneradorPDF   {
    
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
    
   /* public boolean generarPDF(Reporte reporte){
        
 try{
            FileOutputStream fi = new FileOutputStream("Avance "+reporte.getIdAvance() + " " + reporte.getNombre()+ ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fi);
            doc.open();
            doc.add(new Paragraph("REPORTE DE AVANCE"));
            doc.add(new Paragraph(reporte.getIdAvance()));
            String infs = "";
            String parrafo;
             
            
                parrafo = "\n**************************************************";
                parrafo+= "\nResponsable: " + reporte.getNombre();
                parrafo+= "\nActividad: " + reporte.getIdActividad();
                parrafo+= "\nFecha: " + reporte.getFechaAvance();
                parrafo+= "\nHorasDedicadas: " + reporte.getHorasDedicadas();
                parrafo+= "\nDescripcion: " + reporte.getDescripcion();
                parrafo+= "\nCorreo: " +reporte.getCorreo();
                //parrafo = "\n**************************************************";
                infs += parrafo;
            
            
            doc.add(new Paragraph(infs));
            doc.close();
            
            return true;
        }
        catch(Exception e){
            return false;
        }
        
        
        
    }*/
    

    
}
