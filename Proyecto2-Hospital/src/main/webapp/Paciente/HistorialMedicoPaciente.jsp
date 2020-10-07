<%-- 
    Document   : HistorialMedicoPaciente
    Created on : 5 oct. 2020, 19:36:50
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
        <jsp:include page="/WEB-INF/NavBars/NavBarPaciente.jsp"/>

        <br/>   
    <CENTER>
        <h1>Historial Medico de ${nombre}</h1>
    </CENTER>
    <br/>

    <table class="table table-striped table-bordered">
        <caption>Examenes Laboratorio</caption>
        <tr class="thead-dark">
            <th>Codigo</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Requiere Orden</th>
            <th>Codigo Paciente</th>
            <th>Codigo Medico</th>
            <th>Codigo Tipo Examen</th>
        </tr>
        <c:forEach items="${examenes}" var="examen">
            <tr>
                <td>${examen.codigo}</td>
                <td>${examen.fechaCita}</td>
                <td>${examen.horaCita}</td>
                <td>${examen.requiereOrden}</td>
                <td>${examen.codigoPaciente}</td>
                <td>${examen.codigoMedico}</td>
                <td>${examen.codigoTipoExamen}</td>
            </tr>
        </c:forEach>
    </table>
    
    <br/>

    <table class="table table-striped table-bordered">
        <caption>Consultas Medicas</caption>
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
        <c:forEach items="${consultas}" var="consulta">
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
