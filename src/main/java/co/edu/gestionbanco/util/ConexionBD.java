/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.gestionbanco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class ConexionBD {
    private String user;
    private String password;
    private String dataBase;
    private String port;
    private String url;
    private String serverData;
    Connection con;

    //Constructor 
    public ConexionBD(){
        this.user = "root";
        this.password = "";
        this.dataBase = "gestion_banco";
        this.port = "3307";
        this.serverData = "localhost";
        this.url = "jdbc:mysql://"+this.serverData+":"+this.port+"/"+this.dataBase;
        this.con = null;
    }
    //Metodo de conexion a la DB
    private Connection connecting(){
    //Usi de control excepxion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay conexion:"+ e.getMessage());
            System.out.println("***********Error"+ e);
            this.con = null;
        }
    return this.con;
    }
    public Connection getConectionDB(){
        return this.connecting();
    }
}
