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
public class InformeMedico {
    private String codigo;
    private Date fechaInforme;
    private Time horaInforme;
    private String descripcionInforme;
    private String codigoPaciente;
    private String codigoMedico;
    private String idConsulta;

    public InformeMedico(Date fechaInforme, Time horaInforme,
            String descripcionInforme, String codigoPaciente,
            String codigoMedico, String idConsulta) {
        this.fechaInforme = fechaInforme;
        this.horaInforme = horaInforme;
        this.descripcionInforme = descripcionInforme;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.idConsulta = idConsulta;
    }

    public InformeMedico(String codigo, Date fechaInforme, Time horaInforme,
            String descripcionInforme, String codigoPaciente,
            String codigoMedico, String idConsulta) {
        this.codigo = codigo;
        this.fechaInforme = fechaInforme;
        this.horaInforme = horaInforme;
        this.descripcionInforme = descripcionInforme;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.idConsulta = idConsulta;
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

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    
}
