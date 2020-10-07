package ControladoresInicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Encriptar.Encriptacion;
import Modelos.PacienteModel;
import ModelosInicio.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joel
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/Inicio/Login.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");
        String password = request.getParameter("password");

        //Encriptamos la contraseña entrante
        Encriptacion encriptacion = new Encriptacion();
        String encryptedPass = "";
        try {
            encryptedPass = encriptacion.encriptar(password);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        LoginModel loginM = new LoginModel();
        boolean accesoConcedido = false;
        String tipoPersona = loginM.devolverTipoPersona(codigo);
        //Verificamos que tipo de usuario es y buscamos en la tabla respectiva
        switch (tipoPersona) {
            case "Paciente":
                accesoConcedido = loginM.loginPacienteValido(Integer.parseInt(codigo), encryptedPass);
                break;
            case "Medico":
                accesoConcedido = loginM.loginMedicoValido(codigo, encryptedPass);
                break;
            case "Laboratorista":
                accesoConcedido = loginM.loginLabValido(codigo, encryptedPass);
                break;
            case "Admin":
                accesoConcedido = loginM.loginAdminValido(codigo, encryptedPass);
                break;
            default:
                break;
        }

        if (accesoConcedido) {

            request.getSession().setAttribute("codigo", codigo);
            request.getSession().setAttribute("persona", tipoPersona);           

            switch (tipoPersona) {
                case "Paciente":
                    PacienteModel pacienteModel = new PacienteModel();
                    request.getSession().setAttribute("nombre", pacienteModel.obtenerPaciente(Integer.parseInt(codigo)).getNombre());
                    response.sendRedirect(request.getContextPath() + "/Paciente/InicioPaciente.jsp");
                    break;
                case "Medico":
                    response.sendRedirect(request.getContextPath() + "/Medico/InicioMedico.jsp");
                    break;
                case "Laboratorista":
                    response.sendRedirect(request.getContextPath() + "/Laboratorista/InicioLaboratorista.jsp");
                    break;
                case "Admin":
                    response.sendRedirect(request.getContextPath() + "/Admin/InicioAdmin.jsp");
                    break;
            }
        } else {
            request.setAttribute("fail", true);
            request.getRequestDispatcher("/Inicio/Login.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
