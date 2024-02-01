import java.util.ArrayList;
import java.util.Scanner;

class Bus {
    String from;
    String to;
    String time;
    ArrayList<Integer> availableSeats;

    public Bus(String from, String to, String time, int totalSeats) {
        this.from = from;
        this.to = to;
        this.time = time;
        this.availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }
}

class Reservation {
    String email;
    String from;
    String to;
    String time;
    int seatNumber;

    public Reservation(String email, String from, String to, String time, int seatNumber) {
        this.email = email;
        this.from = from;
        this.to = to;
        this.time = time;
        this.seatNumber = seatNumber;
    }
}

public class buses {
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBuses();

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    bookSeat();
                    break;
                case 2:
                    cancelBooking();
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    static void initializeBuses() {
        buses.add(new Bus("City A", "City B", "10:00 AM", 5));
        buses.add(new Bus("City B", "City C", "02:00 PM", 10));
        buses.add(new Bus("City C", "City D", "06:00 PM", 8));
    }

    static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Check available buses and book seats");
        System.out.println("2. Cancel booking");
        System.out.println("3. Exit");
    }

    static void bookSeat() {
        System.out.print("Enter 'From' city: ");
        String from = scanner.nextLine();
        System.out.print("Enter 'To' city: ");
        String to = scanner.nextLine();

        System.out.println("Available Buses:");
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.from.equalsIgnoreCase(from) && bus.to.equalsIgnoreCase(to)) {
                System.out.println(i + 1 + ". From " + bus.from + " to " + bus.to + " at " + bus.time);
            }
        }

        System.out.print("Choose a bus (enter number): ");
        int busChoice = scanner.nextInt();
        Bus selectedBus = buses.get(busChoice - 1);

        System.out.println("Available Seats for Bus " + busChoice + ": " + selectedBus.availableSeats);
        System.out.print("Enter your email: ");
        String email = scanner.next();
        System.out.print("Enter the seat number you want to reserve: ");
        int seatNumber = scanner.nextInt();

        if (selectedBus.availableSeats.contains(seatNumber)) {
            selectedBus.availableSeats.remove(Integer.valueOf(seatNumber));
            reservations.add(new Reservation(email, from, to, selectedBus.time, seatNumber));
            System.out.println("Seat reserved successfully!");
        } else {
            System.out.println("Invalid seat number. Please try again.");
        }
    }

    static void cancelBooking() {
        System.out.print("Enter your email to cancel the booking: ");
        String email = scanner.next();

        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.email.equals(email)) {
                Bus bus = getBusByDetails(reservation.from, reservation.to, reservation.time);
                bus.availableSeats.add(reservation.seatNumber);
                reservations.remove(reservation);
                found = true;
                System.out.println("Booking canceled successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found for the provided email.");
        }
    }

    static Bus getBusByDetails(String from, String to, String time) {
        for (Bus bus : buses) {
            if (bus.from.equalsIgnoreCase(from) && bus.to.equalsIgnoreCase(to) && bus.time.equals(time)) {
                return bus;
            }
        }
        return null;
    }
}
