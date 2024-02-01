import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class brs1 extends JFrame {
    private Map<String, Bus> buses = new HashMap<>();

    public brs1() {
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
        buses.put("Bus1", new Bus("Bus1", "Route A", "9:00 AM", 30));
        buses.put("Bus2", new Bus("Bus2", "Route B", "10:30 AM", 40));
        buses.put("Bus3", new Bus("Bus3", "Route C", "1:00 PM", 20));
    }

    private void showAvailableBuses() {
        JOptionPane.showInputDialog("Enter From Address:");
        JOptionPane.showInputDialog("Enter To Address:");

        StringBuilder availableBuses = new StringBuilder("Available Buses:\n");

        for (Bus bus : buses.values()) {
            availableBuses.append(bus.getDetails()).append("\n");
        }

        String selectedBus = JOptionPane.showInputDialog(null, availableBuses.toString(), "Select a Bus", JOptionPane.INFORMATION_MESSAGE);

        if (selectedBus != null && buses.containsKey(selectedBus)) {
            Bus selectedBusObj = buses.get(selectedBus);
            reserveSeat(selectedBusObj);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reserveSeat(Bus bus) {
        String[] seats = new String[bus.getAvailableSeats()];
        for (int i = 0; i < bus.getAvailableSeats(); i++) {
            seats[i] = Integer.toString(i + 1);
        }

        String selectedSeat = (String) JOptionPane.showInputDialog(null, "Select a Seat:", "Seat Selection",
                JOptionPane.QUESTION_MESSAGE, null, seats, seats[0]);

        if (selectedSeat != null) {
            String email = JOptionPane.showInputDialog("Enter your email:");

            Reservation reservation = new Reservation(bus.getName(), bus.getRoute(), bus.getTime(), Integer.parseInt(selectedSeat), email);
            bus.reserveSeat(Integer.parseInt(selectedSeat));
            JOptionPane.showMessageDialog(null, "Seat reserved successfully!\n" + reservation.toString(), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cancelBooking() {
        String email = JOptionPane.showInputDialog("Enter your email:");

        for (Bus bus : buses.values()) {
            Reservation reservation = bus.getReservation(email);
            if (reservation != null) {
                bus.cancelReservation(reservation.getSeatNumber());
                JOptionPane.showMessageDialog(null, "Booking canceled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No booking found for the provided email.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new brs1();
    }
}

class Bus {
    private String name;
    private String route;
    private String time;
    private int[] seats;
    private Map<String, Reservation> reservations;

    public Bus(String name, String route, String time, int totalSeats) {
        this.name = name;
        this.route = route;
        this.time = time;
        this.seats = new int[totalSeats];
        this.reservations = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public String getTime() {
        return time;
    }

    public int getAvailableSeats() {
        int count = 0;
        for (int seat : seats) {
            if (seat == 0) {
                count++;
            }
        }
        return count;
    }

    public String getDetails() {
        return "Bus: " + name + ", Route: " + route + ", Time: " + time + ", Available Seats: " + getAvailableSeats();
    }

    public void reserveSeat(int seatNumber) {
        seats[seatNumber - 1] = 1;
        Reservation reservation = new Reservation(name, route, time, seatNumber, null);
        reservations.put(reservation.getEmail(), reservation);
    }

    public Reservation getReservation(String email) {
        return reservations.get(email);
    }

    public void cancelReservation(int seatNumber) {
        seats[seatNumber - 1] = 0;
    }
}

class Reservation {
    private String busName;
    private String route;
    private String time;
    private int seatNumber;
    private String email;

    public Reservation(String busName, String route, String time, int seatNumber, String email) {
        this.busName = busName;
        this.route = route;
        this.time = time;
        this.seatNumber = seatNumber;
        this.email = email;
    }

    public String getBusName() {
        return busName;
    }

    public String getRoute() {
        return route;
    }

    public String getTime() {
        return time;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Reservation Details:\n" +
                "Bus: " + busName + "\n" +
                "Route: " + route + "\n" +
                "Time: " + time + "\n" +
                "Seat Number: " + seatNumber + "\n" +
                "Email: " + email;
    }
}

