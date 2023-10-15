<%-- 
    Document   : Login
    Created on : 5 oct 2023, 10:39:44
    Author     : A22-PC-17
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesión</title>
    <!-- Enlaces de CDN para Bootstrap CSS y Font Awesome -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>

<body>
    <div class="container mt-5">
        <form method="POST" action="/Ferreteria/ServletPrincipal?accion=Login" id="formLogin">
            <div id="resultLogin"></div>
            <div class="mb-4">
                <h1>Bienvenido al Sistema del SuperMercado</h1>
            </div>
            
            <%-- Insercion de comentario Java --%>
            <%-- Forma legible --%>
            <%
                java.util.Date fechaActual = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/YYYY");
                String fechaActualLegible = sdf.format(fechaActual);
            %>
            <p class="mb-4">Fecha actual: <strong><%= fechaActualLegible %></strong></p>

            <div class="form-group">
                <label for="idtfUsuario">Usuario:</label>
                <input type="text" class="form-control" name="tfUsuario" id="idtfUsuario" required>
            </div>

            <div class="form-group">
                <label for="idtfContrasenia">Contraseña:</label>
                <input type="password" class="form-control" name="tfContrasenia" id="idtfContrasenia" required>
            </div>

            <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i> Iniciar Sesión</button>
        </form>
    </div>

    <!-- Scripts de Bootstrap JS y Font Awesome -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Enlace de CDN para Font Awesome JS -->
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>

</html>
