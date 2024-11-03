import java.awt.*;
import javax.swing.*;

public class MainCarApp extends JFrame {
    private JPanel mainPanel;
    private CarInputPanel carInputPanel;
    private CarViewPanel carViewPanel;

    public MainCarApp() {
        setTitle("Aplikasi Penjualan Mobil Klasik");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Membuat JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuInput = new JMenuItem("Tambah Mobil");
        JMenuItem menuView = new JMenuItem("Lihat Daftar Mobil");
        JMenuItem menuExit = new JMenuItem("Keluar"); // Tambahan menu Keluar

        menu.add(menuInput);
        menu.add(menuView);
        menu.addSeparator(); // Menambahkan garis pemisah untuk estetika
        menu.add(menuExit); // Menambahkan menu Keluar
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Utama dengan CardLayout
        mainPanel = new JPanel(new CardLayout());
        carInputPanel = new CarInputPanel();
        carViewPanel = new CarViewPanel();

        mainPanel.add(carInputPanel, "Input");
        mainPanel.add(carViewPanel, "View");

        add(mainPanel);

        // Aksi pada MenuItem
        menuInput.addActionListener(e -> showPanel("Input"));
        menuView.addActionListener(e -> showPanel("View"));
        menuExit.addActionListener(e -> System.exit(0)); // Menambahkan aksi untuk keluar dari aplikasi

        // Menghubungkan tabel input dan view
        carInputPanel.setTableModel(carViewPanel.getTableModel());
    }

    private void showPanel(String panelName) {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainCarApp app = new MainCarApp();
            app.setVisible(true);
        });
    }
}
