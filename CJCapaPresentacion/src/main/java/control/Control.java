/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Comanda;
import entidades.ComandaExpress;
import entidades.ComandaMesa;
import entidades.ComandaPedido;
import entidades.ComandaProducto;
import entidades.Mesa;
import entidades.Producto;
import entidades.TipoComida;
import enums.TiposComanda;
import interfaces.INegocios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import negocios.ObjetoNegocio;
import view.FrmComandas;

/**
 *
 * @author JGlam
 */
public class Control {

    private List<ComandaProducto> productosComanda = new ArrayList<>();
    private List<Producto> productosCargados = new ArrayList<>();
    
    private JComboBox<Mesa> cbxMesas;
    private JLabel vistaTotal;
    private JTextField vistaDireccion;

    private INegocios controlNegocio = new ObjetoNegocio();

    public List<ComandaProducto> obtenerProductosComandaAgregados(){
        return productosComanda;
    }
    
    public void agregarBebidaComanda(Producto producto, Integer cantidad) {
        productosComanda.add(new ComandaProducto(producto, cantidad, "No se incluyeron detalles"));
        this.calcularTotal();
    }

    public void agregarComidaComanda(Producto producto, Integer cantidadPrecio, String detalles) {
        productosComanda.add(new ComandaProducto(producto, cantidadPrecio, detalles));
        this.calcularTotal();
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

    public Producto obtenerProductoFila(int filaSelecionada) {
        if (filaSelecionada != -1) {
            return productosCargados.get(filaSelecionada);
        } else {
            return null;
        }
    }

    public Mesa consultarMesaSeleccionada(){
        return (Mesa)this.cbxMesas.getSelectedItem();
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

    public void registrarComanda(int tipoSeleccionado){
        if(tipoSeleccionado == TiposComanda.EXPRESS){
            controlNegocio.crearComanda(new ComandaExpress(), productosComanda);
        }
        if(tipoSeleccionado == TiposComanda.MESA){
            controlNegocio.crearComanda(new ComandaMesa(consultarMesaSeleccionada()), productosComanda);
        }
        if(tipoSeleccionado == TiposComanda.PEDIDO){
            controlNegocio.crearComanda(new ComandaPedido(vistaDireccion.getText()), productosComanda);
        }
        Mediador.cerrarFrmRegistroComanda();
        Mediador.abrirFrmComandas();
    }

    
}
