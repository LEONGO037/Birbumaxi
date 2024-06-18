package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;

import conexionBase.conexionBD;

public class ReporteVentas extends ReportePapa{
	public ReporteVentas() {
		super();
	}
	
	@Override
	public void addTableCell(PdfPTable table, String text) {
		// TODO Auto-generated method stub
		super.addTableCell(table, text);
	}
	
	@Override
	public void addTableHeader(PdfPTable table, Font font, String text) {
		// TODO Auto-generated method stub
		super.addTableHeader(table, font, text);
	}
	
	@Override
	public String Fechita() {
		// TODO Auto-generated method stub
		return super.Fechita();
	}
	
	@Override
	public String horita() {
		// TODO Auto-generated method stub
		return super.horita();
	}
	
	public ArrayList<DatosVentas> obtenerDatos (LocalDate inicio, LocalDate fin){
		ArrayList<DatosVentas> inv = new ArrayList<>();
		String consulta = "SELECT productos.nombre, productos.precio_compra, pedidosReporte.fecha, pedidosReporte.cantidad " +
                "FROM productos, pedidosReporte " +
                "WHERE productos.ID_producto = pedidosReporte.id_producto " +
                "AND (pedidosReporte.fecha >= ? AND pedidosReporte.fecha <= ?)"
                + "ORDER BY pedidosReporte.fecha;";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			ps.setString(1, inicio.format(DateTimeFormatter.ISO_LOCAL_DATE));
			ps.setString(2, fin.format(DateTimeFormatter.ISO_LOCAL_DATE));
			rs=ps.executeQuery();
			int num = 1;
			while(rs.next()) {
				String nombre = rs.getString("nombre");
                double precioCompra = rs.getDouble("precio_compra");
                Date fecha = rs.getDate("fecha");
                LocalDate fechaLocal = fecha.toLocalDate();
                fechaLocal = fechaLocal.plusDays(1);
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaActualStr = fechaLocal.format(formato);
                int cantidad = rs.getInt("cantidad");
                double total = precioCompra * cantidad;
                DatosVentas ped = new DatosVentas(num, nombre, "", "", 0.0);
                inv.add(ped);
				num++;
			}
		}catch(Exception e) {
			
		}
		return inv;
	}
}
