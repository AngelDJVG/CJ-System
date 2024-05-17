/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.Comanda;
import enums.TiposComanda;
import java.awt.Component;
import javax.swing.JOptionPane;
import view.FrmAdministrarComandas;
import view.FrmAdministrarProductos;
import view.FrmComandas;
import view.FrmEditarComanda;
import view.FrmPrincipal;
import view.FrmRegistroComanda;
import view.FrmReporteVentas;

/**
 *
 * @author 
 */
public class Mediador {
    
    private static FrmComandas frmComandas;
    private static FrmRegistroComanda frmRegistroComanda;
    private static FrmEditarComanda frmEditarComanda;
    private static FrmAdministrarComandas frmAdministrarComandas;
    private static FrmPrincipal frmPrincipal;
    private static FrmReporteVentas frmReporteVentas;
    private static FrmAdministrarProductos frmAdministrarProductos;
    public static Control control = new Control();
    
    public static void abrirFrmComandas(){
        frmComandas = new FrmComandas();
        frmComandas.setVisible(true);
    }
    
    public static void cerrarFrmComandas(){
        frmComandas.dispose();
    }
    
    public static void abrirFrmProductos(){
        frmAdministrarProductos = new FrmAdministrarProductos();
        frmAdministrarProductos.setVisible(true);
    }
    public static void cerrarFrmProductos(){
        frmAdministrarProductos.setVisible(false);
    }
    
    public static void cerrarFrmAdministrarComandas(){
      frmAdministrarComandas.dispose();
    }
    public static void abrirFrmRegistroComanda(){
        frmRegistroComanda = new FrmRegistroComanda();
        frmRegistroComanda.setVisible(true);
    }
    public static void abrirFrmEditarComanda(int tipoComanda,Comanda comanda){
        control.agregarProductosComanda(comanda.getComandaProductos());
        frmEditarComanda = new FrmEditarComanda(tipoComanda,comanda);
        frmEditarComanda.setVisible(true);
    }
    public static void abrirFrmAdministrarComanda(int tipoComanda){
       
        frmAdministrarComandas = new FrmAdministrarComandas(control.obtenerTablaComandas(tipoComanda),tipoComanda);
        frmAdministrarComandas.setVisible(true);
    }
    
    public static void abrirFrmPrincipal(){
        frmPrincipal = new FrmPrincipal();
        frmPrincipal.setVisible(true);
    }
    
    public static void abrirFrmReporteVentas(){
        frmReporteVentas = new FrmReporteVentas(control);
        frmReporteVentas.setVisible(true);
    }
    
    
    public static FrmRegistroComanda obtenerFrmRegistroComanda(){
        return frmRegistroComanda;
    }
    
    public static void cerrarFrmRegistroComanda(){
        frmRegistroComanda.dispose();
    }
    
    public static void mostrarOptionPaneError(Component component, String mensaje){
        JOptionPane.showMessageDialog(component, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrarOptionPaneAviso(Component component, String mensaje){
        JOptionPane.showMessageDialog(component, mensaje, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mostrarOptionPaneExito(Component component, String mensaje){
        JOptionPane.showMessageDialog(component, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
