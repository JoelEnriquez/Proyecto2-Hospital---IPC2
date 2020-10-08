

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

        <br>
        <br>
        <br>
        <br>
        <br>
        <c:if test="${wrong_time!=null}"> <p class="alert alert-danger"> Por favor, elija un intervalo correcto </p></c:if>
            <div class="flexbox-container" style="display:flex;">

                <div class="main mx-5" style="flex:2;">
                    <br>
                    <form action="${pageContext.request.contextPath}/PacientesMayorInformes" method="GET">
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
                    <button type="submit" class="btn btn-primary">Solicitar</button>
                </form>
            </div>

            <div class="main mx-4"  style="flex:2;">
                <table class="table table-striped table-bordered table-sm">
                    <tr class="thead-dark">
                        <th>Codigo</th>
                        <th>Nombre</th>
                        <th>Sexo</th>
                        <th>DPI</th>
                        <th>Telefono</th>
                        <th>Peso</th>
                        <th>Tipo Sangre</th>
                        <th>Correo</th>
                        <th>Veces informe</th>
                    </tr>
                    <c:forEach items="${list_pacientes}" var="paciente">
                        <tr>
                            <td>${paciente.codigo}</td>
                            <td>${paciente.nombre}</td>
                            <td>${paciente.sexo}</td>
                            <td>${paciente.DPI}</td>
                            <td>${paciente.telefono}</td>
                            <td>${paciente.peso}</td>
                            <td>${paciente.tipoSangre}</td>
                            <td>${paciente.correoElectronico}</td>
                            <td>${paciente.numeroInformes}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
