<%-- 
    Document   : CitasPendientesDia
    Created on : 8 oct. 2020, 6:43:18
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
        <%--Se valida que se un medico y tenga sesion activa el que ingrese al formulario, sino regresar al inicio--%>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("codigo") == null || !session.getAttribute("persona").equals("Medico")) {
                response.sendRedirect(request.getContextPath() + "/Inicio/Login.jsp");
            }
        %>

        <jsp:include page="/WEB-INF/NavBars/NavBarMedico.jsp"/>

        <style>
            .my-custom-scrollbar {
                position: relative;
                height: 300px;
                overflow: auto;
            }
            .table-wrapper-scroll-y {
                display: block;
            }
        </style>

        <br>

        <div class="main mx-4" style="flex:2;">
            <br/>

            <div class="container">
                <div class="row">
                    <div class="col">
                        <h1>Consultas Pendientes Hoy</h1>
                    </div>
                    <c:if test="${cita_atender!=null}">
                    <div>
                            <span class="label label-primary">Codigo Cita: ${cita_atender.codigo}</span>
                            <br>
                            <span class="label label-info">Hora Cita:${cita_atender.horaCita}</span>
                            <br>
                            <div class="col-auto my-1">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Medico/RealizarInforme.jsp" role="button">Realizar Informe</a>
                            </div>
                    </div>
                    </c:if>
                </div>
            </div>

            <br/>       
            <br/>

            <div class="table-wrapper-scroll-y my-custom-scrollbar">
                <table class="table table-striped table-bordered table-sm">
                    <tr class="thead-dark">
                        <th>Codigo</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Codigo Paciente</th>
                        <th>Codigo Medico</th>
                        <th>Nombre Consulta</th>
                        <th>Costo Consulta</th>
                    </tr>
                    <c:forEach items="${citas_pen}" var="cita">
                        <tr>
                            <td>${cita.codigo}</td>
                            <td>${cita.fechaCita}</td>
                            <td>${cita.horaCita}</td>
                            <td>${cita.codigoPaciente}</td>
                            <td>${cita.codigoMedico}</td>
                            <td>${cita.nombreEspecialidad}</td>
                            <td>${cita.costoConsulta}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>



        <br>
        <c:if test="${fail_consulta!=null}"> <p class="alert alert-danger"> Error en la solicitud </p></c:if>
        <c:if test="${sucess_consulta!=null}"> <p class="alert alert-success"> Consulta Generada Exitosamente </p></c:if>  


        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
