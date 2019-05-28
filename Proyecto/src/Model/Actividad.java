package Model;

/**
 *
 * @author Joaquin
 */
public class Actividad {
    
    private String IdTarea;
    private String FechaCreacion;
    private String FechaCompletado;
    private String FechaUltMod;
    private String NombreTarea;
    private String UsuarioAsignado;
    private String EmailAsignado;
    private String FechaInicion;
    private String FechaFin;
    private String etiqueta;
    private String Nota;
    private int ProyectoPertenece;
    private String TareaPadre;

    public String getIdTarea() {
        return IdTarea;
    }

    public void setIdTarea(String IdTarea) {
        this.IdTarea = IdTarea;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getFechaCompletado() {
        return FechaCompletado;
    }

    public void setFechaCompletado(String FechaCompletado) {
        this.FechaCompletado = FechaCompletado;
    }

    public String getFechaUltMod() {
        return FechaUltMod;
    }

    public void setFechaUltMod(String FechaUltMod) {
        this.FechaUltMod = FechaUltMod;
    }

    public String getNombreTarea() {
        return NombreTarea;
    }

    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }

    public String getUsuarioAsignado() {
        return UsuarioAsignado;
    }

    public void setUsuarioAsignado(String UsuarioAsignado) {
        this.UsuarioAsignado = UsuarioAsignado;
    }

    public String getEmailAsignado() {
        return EmailAsignado;
    }

    public void setEmailAsignado(String EmailAsignado) {
        this.EmailAsignado = EmailAsignado;
    }

    public String getFechaInicion() {
        return FechaInicion;
    }

    public void setFechaInicion(String FechaInicion) {
        this.FechaInicion = FechaInicion;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getNota() {
        return Nota;
    }

    public void setNota(String Nota) {
        this.Nota = Nota;
    }

    public int getProyectoPertenece() {
        return ProyectoPertenece;
    }

    public void setProyectoPertenece(int ProyectoPertenece) {
        this.ProyectoPertenece = ProyectoPertenece;
    }

    public String getTareaPadre() {
        return TareaPadre;
    }

    public void setTareaPadre(String TareaPadre) {
        this.TareaPadre = TareaPadre;
    }
    
}
