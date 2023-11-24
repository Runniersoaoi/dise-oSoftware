/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliar;

import com.mycompany.pooproyect.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
/**
 *
 
@author Admin*/
public class CConexion {
    Connection conectar = null;

    String usuario = "usersql";
    String contrasenia = "root";
    String bd ="GimnasioAlpha";
    String ip ="localhost";
    String puerto ="1433"; 

    String cadena="jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";integratedSecurity=false; trustServerCertificate=true";

    public Connection establecerConexion(){
        try{
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
            System.out.println("Se conecto correctamente a la base de datos");
        }catch(Exception e){
            System.out.println("No se conecto xd" +e.toString());
        }

        return conectar;
    }
}