/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Servicio;
import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.entity.Usuario;
import co.edu.gestionbanco.repository.TurnoRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DIEGO
 */
public class CrearTurno extends javax.swing.JInternalFrame {

    public boolean esCliente;
    public Turno turno = new Turno();
    public Usuario usuario = new Usuario();
    public Servicio servicio = new Servicio();
    TurnoRepository repository = new TurnoRepository();

    private PrimerPasoCrearTurno primerPaso = new PrimerPasoCrearTurno(this);

    public CrearTurno() {
        initComponents();
        panelPrincipalCrear.add(primerPaso);
        primerPaso.setVisible(true);
    }

    public void pasarSegundoPaso() {
        SegundoPasoCrerTurno segundoPaso = new SegundoPasoCrerTurno(this);
        panelPrincipalCrear.add(segundoPaso);
        primerPaso.setVisible(false);
        segundoPaso.setVisible(true);
    }

    public void pasarTercerPaso(SegundoPasoCrerTurno segundoPaso) {
        TercerPasoCrearTurno tercerPaso = new TercerPasoCrearTurno(this);
        panelPrincipalCrear.add(tercerPaso);
        segundoPaso.setVisible(false);
        tercerPaso.setVisible(true);
    }

    public void pasarCuartoPaso(TercerPasoCrearTurno tercerPaso) {
        CuartoPasoCrearTurno cuartoPaso = new CuartoPasoCrearTurno(this);
        panelPrincipalCrear.add(cuartoPaso);
        tercerPaso.setVisible(false);
        cuartoPaso.setVisible(true);
    }

    public void pasarQuintoPaso(CuartoPasoCrearTurno cuartoPaso) {
        QuintoPasoCrearTurno quintoPaso = new QuintoPasoCrearTurno(this);
        panelPrincipalCrear.add(quintoPaso);
        cuartoPaso.setVisible(false);
        quintoPaso.setVisible(true);
    }

    public boolean crearTurno() {
        String sqlQuery;
        String codigo;
        if (turno.prioridad.getLEVEL() != 0) {
            sqlQuery = repository.eleccionSentenciaCodigo("discapacidad");
        } else {
            sqlQuery = repository.eleccionSentenciaCodigo("normal");
        }
        codigo = generarSiguienteCodigo(repository.getUltimoTurno(sqlQuery));
        turno.setCodigo(codigo);
        //Set id Usuaio
        turno.setUsuario_id(usuario.getId_usuario());
        //Set id Servicio
        turno.setServicio_id(servicio.getId_servicio());
        //Set estado
        turno.setEstado("En espera");
        //Set fecha
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        turno.setFecha(fecha);
        //Set Hora
        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        turno.setHora(hora);
        return repository.crearTurno(turno) ? true : false;
    }

    public String generarSiguienteCodigo(String codigoAnterior) {
        String letra = servicio.getNombre().substring(0, 1);
        String numeroStr = "00";
        int numero = 0;
        if (turno.getPrioridad().getLEVEL() != 0) {
            letra = "P";
        }
        
        //Si el codigo anterior esta vacio entonces lo inicia en 1 de lo contrario si parsea el numero que trae y leugo le suma 1 
        if(codigoAnterior.isBlank()) {
            numero = 1;
        }else{
           numeroStr = codigoAnterior.substring(1);
           numero = Integer.parseInt(numeroStr);
        } 

        // Si el número llega a 99 se reinicia a 01
        if (numero == 99) {
            numero = 1;
        } else {
            numero++;
        }

        // Sirve para hacer que se cree un string y cuando pueda ponga los ceros a la izquierda
        String nuevoNumeroStr = String.format("%0" + numeroStr.length() + "d", numero);

        return letra + nuevoNumeroStr;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelPrincipalCrear = new javax.swing.JDesktopPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalCrear, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    public static javax.swing.JDesktopPane panelPrincipalCrear;
    // End of variables declaration//GEN-END:variables
}
