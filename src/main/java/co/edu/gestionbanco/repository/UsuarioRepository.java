/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.repository;


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
public class UsuarioRepository {
    //Atributos 

    private ConexionBD conexionBD;
    private PreparedStatement preStm;
    //Constructor
    public UsuarioRepository() {
        this.conexionBD = new ConexionBD();
        this.preStm = null;
    }

    //METODOS CRUD 
    //Conseguir todos los turnos en espera
    public List<Usuario> getAllUsuarios() {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM usuarios WHERE estado = 1"; //Agregar order by para traer en orden la lista por prioridad 
        List<Usuario> usuariosList = new ArrayList<>();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            while (resultSet.next()) {
                usuariosList.add(new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("ocupacion"),
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
        return usuariosList;
    }

    public Usuario getUsuario(int documento) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT * FROM usuarios WHERE documento = ?"; //Agregar order by para traer en orden la lista por prioridad 
        Usuario usuario = new Usuario();
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, documento);
            //Los datos de la tabla se guardan en el resultSet
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getInt("documento"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("ocupacion"),
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
        return usuario;
    }
    public boolean actualizarUsuario(Usuario usuario) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE usuarios SET nombre = ?, correo = ?, telefono = ?, ocupacion = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, usuario.getNombre());
                this.preStm.setString(2, usuario.getCorreo());
                this.preStm.setString(3, usuario.getTelefono());
                this.preStm.setString(4, usuario.getOcupacion());
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
    
    public boolean registrarUsuario(Usuario usuario) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO usuarios VALUES(null,?,?,?,?,?,?,?)";
        int estado = 1;       
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, usuario.getDocumento());
                this.preStm.setString(2, usuario.getNombre());
                this.preStm.setString(3, usuario.getCorreo());
                this.preStm.setString(4, usuario.getTelefono());
                this.preStm.setString(5, usuario.getOcupacion());
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
    
    public boolean bajaUsuario(int id) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE usuarios SET estado = 0 WHERE id_usuario = ?";
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
