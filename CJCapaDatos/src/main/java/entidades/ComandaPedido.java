
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Ángel ñ
 */
@Entity
@Table(name = "comandas_pedidos")
@PrimaryKeyJoinColumn(name = "id_comanda_pedido")
public class ComandaPedido extends Comanda implements Serializable{

    public ComandaPedido() {
    }

    public ComandaPedido(Long id, Calendar fecha) {
        super(id, fecha);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComandaPedido)) {
            return false;
        }
        ComandaPedido other = (ComandaPedido) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComandaPedido[ id=" + this.getId() + " ]";
    }

}
