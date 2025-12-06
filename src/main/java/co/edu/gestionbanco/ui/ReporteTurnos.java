/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Producto;
import co.edu.gestionbanco.entity.Reporte;
import co.edu.gestionbanco.entity.Servicio;
import co.edu.gestionbanco.repository.ReporteRepository;
import co.edu.gestionbanco.repository.ServicioRepository;
import java.awt.Font;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class ReporteTurnos extends javax.swing.JInternalFrame {

    private final String COLUMNAS[] = {"ID", "Codigo", "Cliente", "Atendio por", "Servicio", "Fecha creacion", "Hora creacion", "Hora llamado", "Hora finalizacion", "Tiempo en cola", "Tiempo de atencion", "Tiempo total"};

    public ReporteTurnos() {
        initComponents();
        setCombServicios();
        estilizarTabla();
        txtFechaDesde.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        txtFechaHasta.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        this.setClosable(true);
    }

    private void estilizarTabla() {
        // Centrar texto
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tblDatos.getColumnCount(); i++) {
            tblDatos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // Aumentar la fuente
        tblDatos.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        // Aumentar altura de filas
        tblDatos.setRowHeight(28);
    }

    private void setCombServicios() {
        ServicioRepository serRepository = new ServicioRepository();
        List<Servicio> serList = serRepository.getAllServicios();

        for (Servicio ser : serList) {
            combServicios.addItem(ser.getNombre());
        }
    }

    private String formatDuration(Duration tiempo) {
        if (tiempo == null) {
            return "";
        }

        long hours = tiempo.toHours();
        long minutes = tiempo.toMinutesPart();
        long seconds = tiempo.toSecondsPart();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private void setDataTabla(List<Reporte> listaReporte) {
        if (listaReporte.size() == 0) {
            JOptionPane.showMessageDialog(null, "Ningun regsitro encontrado, revise los datos");
            return;
        }
        Object[][] data = new Object[listaReporte.size()][COLUMNAS.length];

        for (int i = 0; i < listaReporte.size(); i++) {
            Reporte reporte = listaReporte.get(i);
            data[i][0] = reporte.getTurnoId();
            data[i][1] = reporte.getCodigoTurno();
            data[i][2] = reporte.getNombreUsuario();
            if (reporte.getNombreUsuario() == null) {
                data[i][2] = "Invitado";
            }
            data[i][3] = reporte.getNombreEmpleado();
            data[i][4] = reporte.getServicio();
            data[i][5] = reporte.getFechaCreacionTurno();
            data[i][6] = reporte.getHoraCreacionTurno();
            data[i][7] = reporte.getHoraLlamadoTurno();
            data[i][8] = reporte.getHoraFinalizacionTurno();
            data[i][9] = formatDuration(reporte.getTiempoEnCola());
            data[i][10] = formatDuration(reporte.getTiempoAtencion());
            data[i][11] = formatDuration(reporte.getTiempoTotal());

        }
        DefaultTableModel model = new DefaultTableModel(data, COLUMNAS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ninguna celda se puede editar
            }
        };
        tblDatos.setModel(model);

        //Para que no se vea el ID del turno
        tblDatos.getColumnModel().getColumn(0).setMinWidth(0);
        tblDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblFechaHasta = new javax.swing.JLabel();
        lblFiltros = new javax.swing.JLabel();
        lblFechaDesde = new javax.swing.JLabel();
        txtFechaDesde = new javax.swing.JFormattedTextField();
        txtFechaHasta = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        lblAtendidoPor = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblServicio = new javax.swing.JLabel();
        combServicios = new javax.swing.JComboBox<>();
        txtAtendido = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();

        setTitle("Reportes");

        tblDatos.setAutoCreateRowSorter(true);
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Codigo", "Cliente", "Atendio por", "Servicio", "Fecha creacion", "Hora creacion", "Hora llamado", "Hora finalizacion", "Tiempo en cola", "Tiempo de atencion", "Tiempo total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatos.setToolTipText("");
        jScrollPane1.setViewportView(tblDatos);

        lblFechaHasta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaHasta.setText("Hasta:");

        lblFiltros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFiltros.setText("Filtros");

        lblFechaDesde.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaDesde.setText("Desde:");

        try {
            txtFechaDesde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFechaDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaDesdeActionPerformed(evt);
            }
        });

        try {
            txtFechaHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblAtendidoPor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAtendidoPor.setText("Atendido por:");

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCliente.setText("Cliente:");

        lblServicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblServicio.setText("Servicio");

        combServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtAtendido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFechaDesde)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lblFechaHasta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAtendidoPor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAtendido, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(lblServicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1570, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblFiltros)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblFiltros)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaHasta)
                            .addComponent(lblFechaDesde)
                            .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblServicio)
                            .addComponent(combServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAtendidoPor)
                    .addComponent(lblCliente)
                    .addComponent(txtAtendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String formatoFechaRegex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

        String fechaDesde = txtFechaDesde.getText();
        String fechaHasta = txtFechaHasta.getText();
        String docEmpleadoStr = txtAtendido.getText();
        String docUsuarioStr = txtCliente.getText();
        String servicio = String.valueOf(combServicios.getSelectedItem());

        if (!fechaDesde.matches(formatoFechaRegex)) {
            txtFechaDesde.requestFocus();
            JOptionPane.showMessageDialog(null, "Fecha no valida. Use el formato YYYY-MM-DD");
            return;
        }
        if (!fechaHasta.matches(formatoFechaRegex)) {
            txtFechaHasta.requestFocus();
            JOptionPane.showMessageDialog(null, "Fecha no valida. Use el formato YYYY-MM-DD");
            return;
        }
        if (!docEmpleadoStr.isBlank() && !docEmpleadoStr.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros");
            return;
        }

        if (!docUsuarioStr.isBlank() && !docUsuarioStr.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros");
            return;
        }

        ReporteRepository repoRepository = new ReporteRepository();
        setDataTabla(repoRepository.getReporte(fechaDesde, fechaHasta, docEmpleadoStr, docUsuarioStr, servicio));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> combServicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtendidoPor;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFechaDesde;
    private javax.swing.JLabel lblFechaHasta;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAtendido;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtFechaDesde;
    private javax.swing.JFormattedTextField txtFechaHasta;
    // End of variables declaration//GEN-END:variables
}
