<%-- 
    Document   : RegistroPacientes
    Created on : 4 oct. 2020, 18:17:26
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

        <c:if test="${complete==null}">
            <br>
            <c:if test="${mensaje_error!=null}"> <p class="alert alert-danger"> ${mensaje_error} </p></c:if>
                <br>

                <div class="main mx-4" style="flex:2;">
                    <form action="${pageContext.request.contextPath}/RegistroNuevoPaciente" method="POST">
                    <div class="form-group row">
                        <label class="col-sm-1 col-form-label">Nombre</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" name="nombre" required>
                        </div>
                    </div>    
                    <div class="form-group row">
                        <label class="col-sm-1 col-form-label">Sexo</label>
                        <select class="form-control col-sm-3" name="sexo">
                            <option value="Hombre">Hombre</option>
                            <option value="Mujer">Mujer</option>
                        </select>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-1 col-form-label">Fecha Nacimiento</label>
                        <div class="col-sm-4">                          
                            <input type="date" class="form-control" name="fecha_nacimiento" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">DPI</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="number" class="form-control" name="DPI" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Telefono</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="number" class="form-control" name="telefono" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Peso</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="number" class="form-control" name="peso" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Tipo Sangre</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="text" class="form-control" name="tipo_sangre" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Correo Electronico</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="email" class="form-control" name="correo" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Contraseña</label>
                        <div class="col-sm-3 my-1">                          
                            <input type="password" class="form-control" name="password" required>
                        </div>
                    </div>
                    <div class="col-auto my-1">
                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </div>
                </form>
            </div>
        </c:if>
        <c:if test="${complete!=null}">
            <<p class="alert alert-success">Enhorabuena!</p>
            <h3>Su codigo es ${complete}</h3>
            <br>
            <a href="${pageContext.request.contextPath}/Inicio/Login.jsp" class="btn-light">Volver al menu</a>
        </c:if>

        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
