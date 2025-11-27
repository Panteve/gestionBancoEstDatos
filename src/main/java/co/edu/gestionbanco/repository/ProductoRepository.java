/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.Empleado;
import co.edu.gestionbanco.entity.Producto;
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
public class ProductoRepository {
    private ConexionBD conexionBD;
    private PreparedStatement preStm;

    //Constructor
    public ProductoRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }
    
    public List<Producto> getAllProductosPorUsuario(int id_usuario){
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM productos WHERE id_usuario = ?"; //Agregar order by para traer en orden la lista por prioridad 
        List<Producto> prodcutosList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, id_usuario);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                prodcutosList.add(new Producto(
                        resultSet.getInt("id_producto"),
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("referenccia"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("valor")
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
        return prodcutosList;
    }
    
}
