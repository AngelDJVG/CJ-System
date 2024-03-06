/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Mesa;
import javax.persistence.EntityManager;

/**
 *
 * @author JGlam
 */
public class MesasDAO {
    EntityManager entityManager;
   
    public MesasDAO(EntityManager entityManger) {
        this.entityManager = entityManger;
    }
    public Mesa registrarMesa(Mesa mesa) {
        if (mesa != null) {
            if (mesa.getNumero() != null) {
                if (this.consultarMesa(mesa.getNumero()) != null) {
                    return null;
                }
            }
            entityManager.getTransaction().begin();
            entityManager.persist(mesa);
            entityManager.getTransaction().commit();
            return mesa;
        }
        return null;
    }
    
    public Mesa consultarMesa(Long numMesa){
        if(numMesa!= null){
            Mesa mesaBuscar = entityManager.find(Mesa.class, numMesa);
            if(mesaBuscar != null){
                return mesaBuscar;
            }
        }
        return null;
    }

    public Mesa modificarMesa(Mesa mesa) {
        if (mesa != null) {
            if (mesa.getNumero() != null) {
                entityManager.getTransaction().begin();
                entityManager.merge(mesa);
                entityManager.getTransaction().commit();
                return mesa;
            }
        }
        return null;
    }
    public Mesa eliminarMesa(Mesa mesa){
        if(mesa!=null){
            if(mesa.getNumero()!=null){
                entityManager.getTransaction().begin();
                entityManager.remove(mesa);
                entityManager.getTransaction().commit();
                return mesa;
            }
        }
        return null;
    }
}
