/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.gestionbanco;

import co.edu.gestionbanco.entity.TriagePrioridad;
import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.entity.Usuario;
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
        
        Usuario usuario = new Usuario(
    3,  // id existente
    123456789,                         // documento inventado
    "Carlos Mendoza",                   // nombre inventado
    "carlos.mendoza@example.com",       // correo inventado
    "3104589623",                       // teléfono inventado
    "Asesor Financiero",                // ocupación inventada
    "1995-04-12",                       // fechaNacimiento inventada
    "Bogotá",                           // lugarExpedicion inventado
    "2014-07-28",                       // fechaExpedicion inventada
    1);       // estado existente
        //UsuarioRepository usuRepository = new UsuarioRepository();
        //usuRepository.actualizarUsuario(usuario);
        //TurnoRepository turnos = new TurnoRepository();
        //System.out.println(turnos.crearTurno(turno));
        //UsuarioRepository repo = new UsuarioRepository();
        //System.out.println(repo.getUsuario(1234567));
    
        
            
    }
}
