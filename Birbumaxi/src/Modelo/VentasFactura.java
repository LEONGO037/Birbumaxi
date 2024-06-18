package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexionBase.conexionBD;

public class VentasFactura {
	
	public VentasFactura() {
		// TODO Auto-generated constructor stub
	}
	
	public int RealizarVenta(ArrayList<String>productos, ArrayList<Double>Cantidad) {
		String consulta= "INSERT INTO factura (metodo_pago, persona_id_persona, total, fecha) values (1, 1, 0.0,now())";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;

		int facturaID = 0;
		try {
			ps=conn.prepareStatement(consulta);
			ps.executeUpdate();
			String obtenerIDF = "SELECT id_factura from factura where total = 0.0";
			ps = conn.prepareStatement(obtenerIDF);
			rs=ps.executeQuery();
			while(rs.next()) {
				facturaID = rs.getInt("id_factura");
			}
			double totalEsteSi = 0.0;
			System.out.println("size cantidad" + Cantidad.size());
			System.out.println("size productos" + productos.size());
			for(int i = 0; i < productos.size(); i++) {
				String p = productos.get(i);
				System.out.println("Producto " + p);
				System.out.println("Cantidad " + Cantidad.get(i));
			}
			for(int i = 0; i < productos.size(); i++) {
				String p = productos.get(i);
				System.out.println("Producto " + p);
				System.out.println("Cantidad " + Cantidad.get(i));
				String idP = "SELECT ID_producto, precio_venta from productos where ID_producto = '" + p + "';";
				ps = conn.prepareStatement(idP);
				rs=ps.executeQuery();
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
				ps = conn.prepareStatement(compras);
				ps.executeUpdate();
				System.out.println("Parte final");
			}
			
			String actualizarFactura = "UPDATE factura SET total = " + totalEsteSi + "WHERE id_factura = "+facturaID+";";
			ps = conn.prepareStatement(actualizarFactura);
			ps.executeUpdate();
			
		}catch(Exception e) {
			
		}
		
		return facturaID;
	}
}
