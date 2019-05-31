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

/**
 *
 * @author mcai
 */
public class ConexionBD {
    private static ConexionBD instance;
    //String connectionUrl = "jdbc:sqlserver://(localdb)\\MSSQLLocalDB;databaseName=Diseño;integratedSecurity=true";
    private String connectionUrl = "jdbc:jtds:sqlserver://.;instance=LOCALDB#BDEC231B;databaseName=Diseño;namedPipe=true;integratedSecurity=true";
    
    private ConexionBD () {
    }
    
    public static synchronized ConexionBD getInstance() {
        if(instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }
    
    private java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
    public void insertarActividad(Actividad a) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarActividad(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Actividad leerActividad(Integer idActividad) {
        Actividad a = null;
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerActividad(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return a;
    }

    public void actualizarActividad(Actividad a) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarActividad(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarActividad(Integer idActividad) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarActividad(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarAvance(Avance a) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarAvance(?,?,?,?,?,?)}");

            cstmt.setObject(1, a.getIdAvance(), Types.INTEGER);
            cstmt.setObject(2, a.getIdActividad(), Types.INTEGER);
            cstmt.setDate(3, sqlDate(a.getFechaAvance()));
            cstmt.setObject(4, a.getHorasDedicadas(), Types.INTEGER);
            cstmt.setObject(5, a.getTipoAvance(), Types.INTEGER);
            cstmt.setString(6, a.getDescripcion());

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Avance leerAvance(Integer idAvance) {
        Connection con = null;
        CallableStatement cstmt = null;
        Avance a = new Avance();
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerAvance(?)}");
            
            cstmt.setObject(1, idAvance, Types.INTEGER);
            ResultSet rs = cstmt.executeQuery();
            rs.next();
            a = new Avance(idAvance,
                    (Integer) rs.getObject(1),
                    rs.getDate(2),
                    (Integer) rs.getObject(3),
                    (Integer) rs.getObject(4),
                    rs.getString(5));
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return a;
    }

    public void actualizarAvance(Avance a) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarAvance(?,?,?,?,?,?)}");
            
            cstmt.setObject(1, a.getIdAvance(), Types.INTEGER);
            cstmt.setObject(2, a.getIdActividad(), Types.INTEGER);
            cstmt.setDate(3, sqlDate(a.getFechaAvance()));
            cstmt.setObject(4, a.getHorasDedicadas(), Types.INTEGER);
            cstmt.setObject(5, a.getTipoAvance(), Types.INTEGER);
            cstmt.setString(6, a.getDescripcion());

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarAvance(Integer idAvance) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarAvance(?)}");

            cstmt.setObject(1, idAvance, Types.INTEGER);
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarEvidencia(Evidencia e) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarEvidencia(?,?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Evidencia leerEvidencia(Integer idEvidencia) {
        Evidencia e = new Evidencia();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerEvidencia(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return e;
    }

    public void actualizarEvidencia(Evidencia e) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarEvidencia(?,?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarEvidencia(Integer idEvidencia) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarEvidencia(?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarPermiso(Permiso p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarPermiso(?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Permiso leerPermiso(Integer idPermiso) {
        Permiso p = new Permiso();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerPermiso(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return p;
    }

    public void actualizarPermiso(Permiso p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarPermiso(?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarPermiso(Integer idPermiso) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarPermiso(?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarPermisoUsuarios(PermisoUsuarios p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarPermisoUsuarios(?,?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public PermisoUsuarios leerPermisoUsuarios(Integer idPermisoUsuarios) {
        PermisoUsuarios p = new PermisoUsuarios();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerPermisoUsuarios(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return p;
    }

    public void actualizarPermisoUsuarios(PermisoUsuarios p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarPermisoUsuarios(?,?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarPermisoUsuarios(Integer idPermisoUsuarios) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarPermisoUsuarios(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarProyecto(Proyecto p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarProyecto(?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Proyecto leerProyecto(Integer idProyecto) {
        Proyecto p = new Proyecto();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerProyecto(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return p;
    }

    public void actualizarProyecto(Proyecto p) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarProyecto(?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarProyecto(Integer idProyecto) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarProyecto(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarRol(Rol r) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarRol(?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Rol leerRol(Integer idRol) {
        Rol r = new Rol();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerRol(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return r;
    }

    public void actualizarRol(Rol r) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarRol(?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarRol(Integer idRol) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarRol(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarRolUsuario(RolUsuario r) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarRolUsuario(?,?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public RolUsuario leerRolUsuario(Integer idRolUsuario) {
        RolUsuario r = new RolUsuario();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerRolUsuario(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return r;
    }

    public void actualizarRolUsuario(RolUsuario r) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarRolUsuario(?,?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarRolUsuario(Integer idRolUsuario) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarRolUsuario(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarTipoAvance(TipoAvance t) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarTipoAvance(?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public TipoAvance leerTipoAvance(Integer idTipoAvance) {
        TipoAvance t = new TipoAvance();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerTipoAvance(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return t;
    }

    public void actualizarTipoAvance(TipoAvance t) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarTipoAvance(?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarTipoAvance(Integer idTipoAvance) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarTipoAvance(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void insertarUsuario(Usuario u) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call insertarUsuario(?,?,?)}");

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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Usuario leerUsuario(Integer idUsuario) {
        Usuario u = new Usuario();
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call leerUsuario(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
        return u;
    }

    public void actualizarUsuario(Usuario u) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call actualizarUsuario(?,?,?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void borrarUsuario(Integer idUsuario) {
        Connection con = null;
        CallableStatement cstmt = null;
        try {
            con = DriverManager.getConnection(connectionUrl);
            cstmt = con.prepareCall("{call borrarUsuario(?)}");
            
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
            if(con!=null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
