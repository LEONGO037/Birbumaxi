package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Modelo.verificacionCorreo;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField correo;
	private JPasswordField contrasena2;

	public login() {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\BIRBUMAXI.png"));
		lblNewLabel.setBounds(7, 47, 390, 187);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\Colorxd.png"));
		lblNewLabel_1.setBounds(1, -33, 396, 614);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("INICIAR SESION");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 34));
		lblNewLabel_2.setBounds(428, 101, 404, 70);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(428, 214, 157, 30);
		contentPane.add(lblNewLabel_3);
		
		correo = new JTextField();
		correo.setFont(new Font("Arial Black", Font.PLAIN, 13));
		correo.setBackground(new Color(192, 192, 192));
		correo.setBounds(428, 255, 404, 30);
		contentPane.add(correo);
		correo.setColumns(10);
		
		contrasena2 = new JPasswordField();
		contrasena2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		contrasena2.setBackground(new Color(192, 192, 192));
		contrasena2.setBounds(428, 338, 404, 30);
		contentPane.add(contrasena2);

		
		JLabel lblNewLabel_3_1 = new JLabel("Contraseña:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(428, 298, 157, 30);
		contentPane.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Iniciar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificacionCorreo ver1= new verificacionCorreo();
				String contrasena= new String(contrasena2.getPassword());
				if(ver1.verificador(correo.getText(), contrasena)) {
					JOptionPane.showMessageDialog(null, "ingreso permitido");
					correo.setText("");
					contrasena2.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "ingreso denegado");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(247, 118, 2));
		btnNewButton.setBounds(599, 475, 146, 49);
		contentPane.add(btnNewButton);
		

	}
}
