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
@WebServlet(name = "ControlHistorialMP", urlPatterns = {"/ControlHistorialMP"})
public class ControlHistorialMP extends HttpServlet {

    private ModelHistorialMedico historialMM = new ModelHistorialMedico();    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String codigoPaciente = request.getSession().getAttribute("codigo").toString();
            if (codigoPaciente!=null) {
                //Se obtienen las consultas y examenes del Paciente en base a su codigo
                request.setAttribute("examenes", historialMM.obtenerExamenesEspecificos(codigoPaciente));
                request.setAttribute("consultas", historialMM.obtenerCitasMedicasEspecificos(codigoPaciente));
                RequestDispatcher requestD = request.getRequestDispatcher("/Paciente/HistorialMedicoPaciente.jsp");
                requestD.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace(System.out);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
