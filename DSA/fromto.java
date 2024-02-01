import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fromto extends JFrame implements ActionListener {
    private JLabel fromLabel, toLabel;
    private JTextField fromField, toField;
    private JButton searchButton;
    private JTextArea resultArea;

    public fromto() {
        super("Bus Reservation System");

        // Initialize UI components
        fromLabel = new JLabel("From:");
        toLabel = new JLabel("To:");
        fromField = new JTextField(10);
        toField = new JTextField(10);
        searchButton = new JButton("Search Buses");
        resultArea = new JTextArea(10, 30);

        // Set layout and add components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(fromLabel);
        panel.add(fromField);
        panel.add(toLabel);
        panel.add(toField);
        panel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Set action listener
        searchButton.addActionListener(this);

        // Set frame properties
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String from = fromField.getText();
            String to = toField.getText();

            // Perform bus search logic here (replace this with your actual logic)
            String busesInfo = searchBuses(from, to);

            // Display the result in the JTextArea
            resultArea.setText(busesInfo);
        }
    }

    // Replace this method with your actual bus search logic
    private String searchBuses(String from, String to) {
        // Dummy data for demonstration purposes
        return "Buses from " + from + " to " + to + ":\n" +
                "1. Bus A\n" +
                "2. Bus B\n" +
                "3. Bus C";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new fromto());
    }
}

