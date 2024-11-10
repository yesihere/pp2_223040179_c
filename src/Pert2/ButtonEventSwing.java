package Pert2;
import java.awt.event.*;
import javax.swing.*;

public class ButtonEventSwing extends JFrame {
    // Constructor
    public ButtonEventSwing() {
        // Set close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JLabel
        JLabel label = new JLabel("Hello World");
        label.setBounds(130, 40, 400, 10);

        // JButton
        JButton button = new JButton("Klik");
        button.setBounds(130, 100, 100, 40);

        // Action Listener for button
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                label.setText("Hello Pemrograman II");
            }
        });

        // Add button and label to JFrame
        this.add(button);
        this.add(label);

        // Set JFrame size and layout
        this.setSize(400, 500);
        this.setLayout(null);
    }

    // Main method
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ButtonEventSwing b = new ButtonEventSwing();
                b.setVisible(true);  // corrected "turn" to "true"
            }
        });
    }
}
