/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresMedico;

import Modelos.PacienteModel;
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
@WebServlet(name = "PacientesMayorInformes", urlPatterns = {"/PacientesMayorInformes"})
public class PacientesMayorInformes extends HttpServlet {

   private PacienteModel paciente = new PacienteModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Date fecha1 = Date.valueOf(request.getParameter("intervalo_1"));
        Date fecha2 = Date.valueOf(request.getParameter("intervalo_2"));
        if (fecha1.compareTo(fecha2)>0) {
            request.setAttribute("wrong_time", true);
        }
        else{
        request.setAttribute("list_pacientes", paciente.pacientesMasInformes(request.getSession().getAttribute("codigo").toString(), fecha1, fecha2));
        }
        request.getRequestDispatcher("/Medico/PacientesMayorCantidadInformes.jsp").forward(request, response);
    }


}
