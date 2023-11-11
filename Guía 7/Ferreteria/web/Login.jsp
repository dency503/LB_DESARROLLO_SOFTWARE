

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesión</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <!-- Font Awesome CSS link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body class="container mt-5">
    <form method="POST" action="/Ferreteria/ServletPrincipal?accion=Login" id="formLogin">
        <!-- Error message container -->
        <div id="errorContainer"></div>

        <div><h1>Bienvenido a la Ferretería</h1></div>
  <c:set var ="fechaActual"  value= "<%= new java.util.Date() %>" />
        <c:set var="formatoFecha" value="dd/MM/yyyy" />
        <!-- Display current date -->
        <div class="mt-3">
            <label>
                <strong>
                    <c:out value="Fecha actual: "/>
                    <fmt:formatDate value="${fechaActual}" pattern="${formatoFecha}" />
                </strong>
            </label>
        </div><br>

        <!-- User input fields -->
        <div class="form-group">
            <label for="idtfUsuario">Usuario:</label>
            <input type="text" class="form-control" name="tfUsuario" id="idtfUsuario" required>
        </div>
        <div class="form-group">
            <label for="idtfContrasenia">Contraseña:</label>
            <input type="password" class="form-control" name="tfContrasenia" id="idtfContrasenia" required>
        </div>

        <!-- Submit button -->
        <div class="mt-3">
            <button type="submit" class="btn btn-primary">
                Iniciar Sesión <i class="fas fa-sign-in-alt"></i>
            </button>
        </div>
    </form>

    <!-- Bootstrap JS and dependencies -->
 
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
