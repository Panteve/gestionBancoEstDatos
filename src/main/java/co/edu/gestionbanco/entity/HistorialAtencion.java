/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

/**
 *
 * @author DIEGO
 */
public class HistorialAtencion {
    private int id_historial;
    private int id_empleado;
    private int id_turno;
    private String horaLlamado;
    private String horaFinalizacion;

    public HistorialAtencion(int id_historial,int id_empleado, int id_turno, String horaLlamado, String horaFinalizacion) {
        this.id_historial = id_historial;
        this.id_empleado = id_empleado;
        this.id_turno = id_turno;
        this.horaLlamado = horaLlamado;
        this.horaFinalizacion = horaFinalizacion;
    }

    public HistorialAtencion(int id_empleado, int id_turno, String horaLlamado, String horaFinalizacion) {
        this.id_empleado = id_empleado;
        this.id_turno = id_turno;
        this.horaLlamado = horaLlamado;
        this.horaFinalizacion = horaFinalizacion;
    }

    public HistorialAtencion() {
    }
    

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public String getHoraLlamado() {
        return horaLlamado;
    }

    public void setHoraLlamado(String horaLlamado) {
        this.horaLlamado = horaLlamado;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    public void setHoraFinalizacion(String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HistorialAtencion{");
        sb.append("id_historial=").append(id_historial);
        sb.append(", id_empleado=").append(id_empleado);
        sb.append(", id_turno=").append(id_turno);
        sb.append(", horaLlamado=").append(horaLlamado);
        sb.append(", horaFinalizacion=").append(horaFinalizacion);
        sb.append('}');
        return sb.toString();
    }

    
    
}
