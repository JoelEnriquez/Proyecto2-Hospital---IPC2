/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresMedico;

import EntidadesHospital.Examen;
import ModelosComunes.ExamenModel;
import ModelosComunes.ModelHistorialMedico;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "HistorialMedicoPacientes", urlPatterns = {"/HistorialMedicoPacientes"})
public class HistorialMedicoPacientes extends HttpServlet {

    private ModelHistorialMedico modelHistorial = new ModelHistorialMedico();
    private ExamenModel examenModel = new ExamenModel();
    
    /**
     * Se comprueba que no haya codigo nulo o ajeno a permisos, y si se procede; se buscar el historial medico de todos los pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("codigo")==null || !request.getSession().getAttribute("persona").equals("Medico")) {
            response.sendRedirect(request.getContextPath()+"/Inicio/Login.jsp");
        }
        else{
            request.setAttribute("consultas", modelHistorial.obtenerCitasMedicasPacientes());
            //Se agrega el nombre de examen al array de examenes
            ArrayList<Examen> historialExamenes = modelHistorial.obtenerExamenesPacientes();
            for (Examen historialE : historialExamenes) {
                if (!historialE.getCodigoTipoExamen().equals("")) {
                    historialE.setNombreTipoExamen(examenModel.nombreTipoExamenPorCodigo(historialE.getCodigoTipoExamen()));
                }
            }
            request.setAttribute("examenes", historialExamenes);
            
            request.getRequestDispatcher("/Medico/HistorialMedicoPacientes.jsp").forward(request, response);
        }
    }

   

}
