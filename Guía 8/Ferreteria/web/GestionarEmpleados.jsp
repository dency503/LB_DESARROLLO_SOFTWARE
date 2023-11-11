<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestionar Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            .table th, .table td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5">
            <h1 class="mb-4">Listado de Empleados</h1>
            <button class="btn btn-primary">
    <a href="/Ferreteria?accion=AgregarEmpleado" style="color: white; text-decoration: none;">Agregar Empleado</a>
</button>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
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
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${empleadosList}">
                        <tr>
                            <td><c:out value="${item.idEmpleado}" /></td>
                            <td><c:out value="${item.dui}" /></td>
                            <td><c:out value="${item.isss}" /></td>
                            <td><c:out value="${item.nombres}" /></td>
                            <td><c:out value="${item.apellidos}" /></td>
                            <td><c:out value="${item.fechaNacEmpleado}" /></td>
                            <td><c:out value="${item.telefono}" /></td>
                            <td><c:out value="${item.correo}" /></td>
                            <td><c:out value="${item.idCargo}" /></td>
                            <td><c:out value="${item.idDireccion}" /></td>
                            <td>
                                <form method="post" action="opcionesUsuario/ModificarEmpleado.jsp">
                                    <input type="hidden" name="idEmpleado" value="${item.idEmpleado}" />
                                    <input type="hidden" name="dui" value="${item.dui}" />
                                    <input type="hidden" name="isss" value="${item.isss}" />
                                    <input type="hidden" name="nombres" value="${item.nombres}" />
                                    <input type="hidden" name="apellidos" value="${item.apellidos}" />
                                    <input type="hidden" name="fechaNacEmpleado" value="${item.fechaNacEmpleado}" />
                                    <input type="hidden" name="telefono" value="${item.telefono}" />
                                    <input type="hidden" name="correo" value="${item.correo}" />
                                    <input type="hidden" name="idCargo" value="${item.idCargo}" />
                                    <input type="hidden" name="idDireccion" value="${item.idDireccion}" />
                                    <input type="submit" value="Modificar" />
                                </form>
                                <form method="post" action="opcionesUsuario/EliminarEmpleado.jsp">
                                    <input type="hidden" name="idEmpleado" value="${item.idEmpleado}" />
                                    <input type="hidden" name="dui" value="${item.dui}" />
                                    <input type="hidden" name="isss" value="${item.isss}" />
                                    <input type="hidden" name="nombres" value="${item.nombres}" />
                                    <input type="hidden" name="apellidos" value="${item.apellidos}" />
                                    <input type="hidden" name="fechaNacEmpleado" value="${item.fechaNacEmpleado}" />
                                    <input type="hidden" name="telefono" value="${item.telefono}" />
                                    <input type="hidden" name="correo" value="${item.correo}" />
                                    <input type="hidden" name="idCargo" value="${item.idCargo}" />
                                    <input type="hidden" name="idDireccion" value="${item.idDireccion}" />
                                    <input type="submit" value="Eliminar" />
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button class="btn btn-primary" onclick="regresar()">Regresar</button>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script>
                function regresar() {
                    window.history.back();
                }
        </script>
    </body>
</html>
