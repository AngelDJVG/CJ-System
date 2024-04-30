package dao;

import entidades.Comanda;
import entidades.ComandaProducto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
                System.out.println(comanda.getComandaProductos().get(0).getComanda().getId());
                entityManager.merge(revisarListaProductos(comanda));
                entityManager.getTransaction().commit();
                return comanda;
            }
        }
        return null;
    }

    public Comanda revisarListaProductos(Comanda comanda) {
        for (ComandaProducto comandaProducto : comanda.getComandaProductos()) {
            if (comandaProducto.getComanda() == null) {
                comandaProducto.setComanda(comanda);
            }
        }

        return comanda;
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

    public List<Comanda> consultarComandas() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM Comanda a WHERE a.estadoAbierta=true", Comanda.class).getResultList();
        return comandas;
    }

    public List<Comanda> consultarComandasAbiertasCerradas(int tipoComanda) {
        String query;
        query = switch (tipoComanda) {
            case 0 -> "SELECT c FROM ComandaPedido c";
            case 1 -> "SELECT c FROM ComandaMesa c";
            case 2 -> "SELECT c FROM ComandaExpress c";
            case 5 -> "SELECT c FROM Comanda c";
            default -> "SELECT c FROM Comanda c";
        }; 
        TypedQuery<Comanda> typedQuery = entityManager.createQuery(query, Comanda.class);
        List<Comanda> comandas = typedQuery.getResultList();
        return comandas;
    }

    public List<Comanda> consultarComandasExpress() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaExpress a", Comanda.class).getResultList();
        return comandas;
    }

    public List<Comanda> consultarComandasMesa() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaMesa a WHERE a.estadoAbierta=true", Comanda.class).getResultList();
        return comandas;
    }

    public List<Comanda> consultarComandasPedido() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM ComandaPedido a WHERE a.estadoAbierta=true", Comanda.class).getResultList();
        return comandas;
    }

    public List<Comanda> consultarComandasCerradas() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM Comanda a WHERE a.estadoAbierta=false", Comanda.class).getResultList();
        return comandas;

    }

    public List<Comanda> consultarComandasEliminadas() {
        List<Comanda> comandas = entityManager.createQuery("SELECT a FROM Comanda a WHERE a.estadoAbierta=3", Comanda.class).getResultList();
        return comandas;

    }

}
