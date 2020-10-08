/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import ModelosComunes.ExamenModel;
import ModelosReportesPaciente.ExamenesTipoReportModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "ControladorExamenesTipoRepor", urlPatterns = {"/ControladorExamenesTipoRepor"})
public class ControladorExamenesTipoRepor extends HttpServlet {

    private ExamenesTipoReportModel examenesTipo = new ExamenesTipoReportModel();
    private ExamenModel examenModel = new ExamenModel();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String intervaloTiempo1 = request.getParameter("intervalo_1");
        String intervaloTiempo2 = request.getParameter("intervalo_2");
        String codigoPaciente = request.getSession().getAttribute("codigo").toString();
        String tipoExamen = request.getParameter("tipo_examen");
        
        
        if (tipoExamen.equals("-1")) {
            request.setAttribute("no_examen_type", true);
        }
        else{
            Date firstIntevalo = null;
            Date lastIntevalo = null;
            try {
                firstIntevalo = Date.valueOf(intervaloTiempo1);
                lastIntevalo = Date.valueOf(intervaloTiempo2);
            } catch (Exception e) {
                System.out.println("Fallo en la conversion");
                request.setAttribute("date_order", true);
            }
            if ((firstIntevalo!=null&&lastIntevalo!=null) && firstIntevalo.compareTo(lastIntevalo)>0) {
                request.setAttribute("date_order", true);
            }
            else{
                request.setAttribute("examenes", examenesTipo.examenesTipoIntervalo(codigoPaciente, Integer.parseInt(tipoExamen), firstIntevalo, lastIntevalo));
                request.setAttribute("nombre_examen", examenModel.nombreTipoExamenPorCodigo(tipoExamen));
            }
            
        }
        request.setAttribute("tipo_examenes", examenModel.listaTiposExamen());
                
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Paciente/ExamenesTipoEspe.jsp");
        requestDispatcher.forward(request, response);
    }

    

}
