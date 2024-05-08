/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Producto;
import entidades.TipoComida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author JGlam
 */
public class ProductosDAO {

    private EntityManager entityManager;

    public ProductosDAO(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    public Producto registrarProducto(Producto producto) {
        if (producto != null) {
            if (producto.getId() != null) {
                if (this.consultarProducto(producto.getId()) != null) {
                    return null;
                }
            }
            entityManager.getTransaction().begin();
            entityManager.persist(producto);
            entityManager.getTransaction().commit();
            return producto;
        }
        return null;
    }
    
    public Producto consultarProducto(Long idProducto){
        if(idProducto != null){
            Producto productoBuscar = entityManager.find(Producto.class, idProducto);
            if(productoBuscar != null){
                return productoBuscar;
            }
        }
        return null;
    }

    public Producto modificarProducto(Producto producto) {
        if (producto != null) {
            if (producto.getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.merge(producto);
                entityManager.getTransaction().commit();
                return producto;
            }
        }
        return null;
    }
    
    public Producto eliminarProducto(Producto producto) {
        if (producto != null) {
            if (producto.getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(producto);
                entityManager.getTransaction().commit();
                return producto;
            }
        }
        return null;
    }
    public List<Producto> consultarProductosAlimentos(){
        TypedQuery<Producto> productosQuery = entityManager.createQuery("SELECT a FROM Producto a WHERE a.tipo= :tipo",Producto.class);
        productosQuery.setParameter("tipo", TipoComida.COMIDA);
        return productosQuery.getResultList();
    }
    public List<Producto> consultarProductosBebidas(){
         TypedQuery<Producto> productosQuery = entityManager.createQuery("SELECT a FROM Producto a WHERE a.tipo= :tipo",Producto.class);
        productosQuery.setParameter("tipo", TipoComida.BEBIDA);
        return productosQuery.getResultList();
    }
    public List<Producto> consultarTodosProductos(){
         TypedQuery<Producto> productosQuery = entityManager.createQuery("SELECT a FROM Producto a", Producto.class);
         return productosQuery.getResultList();
    }
}
