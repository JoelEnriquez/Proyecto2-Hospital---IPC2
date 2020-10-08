/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelMedico;

import ConexionDB.Conexion;
import EntidadesHospital.CitaMedico;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class ConsultasAgendadasIntervalo {
    
    private final String CITAS_AGENDADAS_INTERVALO = "SELECT * FROM CITA_MEDICO WHERE fecha BETWEEN ? AND ? AND codigo_medico=?";

    private Connection conexion = Conexion.getConexion();


    public ArrayList<CitaMedico> listaCitasIntervalo (String codigoMedico, Date fecha1, Date fecha2){
        
        ArrayList<CitaMedico> listaCitas = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(CITAS_AGENDADAS_INTERVALO)) {
            ps.setDate(1, fecha1);
            ps.setDate(2, fecha2);
            ps.setString(3, codigoMedico);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    listaCitas.add(new CitaMedico(
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
        }
        return listaCitas;
    }
}


