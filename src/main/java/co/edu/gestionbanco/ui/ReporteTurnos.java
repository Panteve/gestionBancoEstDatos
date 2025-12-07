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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComponent;
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

    private String formateoDuration(Duration tiempo) {
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
            data[i][9] = formateoDuration(reporte.getTiempoEnCola());
            data[i][10] = formateoDuration(reporte.getTiempoAtencion());
            data[i][11] = formateoDuration(reporte.getTiempoTotal());

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

    private HashMap<String, Duration> calcularPromedios() {
        HashMap<String, Duration> promedios = new HashMap<>();
        for (int i = 9; i < 12; i++) {
            Duration suma = Duration.ZERO;
            for (int j = 0; j < tblDatos.getRowCount(); j++) {
                Duration duracion = convertirATiempo(tblDatos.getValueAt(j, i).toString());
                suma = suma.plus(duracion);
            }
            String nombreColumna = tblDatos.getColumnName(i);
            Duration promedio = suma.dividedBy(tblDatos.getRowCount());
            promedios.put(nombreColumna, promedio);
        }
        return promedios;
    }

    //Recibe un string con fomrato HH:MM:SS para convertirlo en localTime
    //y luego devuelve un tipo de dato Duration que contiene el tiempo que paso(Line 163)
    private Duration convertirATiempo(String tiempo) {
        LocalTime localTime = LocalTime.parse(tiempo);
        //LocalTime.MIN es 00:00:00
        //basicamente es decir ¿Cuánto tiempo hay desde las 00:00:00 hasta la hora del string?"
        return Duration.between(LocalTime.MIN, localTime);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
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
        lblPromedioTotal = new javax.swing.JLabel();
        lblPromedioAtencion = new javax.swing.JLabel();
        lblPromedioCola = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setTitle("Reportes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, 1570, 446));

        lblFechaHasta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaHasta.setText("Hasta:");
        getContentPane().add(lblFechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 65, -1, -1));

        lblFiltros.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblFiltros.setText("Filtros");
        getContentPane().add(lblFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 14, -1, -1));

        lblFechaDesde.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFechaDesde.setText("Desde:");
        getContentPane().add(lblFechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 65, -1, -1));

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
        getContentPane().add(txtFechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 64, 170, -1));

        try {
            txtFechaHasta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtFechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 64, 170, -1));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 72, 102, 37));

        lblAtendidoPor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAtendidoPor.setText("Atendido por:");
        getContentPane().add(lblAtendidoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 113, -1, -1));

        lblCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCliente.setText("Cliente:");
        getContentPane().add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 113, -1, -1));

        lblServicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblServicio.setText("Servicio");
        getContentPane().add(lblServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 65, -1, -1));

        combServicios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(combServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 64, 186, -1));

        txtAtendido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtAtendido, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 112, 171, -1));

        txtCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 112, 171, -1));

        lblPromedioTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPromedioTotal.setText("Tiempo promedio");
        getContentPane().add(lblPromedioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, -1, -1));

        lblPromedioAtencion.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPromedioAtencion.setText("Tiempo promedio");
        getContentPane().add(lblPromedioAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 100, -1, -1));

        lblPromedioCola.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblPromedioCola.setText("Tiempo promedio");
        getContentPane().add(lblPromedioCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, -1, -1));

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
            JOptionPane.showMessageDialog(null, "Fecha no valida. Use el formato YYYY-MM-DD",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtFechaDesde.requestFocus();
            return;
        }
        if (!fechaHasta.matches(formatoFechaRegex)) {
            JOptionPane.showMessageDialog(null, "Fecha no valida. Use el formato YYYY-MM-DD",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtFechaHasta.requestFocus();
            return;
        }
        if (!docEmpleadoStr.isBlank() && !docEmpleadoStr.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtAtendido.requestFocus();
            return;
        }

        if (!docUsuarioStr.isBlank() && !docUsuarioStr.matches("^[0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtCliente.requestFocus();
            return;
        }

        ReporteRepository repoRepository = new ReporteRepository();
        setDataTabla(repoRepository.getReporte(fechaDesde, fechaHasta, docEmpleadoStr, docUsuarioStr, servicio));

        HashMap<String, Duration> promedios = calcularPromedios();

        promedios.forEach((tipoPromedio, duracion) -> {
            long horas = duracion.toHours();
            long minutos = duracion.toMinutesPart();
            long segundos = duracion.toSecondsPart();
            String promedioStr = String.format("%02d:%02d:%02d", horas, minutos, segundos);
            switch (tipoPromedio) {
                case "Tiempo en cola":
                    lblPromedioCola.setText("Tiempo promedio en cola: " + promedioStr);
                    break;
                case "Tiempo de atencion":
                    lblPromedioAtencion.setText("Tiempo promedio en atencion: " + promedioStr);
                    break;
                case "Tiempo total":
                    lblPromedioTotal.setText("Tiempo promedio total " + promedioStr);
                    break;
                default:
                    throw new AssertionError();
            }
        });

        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaDesdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaDesdeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> combServicios;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtendidoPor;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFechaDesde;
    private javax.swing.JLabel lblFechaHasta;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblPromedioAtencion;
    private javax.swing.JLabel lblPromedioCola;
    private javax.swing.JLabel lblPromedioTotal;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAtendido;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtFechaDesde;
    private javax.swing.JFormattedTextField txtFechaHasta;
    // End of variables declaration//GEN-END:variables
}
