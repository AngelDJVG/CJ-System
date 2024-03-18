/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import control.Control;
import control.Mediador;
import entidades.ComandaProducto;
import entidades.Producto;
import entidades.TipoComida;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Ángel Valenzuela
 */
public class JDLElegirProducto extends javax.swing.JDialog {

    private Control controlAplicacion;
    private TipoComida tipoProductoActual = TipoComida.COMIDA;

    /**
     * Creates new form JDLElegirProducto
     */
    public JDLElegirProducto(java.awt.Frame parent, boolean modal, Control controlAplicacion) {
        super(parent, modal);
        initComponents();
        this.controlAplicacion = controlAplicacion;
        controlAplicacion.cargarProductos(tblProductos, tipoProductoActual);
        configuracionTabla();
        ajustarLabels();
        spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        configuracionSpinner(spnCantidad);
        txaDetalles = new JTextArea();
        mostrarTextField();
    }

    public JDLElegirProducto(java.awt.Frame parent, boolean modal, Control controlAplicacion, ComandaProducto comandaProducto) {
        super(parent, modal);
        initComponents();
        this.btnAgregar.setText("Guardar");
        this.controlAplicacion = controlAplicacion;
        spnCantidad = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        txaDetalles = new JTextArea();
        configuracionSpinner(spnCantidad);
        controlAplicacion.cargarProductos(tblProductos, comandaProducto.getProducto().getTipo());
        configuracionTabla();
        configurarInterfaz(comandaProducto);
        ajustarLabels();
    }

    private void configurarInterfaz(ComandaProducto comandaProducto) {
        Producto productoComanda = comandaProducto.getProducto();
        if (productoComanda.getTipo().equals(TipoComida.BEBIDA)) {
            ajustarInterfazModoBebidas();
            txtPrecio.setText(String.valueOf(comandaProducto.getPrecioVenta()));
            spnCantidad.setValue(comandaProducto.getCantidad());
        } else {
            ajustarInterfazModoComidas();
            mostrarTextField();
            txtPrecio.setText(String.valueOf(comandaProducto.getCantidad()));
            txaDetalles.setText(comandaProducto.getDetalles());
        }
        deshabilitarBotones();
    }

    private void deshabilitarBotones() {
        btnAlimentos.setEnabled(false);
        btnBebidas.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        btnAlimentos = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        pnlContenedorTabla = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        pnlContenedorDetalles = new javax.swing.JPanel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblCambiable = new javax.swing.JLabel();
        pnlContenedor = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 620));
        setMinimumSize(new java.awt.Dimension(500, 620));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(203, 95, 29), 3));
        pnlFondo.setMaximumSize(new java.awt.Dimension(500, 620));
        pnlFondo.setMinimumSize(new java.awt.Dimension(500, 620));
        pnlFondo.setPreferredSize(new java.awt.Dimension(500, 620));

        pnlTitulo.setBackground(new java.awt.Color(203, 95, 29));
        pnlTitulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        pnlTitulo.setMaximumSize(new java.awt.Dimension(450, 100));
        pnlTitulo.setMinimumSize(new java.awt.Dimension(450, 100));
        pnlTitulo.setPreferredSize(new java.awt.Dimension(450, 100));
        pnlTitulo.setLayout(new java.awt.GridBagLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Seleccionar Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(41, 298, 43, 319);
        pnlTitulo.add(lblTitulo, gridBagConstraints);

        pnlFondo.add(pnlTitulo);

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(404, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(404, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(404, 300));

        btnAlimentos.setBackground(new java.awt.Color(203, 95, 29));
        btnAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlimentos.setForeground(new java.awt.Color(255, 255, 255));
        btnAlimentos.setText("Alimentos");
        btnAlimentos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 3, true));
        btnAlimentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlimentos.setMaximumSize(new java.awt.Dimension(100, 40));
        btnAlimentos.setMinimumSize(new java.awt.Dimension(100, 40));
        btnAlimentos.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAlimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlimentosActionPerformed(evt);
            }
        });

        btnBebidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBebidas.setText("Bebidas");
        btnBebidas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 95, 29), 3, true));
        btnBebidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBebidas.setMaximumSize(new java.awt.Dimension(100, 40));
        btnBebidas.setMinimumSize(new java.awt.Dimension(100, 40));
        btnBebidas.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });

        pnlContenedorTabla.setBackground(new java.awt.Color(255, 255, 255));
        pnlContenedorTabla.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlContenedorTabla.setPreferredSize(new java.awt.Dimension(390, 332));
        pnlContenedorTabla.setLayout(new javax.swing.BoxLayout(pnlContenedorTabla, javax.swing.BoxLayout.LINE_AXIS));

        tblProductos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblProductos.setMaximumSize(new java.awt.Dimension(200, 80));
        tblProductos.setMinimumSize(new java.awt.Dimension(200, 80));
        tblProductos.setPreferredSize(new java.awt.Dimension(200, 80));
        scroll.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(190);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(190);
        }

        pnlContenedorTabla.add(scroll);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContenedorTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContenedorTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlFondo.add(jPanel2);

        pnlContenedorDetalles.setBackground(new java.awt.Color(255, 153, 153));
        pnlContenedorDetalles.setMaximumSize(new java.awt.Dimension(404, 120));
        pnlContenedorDetalles.setMinimumSize(new java.awt.Dimension(404, 120));
        pnlContenedorDetalles.setPreferredSize(new java.awt.Dimension(404, 120));

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(203, 95, 29));
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrecio.setText("Precios");

        txtPrecio.setMaximumSize(new java.awt.Dimension(64, 22));

        lblCambiable.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCambiable.setForeground(new java.awt.Color(203, 95, 29));
        lblCambiable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCambiable.setText("Detalles");

        pnlContenedor.setMaximumSize(new java.awt.Dimension(50, 50));
        pnlContenedor.setMinimumSize(new java.awt.Dimension(50, 50));
        pnlContenedor.setPreferredSize(new java.awt.Dimension(50, 50));
        pnlContenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlContenedorDetallesLayout = new javax.swing.GroupLayout(pnlContenedorDetalles);
        pnlContenedorDetalles.setLayout(pnlContenedorDetallesLayout);
        pnlContenedorDetallesLayout.setHorizontalGroup(
            pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenedorDetallesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(lblCambiable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlContenedorDetallesLayout.setVerticalGroup(
            pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenedorDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCambiable)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlContenedorDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenedorDetallesLayout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlFondo.add(pnlContenedorDetalles);

        btnRegresar.setBackground(new java.awt.Color(203, 95, 29));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setMaximumSize(new java.awt.Dimension(100, 30));
        btnRegresar.setMinimumSize(new java.awt.Dimension(100, 30));
        btnRegresar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegresar);

        btnAgregar.setBackground(new java.awt.Color(0, 191, 99));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setMaximumSize(new java.awt.Dimension(100, 30));
        btnAgregar.setMinimumSize(new java.awt.Dimension(100, 30));
        btnAgregar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAgregar);

        getContentPane().add(pnlFondo);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void configuracionTabla() {
        ListSelectionModel selectionModel = tblProductos.getSelectionModel();
        selectionModel.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblProductos.getSelectedRow();
                if (selectedRow != -1) {
                    controlAplicacion.actualizarPrecioBebida(txtPrecio, tipoProductoActual, selectedRow);
                }
            }
        });
    }

    private void ajustarLabels() {
        if (this.tipoProductoActual.equals(TipoComida.COMIDA)) {
            lblCambiable.setText("Detalles");
            lblPrecio.setText("Precio / KG");
        } else {
            lblCambiable.setText("Cantidad");
            lblPrecio.setText("Precio");
        }
    }

    private void mostrarSpinner() {

        pnlContenedor.removeAll();
        spnCantidad.setValue(1);
        pnlContenedor.add(spnCantidad, BorderLayout.CENTER);

        pnlContenedor.revalidate();
        pnlContenedor.repaint();
    }

    private void configuracionSpinner(JSpinner spinner) {
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spinner.getValue();
                if (value < 1) {
                    spinner.setValue(1);
                }
            }
        });
    }

    private void mostrarTextField() {

        pnlContenedor.removeAll();

        txaDetalles.setLineWrap(true);
        txaDetalles.setWrapStyleWord(true);
        txaDetalles.setText("");
        JScrollPane scrollPane = new JScrollPane(txaDetalles);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        pnlContenedor.add(scrollPane, BorderLayout.CENTER);

        pnlContenedor.revalidate();
        pnlContenedor.repaint();
    }

    private void ajustarInterfazModoBebidas() {
        this.tipoProductoActual = TipoComida.BEBIDA;
        controlAplicacion.cargarProductos(tblProductos, tipoProductoActual);
        mostrarSpinner();
        configurarTxtPrecio();
        ajustarLabels();
        btnAlimentos.setBackground(Color.WHITE);
        btnAlimentos.setForeground(Color.BLACK);
        btnBebidas.setBackground(new Color(0xCB5F1D));
        btnBebidas.setForeground(Color.WHITE);
    }

    private void ajustarInterfazModoComidas() {
        this.tipoProductoActual = TipoComida.COMIDA;
        controlAplicacion.cargarProductos(tblProductos, tipoProductoActual);
        mostrarTextField();
        ajustarLabels();
        configurarTxtPrecio();
        btnBebidas.setBackground(Color.WHITE);
        btnBebidas.setForeground(Color.BLACK);
        btnAlimentos.setBackground(new Color(0xCB5F1D));
        btnAlimentos.setForeground(Color.WHITE);
    }

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        ajustarInterfazModoBebidas();
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnAlimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlimentosActionPerformed
        ajustarInterfazModoComidas();
    }//GEN-LAST:event_btnAlimentosActionPerformed

    private void configurarTxtPrecio() {
        if (this.tipoProductoActual.equals(TipoComida.COMIDA)) {
            this.txtPrecio.setEnabled(true);
            this.txtPrecio.setText("");
        } else {
            this.txtPrecio.setEnabled(false);
            this.txtPrecio.setText("");
        }
    }

    private void agregarProductoComanda() {
        int selectedRow = tblProductos.getSelectedRow();
        if (selectedRow != -1) {
            if (!esVacioAlgunCampo()) {
                this.extraerDatos(selectedRow);
                this.dispose();
            }
        } else {
            Mediador.mostrarOptionPaneError(this, "Debe seleccionar un producto");
        }
    }

    private void editarProductoComanda() {
        if (!esVacioAlgunCampo()) {
            this.extraerDatos(-1);
            this.dispose();
        }
    }

    private void validarTipoAccion() {
        if (btnAgregar.getText().equals("Agregar")) {
            agregarProductoComanda();
        } else {
            editarProductoComanda();
        }
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        validarTipoAccion();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private boolean esEntero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esDecimal(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean esVacioAlgunCampo() {
        if (tipoProductoActual == TipoComida.COMIDA) {
            if (txtPrecio.getText() == null || txtPrecio.getText().isBlank()) {
                Mediador.mostrarOptionPaneError(this, "El precio del alimento no puede estar en blanco");
                return true;
            } else if (!esEntero(txtPrecio.getText())) {
                Mediador.mostrarOptionPaneError(this, "El precio del alimento debe ser entero");
                return true;
            }
        } else if (tipoProductoActual == TipoComida.BEBIDA) {
            boolean precioVacio = txtPrecio.getText() == null || txtPrecio.getText().isBlank();
            boolean cantidadMenorAUno = spnCantidad.getValue() == null || (int) spnCantidad.getValue() < 1;
            boolean noNumero = !esDecimal(txtPrecio.getText());
            if (precioVacio && cantidadMenorAUno) {
                Mediador.mostrarOptionPaneError(this, "Tanto el precio como la cantidad de la bebida no pueden estar en blanco o ser menor a 1");
                return true;
            }

            if (precioVacio) {
                Mediador.mostrarOptionPaneError(this, "El precio de la bebida no puede estar en blanco");
                return true;
            } else if (noNumero) {
                Mediador.mostrarOptionPaneError(this, "El precio de la bebida debe ser un número válido");
                return true;
            }

            if (cantidadMenorAUno) {
                Mediador.mostrarOptionPaneError(this, "La cantidad de la bebida no puede ser menor a 1");
                return true;
            }
        }

        return false;
    }

    private JSpinner spnCantidad;
    private JTextArea txaDetalles;

    private void extraerDatos(int selectedRow) {
        if (tipoProductoActual.equals(TipoComida.BEBIDA)) {
            Integer cantidad = (int) spnCantidad.getValue();
            if (btnAgregar.getText().equals("Agregar")) {
                controlAplicacion.agregarBebidaComanda(controlAplicacion.obtenerProductoFila(selectedRow), cantidad);
            } else {
                controlAplicacion.editarBebidaComanda(cantidad);
            }
        } else {
            Integer precio = Integer.valueOf(txtPrecio.getText());
            String detalles = txaDetalles.getText();
            if (detalles.isBlank()) {
                detalles = "Sin detalles";
            }
            if (btnAgregar.getText().equals("Agregar")) {
                controlAplicacion.agregarComidaComanda(controlAplicacion.obtenerProductoFila(selectedRow), precio, detalles);
            } else {
                controlAplicacion.editarComidaComanda(precio, detalles);
            }
        }

        if (btnAgregar.getText().equals("Agregar")) {
            Mediador.mostrarOptionPaneAviso(this, "Se ha agregado un producto");
        } else {
            Mediador.mostrarOptionPaneAviso(this, "Se ha editado un producto");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAlimentos;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCambiable;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenedor;
    private javax.swing.JPanel pnlContenedorDetalles;
    private javax.swing.JPanel pnlContenedorTabla;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
