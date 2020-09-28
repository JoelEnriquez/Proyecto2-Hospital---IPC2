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
public class ExamenLab {
    private String id;
    private String idCita;
    private String codigoLaboratorista;
    private boolean requiereOrden;

    public ExamenLab(String idCita, String codigoLaboratorista, boolean requiereOrden) {
        this.idCita = idCita;
        this.codigoLaboratorista = codigoLaboratorista;
        this.requiereOrden = requiereOrden;
    }

    public ExamenLab(String id, String idCita, String codigoLaboratorista, boolean requiereOrden) {
        this.id = id;
        this.idCita = idCita;
        this.codigoLaboratorista = codigoLaboratorista;
        this.requiereOrden = requiereOrden;
    }


    public String getCodigo() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getCodigoLaboratorista() {
        return codigoLaboratorista;
    }

    public void setCodigoLaboratorista(String codigoLaboratorista) {
        this.codigoLaboratorista = codigoLaboratorista;
    }

    public boolean isRequiereOrden() {
        return requiereOrden;
    }

    public void setRequiereOrden(boolean requiereOrden) {
        this.requiereOrden = requiereOrden;
    }
    
    
}
