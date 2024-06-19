package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexionBase.conexionBD;

public class VentasFactura {
	public ArrayList<Double>Cantidad;
	public ArrayList<String>productos;
	public VentasFactura(ArrayList<Double>Cantidad, ArrayList<String>productos) {
		this.Cantidad=Cantidad;
		this.productos=productos;
	}
	
	public int RealizarVenta() {
		String consulta= "INSERT INTO factura (metodo_pago, persona_id_persona, total, fecha) values (1, 1, 0.0,CONVERT_TZ(NOW(), @@global.time_zone, 'America/La_Paz'))";
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
	public DefaultTableModel carritoFactura(String[] columnas) {
	    DefaultTableModel model = new DefaultTableModel(null, columnas);

	    if (Cantidad.size() != productos.size()) {
	        JOptionPane.showMessageDialog(null, "Las listas de productos y cantidades no coinciden en tamaño.");
	        return model;
	    }

	    String id_factura = String.valueOf(RealizarVenta());
	    System.out.println("factura: " + id_factura);

	    String consulta = "SELECT productos.nombre, producto_factura.cantidad, productos.precio_venta, producto_factura.subtotal " +
	                      "FROM productos, producto_factura " +
	                      "WHERE factura_id_factura = ? AND producto_factura.productos_id_producto = productos.id_producto;";

	    conexionBD conec = new conexionBD();
	    Connection conn = conec.conexion();
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = conn.prepareStatement(consulta);
	        ps.setString(1, id_factura);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            String[] tabla = new String[4];
	            tabla[0] = rs.getString("productos.nombre");
	            tabla[1] = rs.getString("producto_factura.cantidad");
	            tabla[2] = rs.getString("productos.precio_venta");
	            tabla[3] = rs.getString("producto_factura.subtotal");

	            model.addRow(tabla);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "No se pudo cargar la tabla: " + e.getMessage());
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, "Error cerrando recursos: " + e.getMessage());
	        }
	    }

	    return model;
	}


}
