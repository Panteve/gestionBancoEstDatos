/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Empleado;
import co.edu.gestionbanco.entity.Turno;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class Escritorio extends javax.swing.JFrame {

    Empleado empleado = new Empleado();
    List<Turno> listTurnos = new ArrayList<>();
    private final String columnas[] = {"Turno", "Caja"};

    public Escritorio() {
        initComponents();
        itemCerrarSesion.setVisible(false);
        itemEditarInformacion.setVisible(false);
        itemGestionTurno.setVisible(false);
        menuServicios.setVisible(false);
        itemRegistrarEmpleado.setVisible(false);
        menuReportes.setVisible(false);
        estilizarTabla();
    }

    public void estilizarTabla() {
        // Centrar texto
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tblDatos.getColumnCount(); i++) {
            tblDatos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // Filas más grandes
        tblDatos.setRowHeight(35);

        // Mostrar solo 5 filas visibles
        int filasVisibles = 5;
        int altoFila = tblDatos.getRowHeight();
        int altoHeader = tblDatos.getTableHeader().getPreferredSize().height;

        jScrollPane1.setPreferredSize(new Dimension(
                jScrollPane1.getPreferredSize().width,
                altoHeader + (altoFila * filasVisibles)
        ));
    }

    public void agregarTurno(Turno turno) {
        listTurnos.add(turno);
        setDatosTabla();
    }

    public void setDatosTabla() {
        Object[][] data = new Object[listTurnos.size()][columnas.length];

        for (int i = 0; i < listTurnos.size(); i++) {
            Turno turno = listTurnos.get(i);
            data[i][0] = turno.getCodigo();
            data[i][1] = turno.getCaja();
        }
        DefaultTableModel model = new DefaultTableModel(data, columnas);
        tblDatos.setModel(model);
    }

    public void quitarTurno(Turno turnoAtendido) {
        listTurnos.removeIf(turno -> turno.getId_turno() == turnoAtendido.getId_turno());
        setDatosTabla();
    }

    private void cerrarVentanasAbiertas() {
        JInternalFrame[] paneles = panelPrincipal.getAllFrames();
        for (int i = 0; i < paneles.length; i++) {
            if (!"GestionarTurno".equals(paneles[i].getClass().getSimpleName())) {
                paneles[i].dispose();
            }
        }
    }

    public void serEmpleado(InicioSesion inicioSesion) {
        itemIniciarSesion.setVisible(false);
        itemCerrarSesion.setVisible(true);
        itemEditarInformacion.setVisible(true);
        itemGestionTurno.setVisible(true);
        menuServicios.setVisible(true);
        menuReportes.setVisible(true);
        itemRegistrarEmpleado.setVisible(true);
        if (empleado.getCargo().equals("Admin")) {

        }
        inicioSesion.dispose();
        lblBienvenida.setText("Bienvenido, " + empleado.getNombre());
        lblCargo.setText("Cargo: " + empleado.getCargo());
        lblCaja.setText("Caja: " + empleado.getCaja());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panelPrincipal = new javax.swing.JDesktopPane();
        lblCaja = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblTituloTabla = new javax.swing.JLabel();
        lblTituloTabla1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTurnos = new javax.swing.JMenu();
        itemGenerarTurno = new javax.swing.JMenuItem();
        itemGestionTurno = new javax.swing.JMenuItem();
        menuServicios = new javax.swing.JMenu();
        itemRegistroCli = new javax.swing.JMenuItem();
        itemAgregarPro = new javax.swing.JMenuItem();
        itemPagoServi = new javax.swing.JMenuItem();
        itemRetiroDeposito = new javax.swing.JMenuItem();
        menuEmpleados = new javax.swing.JMenu();
        itemIniciarSesion = new javax.swing.JMenuItem();
        itemCerrarSesion = new javax.swing.JMenuItem();
        itemEditarInformacion = new javax.swing.JMenuItem();
        itemRegistrarEmpleado = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        itemTurnos = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCaja.setBackground(new java.awt.Color(255, 255, 255));
        lblCaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCaja.setForeground(new java.awt.Color(255, 255, 255));
        lblCaja.setText("-");

        lblBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenida.setText("-");

        lblCargo.setBackground(new java.awt.Color(255, 255, 255));
        lblCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setText("-");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        lblTituloTabla.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTituloTabla.setText("En atencion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(lblTituloTabla)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloTabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblTituloTabla1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTituloTabla1.setText("Turnos");

        panelPrincipal.setLayer(lblCaja, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincipal.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincipal.setLayer(lblCargo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincipal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincipal.setLayer(lblTituloTabla1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCargo)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblTituloTabla1))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(238, 238, 238)
                        .addComponent(lblCaja)))
                .addContainerGap(638, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBienvenida)
                    .addComponent(lblCaja))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(lblTituloTabla1)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        menuTurnos.setText("Gestion turnos");

        itemGenerarTurno.setText("Crear turno");
        itemGenerarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGenerarTurnoActionPerformed(evt);
            }
        });
        menuTurnos.add(itemGenerarTurno);

        itemGestionTurno.setText("Gestionar turnos");
        itemGestionTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGestionTurnoActionPerformed(evt);
            }
        });
        menuTurnos.add(itemGestionTurno);

        jMenuBar1.add(menuTurnos);

        menuServicios.setText("Gestion servicios");

        itemRegistroCli.setText("Registrar cliente");
        itemRegistroCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistroCliActionPerformed(evt);
            }
        });
        menuServicios.add(itemRegistroCli);

        itemAgregarPro.setText("Agregar producto");
        itemAgregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarProActionPerformed(evt);
            }
        });
        menuServicios.add(itemAgregarPro);

        itemPagoServi.setText("Pago de servicios");
        itemPagoServi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPagoServiActionPerformed(evt);
            }
        });
        menuServicios.add(itemPagoServi);

        itemRetiroDeposito.setText("Retiro/Deposito");
        itemRetiroDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRetiroDepositoActionPerformed(evt);
            }
        });
        menuServicios.add(itemRetiroDeposito);

        jMenuBar1.add(menuServicios);

        menuEmpleados.setText("Empleado");

        itemIniciarSesion.setText("Iniciar Sesion");
        itemIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIniciarSesionActionPerformed(evt);
            }
        });
        menuEmpleados.add(itemIniciarSesion);

        itemCerrarSesion.setText("Cerrar Sesion");
        itemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarSesionActionPerformed(evt);
            }
        });
        menuEmpleados.add(itemCerrarSesion);

        itemEditarInformacion.setText("Editar Informacion");
        itemEditarInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarInformacionActionPerformed(evt);
            }
        });
        menuEmpleados.add(itemEditarInformacion);

        itemRegistrarEmpleado.setText("Registrar empleado");
        itemRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarEmpleadoActionPerformed(evt);
            }
        });
        menuEmpleados.add(itemRegistrarEmpleado);

        jMenuBar1.add(menuEmpleados);

        menuReportes.setText("Reportes");
        menuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReportesActionPerformed(evt);
            }
        });

        itemTurnos.setText("Turnos");
        itemTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTurnosActionPerformed(evt);
            }
        });
        menuReportes.add(itemTurnos);

        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemGenerarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGenerarTurnoActionPerformed
        cerrarVentanasAbiertas();
        CrearTurno crear = new CrearTurno();
        panelPrincipal.add(crear);
        crear.setResizable(false);
        crear.setVisible(true);

    }//GEN-LAST:event_itemGenerarTurnoActionPerformed

    private void itemGestionTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGestionTurnoActionPerformed
        cerrarVentanasAbiertas();
        GestionarTurno gestionar = new GestionarTurno(this);
        panelPrincipal.add(gestionar);
        gestionar.setResizable(false);
        gestionar.setVisible(true);
    }//GEN-LAST:event_itemGestionTurnoActionPerformed

    private void itemRegistroCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistroCliActionPerformed
        cerrarVentanasAbiertas();
        RegistrarUsuario registrar = new RegistrarUsuario();
        panelPrincipal.add(registrar);
        registrar.setResizable(false);
        registrar.setVisible(true);
    }//GEN-LAST:event_itemRegistroCliActionPerformed

    private void itemAgregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarProActionPerformed
        cerrarVentanasAbiertas();
        VisualizarUsuario agregar = new VisualizarUsuario();
        panelPrincipal.add(agregar);
        agregar.setResizable(false);
        agregar.setVisible(true);
    }//GEN-LAST:event_itemAgregarProActionPerformed

    private void itemPagoServiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPagoServiActionPerformed
        cerrarVentanasAbiertas();
        PagoServicios pago = new PagoServicios();
        panelPrincipal.add(pago);
        pago.setResizable(false);
        pago.setVisible(true);
    }//GEN-LAST:event_itemPagoServiActionPerformed

    private void itemRetiroDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRetiroDepositoActionPerformed
        cerrarVentanasAbiertas();
        RetiroDeposito retiroDeposito = new RetiroDeposito();
        panelPrincipal.add(retiroDeposito);
        retiroDeposito.setResizable(false);
        retiroDeposito.setVisible(true);
    }//GEN-LAST:event_itemRetiroDepositoActionPerformed

    private void itemIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIniciarSesionActionPerformed
        cerrarVentanasAbiertas();
        InicioSesion inicioSesion = new InicioSesion(this);
        panelPrincipal.add(inicioSesion);
        inicioSesion.setResizable(false);
        inicioSesion.setVisible(true);
    }//GEN-LAST:event_itemIniciarSesionActionPerformed

    private void itemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarSesionActionPerformed
        empleado = new Empleado();
        itemIniciarSesion.setVisible(true);
        itemCerrarSesion.setVisible(false);
        itemEditarInformacion.setVisible(false);
        itemGestionTurno.setVisible(false);
        menuServicios.setVisible(false);
        itemRegistrarEmpleado.setVisible(false);
        menuReportes.setVisible(false);

        lblBienvenida.setText(" ");
        lblCargo.setText(" ");
        lblCaja.setText(" ");
    }//GEN-LAST:event_itemCerrarSesionActionPerformed

    private void itemEditarInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarInformacionActionPerformed
        ModificarEmpleDialog modificarEmpleDialog = new ModificarEmpleDialog(this, true);
        modificarEmpleDialog.setDatos(empleado);
        modificarEmpleDialog.setResizable(false);
        modificarEmpleDialog.setVisible(true);
    }//GEN-LAST:event_itemEditarInformacionActionPerformed

    private void itemRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarEmpleadoActionPerformed
        cerrarVentanasAbiertas();
        RegistrarEmpleado resgitrarEmpleado = new RegistrarEmpleado();
        panelPrincipal.add(resgitrarEmpleado);
        resgitrarEmpleado.setResizable(false);
        resgitrarEmpleado.setVisible(true);
    }//GEN-LAST:event_itemRegistrarEmpleadoActionPerformed

    private void menuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReportesActionPerformed

    }//GEN-LAST:event_menuReportesActionPerformed

    private void itemTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTurnosActionPerformed
        cerrarVentanasAbiertas();
        ReporteTurnos reporteTurno = new ReporteTurnos();
        panelPrincipal.add(reporteTurno);
        reporteTurno.setResizable(false);
        reporteTurno.setVisible(true);
    }//GEN-LAST:event_itemTurnosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Escritorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Escritorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemAgregarPro;
    private javax.swing.JMenuItem itemCerrarSesion;
    private javax.swing.JMenuItem itemEditarInformacion;
    private javax.swing.JMenuItem itemGenerarTurno;
    private javax.swing.JMenuItem itemGestionTurno;
    private javax.swing.JMenuItem itemIniciarSesion;
    private javax.swing.JMenuItem itemPagoServi;
    private javax.swing.JMenuItem itemRegistrarEmpleado;
    private javax.swing.JMenuItem itemRegistroCli;
    private javax.swing.JMenuItem itemRetiroDeposito;
    private javax.swing.JMenuItem itemTurnos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblTituloTabla;
    private javax.swing.JLabel lblTituloTabla1;
    private javax.swing.JMenu menuEmpleados;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuServicios;
    private javax.swing.JMenu menuTurnos;
    private javax.swing.JDesktopPane panelPrincipal;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
