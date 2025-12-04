/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

/**
 *
 * @author DIEGO
 */
public class Producto {
    private int id_producto;
    private int id_usuario;
    private String referencia;
    private String nombre;
    private float valor;
    private int empresarial;
    private int estado;

    public Producto(int id_producto, int id_usuario, String referencia, String nombre, float valor, int empresarial, int estado) {
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.referencia = referencia;
        this.nombre = nombre;
        this.valor = valor;
        this.empresarial = empresarial;
        this.estado = estado;
    }

    public Producto(int id_usuario, String referencia, String nombre, float valor, int empresarial) {
        this.id_usuario = id_usuario;
        this.referencia = referencia;
        this.nombre = nombre;
        this.valor = valor;
        this.empresarial = empresarial;
    }

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEmpresarial() {
        return empresarial;
    }

    public void setEmpresarial(int empresarial) {
        this.empresarial = empresarial;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("id_producto=").append(id_producto);
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", referencia=").append(referencia);
        sb.append(", nombre=").append(nombre);
        sb.append(", valor=").append(valor);
        sb.append(", empresarial=").append(empresarial);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }
}
