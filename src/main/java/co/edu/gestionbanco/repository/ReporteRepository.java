/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.Reporte;
import co.edu.gestionbanco.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DIEGO
 */
public class ReporteRepository {

    //Atributos 
    private ConexionBD conexionBD;//Objeto
    private PreparedStatement preStm;

    //Constructor
    public ReporteRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }

    private String eleccionQuery(String docEmpleadoStr, String docUsuarioStr, String servicio) {
        StringBuilder query = new StringBuilder("SELECT \n"
                + "    t.id_turno,\n"
                + "    t.codigo_turno,\n"
                + "    t.fecha_creacion,\n"
                + "    t.hora_creacion,\n"
                + "    u.nombre AS nombreUsuario,\n"
                + "    e.nombre AS nombreEmpleado,\n"
                + "    s.nombre AS servicio,\n"
                + "    h.hora_llamado AS horaLlamadoTurno,\n"
                + "    h.hora_finalizacion AS horaFinalizacionTurno\n"
                + "FROM turnos t\n"
                + "INNER JOIN historial_atencion h  ON t.id_turno = h.id_turno\n"
                + "INNER JOIN usuarios u  ON t.id_usuario = u.id_usuario\n"
                + "INNER JOIN servicios s ON t.id_servicio = s.id_servicio\n"
                + "INNER JOIN empleados e ON h.id_empleado = e.id_empleado\n"
                + "\n"
                + "WHERE t.estado = 'Atendido'"
                + "AND t.fecha_creacion BETWEEN ? AND ? ");

        if (!docEmpleadoStr.isBlank()) {
            query.append("AND e.documento = ? ");
        }

        if (!docUsuarioStr.isBlank()) {
            query.append("AND u.documento = ? ");
        }

        if (!servicio.isBlank()) {
            query.append("AND s.nombre = ? ");
        }
        return query.toString();
    }

    public List<Reporte> getReporte(String fechaDesde, String fechaHasta, String docEmpleadoStr, String docUsuarioStr, String servicio) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = eleccionQuery(docEmpleadoStr, docUsuarioStr, servicio);
        List<Reporte> listaReporte = new ArrayList<>();
        java.sql.Date fechaDesdeSql = java.sql.Date.valueOf(fechaDesde);
        java.sql.Date fechaHastaSql = java.sql.Date.valueOf(fechaHasta);
        try {

            int indice = 3;
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setDate(1, fechaDesdeSql);
            this.preStm.setDate(2, fechaHastaSql);

            if (!docEmpleadoStr.isBlank()) {
                this.preStm.setInt(indice, Integer.parseInt(docEmpleadoStr));
                indice++;
            }

            if (!docUsuarioStr.isBlank()) {
                this.preStm.setInt(indice, Integer.parseInt(docUsuarioStr));
                indice++;
            }

            if (!servicio.isBlank()) {
                this.preStm.setString(indice, servicio);
                indice++;
            }

            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                listaReporte.add(new Reporte(
                        resultSet.getInt("id_turno"),
                        resultSet.getString("codigo_turno"),
                        resultSet.getString("nombreUsuario"),
                        resultSet.getString("nombreEmpleado"),
                        resultSet.getString("servicio"),
                        resultSet.getDate("fecha_creacion").toLocalDate(),
                        resultSet.getTime("hora_creacion").toLocalTime(),
                        resultSet.getTime("horaLlamadoTurno").toLocalTime(),
                        resultSet.getTime("horaFinalizacionTurno").toLocalTime()
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en la sentencia:" + e.getMessage());
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if ((con != null) && (this.preStm != null)) {
                try {
                    con.close();
                    this.preStm.close();
                    this.preStm = null;
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return listaReporte;
    }
}
