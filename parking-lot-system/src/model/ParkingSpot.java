package model;

public class ParkingSpot {
    private int spotId;
    private SpotType spotType;
    private boolean occupied;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.occupied = false;
        this.parkedVehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.MOTORCYCLE) {
            return true;
        }
        if (vehicle.getType() == VehicleType.CAR) {
            return spotType == SpotType.COMPACT || spotType == SpotType.LARGE;
        }
        if (vehicle.getType() == VehicleType.TRUCK) {
            return spotType == SpotType.LARGE;
        }
        return false;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        if (!occupied && canFitVehicle(vehicle)) {
            parkedVehicle = vehicle;
            occupied = true;
            return true;
        }
        return false;
    }
    public void removeVehicle() {
        parkedVehicle = null;
        occupied = false;
    }
    public int getSpotId() {
         return spotId;
    }
    public SpotType getSpotType() {
        return spotType;
    }
    public boolean isOccupied() {
        return occupied;
    }
    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
