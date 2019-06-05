/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author mcai
 */
public class ConexionBD {
    

    //private String connectionUrl = "jdbc:jtds:sqlserver://.;instance=LOCALDB#BDEC231B;databaseName=Diseño;namedPipe=true;integratedSecurity=true";
     String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Diseño";


    private static ConexionBD instance;
    static Connection conn = null;
    public Statement statement = null;
    private ResultSet rs = null;

    
    private ConexionBD () {
    }
    
    public static synchronized ConexionBD getInstance() {
        if(instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }
    
    public static Connection getConexion(){
        //String Url = "jdbc:sqlserver://JOAQUIN:1433;databaseName=Diseño";
        String Url = "jdbc:sqlserver://localhost:1433;databaseName=Diseño";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
            
        }
        try{
            conn = DriverManager.getConnection(Url,"sa","123");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
    
    public void desconectar() throws SQLException{
        conn.close();
    }
       
    
    /*Propio de cada gestor*/
    private java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
    

    public void insertarPermiso(Permiso p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarPermiso(?,?)}");

            cstmt.setObject(1, p.getIdPermiso(), Types.INTEGER);
            cstmt.setString(2, p.getNombre());

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

    public Permiso leerPermiso(Integer idPermiso) {
        Permiso p = new Permiso();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerPermiso(?)}");
            
            cstmt.setObject(1, idPermiso, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            p = new Permiso(idPermiso,
                    rs.getString(1));
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
        return p;
    }

    public void actualizarPermiso(Permiso p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarPermiso(?,?)}");
            
            cstmt.setObject(1, p.getIdPermiso(), Types.INTEGER);
            cstmt.setString(2, p.getNombre());

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

    public void borrarPermiso(Integer idPermiso) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarPermiso(?)}");

            cstmt.setObject(1, idPermiso, Types.INTEGER);
            
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

    public void insertarPermisoUsuarios(PermisoUsuarios p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarPermisoUsuarios(?,?,?)}");

            cstmt.setObject(1, p.getIdPermisoUsuario(), Types.INTEGER);
            cstmt.setObject(2, p.getIdUsuario(), Types.INTEGER);
            cstmt.setObject(3, p.getIdPermiso(), Types.INTEGER);

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

    public PermisoUsuarios leerPermisoUsuarios(Integer idPermisoUsuarios) {
        PermisoUsuarios p = new PermisoUsuarios();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerPermisoUsuarios(?)}");
            
            cstmt.setObject(1, idPermisoUsuarios, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            p = new PermisoUsuarios(idPermisoUsuarios,
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
        return p;
    }

    public void actualizarPermisoUsuarios(PermisoUsuarios p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarPermisoUsuarios(?,?,?)}");
            
            cstmt.setObject(1, p.getIdPermisoUsuario(), Types.INTEGER);
            cstmt.setObject(2, p.getIdUsuario(), Types.INTEGER);
            cstmt.setObject(3, p.getIdPermiso(), Types.INTEGER);

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

    public void borrarPermisoUsuarios(Integer idPermisoUsuarios) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarPermisoUsuarios(?)}");
            
            cstmt.setObject(1, idPermisoUsuarios, Types.INTEGER);

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

    public void insertarProyecto(Proyecto p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarProyecto(?,?)}");

            cstmt.setObject(1, p.getCodigoProyecto(), Types.INTEGER);
            cstmt.setString(2, p.getNombreProyecto());

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

    public Proyecto leerProyecto(Integer idProyecto) {
        Proyecto p = new Proyecto();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerProyecto(?)}");
            
            cstmt.setObject(1, idProyecto, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            p = new Proyecto(idProyecto,
                    rs.getString(1));
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
        return p;
    }

    public void actualizarProyecto(Proyecto p) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarProyecto(?,?)}");
            
            cstmt.setObject(1, p.getCodigoProyecto(), Types.INTEGER);
            cstmt.setString(2, p.getNombreProyecto());

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

    public void borrarProyecto(Integer idProyecto) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarProyecto(?)}");
            
            cstmt.setObject(1, idProyecto, Types.INTEGER);

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

    public void insertarRol(Rol r) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarRol(?,?)}");

            cstmt.setObject(1, r.getIdRol(), Types.INTEGER);
            cstmt.setString(2, r.getNombre());

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

    public Rol leerRol(Integer idRol) {
        Rol r = new Rol();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerRol(?)}");
            
            cstmt.setObject(1, idRol, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            r = new Rol(idRol,
                    rs.getString(1));
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

    public void actualizarRol(Rol r) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarRol(?,?)}");
            
            cstmt.setObject(1, r.getIdRol(), Types.INTEGER);
            cstmt.setString(2, r.getNombre());

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

    public void borrarRol(Integer idRol) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarRol(?)}");
            
            cstmt.setObject(1, idRol, Types.INTEGER);

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

    public void insertarRolUsuario(RolUsuario r) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarRolUsuario(?,?,?)}");

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

    public void insertarTipoAvance(TipoAvance t) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarTipoAvance(?,?)}");

            cstmt.setObject(1, t.getIdTipoAvance(), Types.INTEGER);
            cstmt.setString(2, t.getNombre());

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

    public TipoAvance leerTipoAvance(Integer idTipoAvance) {
        TipoAvance t = new TipoAvance();
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call leerTipoAvance(?)}");
            
            cstmt.setObject(1, idTipoAvance, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            t = new TipoAvance(idTipoAvance,
                    rs.getString(1));
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
        return t;
    }

    public void actualizarTipoAvance(TipoAvance t) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarTipoAvance(?,?)}");
            
            cstmt.setObject(1, t.getIdTipoAvance(), Types.INTEGER);
            cstmt.setString(2, t.getNombre());

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

    public void borrarTipoAvance(Integer idTipoAvance) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call borrarTipoAvance(?)}");
            
            cstmt.setObject(1, idTipoAvance, Types.INTEGER);

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
