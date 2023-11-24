/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooProyect;


import auxiliar.CConexion;
import auxiliar.PaddedCellRenderer;
import auxiliar.Render;
import auxiliar.panelMensaje;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class CMembresias {
    public void mostrarMembresias(JTable paramTablaMembresias){
        tableStyles(paramTablaMembresias);
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Codigo","Nombre", "Descripcion", "Precio","Fecha Creación","Duración", "",""};
        paramTablaMembresias.setDefaultRenderer(Object.class,new Render());
        paramTablaMembresias.setBorder(null);
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        String sql="";
        JButton botonDetalle = new JButton();
        botonDetalle.setName("m");
        botonDetalle.setContentAreaFilled(false);
        botonDetalle.setBorder( null);
        botonDetalle.setOpaque(false);
        botonDetalle.setBorderPainted(false);
        
        JButton botonEliminar = new JButton();
        botonEliminar.setName("e");   
        botonEliminar.setContentAreaFilled(false);
        botonEliminar.setBorderPainted(false);
        botonEliminar.setBorder(null);
        botonEliminar.setOpaque(false);
        
        scaleImageSizeAutomatic(botonEliminar, "src/main/resources/images/Eliminar.png",30,30);
        scaleImageSizeAutomatic(botonDetalle, "src/main/resources/images/Detalle.png",30,30);
        
        sql="SELECT\n" +
            "	IDMembresia,\n" +
            "	membresiaNombre,\n" +
            "	membresiaDescripcion,\n" +
            "	membresiaPrecio,\n" +
            "	membresiaFechaCreacion,\n" +
            "	membresiaDuracion\n" +
            "FROM Membresia";
        
        String [] datos = new String[6];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);          
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), botonDetalle, botonEliminar});
            }
            
            paramTablaMembresias.setModel(modelo);
            tableStyles(paramTablaMembresias);
            
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void mostrarMembresiasSimple(JTable paramTablaMembresias){
        tableStyles(paramTablaMembresias);
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Codigo","Nombre", "Descripcion", "Precio","Fecha Creación","Duración"};
        paramTablaMembresias.setDefaultRenderer(Object.class,new Render());
        paramTablaMembresias.setBorder(null);
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        String sql="";
        
        
        sql="SELECT\n" +
            "	IDMembresia,\n" +
            "	membresiaNombre,\n" +
            "	membresiaDescripcion,\n" +
            "	membresiaPrecio,\n" +
            "	membresiaFechaCreacion,\n" +
            "	membresiaDuracion\n" +
            "FROM Membresia";
        
        String [] datos = new String[6];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);          
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            
            paramTablaMembresias.setModel(modelo);
            tableStyles2(paramTablaMembresias);
            
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void InsertarMembresias(String paramNombreMembresia, String paramDescripcionMembresia, String paramPrecioMembresia,String paramFechaCreacionMembresia,String paramDuracionMembresia){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO Membresia VALUES(?,?,?,CONVERT(DATE, ?, 103),?)";
        try{ 
            String fechaCreacionMembresia = paramFechaCreacionMembresia;
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCreacionMembresiaDate = inputDateFormat.parse(fechaCreacionMembresia);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaCreacionMembresiaJava = new java.sql.Date(fechaCreacionMembresiaDate.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,paramNombreMembresia);
            cs.setString(2,paramDescripcionMembresia);
            cs.setFloat(3,Float.parseFloat(paramPrecioMembresia));
            cs.setDate(4,fechaCreacionMembresiaJava);
            cs.setInt(5,Integer.parseInt(paramDuracionMembresia));
            cs.execute();
            String mensaje = "Se ingresó correctamente";
            new panelMensaje(null, true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void ModificarMembresias(String paramCodigoMembresia, String paramNombreMembresia, String paramDescripcionMembresia, String paramPrecioMembresia,String paramFechaCreacionMembresia,String paramDuracionMembresia){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE Membresia \n" +
                            "SET \n" +
                            "    Membresia.membresiaNombre = ?,\n" +
                            "    Membresia.membresiaDescripcion = ?,\n" +
                            "    Membresia.membresiaPrecio= ?,\n" +
                            "    Membresia.membresiaFechaCreacion = ?,\n" +
                            "    Membresia.membresiaDuracion = ?\n" +
                            "WHERE Membresia.IDMembresia = ? ";
        try{  
     
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCreacionMembresiaDate = inputDateFormat.parse(paramFechaCreacionMembresia);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaCreacionMembresiaJava = new java.sql.Date(fechaCreacionMembresiaDate.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setString(1,paramNombreMembresia);
            cs.setString(2,paramDescripcionMembresia);
            cs.setFloat(3,Float.parseFloat(paramPrecioMembresia));
            cs.setDate(4,fechaCreacionMembresiaJava);
            cs.setInt(5,Integer.parseInt(paramDuracionMembresia));
            cs.setInt(6,Integer.parseInt(paramCodigoMembresia));
            cs.execute();
            
            String mensaje = "Se guardó correctamente";
            new panelMensaje(null, true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarMembresia(Integer paramCodigo){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM Membresia WHERE Membresia.IDMembresia = ?";
        
        try{            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setInt(1,paramCodigo);  
            cs.execute();
            String mensaje = "Se eliminó el registro";
            new panelMensaje(null, true,mensaje).setVisible(true);
        } catch (Exception e){
            System.out.println("Error en eliminacion"+e.toString());
        }
    }
    
    public Map<String, String> asignarMembresia(Integer parametroCodigoDescuento) throws SQLException {
    CConexion objetoConexion = new CConexion();
    Map<String, String> membresiasData = new HashMap<>();

    // OBTENCION DE DATOS
    String consulta = "SELECT\n" +
                        "	IDMembresia,\n" +
                        "    membresiaNombre,\n" +
                        "    membresiaDescripcion,\n" +
                        "    membresiaPrecio,\n" +
                        "    membresiaFechaCreacion,\n" +
                        "    membresiaDuracion\n" +
                        "FROM Membresia	\n" +
                        "WHERE IDMembresia = ?;";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setInt(1, parametroCodigoDescuento);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        membresiasData.put("IDMembresia", resultSet.getString("IDMembresia"));
        membresiasData.put("membresiaNombre", resultSet.getString("membresiaNombre"));
        membresiasData.put("membresiaDescripcion", resultSet.getString("membresiaDescripcion"));
        membresiasData.put("membresiaPrecio", resultSet.getString("membresiaPrecio"));
        membresiasData.put("membresiaFechaCreacion", resultSet.getString("membresiaFechaCreacion"));
        membresiasData.put("membresiaDuracion", resultSet.getString("membresiaDuracion"));
    }

    return membresiasData;
    }
    public void mostrarMembresiaSimple(JTable paramTablaMembresias){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Codigo","Nombre", "Descripcion", "Precio","Fecha Creación","Duración"};
        paramTablaMembresias.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
        JButton botonEditar = new JButton("Editar");
        botonEditar.setName("m");
        
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setName("e");   
        
        
        sql="SELECT\n" +
            "	IDMembresia,\n" +
            "	membresiaNombre,\n" +
            "	membresiaDescripcion,\n" +
            "	membresiaPrecio,\n" +
            "	membresiaFechaCreacion,\n" +
            "	membresiaDuracion\n" +
            "FROM Membresia";
        
        String [] datos = new String[6];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);          
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            
            paramTablaMembresias.setModel(modelo);
            tableStyles(paramTablaMembresias);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void BuscarMembresias(JTextField paramBusqueda,JTable paramTablaMembresias) throws SQLException{
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        Object[] columnNames = {"Codigo","Nombre", "Descripcion", "Precio","Fecha Creación","Duración","" , ""};
        paramTablaMembresias.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        JButton botonDetalle = new JButton();
        botonDetalle.setName("m");
        JButton botonEliminar = new JButton();
        botonEliminar.setName("e");   
        
        botonDetalle.setBorder(null);
        botonEliminar.setBorder(null);
        scaleImageSizeAutomatic(botonEliminar, "src/main/resources/images/Eliminar.png",30,30);
        scaleImageSizeAutomatic(botonDetalle, "src/main/resources/images/Detalle.png",30,30);
        
        
        String sql="";
         sql = 
                        "SELECT\n" +
                        "	IDMembresia,\n" +
                        "	membresiaNombre,\n" +
                        "	membresiaDescripcion,\n" +
                        "	membresiaPrecio,\n" +
                        "	membresiaFechaCreacion,\n" +
                        "	membresiaDuracion\n" +
                        "FROM Membresia \n" +
                        "WHERE membresiaNombre LIKE '%' + '" + parametroString + "' + '%'";
        
        String [] datos = new String[8];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), botonDetalle, botonEliminar});
            }
            
            paramTablaMembresias.setModel(modelo);
            tableStyles(paramTablaMembresias);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
        
    }
    public void BuscarMembresiasSimple(JTextField paramBusqueda,JTable paramTablaMembresias) throws SQLException{
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        Object[] columnNames = {"Codigo","Nombre", "Descripcion", "Precio","Fecha Creación","Duración"};
        paramTablaMembresias.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        
        String sql="";
         sql = 
                        "SELECT\n" +
                        "	IDMembresia,\n" +
                        "	membresiaNombre,\n" +
                        "	membresiaDescripcion,\n" +
                        "	membresiaPrecio,\n" +
                        "	membresiaFechaCreacion,\n" +
                        "	membresiaDuracion\n" +
                        "FROM Membresia \n" +
                        "WHERE membresiaNombre LIKE '%' + '" + parametroString + "' + '%'";
        
        String [] datos = new String[8];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            
            paramTablaMembresias.setModel(modelo);
            tableStyles2(paramTablaMembresias);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
        
    }
    public void tableStyles(JTable table){
        //Ancho de columnas
        
        // Obtener el ancho de la tabla después de que esté visible
        int totalWidth = table.getWidth();
        int[] columnWidths = {8, 17, 32, 8, 14, 12,3,3}; // Porcentajes relativos al ancho total

        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
            column.setPreferredWidth(preferredWidth);
        }
            
        
        //Pading de celdas
        table.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, table.getColumnCount()-2)); // Agregar el renderizador con padding
        
    }
     public void tableStyles2(JTable table){
     
        int totalWidth = table.getWidth();
        int[] columnWidths = {9, 18, 33, 9, 15, 13};// Porcentajes relativos al ancho total

        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
            column.setPreferredWidth(preferredWidth);
        }
         //Pading de celdas
        table.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, table.getColumnCount())); // Agregar el renderizador con padding
        System.out.println(table.getColumnCount());   
    }
    public void scaleImageSizeAutomatic(JButton labelName, String route, Integer Ancho, Integer Alto){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Ancho, Alto, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
    }
}
