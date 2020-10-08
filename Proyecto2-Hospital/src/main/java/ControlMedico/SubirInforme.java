/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlMedico;

import EntidadesHospital.CitaMedico;
import EntidadesHospital.InformeMedico;
import Modelos.InformeMedicoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "SubirInforme", urlPatterns = {"/SubirInforme"})
public class SubirInforme extends HttpServlet {

    private InformeMedicoModel informeMedicoModel = new InformeMedicoModel();
    private InformeMedico informeMedico;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            CitaMedico citaInforme = (CitaMedico)request.getSession().getAttribute("cita_atender");
            Date fechaInforme = citaInforme.getFechaCita();
            Time timeInforme = citaInforme.getHoraCita();
            String descripcion = request.getParameter("descripcion");
            String codigoPaciente = citaInforme.getCodigoPaciente();
            String codigoMedico = citaInforme.getCodigoMedico();
            String codigoCitaMedico = citaInforme.getCodigo();
        try {           
            informeMedico = new InformeMedico(fechaInforme, timeInforme, descripcion, codigoPaciente, codigoMedico, codigoCitaMedico);
            informeMedicoModel.crearInforme(informeMedico);
            request.setAttribute("success_info", true);
        } catch (Exception e) {
            e.getMessage();
            request.setAttribute("error_info", true);
        }
        
        request.getSession().removeAttribute("cita_atender");
        
        request.getRequestDispatcher("/Medico/RealizarInforme.jsp").forward(request, response);
    }

    

}
