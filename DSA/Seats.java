import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seats extends JFrame implements ActionListener {
    private JButton[] seats;

    public Seats() {
        super("Bus Reservation System");

        // Initialize UI components
        JPanel panel = new JPanel();
        seats = new JButton[20];

        for (int i = 0; i < 20; i++) {
            seats[i] = new JButton("Seat " + (i + 1));
            seats[i].addActionListener(this);
            panel.add(seats[i]);
        }

        // Set layout and add components
        panel.setLayout(new GridLayout(4, 5, 10, 10));
        add(panel);

        // Set frame properties
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int seatNumber = Integer.parseInt(clickedButton.getText().substring(5));

        int choice = JOptionPane.showConfirmDialog(this,
                "Do you want to reserve Seat " + seatNumber + "?",
                "Confirmation", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            clickedButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Seat " + seatNumber + " reserved successfully!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Seats());
    }
}

