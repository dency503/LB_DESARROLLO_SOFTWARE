/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Home
 */
import procesos.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Empleado;

public class EmpleadoDAO {
    private Connection connection;
private Conexion conexion;
    public EmpleadoDAO() {
        conexion = new Conexion();
    connection = conexion.Conectar();
    }

    public List<Empleado> obtenerTodosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM Empleados";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setDui(resultSet.getString("DUI"));
                empleado.setIsss(resultSet.getInt("ISSS"));
                empleado.setNombres(resultSet.getString("Nombres"));
                empleado.setApellidos(resultSet.getString("Apellidos"));
                empleado.setFechaNacEmpleado(resultSet.getDate("FechaNacEmpleado"));
                empleado.setTelefono(resultSet.getString("Telefono"));
                empleado.setCorreo(resultSet.getString("Correo"));
                empleado.setIdCargo(resultSet.getInt("ID_Cargo"));
                empleado.setIdDireccion(resultSet.getInt("ID_Direccion"));

                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    public Empleado obtenerEmpleadoPorId(int idEmpleado) {
        String query = "SELECT * FROM Empleados WHERE idEmpleado = ?";
        Empleado empleado = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setDui(resultSet.getString("DUI"));
                empleado.setIsss(resultSet.getInt("ISSS"));
                empleado.setNombres(resultSet.getString("Nombres"));
                empleado.setApellidos(resultSet.getString("Apellidos"));
                empleado.setFechaNacEmpleado(resultSet.getDate("FechaNacEmpleado"));
                empleado.setTelefono(resultSet.getString("Telefono"));
                empleado.setCorreo(resultSet.getString("Correo"));
                empleado.setIdCargo(resultSet.getInt("ID_Cargo"));
                empleado.setIdDireccion(resultSet.getInt("ID_Direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }

    public void agregarEmpleado(Empleado empleado) {
        String query = "INSERT INTO Empleados (DUI, ISSS, Nombres, Apellidos, FechaNacEmpleado, Telefono, Correo, ID_Cargo, ID_Direccion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado.getDui());
            statement.setInt(2, empleado.getIsss());
            statement.setString(3, empleado.getNombres());
            statement.setString(4, empleado.getApellidos());
            statement.setDate(5, new java.sql.Date(empleado.getFechaNacEmpleado().getTime()));
            statement.setString(6, empleado.getTelefono());
            statement.setString(7, empleado.getCorreo());
            statement.setInt(8, empleado.getIdCargo());
            statement.setInt(9, empleado.getIdDireccion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmpleado(Empleado empleado) {
        String query = "UPDATE Empleados SET DUI=?, ISSS=?, Nombres=?, Apellidos=?, FechaNacEmpleado=?, " +
                "Telefono=?, Correo=?, ID_Cargo=?, ID_Direccion=? WHERE idEmpleado=?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, empleado.getDui());
            statement.setInt(2, empleado.getIsss());
            statement.setString(3, empleado.getNombres());
            statement.setString(4, empleado.getApellidos());
            statement.setDate(5, new java.sql.Date(empleado.getFechaNacEmpleado().getTime()));
            statement.setString(6, empleado.getTelefono());
            statement.setString(7, empleado.getCorreo());
            statement.setInt(8, empleado.getIdCargo());
            statement.setInt(9, empleado.getIdDireccion());
            statement.setInt(10, empleado.getIdEmpleado());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(int idEmpleado) {
        String query = "DELETE FROM Empleados WHERE idEmpleado = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idEmpleado);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
