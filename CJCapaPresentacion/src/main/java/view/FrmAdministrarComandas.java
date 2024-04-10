/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import componentes.BotonComandaProducto;
import componentes.BotonEditor;
import componentes.BotonRender;
import control.BotonListener;
import control.Mediador;
import entidades.Comanda;
import entidades.ComandaPedido;
import enums.TiposComanda;
import static enums.TiposComanda.CERRADA;
import static enums.TiposComanda.ELIMINADA;
import static enums.TiposComanda.EXPRESS;
import static enums.TiposComanda.MESA;
import static enums.TiposComanda.PEDIDO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Ángel Valenzuela
 */
public class FrmAdministrarComandas extends javax.swing.JFrame {

    /**
     * Creates new form FrmComandas
     */
    private int tipoComanda;
    public FrmAdministrarComandas(DefaultTableModel model,int tipoComanda) {
        // Crear un modelo de tabla
        this.tipoComanda = tipoComanda;
        initComponents();
        
        cargarPantalla( model);
        if(tipoComanda != CERRADA)
        {
            btnEliminadas.setVisible(false);
        }
        
        
    }

    public int getTipoComanda() {
        return tipoComanda;
    }
    public void cargarPantalla(DefaultTableModel model)
    {
        tblComandas.setModel(model);
        switch(tipoComanda)
        {
            case PEDIDO:
                tblComandas.setRowHeight(40);
                tblComandas.setBackground(Color.decode("#CB5F1D"));
                lblTitulo.setText("Comandas - Pedidos");
                tblComandas.getColumnModel().getColumn(2).setCellRenderer(new BotonRender(""));
                tblComandas.getColumnModel().getColumn(3).setCellRenderer(new BotonRender(""));
                tblComandas.getColumnModel().getColumn(4).setCellRenderer(new BotonRender(""));
                tblComandas.addMouseListener(new BotonListener(tblComandas,this));
            break;
            case MESA:
                lblTitulo.setText("Comandas - Mesas");
                tblComandas.setRowHeight(40);
                tblComandas.setBackground(Color.decode("#CB5F1D"));
                tblComandas.getColumnModel().getColumn(2).setCellRenderer(new BotonRender(""));
                tblComandas.getColumnModel().getColumn(3).setCellRenderer(new BotonRender(""));
                tblComandas.getColumnModel().getColumn(4).setCellRenderer(new BotonRender("/iconos/ic_informacion.png"));
                tblComandas.addMouseListener(new BotonListener(tblComandas,this));
            break;
            case CERRADA:
                
                lblTitulo.setText("Comandas - Cerradas");
                tblComandas.setRowHeight(40);
                tblComandas.setBackground(Color.decode("#CB5F1D"));
                tblComandas.getColumnModel().getColumn(1).setCellRenderer(new BotonRender("/iconos/ic_informacion.png"));
                tblComandas.getColumnModel().getColumn(2).setCellRenderer(new BotonRender("/iconos/ic_informacion.png"));
                tblComandas.addMouseListener(new BotonListener(tblComandas,this));
                
            break;
            case ELIMINADA:
                
                btnEliminadas.setEnabled(false);
                lblTitulo.setText("Comandas - Eliminadas");
                tblComandas.setRowHeight(40);
                tblComandas.setBackground(Color.decode("#CB5F1D"));
            break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlFondo = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlOpciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComandas = new javax.swing.JTable();
        pnlOperaciones = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 607));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 3));
        pnlFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        pnlFondo.setMinimumSize(new java.awt.Dimension(800, 600));
        pnlFondo.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlFondo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        pnlTitulo.setBackground(new java.awt.Color(203, 95, 29));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        pnlTitulo.setMaximumSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setPreferredSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Comandas-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 298, 50, 319);
        pnlTitulo.add(lblTitulo, gridBagConstraints);

        pnlFondo.add(pnlTitulo);

        pnlOpciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlOpciones.setMaximumSize(new java.awt.Dimension(710, 300));
        pnlOpciones.setMinimumSize(new java.awt.Dimension(710, 300));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(710, 300));
        pnlOpciones.setLayout(new java.awt.GridLayout(1, 0));

        tblComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComandas.setFocusable(false);
        jScrollPane1.setViewportView(tblComandas);
        if (tblComandas.getColumnModel().getColumnCount() > 0) {
            tblComandas.getColumnModel().getColumn(0).setResizable(false);
            tblComandas.getColumnModel().getColumn(3).setResizable(false);
        }

        pnlOpciones.add(jScrollPane1);

        pnlFondo.add(pnlOpciones);

        pnlOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlOperaciones.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(203, 95, 29)));
        pnlOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        pnlOperaciones.setPreferredSize(new java.awt.Dimension(710, 130));
        pnlOperaciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 80, 50));

        btnRegresar.setBackground(new java.awt.Color(203, 95, 29));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setMaximumSize(new java.awt.Dimension(170, 60));
        btnRegresar.setMinimumSize(new java.awt.Dimension(170, 60));
        btnRegresar.setPreferredSize(new java.awt.Dimension(170, 60));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlOperaciones.add(btnRegresar);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_comandas/img_cerdito.png"))); // NOI18N
        pnlOperaciones.add(jLabel1);

        btnEliminadas.setBackground(new java.awt.Color(203, 95, 29));
        btnEliminadas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminadas.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminadas.setText("Eliminadas");
        btnEliminadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminadas.setMaximumSize(new java.awt.Dimension(170, 60));
        btnEliminadas.setMinimumSize(new java.awt.Dimension(170, 60));
        btnEliminadas.setPreferredSize(new java.awt.Dimension(170, 60));
        btnEliminadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminadasActionPerformed(evt);
            }
        });
        pnlOperaciones.add(btnEliminadas);

        pnlFondo.add(pnlOperaciones);

        getContentPane().add(pnlFondo);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        Mediador.abrirFrmComandas();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminadasActionPerformed
        this.dispose();
        Mediador.abrirFrmAdministrarComanda(ELIMINADA);
    }//GEN-LAST:event_btnEliminadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminadas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlOperaciones;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTable tblComandas;
    // End of variables declaration//GEN-END:variables
}
