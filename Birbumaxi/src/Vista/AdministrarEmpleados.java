package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministrarEmpleados frame = new AdministrarEmpleados();
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
	public AdministrarEmpleados() {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(13, 71, 170));
		panel.setBounds(0, 0, 350, 663);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
		lblNewLabel.setBounds(10, 20, 330, 200);
		panel.add(lblNewLabel);
		
		JButton btnVerPersonal = new JButton("Ver Personal");
		btnVerPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVerPersonal.setForeground(Color.WHITE);
		btnVerPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnVerPersonal.setFocusPainted(false);
		btnVerPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnVerPersonal.setBackground(new Color(21, 101, 192));
		btnVerPersonal.setBounds(0, 230, 350, 44);
		panel.add(btnVerPersonal);
		
		JButton btnContratarPersonal = new JButton("Modificar Personal");
		btnContratarPersonal.setForeground(Color.WHITE);
		btnContratarPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnContratarPersonal.setFocusPainted(false);
		btnContratarPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnContratarPersonal.setBackground(new Color(21, 101, 192));
		btnContratarPersonal.setBounds(0, 273, 350, 44);
		panel.add(btnContratarPersonal);
		
		JButton btnDespedirPersonal = new JButton("Contratar Personal");
		btnDespedirPersonal.setForeground(Color.WHITE);
		btnDespedirPersonal.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnDespedirPersonal.setFocusPainted(false);
		btnDespedirPersonal.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnDespedirPersonal.setBackground(new Color(21, 101, 192));
		btnDespedirPersonal.setBounds(0, 316, 350, 44);
		panel.add(btnDespedirPersonal);
		
		JButton btnDespedirPersonal_1 = new JButton("Despedir Personal");
		btnDespedirPersonal_1.setForeground(Color.WHITE);
		btnDespedirPersonal_1.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		btnDespedirPersonal_1.setFocusPainted(false);
		btnDespedirPersonal_1.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnDespedirPersonal_1.setBackground(new Color(21, 101, 192));
		btnDespedirPersonal_1.setBounds(0, 358, 350, 44);
		panel.add(btnDespedirPersonal_1);
		
		JButton botonCereales = new JButton("Cereales");
		botonCereales.setForeground(Color.WHITE);
		botonCereales.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonCereales.setFocusPainted(false);
		botonCereales.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonCereales.setBackground(new Color(21, 101, 192));
		botonCereales.setBounds(0, 400, 350, 44);
		panel.add(botonCereales);
		
		JButton botonDulces = new JButton("Dulces");
		botonDulces.setForeground(Color.WHITE);
		botonDulces.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonDulces.setFocusPainted(false);
		botonDulces.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonDulces.setBackground(new Color(21, 101, 192));
		botonDulces.setBounds(0, 442, 350, 44);
		panel.add(botonDulces);
		
		JButton botonLimpieza = new JButton("Limpieza");
		botonLimpieza.setForeground(Color.WHITE);
		botonLimpieza.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonLimpieza.setFocusPainted(false);
		botonLimpieza.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonLimpieza.setBackground(new Color(21, 101, 192));
		botonLimpieza.setBounds(0, 484, 350, 44);
		panel.add(botonLimpieza);
		
		JButton botonAseoPer = new JButton("Aseo Personal");
		botonAseoPer.setForeground(Color.WHITE);
		botonAseoPer.setFont(new Font("Roboto Medium", Font.BOLD, 24));
		botonAseoPer.setFocusPainted(false);
		botonAseoPer.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		botonAseoPer.setBackground(new Color(21, 101, 192));
		botonAseoPer.setBounds(0, 527, 350, 44);
		panel.add(botonAseoPer);
		
		JButton botonCancelar = new JButton("Cancelar Pedido");
		botonCancelar.setForeground(Color.WHITE);
		botonCancelar.setFont(new Font("Arial Black", Font.BOLD, 14));
		botonCancelar.setBackground(new Color(51, 102, 255));
		botonCancelar.setBounds(10, 581, 192, 44);
		panel.add(botonCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(348, 0, 633, 663);
		contentPane.add(panel_1);
		

	}
	
	/*private void ShowPanel (JPanel p) {
		p.setSize (633, 663);
		p.setLocation (0, 0);
		removeAll();
		Container content = null;
		content.add(p, BorderLayout.CENTER);
		content.revalidate();
		content.repaint();
	}*/
}
