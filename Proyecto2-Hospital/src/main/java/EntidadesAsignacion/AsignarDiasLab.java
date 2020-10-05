/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesAsignacion;

/**
 * 
 * @author Joel Enriquez
 */
public class AsignarDiasLab {

    public static final String ASIGNAR_DIAS_LAB_DB_NAME = "ASIGNAR_DIAS_LAB";
    public static final String CODIGO_LABORISTA_DB_NAME = "codigo_laboratorista";
    public static final String LUNES_DB_NAME = "lunes";
    public static final String MARTES_DB_NAME = "martes";
    public static final String MIERCOLES_DB_NAME = "miercoles";
    public static final String JUEVES_DB_NAME = "jueves";
    public static final String VIERNES_DB_NAME = "viernes";
    public static final String SABADO_DB_NAME = "sabado";  
    public static final String DOMINGO_DB_NAME = "domingo"; 
    
    private String codigoLaboratorista;
    private boolean lunes=false;
    private boolean martes=false;
    private boolean miercoles=false;
    private boolean jueves=false;
    private boolean viernes=false;
    private boolean sabado=false;
    private boolean domingo=false;

    public AsignarDiasLab(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public boolean isLunes() {
        return lunes;
    }

    public void setLunes(boolean lunes) {
        this.lunes = lunes;
    }

    public boolean isMartes() {
        return martes;
    }

    public void setMartes(boolean martes) {
        this.martes = martes;
    }

    public boolean isMiercoles() {
        return miercoles;
    }

    public void setMiercoles(boolean miercoles) {
        this.miercoles = miercoles;
    }

    public boolean isJueves() {
        return jueves;
    }

    public void setJueves(boolean jueves) {
        this.jueves = jueves;
    }

    public boolean isViernes() {
        return viernes;
    }

    public void setViernes(boolean viernes) {
        this.viernes = viernes;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }
    
    
    
    
    
}
