
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand text-white" href="${pageContext.request.contextPath}/Medico/InicioMedico.jsp">Corpomedic <%=request.getSession().getAttribute("persona")%></a>
        <button class="navbar-toggler" data-target="#menu" data-toggle="collapse" type="button">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="menu">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                        Citas Medicas
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/CitasAgendadas">Ver Citas Agendadas</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/CitasPendientesEnDia">Pendientes en el dia</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle active" data-toggle="dropdown" data-target="desplegable" href="#">
                        Informacion Pacientes
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/PacientesMayorInformes">Pacientes con mas informes</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/HistorialMedicoPacientes">Historial medico</a>
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

