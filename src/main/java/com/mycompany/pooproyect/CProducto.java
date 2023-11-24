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
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class CProducto {
    JDialog auxiliar;
     public void mostrarProducto(JTable paramTablaProductos){
        CConexion objetoConexion = new CConexion();
        DecimalFormat decimalFormat = new DecimalFormat("0.######");
        Object[] columnNames = {"Código", "Nombre", "Precio", "Costo", "Stock", "Descripcion" ,"Categoria" , "Proovedor" ,"",""};
        paramTablaProductos.setDefaultRenderer(Object.class,new Render());
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
            "elemento.IDElemento,\n" +
            "elemento.nombreElemento,\n" +
            "elemento.precioElemento,\n" +
            "elemento.costoUnitarioElemento,\n" +
            "elemento.stockElemento,\n" +
            "elemento.descripcionElemento,\n" +
            "elemento.categoriaElemento,\n" +
            "elemento.FKProovedor\n" +
            "FROM elemento\n" ;
        
        String [] datos = new String[10];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                float precio = Float.parseFloat(datos[2]);
                datos[3] = rs.getString(4);
                float costo = Float.parseFloat(datos[3]);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),decimalFormat.format(precio),decimalFormat.format(costo),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), botonDetalle, botonEliminar});
            }
            
            paramTablaProductos.setModel(modelo);
            tableStyles2(paramTablaProductos);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
     public void mostrarProductoSimple(JTable paramTablaProductos){
        CConexion objetoConexion = new CConexion();
        DecimalFormat decimalFormat = new DecimalFormat("0.######");
        Object[] columnNames = {"Código", "Nombre", "Precio", "Costo", "Stock", "Descripcion" ,"Categoria" , "Proovedor"};
        paramTablaProductos.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
        
        sql="SELECT\n" +
            "elemento.IDElemento,\n" +
            "elemento.nombreElemento,\n" +
            "elemento.precioElemento,\n" +
            "elemento.costoUnitarioElemento,\n" +
            "elemento.stockElemento,\n" +
            "elemento.descripcionElemento,\n" +
            "elemento.categoriaElemento,\n" +
            "elemento.FKProovedor\n" +
            "FROM elemento\n" ;
        
        String [] datos = new String[10];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                float precio = Float.parseFloat(datos[2]);
                datos[3] = rs.getString(4);
                float costo = Float.parseFloat(datos[3]);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),decimalFormat.format(precio),decimalFormat.format(costo),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
            }
            
            paramTablaProductos.setModel(modelo);
            tableStyles2(paramTablaProductos);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public String obtenerIdPorValor(String valor) {
    CConexion objetoConexion = new CConexion();
    String id = "11223344556"; // Valor predeterminado en caso de que no se encuentre ningún registro
    
    String consulta = "SELECT RUCProovedor FROM proovedor WHERE razonSocialProovedor = ?";
    
    try {
        CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
        cs.setString(1, valor);

        ResultSet resultado = cs.executeQuery();
        if (resultado.next()) {
            id = resultado.getString("RUCProovedor");
        }
        resultado.close();
        cs.close();
        System.out.println(id);
    } catch (Exception e) {
        System.out.println("Error en ejecución: " + e.toString());
    }
    return id;
}
    public void InsertarProductos(String paramNombre, String paramPrecio, String paramCosto, String paramStock, String paramDescripcion, String paramCategoria, String paramProovedor, String valore7){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO elemento (nombreElemento, precioElemento, costoUnitarioElemento, stockElemento, descripcionElemento, categoriaElemento, FKProovedor)\n" +
                            "VALUES (?,?,?,?,?,?,?);";
        
       
        
        try{  
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,paramNombre);
            cs.setFloat(2,Float.parseFloat(paramPrecio));
            cs.setFloat(3,Float.parseFloat(paramCosto));
            cs.setInt(4,Integer.parseInt(paramStock));
            cs.setString(5,paramDescripcion);
            cs.setString(6,paramCategoria);
            cs.setString(7, paramProovedor);
            cs.execute();
            String mensaje = "La información se ha registrado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void ModificarProductos(String paramCodigo, String paramNombre, String paramPrecio, String paramCosto, String paramStock, String paramDescripcion, String paramCategoria, String paramProovedor){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE elemento \n" +
                            "SET \n" +
                            "    elemento.nombreElemento = ?, \n" +
                            "    elemento.precioElemento = ?,\n" +
                            "    elemento.costoUnitarioElemento = ?,\n" +
                            "    elemento.stockElemento = ?,\n" +
                            "    elemento.descripcionElemento = ?,\n" +
                            "    elemento.categoriaElemento = ?,\n" +
                            "    elemento.FKProovedor = ?\n" +
                            "WHERE elemento.IDElemento = ?";
        
        
        try{  
            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setString(1,paramNombre);
            cs.setFloat(2,Float.parseFloat(paramPrecio));
            cs.setFloat(3,Float.parseFloat(paramCosto));
            cs.setInt(4,Integer.parseInt(paramStock));
            cs.setString(5,paramDescripcion);
            cs.setString(6,paramCategoria);
            cs.setString(7, paramProovedor);
            cs.setInt(8, Integer.parseInt(paramCodigo));
            
            cs.execute();
            String mensaje = "Los cambios se han realizado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarProducto(Integer paramCodigo){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM elemento WHERE elemento.IDElemento = ?";
        
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
    public Map<String, String> asignarProductos(Integer parametroCodigo) throws SQLException {
    CConexion objetoConexion = new CConexion();
    Map<String, String> productoData = new HashMap<>();

    // OBTENCION DE DATOS
    String consulta = "SELECT IDElemento,nombreElemento, precioElemento, costoUnitarioElemento, stockElemento, descripcionElemento, categoriaElemento, FKProovedor FROM elemento WHERE IDElemento = ? \n";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setInt(1, parametroCodigo);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        productoData.put("IDElemento", resultSet.getString("IDElemento"));
        productoData.put("nombreElemento", resultSet.getString("nombreElemento"));
        productoData.put("precioElemento", resultSet.getString("precioElemento"));
        productoData.put("costoUnitarioElemento", resultSet.getString("costoUnitarioElemento"));
        productoData.put("stockElemento", resultSet.getString("stockElemento"));
        productoData.put("descripcionElemento", resultSet.getString("descripcionElemento"));
        productoData.put("FKCategoria", resultSet.getString("categoriaElemento"));
        productoData.put("FKProovedor", resultSet.getString("FKProovedor"));
    }

    return productoData;
    }
    public void BuscarProducto(JTextField paramBusqueda,JTable paramTablaProductos){
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        DecimalFormat decimalFormat = new DecimalFormat("0.######");
        Object[] columnNames = {"Código", "Nombre", "Precio", "Costo", "Stock", "Descripcion" ,"Categoria" , "Proovedor" ,"",""};
        paramTablaProductos.setDefaultRenderer(Object.class,new Render());
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
            "elemento.IDElemento,\n" +
            "elemento.nombreElemento,\n" +
            "elemento.precioElemento,\n" +
            "elemento.costoUnitarioElemento,\n" +
            "elemento.stockElemento,\n" +
            "elemento.descripcionElemento,\n" +
            "elemento.categoriaElemento,\n" +
            "elemento.FKProovedor\n" +
            "FROM elemento\n" +
            "WHERE elemento.nombreElemento LIKE '%' + '" + parametroString + "' + '%'";
        
        String [] datos = new String[10];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                float precio = Float.parseFloat(datos[2]);
                datos[3] = rs.getString(4);
                float costo = Float.parseFloat(datos[3]);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),decimalFormat.format(precio),decimalFormat.format(costo),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), botonDetalle, botonEliminar});
            }
            
            paramTablaProductos.setModel(modelo);
            tableStyles(paramTablaProductos);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    
    public void BuscarProductoSimple(JTextField paramBusqueda,JTable paramTablaProductos){
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        DecimalFormat decimalFormat = new DecimalFormat("0.######");
        Object[] columnNames = {"Código", "Nombre", "Precio", "Costo", "Stock", "Descripcion" ,"Categoria" , "Proovedor"};
        paramTablaProductos.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
        
        
        sql="SELECT\n" +
            "elemento.IDElemento,\n" +
            "elemento.nombreElemento,\n" +
            "elemento.precioElemento,\n" +
            "elemento.costoUnitarioElemento,\n" +
            "elemento.stockElemento,\n" +
            "elemento.descripcionElemento,\n" +
            "elemento.categoriaElemento,\n" +
            "elemento.FKProovedor\n" +
            "FROM elemento\n" +
            "WHERE elemento.nombreElemento LIKE '%' + '" + parametroString + "' + '%'";
        
        String [] datos = new String[10];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                float precio = Float.parseFloat(datos[2]);
                datos[3] = rs.getString(4);
                float costo = Float.parseFloat(datos[3]);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),decimalFormat.format(precio),decimalFormat.format(costo),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
            }
            
            paramTablaProductos.setModel(modelo);
            tableStyles2(paramTablaProductos);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void tableStyles(JTable table){
     
        
        
        int totalWidth = table.getWidth();
        int[] columnWidths = {6, 20, 8, 8, 6, 28,8,8,4,4};

        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
            column.setPreferredWidth(preferredWidth);
        }
         //Pading de celdas
        table.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, table.getColumnCount()-2)); // Agregar el renderizador con padding
        System.out.println(table.getColumnCount()-2);   
    }
    
    public void tableStyles2(JTable table){
     
        
        
        int totalWidth = table.getWidth();
        int[] columnWidths = {7, 21, 9, 9, 8, 29,9,8};
        
        
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