package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Panel2 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField apellidoemp;
    private JTextField salarioemp;
    private JTextField idemp;
    private JTextField nombremp;

    /**
     * Create the panel.
     */
    public Panel2() {
        setBackground(new Color(13, 71, 170));
        setLayout(null);

        JLabel lblListaDePersonal = new JLabel("ADMINISTRAR PERSONAL");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 30));
        lblListaDePersonal.setBounds(137, 26, 400, 29);
        add(lblListaDePersonal);

        JLabel lblIngreseAlgunCampo = new JLabel("Ingrese algun campo para buscar al personal:");
        lblIngreseAlgunCampo.setForeground(Color.WHITE);
        lblIngreseAlgunCampo.setFont(new Font("Roboto Medium", Font.ITALIC, 18));
        lblIngreseAlgunCampo.setBounds(23, 65, 400, 29);
        add(lblIngreseAlgunCampo);

        JLabel lblCdigo = new JLabel("ID:");
        lblCdigo.setForeground(Color.WHITE);
        lblCdigo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo.setBounds(23, 104, 73, 29);
        add(lblCdigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNombre.setBounds(23, 145, 73, 29);
        add(lblNombre);

        JLabel lblCdigo_1_1 = new JLabel("Cargo:");
        lblCdigo_1_1.setForeground(Color.WHITE);
        lblCdigo_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo_1_1.setBounds(23, 223, 73, 29);
        add(lblCdigo_1_1);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.WHITE);
        lblApellido.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblApellido.setBounds(23, 184, 73, 29);
        add(lblApellido);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setForeground(Color.WHITE);
        lblSalario.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblSalario.setBounds(23, 262, 73, 29);
        add(lblSalario);

        String[] cargosOptions = { "Gerente", "Cajero" };
        JComboBox<String> cargos = new JComboBox<>(cargosOptions);
        cargos.setForeground(new Color(128, 128, 128));
        cargos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        cargos.setBounds(106, 225, 175, 27);
        add(cargos);


        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Roboto Black", Font.BOLD, 24));
        btnBuscar.setBackground(new Color(51, 102, 255));
        btnBuscar.setBounds(116, 309, 149, 44);
        add(btnBuscar);

        JButton btnActualizarInformacin = new JButton("Actualizar Información");
        btnActualizarInformacin.setForeground(Color.WHITE);
        btnActualizarInformacin.setFont(new Font("Roboto Medium", Font.ITALIC, 17));
        btnActualizarInformacin.setBackground(new Color(51, 102, 255));
        btnActualizarInformacin.setBounds(324, 115, 221, 52);
        add(btnActualizarInformacin);

        JButton btnDespedirEmpleado = new JButton("Despedir Empleado");
        btnDespedirEmpleado.setForeground(Color.WHITE);
        btnDespedirEmpleado.setFont(new Font("Roboto Medium", Font.ITALIC, 17));
        btnDespedirEmpleado.setBackground(new Color(51, 102, 255));
        btnDespedirEmpleado.setBounds(324, 190, 221, 52);
        add(btnDespedirEmpleado);

        apellidoemp = new JTextField();
        apellidoemp.setForeground(new Color(128, 128, 128));
        apellidoemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        apellidoemp.setBounds(106, 186, 175, 29);
        add(apellidoemp);
        apellidoemp.setColumns(10);

        salarioemp = new JTextField();
        salarioemp.setForeground(new Color(128, 128, 128));
        salarioemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        salarioemp.setColumns(10);
        salarioemp.setBounds(106, 264, 175, 29);
        add(salarioemp);

        idemp = new JTextField();
        idemp.setForeground(new Color(128, 128, 128));
        idemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        idemp.setColumns(10);
        idemp.setBounds(106, 104, 175, 29);
        add(idemp);

        nombremp = new JTextField();
        nombremp.setForeground(new Color(128, 128, 128));
        nombremp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        nombremp.setColumns(10);
        nombremp.setBounds(106, 145, 175, 29);
        add(nombremp);
    }
}
