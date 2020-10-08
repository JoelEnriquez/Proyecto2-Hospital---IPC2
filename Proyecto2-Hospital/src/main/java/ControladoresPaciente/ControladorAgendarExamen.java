/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresPaciente;

import EntidadesHospital.Examen;
import Modelos.AgendarExamenModel;
import ModelosComunes.ExamenModel;
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
@WebServlet(name = "ControladorAgendarExamen", urlPatterns = {"/ControladorAgendarExamen"})
public class ControladorAgendarExamen extends HttpServlet {

    private AgendarExamenModel agendarExamenModel = new AgendarExamenModel();
    private ExamenModel examenModel = new ExamenModel();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("HH:mm"); //Formato correcto para la hora

        String hExamen = request.getParameter("hour_examen");
        String fExamen = request.getParameter("date_examen");
        boolean requiereOrden = false;
        String codigoPaciente = request.getSession().getAttribute("nombre").toString();
        String codigoTipoExamen = request.getParameter("tipo_examen");

        Date fechaExamen = null;
        Time horaExamen = null;

        try {
            fechaExamen = Date.valueOf(fExamen);
        } catch (Exception e) {
            request.setAttribute("fail_consulta", true);
            e.printStackTrace(System.out);
        }

        try {
            //Conversion del tiempo
            java.util.Date dateAuxTime = (java.util.Date) format.parse(hExamen);
            horaExamen = new Time(dateAuxTime.getTime());
        } catch (ParseException e) {
            System.out.println("No se pudo concretar la conversion");
            request.setAttribute("fail_consulta", true);
        }
        
        if (codigoTipoExamen.equals("-1")) {
            request.setAttribute("no_examen_type", true); //No se pudo lograr 
        }
        else{
            agendarExamenModel.crearExamenSinOrden(new Examen(fechaExamen, horaExamen, requiereOrden, codigoPaciente, codigoTipoExamen));
            request.setAttribute("sucess_examen", true); //Si se crea el examen
        }
        request.setAttribute("tipo_examenes", examenModel.listaTiposExamen());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Paciente/AgendarExamen.jsp");
        requestDispatcher.forward(request, response);
    }

}
