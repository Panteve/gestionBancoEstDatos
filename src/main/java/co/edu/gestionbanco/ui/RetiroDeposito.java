/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Producto;
import co.edu.gestionbanco.repository.ProductoRepository;
import co.edu.gestionbanco.repository.UsuarioRepository;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class RetiroDeposito extends javax.swing.JInternalFrame {

    String[] transacciones = {"Retiro", "Deposito"};
    Producto productoSeleccionado;

    public RetiroDeposito() {
        initComponents();
        setCombTipos();
        this.setClosable(true);
    }

    private void setCombTipos() {
        for (String transaccion : transacciones) {
            combTipo.addItem(transaccion);
        }
    }

    private void setCombCuentas(List<Producto> cuentas) {
        for (Producto cuenta : cuentas) {
            combCuentas.addItem(cuenta.getReferencia());
        }
    }
    
    private void resetComponentes(){
        combCuentas.removeAllItems();
        txtIdentificacion.setText("");
        txtValor.setText("");
        txtValorActual.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combTipo = new javax.swing.JComboBox<>();
        lblValor = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblIdentificacion = new javax.swing.JLabel();
        combCuentas = new javax.swing.JComboBox<>();
        lblNCuenta = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblValorActual = new javax.swing.JLabel();
        txtValorActual = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();

        setTitle("Retiro o deposito");

        combTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValor.setText("Valor:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblIdentificacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblIdentificacion.setText("N° de identificacion:");

        combCuentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combCuentasActionPerformed(evt);
            }
        });

        lblNCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNCuenta.setText("N° de cuenta:");

        txtIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIdentificacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblValorActual.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValorActual.setText("Saldo actual:");

        txtValorActual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtValorActual.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtValorActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActualActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Retiro o deposito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txtValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lblIdentificacion)
                .addGap(18, 18, 18)
                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lblNCuenta)
                .addGap(18, 18, 18)
                .addComponent(combCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lblValorActual)
                .addGap(18, 18, 18)
                .addComponent(txtValorActual, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(lblValor)
                .addGap(18, 18, 18)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblIdentificacion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblNCuenta))
                    .addComponent(combCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblValorActual))
                    .addComponent(txtValorActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblValor))
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnAceptar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        UsuarioRepository usuRepository = new UsuarioRepository();
        ProductoRepository proRepository = new ProductoRepository();
        
        String documentoStr = txtIdentificacion.getText();
        int documento;
        
        if (!documentoStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Documento no valido, solo numeros");
            txtIdentificacion.requestFocus();
            return;
        }
        documento = Integer.parseInt(documentoStr);
        
        int idUsuario = usuRepository.getIdUsuario(documento);
        if (idUsuario != 0) {
            List<Producto> listaProductos = proRepository.getAllProductosPorUsuario(idUsuario);
            setCombCuentas(listaProductos);
        }else{
            JOptionPane.showMessageDialog(null, "No se encuntra el documento");
            txtIdentificacion.requestFocus();
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        float valorActual = productoSeleccionado.getValor();
        float valorNuevo = valorActual;
        float valor; 
        
        if (txtValor.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Digite un valor válido");
            txtValor.requestFocus();
            return;
        }
        valor = ((Number) txtValor.getValue()).floatValue();

        if (combTipo.getSelectedIndex() == 0) {
            valorNuevo -= valor;
        } else {
            valorNuevo += valor;
        }
        
        ProductoRepository proRepository = new ProductoRepository();
        productoSeleccionado.setValor(valorNuevo);
        
        boolean status = proRepository.updateValorProducto(productoSeleccionado);
        if(status){
            JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            resetComponentes();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtValorActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActualActionPerformed

    private void combCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combCuentasActionPerformed
        ProductoRepository proRepository = new ProductoRepository();
        String referencia = String.valueOf(combCuentas.getSelectedItem());
        productoSeleccionado = proRepository.getProducto(referencia);

        txtValorActual.setText(String.valueOf(productoSeleccionado.getValor()));
    }//GEN-LAST:event_combCuentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> combCuentas;
    private javax.swing.JComboBox<String> combTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblNCuenta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorActual;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JFormattedTextField txtValor;
    private javax.swing.JTextField txtValorActual;
    // End of variables declaration//GEN-END:variables
}
