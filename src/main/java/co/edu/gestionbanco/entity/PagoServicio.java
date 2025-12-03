/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

public class PagoServicio {
    private int id_pago;
    private int id_usuario;
    private String referencia;
    private float valor; 

    public PagoServicio(int id_pago, int id_usuario, String referencia, float valor) {
        this.id_pago = id_pago;
        this.id_usuario = id_usuario;
        this.referencia = referencia;
        this.valor = valor;
    }

    public PagoServicio(int id_usuario, String referencia, float valor) {
        this.id_usuario = id_usuario;
        this.referencia = referencia;
        this.valor = valor;
    }
    

    public PagoServicio() {
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PagoServicio{");
        sb.append("id_pago=").append(id_pago);
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", referencia=").append(referencia);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
