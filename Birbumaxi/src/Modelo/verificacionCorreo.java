package Modelo;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.sql.*;

import conexionBase.conexionBD;

public class verificacionCorreo {
	public ArrayList<String> correos = new ArrayList<>();
	public boolean verificador(String Correo, String contrasena ) {
		String password="";
		String id="";
		int estado;
		conexionBD conec = new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String consulta= "SELECT ID_empleado, estado from empleados WHERE correo='"+Correo+"';";
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			if(rs.next()) {
				id=rs.getString(1);
				estado=Integer.parseInt(rs.getString(2));
				String consulta2= "SELECT contrasenia from empleados where id_empleado="+id+";";
				ps=conn.prepareStatement(consulta2);
				rs=ps.executeQuery();
				if(rs.next()) {
					password=rs.getString(1);
					if(contrasena.equals(password) && estado!=0) {
						return true;
					}else {
						JOptionPane.showMessageDialog(null, "Contraseña incorrecta o la cuenta ya no es valida");
						return false;
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Correo no encontrado!");
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
		return false;
	}
}
