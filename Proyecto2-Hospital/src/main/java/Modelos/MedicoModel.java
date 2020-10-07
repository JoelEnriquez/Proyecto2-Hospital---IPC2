/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Personas.Medico;

/**
 *
 * @author joel
 */
public class MedicoModel {
    
    private final String MEDICOS = "SELECT * FROM " + Medico.MEDICO_DB_NAME;
    private final String BUSCAR_MEDICO = MEDICOS + " WHERE " + Medico.MEDICO_CODIGO_DB_NAME + " = ? LIMIT 1";
    private final String PACIENTES_POR_NOMBRE = PACIENTES + " WHERE " + Paciente.NOMBRE_DB_NAME + " LIKE ?";
    private final String CREAR_PACIENTE = "INSERT INTO " + Paciente.PACIENTE_DB_NAME + " (" + Paciente.NOMBRE_DB_NAME + "," + Paciente.SEXO_DB_NAME + "," + Paciente.BIRTH_DB_NAME + "," + Paciente.DPI_DB_NAME + "," + Paciente.TELEFONO_DB_NAME + "," + Paciente.PESO_DB_NAME + "," + Paciente.TIPO_SANGRE_DB_NAME + "," + Paciente.CORREO_DB_NAME + "," + Paciente.PASSWORD_DB_NAME + ") VALUES (?,?,?,?,?,?,?,?,?)";

    private Connection conexion = Conexion.getConexion();
}
