/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

/**
 *
 * @author DIEGO
 */
public class Usuario {
    private int id_usuario;
    private int documento;
    private String nombre;
    private String correo;
    private String telefono;
    private String ocupacion;
    private String fechaNacimiento;
    private String lugarExpedicion;
    private String fechaExpedicion;
    private int estado;

    public Usuario(int id_usuario, int documento, String nombre, String correo, String telefono, String ocupacion, String fechaNacimiento, String lugarExpedicion, String fehcaExpedicion, int estado) {
        this.id_usuario = id_usuario;
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarExpedicion = lugarExpedicion;
        this.fechaExpedicion = fehcaExpedicion;
        this.estado = estado;
    }

    public Usuario(int documento, String nombre, String correo, String telefono, String ocupacion, String fechaNacimiento, String lugarExpedicion, String fechaExpedicion) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarExpedicion = lugarExpedicion;
        this.fechaExpedicion = fechaExpedicion;
    }


    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id_usuario=").append(id_usuario);
        sb.append(", documento=").append(documento);
        sb.append(", nombre=").append(nombre);
        sb.append(", correo=").append(correo);
        sb.append(", telefono=").append(telefono);
        sb.append(", ocupacion=").append(ocupacion);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", lugarNacimiento=").append(lugarExpedicion);
        sb.append(", fechaExpedicion=").append(fechaExpedicion);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }


}
