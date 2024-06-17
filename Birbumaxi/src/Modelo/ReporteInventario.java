package Modelo;

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

import java.awt.Desktop;
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

public class ReporteInventario {
	public static void main(String[] args) {
        String dest = "reporte.pdf";
        
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
            
            ArrayList<DatosInventario> inv = new ArrayList<>();
            inv = obtenerDatos();
            
            for(DatosInventario d : inv) {
            	addTableCell(table, d.getCategoria());
                addTableCell(table, "" + d.getNumero());
                addTableCell(table, d.getNombre());
                addTableCell(table, "" + d.getStock());
            }
            
            
            /*
            addTableCell(table, "1");
            addTableCell(table, "001");
            addTableCell(table, "Producto A");
            addTableCell(table, "10");

            addTableCell(table, "2");
            addTableCell(table, "002");
            addTableCell(table, "Producto B");
            addTableCell(table, "20");

            addTableCell(table, "3");
            addTableCell(table, "003");
            addTableCell(table, "Producto C");
            addTableCell(table, "30");
            
            addTableCell(table, "4");
            addTableCell(table, "004");
            addTableCell(table, "Producto D");
            addTableCell(table, "40");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	private static ArrayList<DatosInventario> obtenerDatos (){
		ArrayList<DatosInventario> inv = new ArrayList<>();
		String consulta= "SELECT nombre, stock, categoria from productos ORDER BY categoria;";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			int num = 1;
			String[] cat = {"","Frutas","Verduras","Carnes","Lacteos","Cereales","Dulces","Limpieza","Aseo Personal"};
			while(rs.next()) {
				int c = Integer.parseInt(rs.getString("categoria"));
				String categoria = cat[c];
				String nombre = rs.getString("nombre");
				double stock = Double.parseDouble(rs.getString("stock"));
				DatosInventario datos = new DatosInventario(categoria, num, nombre, stock);
				inv.add(datos);
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
