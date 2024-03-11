/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.Control;
import entidades.Comanda;
import entidades.ComandaExpress;
import entidades.ComandaMesa;
import entidades.ComandaPedido;
import entidades.ComandaProducto;
import entidades.Mesa;
import enums.TiposComanda;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Ángel Valenzuela
 */
public class FrmRegistroComanda extends javax.swing.JFrame {

    private Control controlAplicacion;

    private List<ComandaProducto> listaProductos;
    /**
     * Creates new form FrmRegistroComanda
     */
    public FrmRegistroComanda() {
        initComponents();
        controlAplicacion = new Control();
        controlAplicacion.establecerVistaTotal(lblDinero);
        controlAplicacion.cargarComandasProductos(pnlPedidos);
        actualizarPanelFormulario(0);
        System.out.println(pnlPedidos.countComponents());
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
        pnlCentralComanda = new javax.swing.JPanel();
        pnlFormulario = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        pnlFormularioComanda = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnlDetalles = new javax.swing.JPanel();
        pnlFondoAgregarProducto = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        lblDinero = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlPedidos = new javax.swing.JPanel();
        lblDato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 3));
        pnlFondo.setMaximumSize(new java.awt.Dimension(800, 600));
        pnlFondo.setMinimumSize(new java.awt.Dimension(800, 600));
        pnlFondo.setPreferredSize(new java.awt.Dimension(800, 600));
        pnlFondo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        pnlTitulo.setBackground(new java.awt.Color(203, 95, 29));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        pnlTitulo.setMaximumSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setPreferredSize(new java.awt.Dimension(710, 100));
        pnlTitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Registro de comanda - Pedido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 298, 43, 319);
        pnlTitulo.add(lblTitulo, gridBagConstraints);

        pnlFondo.add(pnlTitulo);

        pnlCentralComanda.setMaximumSize(new java.awt.Dimension(710, 400));
        pnlCentralComanda.setMinimumSize(new java.awt.Dimension(710, 400));
        pnlCentralComanda.setPreferredSize(new java.awt.Dimension(710, 400));
        pnlCentralComanda.setLayout(new java.awt.GridLayout(1, 0));

        pnlFormulario.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 3));
        pnlFormulario.setLayout(new java.awt.GridBagLayout());

        lblTipo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(203, 95, 29));
        lblTipo.setText("Tipo de Comanda");
        lblTipo.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlFormulario.add(lblTipo, gridBagConstraints);

        cbxTipo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbxTipo.setForeground(new java.awt.Color(203, 95, 29));
        cbxTipo.setMaximumRowCount(3);
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedido", "Mesa", "Express" }));
        cbxTipo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 2, true));
        cbxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxTipo.setMaximumSize(new java.awt.Dimension(250, 50));
        cbxTipo.setMinimumSize(new java.awt.Dimension(250, 50));
        cbxTipo.setPreferredSize(new java.awt.Dimension(250, 50));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlFormulario.add(cbxTipo, gridBagConstraints);

        pnlFormularioComanda.setBackground(new java.awt.Color(255, 255, 255));
        pnlFormularioComanda.setMaximumSize(new java.awt.Dimension(260, 210));
        pnlFormularioComanda.setMinimumSize(new java.awt.Dimension(260, 210));
        pnlFormularioComanda.setPreferredSize(new java.awt.Dimension(260, 210));
        java.awt.GridBagLayout pnlFormularioComandaLayout = new java.awt.GridBagLayout();
        pnlFormularioComandaLayout.columnWidths = new int[] {0};
        pnlFormularioComandaLayout.rowHeights = new int[] {0};
        pnlFormularioComanda.setLayout(pnlFormularioComandaLayout);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 0, 0);
        pnlFormulario.add(pnlFormularioComanda, gridBagConstraints);

        btnRegistrar.setBackground(new java.awt.Color(102, 204, 0));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlFormulario.add(btnRegistrar, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(203, 95, 29));
        jSeparator1.setForeground(new java.awt.Color(203, 95, 29));
        jSeparator1.setMaximumSize(new java.awt.Dimension(300, 3));
        jSeparator1.setMinimumSize(new java.awt.Dimension(300, 3));
        jSeparator1.setPreferredSize(new java.awt.Dimension(300, 3));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 3, 0);
        pnlFormulario.add(jSeparator1, gridBagConstraints);

        pnlCentralComanda.add(pnlFormulario);

        pnlDetalles.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 3));
        pnlDetalles.setLayout(new javax.swing.BoxLayout(pnlDetalles, javax.swing.BoxLayout.Y_AXIS));

        pnlFondoAgregarProducto.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondoAgregarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 2));
        pnlFondoAgregarProducto.setMaximumSize(new java.awt.Dimension(355, 100));
        pnlFondoAgregarProducto.setMinimumSize(new java.awt.Dimension(355, 100));
        pnlFondoAgregarProducto.setPreferredSize(new java.awt.Dimension(355, 100));
        pnlFondoAgregarProducto.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        btnAgregarProducto.setBackground(new java.awt.Color(51, 153, 0));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setMaximumSize(new java.awt.Dimension(170, 50));
        btnAgregarProducto.setMinimumSize(new java.awt.Dimension(170, 50));
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(170, 50));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        pnlFondoAgregarProducto.add(btnAgregarProducto);

        lblDinero.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDinero.setForeground(new java.awt.Color(102, 204, 0));
        lblDinero.setText("Total: $0.00");
        pnlFondoAgregarProducto.add(lblDinero);

        pnlDetalles.add(pnlFondoAgregarProducto);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 2));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(355, 300));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(355, 300));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(355, 300));
        jScrollPane2.setViewportView(pnlPedidos);

        pnlPedidos.setBackground(new java.awt.Color(255, 255, 255));
        pnlPedidos.setMaximumSize(new java.awt.Dimension(320, 300));
        pnlPedidos.setMinimumSize(new java.awt.Dimension(320, 300));
        pnlPedidos.setPreferredSize(new java.awt.Dimension(320, 300));
        pnlPedidos.setLayout(new java.awt.GridLayout(1, 0));

        lblDato.setText("Sin productos");
        pnlPedidos.add(lblDato);

        jScrollPane2.setViewportView(pnlPedidos);

        pnlDetalles.add(jScrollPane2);

        pnlCentralComanda.add(pnlDetalles);

        pnlFondo.add(pnlCentralComanda);

        getContentPane().add(pnlFondo);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        int selectedIndex = cbxTipo.getSelectedIndex();
        actualizarPanelFormulario(selectedIndex);
        
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        JDLElegirProducto elegirProducto = new JDLElegirProducto(this, true, controlAplicacion);
        elegirProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        controlAplicacion.registrarComanda(cbxTipo.getSelectedIndex());
    }//GEN-LAST:event_btnRegistrarActionPerformed

    public void actualizarPanelFormulario(int tipoComanda) {
       
        pnlFormularioComanda.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        switch (tipoComanda) {
            case TiposComanda.PEDIDO -> {
                lblTitulo.setText("Registro de comanda - Pedido");
                JLabel lblNombreCliente = new JLabel("Nombre del cliente");
                pnlFormularioComanda.add(lblNombreCliente, gbc);

                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(5, 5, 5, 5);

                JTextField txtNombreCliente = new JTextField();
                txtNombreCliente.setPreferredSize(new Dimension(250, 50));
                txtNombreCliente.setMinimumSize(new Dimension(250, 50));
                txtNombreCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 2, true));
                pnlFormularioComanda.add(txtNombreCliente, gbc);

                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(5, 5, 5, 5);

                JLabel lblDireccion = new JLabel("Dirección");
                pnlFormularioComanda.add(lblDireccion, gbc);
                
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.insets = new Insets(5, 5, 5, 5);

                JTextField txtDireccion = new JTextField();
                txtDireccion.setPreferredSize(new Dimension(250, 50));
                txtDireccion.setMinimumSize(new Dimension(250, 50));
                txtDireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 2, true));
                pnlFormularioComanda.add(txtDireccion, gbc);

                controlAplicacion.asignarVistaDireccion(txtDireccion);
                
                lblNombreCliente.setFont(new java.awt.Font("Segoe UI", 1, 20));
                lblNombreCliente.setForeground(new java.awt.Color(203, 95, 29));
                lblDireccion.setFont(new java.awt.Font("Segoe UI", 1, 20));
                lblDireccion.setForeground(new java.awt.Color(203, 95, 29));

            }
            case TiposComanda.MESA -> {
                lblTitulo.setText("Registro de comanda - Mesa");
                JLabel lblMesa = new JLabel("Número de mesa");
                pnlFormularioComanda.add(lblMesa, gbc);

                gbc.gridy++;

                JComboBox<Mesa> cbxMesa = new JComboBox<>();
                pnlFormularioComanda.add(cbxMesa, gbc);
                cbxMesa.setBackground(new java.awt.Color(255, 255, 255));
                cbxMesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                cbxMesa.setForeground(new java.awt.Color(203, 95, 29));
                cbxMesa.setMaximumRowCount(4);

                controlAplicacion.cargarMesas(cbxMesa);

                cbxMesa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 2, true));
                cbxMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                cbxMesa.setMaximumSize(new java.awt.Dimension(250, 50));
                cbxMesa.setMinimumSize(new java.awt.Dimension(250, 50));
                cbxMesa.setPreferredSize(new java.awt.Dimension(250, 50));

                lblMesa.setFont(new java.awt.Font("Segoe UI", 1, 20));
                lblMesa.setForeground(new java.awt.Color(203, 95, 29));
                pnlFormularioComanda.setAlignmentY(Component.TOP_ALIGNMENT);
            }
            case TiposComanda.EXPRESS -> {
                lblTitulo.setText("Registro de comanda - Express");
            }
            default -> {
            }
        }

        pnlFormularioComanda.revalidate();
        pnlFormularioComanda.repaint();
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlCentralComanda;
    private javax.swing.JPanel pnlDetalles;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlFondoAgregarProducto;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlFormularioComanda;
    private javax.swing.JPanel pnlPedidos;
    private javax.swing.JPanel pnlTitulo;
    // End of variables declaration//GEN-END:variables
}
