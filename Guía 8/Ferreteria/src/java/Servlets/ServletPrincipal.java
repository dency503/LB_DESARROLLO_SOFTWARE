/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Models.CategoriaModel;
import Models.EmpleadoModel;
import Models.ClienteModel;
import Operaciones.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletPrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPrincipal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPrincipal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
 public ArrayList<ClienteModel> mostrarClientes() {
        ArrayList<ClienteModel> listaClientes = new ArrayList<>();

        try (Connection connection = Conexion.obtenerConexion();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Clientes");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDui(rs.getString("DUI"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setTelefono(rs.getString("Telefono"));
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException aquí, por ejemplo, registrar el error o lanzar una excepción personalizada.
            e.printStackTrace(); // Este es solo un ejemplo. En un entorno de producción, deberías manejar la excepción de forma adecuada.
        }
        return listaClientes;
    }
 public ArrayList<CategoriaModel> mostrarCategorias() {
    ArrayList<CategoriaModel> listaCategorias = new ArrayList<>();

    try (Connection connection = Conexion.obtenerConexion();
         PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Categorias");
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            CategoriaModel categoria = new CategoriaModel();
            categoria.setIdCategoria(rs.getInt("idCategoria"));
            categoria.setNombre(rs.getString("nombre"));
            categoria.setDescripcion(rs.getString("descripcion"));
            listaCategorias.add(categoria);
        }
    } catch (SQLException e) {
        // Handle the SQLException here, e.g., log the error or throw a custom exception.
        e.printStackTrace(); // This is just an example. In a production environment, you should handle the exception appropriately.
    }
    return listaCategorias;
}

    private ArrayList<EmpleadoModel> mostrarEmpleados(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<EmpleadoModel> listaEmpleados = new ArrayList<>();
        try (Connection connection = Conexion.obtenerConexion(); PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Empleados"); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EmpleadoModel empleado = new EmpleadoModel();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setDui(rs.getString("DUI"));
                empleado.setIsss(rs.getInt("ISSS"));
                empleado.setNombres(rs.getString("Nombres"));
                empleado.setApellidos(rs.getString("Apellidos"));
                empleado.setFechaNacEmpleado(rs.getDate("FechaNacEmpleado"));
                empleado.setTelefono(rs.getString("Telefono"));
                empleado.setCorreo(rs.getString("Correo"));
                empleado.setIdCargo(rs.getInt("ID_Cargo"));
                empleado.setIdDireccion(rs.getInt("ID_Direccion"));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            // Manejar la excepción SQLException aquí, por ejemplo, registrar el error o lanzar una excepción personalizada.
            e.printStackTrace(); // Este es solo un ejemplo. En un entorno de producción, deberías manejar la excepción de forma adecuada.
        }
        return listaEmpleados;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (null == accion) {
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        } else switch (accion) {
            case "Login" -> request.getRequestDispatcher("/Login.jsp").forward(request, response);
            case "RegistrarEmpleados" -> request.getRequestDispatcher("/RegistrarEmpleados.html").forward(request, response);
            case "RegistrarCategorias" -> request.getRequestDispatcher("/RegistrarCategorias.html").forward(request, response);
            case "RegistrarCompras" -> request.getRequestDispatcher("/RegistrarCompras.html").forward(request, response);
            case "RegistrarVentas" -> request.getRequestDispatcher("/RegistrarVentas.html").forward(request, response);
            case "RegistrarClientes" -> request.getRequestDispatcher("/RegistrarClientes.html").forward(request, response);
            case "RegistrarProveedores" -> request.getRequestDispatcher("/RegistrarProveedores.html").forward(request, response);
            case "GestionarEmpleados" -> {
                request.setAttribute("empleadosList", mostrarEmpleados(request, response));
                request.getRequestDispatcher("/GestionarEmpleados.jsp").forward(request, response);
            }
             case "GestionarClientes" -> {
                request.setAttribute("clientesList", mostrarClientes());
                request.getRequestDispatcher("/GestionarClientes.jsp").forward(request, response);
            }
             case "GestionarCategorias" -> {
                request.setAttribute("categoriasList", mostrarCategorias());
                request.getRequestDispatcher("/GestionarCategoria.jsp").forward(request, response);
            }
             case "AgregarCategoria" -> {
             ;
                 request.getRequestDispatcher("/opcionesUsuario/AgregarCategoria.jsp").forward(request, response);
            }
            default -> {
                request.getRequestDispatcher("/error404").forward(request, response);
            }
        }
        if (accion.equals("AgregarEmpleado")) {
            if (request.getSession().getAttribute("exito") != null) {
                request.setAttribute("exito", request.getSession().getAttribute("exito"));
                request.getSession().removeAttribute("exito");
            }
            request.getRequestDispatcher("opcionesUsuario/AgregarEmpleado.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion.equals("Login")) {
            String usuario = request.getParameter("tfUsuario");
            String contrasenia = request.getParameter("tfContrasenia");

            try (PrintWriter print = response.getWriter()) {
                if (usuario.equals("admin") && contrasenia.equals("root")) {

                    request.getRequestDispatcher("/PanelAdministrador.jsp").forward(request, response);
                } else {
                    print.println("<!DOCTYPE html>");
                    print.println("<html>");
                    print.println("<head>");
                    print.println("<title>Login Sistema </title>");
                    print.println("</head>");
                    print.println("<body>");
                    print.println("<h2>Error: La contraseña o el usuario son erróneos</h2>");
                    print.println("</body>");
                    print.println("</html>");
                }
            }
        }
        switch (accion) {
            case "AgregarEmpleado" -> {
                // LOS DATOS SE LE PASAN POR PARÁMETROS A LA FUNCIÓN
                agregarEmpleado(request, response);
                // REDIRIGE NUEVAMENTE A LA VISTA DE AGREGAR EMPLEADO
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=AgregarEmpleado");
            }
            case "ModificarEmpleado" -> {
                modificarEmpleado(request, response);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarEmpleados");
            }
            case "EliminarEmpleado" -> {
                eliminarEmpleado(request, response);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarEmpleados");
            }
            case "AgregarCliente" -> {
                agregarCliente(request, response);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=AgregarCliente");
            }
            case "ModificarCliente" -> {
                modificarCliente(request, response);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarClientes");
            }
            case "EliminarCliente" -> {
                eliminarCliente(request, response);
                response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=GestionarClientes");
            }
             case "AgregarCategoria" -> {
                agregarCategoria(request, response);
                 response.sendRedirect(request.getContextPath() + "/ServletPrincipal?accion=AgregarCategoria");
            }
            default -> {
                request.getRequestDispatcher("/error404").forward(request, response);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
private void agregarCategoria(HttpServletRequest request, HttpServletResponse response) {
    String nombre = request.getParameter("nombre");
    String descripcion = request.getParameter("descripcion");

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = Conexion.obtenerConexion();
        String sql = "INSERT INTO Categorias (Nombre, Descripcion) VALUES (?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, nombre);
        pstmt.setString(2, descripcion);

        int registros = pstmt.executeUpdate();

        if (registros > 0) {
            request.getSession().setAttribute("exito", true);
            request.getSession().setAttribute("mensaje", "Categoría agregada correctamente.");
        } else {
            request.getSession().setAttribute("exito", false);
            request.getSession().setAttribute("mensaje", "No se pudo agregar la categoría. Por favor, revise los datos y vuelva a intentarlo.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        request.getSession().setAttribute("exito", false);
        request.getSession().setAttribute("mensaje", "Error al agregar la categoría: " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    private void agregarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        String dui = request.getParameter("dui");
        String isss = request.getParameter("isss");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String fechaNacimiento = request.getParameter("fechaNacEmpleado");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));
        int idDireccion = Integer.parseInt(request.getParameter("idDireccion"));

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Empleados (DUI, ISSS, Nombres, Apellidos, FechaNacEmpleado, Telefono, Correo, ID_Cargo, ID_Direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dui);
            pstmt.setString(2, isss);
            pstmt.setString(3, nombres);
            pstmt.setString(4, apellidos);
            pstmt.setString(5, fechaNacimiento);
            pstmt.setString(6, telefono);
            pstmt.setString(7, correo);
            pstmt.setInt(8, idCargo);
            pstmt.setInt(9, idDireccion);

            int registros = pstmt.executeUpdate();

            if (registros > 0) {
                request.getSession().setAttribute("exito", true);
                request.getSession().setAttribute("mensaje", "Empleado agregado correctamente.");
            } else {
                request.getSession().setAttribute("exito", false);
                request.getSession().setAttribute("mensaje", "No se pudo agregar el empleado. Por favor, revise los datos y vuelva a intentarlo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("exito", false);
            request.getSession().setAttribute("mensaje", "Error al agregar el empleado: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void modificarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        try {

            Connection conn = Conexion.obtenerConexion();

            String sql = "UPDATE Empleados SET DUI=?, ISSS=?, Nombres=?, Apellidos=?, FechaNacEmpleado=?, Telefono=?, Correo=?, ID_Cargo=?, ID_Direccion=? WHERE idEmpleado=?";

            String dui = request.getParameter("dui");
            String isss = request.getParameter("isss");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            int idCargo = Integer.parseInt(request.getParameter("idCargo"));
            int idDireccion = Integer.parseInt(request.getParameter("idDireccion"));
            int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dui);
            pstmt.setString(2, isss);
            pstmt.setString(3, nombres);
            pstmt.setString(4, apellidos);
            pstmt.setString(5, fechaNacimiento);
            pstmt.setString(6, telefono);
            pstmt.setString(7, correo);
            pstmt.setInt(8, idCargo);
            pstmt.setInt(9, idDireccion);
            pstmt.setInt(10, idEmpleado);

            int registros = pstmt.executeUpdate();

            if (registros > 0) {
                request.getSession().setAttribute("exito", true);
            } else {
                request.getSession().setAttribute("exito", false);
            }

            conn.close();
        } catch (SQLException ex) {
            request.getSession().setAttribute("exito", false);
        }
    }

    private void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response) {
        int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Empleados where idEmpleado = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idEmpleado);
           

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                // La eliminación se realizó con éxito
                // Puedes redirigir o mostrar un mensaje de éxito
                request.getSession().setAttribute("exito", true);
                request.getSession().setAttribute("mensaje", "Empleado eliminado correctamente.");
            } else {
                // No se encontró el registro para eliminar
                // Puedes redirigir o mostrar un mensaje de error
              request.getSession().setAttribute("exito", false);
                request.getSession().setAttribute("mensaje", "No se pudo eliminar el empleado. Por favor, revise los datos y vuelva a intentarlo.");
            }
        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        } finally {
            // Cerrar conexiones y declaraciones
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    
                    Conexion.cerrarConexion(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
 public void agregarCliente(HttpServletRequest request, HttpServletResponse response) {
        String dui = request.getParameter("dui");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Clientes (DUI, Nombres, Apellidos, Telefono) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dui);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellidos);
            pstmt.setString(4, telefono);

            int registros = pstmt.executeUpdate();

            if (registros > 0) {
                request.getSession().setAttribute("exito", true);
                request.getSession().setAttribute("mensaje", "Cliente agregado correctamente.");
            } else {
                request.getSession().setAttribute("exito", false);
                request.getSession().setAttribute("mensaje", "No se pudo agregar el cliente. Por favor, revise los datos y vuelva a intentarlo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("exito", false);
            request.getSession().setAttribute("mensaje", "Error al agregar el cliente: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conn);
        }
    }
 public void modificarCliente(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.obtenerConexion();
            String sql = "UPDATE Clientes SET DUI=?, Nombres=?, Apellidos=?, Telefono=? WHERE idCliente=?";
            
            String dui = request.getParameter("dui");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dui);
            pstmt.setString(2, nombres);
            pstmt.setString(3, apellidos);
            pstmt.setString(4, telefono);
            pstmt.setInt(5, idCliente);

            int registros = pstmt.executeUpdate();

            if (registros > 0) {
                request.getSession().setAttribute("exito", true);
                request.getSession().setAttribute("mensaje", "Cliente modificado correctamente.");
            } else {
                request.getSession().setAttribute("exito", false);
                request.getSession().setAttribute("mensaje", "No se pudo modificar el cliente. Por favor, revise los datos y vuelva a intentarlo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("exito", false);
            request.getSession().setAttribute("mensaje", "Error al modificar el cliente: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conn);
        }
    }

    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Clientes WHERE idCliente=?";
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idCliente);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                request.getSession().setAttribute("exito", true);
                request.getSession().setAttribute("mensaje", "Cliente eliminado correctamente.");
            } else {
                request.getSession().setAttribute("exito", false);
                request.getSession().setAttribute("mensaje", "No se pudo eliminar el cliente. Por favor, revise los datos y vuelva a intentarlo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("exito", false);
            request.getSession().setAttribute("mensaje", "Error al eliminar el cliente: " + e.getMessage());
        } finally {
            Conexion.cerrarConexion(conn);
        }
    }
}
