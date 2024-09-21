package Group_3_Programming.src.services;
import java.util.*;
import java.util.regex.Pattern;

import Group_3_Programming.src.models.Customer;

public class UserManagementSystem {
    private static Map<String, Customer> customerMap = RegistrationSystem.getCustomerMap();
    private static Scanner scanner = new Scanner(System.in);

    public static void manageProfile(String email) {
        Customer customer = customerMap.get(email);
        if (customer == null) {
            System.out.println("User not found.");
            return;
        }

        while (true) {
            System.out.println("\n--- Profile Management ---");
            System.out.println("1. Edit User Name");
            System.out.println("2. Edit Address");
            System.out.println("3. Edit Contact Number");
            System.out.println("4. Change Password");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    editUserName(customer);
                    break;
                case "2":
                    editAddress(customer);
                    break;
                case "3":
                    editContactNumber(customer);
                    break;
                case "4":
                    changePassword(customer);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void editUserName(Customer customer) {
        System.out.print("Enter new User Name (max 50 characters): ");
        String newUserName = scanner.nextLine();
        while (newUserName.length() > 50 || newUserName.isEmpty()) {
            System.out.print("Invalid input. Please enter User Name (max 50 characters): ");
            newUserName = scanner.nextLine();
        }
        customer.setUserName(newUserName);
        System.out.println("Your Details updated successfully.");
    }

    private static void editAddress(Customer customer) {
        System.out.print("Enter new Address (max 100 characters): ");
        String newAddress = scanner.nextLine();
        while (newAddress.length() > 100 || newAddress.isEmpty()) {
            System.out.print("Invalid input. Please enter Address (max 100 characters): ");
            newAddress = scanner.nextLine();
        }
        customer.setAddress(newAddress);
        System.out.println("Your Details updated successfully.");
    }

    private static void editContactNumber(Customer customer) {
        System.out.print("Enter new Contact Number (10 digits): ");
        String newContactNumber = scanner.nextLine();
        while (!isValidContactNumber(newContactNumber)) {
            System.out.print("Invalid Contact Number. Enter Contact Number (10 digits): ");
            newContactNumber = scanner.nextLine();
        }
        customer.setContactNumber(newContactNumber);
        System.out.println("Your Details updated successfully.");
    }

    private static void changePassword(Customer customer) {
        System.out.print("Enter Current Password: ");
        String currentPassword = scanner.nextLine();
        if (!currentPassword.equals(customer.getPassword())) {
            System.out.println("Incorrect current password.");
            return;
        }

        System.out.print("Enter New Password (6-12 characters): ");
        String newPassword = scanner.nextLine();
        while (newPassword.length() < 6 || newPassword.length() > 12) {
            System.out.print("Invalid Password length. Enter Password (6-12 characters): ");
            newPassword = scanner.nextLine();
        }
        customer.setPassword(newPassword);
        System.out.println("Your Details updated successfully.");
    }

    // Contact number validation method
    private static boolean isValidContactNumber(String contactNumber) {
        // Check if it's exactly 10 digits
        return contactNumber.matches("\\d{10}");
    }
}
