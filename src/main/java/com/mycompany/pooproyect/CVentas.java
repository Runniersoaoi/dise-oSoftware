/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooProyect;

import auxiliar.CConexion;
import auxiliar.PaddedCellRenderer;
import auxiliar.Render;
import auxiliar.panelMensaje;
import java.awt.Image;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class CVentas {
    JDialog auxiliar;
   public void mostrarVenta(JTable paramTablaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Código", "Monto Cancelado", "Monto Restante", "Estado", "Monto Total", "Fecha Cancelación","Fecha Venta","Cliente","Usuario", "",""};
        paramTablaCliente.setDefaultRenderer(Object.class,new Render());
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
        
        sql="SELECT \n" +
            "	IDVenta,\n" +
            "	montoAbonadoVenta,\n" +
            "	montoRestanteVenta,\n" +
            "	estadoVenta,\n" +
            "	montoTotalVenta,\n" +
            "	fechaCancelacionVenta,\n" +
            "	fechaVenta,\n" +
            "	FKCliente,\n" +
            "	FKUsuario\n" +
            "FROM venta";
        
        String [] datos = new String[9];
        
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
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9), botonDetalle, botonEliminar});
            }
            
            paramTablaCliente.setModel(modelo);
            tableStyles(paramTablaCliente);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
   public void mostrarVentaSimple(JTable paramTablaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Código", "Monto Cancelado", "Monto Restante", "Estado", "Monto Total", "Fecha Cancelación","Fecha Venta","Cliente","Usuario"};
        paramTablaCliente.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
       
        
        sql="SELECT \n" +
            "	IDVenta,\n" +
            "	montoAbonadoVenta,\n" +
            "	montoRestanteVenta,\n" +
            "	estadoVenta,\n" +
            "	montoTotalVenta,\n" +
            "	fechaCancelacionVenta,\n" +
            "	fechaVenta,\n" +
            "	FKCliente,\n" +
            "	FKUsuario\n" +
            "FROM venta";
        
        String [] datos = new String[9];
        
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
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
            }
            
            paramTablaCliente.setModel(modelo);
            tableStyles2(paramTablaCliente);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void InsertarVenta(String montoCancelado, String montoRestante, String estado ,  String montoTotal, String fechaCancelacion, String fechaVenta, String FKCliente, String FKUsuario){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "SET DATEFORMAT YMD\n" +
                            "INSERT INTO venta values (?,?,?,?,?,?,?,?)";
        try{  
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dfechaCancelacion = inputDateFormat.parse(fechaCancelacion);
            Date dfechaVenta = inputDateFormat.parse(fechaVenta);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date dfechaCancelacion2 = new java.sql.Date(dfechaCancelacion.getTime());
            java.sql.Date dfechaVenta2 = new java.sql.Date(dfechaVenta.getTime());

            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,montoCancelado);
            cs.setString(2,montoRestante);
            cs.setString(3,estado);
            cs.setString(4,montoTotal);
            cs.setDate(5, dfechaVenta2);
            cs.setDate(6,dfechaVenta2);
            cs.setString(7,FKCliente);
            cs.setString(8,FKUsuario);
            cs.execute();
            String mensaje = "La información se ha registrado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }

    public void ModificarVenta(String codigoVenta,String montoCancelado, String montoRestante, String estado ,  String montoTotal, String fechaCancelacion, String fechaVenta, String FKCliente, String FKUsuario){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE venta \n" +
                            "SET \n" +
                            "    venta.montoAbonadoVenta = ?,\n" +
                            "    venta.montoRestanteVenta = ?,\n" +
                            "    venta.estadoVenta = ?,\n" +
                            "    venta.montoTotalVenta = ?,\n" +
                            "    venta.fechaCancelacionVenta = CONVERT(DATE, ?, 103)  -- 103 indica el formato 'dd/mm/yyyy',\n" +
                            "    venta.fechaVenta = CONVERT(DATE, ?, 103)  -- 103 indica el formato 'dd/mm/yyyy',\n" +
                            "    venta.FKCliente = ?,\n" +
                            "    venta.FKUsuario = ?\n" +                      
                            "WHERE venta.IDVenta = ?";
        try{  
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dfechaCancelacion = inputDateFormat.parse(fechaCancelacion);
            Date dfechaVenta = inputDateFormat.parse(fechaVenta);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date dfechaCancelacion2 = new java.sql.Date(dfechaCancelacion.getTime());
            java.sql.Date dfechaVenta2 = new java.sql.Date(dfechaVenta.getTime());

       
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,montoCancelado);
            cs.setString(2,montoRestante);
            cs.setString(3,estado);
            cs.setString(4,montoTotal);
            cs.setDate(5, dfechaCancelacion2);
            cs.setDate(6,dfechaVenta2);
            cs.setString(7,FKCliente);
            cs.setString(8,FKUsuario);
            cs.execute();
            String mensaje = "Los cambios se han realizado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarVenta(String paramCodigo){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM venta \n" +                   
                            "WHERE venta.IDVenta = ?";
        try{  
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,paramCodigo);
            cs.execute();
            String mensaje = "Se eliminó el registro";
            new panelMensaje(null, true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public Map<String, String> asignarCliente(Integer parametroCodigoCliente) throws SQLException {
    CConexion objetoConexion = new CConexion();
    Map<String, String> clienteData = new HashMap<>();

    // OBTENCION DE DATOS
    String consulta = "SELECT \n" +
                        "	IDVenta,\n" +
                        "	montoAbonadoVenta,\n" +
                        "	montoRestanteVenta,\n" +
                        "	estadoVenta,\n" +
                        "	montoTotalVenta,\n" +
                        "	fechaCancelacionVenta,\n" +
                        "	fechaVenta,\n" +
                        "	FKCliente,\n" +
                        "	FKUsuario\n" +
                        "FROM venta\n" +
                        "WHERE IDVenta = ?";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setInt(1, parametroCodigoCliente);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        clienteData.put("IDVenta", resultSet.getString("IDVenta"));
        clienteData.put("montoAbonadoVenta", resultSet.getString("montoAbonadoVenta"));
        clienteData.put("montoRestanteVenta", resultSet.getString("montoRestanteVenta"));
        clienteData.put("estadoVenta", resultSet.getString("estadoVenta"));
        clienteData.put("montoTotalVenta", resultSet.getString("montoTotalVenta"));
        clienteData.put("fechaCancelacionVenta", resultSet.getString("fechaCancelacionVenta"));
        clienteData.put("fechaVenta", resultSet.getString("fechaVenta"));
        clienteData.put("FKCliente", resultSet.getString("FKCliente"));
        clienteData.put("FKUsuario", resultSet.getString("FKUsuario"));
    }

    return clienteData;
    }
    public void tableStyles(JTable table){
        //Ancho de columnas
        
        // Obtener el ancho de la tabla después de que esté visible
        int totalWidth = table.getWidth();
        int[] columnWidths = {11, 16, 10, 10, 11, 22,12,4,4};// Porcentajes relativos al ancho total

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
        //Ancho de columnas
        
        // Obtener el ancho de la tabla después de que esté visible
        int totalWidth = table.getWidth();
        int[] columnWidths = {12, 18, 11, 11, 12, 23,13};// Porcentajes relativos al ancho total

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
