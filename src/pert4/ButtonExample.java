import java.awt.event.*;
import javax.swing.*;

public class ButtonExample {
    public static void main(String[] args) {
        // Membuat frame
        JFrame frame = new JFrame("Button Example");
        JButton button = new JButton("Click Me");

        // Menambahkan ActionListener ke JButton
        button.addActionListener((ActionEvent e) -> {
            System.out.println("Button Clicked!");
        });

        // Menentukan posisi dan ukuran button
        button.setBounds(50, 50, 150, 30);
        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
