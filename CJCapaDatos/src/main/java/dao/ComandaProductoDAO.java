/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.ComandaProductoDTO;
import entidades.Comanda;
import entidades.ComandaProducto;
import entidades.Producto;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author
 */
public class ComandaProductoDAO {

    private EntityManager entityManager;

    public ComandaProductoDAO(EntityManager entityManger) {
        this.entityManager = entityManger;
    }

    public List<ComandaProductoDTO> consultarProductosVendidos(Calendar fechaInicio, Calendar fechaFin, int tipoComanda) {
       
        String queryStr = "SELECT p, SUM(cp.cantidad) as cantidad, SUM(cp.total) as total "
                + "FROM ComandaProducto cp "
                + "JOIN cp.comanda c "
                + "JOIN cp.producto p ";
        if (fechaFin != null && fechaInicio != null) {
            queryStr += "WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin ";
        }

        queryStr += queryStr.contains("WHERE")
                ? "AND c.estadoAbierta = false "
                : "WHERE c.estadoAbierta = false ";

        switch (tipoComanda) {
            case 0:
                queryStr += "AND TYPE(c) = ComandaPedido ";
                break;
            case 1:
                queryStr += "AND TYPE(c) = ComandaMesa ";
                break;
            case 2:
                queryStr += "AND TYPE(c) = ComandaExpress ";
                break;
            default:
                ;
                break;
        }

        queryStr += "GROUP BY p";

        Query query = entityManager.createQuery(queryStr);

        if (fechaFin != null && fechaInicio != null) {
            Date sqlFechaInicio = new Date(fechaInicio.getTimeInMillis());
            Date sqlFechaFin = new Date(fechaFin.getTimeInMillis());

            query.setParameter("fechaInicio", sqlFechaInicio, TemporalType.DATE);
            query.setParameter("fechaFin", sqlFechaFin, TemporalType.DATE);
        }

        List<Object[]> results = query.getResultList();
        List<ComandaProductoDTO> productosVendidos = new ArrayList<>();

        for (Object[] result : results) {
            Producto producto = (Producto) result[0];
            Long cantidad = (Long) result[1];
            Double total = (Double) result[2];

            ComandaProductoDTO dto = new ComandaProductoDTO();
            dto.setProducto(producto);
            dto.setCantidad(cantidad);
            dto.setTotal(total);

            productosVendidos.add(dto);
        }

        return productosVendidos;
    }

}
