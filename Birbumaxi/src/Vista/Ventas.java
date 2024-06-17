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

import Modelo.desplegarPorCategoria;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Ventas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    public int categoria;
    private JTextField busqueda;
    /**
     * Create the frame.
     */
    public Ventas() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
        setBounds(100, 100, 1100, 785);
=======
        setBounds(100, 100, 1133, 829);
>>>>>>> 6e4291696ff622d61c0d64278d66286122f8497a
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 71, 170));
        panel.setBounds(0, 0, 350, 790);
        contentPane.add(panel);
        panel.setLayout(null);
        
        // Botón Frutas
        JButton botonFrutas = new JButton("Frutas");
        botonFrutas.setForeground(Color.WHITE);
        botonFrutas.setFont(new Font("Dialog", Font.BOLD, 18));
        botonFrutas.setBackground(new Color(21, 101, 192));
        botonFrutas.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonFrutas.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonFrutas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonFrutas.setBounds(0, 440, 157, 44);
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
                categoria=1;
            }
        });
        panel.add(botonFrutas);
        
        // Botón Verduras
        JButton botonVerduras = new JButton("Verduras");
        botonVerduras.setForeground(Color.WHITE);
        botonVerduras.setFont(new Font("Dialog", Font.BOLD, 18));
        botonVerduras.setBackground(new Color(21, 101, 192));
        botonVerduras.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonVerduras.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonVerduras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVerduras.setBounds(183, 440, 157, 44);
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
                categoria=2;
            }
        });
        panel.add(botonVerduras);
        
        // Botón Carnes
        JButton botonCarnes = new JButton("Carnes");
        botonCarnes.setForeground(Color.WHITE);
        botonCarnes.setFont(new Font("Dialog", Font.BOLD, 18));
        botonCarnes.setBackground(new Color(21, 101, 192));
        botonCarnes.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCarnes.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCarnes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCarnes.setBounds(183, 483, 157, 44);
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
                categoria=3;
            }
        });
        panel.add(botonCarnes);
        
        // Botón Lácteos
        JButton botonLacteos = new JButton("Lácteos");
        botonLacteos.setForeground(Color.WHITE);
        botonLacteos.setFont(new Font("Dialog", Font.BOLD, 18));
        botonLacteos.setBackground(new Color(21, 101, 192));
        botonLacteos.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLacteos.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLacteos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonLacteos.setBounds(0, 483, 157, 44);
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
                categoria=4;
            }
        });
        panel.add(botonLacteos);
        
        // Botón Cereales
        JButton botonCereales = new JButton("Cereales");
        botonCereales.setForeground(Color.WHITE);
        botonCereales.setFont(new Font("Dialog", Font.BOLD, 18));
        botonCereales.setBackground(new Color(21, 101, 192));
        botonCereales.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonCereales.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonCereales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCereales.setBounds(0, 526, 157, 44);
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
                categoria=5;
            }
        });
        panel.add(botonCereales);
		
     // Botón Dulces
        JButton botonDulces = new JButton("Dulces");
        botonDulces.setForeground(Color.WHITE);
        botonDulces.setFont(new Font("Dialog", Font.BOLD, 18));
        botonDulces.setBackground(new Color(21, 101, 192));
        botonDulces.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonDulces.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonDulces.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonDulces.setBounds(183, 526, 157, 44);
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
                categoria=6;
            }
        });
        panel.add(botonDulces);

        // Botón Limpieza
        JButton botonLimpieza = new JButton("Limpieza");
        botonLimpieza.setForeground(Color.WHITE);
        botonLimpieza.setFont(new Font("Dialog", Font.BOLD, 18));
        botonLimpieza.setBackground(new Color(21, 101, 192));
        botonLimpieza.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonLimpieza.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonLimpieza.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonLimpieza.setBounds(0, 569, 157, 44);
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
                categoria=7;
            }
        });
        panel.add(botonLimpieza);

        // Botón Aseo Personal
        JButton botonAseoPer = new JButton("Aseo Personal");
        botonAseoPer.setForeground(Color.WHITE);
        botonAseoPer.setFont(new Font("Dialog", Font.BOLD, 18));
        botonAseoPer.setBackground(new Color(21, 101, 192));
        botonAseoPer.setBorder(new LineBorder(new Color(7, 54, 127), 2)); // Borde azul oscuro de 2 píxeles
        botonAseoPer.setFocusPainted(false); // No mostrar el efecto de foco al presionar
        botonAseoPer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonAseoPer.setBounds(183, 569, 157, 44);
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
                categoria=8;
            }
        });
        panel.add(botonAseoPer);
        
        JLabel lblNewLabel_3 = new JLabel("Cantidad/Kg:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 24));
        lblNewLabel_3.setBounds(10, 629, 157, 30);
        panel.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Roboto Light", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBackground(Color.WHITE);
        textField.setBounds(171, 624, 169, 44);
        panel.add(textField);
        

        
        JButton btnCerrarSesion = new JButton("Cerrar Sesion");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
        		login log = new login();
        		log.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setBounds(70, 694, 192, 44);
=======
        		login vent1 = new login();
        		vent1.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setBounds(73, 735, 192, 44);
>>>>>>> 6e4291696ff622d61c0d64278d66286122f8497a
        panel.add(btnCerrarSesion);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Arial Black", Font.BOLD, 14));
        btnCerrarSesion.setBackground(new Color(51, 102, 255));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(387, 11, 682, 290);
        contentPane.add(scrollPane);


        

        JTable table = new JTable();
        table.setFont(new Font("Roboto Light", Font.BOLD, 18));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        

  

        // Agregar la tabla al JScrollPane
        scrollPane.setViewportView(table);
        
        // Agregar listener para detectar selecciones en la tabla
        table.getSelectionModel().addListSelectionListener(e -> {
            // Obtener la fila seleccionada
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) { // Si se ha seleccionado una fila válida
                // Obtener datos de la fila seleccionada
                String nombre = (String) table.getValueAt(selectedRow, 1); // Nombre del producto
                // Mostrar el nombre del producto seleccionado en un JOptionPane (ejemplo)
                JOptionPane.showMessageDialog(null, "Producto seleccionado: " + nombre);
            }
        });
        
        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setForeground(Color.WHITE);
        btnRealizarVenta.setFont(new Font("Arial Black", Font.BOLD, 16));
        btnRealizarVenta.setBackground(new Color(51, 102, 255));
        btnRealizarVenta.setBounds(877, 730, 230, 49);
        contentPane.add(btnRealizarVenta);
        
        JButton btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener la cantidad ingresada por el usuario
                String cantidadString = textField.getText().trim();
                if (!cantidadString.isEmpty()) {

                } else {
                    JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                }
            }
        });
        btnAgregarProducto.setForeground(Color.WHITE);
        btnAgregarProducto.setFont(new Font("Arial Black", Font.BOLD, 16));
        btnAgregarProducto.setBackground(new Color(51, 102, 255));
        btnAgregarProducto.setBounds(55, 675, 230, 49);
        panel.add(btnAgregarProducto);
<<<<<<< HEAD
=======
        
        JLabel lblNewLabel_3_1 = new JLabel("Busqueda:");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 24));
        lblNewLabel_3_1.setBounds(0, 320, 157, 30);
        panel.add(lblNewLabel_3_1);
        
        busqueda = new JTextField();
        busqueda.setBounds(7, 354, 150, 30);
        panel.add(busqueda);
        busqueda.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Nombres de las columnas
                String[] columnNames = {"ID Producto", "Nombre", "Stock", "Precio"};
                desplegarPorCategoria desp = new desplegarPorCategoria();
                

                // Crear el modelo de la tabla
                DefaultTableModel model = desp.datos(categoria, columnNames, busqueda.getText());
                
                table.setModel(model);
        	}
        });
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnBuscar.setBackground(new Color(21, 101, 192));
        btnBuscar.setBounds(171, 343, 157, 44);
        panel.add(btnBuscar);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\BIRBUMAXI.png"));
        lblNewLabel.setBounds(-23, 44, 373, 197);
        panel.add(lblNewLabel);


>>>>>>> 6e4291696ff622d61c0d64278d66286122f8497a
	}
}
