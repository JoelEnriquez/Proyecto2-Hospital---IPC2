/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosComunes;

import ConexionDB.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author joel
 */
public class FechaTrabajo {

    private Connection conexion = Conexion.getConexion();

    private final String CONSULTA_A_REALIZAR = "SELECT CM.fecha FROM CITA_MEDICO CM LEFT JOIN INFORME_MEDICO IM ON CM.codigo=IM.codigo_cita_medico WHERE IM.codigo_cita_medico IS NULL AND CM.codigo_medico=? ORDER BY fecha LIMIT 1";
    private final String EXAMEN_A_REALIZAR = "SELECT E.fecha FROM EXAMEN E LEFT JOIN RESULTADO_EXAMEN RE ON E.codigo=RE.codigo_cita_medico WHERE RE.codigo_cita_medico IS NULL ORDER BY fecha LIMIT 1";

    /**
     * Returna la consulta examen mas proxima para no saltarla
     * @return 
     */
    public Date examenPendienteARealizar() {
        String query = EXAMEN_A_REALIZAR;
        try (Statement st = conexion.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            if (rs.first()) {
                return rs.getDate(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Se obtiene la consulta mas reciente que tiene que hacer el medico para no
     * saltarla
     *
     * @param codigoMedico
     * @return
     */
    public Date consultaPendienteRealizar(String codigoMedico) {
        String query = CONSULTA_A_REALIZAR;

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigoMedico);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.first()) {
                    return rs.getDate(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
