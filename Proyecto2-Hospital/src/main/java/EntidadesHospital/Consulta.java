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
public class Consulta {
    
    private String idConsulta;
    private double costoConsulta;
    private String codigoCitaMedico;

    public Consulta(double costoConsulta, String codigoCitaMedico) {
        this.costoConsulta = costoConsulta;
        this.codigoCitaMedico = codigoCitaMedico;
    }

    public Consulta(String idConsulta, double costoConsulta, String codigoCitaMedico) {
        this.idConsulta = idConsulta;
        this.costoConsulta = costoConsulta;
        this.codigoCitaMedico = codigoCitaMedico;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public String getCodigoCitaMedico() {
        return codigoCitaMedico;
    }

    public void setCodigoCitaMedico(String codigoCitaMedico) {
        this.codigoCitaMedico = codigoCitaMedico;
    }
    
    
}
