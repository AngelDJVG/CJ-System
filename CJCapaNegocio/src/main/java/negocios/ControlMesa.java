/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

import dao.FachadaDAO;
import entidades.*;
import java.util.List;

/**
 *
 * @author 
 */
public class ControlMesa {
    private FachadaDAO fachadaDAO;
    
    public ControlMesa(FachadaDAO fachadaDAO){
        this.fachadaDAO = fachadaDAO;
    }
    
    public List<Mesa> consultarMesas(){
        return fachadaDAO.consultarMesas();
    }
    
    public Mesa consultarMesa(Long numeroMesa){
        return fachadaDAO.consultarMesa(numeroMesa);
    }
}
