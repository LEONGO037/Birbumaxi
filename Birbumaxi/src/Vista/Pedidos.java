package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.VentasFactura;
import Modelo.carrito;
import Modelo.desplegarPorCategoria;
import conexionBase.conexionBD;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Pedidos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cantidad;
    public int categoria;
    private JTextField busqueda;
    public static String productoSeleccionado="";
    public final static ArrayList<String> productos= new ArrayList<>(); 
    public String[] columnNames = {"ID Producto", "Nombre", "Stock", "Precio"};
    public DefaultTableModel model = new DefaultTableModel(null, columnNames);
    public String[] columnasNombres = {"ID Producto", "Nombre", "Stock", "Precio", "Cantidad"};
    public DefaultTableModel tabla2= new DefaultTableModel(null, columnasNombres);
    public ArrayList<Double> cantidades= new ArrayList<>();
    public static String eliminarProd="";
    /**
     * Create the frame.
     */
    public Pedidos() {
        setType(Type.UTILITY);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1111, 758);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
		setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(13, 71, 170));
        panel.setBounds(0, 0, 350, 758);
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
        botonFrutas.setBounds(0, 364, 175, 44);
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
        botonVerduras.setBounds(174, 364, 175, 44);
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
        botonCarnes.setBounds(174, 403, 175, 44);
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
        botonLacteos.setBounds(0, 405, 175, 44);
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
        botonCereales.setBounds(0, 446, 175, 44);
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
        botonDulces.setBounds(174, 446, 175, 44);
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
        botonLimpieza.setBounds(0, 489, 175, 44);
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
        botonAseoPer.setBounds(174, 489, 175, 44);
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
        lblNewLabel_3.setBounds(10, 547, 157, 30);
        panel.add(lblNewLabel_3);
        
        cantidad = new JTextField();
        cantidad.setForeground(new Color(0, 0, 0));
        cantidad.setFont(new Font("Roboto Light", Font.BOLD, 18));
        cantidad.setColumns(10);
        cantidad.setBackground(Color.WHITE);
        cantidad.setBounds(174, 543, 169, 44);
        panel.add(cantidad);
        

        
        JButton btnCerrarSesion = new JButton("Atras");
        btnCerrarSesion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MenuGerente meng = new MenuGerente();
        		meng.setVisible(true);
        		dispose();
        	}
        });
        btnCerrarSesion.setBounds(72, 661, 192, 44);

        panel.add(btnCerrarSesion);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Roboto Black", Font.BOLD, 22));
        btnCerrarSesion.setBackground(new Color(51, 102, 255));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(387, 11, 682, 290);
        contentPane.add(scrollPane);


        
        JTable table = new JTable(model);
        table.setFont(new Font("Roboto Light", Font.BOLD, 18));
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setFocusable(false); // Deshabilitar el enfoque para evitar la edición por teclado

        
        JLabel lblNewLabel_3_1 = new JLabel("Pedido de Producto:");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Roboto Black", Font.BOLD, 27));
        lblNewLabel_3_1.setBounds(10, 205, 330, 30);
        panel.add(lblNewLabel_3_1);
        
        busqueda = new JTextField();
        busqueda.setFont(new Font("Roboto Light", Font.BOLD, 21));
        busqueda.setBounds(7, 284, 166, 43);
        panel.add(busqueda);
        busqueda.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

                
                desplegarPorCategoria desp = new desplegarPorCategoria();
                model=desp.datos(categoria, columnNames, busqueda.getText());
                table.setModel(model);
                
                
        	}
        });
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Dialog", Font.BOLD, 18));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        btnBuscar.setBackground(new Color(21, 101, 192));
        btnBuscar.setBounds(183, 283, 157, 44);
        panel.add(btnBuscar);

        JButton btnPedirProducto = new JButton("Pedir Producto");
        btnPedirProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si el producto ya está en la lista
                if (productos.contains(productoSeleccionado)) {
                    // Si el producto ya está en la lista, sumar la cantidad ingresada a la cantidad existente
                    String cantidadString = cantidad.getText().trim();
                    if (!cantidadString.isEmpty()) {
                        try {
                            double cantidadDouble = Double.parseDouble(cantidadString);
                            int index = productos.indexOf(productoSeleccionado);
                            cantidades.set(index, cantidades.get(index) + cantidadDouble);
                            actualizarStock(cantidadDouble, 1); // Sumar al stock existente
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                        }
                    }
                } else {
                    // Si el producto no está en la lista, agregarlo con su cantidad
                    String cantidadString = cantidad.getText().trim();
                    if (!cantidadString.isEmpty() && Double.parseDouble(cantidad.getText()) > 0) {
                        try {
                            double cantidadDouble = Double.parseDouble(cantidadString);
                            productos.add(productoSeleccionado);
                            cantidades.add(cantidadDouble);
                            actualizarStock(cantidadDouble, 1); // Sumar al stock existente
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                    }
                }

                // Actualizar la tabla pedidosRealizados con los datos actualizados
                /*try {
                    carrito carr = new carrito();
                    tabla2 = carr.carritos(columnasNombres, productos, cantidades);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar la tabla.");
                }

                System.out.println(productoSeleccionado);
            }
        });*/

       

        btnPedirProducto.setForeground(Color.WHITE);
        btnPedirProducto.setFont(new Font("Roboto Black", Font.BOLD, 21));
        btnPedirProducto.setBackground(new Color(51, 102, 255));
        btnPedirProducto.setBounds(52, 602, 230, 49);
        panel.add(btnPedirProducto);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\logo330x200.png"));
        lblNewLabel.setBounds(10, 10, 330, 200);
        panel.add(lblNewLabel);
        
        JLabel lblBusquedaPorId = new JLabel("Busqueda por ID o Nombre:");
        lblBusquedaPorId.setForeground(Color.WHITE);
        lblBusquedaPorId.setFont(new Font("Roboto Light", Font.ITALIC, 18));
        lblBusquedaPorId.setBounds(10, 245, 275, 29);
        panel.add(lblBusquedaPorId);
        
        JLabel lblBusquedaPorTipo = new JLabel("Busqueda por Tipo:");
        lblBusquedaPorTipo.setForeground(Color.WHITE);
        lblBusquedaPorTipo.setFont(new Font("Roboto Light", Font.ITALIC, 18));
        lblBusquedaPorTipo.setBounds(10, 337, 282, 29);
        panel.add(lblBusquedaPorTipo);
        
        JPanel content = new JPanel();
        content.setBackground(new Color(13, 71, 170));
        content.setBounds(390, 377, 679, 320);
        contentPane.add(content);
		content.setLayout(new BorderLayout(0, 0));
        
        JButton botonPedirNuevo = new JButton("Pedir nuevo Producto");
        botonPedirNuevo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Panel5 mod = new Panel5();
				mod.setSize(679, 320); // Ajuste del tamaño
				mod.setLocation(0, 0); // Ajuste de la ubicación
				content.removeAll();
				content.add(mod, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
        	}
        });
        botonPedirNuevo.setForeground(Color.WHITE);
        botonPedirNuevo.setFont(new Font("Dialog", Font.BOLD, 18));
        botonPedirNuevo.setFocusPainted(false);
        botonPedirNuevo.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        botonPedirNuevo.setBackground(new Color(21, 101, 192));
        botonPedirNuevo.setBounds(387, 323, 350, 44);
        contentPane.add(botonPedirNuevo);
        
        JButton botonModificar = new JButton("Modificar Producto Existente");
        botonModificar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Panel6 mod = new Panel6();
				mod.setSize(679, 320); // Ajuste del tamaño
				mod.setLocation(0, 0); // Ajuste de la ubicación
				content.removeAll();
				content.add(mod, BorderLayout.CENTER);
				content.revalidate();
				content.repaint();
        	}
        });
        botonModificar.setForeground(Color.WHITE);
        botonModificar.setFont(new Font("Dialog", Font.BOLD, 18));
        botonModificar.setFocusPainted(false);
        botonModificar.setBorder(new LineBorder(new Color(7, 54, 127), 2));
        botonModificar.setBackground(new Color(21, 101, 192));
        botonModificar.setBounds(735, 323, 334, 44);
        contentPane.add(botonModificar);
        
        // Agregar la tabla al JScrollPane
        scrollPane.setViewportView(table);
     // Agregar el listener a la tabla para manejar clics simples y dobles
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Verificar que el evento no es intermedio
                // Obtener la fila seleccionada
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Si se ha seleccionado una fila válida
                    // Obtener datos de la fila seleccionada
                    productoSeleccionado = (String) table.getValueAt(selectedRow, 0); // ID del producto

                    // Verificar si el producto ya está en la lista
                    if (productos.contains(productoSeleccionado)) {
                        // Si el producto ya está en la lista, sumar la cantidad ingresada a la cantidad existente
                        String cantidadString = cantidad.getText().trim();
                        if (!cantidadString.isEmpty()) {
                            try {
                                double cantidadDouble = Double.parseDouble(cantidadString);
                                int index = productos.indexOf(productoSeleccionado);
                                cantidades.set(index, cantidades.get(index) + cantidadDouble);
                                actualizarStock(cantidadDouble, 1);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                            }
                        }
                    } else {
                        // Si el producto no está en la lista, agregarlo con su cantidad
                        String cantidadString = cantidad.getText().trim();
                        if (!cantidadString.isEmpty() && Double.parseDouble(cantidad.getText()) > 0 && Double.parseDouble(cantidad.getText()) <= stockCalculo()) {
                            try {
                                double cantidadDouble = Double.parseDouble(cantidadString);
                                productos.add(productoSeleccionado);
                                cantidades.add(cantidadDouble);
                                actualizarStock(cantidadDouble, 1);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.");
                        }
                    }

                    // Actualizar la tabla pedidosRealizados con los datos actualizados
                    try {
                        carrito carr = new carrito();
                        tabla2 = carr.carritos(columnasNombres, productos, cantidades);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error al actualizar la tabla.");
                    }

                    System.out.println(productoSeleccionado);
                }
            }
        });
        

	}

    public static double stockCalculo() {
        double stock = 0;
        String consulta = "SELECT stock from productos WHERE id_producto=" + productoSeleccionado + ";";
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                stock = Double.parseDouble(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el stock");
        }
        return stock;
    }

    
    public static void actualizarStock(double cantidad, int op) {
        String consulta = "SELECT stock from productos WHERE id_producto=" + productoSeleccionado + ";";
        double stock = 0.0;
        conexionBD conec = new conexionBD();
        Connection conn = conec.conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(consulta);
            rs = ps.executeQuery();
            if (rs.next()) {
                stock = Double.parseDouble(rs.getString(1));
            }

            double actual;
            if (op == 1) {
                actual = stock + cantidad; // Sumar cantidad al stock existente
            } else {
                actual = stock - cantidad;
            }

            String act = "update productos set stock =" + actual + " where ID_producto = " + productoSeleccionado + ";";
            ps = conn.prepareStatement(act);
            int v = ps.executeUpdate();
            if (v > 0) {
                System.out.println("Actualizado");
            } else {
                System.out.println("No Actualizado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el stock");
        }
    }

    
    
	public int eliminar() {
		int posicion=0;
		for(int i=0; i<productos.size(); i++) {
			if(eliminarProd.equals(productos.get(i))) {
				posicion=i;
				productos.remove(posicion);
			}else {
				continue;
			}
		}
		return posicion;

	}

	public void eliminarCantidad() {
	    int posicion = eliminar();
	    if (posicion != -1) {
	        actualizarStock(cantidades.get(posicion), 2); // Restar del stock existente
	        cantidades.remove(posicion);
	    }
	}


	public int sacarPosicion() {
		int posicion=0;
		for(int i=0; i<productos.size(); i++) {
			if(productoSeleccionado.equals(productos.get(i))) {
				posicion=i;
			}else {
				continue;
			}
		}
		return posicion;
	}
}