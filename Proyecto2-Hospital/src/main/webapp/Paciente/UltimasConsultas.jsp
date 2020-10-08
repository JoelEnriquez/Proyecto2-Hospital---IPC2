<%-- 
    Document   : UltimasConsultas
    Created on : 6 oct. 2020, 20:37:15
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/HeadTittle.html"%>
        <jsp:include page="/WEB-INF/Extras/extraCSS.jsp"/>
    </head>
    <body>
        <%--Si no encuentra codigo o que sea Paciente, redirigir al inicio --%>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("codigo") == null || !session.getAttribute("persona").equals("Paciente")) {
                response.sendRedirect(request.getContextPath() + "/Inicio/Login.jsp");
            }
        %>
        <jsp:include page="/WEB-INF/NavBars/NavBarPaciente.jsp"/>


        <br/>   
    <CENTER>
        <h1>Ultimos 5 consultas de ${nombre}</h1>
    </CENTER>
    <br/>
    <table class="table table-striped table-bordered">
        <tr class="thead-dark">
            <th>Codigo</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Codigo Paciente</th>
            <th>Codigo Medico</th>
            <th>Id. Especialidad</th>
            <th>Especialidad Cita</th>
            <th>Costo Consulta (Q)</th>
        </tr>
        <c:forEach items="${ultimas_consultas}" var="consulta">
            <tr>
                <td>${consulta.codigo}</td>
                <td>${consulta.fechaCita}</td>
                <td>${consulta.horaCita}</td>
                <td>${consulta.codigoPaciente}</td>
                <td>${consulta.codigoMedico}</td>
                <td>${consulta.idEspecialidad}</td>
                <td>${consulta.nombreEspecialidad}</td>
                <td>${consulta.costoConsulta}</td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
