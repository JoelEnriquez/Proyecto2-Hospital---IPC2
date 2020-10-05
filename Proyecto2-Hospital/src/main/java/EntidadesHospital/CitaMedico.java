/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesHospital;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author Joel Enriquez
 */
public class CitaMedico {
    
    public static final String CITA_MEDICO_DB_NAME = "CITA_MEDICO";
    public static final String CITA_MEDICO_CODIGO_DB_NAME = "codigo";
    public static final String FECHA_DB_NAME = "fecha";
    public static final String HORA_DB_NAME = "hora";
    public static final String CODIGO_PACIENTE_DB_NAME = "codigo_paciente";
    public static final String CODIGO_MEDICO_DB_NAME = "codigo_medico";
    public static final String ID_ESPECIALIDAD_DB_NAME = "id_especialidad";
    public static final String ESPECIALIDAD_CITA_DB_NAME = "especialidad_cita";
    public static final String COSTO_CONSULTA_DB_NAME = "costo_consulta";  
    
    private String codigo;
    private String codigoPaciente;
    private String codigoMedico;
    private String nombreEspecialidad;
    private String idEspecialidad;
    private double costoConsulta;
    private Date fechaCita;
    private Time horaCita;

    public CitaMedico(String codigoPaciente, String codigoMedico, String nombreEspecialidad,
            String idEspecialidad, double costoConsulta, Date fechaCita, Time horaCita) {
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.nombreEspecialidad = nombreEspecialidad;
        this.idEspecialidad = idEspecialidad;
        this.costoConsulta = costoConsulta;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    public CitaMedico(String codigo, String codigoPaciente, String codigoMedico,
            String nombreEspecialidad, String idEspecialidad, double costoConsulta,
            Date fechaCita, Time horaCita) {
        this.codigo = codigo;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.nombreEspecialidad = nombreEspecialidad;
        this.idEspecialidad = idEspecialidad;
        this.costoConsulta = costoConsulta;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
    }

    
    public double getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(String codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
    
    
}
