/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Producto;
import co.edu.gestionbanco.entity.Turno;
import co.edu.gestionbanco.entity.Usuario;
import co.edu.gestionbanco.repository.ProductoRepository;
import co.edu.gestionbanco.repository.UsuarioRepository;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DIEGO
 */
public class VisualizarUsuario extends javax.swing.JInternalFrame {

    private final String COLUMNAS[] = {"Referencia", "Nombre", "Valor"};
    Usuario usuario;

    public VisualizarUsuario() {
        initComponents();
        estilizarTabla();
        btnModificar.setVisible(false);
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

    private void setDatosTabla(List<Producto> listProductos) {
        if(listProductos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Usuario sin productos",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Object[][] data = new Object[listProductos.size()][COLUMNAS.length];

        for (int i = 0; i < listProductos.size(); i++) {
            Producto producto = listProductos.get(i);
            
            data[i][0] = producto.getReferencia();
            data[i][1] = producto.getNombre();
            data[i][2] = producto.getValor();
        }
        DefaultTableModel model = new DefaultTableModel(data, COLUMNAS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ninguna celda se puede editar
            }
        };
        tblDatos.setModel(model);
    }

    private void setDatosUsuario() {
        txtNombre.setText(usuario.getNombre());
        txtOcupacion.setText(usuario.getOcupacion());
        txtCorreo.setText(usuario.getCorreo());
        txtTelefono.setText(usuario.getTelefono());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProductos = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblOcupacion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new javax.swing.JLabel();
        txtOcupacion = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setTitle("Visualizar usuarios");

        lblProductos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblProductos.setText("Productos");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombres:");

        lblOcupacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOcupacion.setText("Ocupacion:");

        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTelefono.setText("Telefono:");

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCorreo.setText("Correo");

        lblIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblIdentificacion.setText("N° de identificacion:");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.setText("Nombre");

        txtOcupacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtOcupacion.setText("Ocupacion");

        lblCorreo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCorreo.setText("Correo:");

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTelefono.setText("Telefono");

        btnModificar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOcupacion)
                                .addGap(18, 18, 18)
                                .addComponent(txtOcupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombre)
                                .addGap(32, 32, 32)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addGap(18, 18, 18)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(277, 277, 277)
                                .addComponent(txtIdentificacion))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(369, 369, 369)
                                        .addComponent(lblProductos))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6)))
                .addGap(63, 63, 63))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(lblIdentificacion)
                    .addContainerGap(718, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono))
                        .addGap(42, 42, 42)
                        .addComponent(lblProductos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblOcupacion)
                                .addComponent(txtOcupacion))
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblIdentificacion)
                    .addContainerGap(520, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        UsuarioRepository usuRepository = new UsuarioRepository();
        ProductoRepository proRepository = new ProductoRepository();

        String documentoStr = txtIdentificacion.getText();
        if (!documentoStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtIdentificacion.requestFocus();
            return;
        }
        int documento = Integer.parseInt(documentoStr);

        usuario = usuRepository.getUsuario(documento);
        if (usuario.getId_usuario() != 0) {
            setDatosUsuario();
            btnModificar.setVisible(true);
            setDatosTabla(proRepository.getAllProductosPorUsuario(usuario.getId_usuario()));
        } else {
            JOptionPane.showMessageDialog(null, "Documento no encontrado",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        ModificarUsuaDialog modificarUsuaDialog = new ModificarUsuaDialog(parent, true);

        modificarUsuaDialog.setDatos(usuario);

        modificarUsuaDialog.setResizable(false);
        modificarUsuaDialog.setVisible(true);

        int documento = Integer.parseInt(txtIdentificacion.getText());
        UsuarioRepository usuRepository = new UsuarioRepository();
        usuario = usuRepository.getUsuario(documento);
        setDatosUsuario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        AgregarProductoDialog agregarProDialog = new AgregarProductoDialog(parent, true);

        agregarProDialog.setId_usuario(String.valueOf(usuario.getId_usuario()));
        agregarProDialog.setResizable(false);
        agregarProDialog.setVisible(true);


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblDatos.getSelectedRow();
        if (fila != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto?",
                    "INFORMATION_MESSAGE", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (opcion == 0) {
                String referencia = tblDatos.getValueAt(fila, 0).toString();
                ProductoRepository proRepository = new ProductoRepository();
                
                boolean status = proRepository.bajaProducto(referencia);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                    usuario = new Usuario();
                    this.dispose();
                }
            }
        }


    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOcupacion;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTable tblDatos;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtOcupacion;
    private javax.swing.JLabel txtTelefono;
    // End of variables declaration//GEN-END:variables
}
