package Controller;

import Model.FlatDecorator;
import Model.TextDecorator.GeneradorBaseTexto;
import Model.ItemReporte;
import Model.TextDecorator.TextoHrDecorator;
import Model.TextDecorator.TextoKeyDecorator;
import Model.Reporte;
import Model.IDecorador;
import Model.OpcionesReporte;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorTXT implements IGenerador {

    public OpcionesReporte or;

    public GeneradorTXT(OpcionesReporte or) {
        this.or = or;
    }

    @Override
    public boolean GenerarReporte(Reporte arg0) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("ReporteTexto.txt");

        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            IDecorador dec = new GeneradorBaseTexto("REPORTE DE AVANCES");
            for (ItemReporte itemReporte : arg0.getItemReportes()) {
                //todo: Falta meter que sea opcional

                dec = new TextoHrDecorator(dec);

                if (or.responsable) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("Responsable");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getNombre());
                }
                if (or.idActividad) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("Actividad");
                    dec = new FlatDecorator(dec);
                    dec.setStr(String.valueOf(itemReporte.getIdActividad()));
                }
                if (or.fecha) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("Fecha");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getFechaAvance().toString());
                }
                if (or.horasDedicadas) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("HorasDedicadas");
                    dec = new FlatDecorator(dec);
                    dec.setStr(String.valueOf(itemReporte.getHorasDedicadas()));
                }
                if (or.descripcion) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("Descripcion");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getDescripcion());
                }
                if (or.correo) {
                    dec = new TextoKeyDecorator(dec);
                    dec.setStr("Correo");
                    dec = new FlatDecorator(dec);
                    dec.setStr(itemReporte.getCorreo());
                }
            }
            dec = new TextoHrDecorator(dec);

            //String texto = "Prueba de archivo txt";
            escribir = new FileWriter(archivo);
            linea = new PrintWriter(escribir);

            linea.println(dec.getSource());
            linea.close();
            escribir.close();
            return true;

        } catch (IOException ex) {
            Logger.getLogger(GeneradorTXT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
