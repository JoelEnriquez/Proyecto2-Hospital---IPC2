<%-- 
    Document   : AgendarConsulta
    Created on : 6 oct. 2020, 17:29:12
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
                response.sendRedirect(request.getContextPath()+"/Inicio/Login.jsp");
            }
        %>
        <jsp:include page="/WEB-INF/NavBars/NavBarPaciente.jsp"/>
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
        <div class="flexbox-container" style="display:flex;">


            <div class="main mx-4" style="flex:2;">

                <br/>   
                <CENTER>
                    <h1>Filtrar Por</h1>
                </CENTER>
                <form action="${pageContext.request.contextPath}/ControladorVerInfoMedicos" method="GET">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Por Nombre</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="name_filter">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Por Especialidad</label>
                        <div class="col-sm-8">
                            <%--Se obtiene el listado de especialidades para darle a elegir al usuario--%>
                            <select class="form-control" name="espe_filter">
                                <option value="-1">
                                    ---Seleccione una especialidad---
                                </option>
                                <c:forEach items="${especialidades}" var="especialidad">
                                    <option value="${especialidad.id}">
                                        ${especialidad.nombre}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Por Disponibilidad</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="time" class="form-control" name="hour_filter">
                        </div>
                    </div>
                    <div class="col-auto my-1">
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>
                </form>

                <br/>   
                <CENTER>
                    <h3>Info Medicos</h3>
                </CENTER>
                <br/>

                <div class="table-wrapper-scroll-y my-custom-scrollbar">
                    <table class="table table-striped table-bordered table-sm">
                        <tr class="thead-dark">
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Numero Colegiado</th>
                            <th>Horario Inicio</th>
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
            </div>

            <div class="main mr-4"  style="flex:1;">
                <%if (request.getAttribute("codigoIncorrecto") != null) {%>
                <%if ((boolean) request.getAttribute("codigoIncorrecto")) {%>
                <CENTER><p class="alert alert-danger">Medico Inextente</p></CENTER>       
                    <%}%>
                    <%}%>

                <form action="${pageContext.request.contextPath}/ControladorEspecialidadesMAgendar" method="GET">
                    <div>
                        <CENTER>
                            <h3>
                                Codigo Medico <c:if test="${codigo_medico!=null}"> : ${codigo_medico}</c:if>
                                </h3>
                            </CENTER>
                            <input type="text" class="form-control" name="codigoMedico" required>
                        </div>
                        <br>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Solicitar</button>
                        </div>
                    </form>
                    <br>
                    <form action="${pageContext.request.contextPath}/ControladorAgendarConsulta" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Hora</label>
                        <div class="col-sm-10">
                            <input type="time" class="form-control" name="horaCita" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Fecha</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control" name="fechaCita" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Tipo Consulta</label>
                        <div class="col-sm-10">
                            <%--Se obtiene las especialidad del medico realizar--%>
                            <select class="form-control" name="tipo_consulta">
                                <option value="${consulta_general.id}">
                                    ${consulta_general.nombre} (Q. ${consulta_general.costoConsulta})
                                </option>
                                <c:forEach items="${especialidades_medico}" var="especialidad">
                                    <option value="${especialidad.id}">
                                        ${especialidad.nombre} (Q.${especialidad.costoConsulta})
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row text-center">
                        <div class="col-sm-10 text-center">
                            <button type="submit" class="btn btn-primary">Agendar</button>
                        </div>
                    </div>
                </form>

                <br>
                <c:if test="${fail_consulta!=null}"> <p class="alert alert-danger"> Error en la solicitud </p></c:if>
                <c:if test="${sucess_consulta!=null}"> <p class="alert alert-success"> Consulta Generada Exitosamente </p></c:if>  
                </div>
            </div>


        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>

    </body>
</html>
