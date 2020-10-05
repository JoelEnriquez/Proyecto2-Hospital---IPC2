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
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand text-white">Corpomedic</a>
                <button class="navbar-toggler" data-target="#menu" data-toggle="collapse" type="button">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="menu">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                                Administracion
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Users</a>
                                <a class="dropdown-item" href="#">Perfiles</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                                Administracion
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Users</a>
                                <a class="dropdown-item" href="#">Perfiles</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                                Administracion
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Users</a>
                                <a class="dropdown-item" href="#">Perfiles</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                                Administracion
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Users</a>
                                <a class="dropdown-item" href="#">Perfiles</a>
                            </div>
                        </li>
                    </ul>
                    <span class="navbar-text">
                        Texto Plano
                    </span> 
                </div>
            </nav>
        </div>
    <center>
        <div class="row align-items-center">
            <div class="col">
                <img src="../resources/Paciente_Doctor.jpg" alt="200">
            </div>
        </div>

    </center>


    <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
</body>
</html>
