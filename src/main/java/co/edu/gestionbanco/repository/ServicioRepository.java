/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.Servicio;
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
public class ServicioRepository {
    //Atributos 
    private ConexionBD conexionBD;//Objeto
    private PreparedStatement preStm;

    //Constructor
    public ServicioRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }
    
    public Servicio getServicio(int id_turno) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM servicios WHERE id_servicio = ?"; //Agregar order by para traer en orden la lista por prioridad 
        Servicio servicio = new Servicio();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, id_turno);
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                servicio = new Servicio(
                        resultSet.getInt("id_servicio"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("para_cliente")
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
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return servicio;
    }
    
    public  List<Servicio> getAllServicios() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM servicios"; //Agregar order by para traer en orden la lista por prioridad 
        List<Servicio> servicioList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                servicioList.add(new Servicio(
                        resultSet.getInt("id_servicio"),
                        resultSet.getString("nombre"),
                        resultSet.getString("descripcion"),
                        resultSet.getInt("para_cliente")
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
        return servicioList;
    }
}
