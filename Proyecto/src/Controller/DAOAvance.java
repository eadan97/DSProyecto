package Controller;

import Model.Avance;
import Model.ConexionBD;
import Model.Evidencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin
 */
public class DAOAvance implements DAOInterface {
    Connection conn;
    
    public DAOAvance(){
        this.conn = null;
    }
    
    @Override
    public boolean Registrar(Object obj) {
        Avance avan = (Avance) obj;
        System.out.println("Proceso de registrar un avance");
        this.conn = ConexionBD.getInstance().getConexion();
        insertarAvance(avan);
        //cierra la conexion
        //ConexionBD.getInstance().desconectar();
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
    
    public void insertarAvance(Avance a) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarAvance(?,?,?,?,?,?)}");

            cstmt.setObject(1, a.getIdActividad(), Types.INTEGER);
            cstmt.setDate(2, sqlDate((Date) a.getFechaAvance()));
            cstmt.setObject(3, a.getHorasDedicadas(), Types.INTEGER);
            cstmt.setObject(4, a.getTipoAvance(), Types.INTEGER);
            cstmt.setObject(5,a.getIdUsuario(),Types.INTEGER);
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
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public Avance leerAvance(Integer idAvance) {
        CallableStatement cstmt = null;
        Avance a = new Avance();
        try {
            cstmt = conn.prepareCall("{call leerAvance(?)}");
            
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

    public void actualizarAvance(Avance a) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call actualizarAvance(?,?,?,?,?,?)}");
            
            cstmt.setObject(1, a.getIdAvance(), Types.INTEGER);
            cstmt.setObject(2, a.getIdActividad(), Types.INTEGER);
            cstmt.setDate(3, sqlDate((Date) a.getFechaAvance()));
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
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }

    public void borrarAvance(Integer idAvance) {
        CallableStatement cstmt = null;
        try {;
            cstmt = conn.prepareCall("{call borrarAvance(?)}");

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
            if(conn!=null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
    public void insertarEvidencia(Evidencia e) {
        CallableStatement cstmt = null;
        try {
            cstmt = conn.prepareCall("{call insertarEvidencia(?,?,?)}");

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

    public Evidencia BuscarAvancesEvidencias ( Integer IdAvance){
    Evidencia e = new Evidencia();
    System.out.println("BUSCAR AVANCES EVIDENCIAS");
    CallableStatement cstmt = null;
        try {
            System.out.println("entro al try "+IdAvance);
            cstmt = conn.prepareCall("{call BuscarEvidencias(?)}");            
                    
            cstmt.setObject(1, IdAvance, Types.INTEGER);            
            ResultSet rs = cstmt.executeQuery();
          //  while (rs.next()){
                System.out.println("while");
//            e = new Evidencia(IdAvance,
//                    (Integer) rs.getObject(1),
//                    rs.getBytes(2));
               // System.out.println(e.getIdAvance());
//            
            cstmt.executeUpdate();
           // }
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
        
        //mandar a llamar a la base de datos, al store Procedure
        return null;
        
    }
    public void BuscarAvanceFechas(Date Inicio, Date Final){
        // generar sp de buscar fechas 
    }    
}
