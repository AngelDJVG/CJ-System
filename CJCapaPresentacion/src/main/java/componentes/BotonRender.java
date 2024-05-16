package componentes;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BotonRender extends JButton implements TableCellRenderer {
    public BotonRender() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        if (value instanceof javax.swing.Icon) {
            setIcon((javax.swing.Icon) value);
            setText("");
        } else {
            setText((value == null) ? "" : value.toString());
        }
        return this;
    }
}
