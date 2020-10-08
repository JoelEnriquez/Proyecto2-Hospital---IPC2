/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresPaciente;

import Modelos.EspecialidadModel;
import Modelos.MedicoModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "ControladorEspecialidades", urlPatterns = {"/ControladorEspecialidades"})
public class ControladorEspecialidades extends HttpServlet {

    
    private EspecialidadModel especialidadModel = new EspecialidadModel();
    private MedicoModel medicoModel = new MedicoModel();
    /**
     * Redirigir con todas las especialidades existentes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        if (request.getSession().getAttribute("codigo")!=null) {
            request.setAttribute("especialidades", especialidadModel.obtenerEspecialidades());
            request.setAttribute("medicos", medicoModel.listaMedicos());
            
            request.getRequestDispatcher("/Paciente/AgendarConsulta.jsp").forward(request, response);
        }
    }

}
