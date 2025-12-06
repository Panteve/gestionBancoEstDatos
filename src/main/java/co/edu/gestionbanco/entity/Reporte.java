/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author DIEGO
 */
public class Reporte {
    private int turnoId;
    private String codigoTurno;
    private String nombreUsuario;
    private String nombreEmpleado;
    private String servicio;
    private LocalDate fechaCreacionTurno; 
    private LocalTime horaCreacionTurno;
    private LocalTime horaLlamadoTurno;
    private LocalTime horaFinalizacionTurno;
    
    private Duration tiempoEnCola;    // desde creación - llamado
    private Duration tiempoAtencion;  // desde llamado - finalización
    private Duration tiempoTotal;     // desde creación - finalización

    public Reporte(int turnoId, String codigoTurno, String nombreUsuario, String nombreEmpleado, String servicio, LocalDate fechaCreacionTurno, LocalTime horaCreacionTurno, LocalTime horaLlamadoTurno, LocalTime horaFinalizacionTurno) {
        this.turnoId = turnoId;
        this.codigoTurno = codigoTurno;
        this.nombreUsuario = nombreUsuario;
        this.nombreEmpleado = nombreEmpleado;
        this.servicio = servicio;
        this.fechaCreacionTurno = fechaCreacionTurno;
        this.horaCreacionTurno = horaCreacionTurno;
        this.horaLlamadoTurno = horaLlamadoTurno;
        this.horaFinalizacionTurno = horaFinalizacionTurno;
        
        tiempoEnCola = Duration.between(horaCreacionTurno, horaLlamadoTurno);
        tiempoAtencion = Duration.between(horaLlamadoTurno, horaFinalizacionTurno);
        tiempoTotal = Duration.between(horaCreacionTurno, horaFinalizacionTurno);
    }

    public int getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(int turnoId) {
        this.turnoId = turnoId;
    }
    

    public String getCodigoTurno() {
        return codigoTurno;
    }

    public void setCodigoTurno(String codigoTurno) {
        this.codigoTurno = codigoTurno;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public LocalDate getFechaCreacionTurno() {
        return fechaCreacionTurno;
    }

    public void setFechaCreacionTurno(LocalDate fechaCreacionTurno) {
        this.fechaCreacionTurno = fechaCreacionTurno;
    }

    public LocalTime getHoraCreacionTurno() {
        return horaCreacionTurno;
    }

    public void setHoraCreacionTurno(LocalTime horaCreacionTurno) {
        this.horaCreacionTurno = horaCreacionTurno;
    }

    public LocalTime getHoraLlamadoTurno() {
        return horaLlamadoTurno;
    }

    public void setHoraLlamadoTurno(LocalTime horaLlamadoTurno) {
        this.horaLlamadoTurno = horaLlamadoTurno;
    }

    public LocalTime getHoraFinalizacionTurno() {
        return horaFinalizacionTurno;
    }

    public void setHoraFinalizacionTurno(LocalTime horaFinalizacionTurno) {
        this.horaFinalizacionTurno = horaFinalizacionTurno;
    }

    public Duration getTiempoEnCola() {
        return tiempoEnCola;
    }

    public void setTiempoEnCola(Duration tiempoEnCola) {
        this.tiempoEnCola = tiempoEnCola;
    }

    public Duration getTiempoAtencion() {
        return tiempoAtencion;
    }

    public void setTiempoAtencion(Duration tiempoAtencion) {
        this.tiempoAtencion = tiempoAtencion;
    }

    public Duration getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Duration tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte{");
        sb.append("turnoId=").append(turnoId);
        sb.append(", codigoTurno=").append(codigoTurno);
        sb.append(", nombreUsuario=").append(nombreUsuario);
        sb.append(", nombreEmpleado=").append(nombreEmpleado);
        sb.append(", servicio=").append(servicio);
        sb.append(", fechaCreacionTurno=").append(fechaCreacionTurno);
        sb.append(", horaCreacionTurno=").append(horaCreacionTurno);
        sb.append(", horaLlamadoTurno=").append(horaLlamadoTurno);
        sb.append(", horaFinalizacionTurno=").append(horaFinalizacionTurno);
        sb.append(", tiempoEnCola=").append(tiempoEnCola);
        sb.append(", tiempoAtencion=").append(tiempoAtencion);
        sb.append(", tiempoTotal=").append(tiempoTotal);
        sb.append('}');
        return sb.toString();
    }

   
    
    
}
