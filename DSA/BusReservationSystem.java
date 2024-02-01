import java.util.LinkedList;
import java.util.Scanner;

class Seat {
    private int seatNumber;
    private boolean isReserved;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isReserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

class Bus {
    private LinkedList<Seat> seats;

    public Bus(int totalSeats) {
        seats = new LinkedList<>();
        for (int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public void showAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (Seat seat : seats) {
            if (!seat.isReserved()) {
                System.out.println("Seat " + seat.getSeatNumber());
            }
        }
    }

    public void reserveSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                if (seat.isReserved()) {
                    System.out.println("Seat " + seatNumber + " is already reserved. Choose another seat.");
                } else {
                    seat.reserve();
                    System.out.println("Seat " + seatNumber + " reserved successfully.");
                }
                return;
            }
        }
        System.out.println("Invalid seat number. Please enter a valid seat number.");
    }

    public void cancelReservation(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                if (!seat.isReserved()) {
                    System.out.println("Seat " + seatNumber + " is not reserved. Nothing to cancel.");
                } else {
                    seat.cancelReservation();
                    System.out.println("Reservation for seat " + seatNumber + " canceled successfully.");
                }
                return;
            }
        }
        System.out.println("Invalid seat number. Please enter a valid seat number.");
    }
}

public class BusReservationSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of seats on the bus: ");
        int totalSeats = scanner.nextInt();
        Bus bus = new Bus(totalSeats);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bus.showAvailableSeats();
                    break;
                case 2:
                    System.out.print("Enter the seat number you want to reserve: ");
                    int reserveSeatNumber = scanner.nextInt();
                    bus.reserveSeat(reserveSeatNumber);
                    break;
                case 3:
                    System.out.print("Enter the seat number you want to cancel the reservation for: ");
                    int cancelSeatNumber = scanner.nextInt();
                    bus.cancelReservation(cancelSeatNumber);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n***** Bus Reservation System *****");
        System.out.println("1. Show Available Seats");
        System.out.println("2. Reserve a Seat");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
