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
public class CitasPendientesModel {

    private final String CITAS_MEDICAS = "SELECT CM.* FROM " + CitaMedico.CITA_MEDICO_DB_NAME + " CM";
    private final String CITAS_PENDIENTES_DIA = CITAS_MEDICAS + " LEFT JOIN INFORME_MEDICO IM ON CM.codigo=IM.codigo_cita_medico WHERE IM.codigo_cita_medico IS NULL AND CM.codigo_medico=? AND fecha=?";

    private Connection conexion = Conexion.getConexion();

    public ArrayList<CitaMedico> getCitasPendientesDia(String codigoMedico, Date diaTrabajo) throws Exception {
        ArrayList<CitaMedico> citasPendientes = new ArrayList<>();
        try (PreparedStatement ps = conexion.prepareStatement(CITAS_PENDIENTES_DIA)) {
            ps.setString(1, codigoMedico);
            ps.setDate(2, diaTrabajo);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    citasPendientes.add(new CitaMedico(
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
            throw new Exception("No concuerdan los datos con lo solicitado");
        }
        return citasPendientes;
    }

}
