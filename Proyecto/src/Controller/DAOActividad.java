package Controller;

import Model.Actividad;
import Model.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class DAOActividad implements DAOInterface {
    Connection conn;
    
    public DAOActividad(){
        this.conn = null;
    }
    
    @Override
    public boolean Registrar(Object obj) {
        Actividad act = (Actividad) obj;
        System.out.println("Proceso de registrar una actividad");
        try {
            this.conn = ConexionBD.getInstance().getConexion();
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOActividad.class.getName()).log(Level.SEVERE, null, ex);
        }
        //cierra la conexion
        ConexionBD.getInstance().desconectar();
        return true;

    }

    @Override
    public List Recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Recuperar(Object clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        /*Propio de cada gestor*/
    private java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
    public void insertarActividad(Actividad a) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarActividad(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            cstmt.setObject(1, a.getIdActividad(), Types.INTEGER);
            cstmt.setObject(2, a.getIdTarea(), Types.INTEGER);
            cstmt.setDate(3, sqlDate(a.getFechaCreacion()));
            cstmt.setDate(4, sqlDate(a.getFechaCompletado()));
            cstmt.setDate(5,  sqlDate(a.getFechaUltimaModificacion()));
            cstmt.setString(6, a.getNombreTarea());
            cstmt.setObject(7, a.getIdUsuario(), Types.INTEGER);
            cstmt.setString(8, a.getEmailAsignado());
            cstmt.setDate(9, sqlDate(a.getFechaInicio()));
            cstmt.setDate(10,  sqlDate(a.getFechaFin()));
            cstmt.setString(11, a.getEtiqueta());
            cstmt.setString(12, a.getNota());
            cstmt.setObject(13, a.getIdProyecto(), Types.INTEGER);
            cstmt.setObject(14, a.getTareaPadre(), Types.INTEGER);

            cstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cstmt!=null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Actividad leerActividad(Integer idActividad) {
        Actividad a = null;
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerActividad(?)}");
            
            cstmt.setObject(1, idActividad, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            a = new Actividad(idActividad,
                    (Integer) rs.getObject(1),
                    rs.getDate(2),
                    rs.getDate(3),
                    rs.getDate(4),
                    rs.getString(5),
                    (Integer) rs.getObject(6),
                    rs.getString(7),
                    rs.getDate(8),
                    rs.getDate(9),
                    rs.getString(10),
                    rs.getString(11),
                    (Integer) rs.getObject(12),
                    (Integer) rs.getObject(13));
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cstmt!=null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return a;
    }

    public void actualizarActividad(Actividad a) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarActividad(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
            cstmt.setObject(1, a.getIdActividad(), Types.INTEGER);
            cstmt.setObject(2, a.getIdTarea(), Types.INTEGER);
            cstmt.setDate(3, sqlDate(a.getFechaCreacion()));
            cstmt.setDate(4, sqlDate(a.getFechaCompletado()));
            cstmt.setDate(5,  sqlDate(a.getFechaUltimaModificacion()));
            cstmt.setString(6, a.getNombreTarea());
            cstmt.setObject(7, a.getIdUsuario(), Types.INTEGER);
            cstmt.setString(8, a.getEmailAsignado());
            cstmt.setDate(9,  sqlDate(a.getFechaInicio()));
            cstmt.setDate(10,  sqlDate(a.getFechaFin()));
            cstmt.setString(11, a.getEtiqueta());
            cstmt.setString(12, a.getNota());
            cstmt.setObject(13, a.getIdProyecto(), Types.INTEGER);
            cstmt.setObject(14, a.getTareaPadre(), Types.INTEGER);

            cstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cstmt!=null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarActividad(Integer idActividad) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarActividad(?)}");
            
            cstmt.setObject(1, idActividad, Types.INTEGER);

            cstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cstmt!=null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    
}