/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import dto.ComandaProductoDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 
 */
public class ControlComandaProducto {
    
    private FachadaDAO fachadaDAO;
    
    public ControlComandaProducto(FachadaDAO fachadaDAO){
        this.fachadaDAO = fachadaDAO;
    }
    
    public List<ComandaProductoDTO> consultarProductosVendidos(Calendar fechaInicio, Calendar fechaFin, int tipoComanda) {
        return fachadaDAO.consultarProductosVendidos(fechaInicio, fechaFin, tipoComanda);
    }
    
}
