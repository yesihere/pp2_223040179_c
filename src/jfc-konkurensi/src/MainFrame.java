import java.awt.*;
import java.util.List;
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

      //Tombol aksi    
      startButton.addActionListener(e -> {
        startButton.setEnabled(false); //nonaktifkan tombol saat berjalan 
        statusLabel.setText("Proses berjalan.... ");

         // Buat SwingWorker untuk menangani tugas berat
         SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulasi tugas berat
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(50); // Simulasi delay
                    publish(i); // Perbarui progres
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
                // Perbarui progress bar
                int latestProgress = chunks.get(chunks.size() - 1);
                progressBar.setValue(latestProgress);
            }

            @Override
            protected void done() {
                // Aksi setelah tugas selesai
                startButton.setEnabled(true);
                statusLabel.setText("Proses selesai!");
            }
        };

        // Jalankan SwingWorker
        worker.execute();
    });

    // Tampilkan frame
    frame.setVisible(true);
});
}
}
    