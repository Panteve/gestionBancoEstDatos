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
                        resultSet.getString("fechaNacimiento"),
                        resultSet.getString("lugarNacimiento"),
                        resultSet.getString("fechaExpedicion"),
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
                    this.preStm = null;
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
                        resultSet.getString("fechaNacimiento"),
                        resultSet.getString("lugarNacimiento"),
                        resultSet.getString("fechaExpedicion"),
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
        return usuario;
    }
    
    public int getIdUsuario(int documento) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "SELECT id_usuario FROM usuarios WHERE documento = ?"; //Agregar order by para traer en orden la lista por prioridad 
        int idUsuario = 0;
        try {
            this.preStm = con.prepareStatement(sqlQuery);
            this.preStm.setInt(1, documento);
            
            ResultSet resultSet = this.preStm.executeQuery();
            if (resultSet.next()) {
                idUsuario = resultSet.getInt("id_usuario");
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
        return idUsuario;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE usuarios SET nombre = ?, correo = ?, telefono = ?, ocupacion = ?, fechaNacimiento = ?,lugarNacimiento = ?,fechaExpedicion = ? WHERE id_usuario = ?";
        try {
            if (this.preStm == null) {
                java.sql.Date fechaNacimiento = java.sql.Date.valueOf(usuario.getFechaNacimiento());
                java.sql.Date fechaExpedicion = java.sql.Date.valueOf(usuario.getFechaExpedicion());
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setString(1, usuario.getNombre());
                this.preStm.setString(2, usuario.getCorreo());
                this.preStm.setString(3, usuario.getTelefono());
                this.preStm.setString(4, usuario.getOcupacion());
                this.preStm.setDate(5, fechaNacimiento);
                this.preStm.setString(6, usuario.getLugarExpedicion());
                this.preStm.setDate(7, fechaExpedicion);
                this.preStm.setInt(8, usuario.getId_usuario());
                
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
     
    
    public boolean registrarInvitado(int documento) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "INSERT INTO usuarios (documento) VALUES (?)";    
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, documento);
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
    
    public boolean bajaCliente(int id) {
        Connection con = conexionBD.getConectionDB();
        String sqlQuery = "UPDATE usuarios SET estado = 0 WHERE id_usuario = ?";
        try {
            if (this.preStm == null) {
                this.preStm = con.prepareStatement(sqlQuery);
                this.preStm.setInt(1, id);

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
