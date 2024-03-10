/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import view.FrmComandas;
import view.FrmRegistroComanda;

/**
 *
 * @author 
 */
public class Mediador {
    
    private static FrmComandas frmComandas;
    private static FrmRegistroComanda frmRegistroComanda;
    
    public static void abrirFrmComandas(){
        frmComandas = new FrmComandas();
        frmComandas.setVisible(true);
    }
    
    public static void cerrarFrmComandas(){
        frmComandas.dispose();
    }
    
    public static void abrirFrmRegistroComanda(){
        frmRegistroComanda = new FrmRegistroComanda();
        frmRegistroComanda.setVisible(true);
    }
    
    public static void cerrarFrmRegistroComanda(){
        frmRegistroComanda.dispose();
    }
    
}
