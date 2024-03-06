/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Producto;
import javax.persistence.EntityManager;

/**
 *
 * @author mario
 */
public class ProductosDAO {

    private EntityManager entityManager;

    public ProductosDAO(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    public Producto registrarProducto(Producto producto) {
        if (producto != null) {
            if (producto.getId() != null) {
                if (entityManager.find(Producto.class, producto.getId()) != null) {
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

}
