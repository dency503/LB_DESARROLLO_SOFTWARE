/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Home
 */
public class Proveedor {
     private int idProveedor;
    private String telefono;
    private int idDireccion;
    private String nombre;

    // Constructors, getters, and setters

    public Proveedor() {
        // Default constructor
    }

    public Proveedor(int idProveedor, String telefono, int idDireccion, String nombre) {
        this.idProveedor = idProveedor;
        this.telefono = telefono;
        this.idDireccion = idDireccion;
        this.nombre = nombre;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
