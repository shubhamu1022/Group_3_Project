package Group_3_Programming.src.models;
import java.util.Random;

public class Customer {
    private String userName;       // Max 50 characters
    private String email;          // Unique
    private String password;       // Min 6, Max 12 characters
    private String address;        // Max 100 characters
    private String contactNumber;  // Exact 10 characters
    private int userID;            // System-generated random 5-digit number

    // Constructor
    public Customer(String userName, String email, String password, String address, String contactNumber) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.contactNumber = contactNumber;
        this.userID = generateUserID();
    }

    // Getters and Setters
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public int getUserID() { return userID; }

    // Method to generate a random 5-digit user ID
    private int generateUserID() {
        Random rand = new Random();
        return 10000 + rand.nextInt(90000); // Generates a number between 10000 and 99999
    }
}
