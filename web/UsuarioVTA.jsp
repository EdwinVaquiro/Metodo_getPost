<%-- 
    Document   : UsuarioVTA
    Created on : 19/08/2021, 9:17:55 a.m.
    Author     : Edwin Sandoval
--%>

<%@page import="Modelo.dto.UsuarioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>Lista usuarios</h1>
    <table>
            <thead>
                <tr>NOMBRE</tr>
                <tr>ROL</tr>
            </thead>
            <tbody>
              <%
                    Object lista = request.getAttribute("lista");
                    if (lista != null) {
                        List<Object> listObj = (List) lista;
                        for (Object usuario : listObj) {
                            UsuarioDTO obj = (UsuarioDTO) usuario;
                %>
                <tr>
                    <td><p><%=obj.getNombre()%></p></td>
                    <td><p><%=obj.getCorreo()%></p></td>
                </tr>
                <%
                    }
                } else {
                %>
            <h2>Sin información</h2>
            <%
                }
            %>
            </tbody>
    </table>
</body>
</html>
