/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EntidadesAsignacion;

/**
 * 
 * @author Joel Enriquez
 */
public class AsignacionEspecialidad {
    
    public static final String ASIGNACION_ESPECIALIDAD_DB_NAME = "ASIGNACION_ESPECIALIDAD";
    public static final String CODIGO_MEDICO_DB_NAME = "codigo_medico";
    public static final String ID_ESPECIALIDAD_DB_NAME = "id_especialidad";
    
    private String idEspecialidad;
    private String codigoMedico;

    public AsignacionEspecialidad(String idEspecialidad, String codigoMedico) {
        this.idEspecialidad = idEspecialidad;
        this.codigoMedico = codigoMedico;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(String codigoMedico) {
        this.codigoMedico = codigoMedico;
    }
    
    
}
