package Models;

public class ClienteModel {
    private int idCliente;
    private String nombres;
    private String apellidos;
    private String dui;
    private String telefono;

    // Constructor, getters y setters

    // Puedes agregar métodos adicionales según sea necesario

    public ClienteModel() {
    }

    public ClienteModel(int idCliente, String nombres, String apellidos, String dui, String telefono) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.telefono = telefono;
    }

    public ClienteModel(String nombres, String apellidos, String dui, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}