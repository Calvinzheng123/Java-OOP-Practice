package model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> spots;

    public ParkingLot(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
    }
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied() && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
        return null;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle);
        if (spot != null) {
            return spot.parkVehicle(vehicle);
        }
        return false;
    }
    public boolean removeVehicle(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getParkedVehicle().getLicensePlate().equals(licensePlate)) {
                spot.removeVehicle();
                return true;
            }
        }
        return false;
    }
    public void displayAvailableSpots() {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                System.out.println("Spot " + spot.getSpotId() + " - " + spot.getSpotType());
            }
        }
    }

    public void displayOccupiedSpots() {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                System.out.println(
                    "Spot " + spot.getSpotId() +
                    " - " + spot.getParkedVehicle().getLicensePlate() +
                    " (" + spot.getParkedVehicle().getType() + ")"
                );
            }
        }
    }

    public String getName() {
        return name;
    }
}
