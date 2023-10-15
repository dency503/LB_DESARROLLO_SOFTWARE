<%-- 
    Document   : MenuAdministrador
    Created on : 5 oct 2023, 11:39:47
    Author     : A22-PC-17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html>
<html lang="es">

<head>
    <title>Ferretería Online</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Enlaces de CDN para Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 60px;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
        <a class="navbar-brand" href="#">Ferretería Online</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria">Inicio Sistema</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=Login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroProductos">Registro de productos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroEmpleados">Registro de empleados</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroProveedores">Registro de proveedores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroClientes">Registro de clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroVentas">Registro de ventas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Ferreteria?accion=RegistroCompras">Registro de compras</a>
                </li>
            </ul>
        </div>
    </nav>

   
    <!-- Scripts de Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>


