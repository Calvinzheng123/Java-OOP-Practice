package model;

public class ParkingSpot {
    private int spotId;
    private SpotType spotType;
    private boolean isAvailable;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = False;
        this.parkedVehicle = NULL;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.MOTORCYCLE) {
            return true;
        }
        if (vehicle.getType() == VehicleType.CAR) {
            return spotType == SpotType.COMPACT || spotType == SpotType.LARGE;
        }
        if (vehcile.getType() == VehcileType.TRUCK) {
            return spotType == SpotType.LARGE;
        }
        return false;
    }
    public boolean parkVehicle(Vehicle vehicle) {
        if (!isOccupied && canFitVehicle(vehicle)) {
            this.parkedVehcile = vehcile;
            this.Occupied = true;
            return true;
        }
        return false;
    }
    public void removeVehicle() {
        this.parkedVehicle = NULL;
        this.isOccupied = false;
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
