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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author labf403
 */
public class CClientes {
    JDialog auxiliar;
   public void mostrarCliente(JTable paramTablaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"DNI", "Nombre", "Estado", "Genero", "Telefono", "Correo Electronico","Fecha Contrata", "",""};
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
                "DNICliente,\n" +
                "nombreCliente + ' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente AS nombreCompleto,\n" +
                "estadoCliente,\n" +
                "generoCliente,\n" +
                "telefonoCliente,\n" +
                "correoElectronicoCliente,\n" +
                "fechaIngresoCliente\n" +
                "FROM cliente;";
        
        String [] datos = new String[7];
        
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
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), botonDetalle, botonEliminar});
            }
            
            paramTablaCliente.setModel(modelo);
            tableStyles(paramTablaCliente);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
   public void mostrarClienteSimple(JTable paramTablaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"DNI", "Nombre", "Estado", "Genero", "Telefono", "Correo Electronico","Fecha Contrata"};
        paramTablaCliente.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
       
        
        sql="SELECT \n" +
                "DNICliente,\n" +
                "nombreCliente + ' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente AS nombreCompleto,\n" +
                "estadoCliente,\n" +
                "generoCliente,\n" +
                "telefonoCliente,\n" +
                "correoElectronicoCliente,\n" +
                "fechaIngresoCliente\n" +
                "FROM cliente;";
        
        String [] datos = new String[7];
        
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
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
            
            paramTablaCliente.setModel(modelo);
            tableStyles2(paramTablaCliente);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void InsertarClientes(String paramDNI, String paramNombre, String paramApellidoPaterno, String paramApellidoMaterno ,  String paramGenero, String paramTelefono, String paramCorreoElectronico, String paramFechaContrata){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "SET DATEFORMAT YMD INSERT INTO cliente (DNICliente, nombreCliente, apellidoPaternoCliente, apellidoMaternoCliente, estadoCliente, generoCliente, telefonoCliente, correoElectronicoCliente,fechaIngresoCliente)"+
                            "VALUES (?,?,?,?,?,?,?,?,?);";
        try{  
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaContrata = inputDateFormat.parse(paramFechaContrata);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaContrata2 = new java.sql.Date(fechaContrata.getTime());

            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,Integer.parseInt(paramDNI));
            cs.setString(2,paramNombre);
            cs.setString(3,paramApellidoPaterno);
            cs.setString(4,paramApellidoMaterno);
            cs.setString(5,"Vigente");
            cs.setString(6,paramGenero);
            cs.setString(7,paramTelefono);
            cs.setString(8,paramCorreoElectronico);
            cs.setDate(9, fechaContrata2);
            cs.execute();
            String mensaje = "La información se ha registrado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public String DevolverCodigo(String paramNombre) {
        CConexion objetoConexion = new CConexion();
        String codigoDNI = null;
        String consulta = "SELECT DNICliente FROM cliente\n" +
                          "WHERE (nombreCliente+' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente) LIKE ?";

        try {
            Connection conexion = objetoConexion.establecerConexion();
            CallableStatement cs = conexion.prepareCall(consulta);

            // Configurar el parámetro antes de ejecutar la consulta
            cs.setString(1, "%" + paramNombre + "%");
            ResultSet rs = cs.executeQuery();

            // Verificar si se encontró algún resultado
            if (rs.next()) {
                codigoDNI = rs.getString("DNICliente");
            }

            // Cerrar recursos
            rs.close();
            cs.close();
            conexion.close();

        } catch (Exception e) {
            System.out.println("Error en ejecucion: " + e.toString());
        }

        return codigoDNI;
    }
    public void ModificarClientes(String paramDNI, String paramNombre, String paramApellidoPaterno, String paramApellidoMaterno,String paramTelefono,  String paramGenero,  String paramCorreoElectronico, String paramFechaContrata){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE cliente \n" +
                            "SET \n" +
                            "    cliente.nombreCliente = ?,\n" +
                            "    cliente.apellidoPaternoCliente = ?,\n" +
                            "    cliente.apellidoMaternoCliente = ?,\n" +
                            "    cliente.estadoCliente = ?,\n" +
                            "    cliente.generoCliente = ?,\n" +
                            "    cliente.telefonoCliente = ?,\n" +
                            "    cliente.correoElectronicoCliente = ?,\n" +
                            "    cliente.fechaIngresoCliente = CONVERT(DATE, ?, 103)  -- 103 indica el formato 'dd/mm/yyyy'\n" +                      
                            "WHERE cliente.DNICliente = ?";
        try{  
            
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaContrata = inputDateFormat.parse(paramFechaContrata);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaContrata2 = new java.sql.Date(fechaContrata.getTime());

            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,paramNombre);
            cs.setString(2,paramApellidoPaterno);
            cs.setString(3,paramApellidoMaterno);
            cs.setString(4,"Vigente");
            cs.setString(5,paramGenero);
            cs.setString(6,paramTelefono);
            cs.setString(7,paramCorreoElectronico);
            cs.setDate(8, fechaContrata2);
            cs.setInt(9,Integer.parseInt(paramDNI));
            cs.execute();
            String mensaje = "Los cambios se han realizado correctamente";
            new panelMensaje(null,true,mensaje).setVisible(true);
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarClientes(Integer paramDNI){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM cliente \n" +                   
                            "WHERE cliente.DNICliente = ?";
        try{  
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1,paramDNI);
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
    String consulta = "SELECT\n" +
                        "DNICliente,\n" +
                        "nombreCliente ,\n"+
                        "apellidoPaternoCliente,\n"+
                        "apellidoMaternoCliente,\n"+
                        "estadoCliente,\n" +
                        "generoCliente,\n" +
                        "telefonoCliente,\n" +
                        "correoElectronicoCliente,\n" +
                        "fechaIngresoCliente\n" +
                        "FROM cliente\n" +
                        "WHERE DNICliente = ?";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setInt(1, parametroCodigoCliente);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        clienteData.put("DNICliente", resultSet.getString("DNICliente"));
        clienteData.put("nombreCliente", resultSet.getString("nombreCliente"));
        clienteData.put("apellidoPaternoCliente", resultSet.getString("apellidoPaternoCliente"));
        clienteData.put("apellidoMaternoCliente", resultSet.getString("apellidoMaternoCliente"));
        clienteData.put("estadoCliente", resultSet.getString("estadoCliente"));
        clienteData.put("generoCliente", resultSet.getString("generoCliente"));
        clienteData.put("telefonoCliente", resultSet.getString("telefonoCliente"));
        clienteData.put("correoElectronicoCliente", resultSet.getString("correoElectronicoCliente"));
        clienteData.put("fechaIngresoCliente", resultSet.getString("fechaIngresoCliente"));
    }

    return clienteData;
    }
    public void buscarCliente2(JTextField paramBusqueda,JTable paramTablaClientes){
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        Object[] columnNames = {"DNI", "Nombre", "Estado", "Genero", "Telefono", "Correo Electronico","Fecha Contrata", "",""};
        paramTablaClientes.setDefaultRenderer(Object.class,new Render());
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
                "DNICliente,\n" +
                "nombreCliente + ' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente AS nombreCompleto,\n" +
                "estadoCliente,\n" +
                "generoCliente,\n" +
                "telefonoCliente,\n" +
                "correoElectronicoCliente,\n" +
                "fechaIngresoCliente\n" +
                "FROM cliente\n"+
                "WHERE nombreCliente LIKE '%' + '" + parametroString + "' + '%'";
        
        String [] datos = new String[7];
        
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
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7), botonDetalle, botonEliminar});
            }
            
            paramTablaClientes.setModel(modelo);
            tableStyles(paramTablaClientes);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void BuscarCliente(JTextField paramBusqueda,JTable paramTablaClientes) throws SQLException{
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        Object[] columnNames = {"DNI", "Nombre", "Estado", "Genero", "Telefono", "Correo Electronico","Fecha Contrata"};
        paramTablaClientes.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }   
        };
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
        String sql="";
         sql = 
                        "SELECT \n" +
                        "DNICliente,\n" +
                        "nombreCliente + ' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente AS nombreCompleto,\n" +
                        "estadoCliente,\n" +
                        "generoCliente,\n" +
                        "telefonoCliente,\n" +
                        "correoElectronicoCliente,\n" +
                        "fechaIngresoCliente\n" +
                        "FROM cliente \n" +
                        "WHERE nombreCliente LIKE '%' + '" + parametroString + "' + '%'";
        
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
                datos[6] = rs.getString(7);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),botonDetalle,botonEliminar});
            }
            
            paramTablaClientes.setModel(modelo);
            tableStyles(paramTablaClientes);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
        
    }
    public void BuscarCliente2(JTextField paramBusqueda,JTable paramTablaClientes) throws SQLException{
        CConexion objetoConexion = new CConexion();
        String parametroString = paramBusqueda.getText();
        Object[] columnNames = {"DNI", "Nombre", "Estado", "Genero", "Telefono", "Correo Electronico","Fecha Contrata"};
        paramTablaClientes.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }   
        };
       
        String sql="";
         sql = 
                        "SELECT \n" +
                        "DNICliente,\n" +
                        "nombreCliente + ' ' + apellidoPaternoCliente + ' ' + apellidoMaternoCliente AS nombreCompleto,\n" +
                        "estadoCliente,\n" +
                        "generoCliente,\n" +
                        "telefonoCliente,\n" +
                        "correoElectronicoCliente,\n" +
                        "fechaIngresoCliente\n" +
                        "FROM cliente \n" +
                        "WHERE nombreCliente LIKE '%' + '" + parametroString + "' + '%'";
        
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
                datos[6] = rs.getString(7);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
            
            paramTablaClientes.setModel(modelo);
            tableStyles2(paramTablaClientes);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
        
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
