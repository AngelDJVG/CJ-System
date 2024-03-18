/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import entidades.ComandaProducto;
import java.util.List;

public class Validador {

    public boolean contieneProductos(List<ComandaProducto> productos) {
        return !productos.isEmpty();
    }

    public boolean datosPedidoValidos(String direccion, String nombreCliente) {
        if (direccion.isBlank() || nombreCliente.isBlank()) {
            return false;
        }
        if (direccion.length() > 100 || nombreCliente.length() > 100) {
            return false;
        }
        if (soloSimbolosONumeros(direccion)||soloSimbolosONumeros(nombreCliente)) {
            return false;
        }
        return true;
    }

    private boolean soloSimbolosONumeros(String str) {
        return str.matches("[\\p{Punct}\\d]+");
    }

}
