

package org.itson.cjcapadatos;

import dao.*;
import entidades.*;

/**
 *
 * @author JGlam
 */
public class CJCapaDatos {

    public static void main(String[] args) {
        FachadaDAO fachadaDAO = new FachadaDAO();
        /*
        Comanda comanda = new ComandaPedido(Calendar.getInstance(), "Villa Itson 345");
        List<ComandaProducto> comandaProductos = new ArrayList<>();
        Producto producto = new Producto(TipoComida.BEBIDA, "Coca Cola 600", 20);
        ComandaProducto comandaProducto = new ComandaProducto(comanda, producto, 3);
        fachadaDAO.registrarProducto(producto);
        comandaProductos.add(comandaProducto);
        comanda.setComandaProductos(comandaProductos);
        fachadaDAO.registrarComanda(comanda);
        */
        Producto producto = new Producto(TipoComida.BEBIDA, "Coca Cola Litro", 25);
        
//        fachadaDAO.registrarProducto(producto);

        Producto productoBuscado = fachadaDAO.consultarProducto(1L);
        Producto productoEliminado = fachadaDAO.eliminarProducto(productoBuscado);
        if(productoEliminado != null){
            System.out.println("se ha eliminado correctamente el producto");
        }else{
            System.out.println("no se eliminó el producto");
        }
    }
}
