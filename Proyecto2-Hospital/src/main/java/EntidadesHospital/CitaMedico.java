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
    private String codigo;
    private String codigoPaciente;
    private String codigoMedico;
    private String especialiadesDoctor;
    private Date fechaCita;
    private Time horaCita;
    private String idEspecialidad;

    public CitaMedico(String codigo, String codigoPaciente, String codigoMedico,
            String especialiadesDoctor, Date fechaCita, Time horaCita, String idEspecialidad) {
        this.codigo = codigo;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.especialiadesDoctor = especialiadesDoctor;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.idEspecialidad = idEspecialidad;
    }

    public CitaMedico(String codigoPaciente, String codigoMedico, String especialiadesDoctor,
            Date fechaCita, Time horaCita, String idEspecialidad) {
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.especialiadesDoctor = especialiadesDoctor;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.idEspecialidad = idEspecialidad;
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

    public String getEspecialiadesDoctor() {
        return especialiadesDoctor;
    }

    public void setEspecialiadesDoctor(String especialiadesDoctor) {
        this.especialiadesDoctor = especialiadesDoctor;
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
