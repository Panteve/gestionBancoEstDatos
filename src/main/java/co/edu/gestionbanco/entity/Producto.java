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
    private int valor;

    public Producto(int id_producto, int id_usuario, String referencia, String nombre, int valor) {
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
        this.referencia = referencia;
        this.nombre = nombre;
        this.valor = valor;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", id_usuario=" + id_usuario + ", referencia=" + referencia + ", nombre=" + nombre + ", valor=" + valor + '}';
    }

    
}
