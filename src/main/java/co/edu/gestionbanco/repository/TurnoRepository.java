/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.util.ConexionBD;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
    public LinkedList<Turno> getAllTurnos() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM turnos WHERE tur_estado = 'En espera'"; //Agregar order by para traer en orden la lista por prioridad 
        LinkedList<Turno> turnosList = new LinkedList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                turnosList.add(new Turno(
                        resultSet.getString("tur_codigo"),
                        resultSet.getInt("tur_id_usuario"),
                        resultSet.getInt("tur_id_servicio"),
                        resultSet.getInt("tur_prioridad"),
                        resultSet.getString("tur_estado"),
                        resultSet.getString("tur_fecha_creacion"),
                        resultSet.getString("tur_hora_creacion")
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
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return turnosList;
    }

}
