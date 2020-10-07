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
import java.sql.Statement;

/**
 *
 * @author joel
 */
public class MedicoModel {
    
    private final String MEDICOS = "SELECT * FROM " + Medico.MEDICO_DB_NAME;
    private final String BUSCAR_MEDICO = MEDICOS + " WHERE " + Medico.MEDICO_CODIGO_DB_NAME + " = ? LIMIT 1";
    private final String MEDICOS_POR_NOMBRE = MEDICOS + " WHERE " + Medico.NOMBRE_DB_NAME + " LIKE ?";
    private final String CREAR_MEDICO = "INSERT INTO " + Medico.MEDICO_DB_NAME + " VALUES (?,?,?,?,?,?,?,?,?,?)";
   
    private Connection conexion = Conexion.getConexion();
    
    public String crearMedico(Medico medico){
        
        try (PreparedStatement preSt = conexion.prepareStatement(CREAR_MEDICO)) {
            preSt.setString(1, medico.getCodigo());
            preSt.setString(2, medico.getNombre());
            preSt.setString(3, medico.getNumeroColegiado());
            preSt.setTime(4, medico.getHoraInicio());
            preSt.setTime(5, medico.getHoraFin());
            preSt.setString(6, medico.getDPI());
            preSt.setString(7, medico.getTelefono());
            preSt.setString(8, medico.getCorreoElectronico());
            preSt.setDate(9, medico.getFechaInicioHospital());
            preSt.setString(10, medico.getContraseña());

            preSt.executeUpdate();

            return ultimoCodigoMedico();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
    
    public String ultimoCodigoMedico(){
        String query = "SELECT codigo FROM MEDICO ORDER BY codigo DESC LIMIT 1";
        
        try(Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            if (rs.first()) {
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
}
