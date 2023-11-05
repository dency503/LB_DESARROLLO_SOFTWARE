<%@ page import="java.util.List" %>
<%@ page import="models.Empleado" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <title>REGISTRO EMPLEADOS</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

        <style>
            body {
                padding: 20px;
            }

            .button-container {
                margin-top: 20px;
            }

            .edit-btn, .delete-btn {
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1 class="mb-4">Registro de Empleados <i class="fas fa-users"></i></h1>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DUI</th>
                        <th>ISSS</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Fecha Nacimiento</th>
                        <th>Teléfono</th>
                        <th>Correo</th>
                        <th>ID Cargo</th>
                        <th>ID Dirección</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>${empleado.idEmpleado}</td>
                            <td>${empleado.dui}</td>
                            <td>${empleado.isss}</td>
                            <td>${empleado.nombres}</td>
                            <td>${empleado.apellidos}</td>
                            <td>${empleado.fechaNacEmpleado}</td>
                            <td>${empleado.telefono}</td>
                            <td>${empleado.correo}</td>
                            <td>${empleado.idCargo}</td>
                            <td>${empleado.idDireccion}</td>
                            <td>
                                <button type="button" class="btn btn-primary  edit-btn"  data-bs-toggle="modal" data-id="${empleado.idEmpleado}"  data-bs-target="#editModal">
                                    <span><i
                                            class="fas fa-edit"></i> Editar</span>
                                </button> |
                                <span class="delete-btn text-danger" ><i
                                        class="fas fa-trash-alt"></i> Eliminar</span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <div class="button-container">
                <button class="btn btn-primary" onclick="regresar()"><i class="fas fa-arrow-left"></i> Regresar</button>
            </div>
        </div>

        <!-- Agrega este modal en tu archivo HTML -->

        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="editModalLabel">Editar Empleado</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <form id="editForm">
                            <div class="form-group">
                                <label for="idEmpleado">ID:</label>
                                <input type="text" class="form-control" id="idEmpleado" disabled>
                            </div>
                            <div class="form-group">
                                <label for="dui">DUI:</label>
                                <input type="text" class="form-control" id="dui">
                            </div>
                            <div class="form-group">
                                <label for="isss">ISSS:</label>
                                <input type="text" class="form-control" id="isss">
                            </div>
                            <div class="form-group">
                                <label for="nombres">Nombres:</label>
                                <input type="text" class="form-control" id="nombres">
                            </div>
                            <div class="form-group">
                                <label for="apellidos">Apellidos:</label>
                                <input type="text" class="form-control" id="apellidos">
                            </div>
                            <div class="form-group">
                                <label for="fechaNac">Fecha de Nacimiento:</label>
                                <input type="date" class="form-control" id="fechaNac">
                            </div>
                            <div class="form-group">
                                <label for="telefono">Teléfono:</label>
                                <input type="tel" class="form-control" id="telefono">
                            </div>
                            <div class="form-group">
                                <label for="correo">Correo:</label>
                                <input type="email" class="form-control" id="correo">
                            </div>
                            <div class="form-group">
                                <label for="idCargo">ID de Cargo:</label>
                                <input type="text" class="form-control" id="idCargo">
                            </div>
                            <div class="form-group">
                                <label for="idDireccion">ID de Dirección:</label>
                                <input type="text" class="form-control" id="idDireccion">
                            </div>
                        </form>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary">Guardar Cambios</button>
                    </div>
                </div>
            </div>
        </div>



        <script>
            // Función para editar empleado
            function obtenerEmpleadoPorId(empleadoId) {

                return new Promise((resolve, reject) => {
                    // Hacer una solicitud GET al servidor para obtener los datos del empleado con el ID proporcionado
                    fetch(`/Ferreteria/EmpleadoServlet?action=buscar&id=`+empleadoId, {
                        method: 'GET'
                    })
                            .then(response => {
                                // Verificar si la solicitud fue exitosa
                                if (response.ok) {
                                    // Parsear la respuesta JSON
                                    return response.json();
                                } else {
                                    // Rechazar la promesa si la solicitud no fue exitosa
                                    throw new Error('Error al obtener los datos del empleado.');
                                }
                            })
                            .then(data => {
                                // Resolver la promesa con los datos del empleado
                                resolve(data);
                            })
                            .catch(error => {
                                // Rechazar la promesa en caso de error
                                reject(error);
                            });
                });
            }


// Función para abrir el modal de edición
            document.addEventListener('DOMContentLoaded', function () {
                const editButtons = document.querySelectorAll('.edit-btn');
                editButtons.forEach(button => {
                    button.addEventListener('click', () => {
                        const empleadoId = button.getAttribute('data-id');


                        // Aquí debes cargar los datos del empleado con el ID correspondiente
                        obtenerEmpleadoPorId(empleadoId)
                                .then(empleado => {
                                    // Llenar el formulario con los datos del empleado
                                    document.getElementById('idEmpleado').value = empleado.idEmpleado;
                                    document.getElementById('dui').value = empleado.dui;
                                    document.getElementById('isss').value = empleado.isss;
                                    document.getElementById('nombres').value = empleado.nombres;
                                    document.getElementById('apellidos').value = empleado.apellidos;
                                    document.getElementById('fechaNac').value = empleado.fechaNacEmpleado; // Asegúrate de tener el formato correcto
                                    document.getElementById('telefono').value = empleado.telefono;
                                    document.getElementById('correo').value = empleado.correo;
                                    document.getElementById('idCargo').value = empleado.idCargo;
                                    document.getElementById('idDireccion').value = empleado.idDireccion;

                                   
                                })
                                .catch(error => {
                                    console.error('Error:', error);
                                    // Handle error
                                });
                    });
                });

                // Resto del código permanece igual
            });


            function guardarCambios() {
                // Implementa la lógica para guardar los cambios hechos en el formulario
            }

            // Función para eliminar empleado
            const deleteButtons = document.querySelectorAll('.delete-btn');
            deleteButtons.forEach(button => {
                button.addEventListener('click', () => {
                    const empleadoId = button.getAttribute('data-id');
                    // Mostrar un mensaje de confirmación antes de eliminar el empleado
                    const confirmDelete = confirm('¿Estás seguro de que quieres eliminar este empleado?');
                    if (confirmDelete) {
                        // Enviar una solicitud al servidor para eliminar el empleado con el ID correspondiente
                        fetch(`/eliminarEmpleado?id=${empleadoId}`, {
                            method: 'DELETE'
                        })
                                .then(response => response.json())
                                .then(data => {
                                    // Mostrar un mensaje de éxito o error después de la eliminación
                                    if (data.success) {
                                        alert('Empleado eliminado exitosamente.');
                                        // Recargar la página para mostrar la lista actualizada de empleados
                                        location.reload();
                                    } else {
                                        alert('Error al eliminar el empleado. Por favor, inténtalo de nuevo más tarde.');
                                    }
                                })
                                .catch(error => {
                                    console.error('Error:', error);
                                    alert('Error al eliminar el empleado. Por favor, inténtalo de nuevo más tarde.');
                                });
                    }
                });
            });

            function regresar() {
                // Implementa la lógica para regresar a la página anterior
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>

</html>
