/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresPaciente;

import Modelos.EspecialidadModel;
import Modelos.FiltrosMedicosModel;
import Modelos.MedicoModel;
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
 *
 * @author joel
 */
@WebServlet(name = "ControladorVerInfoMedicos", urlPatterns = {"/ControladorVerInfoMedicos"})
public class ControladorVerInfoMedicos extends HttpServlet {

    private MedicoModel medicoModel = new MedicoModel();
    private FiltrosMedicosModel filtrosMedicosModel = new FiltrosMedicosModel();
    private EspecialidadModel especialidadModel = new EspecialidadModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("name_filter");
        String especialidad = request.getParameter("espe_filter");

        Time hora = null;

        //Comprobamos si vienen nulos para hacer una conversion correcta
        SimpleDateFormat format = new SimpleDateFormat("HH:mm"); //Formato correcto
        if (!request.getParameter("hour_filter").equals("")) {
            try {
                //Conversion del tiempo
                java.util.Date dateAuxTime = (java.util.Date) format.parse(request.getParameter("hour_filter"));
                hora = new Time(dateAuxTime.getTime());
            } catch (ParseException e) {
                System.out.println("No se pudo concretar la conversion");
            }
        }

        //Ejecutar los filtros
        if (!nombre.equals("")) {
            if (!especialidad.equals("-1")) {
                if (hora != null) {
                    //Todos los filtros
                    request.setAttribute("medicos", filtrosMedicosModel.obtenerPorFiltros(nombre, especialidad, hora));
                } else {
                    //Por nombre y especialidad
                    request.setAttribute("medicos", filtrosMedicosModel.obtenerPorNombreEspecialidad(nombre, especialidad));
                }
            } else if (hora != null) {
                //Por nombre y disponibilidad
                request.setAttribute("medicos", filtrosMedicosModel.obtenerPorNombreDispo(nombre, hora));
            } else {
                //Por nombre
                request.setAttribute("medicos", medicoModel.buscarConNombre(nombre));
            }
        } else if (!especialidad.equals("-1")) {
            if (hora != null) {
                //Por especialidad y disponibilidad
                request.setAttribute("medicos", filtrosMedicosModel.obtenerPorEspecialidadDispo(especialidad, hora));
            } else {
                //Por especialidad
                request.setAttribute("medicos", medicoModel.buscarPorEspecialidad(especialidad));
            }
        } else if (hora != null) {
            //Por disponibilidad
            request.setAttribute("medicos", medicoModel.buscarPorDisponibilidad(hora));
        } else {
            //Todos los medicos
            request.setAttribute("medicos", medicoModel.listaMedicos());
        }
        
        request.setAttribute("especialidades", especialidadModel.obtenerEspecialidades());

        RequestDispatcher requestDis = request.getRequestDispatcher("/Paciente/AgendarConsulta.jsp");
        requestDis.forward(request, response);

    }

}
