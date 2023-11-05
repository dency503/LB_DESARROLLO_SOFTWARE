<%-- 
    Document   : PanelAdministrador
    Created on : 5 oct 2023, 10:46:12
    Author     : A22-PC-17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PanelAdministrador</title>
    </head>
    <body>
        <div><h1>Sistema del SuperMercado</h1></div>
        <%-- Setear la variable usuario con el parametro de la vista e imprimir --%>
        <c:set var="usuario" value="${param.tfUsuario}"/>
        <div><h2><strong>¡Bienvenido, <c:out value="${usuario}" />!</strong></h2></div>
        
        <%-- Directiva Include --%>
    <di><h3>Menú de Opciones</h3></di>
    <div>
        <%@include file="MenuAdministrador.jsp" %>
    </div>
    <div>
        <%@include file="Footer.html" %>
    </div>
    </body>
</html>
