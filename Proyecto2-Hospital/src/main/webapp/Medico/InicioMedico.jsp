<%-- 
    Document   : InicioMedico
    Created on : 3 oct. 2020, 21:34:20
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
        <jsp:include page="/WEB-INF/NavBars/NavBarMedico.jsp"/>

    <CENTER>
        <br/>
        <div class="row align-items-center">
            <div class="col">
                <img src="${pageContext.request.contextPath}/resources/Doctor.png" alt="300">
            </div>
        </div>
    </CENTER>
    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
