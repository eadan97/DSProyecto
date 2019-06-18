package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneradorHTML {

    public GeneradorHTML() {
        String encabezado = "<html>";
        String title = "<head>\n" + "<title>ASACOM</title>\n" + "</head>\n" + "<body>";
        File archivo;

        archivo = new File("ReporteHTML.html");

        if (!archivo.exists()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(encabezado);
                bw.write(title);
                bw.write("<h1>Reporte1</h1>");
                bw.write("<p>Esto es un reporte</p>");
                bw.write("</body>");
                bw.write("</html>");
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(GeneradorHTML.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(encabezado);
                bw.write(title);
                bw.write("<h1>Reporte1</h1>");
                bw.write("<p>Esto es un nUEVO reporte</p>");
                bw.write("</body>");
                bw.write("</html>");
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(GeneradorHTML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
