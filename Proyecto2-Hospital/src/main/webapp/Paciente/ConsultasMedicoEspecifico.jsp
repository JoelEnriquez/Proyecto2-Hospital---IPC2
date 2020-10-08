<%-- 
    Document   : ConsultasMedicoEspecifico
    Created on : 6 oct. 2020, 19:50:59
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
        <br>
        <br>
        <c:if test="${no_medico_exist!=null}"> <p class="alert alert-danger"> Por favor, elija un codigo existente </p></c:if>
        <div class="main mx-5" style="flex:2;">
            <div class="flexbox-container" style="display:flex;">

            <form action="${pageContext.request.contextPath}/ControladorConsultasMedicoEspe" method="GET">
                <h4>Intervalo de tiempo</h4>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Fecha inicio</label>
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
                <h4>Codigo Medico</h4>
                <input type="text" class="form-control col-sm-3" name="codigoMedico" required>
                <br>
                <button type="submit" class="btn btn-primary">Solicitar</button>
            </form>
        </div>
        <br>
        <div class="main mx-5" style="flex:2;">
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
                <c:forEach items="${consultas_medico}" var="consulta">
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
        </div>
        

        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
