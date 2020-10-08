/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosComunes;

import ConexionDB.Conexion;
import EntidadesHospital.TipoExamen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class ExamenModel {

    private String TIPOS_EXAMEN = "SELECT * FROM " + TipoExamen.TIPO_EXAMEN_DB_NAME;
    private String NOMBRE_TIPO_EXAMEN_POR_CODIGO = "SELECT nombre_examen FROM "+TipoExamen.TIPO_EXAMEN_DB_NAME+" WHERE codigo=?";
    private String PENDEINTE = "SELECT TE.* FROM " + TipoExamen.TIPO_EXAMEN_DB_NAME + " TE INNER ";

    private Connection conexion = Conexion.getConexion();

    /**
     * Retornar todos los tipos de examenes existentes
     * @return 
     */
    public ArrayList<TipoExamen> listaTiposExamen() {
        ArrayList<TipoExamen> listTiposExamen = new ArrayList<>();
        
        try (Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(TIPOS_EXAMEN)) {

            while (rs.next()) {
                listTiposExamen.add(new TipoExamen(
                        String.valueOf(rs.getInt("codigo")),
                        rs.getString("nombre_examen"),
                        rs.getString("descripcion"),
                        rs.getDouble("costo"),
                        rs.getString("formato_informe")));
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listTiposExamen;
    }
    
    
    /**
     * Se obtiene el nombre de un tipo de codigo de examen en base a su nombre
     * @param codigo
     * @return 
     */
    public String nombreTipoExamenPorCodigo(String codigo){
        try(PreparedStatement ps = conexion.prepareStatement(NOMBRE_TIPO_EXAMEN_POR_CODIGO)) {
            ps.setString(1, codigo);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    return rs.getString(1);
                }
            }           
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }
}
