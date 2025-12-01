/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.TriagePrioridad;
import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.util.ConexionBD;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class TurnoRepository {
    //Atributos 

    private ConexionBD conexionBD;
    private PreparedStatement preStm;
    //Constructor
    public TurnoRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }

    //METODOS CRUD 
    //Conseguir todos los turnos en espera
    // Hacer que se peuda escoger si es para solo los de espera, par atodos para los completados y asi
    //Hacer que sea solo los turnos del dia
    
    
    public Queue<Turno> getAllTurnos() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM turnos WHERE estado = 'En espera'"; //Agregar order by para traer en orden la lista por prioridad 
        LinkedList<Turno> turnosList = new LinkedList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                int nivelPrioridad = resultSet.getInt("prioridad");
                TriagePrioridad prioridad = TriagePrioridad.fromLevel(nivelPrioridad);
                turnosList.add(new Turno(
                        resultSet.getInt("id_turno"),
                        resultSet.getString("codigo_turno"),
                        resultSet.getInt("id_usuario"),
                        resultSet.getInt("id_servicio"),
                        prioridad,
                        resultSet.getString("estado"),
                        resultSet.getString("fecha_creacion"),
                        resultSet.getString("hora_creacion")
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
        Queue<Turno> turnos = new PriorityQueue<>(turnosList);
        return turnos;
    }
    
    //Seleccion de sentencia
    public String eleccionSentenciaCodigo(String eleccion){
        String sqlQuery = "";
        if ("discapacidad".equals(eleccion)) {
            sqlQuery = "SELECT * FROM turnos WHERE estado = 'En espera' AND codigo_turno LIKE 'P%' ORDER BY id_turno DESC LIMIT 1";
        } else if ("normal".equals(eleccion)) {
            sqlQuery = "SELECT *  FROM turnos  WHERE estado = 'En espera'  AND codigo_turno NOT LIKE 'P%' ORDER BY id_turno DESC  LIMIT 1";
        }
        return sqlQuery;
    }
    
    public String getUltimoTurno(String sqlQuery) {
        Connection con = conexionBD.getConectionDB();
        String codigoTurno = "";
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                codigoTurno = resultSet.getString("codigo_turno");   
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
        return codigoTurno;
    }
    

    public Turno getTurno(int id_turno) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM turnos WHERE id_turno = ?"; //Agregar order by para traer en orden la lista por prioridad 
        Turno turno = new Turno();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, id_turno);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                int nivelPrioridad = resultSet.getInt("prioridad");
                TriagePrioridad prioridad = TriagePrioridad.fromLevel(nivelPrioridad);
                turno = new Turno(
                        resultSet.getInt("id_turno"),
                        resultSet.getString("codigo_turno"),
                        resultSet.getInt("id_usuario"),
                        resultSet.getInt("id_servicio"),
                        prioridad,
                        resultSet.getString("estado"),
                        resultSet.getString("fecha_creacion"),
                        resultSet.getString("hora_creacion")
                );
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
        return turno;
    }
    public boolean actualizarEstadoTurno(Turno turno) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE productos SET estado = ? WHERE id_turno  = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, turno.getEstado());
                this.preStm.setInt(2, turno.getId_turno());
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
        return true;
    }
    
    public boolean crearTurno(Turno turno) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO turnos VALUES(null,?,?,?,?,?,?,?)";
        String estado = "En espera";       
        java.sql.Time hora_creacion = java.sql.Time.valueOf(LocalTime.now());
        java.sql.Date fecha_creacion = java.sql.Date.valueOf(LocalDate.now());
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, turno.getCodigo());
                this.preStm.setInt(2, turno.getUsuario_id());
                this.preStm.setInt(3, turno.getServicio_id());
                this.preStm.setInt(4, turno.prioridad.getLEVEL());
                this.preStm.setString(5, estado);
                this.preStm.setDate(6, fecha_creacion);
                this.preStm.setTime(7, hora_creacion);
                
                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                }
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
        return true;
    } 
}
