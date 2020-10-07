<%-- 
    Document   : AgendarConsulta
    Created on : 6 oct. 2020, 17:29:12
    Author     : joel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/HeadTittle.html"%>
        <jsp:include page="/WEB-INF/Extras/extraCSS.jsp"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/NavBars/NavBarPaciente.jsp"/>

        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="optradio">Option 1
            </label>
        </div>
        <div class="form-check-inline">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="optradio">Option 2
            </label>
        </div>
        <div class="form-check-inline disabled">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="optradio">Option 3
            </label>
        </div>

        
        <h4>Selecciona el/los grupos de usuarios:</h4>
        <input type="radio" name="opciones" value="multiples" id="multiples"> Multiples <br>

        <div id="div1" style="display:none"> 
            <textarea name="query1" rows="5" cols="150" class="panel-body" placeholder="Ingrese el query de restriccion"></textarea>
        </div>

        <input type="radio" name="opciones" value="individual" id="individual">Individual <br>

        <div id="div2"  style="display:none"> 
            <label for="ID">ID</label>
            <input type="text" class="form-control " name="query" placeholder="Ingrese Id"/>
        </div>


        <script>
            $(document).ready(function () {
                $("#individual").click(function () {
                    $("#div1").hide();
                    $("#div2").show();

                });

                $("#multiples").click(function () {
                    $("#div1").show();
                    $("#div2").hide();

                });
            });
        </script>

        <jsp:include page="/WEB-INF/Extras/extraJS.jsp"/>
    </body>
</html>
