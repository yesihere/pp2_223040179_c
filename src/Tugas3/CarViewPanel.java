import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarViewPanel extends JPanel {
    private DefaultTableModel tableModel;
    private JTable carTable;

    public CarViewPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Model", "Harga", "Deskripsi", "Kondisi", "Warna", "Fitur", "Jarak Tempuh", "Tahun", "Garansi"};
        tableModel = new DefaultTableModel(columnNames, 0);
        carTable = new JTable(tableModel);

        add(new JScrollPane(carTable), BorderLayout.CENTER);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
