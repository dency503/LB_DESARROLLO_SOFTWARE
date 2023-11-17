/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Home
 */
import java.util.Date;

public class ProductoModel {

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public ProductoModel(int idProducto, String nombre, String descripcion, double precio, int stock, int idCategoria, Date fechaCreacion, String imagenURL, Date fechaModificacion, boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
        this.fechaCreacion = fechaCreacion;
        this.imagenURL = imagenURL;
        this.fechaModificacion = fechaModificacion;
        this.activo = activo;
    }

    public ProductoModel() {
    }
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private int idCategoria;
    private Date fechaCreacion;
    private String imagenURL;
    private Date fechaModificacion;
    private boolean activo;

    // Constructors, getters, setters, and other methods
}
