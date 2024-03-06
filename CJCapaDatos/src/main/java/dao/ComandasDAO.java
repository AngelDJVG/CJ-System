/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Comanda;
import javax.persistence.EntityManager;

/**
 *
 * @author mario
 */
public class ComandasDAO {

    private EntityManager entityManager;

    public ComandasDAO(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    public Comanda registrarComanda(Comanda comanda) {
        if (comanda != null) {
            if (comanda.getId() != null) {
                if (this.consultarComanda(comanda.getId()) != null) {
                    return null;
                }
            }
            entityManager.getTransaction().begin();
            entityManager.persist(comanda);
            entityManager.getTransaction().commit();
            return comanda;
        }
        return null;
    }

    public Comanda consultarComanda(Long idComanda) {
        if (idComanda != null) {
            Comanda comandaBuscar = entityManager.find(Comanda.class, idComanda);
            if (comandaBuscar != null) {
                return comandaBuscar;
            }
        }
        return null;
    }

    public Comanda modificarComanda(Comanda comanda) {
        if (comanda != null) {
            if (comanda.getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.persist(comanda);
                entityManager.getTransaction().commit();
                return comanda;
            }
        }
        return null;
    }

}
