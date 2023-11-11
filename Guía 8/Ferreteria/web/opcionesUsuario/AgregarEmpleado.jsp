<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Empleado</title>
    <!-- Agrega los enlaces a Bootstrap y Font Awesome -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Agrega un poco de estilo personalizado -->
    <style>
        body {
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mt-5 mb-4">Agregar Empleado</h1>
        <form action="/Ferreteria/ServletPrincipal?accion=AgregarEmpleado" method="post">
            <div class="form-group">
                <label for="dui">DUI:</label>
                <input type="text" class="form-control" id="dui" name="dui" required>
            </div>

            <div class="form-group">
                <label for="isss">ISSS:</label>
                <input type="text" class="form-control" id="isss" name="isss" required>
            </div>

            <div class="form-group">
                <label for="nombres">Nombres:</label>
                <input type="text" class="form-control" id="nombres" name="nombres" required>
            </div>

            <div class="form-group">
                <label for="apellidos">Apellidos:</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" required>
            </div>

            <div class="form-group">
                <label for="fechaNacEmpleado">Fecha de Nacimiento:</label>
                <input type="date" class="form-control" id="fechaNacEmpleado" name="fechaNacEmpleado" required>
            </div>

            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required>
            </div>

            <div class="form-group">
                <label for="correo">Correo:</label>
                <input type="email" class="form-control" id="correo" name="correo" required>
            </div>

            <div class="form-group">
                <label for="idCargo">ID Cargo:</label>
                <input type="text" class="form-control" id="idCargo" name="idCargo" required>
            </div>

            <div class="form-group">
                <label for="idDireccion">ID Dirección:</label>
                <input type="text" class="form-control" id="idDireccion" name="idDireccion" required>
            </div>

            <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Guardar</button>
        </form>
    </div>

    <!-- Agrega los scripts de Bootstrap -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
