<%-- 
    Document   : MenuAdministrador
    Created on : 5 oct 2023, 11:39:47
    Author     : A22-PC-17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú Administrador</title>
    </head>
    <body>
        <div>Bienvenido al Sistema</div>
        <nav>
            <ul>
                <li><a href="/Ferreteria">Inicio del sistema</a></li>
                <li><a href="/Ferreteria?accion=Login">Login</a></li>
                <li><a href="/Ferreteria?accion=RegistrarEmpleados">Registro de Empleados</a></li>
                <li><a href="/Ferreteria?accion=RegistrarCategorias">Registro de Categorias</a></li>
                <li><a href="/Ferreteria?accion=RegistrarProductos">Registro de Productos</a></li>
                <li><a href="/Ferreteria?accion=RegistarCompras">Registro de Compras</a></li>
                <li><a href="/Ferreteria?accion=RegistrarVentas">Registro de Ventas</a></li>
                <li><a href="/Ferreteria?accion=RegistrarClientes">Registro de Cliente</a></li>
                <li><a href="/Ferreteria?accion=RegistrarProveedores">Registro de Proveedores</a></li>
                <!-- Add more links as needed -->
            </ul>
        </nav>
    </body>
</html>
