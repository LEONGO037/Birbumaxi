package Modelo;

import java.awt.Desktop;
import java.beans.PropertyEditor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import conexionBase.conexionBD;

public class ReportePedido {
	
	public static void main(String[] args) {
		GenerarReporte();
	}
	
	
	public static void GenerarReporte() {
        String dest = "ReportePedidos.pdf";
        
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(dest));

            document.open();
            
            String imagePath = "C:\\Documentos\\imag\\logo330x200.png";
            Image imagen = Image.getInstance(imagePath);
            imagen.scaleToFit(100, 100);
            imagen.setAbsolutePosition(10, document.getPageSize().getHeight() - imagen.getScaledHeight() - 10);
            document.add(imagen);

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
            Paragraph title = new Paragraph("Reporte de Inventario", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            Font fechayHora = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL);
            Paragraph fechaReporte = new Paragraph("Fecha: " + Fechita() + "            Hora:" + horita(), fechayHora);
            document.add(fechaReporte);
            
            Paragraph espaciador = new Paragraph(" ");
            espaciador.setSpacingBefore(10);
            document.add(espaciador);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            addTableHeader(table, headerFont, "Categoría");
            addTableHeader(table, headerFont, "Número");
            addTableHeader(table, headerFont, "Nombre");
            addTableHeader(table, headerFont, "Stock");
            
            LocalDate fechaInicio = LocalDate.now().minusDays(1);
            LocalDate fechaFin = LocalDate.now().plusDays(1);
            
            ArrayList<PedidosDatos> inv = new ArrayList<>();
            inv = obtenerDatos(fechaInicio, fechaFin);
            /*
             *  for(PedidosDatos d : inv) {
            	addTableCell(table, d.getCategoria());
                addTableCell(table, "" + d.getNumero());
                addTableCell(table, d.getNombre());
                addTableCell(table, "" + d.getStock());
            }
             */
           

            document.add(table);

            document.close();

            System.out.println("¡Reporte PDF creado exitosamente!");
            
            File pdfFile = new File(dest);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Apertura de archivos no soportada en este sistema.");
                }
            } else {
                System.out.println("El archivo PDF no fue encontrado.");
            }

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	private static String horita () {
		LocalTime ahora = LocalTime.now();
        DateTimeFormatter formato24Horas = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaActual = ahora.format(formato24Horas);
        return horaActual;
	}
	
	private static String Fechita () {
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActualStr = fechaActual.format(formato);
        return fechaActualStr;
	}
	
	private static ArrayList<PedidosDatos> obtenerDatos (LocalDate inicio, LocalDate fin){
		ArrayList<PedidosDatos> inv = new ArrayList<>();
		String consulta = "SELECT productos.nombre, productos.precio_compra, pedidosReporte.fecha, pedidosReporte.cantidad " +
                "FROM productos, pedidosReporte " +
                "WHERE productos.ID_producto = pedidosReporte.id_pedido " +
                "AND (pedidosReporte.fecha >= ? AND pedidosReporte.fecha <= ?)";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			ps.setString(0, inicio.format(DateTimeFormatter.ISO_LOCAL_DATE));
			ps.setString(1, fin.format(DateTimeFormatter.ISO_LOCAL_DATE));
			rs=ps.executeQuery();
			int num = 1;
			while(rs.next()) {
				String nombre = rs.getString("nombre");
                double precioCompra = rs.getDouble("precio_compra");
                java.sql.Date fecha = rs.getDate("fecha");
                int cantidad = rs.getInt("cantidad");
                double total = precioCompra * cantidad;
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio de compra: " + precioCompra);
                System.out.println("Fecha: " + fecha);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("-----");
				num++;
			}
		}catch(Exception e) {
			
		}
		return inv;
	}

    private static void addTableHeader(PdfPTable table, Font font, String text) {
        PdfPCell header = new PdfPCell();
        header.setPhrase(new Phrase(text, font));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header);
    }

    private static void addTableCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(text));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }
}
