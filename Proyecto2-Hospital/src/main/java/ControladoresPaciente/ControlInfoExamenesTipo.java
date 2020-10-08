/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresPaciente;

import ModelosComunes.ExamenModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Serlet para poner la informacion necesaria en ExamenesTipoEspe.jsp
 * @author joel
 */
@WebServlet(name = "ControlInfoExamenesTipo", urlPatterns = {"/ControlInfoExamenesTipo"})
public class ControlInfoExamenesTipo extends HttpServlet {

    private ExamenModel examenModel = new ExamenModel();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("tipo_examenes", examenModel.listaTiposExamen());
                
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Paciente/ExamenesTipoEspe.jsp");
        requestDispatcher.forward(request, response);
    }

}
