import java.awt.*;
import javax.swing.*;

public class MainFrame {
  public static void main(String[] args) {
    // Membuat frame utama
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Contoh Konkurensi di Swing");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 200);
      frame.setLayout(new BorderLayout());

      // Label untuk status
      JLabel statusLabel = new JLabel("Tekan tombol untuk mulai tugas berat", JLabel.CENTER);

      // Tombol untuk memulai proses
      JButton startButton = new JButton("Mulai");

      // Progress bar
      JProgressBar progressBar = new JProgressBar(0, 60);
      progressBar.setValue(0);
      progressBar.setStringPainted(true);

      // Tambahkan komponen ke frame
      frame.add(statusLabel, BorderLayout.NORTH);
      frame.add(progressBar, BorderLayout.CENTER);
      frame.add(startButton, BorderLayout.SOUTH);

      startButton.addActionListener(e -> {
    startButton.setEnabled(false); // Nonaktifkan tombol selama proses berlangsung
    statusLabel.setText("Proses berjalan...");

    SwingWorker<Void, Integer> worker = new SwingWorker<>() {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 1; i <= 60; i++) {
                Thread.sleep(1000); // Simulasi pemrosesan data
                publish(i); // Kirim progres ke proses
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            // Perbarui progress bar
            int progress = chunks.get(chunks.size() - 1);
            progressBar.setValue(progress);
        }

        @Override
        protected void done() {
            // Eksekusi setelah proses selesai
            statusLabel.setText("Proses selesai!");
            startButton.setEnabled(true); // Aktifkan kembali tombol
        }
    };

    worker.execute(); // Jalankan SwingWorker
});

      // Tampilkan frame
      frame.setVisible(true);
    });
  }
}
    