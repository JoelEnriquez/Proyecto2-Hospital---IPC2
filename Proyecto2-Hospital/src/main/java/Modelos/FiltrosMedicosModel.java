/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import Personas.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class FiltrosMedicosModel {

    private final String NOMBRE_CON_ESPECIALIDAD = "SELECT M.* FROM MEDICO M INNER JOIN ASIGNACION_ESPECIALIDAD AE ON M.codigo=AE.codigo_medico WHERE AE.id_especialidad=? AND M.nombre LIKE=?";
    private final String NOMBRE_CON_DISPONIBILIDAD = "SELECT * FROM MEDICO WHERE horario_inicio <= ? AND horario_fin>? AND nombre LIKE ?";
    private final String ESPECIALIDAD_CON_DISPONIBILIDAD = "SELECT M.* FROM MEDICO M INNER JOIN ASIGNACION_ESPECIALIDAD AE ON M.codigo=AE.codigo_medico WHERE AE.id_especialidad=? AND M.horario_inicio <= ? AND M.horario_fin>?";
    private final String TODOS_FILTROS = NOMBRE_CON_ESPECIALIDAD+" AND M.horario_inicio <= ? AND M.horario_fin>?";

    private Connection conexion = Conexion.getConexion();
    private AsignacionEspecialidadModel asignacionModel = new AsignacionEspecialidadModel();
    private EspecialidadModel especialidadModel = new EspecialidadModel();

    public ArrayList<Medico> obtenerPorNombreDispo(String nombreMedico, Time disponibilidad) {
        ArrayList<Medico> medicosNombreDispo = new ArrayList<>();
        try (PreparedStatement st = conexion.prepareStatement(NOMBRE_CON_DISPONIBILIDAD)) {
            st.setTime(1, disponibilidad);
            st.setTime(2, disponibilidad);
            st.setString(3, nombreMedico);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    ArrayList<String> nombreEspeci = asignacionModel.especialidadesMedico(rs.getString("codigo"));
                    for (String nombreE : nombreEspeci) {
                        Medico medicoNuevo = new Medico(
                                rs.getTime("horario_inicio"),
                                rs.getTime("horario_fin"),
                                rs.getString("numero_colegiado"),
                                rs.getDate("fecha_inicio_hospital"),
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("DPI"),
                                rs.getString("password"),
                                rs.getString("telefono"),
                                rs.getString("correo_electronico"));
                        medicoNuevo.setNombreEspecialidad(nombreE);

                        medicosNombreDispo.add(medicoNuevo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicosNombreDispo;
    }

    public ArrayList<Medico> obtenerPorNombreEspecialidad(String nombreMedico, String idEspe) {
        ArrayList<Medico> medicosNombreEspecialidad = new ArrayList<>();
        try (PreparedStatement st = conexion.prepareStatement(NOMBRE_CON_ESPECIALIDAD)) {
            st.setString(1, idEspe);
            st.setString(2, nombreMedico);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Medico medicoNuevo = new Medico(
                            rs.getTime("horario_inicio"),
                            rs.getTime("horario_fin"),
                            rs.getString("numero_colegiado"),
                            rs.getDate("fecha_inicio_hospital"),
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("DPI"),
                            rs.getString("password"),
                            rs.getString("telefono"),
                            rs.getString("correo_electronico"));
                    medicoNuevo.setNombreEspecialidad(especialidadModel.nombrePorId(idEspe));

                    medicosNombreEspecialidad.add(medicoNuevo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicosNombreEspecialidad;
    }

    public ArrayList<Medico> obtenerPorEspecialidadDispo(String idEspe, Time horaDispo) {
        ArrayList<Medico> medicosEspecialidadDispo = new ArrayList<>();
        try (PreparedStatement st = conexion.prepareStatement(ESPECIALIDAD_CON_DISPONIBILIDAD)) {
            st.setString(1, idEspe);
            st.setTime(2, horaDispo);
            st.setTime(3, horaDispo);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Medico medicoNuevo = new Medico(
                            rs.getTime("horario_inicio"),
                            rs.getTime("horario_fin"),
                            rs.getString("numero_colegiado"),
                            rs.getDate("fecha_inicio_hospital"),
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("DPI"),
                            rs.getString("password"),
                            rs.getString("telefono"),
                            rs.getString("correo_electronico"));
                    medicoNuevo.setNombreEspecialidad(especialidadModel.nombrePorId(idEspe));

                    medicosEspecialidadDispo.add(medicoNuevo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        return medicosEspecialidadDispo;
    }

    public ArrayList<Medico> obtenerPorFiltros(String nombreMedico, String idEspe, Time horaDisponible) {
        ArrayList<Medico> medicosPorFiltros = new ArrayList<>();
        try (PreparedStatement st = conexion.prepareStatement(TODOS_FILTROS)) {
            st.setString(1, idEspe);
            st.setString(2, nombreMedico);
            st.setTime(3, horaDisponible);
            st.setTime(4, horaDisponible);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Medico medicoNuevo = new Medico(
                            rs.getTime("horario_inicio"),
                            rs.getTime("horario_fin"),
                            rs.getString("numero_colegiado"),
                            rs.getDate("fecha_inicio_hospital"),
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("DPI"),
                            rs.getString("password"),
                            rs.getString("telefono"),
                            rs.getString("correo_electronico"));
                    medicoNuevo.setNombreEspecialidad(especialidadModel.nombrePorId(idEspe));

                    medicosPorFiltros.add(medicoNuevo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicosPorFiltros;
    }

}
