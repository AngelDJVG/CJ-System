/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import entidades.Producto;
import java.util.List;

/**
 *
 * @author gabli
 */
public class ControlProducto {
    private FachadaDAO fachadaDAO;
    
    public ControlProducto(FachadaDAO fachadaDAO){
        this.fachadaDAO = fachadaDAO;
    }
    public Producto registrarProducto(Producto producto){
        return fachadaDAO.registrarProducto(producto);
    }
    public Producto eliminarProducto(Producto producto){
        return fachadaDAO.eliminarProducto(producto);
    }
    public Producto consultarProducto(){
        return fachadaDAO.consultarProducto(Long.MIN_VALUE);
    }
    List<Producto> consultarProductosAlimentos(){
       return fachadaDAO.consultarProductosAlimentos();
    } 
    List<Producto> consultarProductosBebidas(){
       return fachadaDAO.consultarProductosBebidas();
    }
    public List<Producto> consultarTodosProductos(){
        return fachadaDAO.consultarTodosProductos();
    }
    public Producto consultarProductoNombre(String nombreProducto){
        return fachadaDAO.consultarProductoNombre(nombreProducto);
    }
    
    public List<Producto> filtrarProductosPorNombre(String nombreProducto){
        return fachadaDAO.filtrarProductosPorNombre(nombreProducto);
    }
    
}
