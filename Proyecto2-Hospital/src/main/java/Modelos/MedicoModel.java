package Modelos;

import ConexionDB.Conexion;
import Personas.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author joel
 */
public class MedicoModel {

    private final String MEDICOS = "SELECT * FROM " + Medico.MEDICO_DB_NAME;
    private final String NOMBRE_MEDICO = "SELECT nombre FROM "+ Medico.MEDICO_DB_NAME+" WHERE codigo=?";
    private final String MEDICOS_POR_NOMBRE = MEDICOS + " WHERE " + Medico.NOMBRE_DB_NAME + " LIKE ?";
    private final String MEDICOS_CON_ESPECIALIDAD = "SELECT M.* FROM MEDICO M INNER JOIN ASIGNACION_ESPECIALIDAD AE ON M.codigo=AE.codigo_medico WHERE AE.id_especialidad=?";
    private final String MEDICOS_POR_DISPONIBILIDAD = "SELECT * FROM " + Medico.MEDICO_DB_NAME + " WHERE horario_inicio<=? AND horario_fin>?";
    private final String CREAR_MEDICO = "INSERT INTO " + Medico.MEDICO_DB_NAME + " VALUES (?,?,?,?,?,?,?,?,?,?)";

    private Connection conexion = Conexion.getConexion();
    private EspecialidadModel especialidadModel = new EspecialidadModel();
    private AsignacionEspecialidadModel asignacionModel = new AsignacionEspecialidadModel();

    public String crearMedico(Medico medico) {

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
    
    public String nombreMedico(String codigoMedico){
        try(PreparedStatement ps = conexion.prepareStatement(NOMBRE_MEDICO)) {
            ps.setString(1, codigoMedico);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    return rs.getString(1);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    /**
     * Nos devulve 1 si el medico existe y 0 si no existe
     * @param codigo
     * @return 
     */
    public int medicoExixtente(String codigo) {
        String query = "SELECT COUNT(*) FROM MEDICO WHERE codigo = ?";
        int contador = 0;
        
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    contador = rs.getInt(1);
                }             
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return contador;
    }

    public String ultimoCodigoMedico() {
        String query = "SELECT codigo FROM MEDICO ORDER BY codigo DESC LIMIT 1";

        try (Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            if (rs.first()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "";
    }

    public ArrayList<Medico> listaMedicos() {
        ArrayList<Medico> listadoMedicos = new ArrayList<>();

        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery(MEDICOS)) {
                while (rs.next()) {
                    ArrayList<String> nombreEspeci = asignacionModel.especialidadesMedico(rs.getString("codigo"));
                    for (String nombreE : nombreEspeci) {
                        Medico medicoNuevo = new Medico(
                                rs.getTime("horario_inicio"),
                                rs.getTime("horario_fin"),
                                rs.getString("numero_colegiado"),
                                rs.getDate("fecha_inicio_hospital"),
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("DPI"),
                                rs.getString("password"),
                                rs.getString("telefono"),
                                rs.getString("correo_electronico"));
                        medicoNuevo.setNombreEspecialidad(nombreE);

                        listadoMedicos.add(medicoNuevo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listadoMedicos;
    }

    public ArrayList<Medico> buscarConNombre(String nombre) {
        ArrayList<Medico> medicosConNombre = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(MEDICOS_POR_NOMBRE)) {
            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArrayList<String> nombreEspeci = asignacionModel.especialidadesMedico(rs.getString("codigo"));
                    for (String nombreE : nombreEspeci) {
                        Medico medicoNuevo = new Medico(
                                rs.getTime("horario_inicio"),
                                rs.getTime("horario_fin"),
                                rs.getString("numero_colegiado"),
                                rs.getDate("fecha_inicio_hospital"),
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("DPI"),
                                rs.getString("password"),
                                rs.getString("telefono"),
                                rs.getString("correo_electronico"));
                        medicoNuevo.setNombreEspecialidad(nombreE);

                        medicosConNombre.add(medicoNuevo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicosConNombre;
    }

    public ArrayList<Medico> buscarPorEspecialidad(String idEspecialidad) {
        ArrayList<Medico> medicosConEspecialidad = new ArrayList<>();

        if (!especialidadModel.idEspecialidadPorNombre(idEspecialidad).equals("General")) { //No incluimos consultas generales
            try (PreparedStatement ps = conexion.prepareStatement(MEDICOS_CON_ESPECIALIDAD)) {
                ps.setString(1, idEspecialidad);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Medico medicoNuevo = new Medico(
                                rs.getTime("horario_inicio"),
                                rs.getTime("horario_fin"),
                                rs.getString("numero_colegiado"),
                                rs.getDate("fecha_inicio_hospital"),
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("DPI"),
                                rs.getString("password"),
                                rs.getString("telefono"),
                                rs.getString("correo_electronico"));
                        medicoNuevo.setNombreEspecialidad(especialidadModel.nombrePorId(idEspecialidad));

                        medicosConEspecialidad.add(medicoNuevo);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        return medicosConEspecialidad;
    }

    public ArrayList<Medico> buscarPorDisponibilidad(Time horaDisponible) {
        ArrayList<Medico> medicosPorDisponibilidad = new ArrayList<>();

        //Comprobamos en base a su horario
        try (PreparedStatement ps = conexion.prepareStatement(MEDICOS_POR_DISPONIBILIDAD)) {
            ps.setTime(1, horaDisponible);
            ps.setTime(2, horaDisponible);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ArrayList<String> nombreEspeci = asignacionModel.especialidadesMedico(rs.getString("codigo"));
                    for (String nombreE : nombreEspeci) {
                        Medico medicoNuevo = new Medico(
                                rs.getTime("horario_inicio"),
                                rs.getTime("horario_fin"),
                                rs.getString("numero_colegiado"),
                                rs.getDate("fecha_inicio_hospital"),
                                rs.getString("codigo"),
                                rs.getString("nombre"),
                                rs.getString("DPI"),
                                rs.getString("password"),
                                rs.getString("telefono"),
                                rs.getString("correo_electronico"));
                        medicoNuevo.setNombreEspecialidad(nombreE);

                        medicosPorDisponibilidad.add(medicoNuevo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return medicosPorDisponibilidad;
    }
}
