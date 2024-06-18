package Modelo;

import java.time.LocalDate;

public class PedidosDatos {
	public int numero;
	public String producto;
	public double cantidad;
	public String fecha;
	public double costo;
	
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getProducto() {
		return producto;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public PedidosDatos (int numero, String producto, double cantidad, String fecha, double costo) {
		this.numero = numero;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.costo = costo;
	}
	
}
