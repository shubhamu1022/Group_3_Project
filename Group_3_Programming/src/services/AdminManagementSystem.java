package Group_3_Programming.src.services;
import java.time.LocalTime;
import java.util.*;

import Group_3_Programming.src.models.Train;

public class AdminManagementSystem {
    private static Map<Integer, Train> trainMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Train Management ---");
            System.out.println("1. Add New Train");
            System.out.println("2. Update Existing Train");
            System.out.println("3. View All Trains");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewTrain();
                    break;
                case "2":
                    updateTrain();
                    break;
                case "3":
                    viewAllTrains();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addNewTrain() {
        System.out.print("Enter Train Number: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());
        if (trainMap.containsKey(trainNumber)) {
            System.out.println("Train Number already exists.");
            return;
        }

        System.out.print("Enter Train Name: ");
        String trainName = scanner.nextLine();

        System.out.print("Enter Origin Station: ");
        String originStation = scanner.nextLine();

        System.out.print("Enter Destination Station: ");
        String destinationStation = scanner.nextLine();

        System.out.print("Enter Departure Time (HH:mm): ");
        LocalTime departureTime = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter Arrival Time (HH:mm): ");
        LocalTime arrivalTime = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter Number of Seats: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());

        Train train = new Train(trainNumber, trainName, originStation, destinationStation,
                                departureTime, arrivalTime, numberOfSeats);

        trainMap.put(trainNumber, train);
        System.out.println("Train added successfully.");
    }

    private static void updateTrain() {
        System.out.print("Enter Train Number to Update: ");
        int trainNumber = Integer.parseInt(scanner.nextLine());
        Train train = trainMap.get(trainNumber);
        if (train == null) {
            System.out.println("Train not found.");
            return;
        }

        System.out.print("Enter New Train Name (leave blank to keep current): ");
        String trainName = scanner.nextLine();
        if (!trainName.isEmpty()) {
            train.setTrainName(trainName);
        }

        System.out.print("Enter New Origin Station (leave blank to keep current): ");
        String originStation = scanner.nextLine();
        if (!originStation.isEmpty()) {
            train.setOriginStation(originStation);
        }

        System.out.print("Enter New Destination Station (leave blank to keep current): ");
        String destinationStation = scanner.nextLine();
        if (!destinationStation.isEmpty()) {
            train.setDestinationStation(destinationStation);
        }

        System.out.print("Enter New Departure Time (HH:mm) (leave blank to keep current): ");
        String depTimeInput = scanner.nextLine();
        if (!depTimeInput.isEmpty()) {
            train.setDepartureTime(LocalTime.parse(depTimeInput));
        }

        System.out.print("Enter New Arrival Time (HH:mm) (leave blank to keep current): ");
        String arrTimeInput = scanner.nextLine();
        if (!arrTimeInput.isEmpty()) {
            train.setArrivalTime(LocalTime.parse(arrTimeInput));
        }

        System.out.print("Enter New Number of Seats (leave blank to keep current): ");
        String seatsInput = scanner.nextLine();
        if (!seatsInput.isEmpty()) {
            train.setNumberOfSeats(Integer.parseInt(seatsInput));
        }

        System.out.println("Train updated successfully.");
    }

    private static void viewAllTrains() {
        if (trainMap.isEmpty()) {
            System.out.println("No trains available.");
            return;
        }

        System.out.println("\n--- List of Trains ---");
        for (Train train : trainMap.values()) {
            System.out.println("Train Number: " + train.getTrainNumber() + ", Train Name: " + train.getTrainName());
        }
    }

    // Getter for trainMap to be used in other classes
    public static Map<Integer, Train> getTrainMap() {
        return trainMap;
    }
}
