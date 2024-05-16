/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import dto.ComandaProductoDTO;
import entidades.*;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author gabli
 */
public interface IFachadaDAO {
    Comanda registrarComanda(Comanda comanda);
    Comanda consultarComanda(Long idComanda);
    Comanda modificarComanda(Comanda comanda);
    Comanda eliminarComanda(Comanda comanda);
    List<Comanda> consultarComandas();
    List<Comanda> consultarComandasExpress();
    List<Comanda> consultarComandasMesa();
    List<Comanda> consultarComandasPedido();
    List<Comanda> consultarComandasCerradas();
    
    // Métodos para Productos
    Producto registrarProducto(Producto producto);
    Producto consultarProducto(Long idProducto);
    Producto modificarProducto(Producto producto);
    Producto eliminarProducto(Producto producto);
    List<Producto> consultarProductosAlimentos();
    List<Producto> consultarProductosBebidas();
    List<Producto> consultarTodosProductos();

    // Métodos para Mesas
    Mesa registrarMesa(Mesa mesa);
    Mesa consultarMesa(Long numMesa);
    Mesa modificarMesa(Mesa mesa);
    Mesa eliminarMesa(Mesa mesa);
    List<Mesa> consultarMesas();
    
    List<ComandaProductoDTO> consultarProductosVendidos(Calendar fechaInicio, Calendar fechaFin, int tipoComanda);
}
