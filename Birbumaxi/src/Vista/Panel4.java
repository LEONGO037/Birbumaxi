package Vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Panel4 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Panel4() {
		setBackground(new Color(13, 71, 170));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el intervalo de fecha:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 0, 199, 26);
		add(lblNewLabel);
		
		JLabel lblMenor = new JLabel("Inferior:");
		lblMenor.setForeground(Color.WHITE);
		lblMenor.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblMenor.setBounds(32, 23, 81, 26);
		add(lblMenor);
		
		JLabel lblSuperior = new JLabel("Superior:");
		lblSuperior.setForeground(Color.WHITE);
		lblSuperior.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		lblSuperior.setBounds(32, 49, 81, 26);
		add(lblSuperior);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto Black", Font.BOLD, 11));
		textField.setBounds(91, 28, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Roboto Black", Font.BOLD, 11));
		textField_1.setColumns(10);
		textField_1.setBounds(91, 53, 96, 19);
		add(textField_1);
		
		JButton btnGenerarReporte = new JButton("Generar Reporte");
		btnGenerarReporte.setForeground(Color.WHITE);
		btnGenerarReporte.setFont(new Font("Roboto Medium", Font.BOLD, 15));
		btnGenerarReporte.setFocusPainted(false);
		btnGenerarReporte.setBorder(new LineBorder(new Color(7, 54, 127), 2));
		btnGenerarReporte.setBackground(new Color(21, 101, 192));
		btnGenerarReporte.setBounds(240, 9, 172, 55);
		add(btnGenerarReporte);

	}

}
