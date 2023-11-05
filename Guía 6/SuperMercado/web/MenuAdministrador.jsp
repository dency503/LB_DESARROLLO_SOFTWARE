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
        <div>Bienvenido al Sistema del SuperMercado</div>
        <nav>
            <ul>
                <li><a href="/SuperMercado">Inicio del sistema del SuperMercado</a></li>
                <li><a href="/SuperMercado?accion=Login">Login</a></li>
                <li><a href="/SuperMercado?accion=RegistrarEmpleados">Registro de Empleados</a></li>
                <li><a href="/SuperMercado?accion=RegistrarCategorias">Registro de Categorias</a></li>
                <li><a href="/SuperMercado?accion=RegistrarProductos">Registro de Productos</a></li>
                <li><a href="/SuperMercado?accion=RegistarCompras">Registro de Compras</a></li>
                <li><a href="/SuperMercado?accion=RegistrarVentas">Registro de Ventas</a></li>
                <li><a href="/SuperMercado?accion=RegistrarClientes">Registro de Cliente</a></li>
                <li><a href="/SuperMercado?accion=RegistrarProveedores">Registro de Proveedores</a></li>
                <!--<li><a href="/SuperMercado?accion="></a></li>-->
            </ul>
        </nav>
    </body>
</html>
