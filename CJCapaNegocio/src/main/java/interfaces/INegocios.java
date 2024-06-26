/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ComandaDTO;
import dto.ComandaProductoDTO;
import entidades.*;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author gabli
 */
public interface INegocios {
    public List<Comanda> consultarComandas();
    public List<Comanda> consultarComandasPorFiltro(ComandaDTO filtro);
    public List<Comanda> consultarComandasExpress();
    public List<Comanda> consultarComandasPedido();
    public List<Comanda> consultarComandasMesa();
    public List<Comanda> consultarComandasCerrada();
    public Comanda consultarComanda(Long id);
    public Comanda crearComanda(Comanda comanda, List<ComandaProducto> comandaProductos);
    public Comanda modificarComanda(Comanda comanda);
    public Comanda eliminarComanda(Comanda comanda);
    public List<Producto> consultarProductosAlimentos();
    public List<Producto> consultarProductosBebidas();
    public List<Producto> consultarTodosProductos();
    public List<Mesa> consultarMesas();
    public Mesa consultarMesa(Long numeroMesa);
    public List<Comanda> consultarComandasEliminada();
    public Producto registrarProducto(Producto producto);
    public Producto eliminarProducto(Producto producto);
    public Producto consultarProductoNombre(String nombreProducto);
    public List<Producto> filtrarProductosPorNombre(String nombreProducto);
    public Producto modificarProducto(Producto producto);
    public List<ComandaProductoDTO> consultarProductosVendidos(Calendar fechaInicio, Calendar fechaFin, int tipoComanda);
}
