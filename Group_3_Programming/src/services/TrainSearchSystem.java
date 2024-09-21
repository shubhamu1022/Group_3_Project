package Group_3_Programming.src.services;
import java.util.*;

import Group_3_Programming.src.models.Train;

public class TrainSearchSystem {
    private static Map<Integer, Train> trainMap = AdminManagementSystem.getTrainMap();
    private static Scanner scanner = new Scanner(System.in);

    public static void searchTrains() {
        System.out.print("Enter Origin Station: ");
        String origin = scanner.nextLine();

        System.out.print("Enter Destination Station: ");
        String destination = scanner.nextLine();

        List<Train> matchingTrains = new ArrayList<>();

        for (Train train : trainMap.values()) {
            if (train.getOriginStation().equalsIgnoreCase(origin) &&
                train.getDestinationStation().equalsIgnoreCase(destination)) {
                matchingTrains.add(train);
            }
        }

        if (matchingTrains.isEmpty()) {
            System.out.println("No trains found for the given route.");
            return;
        }

        // Sort by train number
        matchingTrains.sort(Comparator.comparingInt(Train::getTrainNumber));

        System.out.println("\n--- Available Trains ---");
        for (Train train : matchingTrains) {
            System.out.println("Train Number: " + train.getTrainNumber() + ", Train Name: " + train.getTrainName() +
                               ", Departure: " + train.getDepartureTime() + ", Arrival: " + train.getArrivalTime());
        }

        System.out.print("\nEnter Train Number to view details or '0' to go back: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());
        if (trainNumber == 0) return;

        Train selectedTrain = trainMap.get(trainNumber);
        if (selectedTrain != null) {
            displayTrainDetails(selectedTrain);
        } else {
            System.out.println("Invalid Train Number.");
        }
    }

    private static void displayTrainDetails(Train train) {
        System.out.println("\n--- Train Details ---");
        System.out.println("Train Number: " + train.getTrainNumber());
        System.out.println("Train Name: " + train.getTrainName());
        System.out.println("Origin Station: " + train.getOriginStation());
        System.out.println("Destination Station: " + train.getDestinationStation());
        System.out.println("Departure Time: " + train.getDepartureTime());
        System.out.println("Arrival Time: " + train.getArrivalTime());
        System.out.println("Number of Seats: " + train.getNumberOfSeats());
    }
}
