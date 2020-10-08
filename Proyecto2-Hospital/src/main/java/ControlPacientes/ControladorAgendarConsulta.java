/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlPacientes;

import EntidadesAsignacion.Especialidad;
import EntidadesHospital.CitaMedico;
import Modelos.AgendarCitaModel;
import Modelos.EspecialidadModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Se redirige la informacion a comprobar si es exitosa, y se realiza la
 * consulta.
 *
 * @author joel
 */
@WebServlet(name = "ControladorAgendarConsulta", urlPatterns = {"/ControladorAgendarConsulta"})
public class ControladorAgendarConsulta extends HttpServlet {

    private AgendarCitaModel agendarCitaModel = new AgendarCitaModel();
    private EspecialidadModel especialidadModel = new EspecialidadModel();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm"); //Formato correcto para la hora

        String codigoPaciente = request.getSession().getAttribute("nombre").toString();
        String codigoMedico;
        String hCita = request.getParameter("horaCita");
        String fCita = request.getParameter("fechaCita");
        String idTipoConsulta = request.getParameter("tipo_consulta");

        Date fechaCita = null;
        Time horaCita = null;

        if (request.getSession().getAttribute("codigo_medico") == null) {
            request.setAttribute("codigoIncorrecto", true);
        } else {
            codigoMedico = request.getSession().getAttribute("codigo_medico").toString();

            try {
                fechaCita = Date.valueOf(fCita);
            } catch (Exception e) {
                request.setAttribute("fail_consulta", true);
                e.printStackTrace(System.out);
            }

            try {
                //Conversion del tiempo
                java.util.Date dateAuxTime = (java.util.Date)format.parse(hCita);
                horaCita = new Time(dateAuxTime.getTime());
            } catch (ParseException e) {
                System.out.println("No se pudo concretar la conversion");
                request.setAttribute("fail_consulta", true);
            }
            Especialidad especialidadAux = especialidadModel.obtenerPorId(idTipoConsulta);
            agendarCitaModel.crearCita(new CitaMedico(codigoPaciente, codigoMedico, especialidadAux.getNombre() , idTipoConsulta, especialidadAux.getCostoConsulta(), fechaCita, horaCita));
            
            request.setAttribute("sucess_consulta", true);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Paciente/AgendarConsulta.jsp");
        requestDispatcher.forward(request, response);

    }

}
