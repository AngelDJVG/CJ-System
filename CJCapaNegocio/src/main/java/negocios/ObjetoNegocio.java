/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import dto.ComandaDTO;
import dto.ComandaProductoDTO;
import entidades.*;
import interfaces.INegocios;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author
 */
public class ObjetoNegocio implements INegocios{
    private ControlComanda controlComanda;
    private ControlProducto controlProducto;
    private ControlMesa controlMesa;
    private ControlComandaProducto controlComandaProducto;
            
    private FachadaDAO fachadaDAO;
    public ObjetoNegocio(){
        fachadaDAO = new FachadaDAO();
        controlComanda = new ControlComanda(fachadaDAO);
        controlProducto = new ControlProducto(fachadaDAO);
        controlMesa = new ControlMesa(fachadaDAO);
        controlComandaProducto = new ControlComandaProducto(fachadaDAO);
    }

    @Override
    public List<Comanda> consultarComandas() {
       return controlComanda.consultarComandas();
    }
    
    @Override
    public List<Comanda> consultarComandasPorFiltro(ComandaDTO filtro){
        return controlComanda.consultarComandasPorFiltro(filtro);
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
    public List<Producto> consultarTodosProductos(){
        return controlProducto.consultarTodosProductos();
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

    @Override
    public Producto registrarProducto(Producto producto) {
        return controlProducto.registrarProducto(producto);
    }
    @Override
    public Producto eliminarProducto(Producto producto){
        return controlProducto.eliminarProducto(producto);
    }
    @Override
    public Producto consultarProductoNombre(String nombreProducto){
        return controlProducto.consultarProductoNombre(nombreProducto);
    }
    @Override
    public Producto modificarProducto(Producto producto){
        return controlProducto.modificarProducto(producto);
    }
    @Override
    public List<Producto> filtrarProductosPorNombre(String nombreProducto) {
        return controlProducto.filtrarProductosPorNombre(nombreProducto);
    }

    @Override
    public List<ComandaProductoDTO> consultarProductosVendidos(Calendar fechaInicio, Calendar fechaFin, int tipoComanda) {
        return controlComandaProducto.consultarProductosVendidos(fechaInicio, fechaFin, tipoComanda);
    }
}
