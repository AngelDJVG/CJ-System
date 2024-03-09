/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import entidades.*;
import interfaces.INegocios;
import java.util.List;

/**
 *
 * @author gabli
 */
public class ObjetoNegocio implements INegocios{
    ControlComanda controlComanda;
    ControlProducto controlProducto;
    FachadaDAO fachadaDAO;
    public ObjetoNegocio(){
        fachadaDAO = new FachadaDAO();
        controlComanda = new ControlComanda(fachadaDAO);
    }

    @Override
    public List<Comanda> consultarComandas() {
       return controlComanda.consultarComandas();
    }

    @Override
    public List<Comanda> consultarComandasExpress() {
        return controlComanda.consultarComandasExpress();
    }

    @Override
    public List<Comanda> consultarComandasPedido() {
        return controlComanda.consultarComandasPedido();
    }

    @Override
    public List<Comanda> consultarComandasMesa() {
        return controlComanda.consultarComandasMesa();
    }

    @Override
    public Comanda crearComanda(Comanda comanda, List<ComandaProducto> comandaProductos) {
        return controlComanda.crearComanda(comanda, comandaProductos);
    }

    @Override
    public List<Producto> consultarProductosAlimentos() {
        return controlProducto.consultarProductosAlimentos();
    }

    @Override
    public List<Producto> consultarProductosBebidas() {
        return controlProducto.consultarProductosBebidas();
    }
    
    
}
