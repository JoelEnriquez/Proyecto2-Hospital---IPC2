/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import ConexionDB.Conexion;
import EntidadesHospital.CitaMedico;
import EntidadesHospital.Examen;
import EntidadesHospital.InformeMedico;
import EntidadesHospital.ResultadoExamen;
import Personas.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author joel
 */
public class PacienteModel {

    private final String PACIENTES = "SELECT * FROM " + Paciente.PACIENTE_DB_NAME;
    private final String BUSCAR_PACIENTE = PACIENTES + " WHERE " + Paciente.PACIENTE_CODIGO_DB_NAME + " = ? LIMIT 1";
    private final String PACIENTES_POR_NOMBRE = PACIENTES + " WHERE " + Paciente.NOMBRE_DB_NAME + " LIKE ?";
    private final String CREAR_PACIENTE = "INSERT INTO " + Paciente.PACIENTE_DB_NAME + " (" + Paciente.NOMBRE_DB_NAME + "," + Paciente.SEXO_DB_NAME + "," + Paciente.BIRTH_DB_NAME + "," + Paciente.DPI_DB_NAME + "," + Paciente.TELEFONO_DB_NAME + "," + Paciente.PESO_DB_NAME + "," + Paciente.TIPO_SANGRE_DB_NAME + "," + Paciente.CORREO_DB_NAME + "," + Paciente.PASSWORD_DB_NAME + ") VALUES (?,?,?,?,?,?,?,?,?)";
    private final String PACIENTE_MAS_REPORTES = "SELECT codigo_paciente,COUNT(codigo_paciente) AS TOTAL FROM INFORME_MEDICO WHERE codigo_medico = ? BETWEEN ? AND ? GROUP BY codigo_paciente ORDER BY TOTAL;";

    private Connection conexion = Conexion.getConexion();

    /**
     * Se devuelve al nuevo paciente su codigo despues de ser creado
     *
     * @param paciente
     * @return
     * @throws java.lang.Exception
     */
    public long agregarPaciente(Paciente paciente) throws Exception {

        try (PreparedStatement preSt = conexion.prepareStatement(CREAR_PACIENTE, Statement.RETURN_GENERATED_KEYS)) {
            preSt.setString(1, paciente.getNombre());
            preSt.setString(2, paciente.getSexo());
            preSt.setDate(3, paciente.getFechaNacimiento());
            preSt.setString(4, paciente.getDPI());
            preSt.setString(5, paciente.getTelefono());
            preSt.setString(6, paciente.getPeso());
            preSt.setString(7, paciente.getTipoSangre());
            preSt.setString(8, paciente.getCorreoElectronico());
            preSt.setString(9, paciente.getContraseña());

            preSt.executeUpdate();

            try (ResultSet rs = preSt.getGeneratedKeys()) {
                if (rs.first()) {
                    return rs.getLong(1);
                }
            }

        } catch (Exception e) {
            throw new Exception("La informacion de los campos es muy grande");
        }
        return -1;
    }

    public List<Paciente> devolverPacientes() {
        List<Paciente> listaPacientes = new LinkedList<>();

        try (PreparedStatement ps = conexion.prepareStatement(PACIENTES);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listaPacientes.add(new Paciente(
                        rs.getString(Paciente.SEXO_DB_NAME),
                        rs.getDate(Paciente.BIRTH_DB_NAME),
                        rs.getString(Paciente.PESO_DB_NAME),
                        rs.getString(Paciente.TIPO_SANGRE_DB_NAME),
                        rs.getString(Paciente.PACIENTE_CODIGO_DB_NAME),
                        rs.getString(Paciente.NOMBRE_DB_NAME),
                        rs.getString(Paciente.DPI_DB_NAME),
                        rs.getString(Paciente.PASSWORD_DB_NAME),
                        rs.getString(Paciente.TELEFONO_DB_NAME),
                        rs.getString(Paciente.CORREO_DB_NAME)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listaPacientes;
    }

    public Paciente obtenerPaciente(int codigoPaciente) {
        Paciente paciente = null;

        try (PreparedStatement ps = conexion.prepareStatement(BUSCAR_PACIENTE)) {
            ps.setInt(1, codigoPaciente);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(
                        rs.getString(Paciente.SEXO_DB_NAME),
                        rs.getDate(Paciente.BIRTH_DB_NAME),
                        rs.getString(Paciente.PESO_DB_NAME),
                        rs.getString(Paciente.TIPO_SANGRE_DB_NAME),
                        rs.getString(Paciente.PACIENTE_CODIGO_DB_NAME),
                        rs.getString(Paciente.NOMBRE_DB_NAME),
                        rs.getString(Paciente.DPI_DB_NAME),
                        rs.getString(Paciente.PASSWORD_DB_NAME),
                        rs.getString(Paciente.TELEFONO_DB_NAME),
                        rs.getString(Paciente.CORREO_DB_NAME)
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return paciente;
    }

    /**
     * Por medio del codigo del medico y dos fechas como pivotes, es posible
     * encontrar los pacientes con mas informes existen en la aplicacion
     *
     * @param codigoMedico
     * @param intevalo1
     * @param intevalo2
     * @return
     */
    public ArrayList<Paciente> pacientesMasInformes(String codigoMedico, Date intevalo1, Date intevalo2) {
        ArrayList<Paciente> pacientesMasInformes = new ArrayList<>();
        PacienteModel pacienteModel = new PacienteModel();

        try (PreparedStatement ps = conexion.prepareStatement(PACIENTE_MAS_REPORTES)) {
            ps.setString(1, codigoMedico);
            ps.setDate(2, intevalo1);
            ps.setDate(3, intevalo2);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int codigoPaciente = rs.getInt(1);
                    int numeroInformes = rs.getInt(2);

                    Paciente paciente = pacienteModel.obtenerPaciente(codigoPaciente);
                    paciente.setNumeroInformes(numeroInformes);

                    pacientesMasInformes.add(paciente);
                }

            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return pacientesMasInformes;
    }

}
