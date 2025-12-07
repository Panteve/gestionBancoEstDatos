/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

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

    public List<Producto> getAllProductosPorUsuario(int id_usuario) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM productos WHERE id_usuario = ? AND estado = 1";
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
                        resultSet.getString("referencia"),
                        resultSet.getString("nombre"),
                        resultSet.getFloat("valor"),
                        resultSet.getInt("empresarial"),
                        resultSet.getInt("estado")
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

    public boolean registrarProducto(Producto producto) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO productos VALUES(null,?,?,?,?,?,?)";
        int estado = 1;
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, producto.getId_usuario());
                this.preStm.setString(2, producto.getReferencia());
                this.preStm.setString(3, producto.getNombre());
                this.preStm.setFloat(4, producto.getValor());
                this.preStm.setInt(5, producto.getEmpresarial());
                this.preStm.setInt(6, estado);

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

    public Producto getProducto(String referencia) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM productos WHERE referencia = ? AND estado = 1";
        Producto producto = new Producto();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setString(1, referencia);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                producto = new Producto(
                        resultSet.getInt("id_producto"),
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("referencia"),
                        resultSet.getString("nombre"),
                        resultSet.getFloat("valor"),
                        resultSet.getInt("empresarial"),
                        resultSet.getInt("estado")
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
        return producto;
    }

    public boolean updateValorProducto(Producto producto) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE productos SET valor = ? WHERE id_producto = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setFloat(1, producto.getValor());
                this.preStm.setInt(2, producto.getId_producto());

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
    
    public boolean bajaProducto(String referencia) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE productos SET estado = 0 WHERE referencia = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, referencia);
  
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
