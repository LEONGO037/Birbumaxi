package Modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import conexionBase.conexionBD;

public class productos {
	public boolean IngresoProducto(String nombre, int tipo, double stock, double precioCompra, double precioVenta, int categoria, String proveedor, String telefono) {
		String sql = "INSERT INTO productos (nombre, tipo, stock, precio_compra, precio_venta, categoria) VALUES (?, ?, ?, ?, ?, ?)";
		String sql2 = "SELECT id_producto FROM productos WHERE nombre=? AND categoria=?";
		String sql3 ="INSERT INTO pedidos (id_producto, nombre_P, telefono) VALUES (?, ?, ?);";
		conexionBD conec= new conexionBD();
		ResultSet rs= null;
		PreparedStatement ps= null;
		Connection conn= conec.conexion();
		ResultSet rs1= null;
		PreparedStatement ps1= null;
		ResultSet rs2= null;
		PreparedStatement ps2= null;
		
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setInt(2, tipo);
			ps.setDouble(3, stock);
			ps.setDouble(4, precioCompra);
			ps.setDouble(5, precioVenta);
			ps.setInt(6, categoria);
			int i=ps.executeUpdate();
			if(i>0) {
				ps1=conn.prepareStatement(sql2);
				ps1.setString(1, nombre);
				ps1.setInt(2, categoria);
				rs1=ps1.executeQuery();
				if(rs1.next()) {
					String id=rs1.getString("id_producto");
					ps2=conn.prepareStatement(sql3);
					ps2.setString(1, id);
					ps2.setInt(2, Integer.parseInt(proveedor));
					ps2.setInt(3, Integer.parseInt(telefono));
					int j=ps2.executeUpdate();
					if(j>0) {
						return true;
					}else {
						return false;
					}
				}else {
					JOptionPane.showMessageDialog(null, "No se encontro el id");
				}
				
			}else {
				return false;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo ingresar el producto");
		}finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	            System.out.println("conexiones cerradas");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
		return false;
		
	}
}
