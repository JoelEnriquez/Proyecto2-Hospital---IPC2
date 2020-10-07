/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import ModelosComunes.ModelCitasPendientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "ControladorCitasPenPaci", urlPatterns = {"/ControladorCitasPenPaci"})
public class ControladorCitasPenPaci extends HttpServlet {

    private ModelCitasPendientes citasPendientes = new ModelCitasPendientes();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String codigoPaciente = request.getSession().getAttribute("codigo").toString();
            if (codigoPaciente!=null) {
                //Se obtienen las consultas y examenes del Paciente en base a su codigo
                request.setAttribute("consultasPen", citasPendientes.citasPendientesPaciente(codigoPaciente));

                RequestDispatcher requestD = request.getRequestDispatcher("/Paciente/ConsultasPendientes.jsp");
                requestD.forward(request, response);
            }
        } catch (Exception e) {
            
        }
    }

    

}
