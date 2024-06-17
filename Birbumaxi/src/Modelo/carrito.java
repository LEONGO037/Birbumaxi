package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexionBase.conexionBD;

public class carrito {
	public DefaultTableModel carritos(String[] columnas, String producto) {
		DefaultTableModel model = new DefaultTableModel(null, columnas);
		
		String consulta= "SELECT ID_producto, nombre, stock, precio_venta from productos WHERE nombre='"+producto+"';" ;
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		String[] tabla = new String[4];
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				tabla[0]= rs.getString("id_producto");
				tabla[1]= rs.getString("nombre");
				tabla[2]= rs.getString("stock");
				tabla[3]= rs.getString("precio_venta");
				model.addRow(tabla);
			}
			return model;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "no se puedo cargar la tabla");

		}
		return model;
	}
}

