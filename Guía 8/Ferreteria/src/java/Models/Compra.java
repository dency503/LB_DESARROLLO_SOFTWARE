/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Home
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {
    private int idCompra;
    private int idProveedor;
    private int idEmpleado;
    private Date fechaCompra;
    private double montoCompra;
    private Date fechaCreacion;
private String nombreProveedor;
private String nombreEmpleado;
private List<DetalleCompra> detalleCompra;
    // Constructors, getters, setters

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public Compra(int idCompra, int idProveedor, int idEmpleado, Date fechaCompra, double montoCompra, Date fechaCreacion, String nombreProveedor, String nombreEmpleado, List<DetalleCompra> detalleCompra) {
        this.idCompra = idCompra;
        this.idProveedor = idProveedor;
        this.idEmpleado = idEmpleado;
        this.fechaCompra = fechaCompra;
        this.montoCompra = montoCompra;
        this.fechaCreacion = fechaCreacion;
        this.nombreProveedor = nombreProveedor;
        this.nombreEmpleado = nombreEmpleado;
        this.detalleCompra = detalleCompra;
    }

    


    public Compra() {
          this.detalleCompra = new ArrayList<>();
    }

    public Compra(int idProveedor, int idEmpleado, Date fechaCompra, double montoCompra, Date fechaCreacion) {
        this.idProveedor = idProveedor;
        this.idEmpleado = idEmpleado;
        this.fechaCompra = fechaCompra;
        this.montoCompra = montoCompra;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getMontoCompra() {
        return montoCompra;
    }

    public void setMontoCompra(double montoCompra) {
        this.montoCompra = montoCompra;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    
}
