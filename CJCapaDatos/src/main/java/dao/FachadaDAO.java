/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ComandaDTO;
import entidades.Comanda;
import entidades.Mesa;
import entidades.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author JGlam
 */
public class FachadaDAO {

    private final String PERSISTENCE_UNIT_NAME = "org.itson.carnitasjacarandas";

    //DAOs
    private ComandasDAO comandasDAO;
    private ProductosDAO productosDAO;
    private MesasDAO mesasDAO;

    public FachadaDAO() {
        EntityManager entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        this.comandasDAO = new ComandasDAO(entityManager);
        this.productosDAO = new ProductosDAO(entityManager);
        this.mesasDAO = new MesasDAO(entityManager);
    }

    public Comanda registrarComanda(Comanda comanda) {
        return comandasDAO.registrarComanda(comanda);
    }

    public Comanda consultarComanda(Long idComanda) {
        return comandasDAO.consultarComanda(idComanda);
    }

    public Comanda modificarComanda(Comanda comanda) {
        return comandasDAO.modificarComanda(comanda);
    }

    public Comanda eliminarComanda(Comanda comanda) {
        return comandasDAO.eliminarComanda(comanda);
    }

    public Producto registrarProducto(Producto producto) {
        return productosDAO.registrarProducto(producto);
    }

    public Producto consultarProducto(Long idProducto) {
        return productosDAO.consultarProducto(idProducto);
    }
    
    public Producto consultarProductoNombre(String nombreProducto){
        return productosDAO.consultarProductoNombre(nombreProducto);
    }
    
    public Producto modificarProducto(Producto producto) {
        return productosDAO.modificarProducto(producto);
    }

    public Producto eliminarProducto(Producto producto) {
        return productosDAO.eliminarProducto(producto);
    }
    public List<Producto> filtrarProductosPorNombre(String nombreProducto) {
        return productosDAO.filtrarProductosPorNombre(nombreProducto);
    }

    public Mesa registrarMesa(Mesa mesa) {
        return mesasDAO.registrarMesa(mesa);
    }

    public Mesa consultarMesa(Long numMesa) {
        return mesasDAO.consultarMesa(numMesa);
    }

    public Mesa modificarMesa(Mesa mesa) {
        return mesasDAO.modificarMesa(mesa);
    }

    public Mesa eliminarMesa(Mesa mesa) {
        return mesasDAO.eliminarMesa(mesa);
    }
    public List<Comanda> consultarComandas(){
        return comandasDAO.consultarComandas();
    }
    public List<Comanda> consultarComandasPorFiltro(ComandaDTO filtro){
        return comandasDAO.consultarComandasPorFiltro(filtro);
    }
    public List<Comanda> consultarComandasExpress(){
        return comandasDAO.consultarComandasExpress();
    }
    public List<Comanda> consultarComandasMesa(){
        return comandasDAO.consultarComandasMesa();
    }
    public List<Comanda> consultarComandasPedido(){
        return comandasDAO.consultarComandasPedido();
    }
    public List<Comanda> consultarComandasCerradas(){
        return comandasDAO.consultarComandasCerradas();
    }
    public List<Comanda> consultarComandasEliminadas(){
        return comandasDAO.consultarComandasEliminadas();
    }
    public List<Mesa> consultarMesas(){
        return mesasDAO.consultarMesas();
    }
    public List<Producto> consultarProductosAlimentos(){
        return productosDAO.consultarProductosAlimentos();
    }
    public List<Producto> consultarProductosBebidas(){
        return productosDAO.consultarProductosBebidas();
    }
    public List<Producto> consultarTodosProductos(){
        return productosDAO.consultarTodosProductos();
    }
}
