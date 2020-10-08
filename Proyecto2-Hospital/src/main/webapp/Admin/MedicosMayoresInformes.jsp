<%-- 
    Document   : MedicosMayoresInformes
    Created on : 8 oct. 2020, 13:41:12
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
        <jsp:include page="/WEB-INF/NavBars/NavBarAdministrador.jsp"/>

        <form action="${pageContext.request.contextPath}/MedicosMayorInformes" method="GET">
            <h4>Intervalo de tiempo</h4>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Fecha Inicio</label>
                <div class="col-sm-3 my-1">                          
                    <input type="date" class="form-control" name="intervalo_1" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Fecha Fin</label>
                <div class="col-sm-3 my-1">                          
                    <input type="date" class="form-control" name="intervalo_2" required>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Solicitar</button>
        </form>


    <CENTER><h3>Listado Medicos</h3></CENTER>

        <table class="table table-striped table-bordered table-sm">
            <tr class="thead-dark">
                <th>Codigo</th>
                <th>Nombre</th>
                <th>Numero Colegiado</th>
                <th>Horario Inicio</th>
                <th>Horario Fin</th>
                <th>DPI</th>
                <th>Telefono</th>
                <th>Correo Electronico</th>
                <th>Fecha Inicio Hospital</th>
            </tr>
            <c:forEach items="${med_mas_informes}" var="medico">
                <tr>
                    <td>${medico.codigo}</td>
                    <td>${medico.nombre}</td>
                    <td>${medico.numeroColegiado}</td>
                    <td>${medico.horaInicio}</td>
                    <td>${medico.horaFin}</td>
                    <td>${medico.DPI}</td>
                    <td>${medico.telefono}</td>
                    <td>${medico.correoElectronico}</td>
                    <td>${medico.fechaInicioHospital}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
