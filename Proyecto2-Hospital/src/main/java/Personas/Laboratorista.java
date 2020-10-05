/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personas;

import java.sql.Date;

/**
 * 
 * @author Joel Enriquez
 */
public class Laboratorista extends Persona {

    public static final String LABORATORISTA_DB_NAME = "LABORATORISTA";
    public static final String LABORATORISTA_CODIGO_DB_NAME = "codigo";
    public static final String NOMBRE_DB_NAME = "nombre";
    public static final String REGISTRO_DB_NAME = "registro";
    public static final String DPI_DB_NAME = "DPI";
    public static final String TELEFONO_DB_NAME = "telefono";
    public static final String CORREO_DB_NAME = "correo_electronico";
    public static final String FECHA_INICIO_DB_NAME = "fecha_inicio_hospital";
    public static final String PASSWORD_DB_NAME = "password";  
    public static final String CODIGO_EXAMEN_DB_NAME = "codigo_tipo_examen";  
    
    private Date fechaInicioHospital;
    private int codigoTipoExamen;
    private String registroSalud;

    public Laboratorista(Date fechaInicioHospital, int codigoTipoExamen,
            String registroSalud,String codigo, String nombre, String DPI,
            String contraseña, String telefono, String correoElectronico) {
        super(codigo, nombre, DPI, contraseña, telefono, correoElectronico);
        this.fechaInicioHospital = fechaInicioHospital;
        this.codigoTipoExamen = codigoTipoExamen;
        this.registroSalud = registroSalud;
    }

    public Date getFechaInicioHospital() {
        return fechaInicioHospital;
    }

    public void setFechaInicioHospital(Date fechaInicioHospital) {
        this.fechaInicioHospital = fechaInicioHospital;
    }

    public int getCodigoTipoExamen() {
        return codigoTipoExamen;
    }

    public void setCodigoTipoExamen(int codigoTipoExamen) {
        this.codigoTipoExamen = codigoTipoExamen;
    }

    public String getRegistroSalud() {
        return registroSalud;
    }

    public void setRegistroSalud(String registroSalud) {
        this.registroSalud = registroSalud;
    }

}
