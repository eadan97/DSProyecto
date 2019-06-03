/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionBD;
import Model.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOUsuario implements DAOInterface{
    Connection conn;
    
    public void insertarUsuario(Usuario u) {
        
    }

    public Usuario leerUsuario(Integer idUsuario) {
        Usuario u = new Usuario();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerUsuario(?)}");
            
            cstmt.setObject(1, idUsuario, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            u = new Usuario(idUsuario,
                    rs.getString(1),
                    rs.getString(2));
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
        return u;
    }

    public void actualizarUsuario(Usuario u) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarUsuario(?,?,?)}");
            
            cstmt.setObject(1, u.getIdUsuario(), Types.INTEGER);
            cstmt.setString(2, u.getNombre());
            cstmt.setString(3, u.getCorreo());

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

    public void borrarUsuario(Integer idUsuario) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarUsuario(?)}");
            
            cstmt.setObject(1, idUsuario, Types.INTEGER);

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

    @Override
    public boolean Registrar(Object obj) {
        Usuario u = (Usuario) obj;
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarUsuario(?,?)}");
            cstmt.setString(1, u.getNombre());
            cstmt.setString(2, u.getCorreo());

            cstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(cstmt!=null) {
                try {
                    cstmt.close();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    @Override
    public List Recuperar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object Recuperar(Object clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
