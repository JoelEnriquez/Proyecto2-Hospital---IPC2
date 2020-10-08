/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personas;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author Joel Enriquez
 */
public class Medico extends Persona {

    public static final String MEDICO_DB_NAME = "MEDICO";
    public static final String MEDICO_CODIGO_DB_NAME = "codigo";
    public static final String NOMBRE_DB_NAME = "nombre";
    public static final String COLEGIADO_DB_NAME = "numero_colegiado";
    public static final String HORARIO_INICIO_DB_NAME = "horario_inicio";
    public static final String HORARIO_FIN_DB_NAME = "horario_fin";
    public static final String DPI_DB_NAME = "DPI";
    public static final String TELEFONO_DB_NAME = "telefono";
    public static final String CORREO_DB_NAME = "correo_electronico";
    public static final String FECHA_INICIO_DB_NAME = "fecha_inicio_hospital";
    public static final String PASSWORD_DB_NAME = "password";    
    
    private Time horaInicio;
    private Time horaFin;
    private String numeroColegiado;
    private Date fechaInicioHospital;
    private String nombreEspecialidad;

    public Medico(Time horaInicio, Time horaFin, String numeroColegiado,
            Date fechaInicioHospital, String codigo, String nombre,String DPI,
            String contraseña, String telefono, String correoElectronico) {
        super(codigo, nombre, DPI, contraseña, telefono, correoElectronico);
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.numeroColegiado = numeroColegiado;
        this.fechaInicioHospital = fechaInicioHospital;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(String numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public Date getFechaInicioHospital() {
        return fechaInicioHospital;
    }

    public void setFechaInicioHospital(Date fechaInicioHospital) {
        this.fechaInicioHospital = fechaInicioHospital;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }
    
    

}
