package model;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private int spotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fee;

    public Ticket(int ticketId, Vehicle vehicle, int spotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket(double fee) {
        this.exitTime = LocalDateTime.now();
        this.fee = fee;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getFee() {
        return fee;
    }
}