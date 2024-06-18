package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Pedidos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Create the frame.
     */
    public Pedidos() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 785);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 71, 170));
        panel.setBounds(0, 0, 350, 760);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
        lblNewLabel.setBounds(10, 20, 330, 200);
        panel.add(lblNewLabel);
        
        // Botón Frutas
        JButton botonFrutas = new JButton("Frutas");
        botonFrutas.setForeground(Color.WHITE);
        botonFrutas.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonFrutas.setBackground(new Color(21, 101, 192));
        botonFrutas.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonFrutas.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonFrutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonFrutas.setBounds(0, 230, 350, 44);
        // Evento de entrada del mouse (hover)
        botonFrutas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonFrutas.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonFrutas.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonFrutas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Frutas
                System.out.println("Has presionado: Frutas");
            }
        });
        panel.add(botonFrutas);
        
        // Botón Verduras
        JButton botonVerduras = new JButton("Verduras");
        botonVerduras.setForeground(Color.WHITE);
        botonVerduras.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonVerduras.setBackground(new Color(21, 101, 192));
        botonVerduras.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonVerduras.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonVerduras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerduras.setBounds(0, 273, 350, 44);
        // Evento de entrada del mouse (hover)
        botonVerduras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonVerduras.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonVerduras.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonVerduras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Verduras
                System.out.println("Has presionado: Verduras");
            }
        });
        panel.add(botonVerduras);
        
        // Botón Carnes
        JButton botonCarnes = new JButton("Carnes");
        botonCarnes.setForeground(Color.WHITE);
        botonCarnes.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonCarnes.setBackground(new Color(21, 101, 192));
        botonCarnes.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCarnes.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCarnes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCarnes.setBounds(0, 316, 350, 44);
        // Evento de entrada del mouse (hover)
        botonCarnes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCarnes.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCarnes.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonCarnes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Carnes
                System.out.println("Has presionado: Carnes");
            }
        });
        panel.add(botonCarnes);
        
        // Botón Lácteos
        JButton botonLacteos = new JButton("Lácteos");
        botonLacteos.setForeground(Color.WHITE);
        botonLacteos.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonLacteos.setBackground(new Color(21, 101, 192));
        botonLacteos.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLacteos.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLacteos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLacteos.setBounds(0, 358, 350, 44);
        // Evento de entrada del mouse (hover)
        botonLacteos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonLacteos.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonLacteos.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonLacteos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Lácteos
                System.out.println("Has presionado: Lácteos");
            }
        });
        panel.add(botonLacteos);
        
        // Botón Cereales
        JButton botonCereales = new JButton("Cereales");
        botonCereales.setForeground(Color.WHITE);
        botonCereales.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonCereales.setBackground(new Color(21, 101, 192));
        botonCereales.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCereales.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCereales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCereales.setBounds(0, 400, 350, 44);
        // Evento de entrada del mouse (hover)
        botonCereales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCereales.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCereales.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonCereales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Cereales
                System.out.println("Has presionado: Cereales");
            }
        });
        panel.add(botonCereales);
		
     // Botón Dulces
        JButton botonDulces = new JButton("Dulces");
        botonDulces.setForeground(Color.WHITE);
        botonDulces.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonDulces.setBackground(new Color(21, 101, 192));
        botonDulces.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonDulces.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonDulces.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonDulces.setBounds(0, 442, 350, 44);
        // Evento de entrada del mouse (hover)
        botonDulces.addMouseListener((MouseListener) new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonDulces.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonDulces.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonDulces.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Dulces
                System.out.println("Has presionado: Dulces");
            }
        });
        panel.add(botonDulces);

        // Botón Limpieza
        JButton botonLimpieza = new JButton("Limpieza");
        botonLimpieza.setForeground(Color.WHITE);
        botonLimpieza.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonLimpieza.setBackground(new Color(21, 101, 192));
        botonLimpieza.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLimpieza.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLimpieza.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpieza.setBounds(0, 484, 350, 44);
        // Evento de entrada del mouse (hover)
        botonLimpieza.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonLimpieza.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonLimpieza.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonLimpieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Limpieza
                System.out.println("Has presionado: Limpieza");
            }
        });
        panel.add(botonLimpieza);

        // Botón Aseo Personal
        JButton botonAseoPer = new JButton("Aseo Personal");
        botonAseoPer.setForeground(Color.WHITE);
        botonAseoPer.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        botonAseoPer.setBackground(new Color(21, 101, 192));
        botonAseoPer.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonAseoPer.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonAseoPer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonAseoPer.setBounds(0, 527, 350, 44);
        // Evento de entrada del mouse (hover)
        botonAseoPer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                botonAseoPer.setBackground(new Color(31, 121, 212)); // Color más oscuro al pasar el mouse
            }
            public void mouseExited(MouseEvent evt) {
                botonAseoPer.setBackground(new Color(21, 101, 192)); // Restaurar color original al salir
            }
        });
        botonAseoPer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acción del botón Aseo Personal
                System.out.println("Has presionado: Aseo Personal");
            }
        });
        panel.add(botonAseoPer);
        
        JLabel lblNewLabel_3 = new JLabel("Cantidad/Kg:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        lblNewLabel_3.setBounds(10, 581, 157, 30);
        panel.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Roboto Light", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBackground(Color.WHITE);
        textField.setBounds(171, 581, 169, 44);
        panel.add(textField);

        // Datos de ejemplo para el JTable (se pueden cambiar o adaptar según tus necesidades)
        Object[][] data = {
                {"1", "Producto 1", "01/01/2025", 10, 25.5},
                {"2", "Producto 2", "02/02/2025", 20, 15.75},
                {"3", "Producto 3", "03/03/2025", 15, 30.0},
                {"4", "Producto 4", "04/04/2025", 5, 50.25}
        };

        // Nombres de las columnas
        String[] columnNames = {"ID Producto", "Nombre", "F. Vencimiento", "Stock", "Precio"};

        // Crear el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        
        JButton btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setForeground(Color.WHITE);
        btnAgregarProducto.setFont(new Font("Roboto Black", Font.BOLD, 23));
        btnAgregarProducto.setFocusPainted(false);
        btnAgregarProducto.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnAgregarProducto.setBackground(new Color(21, 101, 192));
        btnAgregarProducto.setBounds(38, 635, 252, 49);
        panel.add(btnAgregarProducto);
        
        JButton btnCancelarPedido = new JButton("Cancelar Pedido");
        btnCancelarPedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuGerente meng = new MenuGerente();
        		meng.setVisible(true);
        		dispose();
        	}
        });
        btnCancelarPedido.setForeground(Color.WHITE);
        btnCancelarPedido.setFont(new Font("Roboto Medium", Font.BOLD, 21));
        btnCancelarPedido.setFocusPainted(false);
        btnCancelarPedido.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnCancelarPedido.setBackground(new Color(21, 101, 192));
        btnCancelarPedido.setBounds(63, 694, 206, 49);
        panel.add(btnCancelarPedido);
        
        JButton btnRealizarPedido = new JButton("Realizar Pedido");
        btnRealizarPedido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRealizarPedido.setForeground(Color.WHITE);
        btnRealizarPedido.setFont(new Font("Roboto Black", Font.BOLD, 23));
        btnRealizarPedido.setFocusPainted(false);
        btnRealizarPedido.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnRealizarPedido.setBackground(new Color(21, 101, 192));
        btnRealizarPedido.setBounds(824, 689, 252, 49);
        contentPane.add(btnRealizarPedido);
	}
}
