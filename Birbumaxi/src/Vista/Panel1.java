package Vista;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import java.awt.Font;

public class Panel1 extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTable table;

    /**
     * Create the panel.
     */
    public Panel1() {
        setBackground(new Color(13, 71, 170));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 49, 554, 400);
        add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Juan", "Perez", "12345678", "juan.perez@example.com", "Gerente", "5000"},
                {"Maria", "Lopez", "87654321", "maria.lopez@example.com", "Cajero", "2500"},
                {"Neo", "Aliaga", "124545645", "muerteaneo@example.com", "Limpiabanos", "1"}
            },
            new String[] {
                "Nombre", "Apellido", "CI", "Correo", "Cargo", "Salario"
            }
        ));

        // Establecer el borde para el JTable
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setGridColor(Color.BLACK);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(21, 101, 192));
        header.setForeground(Color.WHITE);
        header.setFont(header.getFont().deriveFont(16f)); 
        header.setBorder(new LineBorder(Color.BLACK, 1));

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ((DefaultTableCellRenderer)component).setBorder(new LineBorder(Color.BLACK));
                return component;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        scrollPane.setViewportView(table);

        JLabel lblListaDePersonal = new JLabel("LISTA DE PERSONAL BIRBUMAXI");
        lblListaDePersonal.setForeground(new Color(255, 255, 255));
        lblListaDePersonal.setFont(new Font("Roboto Black", Font.BOLD, 30));
        lblListaDePersonal.setBounds(24, 10, 486, 29);
        add(lblListaDePersonal);
    }
}
