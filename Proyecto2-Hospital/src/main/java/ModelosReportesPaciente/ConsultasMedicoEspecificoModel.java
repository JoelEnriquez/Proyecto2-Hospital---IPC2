/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosReportesPaciente;

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
public class ConsultasMedicoEspecificoModel {
    
    private final String CONSULTAS_MEDICO_ESPE_INTERVALO = "SELECT CM.* FROM CITA_MEDICO CM LEFT JOIN INFORME_MEDICO IM ON CM.codigo=IM.codigo_cita_medico WHERE CM.codigo_medico=? AND CM.codigo_paciente=? AND CM.fecha BETWEEN ? AND ?";
    
    private Connection conexion = Conexion.getConexion();
    
    public ArrayList<CitaMedico> citasMedicoEspe(String codigoMedico, String codigoPaciente, Date fecha1, Date fecha2){
        ArrayList<CitaMedico> listCitasMedicoEspe = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(CONSULTAS_MEDICO_ESPE_INTERVALO)) {
            ps.setString(1, codigoMedico);
            ps.setString(2, codigoPaciente);
            ps.setDate(3, fecha1);
            ps.setDate(4, fecha2);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    listCitasMedicoEspe.add(new CitaMedico(
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
        return listCitasMedicoEspe;
    }
}
