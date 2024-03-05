
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author JGlam
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {

    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;
    
    @OneToMany(mappedBy = "mesa")
    private List<ComandaMesa> comandas;
    
    public Mesa() {
    }

    public Mesa(Long numero) {
        this.numero = numero;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += numero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        return this.numero == other.numero;
    }

    @Override
    public String toString() {
        return "entidades.Mesa[ numero=" + numero + " ]";
    }
}

