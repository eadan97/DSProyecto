/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FlatDecorator;
import Model.GeneradorBasePdf;
import Model.IDecorador;
import Model.ItemReporte;
import Model.PdfHrDecorator;
import Model.PdfKeyDecorator;
import Model.Reporte;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author eadan
 */
public class GeneradorPDF2 extends GeneradorPDF {

    @Override
    public boolean GenerarReporte(Reporte Reporte) {
        try{
            
            FileOutputStream fi = new FileOutputStream("Reporte X.pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, fi);
            doc.open();
            //doc.add(new Paragraph("REPORTE DE AVANCES"));
            
            //doc.add(new Paragraph());
            String infs = "";
            IDecorador dec = new GeneradorBasePdf("REPORTE DE AVANCES");
            /*if (responsable is in opciones)
            a = new ResponsableWrapper(a);
            if (responsable is in opciones)
            a = new ResponsableWrapper(a);
            if (responsable is in opciones)
            a = new ResponsableWrapper(a);*/
            
            String parrafo;
            for (ItemReporte itemReporte : Reporte.getItemReportes()) {
                //todo: Falta meter que sea opcional
                
                dec=new PdfHrDecorator(dec);
                dec = new PdfKeyDecorator(dec);
                dec.setStr("Responsable");
                
                dec= new FlatDecorator(dec);
                dec.setStr(itemReporte.getNombre());
                dec = new PdfKeyDecorator(dec);
                dec.setStr("Actividad");
                dec= new FlatDecorator(dec);
                dec.setStr(String.valueOf(itemReporte.getIdActividad()));
                dec = new PdfKeyDecorator(dec);
                dec.setStr("Fecha");
                dec= new FlatDecorator(dec);
                dec.setStr(itemReporte.getFechaAvance().toString());
                dec = new PdfKeyDecorator(dec);
                dec.setStr("HorasDedicadas");
                dec= new FlatDecorator(dec);
                dec.setStr(String.valueOf(itemReporte.getHorasDedicadas()));
                dec = new PdfKeyDecorator(dec);
                dec.setStr("Descripcion");
                dec= new FlatDecorator(dec);
                dec.setStr(itemReporte.getDescripcion());
                dec = new PdfKeyDecorator(dec);
                dec.setStr("Correo");
                dec= new FlatDecorator(dec);
                dec.setStr(itemReporte.getCorreo());
                
                
                /*parrafo = "\n\n**************************************************";
                parrafo+= "\nResponsable: " + itemReporte.getNombre();
                parrafo+= "\nActividad: " + itemReporte.getIdActividad();
                parrafo+= "\nFecha: " + itemReporte.getFechaAvance();
                parrafo+= "\nHorasDedicadas: " + itemReporte.getHorasDedicadas();
                parrafo+= "\nDescripcion: " + itemReporte.getDescripcion();
                parrafo+= "\nCorreo: " + itemReporte.getCorreo();*/
                
                //infs += parrafo;
            }
            //infs += "\n**************************************************";
            dec=new PdfHrDecorator(dec);
            //doc.add(new Paragraph(infs));
            doc.add(new Paragraph(dec.getSource()));
            doc.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
