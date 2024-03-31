/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Zaurus
 */
public class BotonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private Action action;

    public BotonEditor(Action action) {
        super(new JTextField());
        this.action = action;
        button = new JButton();
        button.addActionListener(e -> fireEditingStopped());
        button.setBackground(Color.decode("#CB5F1D"));
        button.setForeground(Color.WHITE);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        setLabel(value.toString());
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            // Realiza tu acción aquí
            action.actionPerformed(new ActionEvent(button, ActionEvent.ACTION_PERFORMED, ""));
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    private void setLabel(String fileName) {
        String resourcePath = "/iconos/" + fileName; // Ruta de recursos relativa
        // Carga la imagen desde el recurso
        ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
        if (icon != null) {
            button.setIcon(icon);
        } else {
            // Maneja el caso en el que no se puede cargar la imagen
            button.setText(fileName); // Establece el nombre del archivo como texto del botón
        }
        label = fileName;
    }
}
