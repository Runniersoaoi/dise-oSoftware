/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auxiliar;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alber
 */
public class PaddedCellRenderer extends DefaultTableCellRenderer {
        private int paddingX;
        private int paddingY;
        private int numColumnsToPad;  // Número de columnas a las que se aplicará el padding

        public PaddedCellRenderer(int paddingX, int paddingY, int numColumnsToPad) {
            this.paddingX = paddingX;
            this.paddingY = paddingY;
            this.numColumnsToPad = numColumnsToPad;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof JButton) {
                return (JButton) value;
            } else {
                

                // Verificar si la columna actual debe tener el padding
                if (column <= numColumnsToPad) {
                    // Configurar el borde con el padding solo para las columnas deseadas
                    label.setBorder(new EmptyBorder(paddingY, paddingX, paddingY, paddingX));
                } else {
                    // Si no, asegurarse de que no haya borde
                    label.setBorder(new EmptyBorder(0, 0, 0, 0));
                }
            }
            

            return label;
        }
    }