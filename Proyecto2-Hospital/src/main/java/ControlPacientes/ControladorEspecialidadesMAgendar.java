/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import Modelos.EspecialidadModel;
import Modelos.MedicoModel;
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
@WebServlet(name = "ControladorEspecialidadesMAgendar", urlPatterns = {"/ControladorEspecialidadesMAgendar"})
public class ControladorEspecialidadesMAgendar extends HttpServlet {

    EspecialidadModel especialidadModel = new EspecialidadModel();
    MedicoModel medicoModel = new MedicoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String codigoMedico = request.getParameter("codigoMedico");
            if (medicoModel.medicoExixtente(codigoMedico)==1) {
                request.setAttribute("especialidades_medico", especialidadModel.obtenerEspecialidadesMedico(codigoMedico));
                request.setAttribute("consulta_general", especialidadModel.obtenerPorNombre("General"));
                request.getSession().setAttribute("codigo_medico", codigoMedico);
            }
            else{
                request.setAttribute("codigoIncorrecto", true);
                if (request.getSession().getAttribute("codigo_medico")!=null) {
                    request.getSession().removeAttribute("codigo_medico");
                }               
            }
            
            RequestDispatcher requestDispat = request.getRequestDispatcher("Paciente/AgendarConsulta.jsp");
            requestDispat.forward(request, response);

        } catch (Exception e) {
            System.out.println("No se pudo obtener los datos del medico");
        }
    }

}
