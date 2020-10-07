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
public class ModelHistorialMedico {
    
    private final String HISTORIAL_CONSULTAS = "SELECT CM.* FROM " + CitaMedico.CITA_MEDICO_DB_NAME + " CM INNER JOIN " + InformeMedico.INFORME_MEDICO_DB_NAME + " IM ON CM.codigo=IM.codigo_cita_medico ";
    private final String HISTORIAL_EXAMENES = "SELECT E.* FROM " + Examen.EXAMEN_DB_NAME + " E INNER JOIN " + ResultadoExamen.RESULTADO_EXAMEN_DB_NAME + " RE ON E.codigo=RE.codigo_examen ";
    private final String HISTORIAL_CONSULTAS_PERSONAL = HISTORIAL_CONSULTAS + "WHERE CM.codigo_paciente = ? ORDER BY CM.fecha, CM.hora";
    private final String HISTORIAL_EXAMENES_PERSONAL = HISTORIAL_EXAMENES + "WHERE E.codigo_paciente = ? ORDER BY E.fecha, E.hora";

    private Connection conexion = Conexion.getConexion();

    public ArrayList<Examen> obtenerExamenesPacientes() {
        ArrayList<Examen> examenesPacientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(HISTORIAL_EXAMENES + "ORDER BY E.fecha, E.hora")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    examenesPacientes.add(new Examen(
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
        return examenesPacientes;
    }

    public ArrayList<Examen> obtenerExamenesEspecificos(String codigoPaciente) {
        ArrayList<Examen> examenesPacientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(HISTORIAL_EXAMENES_PERSONAL)) {
            ps.setString(1, codigoPaciente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    examenesPacientes.add(new Examen(
                            rs.getInt("codigo"),
                            rs.getDate("fecha"),
                            rs.getTime("hora"),
                            rs.getBoolean("requiere_orden"),
                            rs.getString("codigo_paciente"),
                            rs.getString("codigo_medico"),
                            rs.getString("codigo_tipo_examen")));
                }
                //return examenesPacientes;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return examenesPacientes;

    }

    public ArrayList<CitaMedico> obtenerCitasMedicasPacientes() {
        ArrayList<CitaMedico> consultasPacientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(HISTORIAL_EXAMENES + "ORDER BY E.fecha, E.hora")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    consultasPacientes.add(new CitaMedico(
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
        return consultasPacientes;
    }

    public ArrayList<CitaMedico> obtenerCitasMedicasEspecificos(String codigoPaciente) {
        ArrayList<CitaMedico> consultasPacientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(HISTORIAL_CONSULTAS_PERSONAL)) {
            ps.setString(1, codigoPaciente);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    consultasPacientes.add(new CitaMedico(
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
        return consultasPacientes;
    }
}
