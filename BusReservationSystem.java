import java.util.Scanner;

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the 'From' address: ");
        String fromAddress = scanner.nextLine();

        System.out.print("Enter the 'To' address: ");
        String toAddress = scanner.nextLine();

        System.out.print("Enter the date:");
        String date= scanner.nextLine();

        System.out.println("---------------------------------------------------");
        System.out.println("From: " + fromAddress);
        System.out.println("To: " + toAddress);
        System.out.println("Date: "+date);
        System.out.println("The available buses on "+date+" are :");
       
       
        // You can continue with the rest of your bus reservation system logic here

        scanner.close();
    }
}

