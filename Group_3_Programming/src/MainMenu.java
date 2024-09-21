package Group_3_Programming.src;
import java.util.Scanner;

import Group_3_Programming.src.models.Customer;
import Group_3_Programming.src.services.AdminManagementSystem;
import Group_3_Programming.src.services.BookingSystem;
import Group_3_Programming.src.services.RegistrationSystem;
import Group_3_Programming.src.services.TrainSearchSystem;
import Group_3_Programming.src.services.UserManagementSystem;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static Customer loggedInCustomer = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Train Ticket Booking System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    RegistrationSystem.registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "3":
                    adminLogin();
                    break;
                case "4":
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void loginUser() {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Customer customer = RegistrationSystem.getCustomerMap().get(email);
        if (customer != null && customer.getPassword().equals(password)) {
            loggedInCustomer = customer;
            userMenu();
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Manage Profile");
            System.out.println("2. Search Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    UserManagementSystem.manageProfile(loggedInCustomer.getEmail());
                    break;
                case "2":
                    TrainSearchSystem.searchTrains();
                    break;
                case "3":
                    BookingSystem.bookTicket(loggedInCustomer);
                    break;
                case "4":
                    BookingSystem.cancelTicket(loggedInCustomer);
                    break;
                case "5":
                    loggedInCustomer = null;
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminLogin() {
        // For simplicity, hardcode admin credentials
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin123")) {
            AdminManagementSystem.adminMenu();
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }
}
