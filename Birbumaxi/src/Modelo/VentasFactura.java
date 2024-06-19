package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexionBase.conexionBD;

public class VentasFactura {
	public ArrayList<Double>Cantidad;
	public ArrayList<String>productos;
	public VentasFactura(ArrayList<Double>Cantidad, ArrayList<String>productos) {
		this.Cantidad=Cantidad;
		this.productos=productos;
	}
	
	public int RealizarVenta(String fechaa) {
		String consulta= "INSERT INTO factura (metodo_pago, persona_id_persona, total, fecha) values (1, 1, 0.0," + fechaa + ")";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;

		int facturaID = 0;
		try {
			ps=conn.prepareStatement(consulta);
			ps.executeUpdate();
			String obtenerIDF = "SELECT id_factura from factura where total = 0.0";
			PreparedStatement ps1= null;
			ps1 = conn.prepareStatement(obtenerIDF);
			rs=ps1.executeQuery();
			while(rs.next()) {
				facturaID = rs.getInt("id_factura");
			}
			double totalEsteSi = 0.0;
			
			for(int i = 0; i < productos.size(); i++) {
				String p = productos.get(i);
				String idP = "SELECT ID_producto, precio_venta from productos where ID_producto = '" + p + "';";
				PreparedStatement ps2= null;
				ps2 = conn.prepareStatement(idP);
				rs=ps2.executeQuery();
				int productoid = 0;
				double precio = 0.0;
				while(rs.next()) {
					productoid = rs.getInt("ID_producto");
					precio = rs.getDouble("precio_venta");
				}
				double cant = Cantidad.get(i);
				double subtotal = cant * precio;
				totalEsteSi += subtotal;
				String compras = "INSERT INTO producto_factura (productos_ID_producto, factura_id_factura, cantidad, subtotal) "
						+ "values(" + productoid + "," + facturaID + "," + cant + "," + subtotal + ");";
				PreparedStatement ps3= null;
				ps3 = conn.prepareStatement(compras);
				ps3.executeUpdate();
			}
			
			String actualizarFactura = "UPDATE factura SET total = " + totalEsteSi + "WHERE id_factura = "+facturaID+";";
			PreparedStatement ps4= null;
			ps4 = conn.prepareStatement(actualizarFactura);
			ps4.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return facturaID;
	}

}
