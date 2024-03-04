/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "comandas_mesas")
@PrimaryKeyJoinColumn(name = "id_comanda_mesa")
public class ComandaMesa extends Comanda implements Serializable {


    public ComandaMesa() {
    }

    public ComandaMesa(Long id, Calendar fecha, Mesa mesa) {
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
        if (!(object instanceof ComandaMesa)) {
            return false;
        }
        ComandaMesa other = (ComandaMesa) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ComandaMesa[ id=" + this.getId() + " ]";
    }
    
}
