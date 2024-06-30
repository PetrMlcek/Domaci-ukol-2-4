package com.engeto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Booking {
    private Room room;
    private List<Guest> guests;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean typeOfVacation;
    private BigDecimal price;

    public Booking(Room room, List<Guest> guests, LocalDate startDate,
                   LocalDate endDate, boolean typeOfVacation, BigDecimal price) {
        this.room = room;
        this.guests = guests;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfVacation = typeOfVacation;
        this.price = room.getPricePerNight();
    }

    public Room getRoom() {
        return room;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean getTypeOfVacation() {
        return typeOfVacation;
    }

    public int getNumberOfGuests() {
        return guests.size();
    }

    @Override
    public String toString() {
        StringBuilder guestNames = new StringBuilder();
        for (Guest guest : guests) {
            guestNames.append(guest.toString()).append(", ");
        }
        return "Rezervace pro: " + guestNames.toString()  + "pokoj číslo " + room.getNumber() +
                ", od " + startDate + ", do " + endDate +
                ", (" + (typeOfVacation ? "rekreační pobyt" : "pracovní pobyt")
                + "), za " + getPrice() + " Kč" ;
    }
    public int getBookingLength() {
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }
    public BigDecimal getPrice(){
        return room.getPricePerNight().multiply(BigDecimal.valueOf(getBookingLength()));
    }
}
