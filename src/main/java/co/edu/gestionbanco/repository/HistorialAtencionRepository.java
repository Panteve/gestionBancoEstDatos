/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.HistorialAtencion;
import co.edu.gestionbanco.entity.Usuario;
import co.edu.gestionbanco.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class HistorialAtencionRepository {

    private ConexionBD conexionBD;//Objeto
    private PreparedStatement preStm;

    public HistorialAtencionRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }
    
     public List<HistorialAtencion> getAllHistorialAtencion() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM historial_atencion";
        List<HistorialAtencion> historialAtencionList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                historialAtencionList.add(new HistorialAtencion(
                        resultSet.getInt("id_historial"),
                        resultSet.getInt("id_empleado"),
                        resultSet.getInt("id_turno"),
                        resultSet.getString("Hora Llamado"),
                        resultSet.getString("Hora Finalizacion")

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
        return historialAtencionList;
    }
     
     //Este metodo se debe usar en conjunto para saber informacion de atencion de un turno por lo tanto se debe buscar por el id del turno
     public HistorialAtencion getHistorialAtencion(int id_turno) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM historial_atencion WHERE id_turno = ?";
        HistorialAtencion historial = new HistorialAtencion();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, id_turno);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                historial = new HistorialAtencion(
                        resultSet.getInt("id_historial"),
                        resultSet.getInt("id_empleado"),
                        resultSet.getInt("id_turno"),
                        resultSet.getString("Hora Llamado"),
                        resultSet.getString("Hora Finalizacion")
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
        return historial;
    }
     
     public boolean registrarHistorialAtencion(HistorialAtencion historial) { 
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO historial_atencion VALUES(null,?,?,?,?)";      
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, historial.getId_empleado());
                this.preStm.setInt(2, historial.getId_turno());
                this.preStm.setString(3, historial.getHoraLlamado());
                this.preStm.setString(4, historial.getHoraFinalizacion());
                
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
