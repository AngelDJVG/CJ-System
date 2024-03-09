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
    public Comanda crearComanda(Comanda comanda, List<ComandaProducto> comandaProductos);
    public List<Producto> consultarProductosAlimentos();
    public List<Producto> consultarProductosBebidas();
}
