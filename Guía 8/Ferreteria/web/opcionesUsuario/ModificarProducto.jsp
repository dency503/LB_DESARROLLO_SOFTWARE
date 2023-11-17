<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Modificar Producto | Ferreteria</title>
</head>
<body>
    <div class="container mt-5">
        <h1>Modificar Producto</h1>
        
        <form method="post" action="/Ferreteria/ModificarProductoServlet">
            <input type="hidden" name="idProducto" value="${producto.idProducto}" />
            
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre del Producto</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="${producto.nombre}" required>
            </div>

            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción</label>
                <textarea class="form-control" id="descripcion" name="descripcion" rows="3" required>${producto.descripcion}</textarea>
            </div>

            <div class="mb-3">
                <label for="precio" class="form-label">Precio</label>
                <input type="text" class="form-control" id="precio" name="precio" value="${producto.precio}" required>
            </div>

            <div class="mb-3">
                <label for="stock" class="form-label">Stock</label>
                <input type="text" class="form-control" id="stock" name="stock" value="${producto.stock}" required>
            </div>

            <div class="mb-3">
                <label for="idCategoria" class="form-label">ID de Categoría</label>
                <input type="text" class="form-control" id="idCategoria" name="idCategoria" value="${producto.idCategoria}" required>
            </div>

            <div class="mb-3">
                <label for="fechaCreacion" class="form-label">Fecha de Creación</label>
                <input type="text" class="form-control" id="fechaCreacion" name="fechaCreacion" value="${producto.fechaCreacion}" required>
            </div>

            <div class="mb-3">
                <label for="imagenURL" class="form-label">URL de la Imagen</label>
                <input type="text" class="form-control" id="imagenURL" name="imagenURL" value="${producto.imagenURL}" required>
            </div>

            <div class="mb-3">
                <label for="fechaModificacion" class="form-label">Fecha de Modificación</label>
                <input type="text" class="form-control" id="fechaModificacion" name="fechaModificacion" value="${producto.fechaModificacion}" required>
            </div>

            <div class="mb-3">
                <label for="activo" class="form-label">Activo</label>
                <input type="checkbox" class="form-check-input" id="activo" name="activo" ${producto.activo ? 'checked' : ''}>
            </div>

            <!-- Add any other fields related to product modification -->

            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
        </form>

        <div class="mt-3">
            <a href="/Ferreteria">Regresar a la Lista de Productos en Ferreteria</a>
        </div>
    </div>

    <!-- Include your Bootstrap JS link and any other necessary scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
