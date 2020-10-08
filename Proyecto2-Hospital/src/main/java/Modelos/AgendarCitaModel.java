/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesAsignacion.Especialidad;
import EntidadesHospital.CitaMedico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */
public class AgendarCitaModel {
    
    private final String CITA_EXISTENTE = "SELECT COUNT(*) FROM CITA_MEDICO WHERE "+CitaMedico.CODIGO_MEDICO_DB_NAME+"=? AND "+CitaMedico.FECHA_DB_NAME+"=? AND "+CitaMedico.HORA_DB_NAME+"=?";
    private final String CREAR_CITA = "INSERT INTO "+ CitaMedico.CITA_MEDICO_DB_NAME +" (fecha, hora, codigo_paciente, codigo_medico, id_especialidad, especialidad_cita, costo_consulta) VALUES (?,?,?,?,?,?,?)";
    private final String ESPECIALIDADES_MEDICO = "SELECT E.* FROM ESPECIALIDAD E INNER JOIN ASIGNACION_ESPECIALIDAD AE WHERE E.id = AE.id_especialidad WHERE AE.codigo_medico = ?";

    private Connection conexion = Conexion.getConexion();
 
    
    public ArrayList<Especialidad> listadoEspecialidadesMedico() {

        try (PreparedStatement ps = conexion.prepareStatement(ESPECIALIDADES_MEDICO)) {
            try(ResultSet rs = ps.executeQuery()){  
            
            ArrayList<Especialidad> listaEspecialidades = new ArrayList<>();
            while (rs.next()) {
                listaEspecialidades.add(new Especialidad(
                        String.valueOf(rs.getInt(1)),
                        rs.getString(2),
                        rs.getDouble(3)));
            }
                return listaEspecialidades;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    /**
     * En base a los atributos de crear cita se almacenan en la base de datos
     * @param citaMedico 
     */
    public void crearCita(CitaMedico citaMedico){
        try(PreparedStatement ps = conexion.prepareStatement(CREAR_CITA)) {
            ps.setDate(1, citaMedico.getFechaCita());
            ps.setTime(2, citaMedico.getHoraCita());
            ps.setInt(3, Integer.parseInt(citaMedico.getCodigoPaciente()));
            ps.setString(4, citaMedico.getCodigoMedico());
            ps.setInt(5, Integer.parseInt(citaMedico.getIdEspecialidad()));
            ps.setString(6, citaMedico.getNombreEspecialidad());
            ps.setDouble(7, citaMedico.getCostoConsulta());
            
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    /**
     * Nos devulve 1 si ya hay una cita y 0 si no la hay
     * @param codigoMedico
     * @param fecha
     * @param hora
     * @return 
     */
    public int citaReservada(String codigoMedico, Date fecha, Time hora){
        try(PreparedStatement ps = conexion.prepareStatement(CITA_EXISTENTE)) {
            ps.setString(1, codigoMedico);
            ps.setDate(2, fecha);
            ps.setTime(3, hora);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return 0;
    }

}
