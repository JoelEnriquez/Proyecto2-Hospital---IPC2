/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesHospital.InformeMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joel
 */
public class InformeMedicoModel {
    
    private final String CREAR_INFORME_MEDICO = "INSERT INTO "+InformeMedico.INFORME_MEDICO_DB_NAME+" (fecha,hora,descripcion,codigo_paciente,codigo_medico,codigo_cita_medico) VALUES (?,?,?,?,?,?)";
            
    private Connection conexion = Conexion.getConexion();
    
    /**
     * Se crea un informe para saber la informacion del examen y asegurarnos que ya fue hecho
     * @param informe
     * @throws Exception 
     */
    public void crearInforme(InformeMedico informe) throws Exception{
        try(PreparedStatement ps = conexion.prepareStatement(CREAR_INFORME_MEDICO)) {
            ps.setDate(1, informe.getFechaInforme());
            ps.setTime(2, informe.getHoraInforme());
            ps.setString(3, informe.getDescripcionInforme());
            ps.setInt(4, Integer.parseInt(informe.getCodigoPaciente()));
            ps.setString(5, informe.getCodigoMedico());
            ps.setInt(6, Integer.parseInt(informe.getCodigoCitaMedico()));
            
            ps.execute();
        } catch (SQLException ex) {
           throw new Exception("El informe contiene muchas lineas de texto");
        }
        
    }
}
