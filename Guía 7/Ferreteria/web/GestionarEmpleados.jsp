<%-- 
    Document   : GestionarEmpleado
    Created on : 4 nov 2023, 22:34:20
    Author     : Home
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestionar Empleados</title>
</head>
<body>
    <h1>Listado de Empleados</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>DUI</th>
            <th>ISSS</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Fecha de Nacimiento</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>ID de Cargo</th>
            <th>ID de Dirección</th>
         
        </tr>
        <c:forEach var="empleado" items="${listaEmpleados}">
            <tr>
                <td><c:out value="${empleado.idEmpleado}" /></td>
                <td><c:out value="${empleado.dui}" /></td>
                <td><c:out value="${empleado.isss}" /></td>
                <td><c:out value="${empleado.nombres}" /></td>
                <td><c:out value="${empleado.apellidos}" /></td>
                <td><c:out value="${empleado.fechaNacEmpleado}" /></td>
                <td><c:out value="${empleado.telefono}" /></td>
                <td><c:out value="${empleado.correo}" /></td>
                <td><c:out value="${empleado.idCargo}" /></td>
                <td><c:out value="${empleado.idDireccion}" /></td>
                <!-- Muestra más atributos del empleado según sea necesario -->
                
            </tr>
        </c:forEach>
    </table>
    <script>
            function regresar(){
                window.history.back();
            }
        </script>

</body>
</html>
