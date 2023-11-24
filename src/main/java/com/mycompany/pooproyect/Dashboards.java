/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pooProyect;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.Dimension;
import static java.awt.GridBagConstraints.BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author Admin
 */
public class Dashboards extends javax.swing.JFrame {

    
    /**
     * Creates new form fraamePrueba
     */
    public Dashboards() {
        initComponents();
        this.setExtendedState(6);
        initStyles();
        setDate();
        paintImages();
        setLocationRelativeTo(null);//Código para centrar ventana
        initConfiguration();
    }
    private void initStyles(){
        lblGymName1.putClientProperty("FlatLaf.styleClass", "h1");
        lblGymName2.putClientProperty("FlatLaf.styleClass", "h1");
        lblTitulo.putClientProperty( "FlatLaf.style", "font: bold $h00.font" );
        lblFecha.putClientProperty("FlatLaf.styleClass", "h3");
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3");
        lblCargo.putClientProperty("FlatLaf.styleClass", "h2");
        
        //Edicion de botones
        btnInicio.putClientProperty("FlatLaf.styleClass", "h2");
        btnVentas.putClientProperty("FlatLaf.styleClass", "h2");
        btnUsuarios.putClientProperty("FlatLaf.styleClass", "h2");
        btnMiembros.putClientProperty("FlatLaf.styleClass", "h2");
        btnMembresias.putClientProperty("FlatLaf.styleClass", "h2");
        btnProductos.putClientProperty("FlatLaf.styleClass", "h2");
        btnLlaves.putClientProperty("FlatLaf.styleClass", "h2");
        btnSalir.putClientProperty("FlatLaf.styleClass", "h2");
    }
    
    private void initConfiguration(){
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
    }
    
    private void paintImages(){
        scaleImage(btnInicio, "src/main/resources/images/Inicio.png");
        scaleImage(btnVentas, "src/main/resources/images/Ventas.png");
        scaleImage(btnUsuarios, "src/main/resources/images/Asistencia.png");
        scaleImage(btnMiembros, "src/main/resources/images/Miembros.png");
        scaleImage(btnMembresias, "src/main/resources/images/Membresias.png");
        scaleImage(btnProductos, "src/main/resources/images/Productos.png");
        scaleImage(btnLlaves, "src/main/resources/images/Llaves.png");
        scaleImage(btnSalir, "src/main/resources/images/Llaves.png");
        scaleImage(btnSalir, "src/main/resources/images/Salir.png");
        scaleImageLabel(lblLogo, "src/main/resources/images/LogoFacebook.png");
        scaleImageLabel(lblFotoUsuario, "src/main/resources/images/FotoUser1.png");
        
        
        
    }
    
    public void scaleImage(JButton labelName, String route){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    public void scaleImageSizeAutomatic(JButton labelName, String route){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    public void scaleImageLabel(JLabel labelName, String route){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    private void setDate(){
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        lblFecha.setText("Hoy es "+day+" de "+meses[month - 1]+" del "+year);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnMiembros = new javax.swing.JButton();
        btnMembresias = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnLlaves = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblGymName2 = new javax.swing.JLabel();
        lblGymName1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblFotoUsuario = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JButton();
        panelVariable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1920, 1020));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Inicio.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnInicio.setBorderPainted(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(20);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        jPanel7.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 372, 53));

        btnVentas.setText("Ventas");
        btnVentas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnVentas.setBorderPainted(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(20);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        jPanel7.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 59, 372, 53));

        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setIconTextGap(20);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jPanel7.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 372, 53));

        btnMiembros.setText("Miembros");
        btnMiembros.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnMiembros.setBorderPainted(false);
        btnMiembros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMiembros.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMiembros.setIconTextGap(20);
        btnMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiembrosActionPerformed(evt);
            }
        });
        jPanel7.add(btnMiembros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 372, 53));

        btnMembresias.setText("Membresías");
        btnMembresias.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnMembresias.setBorderPainted(false);
        btnMembresias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMembresias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMembresias.setIconTextGap(20);
        btnMembresias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMembresiasActionPerformed(evt);
            }
        });
        jPanel7.add(btnMembresias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 372, 53));

        btnProductos.setText("Productos");
        btnProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnProductos.setBorderPainted(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnProductos.setIconTextGap(20);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jPanel7.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 372, 53));

        btnLlaves.setText("Llaves");
        btnLlaves.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnLlaves.setBorderPainted(false);
        btnLlaves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLlaves.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLlaves.setIconTextGap(20);
        btnLlaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlavesActionPerformed(evt);
            }
        });
        jPanel7.add(btnLlaves, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 372, 53));

        jScrollPane1.setViewportView(jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 790));

        lblLogo.setBackground(new java.awt.Color(204, 204, 204));
        lblLogo.setText("Logo");
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 80, 76));

        lblGymName2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGymName2.setText("Alpha");
        jPanel1.add(lblGymName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        lblGymName1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblGymName1.setText("Gym");
        jPanel1.add(lblGymName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(242, 242, 242));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, 1080));

        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 1600, -1));

        jSeparator4.setForeground(new java.awt.Color(242, 242, 242));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 970, 280, -1));

        lblTitulo.setText("Inicio");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 470, 40));

        lblFecha.setText("Date");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        lblFotoUsuario.setText("Foto");
        jPanel1.add(lblFotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 10, 90, 90));

        lblNombre.setText("Maria Cardenas");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 30, -1, -1));

        lblCargo.setText("Administradora");
        jPanel1.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 60, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(242, 242, 242));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(242, 242, 242)));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 280, -1));

        btnSalir.setText("Cerrar Sesión");
        btnSalir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 20, 1, 1, new java.awt.Color(0, 0, 0)));
        btnSalir.setBorderPainted(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSalir.setIconTextGap(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 990, 260, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, -1));

        panelVariable.setBackground(new java.awt.Color(204, 204, 204));
        panelVariable.setPreferredSize(new java.awt.Dimension(1540, 850));

        javax.swing.GroupLayout panelVariableLayout = new javax.swing.GroupLayout(panelVariable);
        panelVariable.setLayout(panelVariableLayout);
        panelVariableLayout.setHorizontalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1570, Short.MAX_VALUE)
        );
        panelVariableLayout.setVerticalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );

        getContentPane().add(panelVariable, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 126, 1570, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        lblTitulo.setText("Inicio");
        
        btnInicio.setEnabled(false);
        btnInicio.requestFocus();
        btnVentas.setEnabled(true);
        btnUsuarios.setEnabled(true);
        btnMiembros.setEnabled(true);
        btnMembresias.setEnabled(true);
        btnProductos.setEnabled(true);
        btnLlaves.setEnabled(true);
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        lblTitulo.setText("Ventas");
        
        panel1Venta panel1Venta = new panel1Venta(this,panelVariable);
        panel1Venta.setSize(panelVariable.getWidth(),panelVariable.getHeight());
        panel1Venta.setLocation(0,0);
        panelVariable.removeAll();
        panelVariable.add(panel1Venta, BorderLayout.CENTER);
        panelVariable.revalidate();
        panelVariable.repaint();
        btnMiembros.setFocusable(true);
        btnInicio.setEnabled(true);
        btnVentas.setEnabled(false);
        btnUsuarios.setEnabled(true);
        btnMiembros.setEnabled(true);
        btnMiembros.requestFocus();
        btnMembresias.setEnabled(true);
        btnProductos.setEnabled(true);
        btnLlaves.setEnabled(true);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiembrosActionPerformed
        
        
    }//GEN-LAST:event_btnMiembrosActionPerformed

    private void btnMembresiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMembresiasActionPerformed
        
    }//GEN-LAST:event_btnMembresiasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
       
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnLlavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlavesActionPerformed
        lblTitulo.setText("Llaves");
        
        btnMiembros.setFocusable(true);
        btnInicio.setEnabled(true);
        btnVentas.setEnabled(true);
        btnUsuarios.setEnabled(true);
        btnMiembros.setEnabled(true);
        btnMembresias.setEnabled(true);
        btnProductos.setEnabled(true);
        btnLlaves.setEnabled(false);
        btnLlaves.requestFocus();
    }//GEN-LAST:event_btnLlavesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        System.setProperty("sun.java2d.uiScale", "1.0");
        
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboards().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLlaves;
    private javax.swing.JButton btnMembresias;
    private javax.swing.JButton btnMiembros;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFotoUsuario;
    private javax.swing.JLabel lblGymName1;
    private javax.swing.JLabel lblGymName2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelVariable;
    // End of variables declaration//GEN-END:variables
}
