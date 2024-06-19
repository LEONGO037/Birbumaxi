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
	
	public int RealizarVenta() {
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
	public int posicion(int p) {
		int posicion=0;
		for(int i=0; i<productos.size();i++) {
			if(String.valueOf(p).equals(productos.get(i))){
				posicion=i;
			}
		}
		return posicion;
	}
	public void CantidadesMod(int p) {
		int posicion=posicion(p);
		String sql= "SELECT tipo from productos WHERE id_producto="+p+";";
		conexionBD conec = new conexionBD();
		PreparedStatement ps= null;
		ResultSet rs= null;
		String tipo="";
		Connection conn = conec.conexion();
		double valorAnt=0;
		valorAnt=Cantidad.get(posicion);
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				tipo=rs.getString("tipo");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		if(tipo.equals("1")) {
			Cantidad.set(posicion, (double) Math.round(valorAnt));
		}else if(tipo.equals("2")) {
			Cantidad.set(posicion, valorAnt);
		}
	}
}
