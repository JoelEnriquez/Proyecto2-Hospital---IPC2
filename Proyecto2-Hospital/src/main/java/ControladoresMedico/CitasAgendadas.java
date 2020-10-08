/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresMedico;

import ModelMedico.ConsultasAgendadasIntervalo;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "CitasAgendadas", urlPatterns = {"/CitasAgendadas"})
public class CitasAgendadas extends HttpServlet {

    private ConsultasAgendadasIntervalo consultas = new ConsultasAgendadasIntervalo();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String codigoMedico = request.getSession().getAttribute("codigo").toString();
        Date fecha1 = Date.valueOf(request.getParameter("intervalo_1"));
        Date fecha2 = Date.valueOf(request.getParameter("intervalo_2"));
        
        request.setAttribute("list_consultas", consultas.listaCitasIntervalo(codigoMedico, fecha1, fecha2));
        request.getRequestDispatcher("/Medico/CitasAgendadasIntervalo.jsp").forward(request, response);
    }

    
    
    
}
