<%-- 
    Document   : Cargar Datos
    Created on : 4 oct. 2020, 22:15:27
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../WEB-INF/HeadTittle.html"%>
    <jsp:include page="/WEB-INF/Extras/extraCSS.jsp"/>

    <body>
        <% if (request.getAttribute("Sucess") == null) {%>
        <div class="container" style="padding-top: 150px" >
            <CENTER>
                <h1 class="align-content-lg-center">Carga de Archivo XML</h1>

                <FORM class="col-12 caja2" METHOD="POST" ACTION="../CargaArchivo" enctype="multipart/form-data">  
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label>Elija el Archivo XML</label>
                        </div>
                        <div class="form-group col-md-4">

                            <input class="form-control" type="file"  name="archivoXML" id="archivoXML" placeholder="Elija el Archivo" accept=".xml" required>
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="form-group col-md-5">
                            <label>Seleccione los archivos para llenar la DB</label>
                        </div>
                        <div class="form-group col-md-4">
                            <input class="form-control" type="file"  name="archivosDB" id="archivosDB" placeholder="Elija los archivos" accept=".pdf,image/*" multiple required>
                        </div>
                    </div>

                    <br>

                    <input class="btn btn-primary" type="submit" value="Cargar">
                    <input class="btn btn-secundary" type="reset" value="Eliminar Datos">

                </FORM>
            </CENTER>
        </div>
        <% } else {%>
        <div class="container " style="padding-top: 150x" >
            <CENTER>
                <h1 class="align-content-lg-center">Carga de Archivo XML</h1>
            </CENTER>
            <% if ((boolean) request.getAttribute("Sucess")) {%>
            <div class="alert alert-success">
                Carga de Archivo Realizada con Exito
            </div>
            <br>
            <CENTER>
                <a href="${pageContext.request.contextPath}/Inicio/Login.jsp" class="btn btn-primary">Iniciar Sesion</a>
            </CENTER>

            <% } else {%>
            <div class="alert alert-danger">
                Fallo en la Carga de Archivo
            </div>
            <br>
            <CENTER>
                <a href="index.jsp" class="btn btn-primary">Volver a Intentar</a>
            </CENTER>
            <% }%>
        </div>
        <% }%>
        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
