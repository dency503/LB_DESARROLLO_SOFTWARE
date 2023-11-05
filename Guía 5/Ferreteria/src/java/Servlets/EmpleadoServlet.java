package Servlets;

import dao.EmpleadoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import models.Empleado;

import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EmpleadoDAO empleadoDAO;

    public void init() {
        empleadoDAO = new EmpleadoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // acción predeterminada: listar empleados
        }

        switch (action) {
            case "list":
                listarEmpleados(request, response);
                break;
            case "agregar":
                agregarEmpleado(request, response);
                break;
            case "editar":
                editarEmpleadoFormulario(request, response);
                break;

            case "buscar":
                buscarEmpleadoPorId(request, response);
                break;
            case "actualizar":
                actualizarEmpleado(request, response);
                break;
            case "eliminar":
                eliminarEmpleado(request, response);
                break;
            default:
                listarEmpleados(request, response);
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<Empleado> empleados = empleadoDAO.obtenerTodosEmpleados();
        request.setAttribute("empleados", empleados);
        try {
            request.getRequestDispatcher("RegistroEmpleados.jsp").forward(request, response);
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Obtener datos del formulario y agregar el empleado utilizando empleadoDAO
        // ...
        // Redirigir a la página de lista de empleados o mostrar un mensaje de éxito
    }

    private void buscarEmpleadoPorId(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int empleadoId = Integer.parseInt(request.getParameter("id"));
        EmpleadoDAO dao = new EmpleadoDAO();
        Empleado empleado = dao.obtenerEmpleadoPorId(empleadoId);

        // Crear un objeto JSON con los datos del empleado
        Map<String, Object> jsonResponse = new HashMap<>();
        if (empleado != null) {
            jsonResponse.put("idEmpleado", empleado.getIdEmpleado());
            jsonResponse.put("dui", empleado.getDui());
            jsonResponse.put("isss", empleado.getIsss());
            jsonResponse.put("nombres", empleado.getNombres());
            jsonResponse.put("apellidos", empleado.getApellidos());
            jsonResponse.put("fechaNacEmpleado", empleado.getFechaNacEmpleado());
            jsonResponse.put("telefono", empleado.getTelefono());
            jsonResponse.put("correo", empleado.getCorreo());
            jsonResponse.put("idCargo", empleado.getIdCargo());
            jsonResponse.put("idDireccion", empleado.getIdDireccion());
        } else {
            // Si el empleado no se encuentra, puedes enviar un mensaje de error
            jsonResponse.put("error", "Empleado no encontrado");
        }

        // Configurar la respuesta del servlet como JSON
        Gson gson = new Gson();
        String jsonString = gson.toJson(jsonResponse);

        // Configurar la respuesta del servlet como JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Enviar la respuesta JSON al cliente
        response.getWriter().write(jsonString);
    }

    private void editarEmpleadoFormulario(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

    }

    private void actualizarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String dui = request.getParameter("dui");
        int isss = Integer.parseInt(request.getParameter("isss"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        Date fechaNacEmpleado = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH).parse(request.getParameter("fechaNacEmpleado"));
        String telefono = request.getParameter("telefono");
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));
        int idDireccion = Integer.parseInt(request.getParameter("idDireccion"));

        // Create an Estudiante object with the received data
        Empleado empleado = new Empleado(idEmpleado, dui, isss, nombres, apellidos, fechaNacEmpleado, telefono, correo, idCargo, idDireccion);

        // Update the student data using daoEstudiante's updateEstudiante method
        EmpleadoDAO empleadodao = new EmpleadoDAO();
        empleadodao.actualizarEmpleado(empleado);

        // Redirect the user to an appropriate page after the update (success page or another action)
        response.sendRedirect("CtrlEsstudiante");
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Obtener el ID del empleado de la solicitud y eliminar el empleado utilizando empleadoDAO
        // ...
        // Redirigir a la página de lista de empleados o mostrar un mensaje de éxito
    }
}
