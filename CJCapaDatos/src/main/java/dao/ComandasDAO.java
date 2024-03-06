
package dao;

import entidades.Comanda;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author JGlam
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

    public Comanda eliminarComanda(Comanda comanda) {
        if (comanda != null) {
            if (comanda.getId() != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(comanda);
                entityManager.getTransaction().commit();
                return comanda;
            }
        }
        return null;
    }
    
}
