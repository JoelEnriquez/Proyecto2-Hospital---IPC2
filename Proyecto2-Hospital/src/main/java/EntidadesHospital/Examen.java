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
public class Examen {
    
    public static final String EXAMEN_DB_NAME = "EXAMEN";
    public static final String EXAMEN_CODIGO_DB_NAME = "codigo";
    public static final String FECHA_DB_NAME = "fecha";
    public static final String HORA_DB_NAME = "hora";
    public static final String REQUIERE_ORDEN_DB_NAME = "requiere_orden";
    public static final String CODIGO_PACIENTE_DB_NAME = "codigo_paciente";
    public static final String CODIGO_MEDICO_DB_NAME = "codigo_medico";
    public static final String CODIGO_TIPO_EXAMEN_DB_NAME = "codigo_tipo_examen";
    
    private int codigo;
    private Date fechaCita;
    private Time horaCita;
    private boolean requiereOrden;
    private String codigoPaciente;
    private String codigoMedico;
    private String codigoTipoExamen;

    public Examen(Date fechaCita, Time horaCita, boolean requiereOrden, String codigoPaciente,
            String codigoMedico, String codigoTipoExamen) {
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.requiereOrden = requiereOrden;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoTipoExamen = codigoTipoExamen;
    }

    public Examen(int codigo, Date fechaCita, Time horaCita, boolean requiereOrden,
            String codigoPaciente, String codigoMedico, String codigoTipoExamen) {
        this.codigo = codigo;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.requiereOrden = requiereOrden;
        this.codigoPaciente = codigoPaciente;
        this.codigoMedico = codigoMedico;
        this.codigoTipoExamen = codigoTipoExamen;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean getRequiereOrden() {
        return requiereOrden;
    }

    public void setRequiereOrden(boolean requiereOrden) {
        this.requiereOrden = requiereOrden;
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
