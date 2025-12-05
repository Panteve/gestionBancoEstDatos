/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

/**
 *
 * @author DIEGO
 */
public class Empleado {
    
    private int id_empleado;
    private int documento;
    private String nombre;
    private String correo;
    private String telefono;
    private String cargo;
    private String contraseña;
    private int estado;
    private int caja;

    public Empleado(int id_empleado, int documento, String nombre, String correo, String telefono, String cargo, String contraseña, int estado) {
        this.id_empleado = id_empleado;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public Empleado(int documento, String nombre, String correo, String telefono, String cargo, String contraseña) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.contraseña = contraseña;
    }
    

    public Empleado() {
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("id_empleado=").append(id_empleado);
        sb.append(", documento=").append(documento);
        sb.append(", nombre=").append(nombre);
        sb.append(", correo=").append(correo);
        sb.append(", telefono=").append(telefono);
        sb.append(", cargo=").append(cargo);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append(", estado=").append(estado);
        sb.append(", caja=").append(caja);
        sb.append('}');
        return sb.toString();
    } 
}
