/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author mario
 */
@Entity
@Table(name = "comanda_producto")
public class ComandaProducto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_comanda")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Double total;
    @Column(name = "detalles")
    private String detalles;

    public ComandaProducto() {
    }

    public ComandaProducto(Comanda comanda, Producto producto, Integer cantidad, String detalles) {
        this.comanda = comanda;
        this.producto = producto;
        this.precioVenta = producto.getPrecio();
        this.cantidad = cantidad;
        this.cargarTotal();
        this.detalles = detalles;
    }

    public ComandaProducto(Producto producto, Integer cantidad, String detalles) {
        this.producto = producto;
        this.precioVenta = producto.getPrecio();
        this.cantidad = cantidad;
        this.cargarTotal();
        this.detalles = detalles;
    }

    public void cargarTotal() {
        if (this.producto.getTipo().equals(TipoComida.BEBIDA)) {
            this.total = this.precioVenta * this.cantidad;
        } else {
            this.total = (double) this.cantidad;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComandaProducto)) {
            return false;
        }
        ComandaProducto other = (ComandaProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (producto.getTipo().equals(TipoComida.COMIDA)) {
            return String.format("%.1f %s %s", total,producto.getNombre(),detalles);
        }else{
            return String.format("%.1f %d %s", total,cantidad,producto.getNombre());
        }
    }
    
}
