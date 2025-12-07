/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.gestionbanco.ui;

import co.edu.gestionbanco.entity.Producto;
import co.edu.gestionbanco.repository.ProductoRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class AgregarProductoDialog extends javax.swing.JDialog {

    String[] productos = {"Cuenta corriente", "Tarjeta de débito", "Crédito hipotecario", "Crédito de vehículo", "Línea de crédito rotativa"};
    private String id_usuario;

    public AgregarProductoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setCombProductos();
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    private void resetTxt() {
        combProductos.setSelectedIndex(0);
        txtReferencia.setText("");
        txtValor.setValue(null);
        checkEmpresarial.setSelected(false);
    }

    private String generarReferencia() {
        int numero = (int) (Math.random() * 90000000) + 10000000; // entre 10000000 y 99999999
        return String.valueOf(numero);
    }

    private void setCombProductos() {
        for (String producto : productos) {
            combProductos.addItem(producto);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combProductos = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        checkEmpresarial = new javax.swing.JCheckBox();
        btnGenerar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGREGAR PRODUCTO");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(combProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 70, 321, 43));

        btnCrear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 118, 44));

        lblReferencia.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblReferencia.setText("Referencia:");
        getContentPane().add(lblReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 164, 120, 25));

        txtReferencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtReferencia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtReferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReferenciaActionPerformed(evt);
            }
        });
        txtReferencia.setEditable(false);
        getContentPane().add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 215, 31));

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblValor.setText("Valor:");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 60, 25));

        checkEmpresarial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        checkEmpresarial.setText("Empresarial");
        checkEmpresarial.setToolTipText("");
        getContentPane().add(checkEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 181, 130, -1));

        btnGenerar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 80, 118, 44));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Agregar productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(lblTitulo)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 50));

        txtValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 210, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtReferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReferenciaActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed

        String referencia = id_usuario + generarReferencia();
        txtReferencia.setText(referencia);
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        ProductoRepository proRepository = new ProductoRepository();

        String nombre = String.valueOf(combProductos.getSelectedItem());
        int empresarial = checkEmpresarial.isSelected() ? 1 : 0;
        float valor;

        if (txtValor.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Digite un valor válido",
                "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            txtValor.requestFocus();
            return;
        }
        valor = ((Number) txtValor.getValue()).floatValue();

        Producto producto = new Producto(Integer.parseInt(id_usuario), txtReferencia.getText(), nombre, valor, empresarial);
        boolean status = proRepository.registrarProducto(producto);
        if (status) {
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
        }
        resetTxt();
    }//GEN-LAST:event_btnCrearActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarProductoDialog dialog = new AgregarProductoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JCheckBox checkEmpresarial;
    private javax.swing.JComboBox<String> combProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
