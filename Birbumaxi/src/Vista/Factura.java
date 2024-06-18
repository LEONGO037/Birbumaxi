package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Factura extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombre;
    private JTextField nitci;
    private JTextField correo;
    private JTable detalleFactura;

    public Factura() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 995, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel sucursal = new JLabel("Sucursal #1");
        sucursal.setBounds(10, 10, 101, 29);
        sucursal.setForeground(Color.WHITE);
        sucursal.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        contentPane.add(sucursal);

        JLabel avenida = new JLabel("Av. Hernando Siles");
        avenida.setForeground(Color.WHITE);
        avenida.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        avenida.setBounds(10, 33, 223, 29);
        contentPane.add(avenida);

        JLabel calle = new JLabel("Calle 3 de Obrajes");
        calle.setForeground(Color.WHITE);
        calle.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        calle.setBounds(10, 59, 223, 29);
        contentPane.add(calle);

        JLabel telefono = new JLabel("Telefono: 72036743");
        telefono.setForeground(Color.WHITE);
        telefono.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        telefono.setBounds(10, 87, 244, 29);
        contentPane.add(telefono);

        JLabel ciudad = new JLabel("La Paz - Bolivia");
        ciudad.setForeground(Color.WHITE);
        ciudad.setFont(new Font("Roboto Medium", Font.BOLD, 14));
        ciudad.setBounds(10, 115, 244, 29);
        contentPane.add(ciudad);

        JLabel lblFactura = new JLabel("FACTURA");
        lblFactura.setForeground(Color.WHITE);
        lblFactura.setFont(new Font("Roboto Black", Font.BOLD, 77));
        lblFactura.setBounds(288, 87, 417, 140);
        contentPane.add(lblFactura);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo220x150.png"));
        lblNewLabel.setBounds(751, 10, 220, 150);
        contentPane.add(lblNewLabel);

        JLabel lblnitci = new JLabel("NIT/CI:");
        lblnitci.setForeground(Color.WHITE);
        lblnitci.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblnitci.setBounds(43, 219, 120, 29);
        contentPane.add(lblnitci);

        JLabel lblnombre = new JLabel("Nombre/Razon Social:");
        lblnombre.setForeground(Color.WHITE);
        lblnombre.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblnombre.setBounds(43, 258, 211, 29);
        contentPane.add(lblnombre);

        nombre = new JTextField();
        nombre.setForeground(new Color(0, 0, 0));
        nombre.setFont(new Font("Roboto Light", Font.BOLD, 18));
        nombre.setBounds(252, 260, 254, 29);
        contentPane.add(nombre);
        nombre.setColumns(10);

        nitci = new JTextField();
        nitci.setForeground(new Color(0, 0, 0));
        nitci.setFont(new Font("Roboto Light", Font.BOLD, 18));
        nitci.setBackground(new Color(255, 255, 255));
        nitci.setColumns(10);
        nitci.setBounds(122, 219, 183, 29);
        contentPane.add(nitci);

        String[] metodos = { "Tarjeta", "Efectivo" };
        JComboBox<String> metodoPago = new JComboBox<>(metodos);
        metodoPago.setFont(new Font("Roboto Light", Font.BOLD, 18));
        metodoPago.setBackground(new Color(13, 71, 170));
        metodoPago.setBounds(689, 258, 254, 29);
        contentPane.add(metodoPago);

        JLabel lblmetodo = new JLabel("Metodo de pago:");
        lblmetodo.setForeground(Color.WHITE);
        lblmetodo.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblmetodo.setBounds(689, 219, 211, 29);
        contentPane.add(lblmetodo);

        JLabel lblcorreo = new JLabel("Correo Electronico:");
        lblcorreo.setForeground(Color.WHITE);
        lblcorreo.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblcorreo.setBounds(43, 299, 211, 29);
        contentPane.add(lblcorreo);

        correo = new JTextField();
        correo.setForeground(new Color(0, 0, 0));
        correo.setFont(new Font("Roboto Light", Font.BOLD, 18));
        correo.setColumns(10);
        correo.setBounds(252, 301, 254, 29);
        contentPane.add(correo);

        JLabel lblma = new JLabel("Monto a pagar:");
        lblma.setForeground(Color.WHITE);
        lblma.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblma.setBounds(43, 583, 138, 29);
        contentPane.add(lblma);

        JTextArea costo = new JTextArea();
        costo.setForeground(new Color(255, 255, 255));
        costo.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        costo.setBackground(new Color(255, 128, 0));
        costo.setBounds(178, 584, 177, 29);
        contentPane.add(costo);

        JLabel lblmp = new JLabel("Monto pagado: ");
        lblmp.setForeground(Color.WHITE);
        lblmp.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        lblmp.setBounds(43, 622, 138, 29);
        contentPane.add(lblmp);

        JTextArea montop = new JTextArea();
        montop.setForeground(new Color(255, 255, 255));
        montop.setFont(new Font("Roboto Medium", Font.BOLD, 18));
        montop.setBackground(new Color(255, 128, 0));
        montop.setBounds(178, 623, 177, 29);
        contentPane.add(montop);

        JButton btnCerrarSesion = new JButton("Atras");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Ventas venta = new Ventas();
        		venta.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 25));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnCerrarSesion.setBackground(new Color(21, 101, 192));
        btnCerrarSesion.setBounds(491, 589, 202, 46);
        contentPane.add(btnCerrarSesion);

        JButton btnFacturar = new JButton("Facturar");
        btnFacturar.setForeground(Color.WHITE);
        btnFacturar.setFont(new Font("Roboto Medium", Font.BOLD, 25));
        btnFacturar.setFocusPainted(false);
        btnFacturar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnFacturar.setBackground(new Color(21, 101, 192));
        btnFacturar.setBounds(741, 589, 202, 46);
        contentPane.add(btnFacturar);

        // Crear la tabla para el detalle de la factura
        detalleFactura = new JTable();
        detalleFactura.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre", "Cantidad", "Precio Unitario", "Subtotal" }
        ));
        JScrollPane scrollPane = new JScrollPane(detalleFactura);
        scrollPane.setBounds(43, 341, 900, 232);
        contentPane.add(scrollPane);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Factura frame = new Factura();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
 