package Group_3_Programming.src.models;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
    private static AtomicInteger bookingCounter = new AtomicInteger(1000);

    private int bookingId;
    private int customerId;
    private int trainNumber;
    private List<Integer> seatNumbers;
    private LocalDate bookingDate;
    private double fare;
    private String bookingStatus;

    // Constructor
    public Booking(int customerId, int trainNumber, List<Integer> seatNumbers, LocalDate bookingDate, double fare) {
        this.bookingId = bookingCounter.getAndIncrement();
        this.customerId = customerId;
        this.trainNumber = trainNumber;
        this.seatNumbers = seatNumbers;
        this.bookingDate = bookingDate;
        this.fare = fare;
        this.bookingStatus = "Confirmed";
    }

    // Getters and Setters
    public int getBookingId() { return bookingId; }
    public int getCustomerId() { return customerId; }
    public int getTrainNumber() { return trainNumber; }
    public List<Integer> getSeatNumbers() { return seatNumbers; }
    public LocalDate getBookingDate() { return bookingDate; }
    public double getFare() { return fare; }
    public String getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(String bookingStatus) { this.bookingStatus = bookingStatus; }
}

