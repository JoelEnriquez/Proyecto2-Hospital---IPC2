/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesHospital;

import java.sql.Date;
import java.sql.Time;

/**
 * Es una descripcion de una consulta previamente realizada
 * @author Joel Enriquez
 */
public class InformeMedico {
    
    public static final String INFORME_MEDICO_DB_NAME = "INFORME_MEDICO";
    public static final String INFORME_MEDICO_CODIGO_DB_NAME = "codigo";
    public static final String FECHA_DB_NAME = "fecha";
    public static final String HORA_DB_NAME = "hora";
    public static final String DESCRIPCION_DB_NAME = "descripcion";
    public static final String CODIGO_PACIENTE_DB_NAME = "codigo_paciente";
    public static final String CODIGO_MEDICO_DB_NAME = "codigo_medico";
    public static final String CODIGO_CITA_MEDICO_DB_NAME = "codigo_cita_medico";
    
    private String codigo;
    private Date fechaInforme;
    private Time horaInforme;
    private String descripcionInforme;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoCitaMedico;
    
    

    public InformeMedico(Date fechaInforme, Time horaInforme,
            String descripcionInforme, String codigoPaciente,
            String codigoMedico, String codigoCitaMedico) {
        this.fechaInforme = fechaInforme;
        this.horaInforme = horaInforme;
        this.descripcionInforme = descripcionInforme;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoCitaMedico = codigoCitaMedico;
    }

    public InformeMedico(String codigo, Date fechaInforme, Time horaInforme,
            String descripcionInforme, String codigoPaciente,
            String codigoMedico, String codigoCitaMedico) {
        this.codigo = codigo;
        this.fechaInforme = fechaInforme;
        this.horaInforme = horaInforme;
        this.descripcionInforme = descripcionInforme;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoCitaMedico = codigoCitaMedico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public Time getHoraInforme() {
        return horaInforme;
    }

    public void setHoraInforme(Time horaInforme) {
        this.horaInforme = horaInforme;
    }

    public String getDescripcionInforme() {
        return descripcionInforme;
    }

    public void setDescripcionInforme(String descripcionInforme) {
        this.descripcionInforme = descripcionInforme;
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

    public String getCodigoCitaMedico() {
        return codigoCitaMedico;
    }

    public void setCodigoCitaMedico(String codigoCitaMedico) {
        this.codigoCitaMedico = codigoCitaMedico;
    }

    
    
    
    
    
}
