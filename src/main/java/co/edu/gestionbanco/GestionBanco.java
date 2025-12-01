/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.gestionbanco;

import co.edu.gestionbanco.entity.TriagePrioridad;
import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.repository.TurnoRepository;
import co.edu.gestionbanco.repository.UsuarioRepository;
import co.edu.gestionbanco.util.ConexionBD;

/**
 *
 * @author DIEGO
 */
public class GestionBanco {

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        conexion.getConectionDB();
            
        Turno turno = new Turno(
    0,              // id_turno (si no tienes el ID aún, usa 0 o -1)
    "D51",          // codigo
    4,              // usuario_id (cliente_id del ticket)
    1,              // servicio_id
    TriagePrioridad.LEVEL3, // prioridad
    "En espera",    // estado
    "2025-11-29",   // fecha
    "23:42:07"      // hora
);
        TurnoRepository turnos = new TurnoRepository();
        System.out.println(turnos.crearTurno(turno));
        //UsuarioRepository repo = new UsuarioRepository();
        //System.out.println(repo.getUsuario(1234567));
        
    }
}
