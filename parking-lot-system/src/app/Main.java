package app;
import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot("Campus Parking Lot");

        // Add parking spots
        parkingLot.addSpot(new ParkingSpot(1, SpotType.MOTORCYCLE));
        parkingLot.addSpot(new ParkingSpot(2, SpotType.COMPACT));
        parkingLot.addSpot(new ParkingSpot(3, SpotType.COMPACT));
        parkingLot.addSpot(new ParkingSpot(4, SpotType.LARGE));
        parkingLot.addSpot(new ParkingSpot(5, SpotType.LARGE));

        boolean running = true;

        while (running) {
            System.out.println("\n=== " + parkingLot.getName() + " ===");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. Show Available Spots");
            System.out.println("4. Show Occupied Spots");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle type (car, truck, motorcycle): ");
                    String type = scanner.nextLine().trim().toLowerCase();

                    System.out.print("Enter license plate: ");
                    String licensePlate = scanner.nextLine().trim();

                    Vehicle vehicle = null;

                    if (type.equals("car")) {
                        vehicle = new Car(licensePlate);
                    } else if (type.equals("truck")) {
                        vehicle = new Truck(licensePlate);
                    } else if (type.equals("motorcycle")) {
                        vehicle = new Motorcycle(licensePlate);
                    } else {
                        System.out.println("Invalid vehicle type.");
                        break;
                    }

                    ParkingSpot availableSpot = parkingLot.findAvailableSpot(vehicle);

                    if (availableSpot != null) {
                        availableSpot.parkVehicle(vehicle);
                        System.out.println("Vehicle parked successfully in spot " + availableSpot.getSpotId());
                    } else {
                        System.out.println("No available spot for this vehicle.");
                    }
                    break;

                case 2:
                    System.out.print("Enter license plate to remove: ");
                    String plateToRemove = scanner.nextLine().trim();

                    boolean removed = parkingLot.removeVehicle(plateToRemove);

                    if (removed) {
                        System.out.println("Vehicle removed successfully.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;

                case 3:
                    System.out.println("\nAvailable Spots:");
                    parkingLot.displayAvailableSpots();
                    break;

                case 4:
                    System.out.println("\nOccupied Spots:");
                    parkingLot.displayOccupiedSpots();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}