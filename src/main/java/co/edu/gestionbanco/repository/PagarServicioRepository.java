/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.PagoServicio;
import co.edu.gestionbanco.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DIEGO
 */
public class PagarServicioRepository {

    //Atributos 
    private ConexionBD conexionBD;//Objeto
    private PreparedStatement preStm;

    //Constructor
    public PagarServicioRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }

    public boolean registrarPagoServicio(PagoServicio pagoServicio) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO pago_servicios VALUES(null,?,?,?)";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, pagoServicio.getId_usuario());
                this.preStm.setString(2, pagoServicio.getReferencia());
                this.preStm.setFloat(3, pagoServicio.getValor());

                this.preStm.executeUpdate();
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
