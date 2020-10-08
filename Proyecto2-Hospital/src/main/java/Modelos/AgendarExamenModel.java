/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesHospital.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author joel
 */
public class AgendarExamenModel {
    
    private final String CREAR_EXAMEN = "INSERT INTO "+Examen.EXAMEN_CODIGO_DB_NAME+ " (fecha,hora,require_orden,codigo_paciente,codigo_tipo_examen) VALUES (?,?,?,?,?)";
    private final String CREAR_EXAMEN_ORDEN = "INSERT INTO "+Examen.EXAMEN_CODIGO_DB_NAME+" VALUES (?,?,?,?,?,?)";
    
    private Connection conexion = Conexion.getConexion();
    
    public void crearExamenSinOrden(Examen examen){
        try(PreparedStatement ps = conexion.prepareStatement(CREAR_EXAMEN)) {
            ps.setDate(1, examen.getFechaCita());
            ps.setTime(2, examen.getHoraCita());
            ps.setBoolean(3, examen.getRequiereOrden());
            ps.setInt(4, Integer.parseInt(examen.getCodigoPaciente()));
            ps.setInt(5, Integer.parseInt(examen.getCodigoTipoExamen()));
            
            ps.execute();            
            
        } catch (Exception e) {
            System.out.println("No se pudo generar el examen");
        }
    }
    
    public void crearExamenConOrden(Examen examen){
        try(PreparedStatement ps = conexion.prepareStatement(CREAR_EXAMEN)) {
            ps.setDate(1, examen.getFechaCita());
            ps.setTime(2, examen.getHoraCita());
            ps.setBoolean(3, examen.getRequiereOrden());
            ps.setInt(4, Integer.parseInt(examen.getCodigoPaciente()));
            ps.setString(5, examen.getCodigoMedico());
            ps.setInt(6, Integer.parseInt(examen.getCodigoTipoExamen()));
            
            ps.execute();            
            
        } catch (Exception e) {
            System.out.println("No se pudo generar el examen");
        }
    }
}
