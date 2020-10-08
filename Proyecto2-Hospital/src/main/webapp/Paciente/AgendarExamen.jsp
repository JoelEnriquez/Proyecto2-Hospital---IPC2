<%-- 
    Document   : AgendarExamen
    Created on : 6 oct. 2020, 23:01:31
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

        <br>
        <c:if test="${no_examen_type!=null}"> <p class="alert alert-danger"> Por favor, elija un examen </p></c:if>
        <c:if test="${sucess_examen!=null}"> <p class="alert alert-success"> Examen Generado Exitosamente </p></c:if> 
            <br>
            <div class="main mx-4" style="flex:2;">
                <form action="${pageContext.request.contextPath}/ControladorAgendarExamen" method="POST">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Hora Examen</label>
                    <div class="col-sm-3 my-1">                          
                        <input type="time" class="form-control" name="hour_examen" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Fecha Examen</label>
                    <div class="col-sm-3 my-1">                          
                        <input type="date" class="form-control" name="date_examen" required>
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
                                    ${tipo_examen.nombreExamen} (Q.${tipo_examen.costoExamen})
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-auto my-1">
                    <button type="submit" class="btn btn-primary">Agendar</button>
                </div>
            </form>
        </div>


        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>

    </body>
</html>
