/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.pooProyect;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.Vector;
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

/**
 *
 * @author Admin
 */
public class panel2Venta extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    DefaultTableModel tableModelSimple;
    CMembresias objetoMembresias = new CMembresias();
    CProducto objetoProducto = new CProducto();
    JFrame dashboard;
    String[] informacionCliente ;
    JPanel panelVariableParm;
    public panel2Venta(JFrame Dashboard,JPanel panelVariableP,String[] infoCliente) {
        initComponents();
        panelVariableParm = panelVariableP;
        informacionCliente = infoCliente;
        dashboard=Dashboard;       
        initStyles();
        paintImages();
        initConfiguration();
        tableStyles();
        objetoMembresias.mostrarMembresiasSimple(tblReporteMembresias);    
        objetoProducto.mostrarProductoSimple(tblReporteMembresias1);     
    }

    private void initStyles(){
        lblelementosCapturados.putClientProperty("FlatLaf.styleClass", "h1");
        lblBusquedaProducto1.putClientProperty("FlatLaf.styleClass", "h3");
        lblelementosCapturados.putClientProperty("FlatLaf.styleClass", "h1");
        tfBusquedaProducto.putClientProperty("FlatLaf.styleClass", "h3");
        lblSeleccionCliente1.putClientProperty("FlatLaf.styleClass", "h1");   
        lblCantidad.putClientProperty("FlatLaf.styleClass", "h3");
        JTableHeader header = tblReporteMembresias.getTableHeader();
        JTableHeader header2 = tblReporteMembresias1.getTableHeader();
        JTableHeader header3 = tblReporteProducto.getTableHeader();
    

        // Propiedades encabezado
        header.putClientProperty("FlatLaf.styleClass", "h2");
        header.setReorderingAllowed(false);
        header.setOpaque(false);  
        
        header2.putClientProperty("FlatLaf.styleClass", "h2");
        header2.setReorderingAllowed(false);
        header2.setOpaque(false); 
        
        header3.putClientProperty("FlatLaf.styleClass", "h2");
        header3.setReorderingAllowed(false);
        header3.setOpaque(false); 
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("TableHeader.cellBorder", new BorderUIResource(BorderFactory.createMatteBorder(10, 20, 10, 0, new Color(5, 89, 253))));
        
        header.setPreferredSize(new Dimension(header.getWidth(), 50));
        header.setBackground(new Color(5, 89, 253));
        header.setForeground(new Color(255, 255, 255));  
        
        header2.setPreferredSize(new Dimension(header.getWidth(), 50));
        header2.setBackground(new Color(5, 89, 253));
        header2.setForeground(new Color(255, 255, 255));    
        
        header3.setPreferredSize(new Dimension(header.getWidth(), 50));
        header3.setBackground(new Color(5, 89, 253));
        header3.setForeground(new Color(255, 255, 255));    
        
        // Alineación a la izquierda 
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        
        DefaultTableCellRenderer headerRenderer2 = (DefaultTableCellRenderer) header2.getDefaultRenderer();
        headerRenderer2.setHorizontalAlignment(SwingConstants.LEFT);
        
        DefaultTableCellRenderer headerRenderer3 = (DefaultTableCellRenderer) header3.getDefaultRenderer();
        headerRenderer3.setHorizontalAlignment(SwingConstants.LEFT);
             
        tblReporteMembresias1.getTableHeader().setDefaultRenderer(headerRenderer);        
        tblReporteMembresias1.setRowHeight(35);       
        tblReporteMembresias1.putClientProperty("FlatLaf.styleClass", "h3" );
        
        tblReporteMembresias.getTableHeader().setDefaultRenderer(headerRenderer);        
        tblReporteMembresias.setRowHeight(35);       
        tblReporteMembresias.putClientProperty("FlatLaf.styleClass", "h3" );
        
        tblReporteProducto.getTableHeader().setDefaultRenderer(headerRenderer);        
        tblReporteProducto.setRowHeight(35);       
        tblReporteProducto.putClientProperty("FlatLaf.styleClass", "h3" );
       
        //Scroll pane   
        
        //Quitar bordes
        tblReporteMembresias.setBorder(BorderFactory.createEmptyBorder());
        jPanel2.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane1.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        tblReporteMembresias1.setBorder(BorderFactory.createEmptyBorder());
        jPanel5.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane2.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        tblReporteProducto.setBorder(BorderFactory.createEmptyBorder());
        jPanel6.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane3.setBorder(new EmptyBorder(0, 0, 0, 0));
              
        btnSiguiente.putClientProperty("FlatLaf.styleClass", "h3" );
        btnSiguiente.setForeground(new Color(5, 89, 253));
        btnSiguiente.setBackground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnSiguiente.setOpaque(true);
        
        btnAgregarMembresia.putClientProperty("FlatLaf.styleClass", "h3" );
        btnAgregarMembresia.setForeground(new Color(5, 89, 253));
        btnAgregarMembresia.setBackground(Color.WHITE);
        btnAgregarMembresia.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnAgregarMembresia.setOpaque(true);
        
        btnAgregarProducto.putClientProperty("FlatLaf.styleClass", "h3" );
        btnAgregarProducto.setForeground(new Color(5, 89, 253));
        btnAgregarProducto.setBackground(Color.WHITE);
        btnAgregarProducto.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnAgregarProducto.setOpaque(true);
        
        cantidadProducto.putClientProperty("FlatLaf.styleClass", "h3" );
        cantidadProducto.setForeground(Color.BLACK);
  
    }
    
    private void tableStyles(){
        
        
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Duración o Cantidad");
        tableModel.addColumn("Monto");
        tableModel.addColumn("");
        tableModelSimple = new DefaultTableModel();
        tableModelSimple.addColumn("Nombre");
        tableModelSimple.addColumn("Duración o Cantidad");
        tableModelSimple.addColumn("Monto");
        tblReporteProducto.setModel(tableModel);
        tblReporteProducto.setEnabled(false);

        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteProducto.getWidth();
                int[] columnWidths = {32,32,32, 4};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteProducto.getColumnCount(); i++) {
                    TableColumn column = tblReporteProducto.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        
        tblReporteProducto.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, tblReporteProducto.getColumnCount())); // Agregar el renderizador con padding
        System.out.println(tblReporteProducto.getColumnCount());   
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteMembresias.getWidth();
                int[] columnWidths = {9, 18, 33, 9, 15, 13};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteMembresias.getColumnCount(); i++) {
                    TableColumn column = tblReporteMembresias.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteMembresias1.getWidth();
                int[] columnWidths = {7, 21, 9, 9, 8, 29,9,8};

                for (int i = 0; i < tblReporteMembresias1.getColumnCount(); i++) {
                    TableColumn column = tblReporteMembresias1.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
    }
    
    private void initConfiguration(){
          
        //Listener de mouse
        GlobalMouseListener globalMouseListener = new GlobalMouseListener(tfBusquedaProducto);
        jPanel1.addMouseListener(globalMouseListener);
        
        //Listener de JtextField
        tfBusquedaProducto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se inserte texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se elimine texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se cambie el estilo del texto (raramente usado en JTextField)
            }

            private void checkTextFieldAndExecuteCode() {
                // Coloca el código que deseas ejecutar aquí
                if(tfBusquedaProducto.getText().equals("") || tfBusquedaProducto.getText().equals("Ingresa Membresía")){
                    objetoMembresias.mostrarMembresiasSimple(tblReporteMembresias);
                } else{
                    CMembresias objetoMembresias = new CMembresias();
                    try {
                        objetoMembresias.BuscarMembresiasSimple(tfBusquedaProducto, tblReporteMembresias);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Dashboards.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                }
            }
        });
        
       
        
        //Listener de mouse
        GlobalMouseListenerProducto  globalMouseListener2 = new GlobalMouseListenerProducto(lblBusquedaProducto1);
        jPanel1.addMouseListener(globalMouseListener2);
        //Listener de JtextField
        lblBusquedaProducto1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se inserte texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se elimine texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se cambie el estilo del texto (raramente usado en JTextField)
            }

            private void checkTextFieldAndExecuteCode() {
                // Coloca el código que deseas ejecutar aquí
                if(lblBusquedaProducto1.getText().equals("") || lblBusquedaProducto1.getText().equals("Ingresa producto")){
                    objetoProducto.mostrarProductoSimple(tblReporteMembresias1);
                } else{
                    CProducto objetoProducto  = new CProducto ();
                    objetoProducto.BuscarProductoSimple(lblBusquedaProducto1, tblReporteMembresias1);     
                }
            }
        });
    }
    private void paintImages(){
         scaleImageSizeAutomatic(btnBusqueda, "src/main/resources/images/BuscarGris.png",20,20);     
         scaleImageSizeAutomatic(btnBusqueda1, "src/main/resources/images/BuscarGris.png",20,20);     
         scaleImageSizeAutomatic(btnEliminar, "src/main/resources/images/CirculoEliminar.png",20,20); 
         scaleImageSizeAutomatic(btnEliminar1, "src/main/resources/images/CirculoEliminar.png",20,20);
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
        lblelementosCapturados = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfBusquedaProducto = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteMembresias = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblBusquedaProducto1 = new javax.swing.JTextField();
        btnBusqueda1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReporteMembresias1 = new javax.swing.JTable();
        lblSeleccionCliente1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporteProducto = new javax.swing.JTable();
        btnSiguiente = new javax.swing.JButton();
        btnAgregarMembresia = new javax.swing.JButton();
        lblCantidad = new javax.swing.JLabel();
        cantidadProducto = new javax.swing.JSpinner();
        btnAgregarProducto = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblelementosCapturados.setText("Elementos agregados a la venta:");

        tfBusquedaProducto.setBackground(new java.awt.Color(242, 242, 242));
        tfBusquedaProducto.setForeground(new java.awt.Color(153, 153, 153));
        tfBusquedaProducto.setText("Ingresa Membresía");
        tfBusquedaProducto.setBorder(null);
        tfBusquedaProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBusquedaProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBusquedaProductoFocusLost(evt);
            }
        });

        btnBusqueda.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda.setBorder(null);
        btnBusqueda.setBorderPainted(false);
        btnBusqueda.setContentAreaFilled(false);
        btnBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBusqueda.setFocusPainted(false);
        btnBusqueda.setFocusable(false);
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseEntered(evt);
            }
        });
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFocusable(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);

        tblReporteMembresias.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblReporteMembresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteMembresias.setToolTipText("");
        tblReporteMembresias.setGridColor(new java.awt.Color(255, 255, 255));
        tblReporteMembresias.setOpaque(false);
        tblReporteMembresias.setRowHeight(35);
        tblReporteMembresias.setSelectionBackground(new java.awt.Color(180, 205, 255));
        tblReporteMembresias.getTableHeader().setResizingAllowed(false);
        tblReporteMembresias.getTableHeader().setReorderingAllowed(false);
        tblReporteMembresias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteMembresiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporteMembresias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1490, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        lblBusquedaProducto1.setBackground(new java.awt.Color(242, 242, 242));
        lblBusquedaProducto1.setForeground(new java.awt.Color(153, 153, 153));
        lblBusquedaProducto1.setText("Ingresa producto");
        lblBusquedaProducto1.setBorder(null);
        lblBusquedaProducto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblBusquedaProducto1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblBusquedaProducto1FocusLost(evt);
            }
        });
        lblBusquedaProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBusquedaProducto1ActionPerformed(evt);
            }
        });

        btnBusqueda1.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda1.setBorder(null);
        btnBusqueda1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusqueda1MouseEntered(evt);
            }
        });
        btnBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqueda1ActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar1.setBorder(null);
        btnEliminar1.setBorderPainted(false);
        btnEliminar1.setContentAreaFilled(false);
        btnEliminar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar1.setFocusPainted(false);
        btnEliminar1.setFocusable(false);
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminar1MouseEntered(evt);
            }
        });
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBusquedaProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBusquedaProducto1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(btnBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBorder(null);

        tblReporteMembresias1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblReporteMembresias1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteMembresias1.setToolTipText("");
        tblReporteMembresias1.setGridColor(new java.awt.Color(255, 255, 255));
        tblReporteMembresias1.setOpaque(false);
        tblReporteMembresias1.setRowHeight(35);
        tblReporteMembresias1.setSelectionBackground(new java.awt.Color(180, 205, 255));
        tblReporteMembresias1.getTableHeader().setResizingAllowed(false);
        tblReporteMembresias1.getTableHeader().setReorderingAllowed(false);
        tblReporteMembresias1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteMembresias1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblReporteMembresias1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1490, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        lblSeleccionCliente1.setText("Seleccione los productos o asigne membresías:");

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAgregarMembresia.setText("Agregar");
        btnAgregarMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMembresiaActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad:");

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblSeleccionCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblelementosCapturados, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1400, 1400, 1400)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSeleccionCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblelementosCapturados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfBusquedaProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaProductoFocusGained
        tfBusquedaProducto.setText("");
    }//GEN-LAST:event_tfBusquedaProductoFocusGained

    private void tfBusquedaProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBusquedaProductoFocusLost

    private void btnBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaMouseEntered

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        tfBusquedaProducto.setText("");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblReporteMembresiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteMembresiasMouseClicked

        
    }//GEN-LAST:event_tblReporteMembresiasMouseClicked

    private void lblBusquedaProducto1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaProducto1FocusGained
        lblBusquedaProducto1.setText("");
    }//GEN-LAST:event_lblBusquedaProducto1FocusGained

    private void lblBusquedaProducto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaProducto1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaProducto1FocusLost

    private void lblBusquedaProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblBusquedaProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaProducto1ActionPerformed

    private void btnBusqueda1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusqueda1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda1MouseEntered

    private void btnBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqueda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda1ActionPerformed

    private void btnEliminar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1MouseEntered

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        lblBusquedaProducto1.setText("");
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void tblReporteMembresias1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteMembresias1MouseClicked
        
    }//GEN-LAST:event_tblReporteMembresias1MouseClicked

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
                    tableModel.removeRow(fila);
                    tableModelSimple.removeRow(fila);
                }
            }
        }
    }//GEN-LAST:event_tblReporteProductoMouseClicked

    private void btnAgregarMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMembresiaActionPerformed
        int filaSeleccionada = tblReporteMembresias.getSelectedRow();
        Object valorNombre = tblReporteMembresias.getValueAt(filaSeleccionada, 1);
        Object valorDuracion = tblReporteMembresias.getValueAt(filaSeleccionada, 5);
        Object valorPrecio = tblReporteMembresias.getValueAt(filaSeleccionada, 3);
        String nombre = valorNombre.toString();
        String duracion = valorDuracion.toString();
        String precio = valorPrecio.toString();
        
        JButton botonEliminar = new JButton();
        botonEliminar.setName("e");
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setBorder( null);
        botonEliminar.setOpaque(false);
        botonEliminar.setBorderPainted(false);
        scaleImageSizeAutomatic(botonEliminar, "src/main/resources/images/Eliminar.png",30,30);
        
        Object[] nuevaFila = {nombre , duracion, precio, botonEliminar};
        Object[] nuevaFilaSimple = {nombre , duracion, precio};
        tableModel.addRow(nuevaFila);
        tableModelSimple.addRow(nuevaFilaSimple);
        
    }//GEN-LAST:event_btnAgregarMembresiaActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        Float monto = null;
        Object value = cantidadProducto.getValue();
        String valueString = value.toString();
        Float valueInt = Float.parseFloat(valueString);
        
        int filaSeleccionada2 = tblReporteMembresias1.getSelectedRow();
        Object nombreProducto = tblReporteMembresias1.getValueAt(filaSeleccionada2, 1);
        String nombreProductoS = nombreProducto.toString();
        Object valorPrecio = tblReporteMembresias1.getValueAt(filaSeleccionada2, 2);
        String valuePrecio2 = valorPrecio.toString();
        Float precioInt = Float.parseFloat(valuePrecio2);
        System.out.println(valueInt);
        System.out.println(precioInt);
        JButton botonEliminar = new JButton();
        botonEliminar.setName("e");
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setBorder( null);
        botonEliminar.setOpaque(false);
        botonEliminar.setBorderPainted(false);
        scaleImageSizeAutomatic(botonEliminar, "src/main/resources/images/Eliminar.png",30,30);
        if(valueInt >0){
            monto = valueInt*precioInt;
            Object[] nuevaFila = {nombreProductoS , valueInt, monto, botonEliminar};
            Object[] nuevaFilaSimple = {nombreProductoS , valueInt, monto};
            tableModel.addRow(nuevaFila);
            tableModelSimple.addRow(nuevaFilaSimple);
            cantidadProducto.setValue(0);
        }     
        
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        
        panel3Venta panel3Venta = new panel3Venta(dashboard, panelVariableParm,tableModelSimple,informacionCliente);
        panel3Venta.setSize(panelVariableParm.getWidth(),panelVariableParm.getHeight());
        panel3Venta.setLocation(0,0);
        jPanel1.removeAll();
        jPanel1.add(panel3Venta, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();    
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMembresia;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnBusqueda1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JSpinner cantidadProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lblBusquedaProducto1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblSeleccionCliente1;
    private javax.swing.JLabel lblelementosCapturados;
    private javax.swing.JTable tblReporteMembresias;
    private javax.swing.JTable tblReporteMembresias1;
    private javax.swing.JTable tblReporteProducto;
    private javax.swing.JTextField tfBusquedaProducto;
    // End of variables declaration//GEN-END:variables
}
