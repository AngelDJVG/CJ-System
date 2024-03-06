

package org.itson.cjcapadatos;

import dao.FachadaDAO;
import entidades.Comanda;
import entidades.ComandaPedido;
import entidades.ComandaProducto;
import entidades.Producto;
import entidades.TipoComida;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author JGlam
 */
public class CJCapaDatos {

    public static void main(String[] args) {
        FachadaDAO fachadaDAO = new FachadaDAO();
        Comanda comanda = new ComandaPedido(Calendar.getInstance(), "Villa Itson 345");
        List<ComandaProducto> comandaProductos = new ArrayList<>();
        Producto producto = new Producto(TipoComida.BEBIDA, "Coca Cola 600", 20);
        ComandaProducto comandaProducto = new ComandaProducto(comanda, producto, 3);
        fachadaDAO.registrarProducto(producto);
        comandaProductos.add(comandaProducto);
        comanda.setComandaProductos(comandaProductos);
        fachadaDAO.registrarComanda(comanda);
    }
}
