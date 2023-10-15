<%-- 
    Document   : registroProducto
    Created on : 15 oct 2023, 13:59:43
    Author     : Home
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRO PRODUCTO</title>
    <!-- Enlaces de CDN para Bootstrap CSS y JavaScript -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container mt-5">
        <h1>Registro de el Producto</h1>

        <%-- Obtener parámetros del formulario --%>
        <% String nombre = request.getParameter("nombreProducto"); %>
        <% String precio = request.getParameter("precio"); %>
        <% String cantidad = request.getParameter("cantidad"); %>
        <% String entradaProducto = request.getParameter("fecha"); %>
        <% String descripcion = request.getParameter("descripcion"); %>
        <% String categoria = request.getParameter("categoria"); %>

       
        <strong>Nombre del producto: </strong><%= nombre %><br>
        <strong>Precio: </strong><%= precio %><br>
        <strong>Cantidad: </strong><%= cantidad %><br>
        <strong>Entrada del producto: </strong><%= entradaProducto %><br>
        <strong>Categoría: </strong><%= categoria %><br>
        <strong>Descripción: </strong><%= descripcion %><br>

        <!-- Toast de Bootstrap para mostrar un mensaje -->
        <div class="toast" id="successToast" data-autohide="true" data-delay="5000" style="position: absolute; top: 20px; right: 20px;">
            <div class="toast-header bg-success text-white">
                <strong class="mr-auto">Envío Exitoso</strong>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                Producto enviado con éxito.
            </div>
        </div>

    </div>

    <!-- Script para mostrar el toast automáticamente al cargar la página -->
    <script>
        $(document).ready(function(){
            $('#successToast').toast('show');
        });
    </script>

</body>
</html>


