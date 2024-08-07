import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<Booking> bookings;
    private List<Payment> payments;

    public CarRentalSystem() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
        payments = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (vehicle.isAvailable()) {
            vehicle.rent();
            Date startDate = new Date();
            Date endDate = new Date(startDate.getTime() + (long) days * 24 * 60 * 60 * 1000);
            double totalAmount = vehicle.calculatePrice(days);
            Booking booking = new Booking("BOOK" + (bookings.size() + 1), customer, vehicle, startDate, endDate, totalAmount);
            addBooking(booking);
            Payment payment = new Payment("PAY" + (payments.size() + 1), booking, totalAmount, new Date(), "Credit Card");
            addPayment(payment);
        } else {
            System.out.println("Vehicle is not available for rent.");
        }
    }

    public void returnVehicle(Vehicle vehicle) {
        vehicle.returnVehicle();
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getVehicle() == vehicle) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            bookings.remove(bookingToRemove);
        } else {
            System.out.println("Vehicle was not rented.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=================================");
            System.out.println("|     Welcome to Car Rentals    |");
            System.out.println("=================================");
            System.out.println("| 1. Rent a Vehicle             |");
            System.out.println("| 2. Return a Vehicle           |");
            System.out.println("| 3. Exit                       |");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println("\n== Rent a Vehicle ==\n");
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();

                System.out.println("\nAvailable Vehicles:");
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.isAvailable()) {
                        System.out.println(vehicle.getRegistrationNumber() + " - " + vehicle.getBrand() + " " + vehicle.getModel());
                    }
                }

                System.out.print("\nEnter the registration number of the vehicle you want to rent: ");
                String registrationNumber = scanner.nextLine();

                System.out.print("Enter the number of days for rental: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Vehicle selectedVehicle = null;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getRegistrationNumber().equals(registrationNumber) && vehicle.isAvailable()) {
                        selectedVehicle = vehicle;
                        break;
                    }
                }

                if (selectedVehicle != null) {
                    double totalPrice = selectedVehicle.calculatePrice(rentalDays);
                    System.out.println("\n== Rental Information ==\n");
                    System.out.println("Customer ID: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Vehicle: " + selectedVehicle.getBrand() + " " + selectedVehicle.getModel());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.printf("Total Price: $%.2f%n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentVehicle(selectedVehicle, newCustomer, rentalDays);
                        System.out.println("\nVehicle rented successfully.");
                    } else {
                        System.out.println("\nRental canceled.");
                    }
                } else {
                    System.out.println("\nInvalid vehicle selection or vehicle not available for rent.");
                }
            } else if (choice == 2) {
                System.out.println("\n== Return a Vehicle ==\n");
                System.out.print("Enter the registration number of the vehicle you want to return: ");
                String registrationNumber = scanner.nextLine();

                Vehicle vehicleToReturn = null;
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getRegistrationNumber().equals(registrationNumber) && !vehicle.isAvailable()) {
                        vehicleToReturn = vehicle;
                        break;
                    }
                }

                if (vehicleToReturn != null) {
                    Customer customer = null;
                    for (Booking booking : bookings) {
                        if (booking.getVehicle() == vehicleToReturn) {
                            customer = booking.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnVehicle(vehicleToReturn);
                        System.out.println("Vehicle returned successfully by " + customer.getName());
                    } else {
                        System.out.println("Vehicle was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid registration number or vehicle is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("\nThank you for using the Car Rental System!");
    }

}