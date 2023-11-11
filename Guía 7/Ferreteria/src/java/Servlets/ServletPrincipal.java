/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Models.EmpleadoModel;
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
 private ArrayList<EmpleadoModel> mostrarEmpleados(HttpServletRequest request, HttpServletResponse response)  {
        ArrayList<EmpleadoModel> listaEmpleados = new ArrayList<>();
        try (Connection connection = Conexion.obtenerConexion();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Empleados");
             ResultSet rs = pstmt.executeQuery()) {

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
        }catch (SQLException e) {
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
        if(accion==null){
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
         }else if(accion.equals("Login")){
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }else if(accion.equals("RegistrarEmpleados")){
            request.getRequestDispatcher("/RegistrarEmpleados.html").forward(request, response);
        }else if(accion.equals("RegistrarCategorias")){
            request.getRequestDispatcher("/RegistrarCategorias.html").forward(request, response);
        }else if(accion.equals("RegistrarCompras")){
            request.getRequestDispatcher("/RegistrarCompras.html").forward(request, response);
        }else if(accion.equals("RegistrarVentas")){
            request.getRequestDispatcher("/RegistrarVentas.html").forward(request, response);
        }else if(accion.equals("RegistrarClientes")){
            request.getRequestDispatcher("/RegistrarClientes.html").forward(request, response);
        }else if(accion.equals("RegistrarProveedores")){
            request.getRequestDispatcher("/RegistrarProveedores.html").forward(request, response);
        }else if(accion.equals("GestionarEmpleados")){
            mostrarEmpleados(request, response);
            request.getRequestDispatcher("/GestionarEmpleados.jsp").forward(request, response);
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
                    print.println("<title>Login Sistema Ferreteria</title>");
                    print.println("</head>");
                    print.println("<body>");
                    print.println("<h2>Error: La contraseña o/y el usuario son erróneos</h2>");
                    print.println("</body>");
                    print.println("</html>");
                }
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

}
