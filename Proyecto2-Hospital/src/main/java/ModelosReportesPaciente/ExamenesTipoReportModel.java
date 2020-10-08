/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosReportesPaciente;

import ConexionDB.Conexion;
import EntidadesHospital.Examen;
import EntidadesHospital.TipoExamen;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class ExamenesTipoReportModel {
    
    private final String EXAMENES_TIPO_INTERVALO = "SELECT E.* FROM "+Examen.EXAMEN_DB_NAME+" E INNER JOIN "+TipoExamen.TIPO_EXAMEN_DB_NAME+" TE ON E.codigo_tipo_examen=TE.codigo WHERE E."+Examen.CODIGO_TIPO_EXAMEN_DB_NAME+"=? AND E."+Examen.CODIGO_PACIENTE_DB_NAME+"=? AND E."+Examen.FECHA_DB_NAME+ " BETWEEN ? AND ?";
    
    private Connection conexion = Conexion.getConexion();
    
    
    /**
     * En base a dichos atributos filtrar la busqueda, para obtener los examenes de un tipo en intervalo
     * @param codigoPaciente
     * @param tipoExamen
     * @param intervalo1
     * @param intervalo2
     * @return 
     */
    public ArrayList<Examen> examenesTipoIntervalo(String codigoPaciente, int tipoExamen, Date intervalo1, Date intervalo2){
        ArrayList<Examen> examenesTipoInter = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(EXAMENES_TIPO_INTERVALO)) {
            ps.setInt(1, tipoExamen);
            ps.setString(2, codigoPaciente);
            ps.setDate(3, intervalo1);
            ps.setDate(4, intervalo2);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    examenesTipoInter.add(new Examen(
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
        return examenesTipoInter;
    }
}
