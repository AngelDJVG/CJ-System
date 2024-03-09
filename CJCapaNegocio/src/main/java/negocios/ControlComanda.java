/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import entidades.*;
import java.util.List;

/**
 *
 * @author gabli
 */
public class ControlComanda {
    private FachadaDAO fachadaDAO;
    
    public ControlComanda(FachadaDAO fachadaDAO){
        this.fachadaDAO = fachadaDAO;
    }
    
    public List<Comanda> consultarComandas(){
        return fachadaDAO.consultarComandas();
    }
    public List<Comanda> consultarComandasExpress(){
        return fachadaDAO.consultarComandasExpress();

    }
    public List<Comanda> consultarComandasPedido(){
        return fachadaDAO.consultarComandasPedido();

    }
    public List<Comanda> consultarComandasMesa(){
        return fachadaDAO.consultarComandasMesa();
    }
    public ComandaProducto crearComandaProducto(Comanda comanda,Producto producto,int cantidad,String detalles){
      ComandaProducto comandaProducto = new ComandaProducto(comanda,producto,cantidad,detalles);
      return comandaProducto;
    }
    public Comanda crearComanda(Comanda comanda, List<ComandaProducto> comandaProductos){
        comanda.setComandaProductos(comandaProductos);
        
        return fachadaDAO.registrarComanda(comanda);
    }
    
}
