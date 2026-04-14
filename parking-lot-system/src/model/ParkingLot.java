import java.util.ArrayList;
import java.util.List;

package model;

public class ParkingLot {
    private String name;
    private List<ParkingSpot> spots;

    public ParkingLot(String name) {
        this.name = name;
        this.spots = new ArrayList<>();
    }
    public void addParkingSpot(ParkingSpot spot) {
        spots.add(spot);
    }
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (parkingSpot spot : spots) {
            if spot.isAvailable() && spot.canFitVehicle(vehicle)) {
                return spot;
            }
        }
    }
}
