/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author JGlam
 */
@Entity
@Table(name = "comandas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comanda implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha;
    
    @OneToOne(mappedBy = "comanda")
    private Movimiento movimiento;
    
    @Column(name = "estadoAbierta", nullable = false)
    private boolean estadoAbierta;
    
    @ManyToMany
    @JoinTable(
        name = "comanda_producto",
        joinColumns = @JoinColumn(name = "id_comanda"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos;
    
    public Comanda() {
    }

    public Comanda(Long id, Calendar fecha, boolean estadoAbierta) {
        this.id = id;
        this.fecha = fecha;
        this.estadoAbierta = estadoAbierta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public boolean isEstadoAbierta() {
        return estadoAbierta;
    }

    public void setEstadoAbierta(boolean estadoAbierta) {
        this.estadoAbierta = estadoAbierta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comanda)) {
            return false;
        }
        Comanda other = (Comanda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comanda[ id=" + id + " ]";
    }

}
