/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosComunes;

import ConexionDB.Conexion;
import EntidadesHospital.CitaMedico;
import EntidadesHospital.Examen;
import EntidadesHospital.InformeMedico;
import EntidadesHospital.ResultadoExamen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class ModelCitasPendientes {
    
    //Citas pendientes de Paciente
    private final String CITAS_MEDICAS = "SELECT CM.* FROM " + CitaMedico.CITA_MEDICO_DB_NAME + " CM LEFT JOIN " + InformeMedico.INFORME_MEDICO_DB_NAME + " IM ON CM.codigo=IM.codigo_cita_medico WHERE IM.codigo_cita_medico IS NULL AND ";
    private final String CITAS_EXAMEN = "SELECT E.* FROM " + Examen.EXAMEN_DB_NAME + " E LEFT JOIN " + ResultadoExamen.RESULTADO_EXAMEN_DB_NAME + " RE ON E.codigo=RE.codigo_examen WHERE RE.codigo_examen IS NULL AND "+Examen.CODIGO_PACIENTE_DB_NAME+" = ? ORDER BY E.fecha, E.hora";
    
    private Connection conexion = Conexion.getConexion();
    
    
    public ArrayList<CitaMedico> citasPendientesPaciente (String codigoPaciente){
        ArrayList<CitaMedico> consultasPendientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(CITAS_MEDICAS +"CM."+CitaMedico.CODIGO_PACIENTE_DB_NAME+" = ? ORDER BY CM.fecha, CM.hora")) {
            ps.setString(1, codigoPaciente);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    consultasPendientes.add(new CitaMedico(
                            rs.getString("codigo"),
                            rs.getString("codigo_paciente"),
                            rs.getString("codigo_medico"),
                            rs.getString("especialidad_cita"),
                            rs.getString("id_especialidad"),
                            rs.getDouble("costo_consulta"),
                            rs.getDate("fecha"),
                            rs.getTime("hora")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return consultasPendientes;
    }
    
    
    public ArrayList<Examen> examenesPendientesPaciente(String codigoPaciente){
        ArrayList<Examen> examenesPendientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(CITAS_EXAMEN + Examen.CODIGO_PACIENTE_DB_NAME+" = ? ORDER BY CM.fecha, CM.hora")) {
            ps.setString(1, codigoPaciente);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    examenesPendientes.add(new Examen(
                            rs.getInt("codigo"),
                            rs.getDate("fecha"),
                            rs.getTime("hora"),
                            rs.getBoolean("requiere_orden"),
                            rs.getString("codigo_paciente"),
                            rs.getString("codigo_medico"),
                            rs.getString("codigo_tipo_examen")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return examenesPendientes;
        
    }
}
