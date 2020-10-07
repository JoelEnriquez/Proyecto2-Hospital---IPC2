/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import ModelosComunes.ModelHistorialMedico;
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
@WebServlet(name = "ControladorUltimosExamenes", urlPatterns = {"/ControladorUltimosExamenes"})
public class ControladorUltimosExamenes extends HttpServlet {

    private ModelHistorialMedico historialMedico = new ModelHistorialMedico();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String codigoPaciente = request.getSession().getAttribute("codigo").toString();
        if (codigoPaciente != null) {

            request.setAttribute("ultimos_examenes", historialMedico.ultimosExamenes(codigoPaciente));

            RequestDispatcher requestD = request.getRequestDispatcher("/Paciente/UltimosExamenes.jsp");
            requestD.forward(request, response);
        } else {
            throw new Exception("No existe codigo en la sesion");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
