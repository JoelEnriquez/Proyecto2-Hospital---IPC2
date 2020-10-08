<%-- 
    Document   : Inicio
    Created on : 3 oct. 2020, 14:50:21
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
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

    <CENTER>
        <br/>
        <div class="row align-items-center">
            <div class="col">
                <img src="${pageContext.request.contextPath}/resources/Paciente_Doctor.jpg" alt="300">
            </div>
        </div>
    </CENTER>

    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
