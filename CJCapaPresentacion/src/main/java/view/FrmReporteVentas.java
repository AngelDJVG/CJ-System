/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.Control;
import control.Mediador;
import dto.ComandaDTO;
import enums.TiposComanda;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Angel
 */
public class FrmReporteVentas extends javax.swing.JFrame {

    private Control controlAplicacion;
    private ComandaDTO comandaDTO;

    public FrmReporteVentas(Control control) {
        initComponents();
        this.controlAplicacion = control;
        comandaDTO = new ComandaDTO();
        comandaDTO.setTipoComanda(TiposComanda.TODAS);
        controlAplicacion.cargarTablaComandas(comandaDTO, tblComandas);
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
        pnlFiltros = new javax.swing.JPanel();
        pnlTipo = new javax.swing.JPanel();
        lblTipo = new javax.swing.JLabel();
        cbxTipoComanda = new javax.swing.JComboBox<>();
        pnlFechas = new javax.swing.JPanel();
        lblDesde = new javax.swing.JLabel();
        dpDesde = new com.github.lgooddatepicker.components.DatePicker();
        lblHasta = new javax.swing.JLabel();
        dpHasta = new com.github.lgooddatepicker.components.DatePicker();
        btnFiltrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComandas = new javax.swing.JTable();
        pnlOperaciones = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnGenerarPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

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
        lblTitulo.setText("Reporte de ventas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 298, 50, 319);
        pnlTitulo.add(lblTitulo, gridBagConstraints);

        pnlFondo.add(pnlTitulo);

        pnlOpciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlOpciones.setMaximumSize(new java.awt.Dimension(710, 340));
        pnlOpciones.setMinimumSize(new java.awt.Dimension(710, 340));
        pnlOpciones.setPreferredSize(new java.awt.Dimension(710, 340));

        pnlFiltros.setBackground(new java.awt.Color(255, 255, 255));
        pnlFiltros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlFiltros.setMaximumSize(new java.awt.Dimension(710, 100));
        pnlFiltros.setMinimumSize(new java.awt.Dimension(710, 100));
        pnlFiltros.setPreferredSize(new java.awt.Dimension(710, 100));

        pnlTipo.setMaximumSize(new java.awt.Dimension(170, 60));
        pnlTipo.setMinimumSize(new java.awt.Dimension(170, 60));
        pnlTipo.setPreferredSize(new java.awt.Dimension(170, 60));

        lblTipo.setText("Tipo de comanda");
        pnlTipo.add(lblTipo);

        cbxTipoComanda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pedidos", "Mesas", "Express", "Todas" }));
        cbxTipoComanda.setSelectedIndex(3);
        cbxTipoComanda.setMaximumSize(new java.awt.Dimension(150, 25));
        cbxTipoComanda.setMinimumSize(new java.awt.Dimension(150, 25));
        cbxTipoComanda.setPreferredSize(new java.awt.Dimension(150, 25));
        cbxTipoComanda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoComandaItemStateChanged(evt);
            }
        });
        pnlTipo.add(cbxTipoComanda);

        pnlFiltros.add(pnlTipo);

        pnlFechas.setMaximumSize(new java.awt.Dimension(280, 90));
        pnlFechas.setMinimumSize(new java.awt.Dimension(280, 90));
        pnlFechas.setPreferredSize(new java.awt.Dimension(280, 60));
        pnlFechas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 6));

        lblDesde.setText("Desde");
        lblDesde.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnlFechas.add(lblDesde);

        dpDesde.setMaximumSize(new java.awt.Dimension(190, 20));
        dpDesde.setMinimumSize(new java.awt.Dimension(190, 20));
        dpDesde.setPreferredSize(new java.awt.Dimension(190, 20));
        pnlFechas.add(dpDesde);

        lblHasta.setText("Hasta");
        lblHasta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pnlFechas.add(lblHasta);

        dpHasta.setMaximumSize(new java.awt.Dimension(190, 20));
        dpHasta.setMinimumSize(new java.awt.Dimension(190, 20));
        dpHasta.setPreferredSize(new java.awt.Dimension(190, 20));
        pnlFechas.add(dpHasta);

        pnlFiltros.add(pnlFechas);

        btnFiltrar.setText("Buscar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        pnlFiltros.add(btnFiltrar);

        pnlOpciones.add(pnlFiltros);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(520, 220));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(520, 220));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(520, 220));

        tblComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblComandas.setFocusable(false);
        tblComandas.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        tblComandas.setRowHeight(30);
        jScrollPane1.setViewportView(tblComandas);
        if (tblComandas.getColumnModel().getColumnCount() > 0) {
            tblComandas.getColumnModel().getColumn(0).setResizable(false);
            tblComandas.getColumnModel().getColumn(1).setResizable(false);
            tblComandas.getColumnModel().getColumn(2).setResizable(false);
        }

        pnlOpciones.add(jScrollPane1);

        pnlFondo.add(pnlOpciones);

        pnlOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        pnlOperaciones.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 0, 0, 0, new java.awt.Color(203, 95, 29)));
        pnlOperaciones.setForeground(new java.awt.Color(255, 255, 255));
        pnlOperaciones.setMaximumSize(new java.awt.Dimension(710, 100));
        pnlOperaciones.setMinimumSize(new java.awt.Dimension(710, 100));
        pnlOperaciones.setPreferredSize(new java.awt.Dimension(710, 100));
        pnlOperaciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 80, 15));

        btnRegresar.setText("Regresar");
        btnRegresar.setBackground(new java.awt.Color(203, 95, 29));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
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

        btnGenerarPdf.setText("Mostrar PDF");
        btnGenerarPdf.setBackground(new java.awt.Color(203, 95, 29));
        btnGenerarPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarPdf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGenerarPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPdf.setMaximumSize(new java.awt.Dimension(170, 60));
        btnGenerarPdf.setMinimumSize(new java.awt.Dimension(170, 60));
        btnGenerarPdf.setPreferredSize(new java.awt.Dimension(170, 60));
        btnGenerarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPdfActionPerformed(evt);
            }
        });
        pnlOperaciones.add(btnGenerarPdf);

        pnlFondo.add(pnlOperaciones);

        getContentPane().add(pnlFondo);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.setVisible(false);
        Mediador.abrirFrmPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPdfActionPerformed
        controlAplicacion.mostrarReporte(comandaDTO);
    }//GEN-LAST:event_btnGenerarPdfActionPerformed

    private void cbxTipoComandaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoComandaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String seleccion = (String) cbxTipoComanda.getSelectedItem();
            int tipoComanda = obtenerTipoComandaCbx(seleccion);
            comandaDTO.setTipoComanda(tipoComanda);
            cargarComandas();
        }
    }//GEN-LAST:event_cbxTipoComandaItemStateChanged

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        if (extraerFechaDesde() != null) {
            comandaDTO.setDesde(extraerFechaDesde());
        }
        if (extraerFechaHasta() != null) {
            comandaDTO.setHasta(extraerFechaHasta());
        }

        cargarComandas();
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private Calendar extraerFechaDesde() {
        if (dpDesde == null || dpDesde.getText().trim().equals("")) {
            comandaDTO.setDesde(null);

            return null;
        }
        LocalDate localDate = dpDesde.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        return calendar;
    }

    private Calendar extraerFechaHasta() {
        if (dpHasta == null || dpHasta.getText().trim().equals("")) {
                comandaDTO.setHasta(null);
            
            return null;
        }
        LocalDate localDate = dpHasta.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        return calendar;
    }

    private void cargarComandas() {
        controlAplicacion.cargarTablaComandas(comandaDTO, tblComandas);
    }

    private int obtenerTipoComandaCbx(String seleccion) {
        int tipoComanda;

        tipoComanda = switch (seleccion) {
            case "Todas" ->
                TiposComanda.TODAS;
            case "Express" ->
                TiposComanda.EXPRESS;
            case "Pedidos" ->
                TiposComanda.PEDIDO;
            case "Mesas" ->
                TiposComanda.MESA;
            default ->
                TiposComanda.TODAS;
        };

        return tipoComanda;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGenerarPdf;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbxTipoComanda;
    private com.github.lgooddatepicker.components.DatePicker dpDesde;
    private com.github.lgooddatepicker.components.DatePicker dpHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFechas;
    private javax.swing.JPanel pnlFiltros;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlOperaciones;
    private javax.swing.JPanel pnlTipo;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JTable tblComandas;
    // End of variables declaration//GEN-END:variables
}
