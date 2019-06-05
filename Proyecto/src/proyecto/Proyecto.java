/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;




import Controller.Controlador;
import Controller.DAOActividad;
import Controller.DAOAvance;

import Controller.GestorImportacion;
import Model.Actividad;
import Model.ConexionBD;
import Model.Evidencia;

import Model.Usuario;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author Joaquin
 */
public class Proyecto {
    
    

    private DAOAvance DAOAv;
    
    public static Controlador Ctrl = Controlador.getInstance();

    public static void main(String[] args) throws SQLException, IOException, ParseException {       
        System.out.println("BIENVENIDO AL SISTEMA ASACOM");
        System.out.println("-*-*-*-*-*-*-*-*-**-*-*-*-*-**-");
        mensajesEntrada();
        //ImportarProyecto();
       //AgregarAvance();
       //AgregarEvidencia();
       //C:\Users\aleta\Pictures\foto.jpg 
    }
    
    public static void mensajesEntrada() throws IOException, ParseException, SQLException{
        int selected = 0;

        System.out.println("Bienvenido a la pantalla de Inicio");
        System.out.println("1-Iniciar Sesión");
        System.out.println("2-Registrarse");
        System.out.println("3-Salir");
        System.out.println("Seccione el numero de la Operacion que desea realizar");
        Scanner entradaScanner = new Scanner(System.in);
        selected = Integer.parseInt(entradaScanner.nextLine());
        switch (selected) {
            case 1:
                IniciarSesion();
                break;
            case 2:
                Registrarse();
                break;
            case 3:
                System.out.println("----Finalizacion de ASACOM-------");
                System.exit(0);
                break;
            default:
                System.out.println("La opción seleccionada es inválida");
                mensajesEntrada();
                break;
        }
    }
    
    public static void IniciarSesion() throws IOException, ParseException, SQLException{
        Scanner entradaScanner;
        String user = "";
        String password = "";
        System.out.println("Digite el nombre de Usuario");
        entradaScanner = new Scanner(System.in);
        user = entradaScanner.nextLine();
        System.out.println("Digite su Contraseña");
        entradaScanner = new Scanner(System.in);
        password = entradaScanner.nextLine();
        //
        Ctrl.getDTOUsuario().getUnUsuario().setNombre(user);
        Ctrl.getDTOUsuario().getUnUsuario().setPassword(password);
        
        int procesoValidacion;
        procesoValidacion = Ctrl.validarUsuario();
                
        if(procesoValidacion == -1){
            System.out.println("Los datos ingresados son invalidos o "
                    + "el usuario no existe");
            IniciarSesion();
        }
        else{
            System.out.println("------------ASACOM------------------------");
            menuInteligente(procesoValidacion);
        }
    }
    
    public static void Registrarse() throws IOException, ParseException, SQLException{
        Scanner entradaScanner;
        String user = "";
        String correo = "";
        String codigoUsuario = "111111111111111";
        String password = "";
        
        //
        System.out.println("Digite el nombre de Usuario");
        entradaScanner = new Scanner(System.in);
        user = entradaScanner.nextLine();
        //
        System.out.println("Digite correo electronico");
        entradaScanner = new Scanner(System.in);
        correo = entradaScanner.nextLine();
        //
        System.out.println("Digite su Contraseña");
        entradaScanner = new Scanner(System.in);
        password = entradaScanner.nextLine();
        
        Ctrl.getDTOUsuario().getUnUsuario().setCodigoUsuario(codigoUsuario);
        Ctrl.getDTOUsuario().getUnUsuario().setCorreo(correo);
        Ctrl.getDTOUsuario().getUnUsuario().setNombre(user);
        Ctrl.getDTOUsuario().getUnUsuario().setPassword(password);
        Ctrl.getDTOUsuario().getUnUsuario().setRolUsuario(1);
        
        Ctrl.CrearUsuario();
        System.out.println("El usuario ha sido ingresado con exito");  
        mensajesEntrada();
    }

    public static void menuInteligente(int IdUsuario) throws IOException, ParseException, SQLException{
        Usuario Uingreso;
        Uingreso = Ctrl.LeerUsuario(IdUsuario);
        String Nombre;
        int rolUsuario;
        int idUsuario;
        //
        idUsuario = Uingreso.getIdUsuario();
        Nombre = Uingreso.getNombre();
        rolUsuario = Uingreso.getRolUsuario();
        //
        System.out.println("Bienvenido " + Nombre);
        Operaciones(idUsuario,rolUsuario);
    }
    
    
    public static void mostrarActividadesUsuario(int idUsuario){
    }
    
    public static void Operaciones(int usuario,int rol) throws IOException, ParseException, SQLException{
        int selected = 0;
        System.out.println("Seleccione la operación que desea realizar");

        System.out.println("1-Mostrar Actividades");
        System.out.println("2-Agregar Avance");
        System.out.println("3-Registrar Evidencia a un Avance"); 
        System.out.println("4-Realizar Reporte");
        System.out.println("5-Editar Perfil Usuario");
        if(rol == 1){
            System.out.println("6-Importar Proyecto");
        }

        System.out.println("Seccione el numero de la Operacion que desea realizar");
        Scanner entradaScanner = new Scanner(System.in);
        selected = Integer.parseInt(entradaScanner.nextLine());
        switch (selected) {
            case 1:
                mostrarActividadesUsuario(usuario);
                break;
            case 2:
                AgregarAvance();
                break;
            case 3:
                AgregarEvidencia();
                break;
            case 4:
                ObtenerReportes(usuario);
                break;
            case 5:
                modificarPerfilUsuario(usuario);
                break;
            case 6:
                ImportarProyecto();
                break;

            default:
                System.out.println("La opción seleccionada es inválida");
                Operaciones(usuario,rol);
                break;
        }
        Operaciones(usuario,rol);
    }
    
    public static void ObtenerReportes(int usuario){
        int selected = 0;
        System.out.println("Seleccione el reporte que desea realizar");
        System.out.println("1-Reporte por Usuario");
        System.out.println("2-Reporte por Fechas");
        System.out.println("3-Reporte por Actividad");
        System.out.println("Seccione el numero de la Operacion que desea realizar");
        Scanner entradaScanner = new Scanner(System.in);
        selected = Integer.parseInt(entradaScanner.nextLine());
        switch (selected) {
            case 1:
                Ctrl.CrearReporte("Usuario");
                break;
            case 2:
                Ctrl.CrearReporte("Fechas");
                break;
            case 3:
                Ctrl.CrearReporte("Actividad");
                break;
            default:
                System.out.println("La opción seleccionada es inválida");
                break;
        }
    }
    
    public static void ImportarProyecto() throws IOException, ParseException{
        System.out.println("Digite la ruta donde se encuentra el archivo JSON");
        String path = "";
        //Scanner entradaScanner = new Scanner(System.in);
        //path = entradaScanner.nextLine();
           
        path = "../archivo.json";
        Ctrl.ImportarArchivo(path);    
    }
    
    public static void AgregarAvance(){
        Scanner entradaScanner;
        int act = 0;
        int horas = 0;
        int tipAvance = 0;
        String descrip = "";
        int idUsuario=0;
        Date Fecha = new Date();
        java.sql.Date FechaMod = sqlDate(Fecha);
        
        System.out.println("Digite Numero de Actividad");
        entradaScanner = new Scanner(System.in);
        act = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite Numero de Horas dedicadas");
        entradaScanner = new Scanner(System.in);
        horas = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite tipo de Avance");
        entradaScanner = new Scanner(System.in);
        tipAvance = Integer.parseInt(entradaScanner.nextLine());
        //
         System.out.println("Digite el usuario");
        entradaScanner = new Scanner(System.in);
        idUsuario = Integer.parseInt(entradaScanner.nextLine());
        //
        System.out.println("Digite descripcion del avance Avance");
        entradaScanner = new Scanner(System.in);
        descrip = entradaScanner.nextLine();
        
        Ctrl.getDTOAvance().getUnAvance().setIdActividad(act);
        Ctrl.getDTOAvance().getUnAvance().setFechaAvance(FechaMod);
        Ctrl.getDTOAvance().getUnAvance().setHorasDedicadas(horas);
        Ctrl.getDTOAvance().getUnAvance().setTipoAvance(tipAvance);
        Ctrl.getDTOAvance().getUnAvance().setIdUsuario(idUsuario);
        Ctrl.getDTOAvance().getUnAvance().setDescripcion(descrip);
        
        Ctrl.CrearAvance();
    }
    public static void AgregarEvidencia() throws IOException{
        Scanner entradaScanner;
        String pathImagen = "";
        int evd = 0;
        System.out.println("Digite path de la imagen");
        entradaScanner = new Scanner(System.in);
        pathImagen = entradaScanner.nextLine();
        //Image imagenExterna = new ImageIcon(pathImagen).getImage();
        BufferedImage bImage = ImageIO.read(new File(pathImagen));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        
        //
        System.out.println("Digite Numero de Avance");
        entradaScanner = new Scanner(System.in);
        evd = Integer.parseInt(entradaScanner.nextLine());
        //
        Ctrl.getDTOEvidencia().getUnaEvidencia().setIdAvance(evd);
        Ctrl.getDTOEvidencia().getUnaEvidencia().setImagen(data);
        
        Ctrl.CrearEvidencia();

    }
    
    
    public static void modificarPerfilUsuario(int idUsuario) throws SQLException{
        Usuario user;
        Usuario userL = Ctrl.LeerUsuario(idUsuario);
        int idUsuarioBD;
        String nombre;
        String correo;
        String password;

        //idUsuarioBD = userL.getIdUsuario();
        nombre = userL.getNombre();
        correo = userL.getCorreo();
        password = userL.getPassword();
        //
        System.out.println(nombre);
        System.out.println(correo);
        System.out.println(password);
        //
        
    }
    
    private static java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
    
}
