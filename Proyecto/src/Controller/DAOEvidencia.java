/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionBD;
import Model.Evidencia;
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
public class DAOEvidencia implements DAOInterface{
    Connection conn;
    
    public DAOEvidencia(){
        this.conn = null;
    }

    @Override
    public boolean Registrar(Object obj) {
        Evidencia evd = (Evidencia) obj;
        System.out.println("Proceso de registrar una evidencia");
        this.conn = ConexionBD.getInstance().getConexion();
        insertarEvidencia(evd);
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
    
    
    public void insertarEvidencia(Evidencia e) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarEvidencia(?,?)}");
            cstmt.setObject(1, e.getIdAvance(), Types.INTEGER);
            cstmt.setBytes(2, e.getImagen());

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
        }
    }

    public Evidencia leerEvidencia(Integer idEvidencia) {
        Evidencia e = new Evidencia();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerEvidencia(?)}");
            
            cstmt.setObject(1, idEvidencia, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            e = new Evidencia(idEvidencia,
                    (Integer) rs.getObject(1),
                    rs.getBytes(2));
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
        }
        return e;
    }

    public void actualizarEvidencia(Evidencia e) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarEvidencia(?,?,?)}");
            
            cstmt.setObject(1, e.getIdEvidencia(), Types.INTEGER);
            cstmt.setObject(2, e.getIdAvance(), Types.INTEGER);
            cstmt.setBytes(3, e.getImagen());

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
        }
    }

    public void borrarEvidencia(Integer idEvidencia) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarEvidencia(?)}");

            cstmt.setObject(1, idEvidencia, Types.INTEGER);
            
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
        }
    }
    
    private java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
}
