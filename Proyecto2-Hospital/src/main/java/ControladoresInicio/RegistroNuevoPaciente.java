/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresInicio;

import Encriptar.Encriptacion;
import Modelos.PacienteModel;
import Personas.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "RegistroNuevoPaciente", urlPatterns = {"/RegistroNuevoPaciente"})
public class RegistroNuevoPaciente extends HttpServlet {

    private PacienteModel pacienteModel = new PacienteModel();
    private Encriptacion encriptar = new Encriptacion();
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fecha_nacimiento"));
        String peso = request.getParameter("peso");
        String tipoSangre = request.getParameter("tipo_sangre");
        String DPI = request.getParameter("DPI");
        String contra = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        String correoElectronico = request.getParameter("correo");
        String contraseña = null;
        try {
            contraseña = encriptar.encriptar(contra);
        } catch (Exception e) {
            e.getMessage();
        }      
                
        Paciente paciente = new Paciente(sexo, fechaNacimiento, peso, tipoSangre, nombre, DPI, contraseña, telefono, correoElectronico);
        try {
            long codigoReciente = pacienteModel.agregarPaciente(paciente);
            request.setAttribute("complete", codigoReciente);
        } catch (Exception e) {
            request.setAttribute("mensaje_error", e.getMessage());
        }
        
        request.getRequestDispatcher("/Inicio/RegistroPacientes.jsp").forward(request, response);
    }

    

}
