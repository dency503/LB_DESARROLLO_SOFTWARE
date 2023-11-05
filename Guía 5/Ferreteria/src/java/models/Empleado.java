/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.text.SimpleDateFormat;
/**
 *
 * @author Home
 */
import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private String dui;
    private int isss;
    private String nombres;
    private String apellidos;
    private Date fechaNacEmpleado;
    private String telefono;
    private String correo;
    private int idCargo;
    private int idDireccion;

    public Empleado(int idEmpleado, String dui, int isss, String nombres, String apellidos, Date fechaNacEmpleado, String telefono, String correo, int idCargo, int idDireccion) {
        this.idEmpleado = idEmpleado;
        this.dui = dui;
        this.isss = isss;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacEmpleado = fechaNacEmpleado;
        this.telefono = telefono;
        this.correo = correo;
        this.idCargo = idCargo;
        this.idDireccion = idDireccion;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getIsss() {
        return isss;
    }

    public void setIsss(int isss) {
        this.isss = isss;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacEmpleado() {
        return fechaNacEmpleado;
    }

    public void setFechaNacEmpleado(Date fechaNacEmpleado) {
        this.fechaNacEmpleado = fechaNacEmpleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }


    
}
