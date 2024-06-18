package Modelo;

import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import conexionBase.conexionBD;

public class empleado extends persona{
	public int estado;
	public String contrasena;
	public int cargo;
	public String apellido;
	public String ci;
	public double salario;
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public empleado(String nombre, String correo,String contrasena, int cargo, String apellido, String ci, double salario) {
		super(nombre, correo);
		this.contrasena=contrasena;
		this.cargo=cargo;
		this.apellido=apellido;
		this.ci=ci;
		this.salario=salario;
		// TODO Auto-generated constructor stub
	}
	
	public DefaultTableModel desplegarEmpleados(String[] nombresColumnas) {
		
		DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
		conexionBD conec = new conexionBD();
		PreparedStatement ps= null;
		ResultSet rs=null;
		Connection conn=conec.conexion();
		String[] datos = new String[8];
		try {
			ps=conn.prepareStatement("SELECT * from empleados;");
			rs=ps.executeQuery();
			while(rs.next()) {
				datos[0]= rs.getString("ID_empleado");
				datos[1]=rs.getString("nombre");
				datos[2]=rs.getString("apellido");
				datos[3]= rs.getString("ci");
				datos[4]=rs.getString("correo");
				datos[5]=rs.getString("contrasenia");
				datos[6]=rs.getString("cargo");
				datos[7]=rs.getString("estado");
			}
			modelo.addRow(datos);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "NO SE PUDO CARGAR LA TABLA");
		}
		return modelo;
		
	}
	public boolean despedir(String palabraClave) { //para buscar por id o por nombre
		String sql= "SELECT estado from empleados WHERE nombre LIKE %'"+palabraClave+"'% OR id_empleado LIKE %'"+palabraClave+"'%;";
		String sql2= "UPDATE empleados SET estado=false WHERE nombre ='"+palabraClave +"' OR id_empleado ="+palabraClave+";";
		PreparedStatement ps=null;
		ResultSet rs= null;
		conexionBD conec= new conexionBD();
		Connection conn=conec.conexion();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				ps=conn.prepareStatement(sql2);
				int i=ps.executeUpdate();
				if(i>0) {
					return true;
				}else {
					return false;
				}
				
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	public boolean contratar() {
		String sql= "INSERT INTO empleados (estado, correo, contrasenia, cargo, nombre, apellido, ci ) VALUES (true,'"+correo+"', '"+contrasena+"', "+cargo+",'"+nombre+"','"+apellido+"','"+ci+"',"+salario+";"; 
		PreparedStatement ps=null;
		ResultSet rs= null;
		conexionBD conec= new conexionBD();
		Connection conn=conec.conexion();
		try {
			ps=conn.prepareStatement(sql);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
