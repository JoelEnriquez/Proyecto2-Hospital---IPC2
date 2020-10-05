/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesHospital;

/**
 * 
 * @author Joel Enriquez
 */
public class TipoExamen {
    
    public static final String TIPO_EXAMEN_DB_NAME = "TIPO_EXAMEN";
    public static final String TIPO_EXAMEN_CODIGO_DB_NAME = "codigo";
    public static final String NOMBRE_EXAMEN_DB_NAME = "nombre_examen";
    public static final String DESCRIPCION_DB_NAME = "descripcion";
    public static final String COSTO_DB_NAME = "costo";
    public static final String FORMATO_INFORME_DB_NAME = "formato_informe";
    
    private String codigo;
    private String nombreExamen;
    private String descripcion;
    private double costoExamen;
    private String formatoInforme;

    public TipoExamen(String codigo, String nombreExamen, String descripcion, double costoExamen, String formatoInforme) {
        this.codigo = codigo;
        this.nombreExamen = nombreExamen;
        this.descripcion = descripcion;
        this.costoExamen = costoExamen;
        this.formatoInforme = formatoInforme;
    }

    public TipoExamen(String nombreExamen, String descripcion, double costoExamen, String formatoInforme) {
        this.nombreExamen = nombreExamen;
        this.descripcion = descripcion;
        this.costoExamen = costoExamen;
        this.formatoInforme = formatoInforme;
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoExamen() {
        return costoExamen;
    }

    public void setCostoExamen(double costoExamen) {
        this.costoExamen = costoExamen;
    }

    public String getFormatoInforme() {
        return formatoInforme;
    }

    public void setFormatoInforme(String formatoInforme) {
        this.formatoInforme = formatoInforme;
    }
    
    
}
