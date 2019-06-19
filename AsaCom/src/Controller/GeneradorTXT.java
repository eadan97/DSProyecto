package Controller;

import Model.GeneradorBasePdf;
import Model.IDecorador;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorTXT {

    public GeneradorTXT() {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("ReporteTexto.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                String texto = "Prueba de archivo txt";
                escribir = new FileWriter(archivo);
                linea = new PrintWriter(escribir);

                linea.println(texto);
                linea.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(GeneradorTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                String texto = "Prueba de archivo txt";
                escribir = new FileWriter(archivo);
                linea = new PrintWriter(escribir);

                linea.println(texto);
                linea.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(GeneradorTXT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
