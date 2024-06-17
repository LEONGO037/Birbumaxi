package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botonReportes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGerente frame = new MenuGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuGerente() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\Imagengerente.jpg"));
		lblNewLabel_1.setBounds(609, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MENU GERENTE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 54));
		lblNewLabel_2.setBounds(84, 114, 468, 192);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
		lblNewLabel.setBounds(122, 0, 330, 200);
		contentPane.add(lblNewLabel);
		
		JButton botonRealizarPedido = new JButton("Realizar Pedido");
		botonRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos pedido = new Pedidos();
				pedido.setVisible(true);
				dispose();
			}
		});
		botonRealizarPedido.setForeground(Color.WHITE);
		botonRealizarPedido.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonRealizarPedido.setFocusPainted(false);
		botonRealizarPedido.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonRealizarPedido.setBackground(new Color(21, 101, 192));
		botonRealizarPedido.setBounds(74, 259, 422, 64);
		contentPane.add(botonRealizarPedido);
		
		JButton botonSimularVentas = new JButton("Simular Ventas");
		botonSimularVentas.setForeground(Color.WHITE);
		botonSimularVentas.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonSimularVentas.setFocusPainted(false);
		botonSimularVentas.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonSimularVentas.setBackground(new Color(21, 101, 192));
		botonSimularVentas.setBounds(74, 323, 422, 64);
		contentPane.add(botonSimularVentas);
		
		botonReportes = new JButton("Reportes");
		botonReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes reportes = new Reportes();
				reportes.setVisible(true);
				dispose();
			}
		});
		botonReportes.setForeground(Color.WHITE);
		botonReportes.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonReportes.setFocusPainted(false);
		botonReportes.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonReportes.setBackground(new Color(21, 101, 192));
		botonReportes.setBounds(74, 386, 422, 64);
		contentPane.add(botonReportes);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log = new login();
				log.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnCerrarSesion.setBackground(new Color(21, 101, 192));
		btnCerrarSesion.setBounds(74, 603, 143, 39);
		contentPane.add(btnCerrarSesion);
		
		JButton botonContratar = new JButton("Contratar personal");
		botonContratar.setForeground(Color.WHITE);
		botonContratar.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonContratar.setFocusPainted(false);
		botonContratar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonContratar.setBackground(new Color(21, 101, 192));
		botonContratar.setBounds(74, 448, 422, 64);
		contentPane.add(botonContratar);
		
		JButton botonAdmEmpleados = new JButton("Administrar Personal");
		botonAdmEmpleados.setForeground(Color.WHITE);
		botonAdmEmpleados.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonAdmEmpleados.setFocusPainted(false);
		botonAdmEmpleados.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonAdmEmpleados.setBackground(new Color(21, 101, 192));
		botonAdmEmpleados.setBounds(74, 512, 422, 64);
		contentPane.add(botonAdmEmpleados);
	}

}
