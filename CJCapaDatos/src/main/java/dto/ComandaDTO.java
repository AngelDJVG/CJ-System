/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Calendar;

/**
 *
 * @author Angel
 */
public class ComandaDTO {
    private int tipoComanda;
    private Calendar desde;
    private Calendar hasta;
    private String nombreProducto;

    public int getTipoComanda() {
        return tipoComanda;
    }

    public void setTipoComanda(int tipoComanda) {
        this.tipoComanda = tipoComanda;
    }

    public Calendar getDesde() {
        return desde;
    }

    public void setDesde(Calendar desde) {
        this.desde = desde;
    }

    public Calendar getHasta() {
        return hasta;
    }

    public void setHasta(Calendar hasta) {
        this.hasta = hasta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombre) {
        this.nombreProducto = nombre;
    }
}