package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class Panel6 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nombreproducto;
	private JTextField precioCompra;
	private JTextField precioVenta;
	private JTextField proveedor;
	private JTextField idProducto;

	/**
	 * Create the panel.
	 */
	public Panel6() {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto: ");
		lblNombreDelProducto.setForeground(Color.WHITE);
		lblNombreDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblNombreDelProducto.setBounds(10, 109, 220, 29);
		add(lblNombreDelProducto);
		
		nombreproducto = new JTextField();
		nombreproducto.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		nombreproducto.setColumns(10);
		nombreproducto.setBounds(229, 110, 206, 30);
		add(nombreproducto);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra:");
		lblPrecioDeCompra.setForeground(Color.WHITE);
		lblPrecioDeCompra.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeCompra.setBounds(40, 148, 179, 29);
		add(lblPrecioDeCompra);
		
		precioCompra = new JTextField();
		precioCompra.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioCompra.setColumns(10);
		precioCompra.setBounds(229, 148, 206, 30);
		add(precioCompra);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta:");
		lblPrecioDeVenta.setForeground(Color.WHITE);
		lblPrecioDeVenta.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblPrecioDeVenta.setBounds(61, 189, 158, 29);
		add(lblPrecioDeVenta);
		
		precioVenta = new JTextField();
		precioVenta.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		precioVenta.setColumns(10);
		precioVenta.setBounds(229, 189, 206, 30);
		add(precioVenta);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setForeground(Color.WHITE);
		lblProveedor.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblProveedor.setBounds(106, 229, 113, 29);
		add(lblProveedor);
		
		proveedor = new JTextField();
		proveedor.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		proveedor.setColumns(10);
		proveedor.setBounds(229, 228, 206, 30);
		add(proveedor);
		
		JButton btnPedirNuevoProducto = new JButton("Modificar Producto");
		btnPedirNuevoProducto.setForeground(Color.WHITE);
		btnPedirNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 18));
		btnPedirNuevoProducto.setFocusPainted(false);
		btnPedirNuevoProducto.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnPedirNuevoProducto.setBackground(new Color(21, 101, 192));
		btnPedirNuevoProducto.setBounds(214, 265, 245, 46);
		add(btnPedirNuevoProducto);
		
		String[] productos = {"Frutas", "Verduras", "Lácteos", "Carnes", "Dulces", "Cereales", "Aseo Personal", "Limpieza"};
		JComboBox<String> comboBox = new JComboBox<>(productos);
		comboBox.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		comboBox.setBounds(458, 179, 211, 40);
		add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblCategoria.setBounds(505, 148, 113, 29);
		add(lblCategoria);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 679, 61);
		add(panel);
		
		JLabel lblPedidoDeNuevo = new JLabel("MODIFICACION DE PRODUCTO");
		lblPedidoDeNuevo.setForeground(Color.WHITE);
		lblPedidoDeNuevo.setFont(new Font("Roboto Black", Font.ITALIC, 48));
		panel.add(lblPedidoDeNuevo);
		
		idProducto = new JTextField();
		idProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 21));
		idProducto.setColumns(10);
		idProducto.setBounds(229, 72, 206, 30);
		add(idProducto);
		
		JLabel lblIdDelProducto = new JLabel("ID del Producto:");
		lblIdDelProducto.setForeground(Color.WHITE);
		lblIdDelProducto.setFont(new Font("Roboto Medium", Font.ITALIC, 21));
		lblIdDelProducto.setBounds(64, 71, 166, 29);
		add(lblIdDelProducto);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnBuscar.setBackground(new Color(21, 101, 192));
		btnBuscar.setBounds(481, 84, 158, 46);
		add(btnBuscar);

	}

}
