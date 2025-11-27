/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.gestionbanco;

import co.edu.gestionbanco.repository.TurnoRepository;
import co.edu.gestionbanco.util.ConexionBD;

/**
 *
 * @author DIEGO
 */
public class GestionBanco {

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.getConectionDB();
        
        TurnoRepository turnos = new TurnoRepository();
        System.out.println(turnos.getTurno(2));
    }
}
