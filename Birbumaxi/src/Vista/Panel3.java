package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Panel3 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField apellidoemp;
    private JTextField salarioemp;
    private JTextField idemp;
    private JTextField nombremp;

    /**
     * Create the panel.
     */
    public Panel3() {
        setBackground(new Color(13, 71, 170));
        setLayout(null);

        JLabel lblListaDePersonal = new JLabel("CONTRATAR PERSONAL");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 23));
        lblListaDePersonal.setBounds(0, 21, 313, 29);
        add(lblListaDePersonal);

        JLabel lblIngreseAlgunCampo = new JLabel("Rellene los datos de la persona a contratar: ");
        lblIngreseAlgunCampo.setForeground(Color.WHITE);
        lblIngreseAlgunCampo.setFont(new Font("Roboto Medium", Font.ITALIC, 14));
        lblIngreseAlgunCampo.setBounds(10, 69, 400, 29);
        add(lblIngreseAlgunCampo);

        JLabel lblCdigo = new JLabel("CI:");
        lblCdigo.setForeground(Color.WHITE);
        lblCdigo.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo.setBounds(10, 108, 73, 29);
        add(lblCdigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblNombre.setBounds(10, 149, 73, 29);
        add(lblNombre);

        JLabel lblCdigo_1_1 = new JLabel("Cargo:");
        lblCdigo_1_1.setForeground(Color.WHITE);
        lblCdigo_1_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblCdigo_1_1.setBounds(10, 227, 73, 29);
        add(lblCdigo_1_1);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.WHITE);
        lblApellido.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblApellido.setBounds(10, 188, 73, 29);
        add(lblApellido);

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setForeground(Color.WHITE);
        lblSalario.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
        lblSalario.setBounds(10, 266, 73, 29);
        add(lblSalario);

        String[] cargosOptions = { "Gerente", "Cajero" };
        JComboBox<String> cargos = new JComboBox<>(cargosOptions);
        cargos.setForeground(new Color(128, 128, 128));
        cargos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        cargos.setBounds(93, 229, 175, 27);
        add(cargos);


        JButton btnBuscar = new JButton("Contratar");
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setFont(new Font("Roboto Black", Font.BOLD, 24));
        btnBuscar.setBackground(new Color(51, 102, 255));
        btnBuscar.setBounds(49, 319, 175, 44);
        add(btnBuscar);

        apellidoemp = new JTextField();
        apellidoemp.setForeground(new Color(128, 128, 128));
        apellidoemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        apellidoemp.setBounds(93, 190, 175, 29);
        add(apellidoemp);
        apellidoemp.setColumns(10);

        salarioemp = new JTextField();
        salarioemp.setForeground(new Color(128, 128, 128));
        salarioemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        salarioemp.setColumns(10);
        salarioemp.setBounds(93, 268, 175, 29);
        add(salarioemp);

        idemp = new JTextField();
        idemp.setForeground(new Color(128, 128, 128));
        idemp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        idemp.setColumns(10);
        idemp.setBounds(93, 108, 175, 29);
        add(idemp);

        nombremp = new JTextField();
        nombremp.setForeground(new Color(128, 128, 128));
        nombremp.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
        nombremp.setColumns(10);
        nombremp.setBounds(93, 149, 175, 29);
        add(nombremp);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Documentos\\imag\\imagenpcontrato.jpg"));
        lblNewLabel.setBounds(295, 0, 260, 449);
        add(lblNewLabel);
    }
}
