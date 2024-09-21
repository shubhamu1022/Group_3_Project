package Group_3_Programming.src.models;
import java.time.LocalTime;

public class Train {
    private int trainNumber;
    private String trainName;
    private String originStation;
    private String destinationStation;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int numberOfSeats;

    // Constructor
    public Train(int trainNumber, String trainName, String originStation, String destinationStation,
                 LocalTime departureTime, LocalTime arrivalTime, int numberOfSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.originStation = originStation;
        this.destinationStation = destinationStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters and Setters
    public int getTrainNumber() { return trainNumber; }
    public void setTrainName(String trainName) { this.trainName = trainName; }
    public String getTrainName() { return trainName; }
    public void setOriginStation(String originStation) { this.originStation = originStation; }
    public String getOriginStation() { return originStation; }
    public void setDestinationStation(String destinationStation) { this.destinationStation = destinationStation; }
    public String getDestinationStation() { return destinationStation; }
    public void setDepartureTime(LocalTime departureTime) { this.departureTime = departureTime; }
    public LocalTime getDepartureTime() { return departureTime; }
    public void setArrivalTime(LocalTime arrivalTime) { this.arrivalTime = arrivalTime; }
    public LocalTime getArrivalTime() { return arrivalTime; }
    public void setNumberOfSeats(int numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public int getNumberOfSeats() { return numberOfSeats; }
}
