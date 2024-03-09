

package org.itson.cjcapadatos;

import dao.*;
import entidades.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author JGlam
 */
public class CJCapaDatos {

    public static void main(String[] args) {
        FachadaDAO fachadaDAO = new FachadaDAO();
        
//        Comanda comanda = new ComandaPedido(Calendar.getInstance(), "Villa Itson 345");
//        List<ComandaProducto> comandaProductos = new ArrayList<>();
//        Producto producto = new Producto(TipoComida.BEBIDA, "Coca Cola 600", 20);
//        ComandaProducto comandaProducto = new ComandaProducto(comanda, producto, 3,"");
//        fachadaDAO.registrarProducto(producto);
//        comandaProductos.add(comandaProducto);
//        comanda.setComandaProductos(comandaProductos);
//        fachadaDAO.registrarComanda(comanda);
//        
//        Producto producto = new Producto(TipoComida.BEBIDA, "Coca Cola Litro", 25);
//        
//       fachadaDAO.registrarProducto(producto);
//
//        Producto productoBuscado = fachadaDAO.consultarProducto(1L);
//        Producto productoEliminado = fachadaDAO.eliminarProducto(productoBuscado);
//        if(productoEliminado != null){
//            System.out.println("se ha eliminado correctamente el producto");
//        }else{
//            System.out.println("no se eliminó el producto");
//        }
//        Calendar fecha = new GregorianCalendar();
//        Comanda comanda = new ComandaExpress(fecha);
//        fachadaDAO.registrarComanda(comanda);
          List<Comanda> comandas;  
          comandas = fachadaDAO.consultarComandasCerradas();
          for (Comanda comanda : comandas) {
              System.out.println(comanda);
        }
        
    }
}
