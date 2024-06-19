package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexionBase.conexionBD;

public class ClienteFactura extends persona{
	
	public int nit;
	
	@Override
	public void setCorreo(String correo) {
		// TODO Auto-generated method stub
		super.setCorreo(correo);
	}
	
	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}
	
	public void setNit(int nit) {
		this.nit = nit;
	}
	
	@Override
	public String getCorreo() {
		// TODO Auto-generated method stub
		return super.getCorreo();
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}
	
	public int getNit() {
		return nit;
	}
	
	public ClienteFactura(String nombre, String correo, int nit) {
		super(nombre, correo);
		this.nit = nit;
	}
	
	public void agregarFactura (int idFac, int metPago) {
		String consulta = "update factura set persona_id_persona = " + nit + ", metodo_pago = " + metPago + " where id_factura = " + idFac + ";";
		String habilitar = "SET FOREIGN_KEY_CHECKS = 0;"; 
		String desHabilitar = "SET FOREIGN_KEY_CHECKS = 1;";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps = conn.prepareStatement(habilitar);
			ps.executeQuery();
			ps=conn.prepareStatement(consulta);
			int actualizado = ps.executeUpdate();
			if(actualizado > 0) {
				System.out.println("Actualizado con exito");
			} else {
				System.out.println("No se pudo actualizar");
			}
			ps = conn.prepareStatement(desHabilitar);
			ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ingresarClienteNuevo () {
		String consulta= super.ingresar();
		consulta += " persona (nombre, NIT, correo_electronico) values ('" + nombre + "', " + nit + ", '" + correo + "');";
		System.out.println(consulta);
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			int aniadido = ps.executeUpdate();
			if(aniadido > 0) {
				System.out.println("Agregado con exito");
			} else {
				System.out.println("no se pudo agregar");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean buscarCliente () {
		ArrayList<Integer> nits = new ArrayList<>();
		String consulta= "SELECT nit from persona;";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("nit");
				nits.add(num);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(nits.contains(nit)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void datosEncontrados (){
		String consulta= "SELECT nombre, correo_electronico from persona where nit = " + nit + ";";
		conexionBD conec= new conexionBD();
		Connection conn= conec.conexion();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=conn.prepareStatement(consulta);
			rs=ps.executeQuery();
			while(rs.next()) {
				String nombreI = rs.getString("nombre");
				String correoI = rs.getString("correo_electronico");
				setNombre(nombreI);
				setCorreo(correoI);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
