/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Zaurus
 */
public class BotonRender extends JButton implements TableCellRenderer{

    public BotonRender(String direccionImagen) {
        setOpaque(true);
        if (direccionImagen != null && !direccionImagen.isEmpty()) {
            ImageIcon icono = new ImageIcon(getClass().getResource(direccionImagen));
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(imagenEscalada));
        }

        valoresDefecto();
    }

   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        setIcon(getIcon(value.toString()));
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(Color.decode("#CB5F1D"));
        }
        return this;
    }

    private ImageIcon getIcon(String fileName) {
        URL url = getClass().getResource(fileName);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }
    private void valoresDefecto() {
        setPreferredSize(new Dimension(35, 35)); 
        setBackground(new Color(100, 200, 100)); 
        setForeground(Color.WHITE); 
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setContentAreaFilled(false); 
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
}
