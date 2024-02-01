import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Brs extends JFrame {
    private Map<String, Bus> buses = new HashMap<>();

    public Brs() {
        initializeBuses();

        setTitle("Bus Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showMenu();
    }

    private void showMenu() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);

        JLabel label = new JLabel("Select an option:");
        label.setBounds(10, 20, 150, 25);
        panel.add(label);

        JButton option1Button = new JButton("1. Check and Book Seats");
        option1Button.setBounds(10, 50, 180, 25);
        panel.add(option1Button);

        JButton option2Button = new JButton("2. Cancel Booking");
        option2Button.setBounds(10, 80, 150, 25);
        panel.add(option2Button);

        JButton option3Button = new JButton("3. Exit");
        option3Button.setBounds(10, 110, 150, 25);
        panel.add(option3Button);

        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAvailableBuses();
            }
        });

        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBooking();
            }
        });

        option3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void initializeBuses() {
        // Initialize buses with routes and timings
        buses.put("Bus1", new Bus("Bus1", "Route A", "9:00 AM", 30));
        buses.put("Bus2", new Bus("Bus2", "Route B", "10:30 AM", 40));
        buses.put("Bus3", new Bus("Bus3", "Route C", "1:00 PM", 20));
    }

    private void showAvailableBuses() {
        // Implement the logic to display available buses, get user input, and reserve seats
        // ...

        // For demonstration purposes, let's just print a message
        JOptionPane.showMessageDialog(null, "Option 1 selected. Implementation pending.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cancelBooking() {
        // Implement the logic to cancel a booking using user's email
        // ...

        // For demonstration purposes, let's just print a message
        JOptionPane.showMessageDialog(null, "Option 2 selected. Implementation pending.", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Brs();
    }
}

class Bus {
    // Class representing a Bus with details
    // ...
}
