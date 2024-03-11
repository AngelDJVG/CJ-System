/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Angel
 */
public class BotonComandaProducto extends JButton {

    public BotonComandaProducto(String direccionImagen) {
        super();

        if (direccionImagen != null && !direccionImagen.isEmpty()) {
            ImageIcon icono = new ImageIcon(getClass().getResource(direccionImagen));
            Image imagen = icono.getImage();
            Image imagenEscalada = imagen.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(imagenEscalada));
        }

        valoresDefecto();
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
