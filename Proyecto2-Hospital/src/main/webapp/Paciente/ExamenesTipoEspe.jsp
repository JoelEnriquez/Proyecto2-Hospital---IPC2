<%-- 
    Document   : ExamenesTipoEspe
    Created on : 6 oct. 2020, 19:51:17
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

        <c:if test="${no_examen_type!=null}"> <p class="alert alert-danger"> Por favor, elija un examen </p></c:if>
        <c:if test="${date_order!=null}"> <p class="alert alert-danger"> Por favor, elija un intervalo correcto </p></c:if>
        <br>
        <div class="main mx-4" style="flex:2;">
            <form action="${pageContext.request.contextPath}/ControladorExamenesTipoRepor" method="GET">
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
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Tipo Examen</label>
                    <div class="col-sm-8">
                        <%--Se obtiene el listado de tipos de examen para darle a elegir al usuario--%>
                        <select class="form-control" name="tipo_examen">
                            <option value="-1">
                                ---Seleccione un tipo de examen---
                            </option>
                            <c:forEach items="${tipo_examenes}" var="tipo_examen">
                                <option value="${tipo_examen.codigo}">
                                    ${tipo_examen.nombreExamen}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br>
                <div class="col-auto my-1">
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </form>
        </div>

        <br>

        <div class="main mx-4" style="flex:2;">
            <table class="table table-striped table-bordered">
                <caption>Examenes de Tipo <c:if test="${nombre_examen!=null}"> :${nombreExamen}</c:if></caption>
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
        </div>
        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
