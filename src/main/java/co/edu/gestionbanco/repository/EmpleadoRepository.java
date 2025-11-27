/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;

import co.edu.gestionbanco.entity.Empleado;
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
public class EmpleadoRepository {
    //Atributos 

    private ConexionBD conexionBD;
    private PreparedStatement preStm;

    //Constructor
    public EmpleadoRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }

    //METODOS CRUD 
    //Conseguir todos los turnos en espera
    public List<Empleado> getAllEmpleados() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM empelados WHERE estado = 1"; //Agregar order by para traer en orden la lista por prioridad 
        List<Empleado> empleadosList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                empleadosList.add(new Empleado(
                        resultSet.getInt("id_empleado"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("cargo"),
                        resultSet.getString("contraseña"),
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
        return empleadosList;
    }

    public Empleado getEmpleado(int documento) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM empleados WHERE documento = ?"; //Agregar order by para traer en orden la lista por prioridad 
        Empleado empleado = new Empleado();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, documento);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                empleado = new Empleado(
                        resultSet.getInt("id_empleado"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("cargo"),
                        resultSet.getString("contraseña"),
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
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return empleado;
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE empelados SET nombre = ?, correo = ?, telefono = ?, cargo = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, empleado.getNombre());
                this.preStm.setString(2, empleado.getCorreo());
                this.preStm.setString(3, empleado.getTelefono());
                this.preStm.setString(4, empleado.getCargo());
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
        return true;
    }

    public boolean registrarEmpelado(Empleado empleado) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO empleados VALUES(null,?,?,?,?,?,?,?)";
        int estado = 1;
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, empleado.getDocumento());
                this.preStm.setString(2, empleado.getNombre());
                this.preStm.setString(3, empleado.getCorreo());
                this.preStm.setString(4, empleado.getTelefono());
                this.preStm.setString(5, empleado.getCargo());
                this.preStm.setInt(6, estado);

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
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return true;
    }

    public boolean bajaEmpleado(int id) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE empleados SET estado = 0 WHERE id_empleado = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, id);

                int response = this.preStm.executeUpdate();
                if (response > 0) {
                    JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
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
                } catch (SQLException ex) {
                    System.out.println("error" + ex.getMessage());
                }
            }
        }
        return true;
    }
}
