package Group_3_Programming.src.services;
import java.util.*;
import java.util.regex.Pattern;

import Group_3_Programming.src.models.Customer;

public class RegistrationSystem {
    private static Map<String, Customer> customerMap = new HashMap<>();

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- User Registration ---");

        // User Name Input
        System.out.print("Enter User Name (max 50 characters): ");
        String userName = scanner.nextLine();
        while (userName.length() > 50 || userName.isEmpty()) {
            System.out.print("Invalid input. Please enter User Name (max 50 characters): ");
            userName = scanner.nextLine();
        }

        // Email Input
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        while (!isValidEmail(email) || customerMap.containsKey(email)) {
            if (customerMap.containsKey(email)) {
                System.out.print("Email already registered. Enter a different Email: ");
            } else {
                System.out.print("Invalid Email format. Enter a valid Email: ");
            }
            email = scanner.nextLine();
        }

        // Password Input
        System.out.print("Enter Password (6-12 characters): ");
        String password = scanner.nextLine();
        while (password.length() < 6 || password.length() > 12) {
            System.out.print("Invalid Password length. Enter Password (6-12 characters): ");
            password = scanner.nextLine();
        }

        // Address Input
        System.out.print("Enter Address (max 100 characters): ");
        String address = scanner.nextLine();
        while (address.length() > 100 || address.isEmpty()) {
            System.out.print("Invalid input. Please enter Address (max 100 characters): ");
            address = scanner.nextLine();
        }

        // Contact Number Input
        System.out.print("Enter Contact Number (10 digits): ");
        String contactNumber = scanner.nextLine();
        while (!isValidContactNumber(contactNumber)) {
            System.out.print("Invalid Contact Number. Enter Contact Number (10 digits): ");
            contactNumber = scanner.nextLine();
        }

        // Creating new customer and adding to the map
        Customer newCustomer = new Customer(userName, email, password, address, contactNumber);
        customerMap.put(email, newCustomer);

        // Acknowledgement
        System.out.println("\nRegistration Successful!");
        System.out.println("Your User ID is: " + newCustomer.getUserID());
    }

    // Email validation method
    private static boolean isValidEmail(String email) {
        // Simple regex for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }

    // Contact number validation method
    private static boolean isValidContactNumber(String contactNumber) {
        // Check if it's exactly 10 digits
        return contactNumber.matches("\\d{10}");
    }

    // Getter for customerMap to be used in other classes
    public static Map<String, Customer> getCustomerMap() {
        return customerMap;
    }
}
