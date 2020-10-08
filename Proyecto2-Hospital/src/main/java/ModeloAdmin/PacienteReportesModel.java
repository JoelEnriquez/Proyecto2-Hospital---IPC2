/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloAdmin;

import ConexionDB.Conexion;
import EntidadesHospital.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class PacienteReportesModel {
    
    private final String ULTIMOS_5_EXAMENES_LAB= "SELECT E.* ESPECIALIDAD E INNER JOIN RESULTADO_EXAMEN RE ON E.codigo=RE.codigo_examen WHERE E.codigo_paciente = ?";
    
    private Connection conexion = Conexion.getConexion();
    
    
    public ArrayList<Examen> ultimosExamenLaboratorio(String codigoPaciente){
        
        ArrayList<Examen> ultimosExamenesLab = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(ULTIMOS_5_EXAMENES_LAB)) {
            ps.setString(1, codigoPaciente);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    ultimosExamenesLab.add(new Examen(
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
        return ultimosExamenesLab;       
    }
}
