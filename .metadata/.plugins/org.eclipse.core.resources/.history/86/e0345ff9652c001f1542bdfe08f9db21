package Modelo;

import conexionBase.conexionBD;
import java.sql.*;
public class desplegarPorCategoria {
	public String[] datos(int categoria) {
		String consulta= "SELECT ID_producto, nombre, stock, precio_venta from productos WHERE categoria="+categoria+";";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		String[] tabla = new String[4];
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				tabla[0]= rs.getString("ID_producto");
				tabla[1]= rs.getString("nombre");
				tabla[2]= rs.getString("stock");
				tabla[3]= rs.getString("precio_venta");
			}
			return tabla;
		}catch(Exception e) {
			
		}
		return tabla;
	}
}
