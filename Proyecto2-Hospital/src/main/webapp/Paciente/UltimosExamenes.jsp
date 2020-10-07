<%-- 
    Document   : UltimosExamenes
    Created on : 6 oct. 2020, 20:37:26
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
        <h1>Ultimos 5 examenes de ${nombre}</h1>
    </CENTER>
    <br/>

    <table class="table table-striped table-bordered">
        <tr class="thead-dark">
            <th>Codigo</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Requiere Orden</th>
            <th>Codigo Paciente</th>
            <th>Codigo Medico</th>
            <th>Codigo Tipo Examen</th>
        </tr>
        <c:forEach items="${ultimos_examenes}" var="examen">
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

    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
