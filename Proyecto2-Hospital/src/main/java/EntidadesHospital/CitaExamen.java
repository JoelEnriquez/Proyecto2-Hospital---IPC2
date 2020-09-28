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
public class CitaExamen {
    String id;
    Date fechaCita;
    Time horaCita;
    String codigoPaciente;
    String codigoMedico;
    String codigoTipoExamen;

    public CitaExamen(Date fechaCita, Time horaCita, String codigoPaciente,
            String codigoMedico, String codigoTipoExamen) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoTipoExamen = codigoTipoExamen;
    }

    public CitaExamen(String id, Date fechaCita, Time horaCita,
            String codigoPaciente, String codigoMedico, String codigoTipoExamen) {
        this.id = id;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoTipoExamen = codigoTipoExamen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCodigoTipoExamen() {
        return codigoTipoExamen;
    }

    public void setCodigoTipoExamen(String codigoTipoExamen) {
        this.codigoTipoExamen = codigoTipoExamen;
    }
    
    
    
}
