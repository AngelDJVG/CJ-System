/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Angel
 */
public class ManejadorFechas {
    
    
    public static String formatearFecha(Calendar fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("d/MMM/yyyy");
        return formatoFecha.format(fecha.getTime());
    }
}
