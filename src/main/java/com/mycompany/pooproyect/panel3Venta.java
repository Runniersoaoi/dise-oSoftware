/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pooProyect;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class panel3Venta extends javax.swing.JPanel {

    JFrame dashboard;
    JPanel panelVariableParm;
    TableModel tablaModel;
    String informacionCliente[];
    public panel3Venta(JFrame Dashboard,JPanel panelVariableP,TableModel tableModel,String[] infoCliente) {
        
        informacionCliente = infoCliente;
        initComponents();
        tablaModel = tableModel;
        dashboard=Dashboard;
        initStyles();
        
        tableStyles();
        initConfiguration();
    }

    private void initStyles(){
        lblConfirmacionVenta.putClientProperty("FlatLaf.styleClass", "h1");
        tblElementosVenta.putClientProperty("FlatLaf.styleClass", "h1");
        lblClienteInfo.putClientProperty("FlatLaf.styleClass", "h1");
        tblInfoAdicional.putClientProperty("FlatLaf.styleClass", "h1");
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3");
        lblDni.putClientProperty("FlatLaf.styleClass", "h3");
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3");
        lblFechaVenta.putClientProperty("FlatLaf.styleClass", "h3");
        lblMontoTotal.putClientProperty("FlatLaf.styleClass", "h3");
        lblMontoCancelado.putClientProperty("FlatLaf.styleClass", "h3");
        lblMontoRestante.putClientProperty("FlatLaf.styleClass", "h3");
        
                        
        JTableHeader header = tblReporteProducto.getTableHeader();
    

        // Propiedades encabezado
        header.putClientProperty("FlatLaf.styleClass", "h2");
        header.setReorderingAllowed(false);
        header.setOpaque(false);             
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("TableHeader.cellBorder", new BorderUIResource(BorderFactory.createMatteBorder(10, 20, 10, 0, new Color(5, 89, 253))));
        
        header.setPreferredSize(new Dimension(header.getWidth(), 50));
        header.setBackground(new Color(5, 89, 253));
        header.setForeground(new Color(255, 255, 255));         
        
        // Alineación a la izquierda 
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
             
        tblReporteProducto.getTableHeader().setDefaultRenderer(headerRenderer);        
        tblReporteProducto.setRowHeight(35);       
        tblReporteProducto.putClientProperty("FlatLaf.styleClass", "h3" );
       
        //Scroll pane
        
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
        jScrollPane3.setBorder(null);      
        
        //Quitar bordes
        tblReporteProducto.setBorder(BorderFactory.createEmptyBorder());
        jPanel6.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane3.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        
        btnVolver.putClientProperty("FlatLaf.styleClass", "h3" );
        btnVolver.setForeground(new Color(5, 89, 253));
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnVolver.setOpaque(true);
        
        btnRegistrar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnRegistrar.setForeground(new Color(5, 89, 253));
        btnRegistrar.setBackground(Color.WHITE);
        btnRegistrar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnRegistrar.setOpaque(true);
        
        
        paramDNI.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDNI.setForeground(Color.BLACK);
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.setForeground(Color.BLACK);
        paramFecha.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFecha.setForeground(Color.BLACK);
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        paramFecha.setText(day+"/"+month+"/"+year);
        paramMontoTotal.putClientProperty("FlatLaf.styleClass", "h3" );
        paramMontoTotal.setForeground(Color.BLACK);
        paramMontoCancelado.putClientProperty("FlatLaf.styleClass", "h3" );
        paramMontoCancelado.setForeground(Color.BLACK);
        paramMontoRestante.putClientProperty("FlatLaf.styleClass", "h3" );
        paramMontoRestante.setForeground(Color.BLACK);
        
        paramDNI.setEditable(false);
        paramNombre.setEditable(false);
        paramMontoTotal.setEditable(false);
        paramFecha.setEditable(false);
        paramMontoRestante.setEditable(false);
        paramDNI.setFocusable(false);
        paramNombre.setFocusable(false);
        paramFecha.setFocusable(false);
        paramMontoTotal.setFocusable(false);
        paramMontoRestante.setFocusable(false);
        paramFecha.setFocusable(false);
    }
    
    private void tableStyles(){
        
        
        tblReporteProducto.setModel(tablaModel);
        //Ancho de columnas
       this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteProducto.getWidth();
                int[] columnWidths = {33,33,34};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteProducto.getColumnCount(); i++) {
                    TableColumn column = tblReporteProducto.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        
        tblReporteProducto.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, tblReporteProducto.getColumnCount())); // Agregar el renderizador con padding
        System.out.println(tblReporteProducto.getColumnCount());   
        tblReporteProducto.setEnabled(false);
    }
    
    private void initConfiguration(){
       
        paramDNI.setText(informacionCliente[0]);
        paramNombre.setText(informacionCliente[1]);
        
        int indiceColumna = 2; // Cambia esto al índice de tu columna específica
        double suma = 0.0;
        int rowCount = tblReporteProducto.getRowCount();
         System.out.println("CANTIDAD COLUMNAS"+rowCount);

        for (int fila = 0; fila < rowCount; fila++) {
            Float valor = Float.parseFloat((tblReporteProducto.getValueAt(fila, indiceColumna)).toString());
            System.out.println("VALOR"+valor);  
            if (valor instanceof Number) {
                suma += ((Number) valor).doubleValue(); 
                System.out.println("ESCALA SUMA"+suma);
            }
            // Puedes agregar más lógica aquí si la columna puede contener otros tipos de datos
        }
        String sumaString = String.valueOf(suma);;
        paramMontoTotal.setText(sumaString);
        
        DocumentListener documentListener = new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    actualizarResultado();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    actualizarResultado();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    actualizarResultado();
                }

                private void actualizarResultado() {
                    try {
                        double num1 = Double.parseDouble(paramMontoTotal.getText());
                        double num2 = Double.parseDouble(paramMontoCancelado.getText());
                        double resultado = num1 - num2;
                        if (resultado < 0) {
                            paramMontoRestante.setText("Resultado negativo");
                        } else {
                            paramMontoRestante.setText(String.valueOf(resultado));
                        }
                    } catch (NumberFormatException ex) {
                        paramMontoRestante.setText("Error");
                    }
                }
            };
        
            paramMontoTotal.getDocument().addDocumentListener(documentListener);
            paramMontoCancelado.getDocument().addDocumentListener(documentListener);

    }
    
    public void scaleImageSizeAutomatic(JButton labelName, String route, Integer Ancho, Integer Alto){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Ancho, Alto, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);            
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tblInfoAdicional = new javax.swing.JLabel();
        lblConfirmacionVenta = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporteProducto = new javax.swing.JTable();
        tblElementosVenta = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblMontoRestante = new javax.swing.JLabel();
        lblClienteInfo = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        paramMontoRestante = new javax.swing.JTextField();
        lblFechaVenta = new javax.swing.JLabel();
        paramNombre = new javax.swing.JTextField();
        lblMontoTotal = new javax.swing.JLabel();
        paramMontoTotal = new javax.swing.JTextField();
        lblMontoCancelado = new javax.swing.JLabel();
        paramMontoCancelado = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        paramFecha = new javax.swing.JTextField();
        paramDNI = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInfoAdicional.setText("Información adicional para el  registro:");
        jPanel1.add(tblInfoAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 870, 40));

        lblConfirmacionVenta.setText("Información a registrar");
        jPanel1.add(lblConfirmacionVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 870, 40));

        jScrollPane3.setBorder(null);

        tblReporteProducto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblReporteProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteProducto.setToolTipText("");
        tblReporteProducto.setGridColor(new java.awt.Color(255, 255, 255));
        tblReporteProducto.setOpaque(false);
        tblReporteProducto.setRowHeight(35);
        tblReporteProducto.setSelectionBackground(new java.awt.Color(180, 205, 255));
        tblReporteProducto.getTableHeader().setResizingAllowed(false);
        tblReporteProducto.getTableHeader().setReorderingAllowed(false);
        tblReporteProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteProductoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReporteProducto);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1490, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1490, 260));

        tblElementosVenta.setText("Elementos a vender:");
        jPanel1.add(tblElementosVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 870, 40));

        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 70, 30));

        lblMontoRestante.setText("Monto restante:");
        jPanel1.add(lblMontoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 120, 30));

        lblClienteInfo.setText("Cliente que realiza la compra");
        jPanel1.add(lblClienteInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 870, 40));

        lblDni.setText("Dni:");
        jPanel1.add(lblDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 30, 30));

        paramMontoRestante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramMontoRestanteActionPerformed(evt);
            }
        });
        jPanel1.add(paramMontoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 130, 30));

        lblFechaVenta.setText("Fecha:");
        jPanel1.add(lblFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 50, 30));

        paramNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 310, 30));

        lblMontoTotal.setText("Monto total:");
        jPanel1.add(lblMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 90, 30));

        paramMontoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramMontoTotalActionPerformed(evt);
            }
        });
        jPanel1.add(paramMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 130, 30));

        lblMontoCancelado.setText("Monto cancelado:");
        jPanel1.add(lblMontoCancelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, 160, 30));

        paramMontoCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramMontoCanceladoActionPerformed(evt);
            }
        });
        jPanel1.add(paramMontoCancelado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 130, 30));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 650, 126, 40));

        btnVolver.setText("Volver");
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 650, 126, 40));

        paramFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramFechaActionPerformed(evt);
            }
        });
        jPanel1.add(paramFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 610, 130, 30));

        paramDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramDNIActionPerformed(evt);
            }
        });
        jPanel1.add(paramDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1572, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblReporteProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteProductoMouseClicked
        int column = tblReporteProducto.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblReporteProducto.getRowHeight();

        if(row < tblReporteProducto.getRowCount() && row >= 0 && column < tblReporteProducto.getColumnCount() && column >= 0){
            Object value = tblReporteProducto.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("e")){
                    int fila = tblReporteProducto.rowAtPoint(evt.getPoint());
                    
                }
            }
        }
    }//GEN-LAST:event_tblReporteProductoMouseClicked

    private void paramMontoRestanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramMontoRestanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramMontoRestanteActionPerformed

    private void paramNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreActionPerformed

    private void paramMontoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramMontoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramMontoTotalActionPerformed

    private void paramMontoCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramMontoCanceladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramMontoCanceladoActionPerformed

    private void paramFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramFechaActionPerformed

    private void paramDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramDNIActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String montoCancelado = paramMontoCancelado.getText();
        String montoRestante = paramMontoRestante.getText();
        String montoTotal = paramMontoTotal.getText();
        Float montoCanceladoF = Float.parseFloat(montoRestante);
        String fechaCancelacion = null;
        String fechaVenta2 = paramFecha.getText();
        String paramDni = paramDNI.getText();
        String paramUsuario = "72345678";
        String estado = "";
        if(montoCanceladoF==0){
             estado = "Completada";
        }
        if(montoCanceladoF >0){
             estado = "Pendiente";
        }
        CVentas objetoVentas = new CVentas();
        objetoVentas.InsertarVenta(montoCancelado,montoRestante,estado,montoTotal, fechaVenta2,fechaVenta2,paramUsuario,paramDni );
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblClienteInfo;
    private javax.swing.JLabel lblConfirmacionVenta;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFechaVenta;
    private javax.swing.JLabel lblMontoCancelado;
    private javax.swing.JLabel lblMontoRestante;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField paramDNI;
    private javax.swing.JTextField paramFecha;
    private javax.swing.JTextField paramMontoCancelado;
    private javax.swing.JTextField paramMontoRestante;
    private javax.swing.JTextField paramMontoTotal;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JLabel tblElementosVenta;
    private javax.swing.JLabel tblInfoAdicional;
    private javax.swing.JTable tblReporteProducto;
    // End of variables declaration//GEN-END:variables
}
