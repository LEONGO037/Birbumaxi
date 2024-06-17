package Modelo;

public class DatosInventario {
	public String categoria;
	public int numero;
	public String nombre;
	public double stock;
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setStock(double stock) {
		this.stock = stock;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public double getStock() {
		return stock;
	}
	
	public DatosInventario (String categoria, int numero, String nombre, double stock) {
		this.categoria = categoria;
		this.numero = numero;
		this.nombre = nombre;
		this.stock = stock;
	}
}
