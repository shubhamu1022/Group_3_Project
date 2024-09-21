# Train Ticket Booking System

This Java-based console application allows users to register, manage profiles, search for trains, and book or cancel tickets. It also enables administrators to manage train schedules and availability.

## Project Structure

```
Group_3_Programming/
├── bin/                   # Compiled output files
├── src/                   # Source files
│   ├── models/            # Data model classes
│   ├── services/          # Service classes
│   └── MainMenu.java      # Application entry point
└── README.md              # Project documentation
```

## Features

- **User Registration and Profile Management**: Users can create accounts and update their profiles.
- **Train Management**: Admins can add, modify, and remove train details.
- **Train Search and Booking**: Users can search for available trains and book tickets.
- **Ticket Cancellation**: Users can cancel their bookings.

## Setup and Execution

### Prerequisites

Ensure you have Java JDK 8 or above installed on your system.

### Compile the Project

Navigate to your project directory and compile the Java files using:

```bash
javac -d bin src/models/*.java src/services/*.java src/MainMenu.java
```

### Run the Application

Run the `MainMenu` class from the `bin` directory:

```bash
java -cp bin MainMenu
```

## Usage

Follow the on-screen prompts to navigate through the application:

1. **Register**: Sign up as a new user.
2. **Login**: Access user-specific functionalities.
3. **Admin Login**: Manage train details.
4. **Exit**: Close the application.

## Contribution

Contributions are welcome! Please fork the repository and submit a pull request with your enhancements.

## License

This project is open-sourced under the MIT license.

## Contact Information

For any queries or contributions, please reach out to `shubhamupadhyay8024@gmail.com`.

