import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarInputPanel extends JPanel {
    private DefaultTableModel tableModel;

    public CarInputPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);  // Margin antar komponen

        // Komponen input
        JTextField modelField = new JTextField();
        JTextField priceField = new JTextField();
        JTextArea descriptionArea = new JTextArea();
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        JRadioButton newCondition = new JRadioButton("Baru");
        JRadioButton usedCondition = new JRadioButton("Bekas");
        ButtonGroup conditionGroup = new ButtonGroup();
        conditionGroup.add(newCondition);
        conditionGroup.add(usedCondition);

        JCheckBox warrantyCheckBox = new JCheckBox("Garansi Tersedia");
        JComboBox<String> colorBox = new JComboBox<>(new String[]{"Merah", "Putih", "Hitam", "Biru", "Hijau"});
        
        JList<String> featuresList = new JList<>(new String[]{"AC", "Sunroof", "Navigasi", "Bluetooth"});
        JScrollPane featureScrollPane = new JScrollPane(featuresList);
        
        JSlider mileageSlider = new JSlider(0, 100000, 50000);
        mileageSlider.setMajorTickSpacing(20000);
        mileageSlider.setPaintTicks(true);
        mileageSlider.setPaintLabels(true);

        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(1990, 1900, 2023, 1));

        JButton addButton = new JButton("Tambah Mobil");

        // Baris 1
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Model:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(modelField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Harga:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(priceField, gbc);

        // Baris 2
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(descriptionScrollPane, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        add(new JLabel("Kondisi:"), gbc);
        gbc.gridx = 1;
        add(newCondition, gbc);
        gbc.gridx = 2;
        add(usedCondition, gbc);

        // Baris 3
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        add(new JLabel("Warna:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(colorBox, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 1;
        add(new JLabel("Fitur:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(featureScrollPane, gbc);

        // Baris 4
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 1;
        add(new JLabel("Jarak Tempuh:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(mileageSlider, gbc);

        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 1;
        add(new JLabel("Tahun Pembuatan:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        add(yearSpinner, gbc);

        // Baris 5
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 1;
        add(new JLabel(), gbc);  // Kosong untuk spasi
        gbc.gridx = 1;
        add(warrantyCheckBox, gbc);

        gbc.gridx = 0; gbc.gridy = 9; gbc.gridwidth = 3;
        add(addButton, gbc);

        // Action Listener untuk tombol
        addButton.addActionListener(e -> {
            String model = modelField.getText();
            String price = priceField.getText();
            String description = descriptionArea.getText();
            String condition = newCondition.isSelected() ? "Baru" : "Bekas";
            String color = (String) colorBox.getSelectedItem();
            String features = featuresList.getSelectedValuesList().toString();
            int mileage = mileageSlider.getValue();
            int year = (int) yearSpinner.getValue();
            boolean warranty = warrantyCheckBox.isSelected();

            tableModel.addRow(new Object[]{model, price, description, condition, color, features, mileage, year, warranty});
            JOptionPane.showMessageDialog(null, "Data mobil berhasil ditambahkan!");
        });
    }

    public void setTableModel(DefaultTableModel model) {
        this.tableModel = model;
    }
}
