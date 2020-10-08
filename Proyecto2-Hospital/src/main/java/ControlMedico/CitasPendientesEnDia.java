/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlMedico;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

/**
 *Se muestra una lista de citas pendientes del dia y se hace referencia para atender
 * @author joel
 */
@WebServlet(name = "CitasPendientesEnDia", urlPatterns = {"/CitasPendientesEnDia"})
public class CitasPendientesEnDia extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("codigo")==null || !request.getSession().getAttribute("persona").equals("Medico")) {
            response.sendRedirect(request.getContextPath()+"/ControlLogOut");
        }
        
        
    }

    

}
