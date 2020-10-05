<%-- 
    Document   : index
    Created on : 3 oct. 2020, 8:18:16
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
        <c:if test="${success == 0}">
            <p id="error">Usuario o Contraseña Incorrecto</p>
        </c:if>
            
        <div class="container">
            <div class="row justify-content-center">
                <div class="card" style="width: 18rem;">
                    <img src="resources/doctor_and_patient.jpg" class="card-img-top" alt="10">
                    <div class="card-body">
                        <form action="Login" method="POST">
                            <div class="form-group">
                                <label>Codigo</label>
                                <input type="text" class="form-control" name="codigo">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                            <center>
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                            </center>                           
                        </form>
                        <br/>
                        <center>
                            <button class="btn btn-light">
                                <a href="RegistroPacientes.jsp">Registrate</a>
                            </button>
                        </center>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
