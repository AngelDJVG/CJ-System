/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Producto;
import entidades.TipoComida;
import java.util.Objects;

/**
 *
 * @author 
 */
public class ComandaProductoDTO {
    
    private Producto producto;
    private Long cantidad;
    private Double total;

    public ComandaProductoDTO(Producto producto, Long cantidad, Double total) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public ComandaProductoDTO() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComandaProductoDTO other = (ComandaProductoDTO) obj;
        return Objects.equals(this.producto, other.producto);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        if(producto.getTipo().equals(TipoComida.BEBIDA)){
            return String.format("%-8d%-15s$%-8.2f", cantidad, producto.getNombre(), total);
        }else{
            return String.format("%-8s%-15s$%-8.2f", "", producto.getNombre(), total);
        }
    }
    
    
    
}
