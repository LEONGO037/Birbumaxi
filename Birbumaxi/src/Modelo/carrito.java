package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexionBase.conexionBD;

public class carrito {
	public DefaultTableModel carritos(String[] columnas, ArrayList<String> producto, ArrayList<Double> cantidad) {
		DefaultTableModel model = new DefaultTableModel(null, columnas);
		
		for(int i=0; i<producto.size(); i++) {
			String consulta= "SELECT ID_producto, nombre, stock, precio_venta, tipo from productos WHERE id_producto="+producto.get(i)+";" ;
			conexionBD conec= new conexionBD();
			Connection conn= conec.conexion();
			int tipo;
			String[] tabla = new String[5];
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
					tipo=Integer.parseInt(rs.getString("tipo"));
					if(tipo==2) {
						tabla[4]= String.valueOf(cantidad.get(i));
					}else if(tipo==1) {
						tabla[4]=String.valueOf(Math.round(cantidad.get(i)));
					}
					
				}
				model.addRow(tabla);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "no se puedo cargar la tabla");
			}
		}
		return model;

	}
	
}

