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
    List<Producto> consultarProductosAlimentos(){
       return fachadaDAO.consultarProductosAlimentos();
    } 
    List<Producto> consultarProductosBebidas(){
       return fachadaDAO.consultarProductosBebidas();
    }
}
