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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public Reportes() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\Imagenreporte.jpg"));
		lblNewLabel_1.setBounds(610, 0, 372, 663);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
		lblNewLabel.setBounds(118, 10, 330, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("REPORTES\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 54));
		lblNewLabel_2.setBounds(138, 166, 294, 140);
		contentPane.add(lblNewLabel_2);
		
		JButton btnGenerarReporteDe = new JButton("Generar Reporte de Inventario");
		btnGenerarReporteDe.setForeground(Color.WHITE);
		btnGenerarReporteDe.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnGenerarReporteDe.setFocusPainted(false);
		btnGenerarReporteDe.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnGenerarReporteDe.setBackground(new Color(21, 101, 192));
		btnGenerarReporteDe.setBounds(71, 279, 422, 64);
		contentPane.add(btnGenerarReporteDe);
		
		JButton botonReporteDia = new JButton("GENERAR REPORTE");
		botonReporteDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonReporteDia.setForeground(Color.WHITE);
		botonReporteDia.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonReporteDia.setFocusPainted(false);
		botonReporteDia.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonReporteDia.setBackground(new Color(21, 101, 192));
		botonReporteDia.setBounds(71, 516, 422, 64);
		contentPane.add(botonReporteDia);
		
		JButton btnCerrarSesion = new JButton("Atras");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		MenuGerente menuGerente = new MenuGerente();
        		menuGerente.setVisible(true);
        		dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnCerrarSesion.setBackground(new Color(21, 101, 192));
		btnCerrarSesion.setBounds(29, 603, 143, 39);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblNewLabel_3 = new JLabel("REPORTE POR DIA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		lblNewLabel_3.setBounds(173, 370, 275, 30);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto", Font.ITALIC, 15));
		textField.setBounds(71, 460, 189, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ingrese la fecha:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		lblNewLabel_3_1.setBounds(71, 420, 275, 30);
		contentPane.add(lblNewLabel_3_1);
	}
}
