package Group_3_Programming.src.services;
import java.time.LocalDate;
import java.util.*;

import Group_3_Programming.src.models.Booking;
import Group_3_Programming.src.models.Customer;
import Group_3_Programming.src.models.Train;

public class BookingSystem {
    private static Map<Integer, Booking> bookingMap = new HashMap<>();
    private static Map<Integer, Train> trainMap = AdminManagementSystem.getTrainMap();
    private static Scanner scanner = new Scanner(System.in);

    public static void bookTicket(Customer customer) {
        System.out.print("Enter Train Number to Book: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());

        Train train = trainMap.get(trainNumber);
        if (train == null) {
            System.out.println("Train does not exist.");
            return;
        }

        System.out.print("Enter Booking Date (YYYY-MM-DD): ");
        LocalDate bookingDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter Number of Seats to Book: ");
        int numSeats = Integer.parseInt(scanner.nextLine());

        List<Integer> seatNumbers = new ArrayList<>();
        for (int i = 1; i <= numSeats; i++) {
            System.out.print("Enter Seat Number " + i + ": ");
            int seatNumber = Integer.parseInt(scanner.nextLine());
            seatNumbers.add(seatNumber);
        }

        double fare = calculateFare(numSeats);

        Booking booking = new Booking(customer.getUserID(), trainNumber, seatNumbers, bookingDate, fare);
        bookingMap.put(booking.getBookingId(), booking);

        System.out.println("\nBooking Confirmed!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Train Number: " + booking.getTrainNumber());
        System.out.println("Seat Numbers: " + booking.getSeatNumbers());
        System.out.println("Booking Date: " + booking.getBookingDate());
        System.out.println("Fare: $" + booking.getFare());
    }

    private static double calculateFare(int numSeats) {
        // For simplicity, assume each seat costs $50
        return numSeats * 50.0;
    }

    // Getter for bookingMap to be used in cancellation
    public static Map<Integer, Booking> getBookingMap() {
        return bookingMap;
    }

    // Existing code above...

    public static void cancelTicket(Customer customer) {
        System.out.print("Enter Booking ID to Cancel: ");
        int bookingId = Integer.parseInt(scanner.nextLine());

        Booking booking = bookingMap.get(bookingId);
        if (booking == null || booking.getCustomerId() != customer.getUserID()) {
            System.out.println("Booking not found.");
            return;
        }

        if (booking.getBookingDate().isBefore(LocalDate.now())) {
            System.out.println("Cannot cancel booking after departure date.");
            return;
        }

        booking.setBookingStatus("Cancelled");
        System.out.println("Booking cancelled successfully.");
    }

}
