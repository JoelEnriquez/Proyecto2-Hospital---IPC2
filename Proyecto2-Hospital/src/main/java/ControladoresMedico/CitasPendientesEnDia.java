/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresMedico;

import EntidadesHospital.CitaMedico;
import ModelMedico.CitasPendientesModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private CitasPendientesModel citasPendientesModel = new CitasPendientesModel();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("codigo")==null || !request.getSession().getAttribute("persona").equals("Medico")) {
            response.sendRedirect(request.getContextPath()+"/ControlLogOut");
        }
        else{
            ArrayList<CitaMedico> listCitasPendientesDia = null;
            try {
                listCitasPendientesDia = citasPendientesModel.getCitasPendientesDia(request.getSession().getAttribute("codigo").toString());
            } catch (Exception ex) {
                ex.getMessage();
            }
            if (listCitasPendientesDia!=null && listCitasPendientesDia.size()>0) {
                request.getSession().setAttribute("cita_atender", listCitasPendientesDia.get(0));
            }           
            
            request.setAttribute("citas_pen", listCitasPendientesDia);
            
            request.getRequestDispatcher("/Medico/CitasPendientesDia.jsp").forward(request, response);
        }
        
    }

    

}
