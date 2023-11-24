/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pooProyect;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author labf403
 */
public class nuevoCliente extends javax.swing.JDialog {

    int variableCambios=0;
    int varPosition;
    int codigoMembresiasLocal;
    boolean estado = false;
    int i;
    String[] valores = new String[10];
    
    Boolean resultado = true;
    
    public nuevoCliente(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
    }

    private void initStyles(){
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1" );
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setOpaque(true);
        
        lblCodigo.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCodigo.setForeground(Color.GRAY);
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        lblNombre.setForeground(Color.GRAY);
        lblApellidoPaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        lblApellidoPaterno.setForeground(Color.GRAY);
        lblApellidoMaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        lblApellidoMaterno.setForeground(Color.GRAY);
        lblTelefono.putClientProperty("FlatLaf.styleClass", "h3" );
        lblTelefono.setForeground(Color.GRAY);
        lblGenero.putClientProperty("FlatLaf.styleClass", "h3" );
        lblGenero.setForeground(Color.GRAY);
        lblCorreoElectronico.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCorreoElectronico.setForeground(Color.GRAY);
        lblFechaContrato.putClientProperty("FlatLaf.styleClass", "h3" );
        lblFechaContrato.setForeground(Color.GRAY);
        
        paramDNI.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDNI.setForeground(Color.BLACK);
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.setForeground(Color.BLACK);
        paramApellidoPaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        paramApellidoPaterno.setForeground(Color.BLACK);
        paramApellidoMaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        paramApellidoMaterno.setForeground(Color.BLACK);
        paramTelefono.putClientProperty("FlatLaf.styleClass", "h3" );
        paramTelefono.setForeground(Color.BLACK);
        paramGenero.putClientProperty("FlatLaf.styleClass", "h3" );
        paramGenero.setForeground(Color.BLACK);
        paramCorreoElectronico.putClientProperty("FlatLaf.styleClass", "h3" );
        paramCorreoElectronico.setForeground(Color.BLACK);
        paramFechaContrata.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFechaContrata.setForeground(Color.BLACK);
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        paramFechaContrata.setText(day+"/"+month+"/"+year);
        paramFechaContrata.setEditable(false);
        paramFechaContrata.setFocusable(false);
        
        
        btnGuardar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnGuardar.setForeground(new Color(5, 89, 253));
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnGuardar.setOpaque(true);
        
        btnVolver.putClientProperty("FlatLaf.styleClass", "h3" );
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setBorder(new LineBorder(Color.GRAY, 1));
        btnVolver.setOpaque(true);
        
        paramNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramApellidoPaterno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramApellidoMaterno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramTelefono.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramGenero.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramCorreoElectronico.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramFechaContrata.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblApellidoMaterno = new javax.swing.JLabel();
        paramCorreoElectronico = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        paramFechaContrata = new javax.swing.JTextField();
        lblCorreoElectronico = new javax.swing.JLabel();
        lblFechaContrato = new javax.swing.JLabel();
        paramDNI = new javax.swing.JTextField();
        paramNombre = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        paramApellidoPaterno = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        paramTelefono = new javax.swing.JTextField();
        paramApellidoMaterno = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblGenero = new javax.swing.JLabel();
        paramGenero = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno: ");
        jPanel1.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 282, -1, -1));
        jPanel1.add(paramCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 340, 30));

        lblTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblTelefono.setText("Teléfono:");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 352, 71, -1));
        jPanel1.add(paramFechaContrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 340, 30));

        lblCorreoElectronico.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCorreoElectronico.setText("Correo Electrónico:");
        jPanel1.add(lblCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 492, 210, -1));

        lblFechaContrato.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblFechaContrato.setText("Fecha de contrata:");
        jPanel1.add(lblFechaContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 562, 230, -1));

        paramDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramDNIActionPerformed(evt);
            }
        });
        jPanel1.add(paramDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 30));

        paramNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 340, 30));

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigo.setText("Dni: ");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 72, -1, -1));
        jPanel1.add(paramApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 340, 30));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 142, 83, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno: ");
        jPanel1.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 212, 138, -1));
        jPanel1.add(paramTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 340, 30));

        paramApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramApellidoMaternoActionPerformed(evt);
            }
        });
        jPanel1.add(paramApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 340, 30));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 638, 126, 40));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 638, 126, 40));

        lblGenero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblGenero.setText("Genero:");
        jPanel1.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 422, 59, -1));

        paramGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(paramGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 340, 30));

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Crear Nuevo Miembro");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramDNIActionPerformed

    private void paramNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreActionPerformed

    private void paramApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramApellidoMaternoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        valores[0] = paramDNI.getText();
        valores[1] = paramNombre.getText();
        valores[2] = paramApellidoPaterno.getText();
        valores[3] = paramApellidoMaterno.getText();
        valores[4] = paramGenero.getText();
        valores[5] = paramTelefono.getText();
        valores[6] = paramCorreoElectronico.getText();
        valores[7] = paramFechaContrata.getText();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String tipo = "crearCliente";
            String mensaje = "<html>¿Está seguro de que quiere insertar el registro?</html>";

            new panelConfirmacion(this, true, titulo, mensaje, tipo, 0, valores).setVisible(true);
        } else{
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        if (estado==false){
            if(variableCambios==1){
                String titulo = "Confirmación";
                String mensaje = "<html>¿Está seguro de que quiere volver a la ventana principal?<br/>La información modificada se perderá.</html>";
                new panelConfirmacion(this, true, titulo, mensaje, null, 0, null).setVisible(true);
            } else{
                this.dispose();
            }

        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void paramGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramGeneroActionPerformed

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
            com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
         } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoCliente(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblFechaContrato;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramApellidoMaterno;
    private javax.swing.JTextField paramApellidoPaterno;
    private javax.swing.JTextField paramCorreoElectronico;
    private javax.swing.JTextField paramDNI;
    private javax.swing.JTextField paramFechaContrata;
    private javax.swing.JTextField paramGenero;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JTextField paramTelefono;
    // End of variables declaration//GEN-END:variables
}
