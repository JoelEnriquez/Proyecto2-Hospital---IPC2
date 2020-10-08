/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresAdmin;

import ModeloAdmin.Reportes;
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
 *Se obtiene una lista de los medicos que mas informes tienen en un intervalo de tiempo
 * @author joel
 */
@WebServlet(name = "MedicosMayorInformes", urlPatterns = {"/MedicosMayorInformes"})
public class MedicosMayorInformes extends HttpServlet {

    private Reportes reportes = new Reportes();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fechaI = request.getParameter("intervalo_1");
        String fechaF = request.getParameter("intervalo_2");
        
        request.setAttribute("med_mas_informes", reportes.obtenerMedicosMayorInformes(fechaI,fechaF));
        request.getRequestDispatcher("/Admin/MedicosMayoresInformes.jsp").forward(request, response);       
    }

}
