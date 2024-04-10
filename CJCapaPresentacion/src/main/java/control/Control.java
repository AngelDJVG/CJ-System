/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import componentes.BotonComandaProducto;
import entidades.Comanda;
import entidades.ComandaExpress;
import entidades.ComandaMesa;
import entidades.ComandaPedido;
import entidades.ComandaProducto;
import entidades.Mesa;
import entidades.Producto;
import entidades.TipoComida;
import enums.TiposComanda;
import static enums.TiposComanda.CERRADA;
import static enums.TiposComanda.ELIMINADA;
import static enums.TiposComanda.EXPRESS;
import static enums.TiposComanda.MESA;
import static enums.TiposComanda.PEDIDO;
import interfaces.INegocios;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocios.ObjetoNegocio;
import utilidades.Validador;
import view.JDLElegirProducto;

/**
 *
 * @author JGlam
 */
public class Control {

    private List<ComandaProducto> productosComanda = new ArrayList<>();
    private List<Producto> productosCargados = new ArrayList<>();
    private ComandaProducto ultimoEventoProducto;

    private JComboBox<Mesa> cbxMesas;
    private JPanel pnlComandasProducto;
    private JLabel vistaTotal;
    private JTextField vistaDireccion;
    private JTextField vistaNombreCliente;

    private INegocios controlNegocio = new ObjetoNegocio();
    private Validador validador = new Validador();

    public List<ComandaProducto> obtenerProductosComandaAgregados() {
        return productosComanda;
    }

    public void editarBebidaComanda(Integer cantidad){
        ultimoEventoProducto.setCantidad(cantidad);
        ultimoEventoProducto.cargarTotal();
        
        this.calcularTotal();
        cargarComandasProductos(pnlComandasProducto);
    }
    
    public void editarComidaComanda(Integer cantidadPrecio, String detalles){
        ultimoEventoProducto.setCantidad(cantidadPrecio);
        ultimoEventoProducto.setDetalles(detalles);
        
        ultimoEventoProducto.cargarTotal();
        
        this.calcularTotal();
        cargarComandasProductos(pnlComandasProducto);
    }
    public List<Comanda> cargarComandas(int tipoComanda)
    {
         switch(tipoComanda)
        {
            case PEDIDO:
                return controlNegocio.consultarComandasPedido();
            case MESA:
                return controlNegocio.consultarComandasMesa();
            case CERRADA:
                return controlNegocio.consultarComandasCerrada();
            case ELIMINADA:
                return controlNegocio.consultarComandasEliminada();
        }
        return null;
    }
    
    public void agregarBebidaComanda(Producto producto, Integer cantidad) {
        productosComanda.add(new ComandaProducto(producto, cantidad, "No se incluyeron detalles"));

        this.calcularTotal();
        cargarComandasProductos(pnlComandasProducto);
    }

    public void agregarComidaComanda(Producto producto, Integer cantidadPrecio, String detalles) {
        productosComanda.add(new ComandaProducto(producto, cantidadPrecio, detalles));
        this.calcularTotal();
        cargarComandasProductos(pnlComandasProducto);
    }
    
    public void agregarProductosComanda(List<ComandaProducto> productosComanda)
    {
        this.productosComanda = productosComanda;
    }

    public void cargarMesas(JComboBox<Mesa> cbxMesa) {
        this.cbxMesas = cbxMesa;
        List<Mesa> mesas = controlNegocio.consultarMesas();
        cbxMesa.setModel(new javax.swing.DefaultComboBoxModel<>(mesas.toArray(new Mesa[mesas.size()])));
    }

    public void cargarProductos(JTable tblProductos, TipoComida tipo) {
        if (tipo.equals(TipoComida.BEBIDA)) {
            productosCargados = controlNegocio.consultarProductosBebidas();
        } else {
            productosCargados = controlNegocio.consultarProductosAlimentos();
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) tblProductos.getModel();
        modeloTabla.setRowCount(0);
        for (Producto producto : productosCargados) {
            Object[] fila = {producto.getNombre(), producto.getPrecio()};
            modeloTabla.addRow(fila);
        }
    }

    public void cargarComandasProductos(JPanel pnlPedidos) {
        this.pnlComandasProducto = pnlPedidos;

        int anchoPanel = pnlComandasProducto.getWidth();
        int alturaPanel = 50;
        int anchoPanelConScroll = pnlComandasProducto.getWidth() - 10;
        int espaciado = 10;
        int alturaPanelPedidos = 0;
        pnlPedidos.removeAll();

        pnlPedidos.setLayout(new BoxLayout(pnlPedidos, BoxLayout.Y_AXIS));

        for (ComandaProducto comandaProducto : productosComanda) {
            JPanel pnlComanda = new JPanel(new BorderLayout());

            pnlComanda.setBackground(new java.awt.Color(235, 204, 204));
            pnlComanda.setMaximumSize(new java.awt.Dimension(anchoPanel, alturaPanel));
            pnlComanda.setMinimumSize(new java.awt.Dimension(anchoPanel, alturaPanel));
            pnlComanda.setPreferredSize(new java.awt.Dimension(anchoPanel, alturaPanel));

            JLabel lblNombreProducto = new JLabel(comandaProducto.getCantidad() + " " + comandaProducto.getProducto().getNombre());
            pnlComanda.add(lblNombreProducto, BorderLayout.WEST);

            JPanel pnlBotones = new JPanel(new GridLayout(1, 3));

            BotonComandaProducto btnDetalles = new BotonComandaProducto("/iconos/ic_informacion.png");
            asignarActionListenerConsultar(btnDetalles, comandaProducto);
            BotonComandaProducto btnEditar = new BotonComandaProducto("/iconos/ic_editar.png");
            asignarActionListenerEditar(btnEditar, comandaProducto, this);
            BotonComandaProducto btnEliminar = new BotonComandaProducto("/iconos/ic_eliminar.png");
            asignarActionListenerBorrar(btnEliminar, comandaProducto);

            pnlBotones.add(btnDetalles);
            pnlBotones.add(btnEditar);
            pnlBotones.add(btnEliminar);

            pnlComanda.add(pnlBotones, BorderLayout.EAST);
            if (productosComanda.size() > 6) {
                alturaPanelPedidos += alturaPanel;

            }
            pnlPedidos.add(pnlComanda);
        }

        pnlPedidos.setPreferredSize(new Dimension(anchoPanel, alturaPanelPedidos));
        pnlPedidos.revalidate();
        pnlPedidos.repaint();
    }

    private void asignarActionListenerConsultar(JButton boton, ComandaProducto comandaProducto) {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, comandaProducto.getDetalles());
            }
        });
    }

    private void asignarActionListenerEditar(JButton boton, ComandaProducto comandaProducto, Control controlAplicacion) {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ultimoEventoProducto = comandaProducto;
                JDLElegirProducto elegirProducto = new JDLElegirProducto(Mediador.obtenerFrmRegistroComanda(), true, controlAplicacion, comandaProducto);
                elegirProducto.setVisible(true);
            }
        });
    }

    private void asignarActionListenerBorrar(JButton boton, ComandaProducto comandaProducto) {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productosComanda.remove(comandaProducto);
                calcularTotal();
                cargarComandasProductos(pnlComandasProducto);

            }
        });
    }

    public Producto obtenerProductoFila(int filaSelecionada) {
        if (filaSelecionada != -1) {
            return productosCargados.get(filaSelecionada);
        } else {
            return null;
        }
    }
    public DefaultTableModel obtenerTablaComandas(int tipoComanda){
        switch(tipoComanda)
        {
            case PEDIDO:
                return obtenerTablaPedidos();

            case MESA:
                return obtenerTablaMesas();
            case CERRADA:
                return obtenerTablaCerradas();
            case ELIMINADA:
                return obtenerTablaEliminadas();
        }
        
        return null;
    }
    public DefaultTableModel obtenerTablaCerradas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Editar");
        model.addColumn("Eliminar");
        List<Comanda> comandas = cargarComandas(CERRADA);
        // Llenar la tabla con los objetos de la lista
        
        for (Comanda obj : comandas) {
            
            
            Object[] rowData = {obj.getId(), "/iconos/ic_editar_blanco.png","/iconos/ic_eliminar_blanco.png"};
            model.addRow(rowData);
        }
        
        return model;
    }
    public DefaultTableModel obtenerTablaEliminadas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        List<Comanda> comandas = cargarComandas(ELIMINADA);
        // Llenar la tabla con los objetos de la lista
        
        for (Comanda obj : comandas) {
            
            
            Object[] rowData = {obj.getId()};
            model.addRow(rowData);
        }
        
        return model;
    }
    public DefaultTableModel obtenerTablaPedidos(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Direccion");
        model.addColumn("Cerrar");
        model.addColumn("Editar");
        model.addColumn("Eliminar");
        List<Comanda> comandas = cargarComandas(PEDIDO);
        // Llenar la tabla con los objetos de la lista
        
        for (Comanda obj : comandas) {
            
            ComandaPedido pedido = (ComandaPedido) obj;
            Object[] rowData = {pedido.getId(),pedido.getDireccion(), "/iconos/ic_cerrar.png", "/iconos/ic_editar_blanco.png","/iconos/ic_eliminar_blanco.png"};
            model.addRow(rowData);
        }
        
        return model;
    }
    public DefaultTableModel obtenerTablaMesas(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Mesa");
        model.addColumn("Cerrar");
        model.addColumn("Editar");
        model.addColumn("Eliminar");
        List<Comanda> comandas = cargarComandas(MESA);
        // Llenar la tabla con los objetos de la lista
        
        for (Comanda obj : comandas) {
            
            ComandaMesa mesa = (ComandaMesa) obj;
            Object[] rowData = {mesa.getId(),mesa.getMesa(), "/iconos/ic_cerrar.png", "/iconos/ic_editar_blanco.png","/iconos/ic_eliminar_blanco.png"};
            model.addRow(rowData);
        }
        
        return model;
    }
    
    public Mesa consultarMesaSeleccionada() {
        return (Mesa) this.cbxMesas.getSelectedItem();
    }

    public void establecerVistaTotal(JLabel vistaTotal) {
        this.vistaTotal = vistaTotal;
    }

    public void calcularTotal() {
        double total = 0;
        for (ComandaProducto comandaProducto : productosComanda) {
            total += comandaProducto.getTotal();
        }
        String textoTotal = String.format("Total: $%.1f", total);
        vistaTotal.setText(textoTotal);
    }

    public void actualizarPrecioBebida(JTextField txtPrecio, TipoComida tipoProductoActual, int selectedRow) {
        if (tipoProductoActual.equals(TipoComida.BEBIDA)) {
            Producto productoSeleccionado = this.obtenerProductoFila(selectedRow);
            String precioMostrar = String.valueOf(productoSeleccionado.getPrecio());
            txtPrecio.setText(precioMostrar);
        }
    }

    public void asignarVistaDireccion(JTextField lblDireccion) {
        this.vistaDireccion = lblDireccion;
    }

    public void registrarComanda(int tipoSeleccionado) {
        if (validador.contieneProductos(productosComanda)) {
            if (tipoSeleccionado == TiposComanda.EXPRESS) {
                controlNegocio.crearComanda(new ComandaExpress(), productosComanda);
                volverInicio();
            }
            if (tipoSeleccionado == TiposComanda.MESA) {
                controlNegocio.crearComanda(new ComandaMesa(consultarMesaSeleccionada()), productosComanda);
                volverInicio();
            }
            if (tipoSeleccionado == TiposComanda.PEDIDO) {
                String direccion = vistaDireccion.getText(), nombreCliente = vistaNombreCliente.getText();
                if (validador.datosPedidoValidos(direccion, nombreCliente)) {
                    controlNegocio.crearComanda(new ComandaPedido(direccion, nombreCliente), productosComanda);
                    volverInicio();
                } else {
                    this.mostrarMensaje("Llene correctamente los campos de dirección y nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            this.mostrarMensaje(
                    "Debe registrar al menos un producto",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void actualizarComanda(int tipoSeleccionado,long id) {
        if (validador.contieneProductos(productosComanda)) {
            if (tipoSeleccionado == TiposComanda.EXPRESS) {
                ComandaExpress comandaExpress = (ComandaExpress) controlNegocio.consultarComanda(id);
                    comandaExpress.setComandaProductos(productosComanda);
                controlNegocio.modificarComanda(comandaExpress);
            }
            if (tipoSeleccionado == TiposComanda.MESA) {
                ComandaMesa comandaMesa = (ComandaMesa) controlNegocio.consultarComanda(id);
                
                    comandaMesa.setComandaProductos(productosComanda);
                controlNegocio.modificarComanda(comandaMesa);
            }
            if (tipoSeleccionado == TiposComanda.PEDIDO) {
                String direccion = vistaDireccion.getText(), nombreCliente = vistaNombreCliente.getText();
                if (validador.datosPedidoValidos(direccion, nombreCliente)) {
                    ComandaPedido comandaPedido = new ComandaPedido(direccion, nombreCliente);
                    comandaPedido.setId(id);
                    comandaPedido.setComandaProductos(productosComanda);
                    controlNegocio.modificarComanda(comandaPedido);
                    Mediador.abrirFrmAdministrarComanda(PEDIDO);
                } else {
                    this.mostrarMensaje("Llene correctamente los campos de dirección y nombre", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            this.mostrarMensaje(
                    "Debe registrar al menos un producto",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void volverInicio() {
        mostrarMensaje("Se ha registrado la comanda", "Registro", JOptionPane.INFORMATION_MESSAGE);
        Mediador.cerrarFrmRegistroComanda();
        Mediador.abrirFrmComandas();
    }

    public void asignarVistaNombreCliente(JTextField txtNombreCliente) {
        this.vistaNombreCliente = txtNombreCliente;
    }

    public void mostrarMensaje(String msj, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, msj, titulo, tipoMensaje);
    }
    
    public Comanda consultarComanda(Long id)
    {
        
        return controlNegocio.consultarComanda(id);
    }
    public void cerrarComanda(Comanda comanda)
    {
        comanda.setEstadoAbierta(0);
        controlNegocio.modificarComanda(comanda);
    }
    public void eliminarComanda(Comanda comanda)
    {
        comanda.setEstadoAbierta(3);
        controlNegocio.modificarComanda(comanda);
    }
    public void pagarComanda()
    {
        JOptionPane.showMessageDialog(null, "PROCESANDO PAGO...", "Pago", JOptionPane.INFORMATION_MESSAGE);
    }

}
