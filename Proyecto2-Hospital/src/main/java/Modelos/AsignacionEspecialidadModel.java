/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class AsignacionEspecialidadModel {
    
    private final String NOMBRE_ESPECIALIDADES_CODIGO = "SELECT E.nombre FROM ESPECIALIDAD E INNER JOIN ASIGNACION_ESPECIALIDAD AE ON E.id=AE.id_especialidad WHERE AE.codigo_medico=?";
    
    private Connection conexion = Conexion.getConexion();
    
    
    public ArrayList<String> especialidadesMedico(String codigoMedico){
        ArrayList<String> listadoEspecialidades = new ArrayList<>();
        
        try(PreparedStatement ps = conexion.prepareStatement(NOMBRE_ESPECIALIDADES_CODIGO)) {
            ps.setString(1, codigoMedico);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    listadoEspecialidades.add(rs.getString(1));
                }
            }
         
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listadoEspecialidades;
    }
}
