<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestionar Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table th, .table td {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Listado de Clientes</h1>

        <!-- Enlace para agregar clientes -->
        <button class="btn btn-primary">  <a href="/Ferreteria?accion=AgregarCliente" class="btn btn-primary mb-2" style="color: white; text-decoration: none;">Agregar Cliente</a></button>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>DUI</th>
                    <th>Teléfono</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cliente" items="${clientesList}">
                    <tr>
                        <td><c:out value="${cliente.idCliente}" /></td>
                        <td><c:out value="${cliente.nombres}" /></td>
                        <td><c:out value="${cliente.apellidos}" /></td>
                        <td><c:out value="${cliente.dui}" /></td>
                        <td><c:out value="${cliente.telefono}" /></td>
                        <td>
                            <form method="post" action="opcionesUsuario/ModificarCliente.jsp">
                                <input type="hidden" name="idCliente" value="${cliente.idCliente}" />
                                <input type="hidden" name="nombres" value="${cliente.nombres}" />
                                <input type="hidden" name="apellidos" value="${cliente.apellidos}" />
                                <input type="hidden" name="dui" value="${cliente.dui}" />
                                <input type="hidden" name="telefono" value="${cliente.telefono}" />
                                <input type="submit" value="Modificar" />
                            </form>
                            <form method="post" action="opcionesUsuario/EliminarCliente.jsp">
                                <input type="hidden" name="idCliente" value="${cliente.idCliente}" />
                                <input type="hidden" name="nombres" value="${cliente.nombres}" />
                                <input type="hidden" name="apellidos" value="${cliente.apellidos}" />
                                <input type="hidden" name="dui" value="${cliente.dui}" />
                                <input type="hidden" name="telefono" value="${cliente.telefono}" />
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
