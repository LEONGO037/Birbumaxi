package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.verificacionCorreo;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

    private JTextField correo;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField password;

    public login() {
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
        
        JLabel lblNewLabel_2 = new JLabel("INICIAR SESION");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Roboto Black", Font.BOLD, 37));
        lblNewLabel_2.setBounds(170, 286, 288, 70);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Correo:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        lblNewLabel_3.setBounds(85, 351, 157, 30);
        contentPane.add(lblNewLabel_3);
        
        correo = new JTextField();
        correo.setForeground(new Color(128, 128, 128));
        correo.setFont(new Font("Roboto Light", Font.BOLD, 18));
        correo.setBackground(new Color(255, 255, 255));
        correo.setBounds(153, 391, 404, 40);
        contentPane.add(correo);
        correo.setColumns(10);
        
        password = new JPasswordField();
        password.setForeground(new Color(128, 128, 128));
        password.setFont(new Font("Roboto Light", Font.BOLD, 18));
        password.setBackground(new Color(255, 255, 255));
        password.setBounds(153, 477, 404, 40);
        contentPane.add(password);
        
        JButton BotonIngresar = new JButton("Iniciar Sesion");
        BotonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificacionCorreo ver1= new verificacionCorreo();
                String contrasena= new String(password.getPassword());
                if(ver1.verificador(correo.getText(), contrasena)) {
                    JOptionPane.showMessageDialog(null, "ingreso permitido");
                    if(ver1.verificadorTipo(correo.getText())) {
                    	MenuGerente ger = new MenuGerente();
                    	ger.setVisible(true);
                    	dispose();
                    }else if(!ver1.verificadorTipo(correo.getText())) {
                    	Ventas venta = new Ventas();
                        venta.setVisible(true);
                        dispose();
                    }
                    correo.setText("");
                    password.setText("");
           
                }else {
                    JOptionPane.showMessageDialog(null, "ingreso denegado");
                }
                correo.setText("");
                password.setText("");
            }
        });
        BotonIngresar.setFont(new Font("Arial Black", Font.PLAIN, 14));
        BotonIngresar.setBackground(new java.awt.Color(51, 102, 255));
        BotonIngresar.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        BotonIngresar.setForeground(new java.awt.Color(255, 255, 255));
        BotonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonIngresar.setBounds(153, 561, 286, 49);
        contentPane.add(BotonIngresar);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\Imagenlogin.jpg"));
        lblNewLabel_1.setBounds(614, 0, 372, 663);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo550x300.png"));
        lblNewLabel.setBounds(33, 0, 550, 300);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_3_2 = new JLabel("Contraseña:");
        lblNewLabel_3_2.setForeground(Color.WHITE);
        lblNewLabel_3_2.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        lblNewLabel_3_2.setBounds(85, 437, 157, 30);
        contentPane.add(lblNewLabel_3_2);
        
        JLabel lblNewLabel_4_1 = new JLabel("");
        lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\userimage.png"));
        lblNewLabel_4_1.setBounds(95, 391, 40, 40);
        contentPane.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("");
        lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Documentos\\imag\\passwordimage.png"));
        lblNewLabel_4_1_1.setBounds(95, 477, 40, 40);
        contentPane.add(lblNewLabel_4_1_1);
        
        JRadioButton vercontrasena = new JRadioButton("Ver contraseña");
        vercontrasena.setFont(new Font("Roboto Light", Font.BOLD, 12));
        vercontrasena.setForeground(new Color(255, 255, 255));
        vercontrasena.setBackground(new Color(255, 128, 0));
        vercontrasena.setBounds(153, 523, 128, 21);
        contentPane.add(vercontrasena);
        
        // ActionListener para el JRadioButton vercontrasena
        vercontrasena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (vercontrasena.isSelected()) {
                    password.setEchoChar((char) 0);
                } else {
                    password.setEchoChar('\u2022');
                }
            }
        });
    }
}

