/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloAdmin;

import ConexionDB.Conexion;
import Personas.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * TODOS LOS REPORTES SON CON INTERVALO DE TIEMPO
 *
 * @author joel
 */
public class Reportes {

    private final String INGRESOS_POR_MEDICO_INTERVALO = "SELECT SUM(costo_consulta) AS TOTAL FROM CITA_MEDICO WHERE codigo_medico = ? BETWEEN ? AND ?";
    private final String MEDICOS_MAYOR_INFORMES = "SELECT * FROM MEDICO WHERE codigo = (SELECT codigo_medico FROM INFORME_MEDICO WHERE fecha BETWEEN ? AND ? GROUP BY codigo_medico LIMIT 10)";
    private final String MEDICOS_MENOR_CANTIDAD_CITAS = ""; //5 medicos
    private final String INGRESOS_POR_PACIENTE = "";
    private final String EXAMENES_LAB_MAYOR_DEMANDADOS = "";
    private final String MEDICOS_MAS_EXAMENES_REQUIEREN = "";
    private final String EXAMENES_MAS_REQUERIDOS_POR_MEDICOS = "";
    
    private Connection conexion = Conexion.getConexion();

    public ArrayList<Medico> obtenerMedicosMayorInformes(String fecha_inicio, String fecha_final) {
        ArrayList<Medico> medicos = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(MEDICOS_MAYOR_INFORMES)) {
            ps.setString(1, fecha_inicio);
            ps.setString(2, fecha_final);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    medicos.add(new Medico(
                            rs.getTime("horario_inicio"),
                            rs.getTime("horario_fin"),
                            rs.getString("numero_colegiado"),
                            rs.getDate("fecha_inicio_hospital"),
                            rs.getString("codigo"),
                            rs.getString("nombre"),
                            rs.getString("DPI"),
                            rs.getString("password"),
                            rs.getString("telefono"),
                            rs.getString("correo_electronico"))
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicos;
    }

    public String obtenerIngresosMedico(String codigo_medico, String fecha_inicio, String fecha_final) {
        String total = "";
        try (PreparedStatement ps = conexion.prepareStatement(INGRESOS_POR_MEDICO_INTERVALO)) {
            ps.setString(1, fecha_inicio);
            ps.setString(1, fecha_final);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    total = rs.getString("TOTAL");
                }
            }

        } catch (Exception e) {
        }
        return total;
    }

}
