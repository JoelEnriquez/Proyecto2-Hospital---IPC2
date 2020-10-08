<%-- 
    Document   : ListadoAdministradores
    Created on : 8 oct. 2020, 13:09:21
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/HeadTittle.html"%>
        <jsp:include page="/WEB-INF/Extras/extraCSS.jsp"/>
    </head>
    <body>
        <jsp:include page="/WEB-INF/NavBars/NavBarAdministrador.jsp"/>

    <CENTER><h3>Listado Laboratoristas</h3></CENTER>

    <div class="table-wrapper-scroll-y my-custom-scrollbar">
        <table class="table table-striped table-bordered table-sm">
            <tr class="thead-dark">
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Registro</th>
                <th>DPI</th>
                <th>Horario Fin</th>
                <th>DPI</th>
                <th>Correo</th>
                <th>Fecha Inicio Hospital</th>
                <th>Nombre Especialidad</th>
            </tr>
            <c:forEach items="${medicos}" var="medico">
                <tr>
                    <td>${medico.codigo}</td>
                    <td>${medico.nombre}</td>
                    <td>${medico.numeroColegiado}</td>
                    <td>${medico.horaInicio}</td>
                    <td>${medico.horaFin}</td>
                    <td>${medico.DPI}</td>
                    <td>${medico.correoElectronico}</td>
                    <td>${medico.fechaInicioHospital}</td>
                    <td>${medico.nombreEspecialidad}</td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
