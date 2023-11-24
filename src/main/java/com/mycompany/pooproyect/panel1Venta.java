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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class panel1Venta extends javax.swing.JPanel {

    CClientes objetoClientes = new CClientes();
    JFrame dashboard;
    JPanel panelVariableParm;
    public panel1Venta(JFrame Dashboard,JPanel panelVariableP) {
        panelVariableParm = panelVariableP;
        initComponents();
        dashboard=Dashboard;
        initStyles();
        paintImages();
        initConfiguration();
        tableStyles();
    }

    private void initStyles(){
        lblSeleccionCliente.putClientProperty("FlatLaf.styleClass", "h1");
        lblBusquedaCliente.putClientProperty("FlatLaf.styleClass", "h3");
        lblInformacionSeleccionada.putClientProperty("FlatLaf.styleClass", "h1");
        lblDni.putClientProperty("FlatLaf.styleClass", "h3");
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3");
        lblGenero.putClientProperty("FlatLaf.styleClass", "h3");
        lblTelefono.putClientProperty("FlatLaf.styleClass", "h3");
        lblCorreoElectronico.putClientProperty("FlatLaf.styleClass", "h3");
        lblFechaMembresia.putClientProperty("FlatLaf.styleClass", "h3");
                        
        JTableHeader header = tblReporteClientes.getTableHeader();
    

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
             
        tblReporteClientes.getTableHeader().setDefaultRenderer(headerRenderer);        
        tblReporteClientes.setRowHeight(35);       
        tblReporteClientes.putClientProperty("FlatLaf.styleClass", "h3" );
       
        //Scroll pane
        
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
        jScrollPane3.setBorder(null);      
        
        //Quitar bordes
        tblReporteClientes.setBorder(BorderFactory.createEmptyBorder());
        panelVariable.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane3.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        
        btnRegistrarCliente.putClientProperty("FlatLaf.styleClass", "h3" );
        btnRegistrarCliente.setForeground(new Color(5, 89, 253));
        btnRegistrarCliente.setBackground(Color.WHITE);
        btnRegistrarCliente.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnRegistrarCliente.setOpaque(true);
        
        
        btnSiguiente.putClientProperty("FlatLaf.styleClass", "h3" );
        btnSiguiente.setForeground(Color.GRAY);
        btnSiguiente.setBackground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.GRAY, 1));
        btnSiguiente.setOpaque(true);
        btnSiguiente.setFocusable(false);
        btnSiguiente.setContentAreaFilled(false);
        
        
        paramDNI.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDNI.setForeground(Color.BLACK);
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.setForeground(Color.BLACK);
        paramGenero.putClientProperty("FlatLaf.styleClass", "h3" );
        paramGenero.setForeground(Color.BLACK);
        paramTelefono.putClientProperty("FlatLaf.styleClass", "h3" );
        paramTelefono.setForeground(Color.BLACK);
        paramCorreo.putClientProperty("FlatLaf.styleClass", "h3" );
        paramCorreo.setForeground(Color.BLACK);
        paramFecha.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFecha.setForeground(Color.BLACK);
        
        paramDNI.setEditable(false);
        paramNombre.setEditable(false);
        paramGenero.setEditable(false);
        paramTelefono.setEditable(false);
        paramCorreo.setEditable(false);
        paramFecha.setEditable(false);
        paramDNI.setFocusable(false);
        paramNombre.setFocusable(false);
        paramGenero.setFocusable(false);
        paramTelefono.setFocusable(false);
        paramCorreo.setFocusable(false);
        paramFecha.setFocusable(false);
    }
    
    private void tableStyles(){
        //Ancho de columnas
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteClientes.getWidth();
                int[] columnWidths = {12, 18, 11, 11, 12, 23,13};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteClientes.getColumnCount(); i++) {
                    TableColumn column = tblReporteClientes.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });      
    }
    
    private void initConfiguration(){
         btnSiguiente.setEnabled(false);
         paramDNI.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarEstadoBoton();
            }
        });
         
        objetoClientes.mostrarClienteSimple(tblReporteClientes);
                   
        //Listener de mouse
        GlobalMouseListenerCliente  globalMouseListener = new GlobalMouseListenerCliente(lblBusquedaCliente);
        panelVariable.addMouseListener(globalMouseListener);
        //Listener de JtextField
        lblBusquedaCliente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    // Este método se ejecutará cuando se inserte texto
                    checkTextFieldAndExecuteCode();
                } catch (SQLException ex) {
                    Logger.getLogger(panel1Venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    // Este método se ejecutará cuando se elimine texto
                    checkTextFieldAndExecuteCode();
                } catch (SQLException ex) {
                    Logger.getLogger(panel1Venta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se cambie el estilo del texto (raramente usado en JTextField)
            }

            private void checkTextFieldAndExecuteCode() throws SQLException {
                // Coloca el código que deseas ejecutar aquí
                if(lblBusquedaCliente.getText().equals("") || lblBusquedaCliente.getText().equals("Ingresa cliente")){
                    objetoClientes.mostrarClienteSimple(tblReporteClientes);
                } else{
                    CClientes objetoClientes = new CClientes();
                    objetoClientes.BuscarCliente2(lblBusquedaCliente, tblReporteClientes);     
                }
            }
        });
    }
    private void actualizarEstadoBoton() {
        // Habilitar el botón solo si el JTextField tiene contenido
        btnSiguiente.setEnabled(!paramDNI.getText().isEmpty());
        btnSiguiente.putClientProperty("FlatLaf.styleClass", "h3" );
        btnSiguiente.setForeground(new Color(5, 89, 253));
        btnSiguiente.setBackground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnSiguiente.setOpaque(true);
        btnSiguiente.setFocusable(true);
    }
    private void paintImages(){
         scaleImageSizeAutomatic(btnBusqueda2, "src/main/resources/images/BuscarGris.png",20,20);       
         scaleImageSizeAutomatic(btnEliminar, "src/main/resources/images/CirculoEliminar.png",20,20); 
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

        panelVariable = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblBusquedaCliente = new javax.swing.JTextField();
        btnBusqueda2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporteClientes = new javax.swing.JTable();
        btnRegistrarCliente = new javax.swing.JButton();
        lblSeleccionCliente = new javax.swing.JLabel();
        lblInformacionSeleccionada = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCorreoElectronico = new javax.swing.JLabel();
        lblFechaMembresia = new javax.swing.JLabel();
        paramFecha = new javax.swing.JTextField();
        paramDNI = new javax.swing.JTextField();
        paramNombre = new javax.swing.JTextField();
        paramGenero = new javax.swing.JTextField();
        paramTelefono = new javax.swing.JTextField();
        paramCorreo = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1562, 940));

        panelVariable.setBackground(new java.awt.Color(255, 255, 255));

        lblBusquedaCliente.setBackground(new java.awt.Color(242, 242, 242));
        lblBusquedaCliente.setForeground(new java.awt.Color(153, 153, 153));
        lblBusquedaCliente.setText("Ingresa cliente");
        lblBusquedaCliente.setBorder(null);
        lblBusquedaCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblBusquedaClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblBusquedaClienteFocusLost(evt);
            }
        });
        lblBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBusquedaClientelblBusquedaProductoActionPerformed(evt);
            }
        });

        btnBusqueda2.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda2.setBorder(null);
        btnBusqueda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusqueda2MouseEntered(evt);
            }
        });
        btnBusqueda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqueda2btnBusquedaActionPerformed(evt);
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
                .addComponent(btnBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 1372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblReporteClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReporteClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1496, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1496, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
        );

        btnRegistrarCliente.setText("Registrar cliente ");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        lblSeleccionCliente.setText("Seleccione el cliente al que se le asignara la venta:");

        lblInformacionSeleccionada.setText("Información seleccionada:");

        lblDni.setText("DNI:");

        lblNombre.setText("Nombre:");

        lblGenero.setText("Genero:");

        lblTelefono.setText("Teléfono:");

        lblCorreoElectronico.setText("Correo electrónico:");

        lblFechaMembresia.setText("Fecha de inicio de membresía:");

        paramFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramFechaActionPerformed(evt);
            }
        });

        paramDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramDNIActionPerformed(evt);
            }
        });

        paramNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreActionPerformed(evt);
            }
        });

        paramGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramGeneroActionPerformed(evt);
            }
        });

        paramTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramTelefonoActionPerformed(evt);
            }
        });

        paramCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramCorreoActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelVariableLayout = new javax.swing.GroupLayout(panelVariable);
        panelVariable.setLayout(panelVariableLayout);
        panelVariableLayout.setHorizontalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblSeleccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblInformacionSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblDni, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paramDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290)
                .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(paramGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(lblCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(paramCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paramNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(paramTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(lblFechaMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(paramFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(1270, 1270, 1270)
                .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelVariableLayout.setVerticalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblSeleccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblInformacionSeleccionada)
                .addGap(54, 54, 54)
                .addGroup(panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblDni))
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(paramDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblGenero))
                    .addComponent(paramGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCorreoElectronico))
                    .addComponent(paramCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNombre))
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(paramNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblTelefono))
                    .addComponent(paramTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVariableLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblFechaMembresia))
                    .addComponent(paramFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVariable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVariable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblBusquedaClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaClienteFocusGained
        lblBusquedaCliente.setText("");
    }//GEN-LAST:event_lblBusquedaClienteFocusGained

    private void lblBusquedaClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaClienteFocusLost

    private void lblBusquedaClientelblBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblBusquedaClientelblBusquedaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaClientelblBusquedaProductoActionPerformed

    private void btnBusqueda2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusqueda2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda2MouseEntered

    private void btnBusqueda2btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqueda2btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda2btnBusquedaActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        lblBusquedaCliente.setText("");
        lblBusquedaCliente.requestFocus();
        CClientes objetoClientess = new CClientes();
        try {
            objetoClientess.BuscarCliente2(lblBusquedaCliente, tblReporteClientes);
        } catch (SQLException ex) {
            Logger.getLogger(panel1Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblReporteClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteClientesMouseClicked
        int filaSeleccionada = tblReporteClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener datos de la fila seleccionada
            String DNI = tblReporteClientes.getValueAt(filaSeleccionada, 0).toString();
            String nombre = tblReporteClientes.getValueAt(filaSeleccionada, 1).toString();
            String genero = tblReporteClientes.getValueAt(filaSeleccionada, 3).toString();
            String telefono = tblReporteClientes.getValueAt(filaSeleccionada, 4).toString();
            String correo = tblReporteClientes.getValueAt(filaSeleccionada, 5).toString();
            String fechaAfiliación = tblReporteClientes.getValueAt(filaSeleccionada, 6).toString();

            // Mostrar datos en JTextField
            paramDNI.setText(DNI);
            paramNombre.setText(nombre);
            paramGenero.setText(genero);
            paramTelefono.setText(telefono);
            paramCorreo.setText(correo);
            paramFecha.setText(fechaAfiliación);
            
        }
        
    }//GEN-LAST:event_tblReporteClientesMouseClicked

    private void paramFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramFechaActionPerformed

    private void paramDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramDNIActionPerformed

    private void paramNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreActionPerformed

    private void paramGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramGeneroActionPerformed

    private void paramTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramTelefonoActionPerformed

    private void paramCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramCorreoActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        new nuevoCliente(dashboard,true).setVisible(true);
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        String infoCliente[]= {paramDNI.getText(),paramNombre.getText()};
        panel2Venta panel2Venta = new panel2Venta(dashboard, panelVariableParm, infoCliente);
        panel2Venta.setSize(panelVariableParm.getWidth(),panelVariableParm.getHeight());
        panel2Venta.setLocation(0,0);
        panelVariable.removeAll();
        panelVariable.add(panel2Venta, BorderLayout.CENTER);
        panelVariable.revalidate();
        panelVariable.repaint();     
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lblBusquedaCliente;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFechaMembresia;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblInformacionSeleccionada;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSeleccionCliente;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JPanel panelVariable;
    private javax.swing.JTextField paramCorreo;
    private javax.swing.JTextField paramDNI;
    private javax.swing.JTextField paramFecha;
    private javax.swing.JTextField paramGenero;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JTextField paramTelefono;
    private javax.swing.JTable tblReporteClientes;
    // End of variables declaration//GEN-END:variables
}
