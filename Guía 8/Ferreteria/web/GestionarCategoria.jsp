<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Add any other necessary head elements -->
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Gestionar Categorías</h1>
 <a href="/Ferreteria?accion=AgregarCategoria" style="color: white; text-decoration: none;">Agregar Categoria</a>
        <!-- Loop through categories -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <!-- Add any other category-related headers -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="categoria" items="${categoriasList}">
                    <tr>
                        <td><c:out value="${categoria.idCategoria}" /></td>
                        <td><c:out value="${categoria.nombre}" /></td>
                        <td><c:out value="${categoria.descripcion}" /></td>
                        <!-- Add any other category-related data -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Add category management actions, links, or forms here -->

        <button class="btn btn-primary" onclick="regresar()">Regresar</button>
    </div>

    <!-- Include your Bootstrap JS link and any other necessary scripts -->

    <script>
        function regresar() {
            window.history.back();
        }
    </script>
</body>
</html>
