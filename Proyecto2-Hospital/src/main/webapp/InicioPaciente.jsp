<%-- 
    Document   : Inicio
    Created on : 3 oct. 2020, 14:50:21
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/HeadTittle.html"%>
        <jsp:include page="/WEB-INF/Extras/extraCSS.jsp"/>
    </head>
    
    <body> 
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <button class="navbar-toggler" data-target="menu" data-toggle="collapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item">
                            <a href="#" class="nav-link">Inicio</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
