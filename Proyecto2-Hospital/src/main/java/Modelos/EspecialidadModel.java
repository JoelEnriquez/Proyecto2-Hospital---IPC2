/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesAsignacion.Especialidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class EspecialidadModel {

    private final String COSTO_ESPECIALIDAD_POR_ID = "SELECT "+ Especialidad.COSTO_CONSULTA_DB_NAME + " FROM "+ Especialidad.ESPECIALIDAD_DB_NAME +" WHERE "+ Especialidad.ESPECIALIDAD_ID_DB_NAME + "=?";
    private final String ESPECIALIDADES = "SELECT E.* FROM " + Especialidad.ESPECIALIDAD_DB_NAME + " E";
    private final String ESPECIALIDADES_MEDICO = ESPECIALIDADES + " INNER JOIN ASIGNACION_ESPECIALIDAD AE ON E.id=AE.id_especialidad WHERE AE.codigo_medico = ?";
    private final String ID_ESPECIALIDAD_POR_NOMBRE = "SELECT " + Especialidad.ESPECIALIDAD_ID_DB_NAME + " FROM " + Especialidad.ESPECIALIDAD_DB_NAME + " WHERE " + Especialidad.NOMBRE_DB_NAME + "=?";
    private final String NOMBRE_ESPECIALIDAD_POR_ID = "SELECT " + Especialidad.NOMBRE_DB_NAME + " FROM " + Especialidad.ESPECIALIDAD_DB_NAME + " WHERE " + Especialidad.ESPECIALIDAD_ID_DB_NAME + "=?";
    private final String ESPECIALIDAD_POR_NOMBRE = ESPECIALIDADES+" WHERE E.nombre = ?";
    private final String ESPECIALIDAD_POR_ID = ESPECIALIDADES+" WHERE E.id = ?";

    private Connection conexion = Conexion.getConexion();

    public String idEspecialidadPorNombre(String nombreEspecialidad) {
        try (PreparedStatement ps = conexion.prepareStatement(ID_ESPECIALIDAD_POR_NOMBRE)) {
            ps.setString(1, nombreEspecialidad);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.first()) {
                    return rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    public String nombrePorId(String idEspecialidad) {
        try (PreparedStatement ps = conexion.prepareStatement(NOMBRE_ESPECIALIDAD_POR_ID)) {
            ps.setString(1, idEspecialidad);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getString(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    /**
     * Obtener todas las especialidades existentes
     *
     * @return
     */
    public ArrayList<Especialidad> obtenerEspecialidades() {
        ArrayList<Especialidad> listEspecialidades = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery(ESPECIALIDADES)) {
                while (rs.next()) {
                    listEspecialidades.add(new Especialidad(
                            String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getDouble(3)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listEspecialidades;
    }

    public ArrayList<Especialidad> obtenerEspecialidadesMedico(String codigoMedico) {
        ArrayList<Especialidad> especialidadesMedico = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(ESPECIALIDADES_MEDICO)) {
            ps.setString(1, codigoMedico);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    especialidadesMedico.add(new Especialidad(
                            String.valueOf(rs.getInt(1)),
                            rs.getString(2),
                            rs.getDouble(3)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return especialidadesMedico;
    }
    
    public Especialidad obtenerPorNombre(String nombreEspecialidad){
        
        try(PreparedStatement ps = conexion.prepareStatement(ESPECIALIDAD_POR_NOMBRE)) {
            ps.setString(1, nombreEspecialidad);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Especialidad(rs.getString(1), rs.getString(2), rs.getDouble(3));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Especialidad obtenerPorId(String idEspecialidad){
        
        try(PreparedStatement ps = conexion.prepareStatement(ESPECIALIDAD_POR_ID)) {
            ps.setInt(1, Integer.parseInt(idEspecialidad));
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return new Especialidad(rs.getString(1), rs.getString(2), rs.getDouble(3));
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
}
