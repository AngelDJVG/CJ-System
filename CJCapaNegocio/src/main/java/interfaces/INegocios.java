/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.*;
import java.util.List;

/**
 *
 * @author gabli
 */
public interface INegocios {
    public List<Comanda> consultarComandas();
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
    public List<Mesa> consultarMesas();
    public Mesa consultarMesa(Long numeroMesa);
    public List<Comanda> consultarComandasEliminada();
}
