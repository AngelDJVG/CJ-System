/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dto.ComandaProductoDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author
 */
public class VistaReporte {
    
    private static final String NOMBRE_ARCHIVO_REPORTE = "reporte.pdf";
    
    public static void generarReporte(List<ComandaProductoDTO> productos,
            Calendar inicio, Calendar fin) {
        StringBuilder mensaje = new StringBuilder("");
        mensaje.append("Reporte de Ventas\n");
        if(inicio!=null&&fin!=null){
            mensaje.append("Periodo: ");
            mensaje.append(formatearFecha(inicio));
            mensaje.append(" a ");
            mensaje.append(formatearFecha(fin));
            mensaje.append("\n");
        }
        mensaje.append("Carnitas Jacarandas\n");
        mensaje.append("Cd. Obregón, Son.\n");
        mensaje.append("--------------------------------------------------------------\n");
        mensaje.append(String.format("%-8s%-15s%-8s\n","CANT.","PRODUCTO", "TOTAL"));
        mensaje.append("--------------------------------------------------------------\n");
        double totalVendido = 0;
        for (ComandaProductoDTO producto : productos) {
            totalVendido+=producto.getTotal();
            mensaje.append(producto.toString());
            mensaje.append("\n");
        }
        mensaje.append("--------------------------------------------------------------\n");
        mensaje.append("Total vendido:$").append(String.valueOf(totalVendido));
        imprimirReporte(mensaje.toString());
    }

    private static void imprimirReporte(String contenido){
        generarPDF(contenido);
        abrirPDF();
    }
    
    private static void generarPDF(String contenido){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(NOMBRE_ARCHIVO_REPORTE));
            document.open();
            Font font = new Font(Font.FontFamily.COURIER, 14);
            Paragraph paragraph = new Paragraph(contenido, font);
            document.add(paragraph);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void abrirPDF(){
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + NOMBRE_ARCHIVO_REPORTE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String obtenerFechaActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaActual = new Date();
        return formatoFecha.format(fechaActual);
    }
    
    private static String formatearFecha(Calendar fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaFormateada = new Date(fecha.getTimeInMillis());
        return formatoFecha.format(fechaFormateada);
    }
    
}