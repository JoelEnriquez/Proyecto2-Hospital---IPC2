/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import EntidadesHospital.CitaMedico;
import Modelos.MedicoModel;
import ModelosReportesPaciente.ConsultasMedicoEspecificoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(name = "ControladorConsultasMedicoEspe", urlPatterns = {"/ControladorConsultasMedicoEspe"})
public class ControladorConsultasMedicoEspe extends HttpServlet {

    private ConsultasMedicoEspecificoModel consultasMedicoEspecificoModel = new ConsultasMedicoEspecificoModel();
    private MedicoModel medicoModel = new MedicoModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fecha1 = request.getParameter("intervalo_1");
        String fecha2 = request.getParameter("intervalo_2");
        String codigoMedico = request.getParameter("codigoMedico");
        String codigoPaciente = request.getSession().getAttribute("codigo").toString();

        if (medicoModel.medicoExixtente(codigoMedico)==0) {
            request.setAttribute("no_medico_exist", true);
        } else {
            ArrayList<CitaMedico> listaCitas = null;

            try {
                listaCitas = consultasMedicoEspecificoModel.citasMedicoEspe(codigoMedico, codigoPaciente, Date.valueOf(fecha1), Date.valueOf(fecha2));
            } catch (Exception e) {
                System.out.println("Error en la conversion de fechas");
            }
            request.setAttribute("consultas_medico", listaCitas);
        }
        request.getRequestDispatcher("/Paciente/ConsultasMedicoEspecifico.jsp").forward(request, response);
    }

}
