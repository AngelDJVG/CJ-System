package componentes;

import control.Control;
import control.Mediador;
import entidades.Producto;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends DefaultCellEditor implements TableCellEditor, ActionListener {
    private JButton button;
    private String label;
    private boolean isClicked;
    private JTable table;
    private int row, column;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        this.row = row;
        this.column = column;

        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(UIManager.getColor("Button.background"));
        }

        if (value instanceof javax.swing.Icon) {
            button.setIcon((javax.swing.Icon) value);
            button.setText("");
        } else {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
        }

        isClicked = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isClicked) {
            if (column == 3) { 
                Producto producto = Mediador.control.consultarProducto((String) table.getValueAt(row, 1));
                System.out.println("Editar producto: " + producto.getId());
                Mediador.control.editarProducto(producto);
            } else if (column == 4) {
                Producto producto = Mediador.control.consultarProducto((String) table.getValueAt(row, 1));
                System.out.println("Eliminar producto: " + producto.getId());
                Mediador.control.eliminarProducto(producto);
            }
        }
        isClicked = false;
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
        Mediador.control.cargarTablaProductos();
    }
}
