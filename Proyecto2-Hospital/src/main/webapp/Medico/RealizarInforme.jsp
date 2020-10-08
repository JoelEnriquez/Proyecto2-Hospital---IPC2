<%-- 
    Document   : RealizarInforme
    Created on : 8 oct. 2020, 9:47:35
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
        <c:if test="${cita_atender!=null}">
            <div class="main mr-4"  style="flex:3;">
                <br>
                <form action="${pageContext.request.contextPath}/SubirInforme" method="POST">
                    <CENTER><h1>Descripcion</h1></CENTER>
                    <div class="form-group row">
                        
                        <textarea class="form-control" rows="5" name="descripcion" required></textarea>
                    </div>
                    <div class="form-group row text-center">
                        <div class="col-sm-12 text-center">
                            <button type="submit" class="btn btn-primary">Subir Informe</button>
                        </div>
                    </div>
                </form>
                    <h3>Codigo Cita: ${cita_atender.codigo}</h3>
            </div>
        </c:if>
        <c:if test="${cita_atender==null}">
            <c:if test="${success_info!=null}">
                <div class="alert alert-success">
                    Informe subido con exito!
                </div>
            </c:if>
            <c:if test="${error_info!=null}">
                <div class="alert alert-danger">
                    Error con la subida
                </div>
            </c:if>
            <jsp:include page="/WEB-INF/NavBars/NavBarMedico.jsp"/>
        </c:if>

        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
