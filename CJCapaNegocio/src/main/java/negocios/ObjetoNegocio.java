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
 * @author
 */
public class ObjetoNegocio implements INegocios{
    private ControlComanda controlComanda;
    private ControlProducto controlProducto;
    private ControlMesa controlMesa;
            
    private FachadaDAO fachadaDAO;
    public ObjetoNegocio(){
        fachadaDAO = new FachadaDAO();
        controlComanda = new ControlComanda(fachadaDAO);
        controlProducto = new ControlProducto(fachadaDAO);
        controlMesa = new ControlMesa(fachadaDAO);
    }

    @Override
    public List<Comanda> consultarComandas() {
       return controlComanda.consultarComandas();
    }
    
    @Override
    public List<Comanda> consultarComandasAbiertasCerradas(int tipoComanda){
        return controlComanda.consultarComandasAbiertasCerradas(tipoComanda);
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
    public Comanda modificarComanda(Comanda comanda) {
         return controlComanda.modificarComanda(comanda);
    }
     @Override
    public Comanda eliminarComanda(Comanda comanda) {
        return controlComanda.eliminarComanda(comanda);
    }
    @Override
    public List<Producto> consultarProductosAlimentos() {
        return controlProducto.consultarProductosAlimentos();
    }

    @Override
    public List<Producto> consultarProductosBebidas() {
        return controlProducto.consultarProductosBebidas();
    }

    @Override
    public List<Mesa> consultarMesas() {
        return controlMesa.consultarMesas();
    }

    @Override
    public Mesa consultarMesa(Long numeroMesa) {
        return controlMesa.consultarMesa(numeroMesa);
    }
    public List<Comanda> consultarComandasCerrada()
    {
        return controlComanda.consultarCerradas();
    }
    public List<Comanda> consultarComandasEliminada()
    {
        return controlComanda.consultarEliminadas();
    }

    @Override
    public Comanda consultarComanda(Long id) {
        return controlComanda.consultarComanda(id);
    }
}
