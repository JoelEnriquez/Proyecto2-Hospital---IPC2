<%-- 
    Document   : NavbarPaciente
    Created on : 5 oct. 2020, 19:38:32
    Author     : joel
--%>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand text-white" href="${pageContext.request.contextPath}/Paciente/InicioPaciente.jsp">Corpomedic <%=request.getSession().getAttribute("persona")%></a>
        <button class="navbar-toggler" data-target="#menu" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                        Historial Medico
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControlHistorialMP">Visualizar</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                        Consultas Medicas
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControladorCitasPenPaci">Visualizar citas</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControladorEspecialidades">Agendar/Info Medicos</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/Paciente/ConsultasMedicoEspecifico.jsp">Consultas con un medico</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControladorUltimasConsultas">Ultimas consultas</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                        Examen Laboratorio
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControladorInfoExamen">Agendar</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControlInfoExamenesTipo">Ver examenes de un tipo</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ControladorUltimosExamenes">Ultimos examenes</a>
                    </div>
                </li>
                <li class="btn btn-secundary">
                    <a href="${pageContext.request.contextPath}/ControlLogOut">Cerrar Sesion</a>
                </li>
            </ul>
            <span class="navbar-text">
                <%="Codigo:" + request.getSession().getAttribute("codigo")%>
            </span> 
        </div>
    </nav>
</div>
