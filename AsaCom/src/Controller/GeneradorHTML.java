package Controller;

import Model.FlatDecorator;
import Model.HtmlDecorator.DecoradorBaseHtml;
import Model.HtmlDecorator.HtmlBodyCloseDecorator;
import Model.HtmlDecorator.HtmlBodyOpenDecorator;
import Model.HtmlDecorator.HtmlBrDecorator;
import Model.HtmlDecorator.HtmlH1Decorator;
import Model.HtmlDecorator.HtmlHeadCloseDecorator;
import Model.HtmlDecorator.HtmlHeadOpenDecorator;
import Model.HtmlDecorator.HtmlHtmlCloseDecorator;
import Model.HtmlDecorator.HtmlKeyDecorator;
import Model.HtmlDecorator.HtmlPCloseDecorator;
import Model.HtmlDecorator.HtmlPOpenDecorator;
import Model.HtmlDecorator.HtmlTitleDecorator;
import Model.IDecorador;
import Model.ItemReporte;
import Model.OpcionesReporte;
import Model.Reporte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorHTML implements IGenerador {

    public OpcionesReporte or;

    public GeneradorHTML(OpcionesReporte or) {
        this.or = or;
    }

    @Override
    public boolean GenerarReporte(Reporte arg0) {
        // String encabezado = "<html>";
        //String title = "<head>\n" + "<title>ASACOM</title>\n" + "</head>\n" + "<body>";
        File archivo;

        archivo = new File("ReporteHTML.html");

        try {
            IDecorador dec = new DecoradorBaseHtml();
            dec = new HtmlHeadOpenDecorator(dec);
            dec = new HtmlTitleDecorator(dec);
            dec.setStr("ASACOM");

            dec = new HtmlHeadCloseDecorator(dec);
            dec = new HtmlBodyOpenDecorator(dec);
            int i = 0;
            for (ItemReporte itemReporte : arg0.getItemReportes()) {
                //todo: Falta meter que sea opcional
                i++;
                dec = new HtmlH1Decorator(dec);
                dec.setStr("Actividad " + i + " del reporte");

                if (or.responsable) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("Responsable");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getNombre());
                    dec = new HtmlPCloseDecorator(dec);
                }
                if (or.idActividad) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("Actividad");
                    dec = new FlatDecorator(dec);
                    dec.setStr(String.valueOf(itemReporte.getIdActividad()));
                    dec = new HtmlPCloseDecorator(dec);
                }
                if (or.fecha) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("Fecha");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getFechaAvance().toString());
                    dec = new HtmlPCloseDecorator(dec);
                }
                if (or.horasDedicadas) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("HorasDedicadas");
                    dec = new FlatDecorator(dec);
                    dec.setStr(String.valueOf(itemReporte.getHorasDedicadas()));
                    dec = new HtmlPCloseDecorator(dec);
                }

                if (or.descripcion) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("Descripcion");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getDescripcion());
                    dec = new HtmlPCloseDecorator(dec);
                }
                if (or.correo) {
                    dec = new HtmlPOpenDecorator(dec);
                    dec = new HtmlKeyDecorator(dec);
                    dec.setStr("Correo");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getCorreo());
                    dec = new HtmlPCloseDecorator(dec);
                }

                dec = new HtmlBrDecorator(dec);

            }
            dec = new HtmlBodyCloseDecorator(dec);
            dec = new HtmlHtmlCloseDecorator(dec);

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            /*bw.write(encabezado);
                bw.write(title);
                bw.write("<h1>Reporte1</h1>");
                bw.write("<p>Esto es un reporte</p>");
                bw.write("</body>");
                bw.write("</html>");*/
            bw.write(dec.getSource());
            bw.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(GeneradorHTML.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
