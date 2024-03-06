

package org.itson.cjcapadatos;

import entidades.Cliente;
import entidades.Movimiento;
import entidades.TipoMovimiento;
import java.util.Calendar;
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
        Movimiento movimiento = new Movimiento(1L, Calendar.getInstance(), TipoMovimiento.CARGO, 1000);
        
        entityManager.persist(movimiento);
        entityManager.getTransaction().commit();
    }
}
