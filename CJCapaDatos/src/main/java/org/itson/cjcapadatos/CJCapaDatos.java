

package org.itson.cjcapadatos;

import entidades.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JGlam
 */
public class CJCapaDatos {

    //CREAR UNA BASE DE DATOS LLAMADA "CARNITASJACARANDAS" EN MYSQL
    public static void main(String[] args) {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("org.itson.carnitasjacarandas");
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = new Cliente("0000000000", "Pablo");
        
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }
}
