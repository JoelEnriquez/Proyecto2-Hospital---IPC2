/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesHospital.CitaMedico;
import EntidadesHospital.Examen;
import EntidadesHospital.InformeMedico;
import EntidadesHospital.ResultadoExamen;
import java.sql.Connection;

/**
 *
 * @author joel
 */
public class HistorialMedicoModel {
    
    private final String HISTORIAL_CONSULTAS = "SELECT C.* FROM "+CitaMedico.CITA_MEDICO_DB_NAME+" CM INNER JOIN " + InformeMedico.INFORME_MEDICO_DB_NAME + " IM ON CM.codigo=IM.codigo_cita_medico ORDER BY E.fecha, E.hora;";
    private final String HISTORIAL_EXAMENES = "SELECT E.* FROM "+Examen.EXAMEN_DB_NAME+" E INNER JOIN "+ResultadoExamen.RESULTADO_EXAMEN_DB_NAME+" RE ON E.codigo=RE.codigo_examen ORDER BY E.fecha, E.hora;";
    
    private Connection conexion = Conexion.getConexion();
}
