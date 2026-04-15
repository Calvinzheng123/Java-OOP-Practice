package model;

import java.time.LocalDateTime;

public class ticket {
    private double fee;
    private Vehicle vehicle;
    private int spotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private int ticketId;

    public Ticket(int ticketId, Vehicle vehicle, int spotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }
    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.fee = calculateFee();
    }
    public int getTicketId() {
        return ticketId;
    }
    public double getFee() {
        return fee;
    }
    public int getSpotId() {
        return spotId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public LocalDateTime getExitTime() {
        return exitTime;
    }
}
