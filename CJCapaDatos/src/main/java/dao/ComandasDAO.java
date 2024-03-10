
package dao;

import entidades.Comanda;
import entidades.ComandaProducto;
import java.util.List;
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
            for (ComandaProducto comandaProducto : comanda.getComandaProductos()) {
                comandaProducto.setComanda(comanda);
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
    public List<Comanda> consultarComandas(){
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM Comanda a",Comanda.class).getResultList();
        return comandas;
    }
   
    public List<Comanda> consultarComandasExpress(){
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaExpress a",Comanda.class).getResultList();
        return comandas;
    }
    
    public List<Comanda> consultarComandasMesa(){
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaMesa a",Comanda.class).getResultList();
        return comandas;
    }
     public List<Comanda> consultarComandasPedido(){
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaPedido a",Comanda.class).getResultList();
        return comandas;
    }
    public List<Comanda> consultarComandasCerradas(){
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaPedido a WHERE a.estadoAbierta=true",Comanda.class).getResultList();
        return comandas;

    }
     
    
}
