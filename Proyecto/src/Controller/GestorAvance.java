package Controller;

import Model.Avance;
import java.util.Date;

/**
 *
 * @author Joaquin
 */
public class GestorAvance {
    //private Controlador Ctrl = Controlador.getInstance();
    private  DAOAvance DAOAvan;
    
    /*Esta parte sera hecho desde la interfaz de agregar Avance*/
    public void RegistrarAvance(int idAvance,int idActividad,Date fechaAvance,
            int horasDedicadas,int tipoAvance,String descripcion){
        Controlador Ctrl = Controlador.getInstance();
        Ctrl.getDTOAvance().getUnAvance().setIdAvance(idAvance);
        Ctrl.getDTOAvance().getUnAvance().setIdActividad(idActividad);
        Ctrl.getDTOAvance().getUnAvance().setFechaAvance(fechaAvance);
        Ctrl.getDTOAvance().getUnAvance().setHorasDedicadas(horasDedicadas);
        Ctrl.getDTOAvance().getUnAvance().setTipoAvance(tipoAvance);
        Ctrl.getDTOAvance().getUnAvance().setDescripcion(descripcion);     
        Ctrl.CrearAvance();
    }
    
    public boolean CrearAvance(Avance avance){
      return DAOAvan.Registrar(avance);
    }
}
