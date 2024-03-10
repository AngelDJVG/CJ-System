package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author JGlam
 */
@Entity
@Table(name = "comandas_pedidos")
@PrimaryKeyJoinColumn(name = "id_comanda_pedido")
public class ComandaPedido extends Comanda implements Serializable {

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    public ComandaPedido() {
    }

    public ComandaPedido(String direccion) {
        super(Calendar.getInstance(), false);
        this.direccion = direccion;
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
        return "entidades.ComandaPedido[ id=" + this.getId() + " ] "+this.isEstadoAbierta();
    }

}
