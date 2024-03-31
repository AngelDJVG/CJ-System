/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Comanda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import view.FrmAdministrarComandas;

/**
 *
 * @author Zaurus
 */
public class BotonListener extends MouseAdapter {
    private final JTable table;
    private final Control control = new Control();
    private final FrmAdministrarComandas frm;
    public BotonListener(JTable table ,FrmAdministrarComandas frm) {
        this.table = table;
        this.frm = frm;
    }

    public void mouseClicked(MouseEvent e) {
        int column = table.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / table.getRowHeight();

        if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
            Object value = table.getValueAt(row, column);
            if (value instanceof String && value.equals("/iconos/ic_cerrar.png")) {
                
                Comanda comanda = control.consultarComanda((Long) table.getValueAt(row, 0));
                control.cerrarComanda(comanda);
                
                frm.cargarPantalla(control.obtenerTablaComandas(frm.getTipoComanda()));
                JOptionPane.showMessageDialog(null, "La comanda se cerro con exito: " + comanda.getId());
            }
            if (value instanceof String && value.equals("/iconos/ic_editar_blanco.png")) {
                
                Comanda comanda = control.consultarComanda((Long) table.getValueAt(row, 0));
                
                Mediador.abrirFrmEditarComanda(frm.getTipoComanda(), comanda);
            }
            
        }
    }
}
