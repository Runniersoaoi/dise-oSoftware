/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pooProyect;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class GlobalMouseListenerProducto extends MouseAdapter {
    private JTextField element; // Declarar una variable para mantener referencia a tu elemento

    public GlobalMouseListenerProducto(JTextField element) {
        this.element = element;
    }

    
    public void mouseClicked(MouseEvent e) {
        // This code will be executed when any click event occurs in your application.
        // You can check if the click is outside a specific element and take appropriate action.
        if (!isClickInsideYourElement(e)) {
            // Code to handle a click outside the element
            
            if(element.getText().equals("")){
                element.setText("Ingresa producto");
                element.setForeground(Color.GRAY);
                element.setFocusable(false); // Desactivar el foco
                element.setFocusable(true);
            }
            
            
        }
    }
    private boolean isClickInsideYourElement(MouseEvent e) {
        // Implement a method to determine if the click is inside your specific element.
        // You might check bounds or coordinates of your element here.
        return false; // Return true if the click is inside your element, false otherwise.
    }
}
