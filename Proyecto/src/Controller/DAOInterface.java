package Controller;

import java.util.List;

/**
 *
 * @author Joaquin
 */
public interface DAOInterface {
    
    boolean Registrar(Object obj);
    List Recuperar();
    Object Recuperar(Object clave);
    
    
    
}
