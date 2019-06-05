/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ConexionBD;
import Model.RolUsuario;
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
    
        @Override
    public boolean Registrar(Object obj) {
        Usuario user = (Usuario) obj;
        System.out.println("Proceso de registrar un Usuario");
        this.conn = ConexionBD.getConexion();
        insertarUsuario(user);
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
    
    public void insertarUsuario(Usuario u) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarUsuario(?,?,?,?)}");
            cstmt.setString(1, u.getCodigoUsuario());
            cstmt.setString(2, u.getNombre());
            cstmt.setString(3, u.getCorreo());
            cstmt.setString(4, u.getPassword());

            cstmt.executeUpdate();
            insertarRolUsuario(u.getRolUsuario());
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

    public Usuario leerUsuario(Integer idUsuario) {
        this.conn = ConexionBD.getConexion();
        Usuario u = new Usuario();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerUsuario(?)}");
            
            cstmt.setObject(1, idUsuario, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            u = new Usuario(idUsuario,
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3));
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
        this.conn = ConexionBD.getConexion();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarUsuario(?,?,?,?)}");
            
            cstmt.setObject(1, u.getIdUsuario(), Types.INTEGER);
            cstmt.setString(2, u.getNombre());
            cstmt.setString(3, u.getCorreo());
            cstmt.setString(4, u.getPassword());

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
    
    public int verificarUsuario(Usuario u) {
        this.conn = ConexionBD.getConexion();
        String password = u.getPassword();
        String nombre = u.getNombre();
        int res = -1;
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call validarUsuario(?,?)}");
            
            cstmt.setString(1, u.getNombre());
            cstmt.setString(2, u.getPassword());
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            res = (Integer) rs.getObject(1);
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
        //System.out.println("Valor recibido "+res);
        return res;
    }
     public void insertarRolUsuario(Integer rol) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarRolUsuario(?)}");

            cstmt.setObject(1,rol, Types.INTEGER);

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

    public RolUsuario leerRolUsuario(Integer idRolUsuario) {
        RolUsuario r = new RolUsuario();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerRolUsuario(?)}");
            
            cstmt.setObject(1, idRolUsuario, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            r = new RolUsuario(idRolUsuario,
                    (Integer) rs.getObject(1),
                    (Integer) rs.getObject(2));
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
        return r;
    }

    public void actualizarRolUsuario(RolUsuario r) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarRolUsuario(?,?,?)}");
            
            cstmt.setObject(1, r.getIdRolUsuario(), Types.INTEGER);
            cstmt.setObject(2, r.getIdUsuario(), Types.INTEGER);
            cstmt.setObject(3, r.getIdRol(), Types.INTEGER);

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

    public void borrarRolUsuario(Integer idRolUsuario) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarRolUsuario(?)}");
            
            cstmt.setObject(1, idRolUsuario, Types.INTEGER);

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

}
