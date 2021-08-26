<%-- 
    Document   : contactoVTA
    Created on : 17/08/2021, 11:26:59 a.m.
    Author     : Edwin Sandoval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="ContactoCTO?accion=crear" method="post">
            <h1>Contacto</h1>
                <label>Nombre:</label>
                <input type="text" name="txtnombre" required/>
                <label>Correo:</label>
                <input type="email" name="txtemail" required/>
                <label>Asunto</label>
                <input type="text" name="txtasunto" required/>
                <label>Descripcion:</label>
                <textarea name="txtdescripcion" required=""></textarea>
                <br>
                <input type="submit" value="Enviar comentario">
                <input type="reset" value="Limpiar">
        </form>
    </body>
</html>
