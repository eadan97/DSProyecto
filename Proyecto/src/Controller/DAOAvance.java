package Controller;

import Model.Avance;
import Model.ConexionBD;
import Model.Evidencia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
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
    GeneradorPDF pdf =new GeneradorPDF();
    
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

    public void BuscarAvancesMiembro ( Integer IdUsuario) throws SQLException {
        this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        String query="	SELECT IdActividad,FechaAvance,HorasDedicadas,T.Nombre as TipoAvance,U.Nombre,Descripción, IdEvidencia,\n" +
"	a.IdAvance,Imagen,U.Correo FROM Avance A  full outer join Evidencia E\n" +
"	on A.IdAvance = E.IdEvidencia\n" +
"	join Usuario U on U.IdUsuario = A.IdUsuario\n" +
"	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n" +
"	Where A.idUsuario = " +IdUsuario+ ";";
       ResultSet rs =stmt.executeQuery(query);
        while(rs.next()){
            System.out.println("---------------------------------");
            System.out.print("IdAvance: "+ rs.getString("IdAvance"));
            System.out.println("          IdActividad: "+rs.getString("IdActividad"));
            System.out.println("Fecha del Avance: "+rs.getString("FechaAvance"));
            System.out.println("Total de horas: "+rs.getString("HorasDedicadas"));
            System.out.println("Tipo de Avance: "+rs.getString("TipoAvance"));
            System.out.println("Usuario: "+rs.getString("Nombre"));
            System.out.println("Correo: "+rs.getString("Correo"));
            System.out.println("Descripcion : "+rs.getString("Descripción"));
            System.out.println("Codigo Evidencia: "+rs.getString("IdEvidencia"));
          //  System.out.println("Imagen: "+rs.getString("Imagen"));
            System.out.println("---------------------------------");   
            
             pdf.generarPDF(rs.getString("IdAvance"),rs.getString("IdActividad"),rs.getString("FechaAvance"),
                    rs.getString("HorasDedicadas"),rs.getString("TipoAvance"),rs.getString("Nombre"),
                    rs.getString("Descripción"),rs.getString("IdEvidencia"),rs.getString("Correo"));
        }
    }    
    
    public void BuscarAvancesActividad (Integer IdActiviad) throws SQLException{
         this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        String query="	SELECT A.IdAvance,IdActividad,FechaAvance,HorasDedicadas,U.Nombre, T.Nombre AS TipoAvance,\n" +
"	Descripción,IdEvidencia,Imagen,U.Correo FROM Avance A  full outer join Evidencia E\n" +
"	on A.IdAvance = E.IdEvidencia\n" +
"	join Usuario U on A.IdUsuario = U.IdUsuario\n" +
"	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n" +
"	Where A.IdActividad ="+IdActiviad+";";
       ResultSet rs =stmt.executeQuery(query);
        while(rs.next()){
            System.out.println("---------------------------------");
            System.out.print("IdAvance: "+ rs.getString("IdAvance"));
            System.out.println("          IdActividad: "+rs.getString("IdActividad"));
            System.out.println("Fecha del Avance: "+rs.getString("FechaAvance"));
            System.out.println("Total de horas: "+rs.getString("HorasDedicadas"));
            System.out.println("Tipo de Avance: "+rs.getString("TipoAvance"));
            System.out.println("Usuario: "+rs.getString("Nombre"));
            System.out.println("Correo: "+rs.getString("Correo"));
            System.out.println("Descripcion : "+rs.getString("Descripción"));
            System.out.println("Codigo Evidencia: "+rs.getString("IdEvidencia"));
            
          //  System.out.println("Imagen: "+rs.getString("Imagen"));
            System.out.println("---------------------------------");   
            
            pdf.generarPDF(rs.getString("IdAvance"),rs.getString("IdActividad"),rs.getString("FechaAvance"),
                    rs.getString("HorasDedicadas"),rs.getString("TipoAvance"),rs.getString("Nombre"),
                    rs.getString("Descripción"),rs.getString("IdEvidencia"),rs.getString("Correo"));
        }
        
    }    
    

    public void BuscarAvanceFechas(String Inicio, String Final) throws SQLException {
        this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
        System.out.println("inicio"+Inicio);
        java.sql.Date d1 = java.sql.Date.valueOf(Inicio);
        java.sql.Date d2 = java.sql.Date.valueOf(Final);
        String query="	SELECT A.IdAvance,IdActividad,FechaAvance,HorasDedicadas,U.Nombre, T.Nombre AS TipoAvance,\n" +
"	Descripción,IdEvidencia,Imagen,U.Correo		\n" +
"	FROM Avance A full outer join\n" +
"	Evidencia E on A.IdAvance =E.IdAvance\n" +
"	join Usuario U on A.IdUsuario = U.IdUsuario\n" +
"	join TipoAvance T on T.IdTipoAvance = A.TipoAvance\n" +
//"	Where (FechaAvance BETWEEN " + Inicio + " AND " + Final + ");"; //" +Inicio+ " AND " + Final +")";
"	Where (FechaAvance BETWEEN '2019-05-06' AND '2019-06-30'); "; //" +Inicio+ " AND " + Final +")";
        ResultSet rs =stmt.executeQuery(query);
        while(rs.next()){
            System.out.println("---------------------------------");
            System.out.print("IdAvance: "+ rs.getString("IdAvance"));
            System.out.println("          IdActividad: "+rs.getString("IdActividad"));
            System.out.println("Fecha del Avance: "+rs.getString("FechaAvance"));
            System.out.println("Total de horas: "+rs.getString("HorasDedicadas"));
            System.out.println("Tipo de Avance: "+rs.getString("TipoAvance"));
            System.out.println("Usuario: "+rs.getString("Nombre"));
            System.out.println("Correo: "+rs.getString("Correo"));
            System.out.println("Descripcion : "+rs.getString("Descripción"));
            System.out.println("Codigo Evidencia: "+rs.getString("IdEvidencia"));
          //  System.out.println("Imagen: "+rs.getString("Imagen"));
            System.out.println("---------------------------------");    
            
          pdf.generarPDF(rs.getString("IdAvance"),rs.getString("IdActividad"),rs.getString("FechaAvance"),
                    rs.getString("HorasDedicadas"),rs.getString("TipoAvance"),rs.getString("Nombre"),
                    rs.getString("Descripción"),rs.getString("IdEvidencia"),rs.getString("Correo"));
        }
        // generar sp de buscar fechas 
    }    
    
    public void BuscarActividades(Integer Usario) throws SQLException{
         this.conn = ConexionBD.getInstance().getConexion();
        Statement stmt = conn.createStatement();
       
 
        String query="Select *,u.Nombre FROM Actividad A\n" +
         "inner join Usuario U on U.IdUsuario =  A.IdUsuario\n" +
         "inner join Proyecto P on P.IdProyecto =A.IdProyecto\n" +
         "where A.IdUsuario ="+Usario + ";";
        ResultSet rs =stmt.executeQuery(query);
        while(rs.next()){
            System.out.println("---------------------------------");
            System.out.println("          IdActividad: "+rs.getString("IdActividad"));
            System.out.println("Fecha de Creacion: "+rs.getString("FechaCreacion"));
            System.out.println("Proyecto: "+rs.getString("NombreProyecto"));
            System.out.println("Fecha Ultima Modificacion: "+rs.getString("FechaUltimaModificacion"));
            System.out.println("Tarea: "+rs.getString("NombreTarea"));
            System.out.println("Usuario: "+rs.getString("Nombre"));
            
         
          //  System.out.println("Imagen: "+rs.getString("Imagen"));
            System.out.println("---------------------------------");    
            
          pdf.generarPDF(rs.getString("IdAvance"),rs.getString("IdActividad"),rs.getString("FechaAvance"),
                    rs.getString("HorasDedicadas"),rs.getString("TipoAvance"),rs.getString("Nombre"),
                    rs.getString("Descripción"),rs.getString("IdEvidencia"),rs.getString("Correo"));
        }
    }

}
